package com.example.cadres.view.Gb;

import com.example.cadres.R;
import com.example.cadres.base.BaseActivity;

public class GbActivity extends BaseActivity {



    @Override
    public int getLayoutId() {
        return R.layout.activity_gb;
    }

    @Override
    public void initView() {
        showLeftIcon();
        showLLRightGoHome();
        showTitleTv("干部名册");

    }

    @Override
    public void initData() {
    }

}
