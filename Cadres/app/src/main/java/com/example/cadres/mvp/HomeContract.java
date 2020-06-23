package com.example.cadres.mvp;

import com.example.cadres.bean.bm.BmBean;
import com.example.cadres.bean.login.LoginBean;
import com.example.cadres.bean.zcfg.ZcfgBean;

import java.util.List;

public interface HomeContract {

    interface Presenter {
        void findUserInfo(int userId);
        void getZcfgList();
        void getBmList();
    }

    interface View {

        void findUserInfoSuccess(LoginBean.LoginBean2 data);
        void findUserInfoFailed(String msg);

        void getZcfgListSuccess(List<ZcfgBean.ZcfgBean2> data);
        void getZcfgListFailed(String msg);

        void getBmListSuccess(List<BmBean.BmBean2> data);
        void getBmListFailed(String msg);
    }

}
