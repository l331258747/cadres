package com.example.cadres.view.yjjc;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.example.cadres.R;
import com.example.cadres.base.BaseActivity;

public class YjjcActivity extends BaseActivity implements View.OnClickListener {

    ImageView iv_bw_bg,iv_sjzt_bg,iv_swcw_bg;

    @Override
    public int getLayoutId() {
        return R.layout.activity_yjjc;
    }

    @Override
    public void initView() {
        showLeftIcon();
        showLLRightGoHome();
        showTitleTv("研究决策");

        iv_bw_bg = $(R.id.iv_bw_bg);
        iv_sjzt_bg = $(R.id.iv_sjzt_bg);
        iv_swcw_bg = $(R.id.iv_swcw_bg);

        iv_bw_bg.setOnClickListener(this);
        iv_sjzt_bg.setOnClickListener(this);
        iv_swcw_bg.setOnClickListener(this);

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context,YjjcDetailActivity.class);
        //会议类型（1部务会议，2书记专题会议，3市委常委会议）
        switch (view.getId()){
            case R.id.iv_bw_bg:
                intent.putExtra("type","部务会议");
                startActivity(intent);
                break;
            case R.id.iv_sjzt_bg:
                intent.putExtra("type","书记专题会议");
                startActivity(intent);
                break;
            case R.id.iv_swcw_bg:
                intent.putExtra("type","市委常委会议");
                startActivity(intent);
                break;
        }
    }
}
