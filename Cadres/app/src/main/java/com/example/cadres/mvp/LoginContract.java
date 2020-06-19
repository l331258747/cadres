package com.example.cadres.mvp;

import com.example.cadres.bean.UserListBean;
import com.example.cadres.bean.login.LoginBean;

import java.util.List;

/**
 * Created by LGQ
 * Time: 2018/11/8
 * Function:
 */

public interface LoginContract {

    interface Presenter {
        void login(String username,String password);
    }

    interface View {
//        void findUserListSuccess(List<UserListBean> list);
//        void findUserListFailed(String msg);

        void loginSuccess(LoginBean.LoginBean2 data);
        void loginFailed(String msg);
    }

}
