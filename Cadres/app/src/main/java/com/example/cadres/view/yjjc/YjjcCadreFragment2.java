package com.example.cadres.view.yjjc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.adapter.YjjcCadreAdapterRight2;
import com.example.cadres.adapter.YjjcCadreLeftAdapter2;
import com.example.cadres.base.BaseFragment;
import com.example.cadres.bean.login.MySelfInfo;
import com.example.cadres.bean.yjjc.YjjcVoteCheckBean;
import com.example.cadres.beanDB.DBYjjcCadre;
import com.example.cadres.beanDB.DBYjjcCadre2;
import com.example.cadres.beanDB.DBYjjcCadre3;
import com.example.cadres.mvp.YjjcCadreContract;
import com.example.cadres.mvp.YjjcCadrePresenter;
import com.example.cadres.widget.MyItemTouchListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class YjjcCadreFragment2 extends BaseFragment implements YjjcCadreContract.View {

    RecyclerView recyclerViewRight;
    RecyclerView recyclerViewLeft;
    MyItemTouchListener touchListenerLeft;
    MyItemTouchListener touchListenerRight;
    TextView tv_btn;

    YjjcCadreAdapterRight2 mAdapterRight;
    YjjcCadreLeftAdapter2 mAdapterLeft;

    Group group_cwhyj;
    List<DBYjjcCadre3> datas;
    int schemeId;
    String type;

    boolean isViewLoad;

    boolean isMeetingModel;

    public static Fragment newInstance(boolean isMeetingModel) {
        YjjcCadreFragment2 fragment = new YjjcCadreFragment2();
        Bundle bundle = new Bundle();
        bundle.putBoolean("isMeetingModel", isMeetingModel);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            isMeetingModel = bundle.getBoolean("isMeetingModel");
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_yjjc_cadre2;
    }

    @Override
    public void initView() {
        initBtn();
        group_cwhyj = $(R.id.group_cwhyj);
        initRecycler();
        initRecyclerLeft();
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
        if(TextUtils.equals(type,"市委常委会议")){
            tv_btn.setVisibility(View.VISIBLE);
            group_cwhyj.setVisibility(View.VISIBLE);
        }else{
            tv_btn.setVisibility(View.GONE);
            group_cwhyj.setVisibility(View.GONE);
        }
        setViewData();
    }

    private void setViewData() {
        if(datas == null) return;
        mAdapterRight.setData(datas);
        mAdapterLeft.setData(datas);
    }

    public void setData(int schemeId, List<DBYjjcCadre3> datas,String type){
        this.schemeId = schemeId;
        this.datas = datas;
        this.type = type;
        if(isViewLoad){
            if(datas == null || datas.size() == 0){
                tv_btn.setVisibility(View.GONE);
                return;
            }

            if(TextUtils.equals(type,"市委常委会议")){
                tv_btn.setVisibility(View.VISIBLE);
            }else{
                tv_btn.setVisibility(View.GONE);
            }

            setViewData();
        }
    }


    //初始化recyclerview
    public void initRecycler() {
        recyclerViewRight = $(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerViewRight.setLayoutManager(linearLayoutManager);
        mAdapterRight = new YjjcCadreAdapterRight2(activity, type, new ArrayList<DBYjjcCadre2>());
        recyclerViewRight.setAdapter(mAdapterRight);

        recyclerViewRight.addOnItemTouchListener(touchListenerRight = new MyItemTouchListener());

        recyclerViewRight.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                touchListenerLeft.setCanTouch(newState == 0? false:true);
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (RecyclerView.SCROLL_STATE_IDLE != recyclerView.getScrollState()) {
                    recyclerViewLeft.scrollBy(dx, dy);
                }

            }
        });

        mAdapterRight.setOnItemClickListener(new YjjcCadreAdapterRight2.OnItemClickListener() {
            @Override
            public void onClick(int baseId) {
//                Intent intent = new Intent(context, GbDetailActivity.class);
//                intent.putExtra("ID", datas.get(pos).getBaseId());
//                startActivity(intent);
                ((YjjcDetailActivity2)getActivity()).showGbinfo(baseId);
            }
        });
    }

    //初始化recyclerview
    public void initRecyclerLeft() {
        recyclerViewLeft = $(R.id.recycler_view_left);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerViewLeft.setLayoutManager(linearLayoutManager);
        mAdapterLeft = new YjjcCadreLeftAdapter2(activity, new ArrayList<DBYjjcCadre2>());
        recyclerViewLeft.setAdapter(mAdapterLeft);

        recyclerViewLeft.addOnItemTouchListener(touchListenerLeft = new MyItemTouchListener());

        recyclerViewLeft.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                touchListenerRight.setCanTouch(newState == 0? false:true);
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (RecyclerView.SCROLL_STATE_IDLE != recyclerView.getScrollState()) {
                    recyclerViewRight.scrollBy(dx, dy);
                }

            }
        });

        mAdapterLeft.setOnItemClickListener(new YjjcCadreLeftAdapter2.OnItemClickListener() {
            @Override
            public void onClick(int baseId) {
//                Intent intent = new Intent(context, GbDetailActivity.class);
//                intent.putExtra("ID", datas.get(pos).getBaseId());
//                startActivity(intent);

                ((YjjcDetailActivity2)getActivity()).showGbinfo(baseId);
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
        intent.putExtra("isMeetingModel",isMeetingModel);
        startActivity(intent);
    }

    @Override
    public void getYjjcVoteCheckFailed(String msg) {
        showShortToast("请在指定的网络下进行票决操作");
    }
}
