package com.example.cadres.view.yjjc;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.adapter.ListDialogAdapter;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.base.BaseFragmentAdapter;
import com.example.cadres.bean.common.ListDialogBean;
import com.example.cadres.bean.yjjc.AppointDismissCadreVoListBean;
import com.example.cadres.bean.yjjc.AppointDismissMeetingListBean;
import com.example.cadres.bean.yjjc.YjjcBean;
import com.example.cadres.beanDB.DBYjjcCadre;
import com.example.cadres.beanDB.DBYjjcMeeting;
import com.example.cadres.beanDB.DbYjjcBean;
import com.example.cadres.dialog.ListDialog;
import com.example.cadres.mvp.YjjcDetailContract;
import com.example.cadres.mvp.YjjcDetailPresenter;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoUtilsStore;
import com.example.cadres.utils.rxbus.RxBus2;
import com.example.cadres.utils.rxbus.rxbusEvent.VoteEvent;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class YjjcDetailActivity extends BaseActivity implements YjjcDetailContract.View {

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

    public Disposable VoteDisposable;
    YjjcDetailPresenter mPresenter;
    int schemeId;

    @Override
    public int getLayoutId() {
        return R.layout.activity_yjjc_detail;
    }

    @Override
    public void initView() {
        showLeftIcon();
        showLLRightGoHome();
        showTitleTv("任免决策详情");

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
        mFragments.add(yjjcCadreFragment = (YjjcCadreFragment) YjjcCadreFragment.newInstance());

        BaseFragmentAdapter adapter = new BaseFragmentAdapter(getSupportFragmentManager(), mFragments, titles);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(titles.length - 1);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public void initData() {

        mPresenter = new YjjcDetailPresenter(context,this);

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

        if(dbYjjcBeans !=null && dbYjjcBeans.size() > 0){
            schemeId = dbYjjcBeans.get(0).getSchemeId();
            getDbMeetingList(schemeId,type);
            getDbCadreingList(schemeId);
            yjjcMettingFragment.setData(dbYjjcMeeting);
            yjjcCadreFragment.setData(schemeId, dbYjjcCadres,type);
        }

        if(dbYjjcMeeting != null)
            tv_dialog.setText(dbYjjcMeeting.getSchemeName());


        VoteDisposable = RxBus2.getInstance().toObservable(VoteEvent.class, new Consumer<VoteEvent>() {
            @Override
            public void accept(VoteEvent voteEvent) throws Exception {
                mPresenter.getYjjcList();
            }
        });
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
    }

    public void getDbCadreingList(int schemeId){
        List<DBYjjcCadre> dbList = new ArrayList<>();
        String sql;
        String[] condition;
        if(TextUtils.equals("书记专题会议",type)){
            sql = "where SCHEME_ID = ? and APPOINT_DISMISS_RESULT <> ?";
            condition = new String[]{schemeId + "", 2 + ""};
        }else if(TextUtils.equals("市委常委会议",type)){
            sql = "where SCHEME_ID = ? and (APPOINT_DISMISS_RESULT <> ? and APPOINT_DISMISS_RESULT <> ?)";
            condition = new String[]{schemeId + "", 2 + "",3 + ""};
        }else{
            sql = "where SCHEME_ID = ?";
            condition = new String[]{schemeId + ""};
        }

        dbList = dBYjjcCadreDaoUtils.queryByNativeSql(sql, condition);
        LogUtil.e("数据库条数：" + dbList.size());

        dbYjjcCadres =  dbList;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(VoteDisposable !=null && !VoteDisposable.isDisposed())
            VoteDisposable.dispose();
    }

    @Override
    public void getYjjcListSuccess(List<YjjcBean.YjjcBean2> data) {
        setDBYjjc(data);

        getDbCadreingList(schemeId);

        if(dbYjjcBeans !=null && dbYjjcBeans.size() > 0)
            yjjcCadreFragment.setData(schemeId, dbYjjcCadres,type);
    }

    @Override
    public void getYjjcListFailed(String msg) {
        LogUtil.e(msg);
    }

    public void setDBYjjc(List<YjjcBean.YjjcBean2> data){
        List<DbYjjcBean> dbList = new ArrayList<>();
        List<DBYjjcCadre> dbList_cadre = new ArrayList<>();
        List<DBYjjcMeeting> dbList_meeting = new ArrayList<>();

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
                        item_cadre.getInspectFileName()
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
        }

        dBYjjcDaoUtils.deleteAll();
        dBYjjcCadreDaoUtils.deleteAll();
        dBYjjcMeetingDaoUtils.deleteAll();

        dBYjjcDaoUtils.insertMulti(dbList);
        dBYjjcCadreDaoUtils.insertMulti(dbList_cadre);
        dBYjjcMeetingDaoUtils.insertMulti(dbList_meeting);


    }
}
