package com.example.cadres.mvp;

import com.example.cadres.bean.yjjc.YjjcBean;

import java.util.List;

public interface YjjcDetailContract {

    interface Presenter {
        void getYjjcList();
    }

    interface View {
        void getYjjcListSuccess(List<YjjcBean.YjjcBean2> data);
        void getYjjcListFailed(String msg);
    }
}
