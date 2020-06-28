package com.example.cadres.view.yjjc;

import android.os.Bundle;

import com.example.cadres.R;
import com.example.cadres.adapter.YjjcCadreAdapter;
import com.example.cadres.base.BaseFragment;
import com.example.cadres.beanDB.DBYjjcCadre;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class YjjcCadreFragment extends BaseFragment {

    RecyclerView recyclerView;

    YjjcCadreAdapter mAdapter;

    List<DBYjjcCadre> datas;

    boolean isViewLoad;

    public static Fragment newInstance() {
        YjjcCadreFragment fragment = new YjjcCadreFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_yjjc_cadre;
    }

    @Override
    public void initView() {
        initRecycler();
        isViewLoad= true;
    }

    @Override
    public void initData() {
        if(datas == null) return;
            setViewData();
    }

    private void setViewData() {
        mAdapter.setData(datas);
    }

    public void setData(List<DBYjjcCadre> datas){
        this.datas = datas;
        if(isViewLoad)
            setViewData();
    }


    //初始化recyclerview
    public void initRecycler() {
        recyclerView = $(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new YjjcCadreAdapter(activity, new ArrayList<DBYjjcCadre>());
        recyclerView.setAdapter(mAdapter);
    }
}
