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

    Group group_table1,group_table2,group_table3;
    ImageView iv_title_left1,iv_title_center1,iv_title_right1;
    TextView tv_title_left1,tv_title_center1,tv_title_right1;
    ImageView iv_title_left2,iv_title_center2;
    TextView tv_title_left2,tv_title_center2;
    TextView tv_title_center3;

    View view_back, view_home;

    String type;

    NoScrollViewPager mViewPager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_dsjty2;
    }

    @Override
    public void initView() {
        type = intent.getStringExtra("type");

        hideTitleLayout();

        StatusBarUtil.setStatusBar(this, getResources().getColor(R.color.color_0b1342));

        mViewPager = findViewById(R.id.viewpager);

        group_table1 = findViewById(R.id.group_table1);
        group_table2 = findViewById(R.id.group_table2);
        group_table3 = findViewById(R.id.group_table3);

        iv_title_left1 = findViewById(R.id.iv_title_left1);
        iv_title_center1 = findViewById(R.id.iv_title_center1);
        iv_title_right1 = findViewById(R.id.iv_title_right1);
        tv_title_left1 = findViewById(R.id.tv_title_left1);
        tv_title_center1 = findViewById(R.id.tv_title_center1);
        tv_title_right1 = findViewById(R.id.tv_title_right1);

        iv_title_left2 = findViewById(R.id.iv_title_left2);
        iv_title_center2 = findViewById(R.id.iv_title_center2);
        tv_title_left2 = findViewById(R.id.tv_title_left2);
        tv_title_center2 = findViewById(R.id.tv_title_center2);

        tv_title_center3 = findViewById(R.id.tv_title_center3);

        view_back = findViewById(R.id.view_back);
        view_home = findViewById(R.id.view_home);
        view_home.setOnClickListener(this);
        view_back.setOnClickListener(this);
        iv_title_left1.setOnClickListener(this);
        iv_title_center1.setOnClickListener(this);
        iv_title_right1.setOnClickListener(this);
        iv_title_left2.setOnClickListener(this);
        iv_title_center2.setOnClickListener(this);
    }

    @Override
    public void initData() {
        group_table1.setVisibility(View.GONE);
        group_table2.setVisibility(View.GONE);
        group_table3.setVisibility(View.GONE);

        List<Fragment> mFragments = new ArrayList<>();
        if(TextUtils.equals(this.type,"1")){
            group_table1.setVisibility(View.VISIBLE);

            mFragments.add(DsjtyZjFragment.newInstance(type));
            mFragments.add(DsjtyJgFragment2.newInstance(type));
            mFragments.add(DsjtyHjFragment.newInstance(type));
        }else if(TextUtils.equals(this.type,"2")){
            group_table2.setVisibility(View.VISIBLE);

            mFragments.add(DsjtyZjFragment.newInstance(type));
            mFragments.add(DsjtyJgFragment2.newInstance(type));
        }else if(TextUtils.equals(this.type,"3")){
            group_table3.setVisibility(View.VISIBLE);

            mFragments.add(DsjtyJgFragment2.newInstance(type));
        }

        BaseFragmentAdapter adapter = new BaseFragmentAdapter(getSupportFragmentManager(), mFragments, null);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(mFragments.size() - 1);

        setType(1);

    }

    //------------------------------父类界面设置
    public void setType(int pos) {
        clean();

        if(TextUtils.equals(type,"1")) {
            if(pos == 1){
                mViewPager.setCurrentItem(0);
                iv_title_left1.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_left));
                tv_title_left1.setTextColor(ContextCompat.getColor(context, R.color.white));
            }else if(pos == 2){
                mViewPager.setCurrentItem(1);
                iv_title_center1.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_center));
                tv_title_center1.setTextColor(ContextCompat.getColor(context, R.color.white));
            }else if(pos == 3){
                mViewPager.setCurrentItem(2);
                iv_title_right1.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_right));
                tv_title_right1.setTextColor(ContextCompat.getColor(context, R.color.white));
            }
        }else if(TextUtils.equals(type,"2")){//公务员
            if(pos == 1){
                mViewPager.setCurrentItem(0);
                iv_title_left2.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_left));
                tv_title_left2.setTextColor(ContextCompat.getColor(context, R.color.white));
            }else if(pos == 2){
                mViewPager.setCurrentItem(1);
                iv_title_center2.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_right));
                tv_title_center2.setTextColor(ContextCompat.getColor(context, R.color.white));
            }
        }else if(TextUtils.equals(type,"3")){
            if(pos == 1){
                mViewPager.setCurrentItem(0);
                tv_title_center3.setTextColor(ContextCompat.getColor(context, R.color.white));
            }
        }
    }

    private void clean() {
        if(TextUtils.equals(type,"1")) {
            tv_title_left1.setTextColor(ContextCompat.getColor(context, R.color.color_23cffd));
            tv_title_center1.setTextColor(ContextCompat.getColor(context, R.color.color_23cffd));
            tv_title_right1.setTextColor(ContextCompat.getColor(context, R.color.color_23cffd));

            iv_title_left1.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_left_un));
            iv_title_center1.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_center_un));
            iv_title_right1.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_right_un));
        }else if(TextUtils.equals(type,"2")){//公务员
            tv_title_left2.setTextColor(ContextCompat.getColor(context, R.color.color_23cffd));
            tv_title_center2.setTextColor(ContextCompat.getColor(context, R.color.color_23cffd));

            iv_title_left2.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_left_un));
            iv_title_center2.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_right_un));
        }else if(TextUtils.equals(type,"3")){
            tv_title_center3.setTextColor(ContextCompat.getColor(context, R.color.color_23cffd));
        }
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
            case R.id.iv_title_left1:
            case R.id.iv_title_left2:
                setType(1);
                break;
            case R.id.iv_title_center1:
            case R.id.iv_title_center2:
                setType(2);
                break;
            case R.id.iv_title_right1:
                setType(3);
                break;
        }
    }
}
