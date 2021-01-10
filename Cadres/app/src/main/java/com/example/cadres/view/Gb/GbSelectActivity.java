package com.example.cadres.view.Gb;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.example.cadres.R;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.view.search.SearchActivity;

public class GbSelectActivity extends BaseActivity implements View.OnClickListener {

    ImageView iv_ldgb_bg,iv_zjgwy_bg,iv_hbgb_bg,iv_sygb_bg;

//    int upActivity;

    @Override
    public int getLayoutId() {
        return R.layout.activity_gb_select;
    }

    @Override
    public void initView() {
        showLeftIcon();
        showLLRightGoHome();
        showTitleTv("干部名册");

//        upActivity = intent.getIntExtra("upActivity",0);

        iv_ldgb_bg = $(R.id.iv_ldgb_bg);
        iv_zjgwy_bg = $(R.id.iv_zjgwy_bg);
        iv_hbgb_bg = $(R.id.iv_hbgb_bg);
        iv_sygb_bg = $(R.id.iv_sygb_bg);

        iv_ldgb_bg.setOnClickListener(this);
        iv_zjgwy_bg.setOnClickListener(this);
        iv_hbgb_bg.setOnClickListener(this);
        iv_sygb_bg.setOnClickListener(this);

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        Intent intent;
//        if(upActivity == 1){
//            intent = new Intent(context, SearchActivity.class);
//        }else{
//            intent = new Intent(context, GbActivity.class);
//        }

        intent = new Intent(context, GbActivity2.class);

        //类型（1领导干部，2职级公务员，3后备干部）
        switch (view.getId()){
            case R.id.iv_ldgb_bg:
                intent.putExtra("type","1");
                intent.putExtra("title","领导干部名册");
                startActivity(intent);
                break;
            case R.id.iv_zjgwy_bg:
                intent.putExtra("type","2");
                intent.putExtra("title","职级公务员名册");
                startActivity(intent);
                break;
            case R.id.iv_hbgb_bg:
                intent.putExtra("type","3");
                intent.putExtra("title","后备干部名册");
                startActivity(intent);
                break;
            case R.id.iv_sygb_bg:
                intent.putExtra("type","4");
                intent.putExtra("title","事业干部名册");
                startActivity(intent);
                break;
        }
    }
}
