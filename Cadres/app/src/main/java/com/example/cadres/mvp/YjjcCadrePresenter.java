package com.example.cadres.mvp;

import android.content.Context;

import com.example.cadres.bean.yjjc.YjjcVoteCheckBean;
import com.example.cadres.utils.http.MethodApi;
import com.example.cadres.utils.http.OnSuccessAndFaultSub;
import com.example.cadres.utils.http.ResponseCallback;

public class YjjcCadrePresenter implements YjjcCadreContract.Presenter {

    YjjcCadreContract.View iView;
    Context context;

    public YjjcCadrePresenter(Context context, YjjcCadreContract.View view) {
        this.iView = view;
        this.context = context;
    }

    @Override
    public void getYjjcVoteCheck(int schemeId, int voteUserId) {
        ResponseCallback listener = new ResponseCallback<YjjcVoteCheckBean>() {
            @Override
            public void onSuccess(YjjcVoteCheckBean data) {
                iView.getYjjcVoteCheckSuccess(data);
            }

            @Override
            public void onFault(String errorMsg) {
                iView.getYjjcVoteCheckFailed(errorMsg);
            }
        };
        MethodApi.getYjjcVoteCheck(schemeId,voteUserId, new OnSuccessAndFaultSub(listener, context));
    }
}
