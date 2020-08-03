package com.example.cadres.mvp;

import android.content.Context;

import com.example.cadres.bean.Gb.GbBean;
import com.example.cadres.bean.apk.ApkBean;
import com.example.cadres.bean.bm.BmBean;
import com.example.cadres.bean.dsjty.HjtyBean;
import com.example.cadres.bean.dsjty.HjtyListBean;
import com.example.cadres.bean.dsjty.JgtyBean;
import com.example.cadres.bean.dsjty.ZstyBean;
import com.example.cadres.bean.file.FileBean;
import com.example.cadres.bean.login.LoginBean;
import com.example.cadres.bean.search.SearchBean;
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
                iView.getZcfgListSuccess(data);
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
                iView.getBmListSuccess(data.getOrganization());
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
                if (data != null && data.getFileUrlList() != null) {
                    for (int i = 0; i < data.getFileUrlList().size(); i++) {
                        String str = data.getFileUrlList().get(i);
                        if (str.startsWith("http") && (str.endsWith("jpg") || str.endsWith("png") || str.endsWith("jpeg"))) {
                            files.add(str);
                        }
                    }
                }
                iView.getFilesSuccess(files);

            }

            @Override
            public void onFault(String errorMsg) {
                iView.getFilesFailed(errorMsg);
            }
        };
        MethodApi.getFiles(new OnSuccessAndFaultSub(listener, context,false));
    }

    @Override
    public void getJgty() {
        ResponseCallback listener = new ResponseCallback<JgtyBean>() {
            @Override
            public void onSuccess(JgtyBean data) {
                iView.getJgtySuccess(data.getOrgdeductionList());
            }

            @Override
            public void onFault(String errorMsg) {
                iView.getJgtyFailed(errorMsg);
            }
        };
        MethodApi.getJgty(new OnSuccessAndFaultSub(listener, context,false));
    }

    @Override
    public void getZsty() {
        ResponseCallback listener = new ResponseCallback<ZstyBean>() {
            @Override
            public void onSuccess(ZstyBean data) {
                iView.getZstySuccess(data);
            }

            @Override
            public void onFault(String errorMsg) {
                iView.getZstyFailed(errorMsg);
            }
        };
        MethodApi.getZsty(new OnSuccessAndFaultSub(listener, context,false));
    }

    @Override
    public void getHjty() {
        ResponseCallback listener = new ResponseCallback<HjtyBean>() {
            @Override
            public void onSuccess(HjtyBean data) {
                iView.getHjtySuccess(data.getNewTerm());
            }

            @Override
            public void onFault(String errorMsg) {
                iView.getHjtyFailed(errorMsg);
            }
        };
        MethodApi.getHjty(new OnSuccessAndFaultSub(listener, context,false));
    }

    @Override
    public void getHjtyList() {
        ResponseCallback listener = new ResponseCallback<HjtyListBean>() {
            @Override
            public void onSuccess(HjtyListBean data) {
                iView.getHjtyListSuccess(data.getMeetRequirements());
            }

            @Override
            public void onFault(String errorMsg) {
                iView.getHjtyListFailed(errorMsg);
            }
        };
        MethodApi.getHjtyList(new OnSuccessAndFaultSub(listener, context,false));
    }

    @Override
    public void getSearchData() {
        ResponseCallback listener = new ResponseCallback<SearchBean>() {
            @Override
            public void onSuccess(SearchBean data) {
                iView.getSearchDataSuccess(data.getSearchParam());
            }

            @Override
            public void onFault(String errorMsg) {
                iView.getSearchDataFailed(errorMsg);
            }
        };
        MethodApi.getSearchData(new OnSuccessAndFaultSub(listener, context,false));
    }

    @Override
    public void getApk() {
        ResponseCallback listener = new ResponseCallback<ApkBean>() {
            @Override
            public void onSuccess(ApkBean data) {
                iView.getApkSuccess(data.getAppVersion());
            }

            @Override
            public void onFault(String errorMsg) {
                iView.getApkFailed(errorMsg);
            }
        };
        MethodApi.getApk(new OnSuccessAndFaultSub(listener, context,false));
    }
}
