package com.example.cadres.view.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.login.LoginBean;
import com.example.cadres.bean.login.MySelfInfo;
import com.example.cadres.dialog.DialogUtil;
import com.example.cadres.mvp.LoginContract;
import com.example.cadres.mvp.LoginPresenter;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.SPUtils;
import com.example.cadres.utils.ToastUtil;
import com.example.cadres.view.home.HomeActivity;

import org.apache.shiro.crypto.hash.Md5Hash;

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginContract.View {

    TextView tv_btn;
    EditText et_account, et_password;
    LoginPresenter mPresenter;

    String username, password;
//    CommonDaoUtils<DBUserListBean> userListDaoUtils;

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

        if (SPUtils.getInstance().getBoolean(SPUtils.IS_LOGIN, false)) {
            startActivity(new Intent(context, HomeActivity.class));
            finish();
        }

//        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
//        userListDaoUtils = _Store.getUserListDaoUtils();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_btn:

                username = et_account.getText().toString();
                password = et_password.getText().toString();
                if(TextUtils.isEmpty(username)){
                    ToastUtil.showShortToast(context,"请输入帐号");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    ToastUtil.showShortToast(context,"请输入帐号");
                    return;
                }
                mPresenter.login(username,password);
                break;
//            case R.id.tv_btn:
//                if (userListDaoUtils.queryAll() != null) {
//                    userListDaoUtils.queryAll().size();
//                    LogUtil.e("数据库条数：" + userListDaoUtils.queryAll().size());
//                } else {
//                    LogUtil.e("没有数据");
//                }
//
//                userListDaoUtils.deleteAll();
//                LogUtil.e("记录删除 完成");
//
//                mPresenter.findUserList();
//                break;
//            case R.id.tv_btn2:
//                deleteAll();
//                LogUtil.e("图片删除 完成");
//
//                loadImages();
//                break;
        }
    }
//    private void deleteAll() {
//        FileUtil.delAllFile(FileUtil.getFolder(Constant.IMAGE_PATH));
//    }
//    @Override
//    public void findUserListSuccess(List<UserListBean> list) {
//        List<DBUserListBean> dbList = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) {
//            progress.setProgress((int) (20 * i / 1000));
//            LogUtil.e("数据：" + progress.getProgress());
//            UserListBean item = list.get(0);
//            dbList.add(new DBUserListBean(null, item.getUserId(), item.getDeptId(), item.getLoginName(), item.getPassword(), item.getSalt()));
//        }
//        userListDaoUtils.insertMulti(dbList);
//        LogUtil.e("dbuserlist 下载完成");
//    }
//    String informationId;
//    File dir;

//    private void loadImages() {
//        dir = FileUtil.getFolder(Constant.IMAGE_PATH);
//        String url = "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1767601834,3862647392&fm=11&gp=0.jpg";
//        //取得最后一个/的下标
//        int index = url.lastIndexOf("/");
//        //将字符串转为字符数组
//        char[] ch = url.toCharArray();
//        //根据 copyValueOf(char[] data, int offset, int count) 取得最后一个字符串
//        informationId = String.copyValueOf(ch, index + 1, ch.length - index - 1);
//
//        Glide.with(context).load(url).asBitmap().toBytes().into(new SimpleTarget<byte[]>() {
//            @Override
//            public void onResourceReady(byte[] bytes, GlideAnimation<? super byte[]> glideAnimation) {
//                try {
//                    String fileName = dir + File.separator + informationId;
//                    FileOutputStream fos = new FileOutputStream(fileName, true);
//                    fos.write(bytes);
//                    fos.flush();
//                    fos.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        LogUtil.e("图片 下载完成");
//    }
//    @Override
//    public void findUserListFailed(String msg) {
//        LogUtil.e(msg);
//    }

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

}