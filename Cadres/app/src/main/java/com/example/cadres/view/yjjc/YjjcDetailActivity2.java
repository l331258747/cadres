package com.example.cadres.view.yjjc;

import android.content.Intent;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cadres.greendao.gen.DBYjjcCadreDao;
import com.cadres.greendao.gen.DBYjjcMeetingDao;
import com.cadres.greendao.gen.DbYjjcBeanDao;
import com.cadres.greendao.gen.DbYjjcCadreGroupingDao;
import com.example.cadres.R;
import com.example.cadres.adapter.ListDialogAdapter;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.base.BaseFragmentAdapter;
import com.example.cadres.bean.common.ListDialogBean;
import com.example.cadres.bean.yjjc.AppointDismissCadreGroupingListBean;
import com.example.cadres.bean.yjjc.AppointDismissCadreVoListBean;
import com.example.cadres.bean.yjjc.AppointDismissMeetingListBean;
import com.example.cadres.bean.yjjc.YjjcBean;
import com.example.cadres.beanDB.DBYjjcCadre;
import com.example.cadres.beanDB.DBYjjcCadre3;
import com.example.cadres.beanDB.DBYjjcMeeting;
import com.example.cadres.beanDB.DbYjjcBean;
import com.example.cadres.beanDB.DbYjjcCadreGrouping;
import com.example.cadres.dialog.DefaultDialog;
import com.example.cadres.dialog.ListDialog;
import com.example.cadres.mvp.YjjcDetailContract;
import com.example.cadres.mvp.YjjcDetailPresenter;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoManager;
import com.example.cadres.utils.greendao.DaoUtilsStore;
import com.example.cadres.utils.myData.GbDrawerData;
import com.google.android.material.tabs.TabLayout;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class YjjcDetailActivity2 extends BaseActivity implements YjjcDetailContract.View, View.OnClickListener {

    TabLayout mTabLayout;
    ViewPager mViewPager;
    TextView tv_dialog;

    private String[] titles = {"任免会议详情", "任免干部名册"};

    String type;

    CommonDaoUtils<DbYjjcBean> dBYjjcDaoUtils;
    CommonDaoUtils<DBYjjcCadre> dBYjjcCadreDaoUtils;
    CommonDaoUtils<DBYjjcMeeting> dBYjjcMeetingDaoUtils;
    CommonDaoUtils<DbYjjcCadreGrouping> dbYjjcCadreGroupingDaoUtils;

    List<DbYjjcBean> dbYjjcBeans;
    List<DBYjjcCadre3> dbYjjcCadres;
    DBYjjcMeeting dbYjjcMeeting;

    List<ListDialogBean> dialogDatas;
    ListDialog listDialog;

    YjjcMettingFragment yjjcMettingFragment;
    YjjcCadreFragment2 yjjcCadreFragment;

//    public Disposable VoteDisposable;
    YjjcDetailPresenter mPresenter;
    int schemeId;

    DrawerLayout drawer_layout;
    NestedScrollView scrollView;
    LinearLayout layout_info;
    GbDrawerData gbDrawerData;

    boolean isMeetingModel;

    @Override
    public int getLayoutId() {
        return R.layout.activity_yjjc_detail_drawer;
    }

    @Override
    public void initView() {

        type = intent.getStringExtra("type");
        isMeetingModel = intent.getBooleanExtra("isMeetingModel",false);

        if(!isMeetingModel){
            showLeftIcon();
            showLLRightGoHome();
        }else{
            if(TextUtils.equals(type,"市委常委会议")){
                showLLRightUpData();
                getTvRight1().setText("同步票决数据");
                getLLRight1().setOnClickListener(this);
            }
        }

        showTitleTv("任免决策详情");

        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.viewpager);
        tv_dialog = findViewById(R.id.tv_dialog);

        tv_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listDialog == null){
                    listDialog = new ListDialog(context, dialogDatas);
                    listDialog.setItemClickListener(new ListDialogAdapter.OnItemClickListener() {
                        @Override
                        public void onClick(int position) {
                            tv_dialog.setText(dialogDatas.get(position).getName());
                            schemeId = dialogDatas.get(position).getId();
                            getDbMeetingList(schemeId,type);
                            getDbCadreingList(schemeId);
                            yjjcMettingFragment.setData(dbYjjcMeeting);
                            yjjcCadreFragment.setData(schemeId,dbYjjcCadres,type);
                            listDialog.dismiss();
                        }
                    });
                }
                listDialog.show();
            }
        });


        List<Fragment> mFragments = new ArrayList<>();
        mFragments.add(yjjcMettingFragment = (YjjcMettingFragment) YjjcMettingFragment.newInstance());
        mFragments.add(yjjcCadreFragment = (YjjcCadreFragment2) YjjcCadreFragment2.newInstance(isMeetingModel));

        BaseFragmentAdapter adapter = new BaseFragmentAdapter(getSupportFragmentManager(), mFragments, titles);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(titles.length - 1);
        mTabLayout.setupWithViewPager(mViewPager);

        initDrawer();
        initDrawerGbInfo();
    }

    @Override
    public void onBackPressed() {
        if(!isMeetingModel)
            super.onBackPressed();
    }

    @Override
    public void initData() {

        mPresenter = new YjjcDetailPresenter(context,this);

        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
        dBYjjcDaoUtils = _Store.getYjjcDaoUtils();
        dBYjjcMeetingDaoUtils = _Store.getYjjcMeetingDaoUtils();
        dBYjjcCadreDaoUtils = _Store.getYjjcCadreDaoUtils();
        dbYjjcCadreGroupingDaoUtils = _Store.getYjjcCadreGroupingDaoUtils();

        getDbList(type);
        dialogDatas = new ArrayList<>();
        for (int i=0;i<dbYjjcBeans.size();i++){
            DbYjjcBean item = dbYjjcBeans.get(i);
            dialogDatas.add(new ListDialogBean(item.getSchemeId(),item.getSchemeTime()));
        }

        if(dbYjjcBeans !=null && dbYjjcBeans.size() > 0){
            schemeId = dbYjjcBeans.get(0).getSchemeId();
            getDbMeetingList(schemeId,type);
            getDbCadreingList(schemeId);
            yjjcMettingFragment.setData(dbYjjcMeeting);
            yjjcCadreFragment.setData(schemeId, dbYjjcCadres,type);

            tv_dialog.setText(dbYjjcBeans.get(0).getSchemeTime());
        }

//        VoteDisposable = RxBus2.getInstance().toObservable(VoteEvent.class, new Consumer<VoteEvent>() {
//            @Override
//            public void accept(VoteEvent voteEvent) throws Exception {
//                mPresenter.getYjjcList();
//            }
//        });
    }

    public void getDbList(String meetingType) {
        List<DbYjjcBean> dbList = new ArrayList<>();

//        dbList = dBYjjcDaoUtils.queryAll();
//        LogUtil.e("数据库条数：" + dbList.size());

        DbYjjcBeanDao dbYjjcBeanDao = DaoManager.getInstance().getDaoSession().getDbYjjcBeanDao();
        QueryBuilder<DbYjjcBean> queryBuilder = dbYjjcBeanDao.queryBuilder();
        queryBuilder.join(DbYjjcBeanDao.Properties.SchemeId, DBYjjcMeeting.class, DBYjjcMeetingDao.Properties.SchemeId)
                .where(DBYjjcMeetingDao.Properties.MeetingType.eq(meetingType));
        queryBuilder.distinct();
        dbList = queryBuilder.list();

        dbYjjcBeans = dbList;
    }

    public void getDbMeetingList(int schemeId, String meetingType) {
        List<DBYjjcMeeting> dbList = new ArrayList<>();
        DBYjjcMeetingDao dbYjjcMeetingDao = DaoManager.getInstance().getDaoSession().getDBYjjcMeetingDao();
        QueryBuilder<DBYjjcMeeting> queryBuilder = dbYjjcMeetingDao.queryBuilder();
        if(schemeId == 0){
            queryBuilder.where(DBYjjcMeetingDao.Properties.MeetingType.eq(meetingType));
        }else{
            queryBuilder.where(DBYjjcMeetingDao.Properties.MeetingType.eq(meetingType),DBYjjcMeetingDao.Properties.SchemeId.eq(schemeId));
        }
        dbList = queryBuilder.list();
        LogUtil.e("数据库条数：" + dbList.size());

//        String sql;
//        String[] condition;
//        if(schemeId == 0){
//            queryBuilder.where(DBYjjcMeetingDao.Properties.MeetingType.eq(meetingType));
//            sql = "where MEETING_TYPE = ?";
//            condition = new String[]{meetingType};
//        }else{
//            sql = "where MEETING_TYPE = ? and SCHEME_ID = ?";
//            condition = new String[]{meetingType,schemeId + ""};
//        }
//        dbList = dBYjjcMeetingDaoUtils.queryByNativeSql(sql, condition);
//        LogUtil.e("数据库条数：" + dbList.size());

        if(dbList.size() > 0)
            dbYjjcMeeting =  dbList.get(0);
    }

    public void getDbCadreingList(int schemeId){
        List<DBYjjcCadre3> list = new ArrayList<>();

        List<DbYjjcCadreGrouping> dbListGrouping = new ArrayList<>();
        DbYjjcCadreGroupingDao dbYjjcCadreGroupingDao = DaoManager.getInstance().getDaoSession().getDbYjjcCadreGroupingDao();
        QueryBuilder<DbYjjcCadreGrouping> queryBuilderGrouping = dbYjjcCadreGroupingDao.queryBuilder();
        queryBuilderGrouping.where(DbYjjcCadreGroupingDao.Properties.SchemeId.eq(schemeId));
        dbListGrouping = queryBuilderGrouping.list();

        for (int i =0;i<dbListGrouping.size();i++){
            DBYjjcCadre3 item = new DBYjjcCadre3();
            DbYjjcCadreGrouping itemGrouping = dbListGrouping.get(i);
            item.setGroupingName(itemGrouping.getGroupingName());
            item.setGroupingId(itemGrouping.getGroupingId());

            List<DBYjjcCadre> dbList = new ArrayList<>();
            DBYjjcCadreDao dbYjjcCadreDao = DaoManager.getInstance().getDaoSession().getDBYjjcCadreDao();
            QueryBuilder<DBYjjcCadre> queryBuilder = dbYjjcCadreDao.queryBuilder();
            if(TextUtils.equals("书记专题会议",type)){
                queryBuilder.where(DBYjjcCadreDao.Properties.SchemeId.eq(schemeId), DBYjjcCadreDao.Properties.AppointDismissResult.notEq(2),DBYjjcCadreDao.Properties.GroupingId.eq(itemGrouping.getGroupingId()));
            }else if(TextUtils.equals("市委常委会议",type)){
                queryBuilder.where(DBYjjcCadreDao.Properties.SchemeId.eq(schemeId), DBYjjcCadreDao.Properties.AppointDismissResult.notEq(2),DBYjjcCadreDao.Properties.AppointDismissResult.notEq(3),DBYjjcCadreDao.Properties.GroupingId.eq(itemGrouping.getGroupingId()));
            }else{
                queryBuilder.where(DBYjjcCadreDao.Properties.SchemeId.eq(schemeId),DBYjjcCadreDao.Properties.GroupingId.eq(itemGrouping.getGroupingId()));
            }
            dbList = queryBuilder.list();
            item.setList(dbList);
            list.add(item);
        }

        DBYjjcCadre3 item = new DBYjjcCadre3();
        if(list.size() == 0){
            item.setGroupingName("");
        }else{
            item.setGroupingName("无分组");
        }

        List<DBYjjcCadre> dbList = new ArrayList<>();
        DBYjjcCadreDao dbYjjcCadreDao = DaoManager.getInstance().getDaoSession().getDBYjjcCadreDao();
        QueryBuilder<DBYjjcCadre> queryBuilder = dbYjjcCadreDao.queryBuilder();
        if(TextUtils.equals("书记专题会议",type)){
            queryBuilder.where(DBYjjcCadreDao.Properties.SchemeId.eq(schemeId), DBYjjcCadreDao.Properties.AppointDismissResult.notEq(2),DBYjjcCadreDao.Properties.GroupingId.notIn(getGroupingId(dbListGrouping)));
        }else if(TextUtils.equals("市委常委会议",type)){
            queryBuilder.where(DBYjjcCadreDao.Properties.SchemeId.eq(schemeId), DBYjjcCadreDao.Properties.AppointDismissResult.notEq(2),DBYjjcCadreDao.Properties.AppointDismissResult.notEq(3),DBYjjcCadreDao.Properties.GroupingId.notIn(getGroupingId(dbListGrouping)));
        }else{
            queryBuilder.where(DBYjjcCadreDao.Properties.SchemeId.eq(schemeId),DBYjjcCadreDao.Properties.GroupingId.notIn(getGroupingId(dbListGrouping)));
        }
        dbList = queryBuilder.list();
        item.setList(dbList);

        if(dbList.size() > 0){
            list.add(item);
        }

        LogUtil.e("数据库条数：" + list.size());
        dbYjjcCadres =  list;
    }

    public List<Integer> getGroupingId(List<DbYjjcCadreGrouping> list){
        List<Integer> sList = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            sList.add(list.get(i).getGroupingId());
        }
        return sList;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if(VoteDisposable !=null && !VoteDisposable.isDisposed())
//            VoteDisposable.dispose();
    }

    @Override
    public void getYjjcListSuccess(List<YjjcBean.YjjcBean2> data) {
        setDBYjjc(data);

        getDbCadreingList(schemeId);

        if(dbYjjcBeans !=null && dbYjjcBeans.size() > 0)
            yjjcCadreFragment.setData(schemeId, dbYjjcCadres,type);

        showShortToast("同步成功");
    }

    @Override
    public void getYjjcListFailed(String msg) {
        showShortToast("同步失败");
        LogUtil.e(msg);
    }

    public void setDBYjjc(List<YjjcBean.YjjcBean2> data){
        List<DbYjjcBean> dbList = new ArrayList<>();
        List<DBYjjcCadre> dbList_cadre = new ArrayList<>();
        List<DBYjjcMeeting> dbList_meeting = new ArrayList<>();
        List<DbYjjcCadreGrouping> dbList_grouping = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            YjjcBean.YjjcBean2 item = data.get(i);
            dbList.add(new DbYjjcBean(
                    null,
                    item.getSchemeId(),
                    item.getSchemeName(),
                    item.getSchemeTime(),
                    item.getSchemeDescribe()
            ));

            for (int i_cadre = 0; i_cadre < data.get(i).getAppointDismissCadreVoList().size(); i_cadre++) {
                AppointDismissCadreVoListBean item_cadre = data.get(i).getAppointDismissCadreVoList().get(i_cadre);
                dbList_cadre.add(new DBYjjcCadre(
                        null,
                        item_cadre.getRemark(),
                        item_cadre.getDeptCode(),
                        item_cadre.getDismissCadreId(),
                        item_cadre.getSchemeId(),
                        item_cadre.getSchemeName(),
                        item_cadre.getBaseId(),
                        item_cadre.getCadreName(),
                        item_cadre.getGender(),
                        item_cadre.getNation(),
                        item_cadre.getNativePlace(),
                        item_cadre.getCurrentEducation(),
                        item_cadre.getFullTimeEducation(),
                        item_cadre.getCurrentMajor(),
                        item_cadre.getFullTimeMajor(),
                        item_cadre.getCurrentDegreeName(),
                        item_cadre.getFullTimeDegreeName(),
                        item_cadre.getTechnicalTitle(),
                        item_cadre.getBirthday(),
                        item_cadre.getAge(),
                        item_cadre.getWorkTime(),
                        item_cadre.getJoinPartyDate(),
                        item_cadre.getCurrentPositionTime(),
                        item_cadre.getCurrentRankTime(),
                        item_cadre.getTalkNumber(),
                        item_cadre.getTalkGainNumber(),
                        item_cadre.getRecommendNumber(),
                        item_cadre.getRecommendGainNumber(),
                        item_cadre.getCurrentPosition(),
                        item_cadre.getAspiringPosition(),
                        item_cadre.getJwOpinion(),
                        item_cadre.getZzbOpinion(),
                        item_cadre.getValidTicket(),
                        item_cadre.getGainVotes(),
                        item_cadre.getCwhOpinion(),
                        item_cadre.getAppointDismissResult(),
                        item_cadre.getAppointDismissType(),
                        item_cadre.getAppointPosition(),
                        item_cadre.getAppointPositionName(),
                        item_cadre.getAppointDeptId(),
                        item_cadre.getAppointDeptName(),
                        item_cadre.getPositionTime(),
                        item_cadre.getPositionReason(),
                        item_cadre.getPositionFileNumber(),
                        item_cadre.getDismissPosition(),
                        item_cadre.getDismissPositionName(),
                        item_cadre.getDismissDeptId(),
                        item_cadre.getDismissDeptName(),
                        item_cadre.getLeaveTime(),
                        item_cadre.getLeaveReason(),
                        item_cadre.getLeaveFileNumber(),
                        item_cadre.getCurrentRank(),
                        item_cadre.getMeetingDescribe(),
                        item_cadre.getRanking(),
                        item_cadre.getVacantPosition(),
                        item_cadre.getInspectFileName(),
                        item_cadre.getGroupingId(),
                        item_cadre.getGroupingName()
                ));
            }

            for (int i_meeting = 0; i_meeting < data.get(i).getAppointDismissMeetingList().size(); i_meeting++) {
                AppointDismissMeetingListBean item_meeting = data.get(i).getAppointDismissMeetingList().get(i_meeting);
                dbList_meeting.add(new DBYjjcMeeting(
                        null,
                        item_meeting.getMeetingId(),
                        item_meeting.getSchemeId(),
                        item_meeting.getSchemeName(),
                        item_meeting.getMeetingSummary(),
                        item_meeting.getMeetingName(),
                        item_meeting.getMeetingType(),
                        item_meeting.getMeetingTime(),
                        item_meeting.getMeetingUser(),
                        item_meeting.getMeetingDescribe(),
                        item_meeting.getMaterialFileName()
                ));
            }

            for (int i_grouping = 0; i_grouping < data.get(i).getAppointDismissCadreGroupingList().size(); i_grouping++) {
                AppointDismissCadreGroupingListBean item_grouping = data.get(i).getAppointDismissCadreGroupingList().get(i_grouping);
                dbList_grouping.add(new DbYjjcCadreGrouping(
                        null,
                        item_grouping.getGroupingId(),
                        item_grouping.getSchemeId(),
                        item_grouping.getGroupingName(),
                        item_grouping.getGroupingRanking()
                ));
            }
        }

        dBYjjcDaoUtils.deleteAll();
        dBYjjcCadreDaoUtils.deleteAll();
        dBYjjcMeetingDaoUtils.deleteAll();
        dbYjjcCadreGroupingDaoUtils.deleteAll();

        dBYjjcDaoUtils.insertMulti(dbList);
        dBYjjcCadreDaoUtils.insertMulti(dbList_cadre);
        dBYjjcMeetingDaoUtils.insertMulti(dbList_meeting);
        dbYjjcCadreGroupingDaoUtils.insertMulti(dbList_grouping);
    }

    private void initDrawer(){
        drawer_layout = findViewById(R.id.drawer_layout);
        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);//关闭手势滑动
        drawer_layout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);//关闭手势滑动
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED); //打开手势滑动
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });
    }

    private void initDrawerGbInfo(){
        scrollView = findViewById(R.id.scrollView);
        layout_info = findViewById(R.id.layout_info);
        gbDrawerData = new GbDrawerData(context, layout_info);
        gbDrawerData.initView();
    }

    public void showGbinfo(int baseId){
        if(isMeetingModel) return;

        gbDrawerData.getData(baseId);
        scrollView.scrollTo(0,0);
        drawer_layout.openDrawer(Gravity.RIGHT);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, YjjcDetailActivity2.class);
        intent.putExtra("isMeetingModel", isMeetingModel);
        //会议类型（1部务会议，2书记专题会议，3市委常委会议）
        switch (view.getId()) {
            case R.id.ll_right1:
                new DefaultDialog(context).setContent("您是否确认同步票决数据？").setSubmitListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mPresenter.getYjjcList();
                    }
                }).show();
                break;
        }
    }
}
