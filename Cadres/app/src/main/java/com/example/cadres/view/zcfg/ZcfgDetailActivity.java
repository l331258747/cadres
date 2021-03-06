package com.example.cadres.view.zcfg;

import android.text.TextUtils;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.utils.StringUtils;

public class ZcfgDetailActivity extends BaseActivity {
    TextView tv_content;
    TextView tv_title;

    String content;

    @Override
    public int getLayoutId() {
        return R.layout.activity_zcfg_detail;
    }

    @Override
    public void initView() {

        showTitleTv("政策法规详情");
        showLeftIcon();
        showLLRightGoHome();

        tv_content = findViewById(R.id.tv_content);
        tv_title = findViewById(R.id.tv_title);
    }

    @Override
    public void initData() {
        tv_title.setText(intent.getStringExtra("title"));
        content = intent.getStringExtra("content");
        if(!TextUtils.isEmpty(content))
            StringUtils.setHtml(tv_content, content);
    }
}
