package com.example.cadres.mvp;

import com.example.cadres.bean.EmptyModel;
import com.example.cadres.bean.yjjc.YjjcVoteListBean;

import java.util.List;
import java.util.Map;

public interface YjjcVoteContract {

    interface Presenter {
        void getYjjcVoteList(int schemeId, int voteUserId);
        void sendYjjcVote(Map<String,String> params);

    }

    interface View {
        void getYjjcVoteListSuccess(List<YjjcVoteListBean> data);
        void getYjjcVoteListFailed(String msg);

        void sendYjjcVoteSuccess(EmptyModel data);
        void sendYjjcVoteFailed(String msg);

    }

}
