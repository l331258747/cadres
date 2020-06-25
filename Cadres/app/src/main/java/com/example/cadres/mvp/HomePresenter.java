package com.example.cadres.mvp;

import android.content.Context;

import com.example.cadres.bean.Gb.GbBean;
import com.example.cadres.bean.bm.BmBean;
import com.example.cadres.bean.login.LoginBean;
import com.example.cadres.bean.zcfg.ZcfgBean;
import com.example.cadres.utils.http.MethodApi;
import com.example.cadres.utils.http.OnSuccessAndFaultSub;
import com.example.cadres.utils.http.ResponseCallback;

import java.util.List;

public class HomePresenter implements HomeContract.Presenter {
    HomeContract.View iView;
    Context context;

    public HomePresenter(Context context, HomeContract.View view) {
        this.iView = view;
        this.context = context;
    }

    @Override
    public void findUserInfo(int userId) {
        ResponseCallback listener = new ResponseCallback<LoginBean>() {
            @Override
            public void onSuccess(LoginBean data) {
                iView.findUserInfoSuccess(data.getZzbUser());
            }

            @Override
            public void onFault(String errorMsg) {
                iView.findUserInfoFailed(errorMsg);
            }
        };
        MethodApi.findUserInfo(userId, new OnSuccessAndFaultSub(listener, context,false));
    }

    @Override
    public void getZcfgList() {
        ResponseCallback listener = new ResponseCallback<ZcfgBean>() {
            @Override
            public void onSuccess(ZcfgBean data) {
                iView.getZcfgListSuccess(data.getZzbNotice());
            }

            @Override
            public void onFault(String errorMsg) {
                iView.getZcfgListFailed(errorMsg);
            }
        };
        MethodApi.getZcfgList(new OnSuccessAndFaultSub(listener, context,false));
    }

    @Override
    public void getBmList() {
        ResponseCallback listener = new ResponseCallback<BmBean>() {
            @Override
            public void onSuccess(BmBean data) {
                iView.getBmListSuccess(data.getZzbOrganization());
            }

            @Override
            public void onFault(String errorMsg) {
                iView.getBmListFailed(errorMsg);
            }
        };
        MethodApi.getbmList(new OnSuccessAndFaultSub(listener, context,false));
    }

    @Override
    public void getGbList() {
        ResponseCallback listener = new ResponseCallback<List<GbBean>>() {
            @Override
            public void onSuccess(List<GbBean> data) {
                iView.getGbListSuccess(data);
            }

            @Override
            public void onFault(String errorMsg) {
                iView.getGbListFailed(errorMsg);
            }
        };
        MethodApi.getbmList(new OnSuccessAndFaultSub(listener, context,false));
    }
}
