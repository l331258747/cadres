package com.example.cadres.view.yjjc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.adapter.FjAdapter;
import com.example.cadres.base.BaseFragment;
import com.example.cadres.beanDB.DBYjjcMeeting;
import com.example.cadres.constant.Constant;
import com.example.cadres.utils.FileUtil;
import com.example.cadres.utils.GsonUtil;
import com.example.cadres.utils.StringUtils;
import com.example.cadres.view.other.PhotoImageActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class YjjcMettingFragment extends BaseFragment {

    TextView tv_content,tv_hynr_content,tv_shsj_content,tv_hylx_content,tv_chry_content,tv_title_content;

    DBYjjcMeeting data;

    boolean isViewLoad;

    Group group_fj;
    RecyclerView recycle_fj;
    FjAdapter mAdapter;
    List<String> datas;

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
        group_fj = $(R.id.group_fj);
        recycle_fj = $(R.id.recycle_fj);
        tv_content = $(R.id.tv_content);
        tv_hynr_content = $(R.id.tv_hynr_content);
        tv_shsj_content = $(R.id.tv_shsj_content);
        tv_hylx_content = $(R.id.tv_hylx_content);
        tv_chry_content = $(R.id.tv_chry_content);
        tv_title_content = $(R.id.tv_title_content);
        initRecycler();

        isViewLoad= true;
    }

    @Override
    public void initData() {
        if(data == null) return;
            setViewData();
    }

    private void setViewData() {
        if(data == null) return;
        if(!TextUtils.isEmpty(data.getMeetingSummary()))
            StringUtils.setHtml(tv_content, data.getMeetingSummary());
        tv_hynr_content.setText(data.getMeetingDescribe());
        tv_shsj_content.setText(data.getMeetingTime());
        tv_hylx_content.setText(data.getMeetingType());
        tv_chry_content.setText(data.getMeetingUser());
        tv_title_content.setText(data.getSchemeName());

        datas = GsonUtil.convertJson2Array(data.getMaterialFileName());

        if(datas.size() == 0){
            group_fj.setVisibility(View.GONE);
        }else{
            group_fj.setVisibility(View.VISIBLE);
            mAdapter.setData(datas);
        }
    }

    public void setData(DBYjjcMeeting data){
        this.data = data;
        if(isViewLoad)
            setViewData();
    }


    //初始化recyclerview
    public void initRecycler() {
        recycle_fj = $(R.id.recycle_fj);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recycle_fj.setLayoutManager(linearLayoutManager);
        mAdapter = new FjAdapter(activity, new ArrayList<String>());
        recycle_fj.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new FjAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                if(TextUtils.isEmpty(datas.get(pos))) return;
                Intent intent = new Intent(context, PhotoImageActivity.class);
                String imgUrl = FileUtil.getFolderPath(Constant.IMAGE_PATH + File.separator) + datas.get(pos);
                intent.putExtra("imgUrl", imgUrl);
                startActivity(intent);
            }
        });
    }
}
