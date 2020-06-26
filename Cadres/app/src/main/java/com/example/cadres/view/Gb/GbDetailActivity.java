package com.example.cadres.view.Gb;

import com.example.cadres.R;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.base.BaseFragmentAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class GbDetailActivity extends BaseActivity {

    TabLayout mTabLayout;
    ViewPager mViewPager;

    private String[] titles = {"干部基本信息", "工作简历", "现任职信息", "曾任职信息","职级信息","家庭成员","奖惩记录","培训情况"};

    int baseId;

    @Override
    public int getLayoutId() {
        return R.layout.activity_gb_detail;
    }

    @Override
    public void initView() {

        showLeftIcon();
        showLLRightGoHome();
        showTitleTv("干部详情");

        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.viewpager);

        baseId = intent.getIntExtra("ID",0);

    }

    @Override
    public void initData() {

        List<Fragment> mFragments = new ArrayList<>();
        mFragments.add(GbInfoFragment.newInstance(baseId));
        mFragments.add(GbResumeFragment.newInstance(baseId));
        mFragments.add(GbNowFragment.newInstance(baseId));
        mFragments.add(GbHistoryFragment.newInstance(baseId));
        mFragments.add(GbRankFragment.newInstance(baseId));
        mFragments.add(GbFamilyFragment.newInstance(baseId));
        mFragments.add(GbAwardFragment.newInstance(baseId));
        mFragments.add(GbTrainFragment.newInstance(baseId));

        BaseFragmentAdapter adapter = new BaseFragmentAdapter(getSupportFragmentManager(), mFragments, titles);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(titles.length - 1);
        mTabLayout.setupWithViewPager(mViewPager);

    }
}
