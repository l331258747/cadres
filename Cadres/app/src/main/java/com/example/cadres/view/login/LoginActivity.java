package com.example.cadres.view.login;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.login.LoginBean;
import com.example.cadres.bean.login.MySelfInfo;
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
        goHome();
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
}