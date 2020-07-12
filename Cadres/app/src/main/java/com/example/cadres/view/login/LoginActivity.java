package com.example.cadres.view.login;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cadres.MyApplication;
import com.example.cadres.R;
import com.example.cadres.base.ActivityCollect;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.apk.ApkBean;
import com.example.cadres.bean.login.LoginBean;
import com.example.cadres.bean.login.MySelfInfo;
import com.example.cadres.constant.Constant;
import com.example.cadres.dialog.DialogUtil;
import com.example.cadres.mvp.LoginContract;
import com.example.cadres.mvp.LoginPresenter;
import com.example.cadres.utils.AppUtils;
import com.example.cadres.utils.FileUtil;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.SPUtils;
import com.example.cadres.utils.ToastUtil;
import com.example.cadres.view.home.HomeActivity;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.io.File;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zlc.season.rxdownload.RxDownload;
import zlc.season.rxdownload.entity.DownloadStatus;

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginContract.View {

    TextView tv_btn;
    EditText et_account, et_password;
    LoginPresenter mPresenter;

    String username, password;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        hideTitleLayout();

        tv_btn = findViewById(R.id.tv_btn);
        et_account = findViewById(R.id.et_account);
        et_password = findViewById(R.id.et_password);
        tv_btn.setOnClickListener(this);

    }

    @Override
    public void initData() {
        mPresenter = new LoginPresenter(context, this);
    }

    public void getApk() {
        mPresenter.getApk();
    }

    public void goHome() {
        if (SPUtils.getInstance().getBoolean(SPUtils.IS_LOGIN, false)) {
            startActivity(new Intent(context, HomeActivity.class));
            finish();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_btn:

                username = et_account.getText().toString();
                password = et_password.getText().toString();
                if (TextUtils.isEmpty(username)) {
                    ToastUtil.showShortToast(context, "请输入帐号");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    ToastUtil.showShortToast(context, "请输入帐号");
                    return;
                }
                mPresenter.login(username, password);
                break;
        }
    }

    @Override
    public void loginSuccess(LoginBean.LoginBean2 data) {
        MySelfInfo.getInstance().setData(data);

        startActivity(new Intent(context, HomeActivity.class));
        finish();

    }

    @Override
    public void loginFailed(String msg) {
        if (TextUtils.isEmpty(SPUtils.getInstance().getString(SPUtils.SP_SALT))) {
            ToastUtil.showShortToast(context, msg);
            return;
        }

        if (!TextUtils.equals(username, SPUtils.getInstance().getString(SPUtils.SP_LOGIN_NAME))) {
            ToastUtil.showShortToast(context, "帐号不正确");
            return;
        }
        String psd = encryptPassword(username, password, SPUtils.getInstance().getString(SPUtils.SP_SALT));
        LogUtil.e(psd);
        LogUtil.e(SPUtils.getInstance().getString(SPUtils.SP_PASSWORD));
        if (!TextUtils.equals(psd, SPUtils.getInstance().getString(SPUtils.SP_PASSWORD))) {
            ToastUtil.showShortToast(context, "密码不正确");
            return;
        }
        startActivity(new Intent(context, HomeActivity.class));
        finish();

    }

    public String encryptPassword(String username, String password, String salt) {
        return new Md5Hash(username + password + salt).toHex().toString();
    }

    //---------------start权限-----------------
    public static final int BASE_VALUE_PERMISSION = 0X0001;
    public static final int PERMISSION_REQ_ID_WRITE_EXTERNAL_STORAGE = BASE_VALUE_PERMISSION + 2;

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isFinishing()) {
                    return;
                }

                boolean checkPermissionResult = checkSelfPermissions();
                LogUtil.e("checkPermissionResult: " + checkPermissionResult);

                if ((Build.VERSION.SDK_INT < Build.VERSION_CODES.M)) {
                    // so far we do not use OnRequestPermissionsResultCallback
                }
            }
        }, 500);
    }

    /**
     * RECORD_AUDIO 录音
     * WRITE_EXTERNAL_STORAGE sd写权限
     * ACCESS_COARSE_LOCATION 定位
     */
    private boolean checkSelfPermissions() {
        return checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, PERMISSION_REQ_ID_WRITE_EXTERNAL_STORAGE);
    }

    public boolean checkSelfPermission(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager
                .PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{permission}, requestCode);
            return false;
        }
        if (permission == android.Manifest.permission.WRITE_EXTERNAL_STORAGE) {
            getApk();
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQ_ID_WRITE_EXTERNAL_STORAGE: {
                if (grantResults[0] == PackageManager.PERMISSION_DENIED) {//选择了不再提示按钮
                    showAccreditDialog();
                    return;
                }
                if (grantResults.length > 0) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        getApk();
                    } else {
                        checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                PERMISSION_REQ_ID_WRITE_EXTERNAL_STORAGE);
                    }
                }
                break;
            }
        }
    }

    //----------------end权限--------------

    //----------start 权限不再询问处理-------------

    private void showAccreditDialog() {
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setMessage("温馨提示\n" +
                        "您需要同意系统使用【储存】权限才能正常使用系统，" +
                        "由于您选择了【禁止（不再提示）】，将导致无法使用系统，" +
                        "需要到设置页面手动授权开启【存储】权限，才能继续使用。")
                .setPositiveButton("去授权", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //引导用户至设置页手动授权
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", getApplicationContext().getPackageName
                                (), null);
                        intent.setData(uri);
                        startActivityForResult(intent, REQUEST_PERMISSION_SETTING);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //引导用户手动授权，权限请求失败
                        finish();
                    }
                }).setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                //引导用户手动授权，权限请求失败
            }
        }).show();
    }

    public static final int REQUEST_PERMISSION_SETTING = 6;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_PERMISSION_SETTING) {
            checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    PERMISSION_REQ_ID_WRITE_EXTERNAL_STORAGE);
        }else if (requestCode == 10086) {
            LogUtil.e("设置了安装未知应用后的回调。。。");
            String successDownloadApkPath = FileUtil.getFOlderPath(Constant.APK_PATH) + File.separator + apkName;
            installApkO(context, successDownloadApkPath);
        }
    }
    //----------end 权限不再询问处理-------------


    //------------------start 下载

    String apkName;
    @Override
    public void getApkSuccess(ApkBean.ApkBean2 data) {
        int cVersionCode = AppUtils.getVersionCodeInt();
        int sVersionCode = data.getVersion();
        String apkUrl = data.getUrl();
//        String apkUrl = "https://www.njzou.com/najiuzou.apk";
        String content = data.getContent();
        apkName = "宁乡市干部大数据管理系统" + sVersionCode + ".apk";

        if (sVersionCode > cVersionCode) {
            //TODO 下载
            initProgress(content);
            progress.show();
            goDownload(apkUrl, sVersionCode);

        } else {
            goHome();
        }
    }

    Subscription subscription;

    private void goDownload(String url, int sVersionCode) {
        subscription = RxDownload.getInstance()
                .download(url, apkName, FileUtil.getFOlderPath(Constant.APK_PATH))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DownloadStatus>() {

                    @Override
                    public void onCompleted() {
                        //下载完成
                        progress.dismiss();
                        installApkO(context,FileUtil.getFOlderPath(Constant.APK_PATH) + File.separator + apkName);
                    }

                    @Override
                    public void onError(Throwable e) {
                        //下载出错
                        goHome();
                    }

                    @Override
                    public void onNext(final DownloadStatus status) {
                        String str = status.getPercent();
                        float num = Float.valueOf(str.substring(0, str.length() - 1));

                        LogUtil.e("s :" + num);
                        //下载状态
                        progress.setProgress((int) num);
                    }
                });
    }

    @Override
    public void getApkFailed(String msg) {
        LogUtil.e("版本下载错误：" + msg);
        goHome();
    }

    // 3.下载成功，开始安装,兼容8.0安装位置来源的权限
    private void installApkO(Context context, String downloadApkPath) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //是否有安装位置来源的权限
            boolean haveInstallPermission = getPackageManager().canRequestPackageInstalls();
            if (haveInstallPermission) {
                LogUtil.e("8.0手机已经拥有安装未知来源应用的权限，直接安装！");
                AppUtils.installApk(context, downloadApkPath);
            } else {

                DialogUtil.getInstance().getDefaultDialog(context, "安装应用需要打开安装未知来源应用权限，请去设置中开启权限", new DialogUtil.DialogCallBack() {
                    @Override
                    public void exectEvent(DialogInterface alterDialog) {
                        Uri packageUri = Uri.parse("package:"+ AppUtils.getPakgeName());
                        Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES,packageUri);
                        startActivityForResult(intent,10086);
                    }
                }).show();
            }
        } else {
            AppUtils.installApk(context, downloadApkPath);
        }
    }
    //4.开启了安装未知来源应用权限后，再次进行步骤3的安装。
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 10086) {
//            LogUtil.e("设置了安装未知应用后的回调。。。");
//            String successDownloadApkPath = FileUtil.getFOlderPath(Constant.APK_PATH) + File.separator + apkName;
//            installApkO(context, successDownloadApkPath);
//        }
//    }


    //------------------end 下载

    ProgressDialog progress;

    private void initProgress(String content) {
        progress = new ProgressDialog(context);
        progress.setTitle("下载更新");
        progress.setMessage(content);
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(false);//设置为fase等待进度更新，设置为true则左右循环滚动
        progress.setMax(100);
        progress.setCancelable(false);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}