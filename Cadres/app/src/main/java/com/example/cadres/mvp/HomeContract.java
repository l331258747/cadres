package com.example.cadres.mvp;

import com.example.cadres.bean.Gb.GbBean;
import com.example.cadres.bean.Gb.GbCadreDeptListBean;
import com.example.cadres.bean.Gb.GbCadreFamilyMemberList;
import com.example.cadres.bean.apk.ApkBean;
import com.example.cadres.bean.bm.BmBean1;
import com.example.cadres.bean.bmGwy.BmGwyBean;
import com.example.cadres.bean.dsjty.HjtyBean;
import com.example.cadres.bean.dsjty.HjtyListBean;
import com.example.cadres.bean.dsjty.JgtyBean;
import com.example.cadres.bean.dsjty.ZstyBean;
import com.example.cadres.bean.login.LoginBean;
import com.example.cadres.bean.search.SearchBean;
import com.example.cadres.bean.yjjc.YjjcBean;
import com.example.cadres.bean.zcfg.ZcfgBean;

import java.util.List;

public interface HomeContract {

    interface Presenter {
        void findUserInfo(int userId);
        void getZcfgList();
        void getBmList();
        void getGbList(boolean isCheck);
        void getGbFamilyList(boolean isCheck);
        void getGbDeptList(boolean isCheck);

        void getYjjcList();
        void getFiles(boolean isCheck);

        void getJgty();
        void getZsty();
        void getHjty();
        void getHjtyList();

        void getSearchData();
        void getBmListGwy();

        void getApk();
    }

    interface View {
        void getBmListGwySuccess(BmGwyBean data);
        void getBmListGwyFailed(String msg);

        void getSearchDataSuccess(SearchBean.SearchParamBean data);
        void getSearchDataFailed(String msg);

        void getApkSuccess(ApkBean.ApkBean2 data);
        void getApkFailed(String msg);

        void getHjtyListSuccess(HjtyListBean.HjtyListBean2 data);
        void getHjtyListFailed(String msg);

        void getJgtySuccess(JgtyBean data);
        void getJgtyFailed(String msg);
        void getZstySuccess(ZstyBean data);
        void getZstyFailed(String msg);
        void getHjtySuccess(HjtyBean.HjtyBean2 data);
        void getHjtyFailed(String msg);

        void findUserInfoSuccess(LoginBean.LoginBean2 data);
        void findUserInfoFailed(String msg);

        void getZcfgListSuccess(ZcfgBean data);
        void getZcfgListFailed(String msg);

        void getBmListSuccess(BmBean1 data);
        void getBmListFailed(String msg);

        void getGbListSuccess(List<GbBean.GbBean2> data);
        void getGbListFailed(String msg);
        void getGbFamilyListSuccess(List<GbCadreFamilyMemberList> data);
        void getGbFamilyListFailed(String msg);
        void getGbDeptListSuccess(List<GbCadreDeptListBean> data);
        void getGbDeptListFailed(String msg);

        void getYjjcListSuccess(List<YjjcBean.YjjcBean2> data);
        void getYjjcListFailed(String msg);

        void getFilesSuccess(List<String> data);
        void getFilesFailed(String msg);
    }

}
