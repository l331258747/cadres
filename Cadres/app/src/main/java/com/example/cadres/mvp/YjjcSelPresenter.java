package com.example.cadres.mvp;

import android.content.Context;

import com.example.cadres.bean.file.FileBean;
import com.example.cadres.bean.yjjc.YjjcBean;
import com.example.cadres.utils.http.MethodApi;
import com.example.cadres.utils.http.OnSuccessAndFaultSub;
import com.example.cadres.utils.http.ResponseCallback;

import java.util.ArrayList;
import java.util.List;

public class YjjcSelPresenter implements YjjcSelContract.Presenter{

    Context context;
    YjjcSelContract.View iView;

    public YjjcSelPresenter(Context context, YjjcSelContract.View iView) {
        this.context = context;
        this.iView = iView;
    }

    @Override
    public void getMeetingFiles() {
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
                iView.getMeetingFilesSuccess(files);

            }

            @Override
            public void onFault(String errorMsg) {
                iView.getMeetingFilesFailed(errorMsg);
            }
        };
        MethodApi.getMeetingFiles(new OnSuccessAndFaultSub(listener, context,false));
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
}
