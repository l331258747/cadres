package com.example.cadres.view.yjjc;

import android.view.View;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.adapter.YjjcVoteAdapter;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.EmptyModel;
import com.example.cadres.bean.login.MySelfInfo;
import com.example.cadres.bean.yjjc.YjjcVoteListBean;
import com.example.cadres.mvp.YjjcVoteContract;
import com.example.cadres.mvp.YjjcVotePresenter;
import com.example.cadres.utils.rxbus.RxBus2;
import com.example.cadres.utils.rxbus.rxbusEvent.VoteEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class YjjcVoteActivity extends BaseActivity implements YjjcVoteContract.View {

    YjjcVotePresenter mPresenter;
    TextView tv_btn;
    RecyclerView recyclerView;

    YjjcVoteAdapter mAdapter;

    int state;
    int schemeId;

    @Override
    public int getLayoutId() {
        return R.layout.activity_yjjc_vote;
    }

    @Override
    public void initView() {
        showLeftIcon();
        showLLRightGoHome();
        showTitleTv("票决");

        state = intent.getIntExtra("state",0);
        schemeId = intent.getIntExtra("schemeId",0);

        if(state == 1)
            tv_btn.setVisibility(View.GONE);

        initRecycler();
        initBtn();

    }

    private void initBtn() {

        tv_btn = findViewById(R.id.tv_btn);
        tv_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, String> params = new HashMap<>();
                for (int i = 0; i< mAdapter.getData().size();i++){
                    YjjcVoteListBean item =  mAdapter.getData().get(i);
                    if(item.getMyVote() == 0){
                        showShortToast("请完成选择后再进行票决");
                        return;
                    }
                    params.put(item.getVoteId() + "",item.getMyVote() + "");
                }
                mPresenter.sendYjjcVote(params);
            }
        });
    }

    @Override
    public void initData() {
        mPresenter = new YjjcVotePresenter(context,this);

        mPresenter.getYjjcVoteList(schemeId, MySelfInfo.getInstance().getUserId());

    }

    @Override
    public void getYjjcVoteListSuccess(List<YjjcVoteListBean> data) {
        mAdapter.setData(data,state == 1?true:false);
    }

    @Override
    public void getYjjcVoteListFailed(String msg) {
        showShortToast(msg);
    }

    @Override
    public void sendYjjcVoteSuccess(EmptyModel data) {
        mAdapter.setOver();
        tv_btn.setVisibility(View.GONE);
        RxBus2.getInstance().post(new VoteEvent());
    }

    @Override
    public void sendYjjcVoteFailed(String msg) {
        showShortToast(msg);
    }


    //初始化recyclerview
    public void initRecycler() {
        recyclerView = $(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new YjjcVoteAdapter(activity, new ArrayList<YjjcVoteListBean>());
        recyclerView.setAdapter(mAdapter);
    }
}
