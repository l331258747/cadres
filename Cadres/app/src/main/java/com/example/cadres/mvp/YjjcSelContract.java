package com.example.cadres.mvp;

import com.example.cadres.bean.yjjc.YjjcBean;

import java.util.List;

public interface YjjcSelContract {

    interface Presenter {
        void getMeetingFiles();
        void getYjjcList();
    }

    interface View {
        void getMeetingFilesSuccess(List<String> data);
        void getMeetingFilesFailed(String msg);

        void getYjjcListSuccess(List<YjjcBean.YjjcBean2> data);
        void getYjjcListFailed(String msg);
    }

}
