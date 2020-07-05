package com.example.cadres.view.yjjc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.adapter.YjjcCadreAdapter;
import com.example.cadres.base.BaseFragment;
import com.example.cadres.bean.login.MySelfInfo;
import com.example.cadres.bean.yjjc.YjjcVoteCheckBean;
import com.example.cadres.beanDB.DBYjjcCadre;
import com.example.cadres.mvp.LoginPresenter;
import com.example.cadres.mvp.YjjcCadreContract;
import com.example.cadres.mvp.YjjcCadrePresenter;
import com.example.cadres.view.Gb.GbDetailActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class YjjcCadreFragment extends BaseFragment implements YjjcCadreContract.View {

    RecyclerView recyclerView;
    TextView tv_btn;

    YjjcCadreAdapter mAdapter;

    List<DBYjjcCadre> datas;
    int schemeId;

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
        initBtn();

        initRecycler();
        isViewLoad= true;

        mPresenter = new YjjcCadrePresenter(context,this);
    }

    YjjcCadrePresenter mPresenter;

    private void initBtn() {
        tv_btn = $(R.id.tv_btn);
        tv_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getYjjcVoteCheck(schemeId, MySelfInfo.getInstance().getUserId());
            }
        });
    }

    @Override
    public void initData() {
        if(datas == null || datas.size() == 0){
            tv_btn.setVisibility(View.GONE);
            return;
        }
        tv_btn.setVisibility(View.VISIBLE);
        setViewData();
    }

    private void setViewData() {
        mAdapter.setData(datas);
    }

    public void setData(int schemeId, List<DBYjjcCadre> datas){
        this.schemeId = schemeId;
        this.datas = datas;
        if(isViewLoad){
            if(datas == null || datas.size() == 0){
                tv_btn.setVisibility(View.GONE);
                return;
            }
            tv_btn.setVisibility(View.VISIBLE);
            setViewData();
        }
    }


    //初始化recyclerview
    public void initRecycler() {
        recyclerView = $(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new YjjcCadreAdapter(activity, new ArrayList<DBYjjcCadre>());
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new YjjcCadreAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Intent intent = new Intent(context, GbDetailActivity.class);
                intent.putExtra("ID", datas.get(pos).getBaseId());
                startActivity(intent);
            }
        });
    }

    @Override
    public void getYjjcVoteCheckSuccess(YjjcVoteCheckBean data) {
        if(data.getState() == 2){
            showShortToast("对不起，您没有票决权限");
            return;
        }
        Intent intent = new Intent(context,YjjcVoteActivity.class);
        intent.putExtra("state", data.getState());
        intent.putExtra("schemeId", schemeId);
        startActivity(intent);
    }

    @Override
    public void getYjjcVoteCheckFailed(String msg) {
        showShortToast("请在指定的网络下进行票决操作");
    }
}
