package com.example.cadres.mvp;

import android.content.Context;

import com.example.cadres.bean.EmptyModel;
import com.example.cadres.bean.yjjc.YjjcVoteListBean;
import com.example.cadres.bean.yjjc.YjjcVoteListParent;
import com.example.cadres.utils.http.MethodApi;
import com.example.cadres.utils.http.OnSuccessAndFaultSub;
import com.example.cadres.utils.http.ResponseCallback;

import java.util.List;
import java.util.Map;

public class YjjcVotePresenter implements YjjcVoteContract.Presenter {

    YjjcVoteContract.View iView;
    Context context;

    public YjjcVotePresenter(Context context, YjjcVoteContract.View view) {
        this.iView = view;
        this.context = context;
    }

    @Override
    public void getYjjcVoteList(int schemeId, int voteUserId) {
        ResponseCallback listener = new ResponseCallback<YjjcVoteListParent>() {
            @Override
            public void onSuccess(YjjcVoteListParent data) {
                iView.getYjjcVoteListSuccess(data.getZzbAppointDismissVoteList());
            }

            @Override
            public void onFault(String errorMsg) {
                iView.getYjjcVoteListFailed(errorMsg);
            }
        };
        MethodApi.getYjjcVoteList(schemeId,voteUserId, new OnSuccessAndFaultSub(listener, context));
    }

    @Override
    public void sendYjjcVote(Map<String, String> params) {
        ResponseCallback listener = new ResponseCallback<EmptyModel>() {
            @Override
            public void onSuccess(EmptyModel data) {
                iView.sendYjjcVoteSuccess(data);
            }

            @Override
            public void onFault(String errorMsg) {
                iView.sendYjjcVoteFailed(errorMsg);
            }
        };
        MethodApi.sendYjjcVote(params, new OnSuccessAndFaultSub(listener, context));
    }
}
