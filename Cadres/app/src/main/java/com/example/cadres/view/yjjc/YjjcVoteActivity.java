package com.example.cadres.view.yjjc;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.adapter.YjjcVoteAdapter;
import com.example.cadres.base.ActivityCollect;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.EmptyModel;
import com.example.cadres.bean.login.MySelfInfo;
import com.example.cadres.bean.yjjc.YjjcVoteListBean;
import com.example.cadres.dialog.DialogUtil;
import com.example.cadres.mvp.YjjcVoteContract;
import com.example.cadres.mvp.YjjcVotePresenter;
import com.example.cadres.utils.SPUtils;
import com.example.cadres.utils.rxbus.RxBus2;
import com.example.cadres.utils.rxbus.rxbusEvent.VoteEvent;
import com.example.cadres.view.login.LoginActivity;

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

        tv_btn = findViewById(R.id.tv_btn);

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
                final Map<String, String> params = new HashMap<>();
                int numYes = 0;
                int numNo = 0;
                StringBuffer namesNo = new StringBuffer("");
                int numNone = 0;
                StringBuffer namesNone = new StringBuffer("");
                for (int i = 0; i< mAdapter.getData().size();i++){
                    YjjcVoteListBean item =  mAdapter.getData().get(i);
                    if(item.getMyVote() == 0){
                        showShortToast("请完成选择后再进行票决");
                        return;
                    }
                    params.put(item.getVoteId() + "",item.getMyVote() + "");

                    if(item.getMyVote() == 1) numYes++;
                    if(item.getMyVote() == 2) {numNo++; namesNo.append(item.getCadreName() + "，");}
                    if(item.getMyVote() == 3) {numNone++; namesNone.append(item.getCadreName() + "，");}
                }

                String content = getDialogContent(numYes,numNo,numNone,namesNo,namesNone);
                DialogUtil.getInstance().getDefaultDialog(context, content, new DialogUtil.DialogCallBack() {
                    @Override
                    public void exectEvent(DialogInterface alterDialog) {
                        mPresenter.sendYjjcVote(params);
                    }
                }).show();
            }
        });
    }

    public String getDialogContent(int numYes,int numNo,int numNone,StringBuffer namesNo,StringBuffer namesNone){
        if(numNo == 0 && numNone == 0)
            return "同意"+numYes+"人、不同意"+numNo+"人、弃权"+numNone+"人";
        String content = "同意"+numYes+"人、不同意"+numNo+"人、弃权"+numNone+"人";
        if(numNo > 0)
            content = content + "\n" +"不同意人员：" + "\n" + namesNo.toString().substring(0,namesNo.toString().length() - 1);
        if(numNone > 0)
            content = content + "\n" +"弃权人员：" + "\n" + namesNone.toString().substring(0,namesNone.toString().length() - 1);
        return content;
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
        tv_btn.setVisibility(View.GONE);
        RxBus2.getInstance().post(new VoteEvent());

        state = 1;
        mPresenter.getYjjcVoteList(schemeId,MySelfInfo.getInstance().getUserId());
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
