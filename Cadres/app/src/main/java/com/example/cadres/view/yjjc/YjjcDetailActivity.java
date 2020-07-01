package com.example.cadres.view.yjjc;

import android.view.View;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.adapter.ListDialogAdapter;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.base.BaseFragmentAdapter;
import com.example.cadres.bean.common.ListDialogBean;
import com.example.cadres.beanDB.DBYjjcCadre;
import com.example.cadres.beanDB.DBYjjcMeeting;
import com.example.cadres.beanDB.DbYjjcBean;
import com.example.cadres.dialog.ListDialog;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoUtilsStore;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class YjjcDetailActivity extends BaseActivity {

    TabLayout mTabLayout;
    ViewPager mViewPager;
    TextView tv_dialog;

    private String[] titles = {"任免会议详情", "任免干部名册"};

    String type;

    CommonDaoUtils<DbYjjcBean> dBYjjcDaoUtils;
    CommonDaoUtils<DBYjjcCadre> dBYjjcCadreDaoUtils;
    CommonDaoUtils<DBYjjcMeeting> dBYjjcMeetingDaoUtils;

    List<DbYjjcBean> dbYjjcBeans;
    List<DBYjjcCadre> dbYjjcCadres;
    DBYjjcMeeting dbYjjcMeeting;

    List<ListDialogBean> dialogDatas;
    ListDialog listDialog;

    YjjcMettingFragment yjjcMettingFragment;
    YjjcCadreFragment yjjcCadreFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_yjjc_detail;
    }

    @Override
    public void initView() {
        showLeftIcon();
        showLLRightGoHome();
        showTitleTv("研究决策详情");

        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.viewpager);
        tv_dialog = findViewById(R.id.tv_dialog);

        type = intent.getStringExtra("type");

        tv_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listDialog == null){
                    listDialog = new ListDialog(context, dialogDatas);
                    listDialog.setItemClickListener(new ListDialogAdapter.OnItemClickListener() {
                        @Override
                        public void onClick(int position) {
                            tv_dialog.setText(dialogDatas.get(position).getName());
                            getDbMeetingList(dialogDatas.get(position).getId(),type);
                            yjjcMettingFragment.setData(dbYjjcMeeting);
                            yjjcCadreFragment.setData(dbYjjcCadres);
                            listDialog.dismiss();
                        }
                    });
                }
                listDialog.show();
            }
        });


        List<Fragment> mFragments = new ArrayList<>();
        mFragments.add(yjjcMettingFragment = (YjjcMettingFragment) YjjcMettingFragment.newInstance());
        mFragments.add(yjjcCadreFragment = (YjjcCadreFragment) YjjcCadreFragment.newInstance());

        BaseFragmentAdapter adapter = new BaseFragmentAdapter(getSupportFragmentManager(), mFragments, titles);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(titles.length - 1);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public void initData() {

        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
        dBYjjcDaoUtils = _Store.getYjjcDaoUtils();
        dBYjjcMeetingDaoUtils = _Store.getYjjcMeetingDaoUtils();
        dBYjjcCadreDaoUtils = _Store.getYjjcCadreDaoUtils();

        getDbList();
        dialogDatas = new ArrayList<>();
        for (int i=0;i<dbYjjcBeans.size();i++){
            DbYjjcBean item = dbYjjcBeans.get(i);
            dialogDatas.add(new ListDialogBean(item.getSchemeId(),item.getSchemeNameTime()));
        }

        getDbMeetingList(0,type);
        yjjcMettingFragment.setData(dbYjjcMeeting);
        yjjcCadreFragment.setData(dbYjjcCadres);

        if(dbYjjcMeeting != null)
            tv_dialog.setText(dbYjjcMeeting.getSchemeName());
    }

    public void getDbList() {
        List<DbYjjcBean> dbList = new ArrayList<>();
        dbList = dBYjjcDaoUtils.queryAll();
        LogUtil.e("数据库条数：" + dbList.size());
        dbYjjcBeans = dbList;
    }

    public void getDbMeetingList(int schemeId, String meetingType) {
        List<DBYjjcMeeting> dbList = new ArrayList<>();
        String sql;
        String[] condition;
        if(schemeId == 0){
            sql = "where MEETING_TYPE = ?";
            condition = new String[]{meetingType};
        }else{
            sql = "where MEETING_TYPE = ? and SCHEME_ID = ?";
            condition = new String[]{meetingType,schemeId + ""};
        }
        dbList = dBYjjcMeetingDaoUtils.queryByNativeSql(sql, condition);
        LogUtil.e("数据库条数：" + dbList.size());

        if(dbList.size() > 0)
            dbYjjcMeeting =  dbList.get(0);

        if(dbYjjcMeeting !=null)
            getDbCadreingList(dbYjjcMeeting.getSchemeId());

    }

    public void getDbCadreingList(int schemeId){
        List<DBYjjcCadre> dbList = new ArrayList<>();
        String sql;
        String[] condition;
        sql = "where SCHEME_ID = ?";
        condition = new String[]{schemeId + ""};
        dbList = dBYjjcCadreDaoUtils.queryByNativeSql(sql, condition);
        LogUtil.e("数据库条数：" + dbList.size());

        dbYjjcCadres =  dbList;
    }





}
