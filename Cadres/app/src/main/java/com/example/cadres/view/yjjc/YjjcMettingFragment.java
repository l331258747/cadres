package com.example.cadres.view.yjjc;

import android.os.Bundle;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.base.BaseFragment;
import com.example.cadres.beanDB.DBYjjcMeeting;
import com.example.cadres.utils.StringUtils;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class YjjcMettingFragment extends BaseFragment {

    TextView tv_content,tv_hynr_content,tv_shsj_content,tv_hylx_content,tv_chry_content,tv_title_content;

    DBYjjcMeeting data;

    boolean isViewLoad;


    public static Fragment newInstance() {
        YjjcMettingFragment fragment = new YjjcMettingFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_yjjc_meeting;
    }


    @Override
    public void initView() {
        tv_content = $(R.id.tv_content);
        tv_hynr_content = $(R.id.tv_hynr_content);
        tv_shsj_content = $(R.id.tv_shsj_content);
        tv_hylx_content = $(R.id.tv_hylx_content);
        tv_chry_content = $(R.id.tv_chry_content);
        tv_title_content = $(R.id.tv_title_content);

        isViewLoad= true;
    }

    @Override
    public void initData() {
        if(data == null) return;
            setViewData();
    }

    private void setViewData() {
        StringUtils.setHtml(tv_content, data.getMeetingSummary());
        tv_hynr_content.setText(data.getMeetingDescribe());
        tv_shsj_content.setText(data.getMeetingTime());
        tv_hylx_content.setText(data.getMeetingType());
        tv_chry_content.setText(data.getMeetingUser());
        tv_title_content.setText(data.getSchemeName());
    }

    public void setData(DBYjjcMeeting data){
        this.data = data;
        if(isViewLoad)
            setViewData();
    }
}
