package com.example.cadres.mvp;

import com.example.cadres.bean.yjjc.YjjcVoteCheckBean;

public interface YjjcCadreContract {

    interface Presenter {
        void getYjjcVoteCheck(int schemeId, int voteUserId);

    }

    interface View {
        void getYjjcVoteCheckSuccess(YjjcVoteCheckBean data);
        void getYjjcVoteCheckFailed(String msg);

    }
}
