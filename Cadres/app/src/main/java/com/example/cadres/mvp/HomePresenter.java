package com.example.cadres.mvp;

import android.content.Context;

import com.example.cadres.bean.Gb.GbBean;
import com.example.cadres.bean.bm.BmBean;
import com.example.cadres.bean.file.FileBean;
import com.example.cadres.bean.login.LoginBean;
import com.example.cadres.bean.yjjc.YjjcBean;
import com.example.cadres.bean.zcfg.ZcfgBean;
import com.example.cadres.utils.http.MethodApi;
import com.example.cadres.utils.http.OnSuccessAndFaultSub;
import com.example.cadres.utils.http.ResponseCallback;

import java.util.ArrayList;
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
        ResponseCallback listener = new ResponseCallback<GbBean>() {
            @Override
            public void onSuccess(GbBean data) {
                iView.getGbListSuccess(data.getCadreBaseList());
            }

            @Override
            public void onFault(String errorMsg) {
                iView.getGbListFailed(errorMsg);
            }
        };
        MethodApi.getGbList(new OnSuccessAndFaultSub(listener, context,false));
    }

    @Override
    public void getYjjcList() {
        ResponseCallback listener = new ResponseCallback<YjjcBean>() {
            @Override
            public void onSuccess(YjjcBean data) {
                iView.getYjjcListSuccess(data.getAppointDismissSchemeList());
            }

            @Override
            public void onFault(String errorMsg) {
                iView.getYjjcListFailed(errorMsg);
            }
        };
        MethodApi.getYjjcList(new OnSuccessAndFaultSub(listener, context,false));
    }

    @Override
    public void getFiles() {
        ResponseCallback listener = new ResponseCallback<FileBean>() {
            @Override
            public void onSuccess(FileBean data) {
                List<String> files = new ArrayList<>();
//                if (data != null && data.getFileUrlList() != null) {
//                    for (int i = 0; i < data.getFileUrlList().size(); i++) {
//                        String str = data.getFileUrlList().get(i);
//                        if (str.startsWith("http") && (str.endsWith("jpg") || str.endsWith("png") || str.endsWith("jpeg"))) {
//                            files.add(str);
//                        }
//                    }
//                }
                files.add("http://img1.imgtn.bdimg.com/it/u=1320272459,772040234&fm=26&gp=0.jpg");
                files.add("http://192.168.100.103:8099/profile/upload/2020/06/29/8c4bfc6ca81b86b2a952fce9ac7daaa5.png");
                files.add("http://img3.imgtn.bdimg.com/it/u=226419046,487093019&fm=26&gp=0.jpg");
                files.add("http://img0.imgtn.bdimg.com/it/u=2238904677,3640117141&fm=26&gp=0.jpg");
                files.add("http://img2.imgtn.bdimg.com/it/u=3087705303,1740657087&fm=26&gp=0.jpg");
                iView.getFilesSuccess(files);

            }

            @Override
            public void onFault(String errorMsg) {
                iView.getFilesFailed(errorMsg);
            }
        };
        MethodApi.getFiles(new OnSuccessAndFaultSub(listener, context,false));
    }
}
