package com.example.cadres.mvp;

import android.content.Context;

import com.example.cadres.bean.apk.ApkBean;
import com.example.cadres.bean.login.LoginBean;
import com.example.cadres.utils.http.MethodApi;
import com.example.cadres.utils.http.OnSuccessAndFaultSub;
import com.example.cadres.utils.http.ResponseCallback;

/**
 * Created by LGQ
 * Time: 2018/8/23
 * Function:
 */

public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.View iView;
    Context context;

    public LoginPresenter(Context context, LoginContract.View view) {
        this.iView = view;
        this.context = context;
    }

    @Override
    public void login(String username, String password) {
        ResponseCallback listener = new ResponseCallback<LoginBean>() {
            @Override
            public void onSuccess(LoginBean data) {
                iView.loginSuccess(data.getZzbUser());
            }

            @Override
            public void onFault(String errorMsg) {
                iView.loginFailed(errorMsg);
            }
        };
        MethodApi.login(username,password, new OnSuccessAndFaultSub(listener, context));
    }
}
