package com.example.cadres.view.dsjty;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.example.cadres.R;
import com.example.cadres.base.BaseActivity;

public class DsjtySelectActivity extends BaseActivity implements View.OnClickListener{
    ImageView iv_ldgb_bg,iv_zjgwy_bg;

    @Override
    public int getLayoutId() {
        return R.layout.activity_dsjty_select;
    }

    @Override
    public void initView() {
        showLeftIcon();
        showLLRightGoHome();
        showTitleTv("大数据推演");

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
        Intent intent = new Intent(context, DsjtyActivity.class);
        //类型（1领导干部，2职级公务员，3后备干部）
        switch (view.getId()){
            case R.id.iv_ldgb_bg:
                intent.putExtra("type","1");
                startActivity(intent);
                break;
            case R.id.iv_zjgwy_bg:
                intent.putExtra("type","2");
                startActivity(intent);
                break;
        }
    }
}
