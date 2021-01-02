package com.example.cadres.view.Bm;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.example.cadres.R;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.view.dsjty.DsjtyActivity;

public class BmSelectActivity extends BaseActivity implements View.OnClickListener {
    ImageView iv_ldgb_bg, iv_zjgwy_bg;

    @Override
    public int getLayoutId() {
        return R.layout.activity_bm_select;
    }

    @Override
    public void initView() {
        showLeftIcon();
        showLLRightGoHome();
        showTitleTv("市管职数配备表");


        iv_ldgb_bg = $(R.id.iv_ldgb_bg);
        iv_zjgwy_bg = $(R.id.iv_zjgwy_bg);

        iv_ldgb_bg.setOnClickListener(this);
        iv_zjgwy_bg.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();

        //类型（1领导干部，2职级公务员）
        switch (view.getId()) {
            case R.id.iv_ldgb_bg:
                intent = new Intent(context, BmActivity.class);
                intent.putExtra("type", "1");
                startActivity(intent);
                break;
            case R.id.iv_zjgwy_bg:
                intent = new Intent(context, BmGwyActivity.class);
                intent.putExtra("type", "2");
                startActivity(intent);
                break;
        }
    }
}
