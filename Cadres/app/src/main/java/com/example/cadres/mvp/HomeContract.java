package com.example.cadres.mvp;

import com.example.cadres.bean.login.LoginBean;

public interface HomeContract {

    interface Presenter {
        void findUserInfo(int userId);
    }

    interface View {
//        void findUserListSuccess(List<UserListBean> list);
//        void findUserListFailed(String msg);

        void findUserInfoSuccess(LoginBean.LoginBean2 data);
        void findUserInfoFailed(String msg);
    }

}
