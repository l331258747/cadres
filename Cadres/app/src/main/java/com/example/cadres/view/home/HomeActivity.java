package com.example.cadres.view.home;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.login.LoginBean;
import com.example.cadres.bean.login.MySelfInfo;
import com.example.cadres.dialog.DialogUtil;
import com.example.cadres.mvp.HomeContract;
import com.example.cadres.mvp.HomePresenter;
import com.example.cadres.utils.SPUtils;
import com.example.cadres.utils.ToastUtil;

public class HomeActivity extends BaseActivity implements HomeContract.View, View.OnClickListener {

    EditText et_search;
    View view_mcb, view_gbmc, view_yjjc, view_zcfg, view_dsj;

    HomePresenter mPresenter;

    ProgressDialog progress;

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {
        showLLRight1();
        showLLRight2();
        showTitleTv(getTitleName());

        view_mcb = findViewById(R.id.view_mcb);
        view_gbmc = findViewById(R.id.view_gbmc);
        view_yjjc = findViewById(R.id.view_yjjc);
        view_zcfg = findViewById(R.id.view_zcfg);
        view_dsj = findViewById(R.id.view_dsj);
        et_search = findViewById(R.id.et_search);

        getLLRight1().setOnClickListener(this);
        getLLRight2().setOnClickListener(this);
        view_mcb.setOnClickListener(this);
        view_gbmc.setOnClickListener(this);
        view_yjjc.setOnClickListener(this);
        view_zcfg.setOnClickListener(this);
        view_dsj.setOnClickListener(this);

        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                /*判断是否是“搜索”键*/
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String key = et_search.getText().toString().trim();
                    if (TextUtils.isEmpty(key)) {
                        ToastUtil.showShortToast(context, "请输入您想要搜索的内容");
                        return true;
                    }

                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void initData() {
        mPresenter = new HomePresenter(context, this);

        fistOne();
        initProgress();
    }

    private void initProgress() {
        progress = new ProgressDialog(context);
        progress.setTitle("文件下载");
        progress.setMessage("数据正在更新中，请勿中途退出系统！");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(false);//设置为fase等待进度更新，设置为true则左右循环滚动
        progress.setMax(100);
    }

    public String getTitleName() {
        String str = "";
        if (!TextUtils.isEmpty(MySelfInfo.getInstance().getUserName())) {
            str = MySelfInfo.getInstance().getUserName();
        }
        if (!TextUtils.isEmpty(MySelfInfo.getInstance().getLoginName())) {
            str = str + "（" + MySelfInfo.getInstance().getUserName() + "）";
        }
        if (TextUtils.isEmpty(str))
            return "欢迎";
        return "欢迎您的登录，当前用户：" + str;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.view_mcb:
                ToastUtil.showShortToast(context, "名称表");
                break;
            case R.id.view_gbmc:
                ToastUtil.showShortToast(context, "干部名册");
                break;
            case R.id.view_yjjc:
                ToastUtil.showShortToast(context, "研究决策");
                break;
            case R.id.view_zcfg:
                ToastUtil.showShortToast(context, "政策法规");
                break;
            case R.id.view_dsj:
                ToastUtil.showShortToast(context, "大数据");
                break;
            case R.id.ll_right1:
                updata();
                break;
            case R.id.ll_right2:
                DialogUtil.getInstance().getDefaultDialog(context, "您是否确认退出?", new DialogUtil.DialogCallBack() {
                    @Override
                    public void exectEvent(DialogInterface alterDialog) {
                        finish();
                    }
                }).show();
                break;
        }
    }

    private void updata() {
        progress.show();
        ToastUtil.showShortToast(context, "同步数据");
    }

    @Override
    public void findUserInfoSuccess(LoginBean.LoginBean2 data) {
        MySelfInfo.getInstance().setData(data);

        //数据库数据


        progress.dismiss();
    }

    @Override
    public void findUserInfoFailed(String msg) {
        ToastUtil.showShortToast(context, "同步数据失败，请检查网络情况");
        progress.dismiss();
    }

    //第一次
    public void fistOne() {
        if (SPUtils.getInstance().getBoolean(SPUtils.FIRST_OPENED, false)) {
            DialogUtil.getInstance().getDefaultDialog(context, "是否需要同步数据", new DialogUtil.DialogCallBack() {
                @Override
                public void exectEvent(DialogInterface alterDialog) {
                    updata();
                }
            }).show();
        }
        SPUtils.getInstance().putBoolean(SPUtils.FIRST_OPENED, true);
    }
}
