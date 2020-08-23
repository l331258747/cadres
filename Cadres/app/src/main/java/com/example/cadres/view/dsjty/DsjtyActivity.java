package com.example.cadres.view.dsjty;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.base.ActivityCollect;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.base.BaseFragmentAdapter;
import com.example.cadres.utils.StatusBarUtil;
import com.example.cadres.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class DsjtyActivity extends BaseActivity implements View.OnClickListener {

    ImageView iv_title_left, iv_title_center, iv_title_right;
    TextView tv_title_left, tv_title_center, tv_title_right;
    View view_back, view_home;

    Group group_title_right;

    String type;

    NoScrollViewPager mViewPager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_dsjty;
    }

    @Override
    public void initView() {
        type = intent.getStringExtra("type");

        hideTitleLayout();

        StatusBarUtil.setStatusBar(this, getResources().getColor(R.color.color_0b1342));

        mViewPager = findViewById(R.id.viewpager);

        iv_title_left = findViewById(R.id.iv_title_left);
        iv_title_center = findViewById(R.id.iv_title_center);
        iv_title_right = findViewById(R.id.iv_title_right);
        tv_title_left = findViewById(R.id.tv_title_left);
        tv_title_center = findViewById(R.id.tv_title_center);
        tv_title_right = findViewById(R.id.tv_title_right);
        group_title_right = findViewById(R.id.group_title_right);

        view_back = findViewById(R.id.view_back);
        view_home = findViewById(R.id.view_home);
        view_home.setOnClickListener(this);
        view_back.setOnClickListener(this);
        iv_title_left.setOnClickListener(this);
        iv_title_center.setOnClickListener(this);
        iv_title_right.setOnClickListener(this);

    }

    @Override
    public void initData() {
        List<Fragment> mFragments = new ArrayList<>();
        mFragments.add(DsjtyZjFragment.newInstance(type));
        mFragments.add(DsjtyJgFragment.newInstance(type));
        if(TextUtils.equals(this.type,"1")){
            mFragments.add(DsjtyHjFragment.newInstance(type));
        }

        BaseFragmentAdapter adapter = new BaseFragmentAdapter(getSupportFragmentManager(), mFragments, null);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(mFragments.size() - 1);

        setType(1);

    }

    //------------------------------父类界面设置
    public void setType(int type) {
        clean();
        if (type == 1) {
            mViewPager.setCurrentItem(0);
            iv_title_left.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_left));
            tv_title_left.setTextColor(ContextCompat.getColor(context, R.color.white));
        } else if (type == 2) {
            mViewPager.setCurrentItem(1);
            if(TextUtils.equals(this.type,"2")){
                iv_title_center.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_right));
            }else{
                iv_title_center.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_center));
            }
            tv_title_center.setTextColor(ContextCompat.getColor(context, R.color.white));
        } else if (type == 3) {
            mViewPager.setCurrentItem(2);
            iv_title_right.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_right));
            tv_title_right.setTextColor(ContextCompat.getColor(context, R.color.white));
        }

    }

    private void clean() {
        if(TextUtils.equals(type,"2")){
            iv_title_left.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_left_un));
            iv_title_center.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_right_un));
            group_title_right.setVisibility(View.GONE);
            tv_title_center.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);

        }else{
            iv_title_left.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_left_un));
            iv_title_center.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_center_un));
            iv_title_right.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_right_un));
        }

        tv_title_left.setTextColor(ContextCompat.getColor(context, R.color.color_23cffd));
        tv_title_center.setTextColor(ContextCompat.getColor(context, R.color.color_23cffd));
        tv_title_right.setTextColor(ContextCompat.getColor(context, R.color.color_23cffd));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.view_home:
                ActivityCollect.getAppCollect().finishAllNotHome();
                break;
            case R.id.view_back:
                finish();
                break;
            case R.id.iv_title_left:
                setType(1);
                break;
            case R.id.iv_title_center:
                setType(2);
                break;
            case R.id.iv_title_right:
                setType(3);
                break;
        }
    }
}
