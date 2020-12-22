package com.example.cadres.mvp;

import android.content.Context;

import com.example.cadres.bean.yjjc.YjjcBean;
import com.example.cadres.utils.http.MethodApi;
import com.example.cadres.utils.http.OnSuccessAndFaultSub;
import com.example.cadres.utils.http.ResponseCallback;

public class YjjcDetailPresenter implements YjjcDetailContract.Presenter {

    YjjcDetailContract.View iView;
    Context context;

    public YjjcDetailPresenter(Context context, YjjcDetailContract.View view) {
        this.iView = view;
        this.context = context;
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
        MethodApi.getYjjcList2(new OnSuccessAndFaultSub(listener, context));
    }
}
