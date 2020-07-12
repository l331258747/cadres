package com.example.cadres.view.other;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cadres.R;
import com.example.cadres.base.BaseActivity;
import com.github.chrisbanes.photoview.PhotoView;

public class PhotoImageActivity extends BaseActivity {

    PhotoView photoView;
    String imgUrl;
    TextView tv_content;

    @Override
    public int getLayoutId() {
        return R.layout.activity_photo_image;
    }

    @Override
    public void initView() {
        showLeftIcon();
        showLLRightGoHome();
        showTitleTv("附件");

        imgUrl = intent.getStringExtra("imgUrl");

        photoView = findViewById(R.id.photoView);
        tv_content = findViewById(R.id.tv_content);
    }

    @Override
    public void initData() {
        if(TextUtils.isEmpty(imgUrl)){
            tv_content.setVisibility(View.VISIBLE);
            photoView.setVisibility(View.GONE);
        }else{
            tv_content.setVisibility(View.GONE);
            photoView.setVisibility(View.VISIBLE);
            Glide.with(context).load(imgUrl).into(photoView);
        }
    }
}
