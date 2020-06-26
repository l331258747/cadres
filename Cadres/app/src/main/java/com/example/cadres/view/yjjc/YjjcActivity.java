package com.example.cadres.view.yjjc;

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

        iv_bw_bg.setOnClickListener(this);
        iv_sjzt_bg.setOnClickListener(this);
        iv_swcw_bg.setOnClickListener(this);

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_bw_bg:

                break;
            case R.id.iv_sjzt_bg:

                break;
            case R.id.iv_swcw_bg:

                break;
        }
    }
}
