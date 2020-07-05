package com.example.cadres.mvp;

import com.example.cadres.bean.Gb.GbBean;
import com.example.cadres.bean.bm.BmBean;
import com.example.cadres.bean.dsjty.HjtyBean;
import com.example.cadres.bean.dsjty.JgtyBean;
import com.example.cadres.bean.dsjty.ZstyBean;
import com.example.cadres.bean.login.LoginBean;
import com.example.cadres.bean.yjjc.YjjcBean;
import com.example.cadres.bean.zcfg.ZcfgBean;

import java.util.List;

public interface HomeContract {

    interface Presenter {
        void findUserInfo(int userId);
        void getZcfgList();
        void getBmList();
        void getGbList();
        void getYjjcList();
        void getFiles();

        void getJgty();
        void getZsty();
        void getHjty();
    }

    interface View {

        void getJgtySuccess(List<JgtyBean.jgtyBean2> data);
        void getJgtyFailed(String msg);
        void getZstySuccess(List<ZstyBean.ZstyBean2> data);
        void getZstyFailed(String msg);
        void getHjtySuccess(HjtyBean.HjtyBean2 data);
        void getHjtyFailed(String msg);

        void findUserInfoSuccess(LoginBean.LoginBean2 data);
        void findUserInfoFailed(String msg);

        void getZcfgListSuccess(List<ZcfgBean.ZcfgBean2> data);
        void getZcfgListFailed(String msg);

        void getBmListSuccess(List<BmBean.BmBean2> data);
        void getBmListFailed(String msg);

        void getGbListSuccess(List<GbBean.GbBean2> data);
        void getGbListFailed(String msg);

        void getYjjcListSuccess(List<YjjcBean.YjjcBean2> data);
        void getYjjcListFailed(String msg);

        void getFilesSuccess(List<String> data);
        void getFilesFailed(String msg);
    }

}
