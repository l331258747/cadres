package com.example.cadres.view.home;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.cadres.greendao.gen.DBGbBeanDao;
import com.cadres.greendao.gen.DBGbCadreAwardPunishListDao;
import com.cadres.greendao.gen.DBGbCadreDeptListBeanDao;
import com.cadres.greendao.gen.DBGbCadreFamilyMemberListDao;
import com.cadres.greendao.gen.DBGbCadreHistoryPositionListBeanDao;
import com.cadres.greendao.gen.DBGbCadreNowPositionListBeanDao;
import com.cadres.greendao.gen.DBGbCadreRankListBeanDao;
import com.cadres.greendao.gen.DBGbCadreResumeListBeanDao;
import com.cadres.greendao.gen.DBGbCadreTrainListBeanDao;
import com.example.cadres.R;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.Gb.GbBean;
import com.example.cadres.bean.Gb.GbCadreAwardPunishList;
import com.example.cadres.bean.Gb.GbCadreDeptListBean;
import com.example.cadres.bean.Gb.GbCadreFamilyMemberList;
import com.example.cadres.bean.Gb.GbCadreHistoryPositionListBean;
import com.example.cadres.bean.Gb.GbCadreNowPositionListBean;
import com.example.cadres.bean.Gb.GbCadreRankListBean;
import com.example.cadres.bean.Gb.GbCadreResumeListBean;
import com.example.cadres.bean.Gb.GbCadreTrainListBean;
import com.example.cadres.bean.bm.BmBean;
import com.example.cadres.bean.bm.BmExplainBean;
import com.example.cadres.bean.login.LoginBean;
import com.example.cadres.bean.login.MySelfInfo;
import com.example.cadres.bean.yjjc.AppointDismissCadreVoListBean;
import com.example.cadres.bean.yjjc.AppointDismissMeetingListBean;
import com.example.cadres.bean.yjjc.YjjcBean;
import com.example.cadres.bean.zcfg.ZcfgBean;
import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.beanDB.DBBmExplainBean;
import com.example.cadres.beanDB.DBGbBean;
import com.example.cadres.beanDB.DBGbCadreAwardPunishList;
import com.example.cadres.beanDB.DBGbCadreDeptListBean;
import com.example.cadres.beanDB.DBGbCadreFamilyMemberList;
import com.example.cadres.beanDB.DBGbCadreHistoryPositionListBean;
import com.example.cadres.beanDB.DBGbCadreNowPositionListBean;
import com.example.cadres.beanDB.DBGbCadreRankListBean;
import com.example.cadres.beanDB.DBGbCadreResumeListBean;
import com.example.cadres.beanDB.DBGbCadreTrainListBean;
import com.example.cadres.beanDB.DBYjjcCadre;
import com.example.cadres.beanDB.DBYjjcMeeting;
import com.example.cadres.beanDB.DBZcfgBean;
import com.example.cadres.beanDB.DbYjjcBean;
import com.example.cadres.dialog.DialogUtil;
import com.example.cadres.mvp.HomeContract;
import com.example.cadres.mvp.HomePresenter;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.SPUtils;
import com.example.cadres.utils.ToastUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoUtilsStore;
import com.example.cadres.view.Bm.BmActivity;
import com.example.cadres.view.Gb.GbActivity;
import com.example.cadres.view.dsjty.DsjtyActivity;
import com.example.cadres.view.search.SearchActivity;
import com.example.cadres.view.yjjc.YjjcActivity;
import com.example.cadres.view.zcfg.ZcfgActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity implements HomeContract.View, View.OnClickListener {

    EditText et_search;
    View view_mcb, view_gbmc, view_yjjc, view_zcfg, view_dsj;

    HomePresenter mPresenter;

    ProgressDialog progress;

    CommonDaoUtils<DBZcfgBean> dBZcfgDaoUtils;

    CommonDaoUtils<DBBmBean> dBBmDaoUtils;
    CommonDaoUtils<DBBmExplainBean> dBBmExplainDaoUtils;

    CommonDaoUtils<DBGbBean> dBGbDaoUtils;
    CommonDaoUtils<DBGbCadreAwardPunishList> dBGbAwardDaoUtils;
    CommonDaoUtils<DBGbCadreDeptListBean> dBGbDeptDaoUtils;
    CommonDaoUtils<DBGbCadreFamilyMemberList> dBGbFamilyDaoUtils;
    CommonDaoUtils<DBGbCadreHistoryPositionListBean> dBGbHistoryDaoUtils;
    CommonDaoUtils<DBGbCadreNowPositionListBean> dBGbNowDaoUtils;
    CommonDaoUtils<DBGbCadreRankListBean> dBGbRankDaoUtils;
    CommonDaoUtils<DBGbCadreResumeListBean> dBGbResumeDaoUtils;
    CommonDaoUtils<DBGbCadreTrainListBean> dBGbTrainDaoUtils;

    CommonDaoUtils<DbYjjcBean> dBYjjcDaoUtils;
    CommonDaoUtils<DBYjjcCadre> dBYjjcCadreDaoUtils;
    CommonDaoUtils<DBYjjcMeeting> dBYjjcMeetingDaoUtils;

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {
        showLLRightUpData();
        showLLRightOutOff();
        showTitleTv(getTitleName());

        view_mcb = findViewById(R.id.view_mcb);
        view_gbmc = findViewById(R.id.view_gbmc);
        view_yjjc = findViewById(R.id.view_yjjc);
        view_zcfg = findViewById(R.id.view_zcfg);
        view_dsj = findViewById(R.id.view_dsj);
        et_search = findViewById(R.id.et_search);

        getLLRight1().setOnClickListener(this);
        view_mcb.setOnClickListener(this);
        view_gbmc.setOnClickListener(this);
        view_yjjc.setOnClickListener(this);
        view_zcfg.setOnClickListener(this);
        view_dsj.setOnClickListener(this);
        et_search.setOnClickListener(this);

    }

    @Override
    public void initData() {
        SPUtils.getInstance().putBoolean(SPUtils.IS_LOGIN, true);

        mPresenter = new HomePresenter(context, this);

        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
        dBZcfgDaoUtils = _Store.getZcfgDaoUtils();
        dBBmDaoUtils = _Store.getBmDaoUtils();
        dBBmExplainDaoUtils = _Store.getBmExplainDaoUtils();

        dBGbDaoUtils = _Store.getGbDaoUtils();
        dBGbAwardDaoUtils = _Store.getGbAwardDaoUtils();
        dBGbDeptDaoUtils = _Store.getGbDeptDaoUtils();
        dBGbFamilyDaoUtils = _Store.getGbFamilyDaoUtils();
        dBGbHistoryDaoUtils = _Store.getGbHistoryDaoUtils();
        dBGbNowDaoUtils = _Store.getGbNowDaoUtils();
        dBGbRankDaoUtils = _Store.getGbRankDaoUtils();
        dBGbResumeDaoUtils = _Store.getGbResumeDaoUtils();
        dBGbTrainDaoUtils = _Store.getGbTrainDaoUtils();

        dBYjjcDaoUtils = _Store.getYjjcDaoUtils();
        dBYjjcCadreDaoUtils = _Store.getYjjcCadreDaoUtils();
        dBYjjcMeetingDaoUtils = _Store.getYjjcMeetingDaoUtils();

        fistOne();
        initProgress();
    }

    private void initProgress() {
        progress = new ProgressDialog(context);
        progress.setTitle("同步数据");
        progress.setMessage("数据正在更新中，请勿中途退出系统！");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(false);//设置为fase等待进度更新，设置为true则左右循环滚动
        progress.setMax(100);
    }

    public String getTitleName() {
        String str = "";
        if (!TextUtils.isEmpty(MySelfInfo.getInstance().getUserName())) {
            str = MySelfInfo.getInstance().getUserName();
        }
        if (!TextUtils.isEmpty(MySelfInfo.getInstance().getLoginName())) {
            str = str + "（" + MySelfInfo.getInstance().getLoginName() + "）";
        }
        if (TextUtils.isEmpty(str))
            return "欢迎";
        return "欢迎您的登录，当前用户：" + str;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.et_search:
                startActivity(new Intent(context, SearchActivity.class));
                break;
            case R.id.view_mcb:
                startActivity(new Intent(context, BmActivity.class));
                break;
            case R.id.view_gbmc:
                startActivity(new Intent(context, GbActivity.class));
                break;
            case R.id.view_yjjc:
                startActivity(new Intent(context, YjjcActivity.class));
                break;
            case R.id.view_zcfg:
                startActivity(new Intent(context, ZcfgActivity.class));
                break;
            case R.id.view_dsj:
                startActivity(new Intent(context, DsjtyActivity.class));
                break;
            case R.id.ll_right1:
                DialogUtil.getInstance().getDefaultDialog(context, "同步数据需要时间较长，您是否确认同步数据？", new DialogUtil.DialogCallBack() {
                    @Override
                    public void exectEvent(DialogInterface alterDialog) {
                        getUserInfoData();
                    }
                }).show();
                break;
        }
    }

    private void getUserInfoData() {
        progress.show();

        progress.setProgress(5);
        mPresenter.findUserInfo(SPUtils.getInstance().getInt(SPUtils.SP_USER_ID));
    }

    @Override
    public void findUserInfoSuccess(LoginBean.LoginBean2 data) {
        MySelfInfo.getInstance().setData(data);
        //数据库数据
        cleanDBData();

        progress.setProgress(10);

        mPresenter.getZcfgList();
    }

    @Override
    public void findUserInfoFailed(String msg) {
        ToastUtil.showShortToast(context, "同步数据失败 " + msg);
        progress.dismiss();
    }


    @Override
    public void getZcfgListSuccess(List<ZcfgBean.ZcfgBean2> data) {
        setDBZcfg(data);
        mPresenter.getBmList();
    }

    @Override
    public void getZcfgListFailed(String msg) {
        progress.setProgress(30);
        mPresenter.getBmList();
    }

    @Override
    public void getBmListSuccess(List<BmBean.BmBean2> data) {
        setDBBm(data);
        mPresenter.getGbList();
    }

    @Override
    public void getBmListFailed(String msg) {
        progress.setProgress(50);
        mPresenter.getGbList();
    }

    @Override
    public void getGbListSuccess(List<GbBean.GbBean2> data) {
        setDBGb(data);
        mPresenter.getYjjcList();
    }

    @Override
    public void getGbListFailed(String msg) {
        progress.setProgress(70);
        mPresenter.getYjjcList();
    }

    @Override
    public void getYjjcListSuccess(List<YjjcBean.YjjcBean2> data) {
        setDBYjjc(data);
        progress.dismiss();
    }

    @Override
    public void getYjjcListFailed(String msg) {
        progress.setProgress(90);
        progress.dismiss();
    }

    //第一次
    public void fistOne() {
        if (SPUtils.getInstance().getBoolean(SPUtils.FIRST_OPENED, true)) {
            DialogUtil.getInstance().getDefaultDialog(context, "是否需要同步数据", new DialogUtil.DialogCallBack() {
                @Override
                public void exectEvent(DialogInterface alterDialog) {
                    getUserInfoData();
                }
            }).show();
        }
        SPUtils.getInstance().putBoolean(SPUtils.FIRST_OPENED, false);
    }

    public void cleanDBData() {
        LogUtil.e("政策法规 条数：" + dBZcfgDaoUtils.queryAll().size());
        LogUtil.e("部门 条数：" + dBBmDaoUtils.queryAll().size());
        LogUtil.e("部门描述 条数：" + dBBmExplainDaoUtils.queryAll().size());

        LogUtil.e("干部 条数：" + dBGbDaoUtils.queryAll().size());
        LogUtil.e("干部奖惩记录信息 条数：" + dBGbAwardDaoUtils.queryAll().size());
        LogUtil.e("干部所属部门信息 条数：" + dBGbDeptDaoUtils.queryAll().size());
        LogUtil.e("干部家庭成员信息 条数：" + dBGbFamilyDaoUtils.queryAll().size());
        LogUtil.e("干部曾任职信息 条数：" + dBGbHistoryDaoUtils.queryAll().size());
        LogUtil.e("干部现任职信息 条数：" + dBGbNowDaoUtils.queryAll().size());
        LogUtil.e("干部职级信息 条数：" + dBGbRankDaoUtils.queryAll().size());
        LogUtil.e("干部简历 条数：" + dBGbResumeDaoUtils.queryAll().size());
        LogUtil.e("干部培训情况 条数：" + dBGbTrainDaoUtils.queryAll().size());

        LogUtil.e("研究决策 条数：" + dBYjjcDaoUtils.queryAll().size());
        LogUtil.e("研究决策 任免会议信息 条数：" + dBYjjcCadreDaoUtils.queryAll().size());
        LogUtil.e("研究决策 任免干部名册列表 条数：" + dBYjjcMeetingDaoUtils.queryAll().size());


        dBZcfgDaoUtils.deleteAll();
        dBBmDaoUtils.deleteAll();
        dBBmExplainDaoUtils.deleteAll();

        dBGbDaoUtils.deleteAll();
        dBGbAwardDaoUtils.deleteAll();
        dBGbDeptDaoUtils.deleteAll();
        dBGbFamilyDaoUtils.deleteAll();
        dBGbHistoryDaoUtils.deleteAll();
        dBGbNowDaoUtils.deleteAll();
        dBGbRankDaoUtils.deleteAll();
        dBGbResumeDaoUtils.deleteAll();
        dBGbTrainDaoUtils.deleteAll();

        dBYjjcDaoUtils.deleteAll();
        dBYjjcCadreDaoUtils.deleteAll();
        dBYjjcMeetingDaoUtils.deleteAll();
    }

    private void setDBZcfg(List<ZcfgBean.ZcfgBean2> data) {
        List<DBZcfgBean> dbList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            progress.setProgress(10 + (20/data.size() * i));
            ZcfgBean.ZcfgBean2 item = data.get(i);
            dbList.add(new DBZcfgBean(
                    null,
                    item.getSearchValue(),
                    item.getCreateBy(),
                    item.getCreateTime(),
                    item.getUpdateBy(),
                    item.getUpdateTime(),
                    item.getRemark(),
                    item.getDeptCode(),
                    item.getNoticeId(),
                    item.getNoticeTitle(),
                    item.getNoticeType(),
                    item.getNoticeTypeName(),
                    item.getNoticeContent(),
                    item.getStatus(),
                    item.getStatusName(),
                    item.getTitleFileUrl()
            ));
        }
        dBZcfgDaoUtils.insertMulti(dbList);
    }

    private void setDBBm(List<BmBean.BmBean2> data) {
        List<DBBmBean> dbList = new ArrayList<>();
        List<DBBmExplainBean> dbList_explain = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            progress.setProgress(30 + (20/data.size() * i));
            BmBean.BmBean2 item = data.get(i);
            dbList.add(new DBBmBean(
                    null,
                    item.getDeptId(),
                    item.getParentId(),
                    item.getDeptName(),
                    item.getDzzName(),
                    item.getOrgCode(),
                    item.getOrgType(),
                    item.getOrgTypeName(),
                    item.getFinanceType(),
                    item.getFinanceTypeName(),
                    item.getSimpleName(),
                    item.getOrderNum(),
                    item.getDeptType(),
                    item.getDeptTypeName(),
                    item.getDelFlag(),
                    item.getParentName(),
                    item.getVerification(),
                    item.getActual(),
                    item.getOvermatch(),
                    item.getMismatch(),
                    item.getApprovedPosition(),
                    item.getApprovedDeputy(),
                    item.getApprovedOther(),
                    item.getActualPosition(),
                    item.getActualDeputy(),
                    item.getActualOther(),
                    item.getOrgLevelName()
            ));

            for (int i_explain = 0; i_explain < data.get(i).getOrganizationExplain().size(); i_explain++) {
                BmExplainBean item_a = data.get(i).getOrganizationExplain().get(i_explain);
                dbList_explain.add(new DBBmExplainBean(
                        null,
                        item_a.getExplainId(),
                        item_a.getDeptId(),
                        item_a.getOrgExplain(),
                        item_a.getYear()
                ));
            }
        }

        dBBmDaoUtils.insertMulti(dbList);
        dBBmExplainDaoUtils.insertMulti(dbList_explain);
    }

    private void setDBGb(List<GbBean.GbBean2> data) {
        List<DBGbBean> dbList = new ArrayList<>();
        List<DBGbCadreAwardPunishList> dbList_award = new ArrayList<>();
        List<DBGbCadreDeptListBean> dbList_dept = new ArrayList<>();
        List<DBGbCadreFamilyMemberList> dbList_family = new ArrayList<>();
        List<DBGbCadreHistoryPositionListBean> dbList_history = new ArrayList<>();
        List<DBGbCadreNowPositionListBean> dbList_now = new ArrayList<>();
        List<DBGbCadreRankListBean> dbList_rank = new ArrayList<>();
        List<DBGbCadreResumeListBean> dbList_resume = new ArrayList<>();
        List<DBGbCadreTrainListBean> dbList_train = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            progress.setProgress(50 + (20/data.size() * i));
            GbBean.GbBean2 item = data.get(i);
            dbList.add(new DBGbBean(
                    null,
                    item.getBaseId(),
                    item.getName(),
                    item.getPhotoFileName(),
                    item.getGender(),
                    item.getIdCard(),
                    item.getBirthday(),
                    item.getAge(),
                    item.getNation(),
                    item.getPoliticalOutlook(),
                    item.getJoinPartyDate(),
                    item.getNativePlace(),
                    item.getBirthplace(),
                    item.getWorkTime(),
                    item.getPersonnelRelationsDeptId(),
                    item.getPersonnelRelationsDeptName(),
                    item.getEnterUnitTime(),
                    item.getCurrentRank(),
                    item.getCurrentRankTime(),
                    item.getHealth(),
                    item.getFunctionaryRankId(),
                    item.getFunctionaryRankName(),
                    item.getFunctionaryRankTime(),
                    item.getCadreType(),
                    item.getCurrentPosition(),
                    item.getCurrentPositionTime(),
                    item.getPersonnelType(),
                    item.getTechnicalTitle(),
                    item.getExpertise(),
                    item.getFullTimeEducation(),
                    item.getFullTimeSchool(),
                    item.getFullTimeDegreeId(),
                    item.getFullTimeDegreeName(),
                    item.getFullTimeSchoolType(),
                    item.getCurrentEducation(),
                    item.getCurrentDegreeId(),
                    item.getCurrentDegreeName(),
                    item.getCurrentSchool(),
                    item.getCurrentSchoolType(),
                    item.getWorkPhone(),
                    item.getPhoneNumber(),
                    item.getHomeAddress(),
                    item.getResponsibilities(),
                    item.getAffectedState()
            ));

            for (int i_resume = 0; i_resume < data.get(i).getCadreResumeList().size(); i_resume++) {
                GbCadreResumeListBean item_resume = data.get(i).getCadreResumeList().get(i_resume);
                dbList_resume.add(new DBGbCadreResumeListBean(
                        null,
                        item_resume.getResumeId(),
                        item_resume.getBaseId(),
                        item_resume.getCadreName(),
                        item_resume.getWorkType(),
                        item_resume.getWorkStartTime(),
                        item_resume.getWorkEndTime(),
                        item_resume.getWorkDescribe()
                ));
            }

            for (int i_award = 0; i_award < data.get(i).getCadreAwardPunishList().size(); i_award++) {
                GbCadreAwardPunishList item_award = data.get(i).getCadreAwardPunishList().get(i_award);
                dbList_award.add(new DBGbCadreAwardPunishList(
                        null,
                        item_award.getAwardPunishId(),
                        item_award.getBaseId(),
                        item_award.getCadreName(),
                        item_award.getAwardPunishType(),
                        item_award.getAwardType(),
                        item_award.getAwardLevel(),
                        item_award.getPunishType(),
                        item_award.getAwardPunishName(),
                        item_award.getRatifyTime(),
                        item_award.getRatifyDept(),
                        item_award.getAwardPunishReason(),
                        item_award.getAwardPunishExplain()
                ));
            }

            for (int i_dept = 0; i_dept < data.get(i).getCadreDeptList().size(); i_dept++) {
                GbCadreDeptListBean item_dept = data.get(i).getCadreDeptList().get(i_dept);
                dbList_dept.add(new DBGbCadreDeptListBean(
                        null,
                        item_dept.getDeptId(),
                        item_dept.getBaseId(),
                        item_dept.getState(),
                        item_dept.getDeptName(),
                        item_dept.getDeptType(),
                        item_dept.getDeptCode()
                ));
            }

            for (int i_family = 0; i_family < data.get(i).getCadreFamilyMemberList().size(); i_family++) {
                GbCadreFamilyMemberList item_family = data.get(i).getCadreFamilyMemberList().get(i_family);
                dbList_family.add(new DBGbCadreFamilyMemberList(
                        null,
                        item_family.getMemberId(),
                        item_family.getBaseId(),
                        item_family.getCadreName(),
                        item_family.getAppellation(),
                        item_family.getName(),
                        item_family.getBirthday(),
                        item_family.getPoliticalOutlook(),
                        item_family.getWorkUnit()
                ));
            }

            for (int i_history = 0; i_history < data.get(i).getCadreHistoryPositionList().size(); i_history++) {
                GbCadreHistoryPositionListBean item_history = data.get(i).getCadreHistoryPositionList().get(i_history);
                dbList_history.add(new DBGbCadreHistoryPositionListBean(
                        null,
                        item_history.getPositionId(),
                        item_history.getDeptId(),
                        item_history.getDeptName(),
                        item_history.getBaseId(),
                        item_history.getCadreName(),
                        item_history.getDutiesRank(),
                        item_history.getPosition(),
                        item_history.getPositionTitle(),
                        item_history.getPositionTitleName(),
                        item_history.getLeaveTime(),
                        item_history.getLeaveReason(),
                        item_history.getLeaveFileNumber(),
                        item_history.getVacantPosition()
                ));
            }


            for (int i_now = 0; i_now < data.get(i).getCadreNowPositionList().size(); i_now++) {
                GbCadreNowPositionListBean item_now = data.get(i).getCadreNowPositionList().get(i_now);
                dbList_now.add(new DBGbCadreNowPositionListBean(
                        null,
                        item_now.getPositionId(),
                        item_now.getDeptId(),
                        item_now.getDeptName(),
                        item_now.getBaseId(),
                        item_now.getCadreName(),
                        item_now.getPositionTime(),
                        item_now.getPosition(),
                        item_now.getPositionTitle(),
                        item_now.getPositionTitleName(),
                        item_now.getPositionReason(),
                        item_now.getPositionFileNumber(),
                        item_now.getDutiesRank(),
                        item_now.getVacantPosition()
                ));
            }


            for (int i_rank = 0; i_rank < data.get(i).getCadreRankList().size(); i_rank++) {
                GbCadreRankListBean item_rank = data.get(i).getCadreRankList().get(i_rank);
                dbList_rank.add(new DBGbCadreRankListBean(
                        null,
                        item_rank.getRankId(),
                        item_rank.getBaseId(),
                        item_rank.getCadreName(),
                        item_rank.getState(),
                        item_rank.getDutiesRank(),
                        item_rank.getDutiesRankTime(),
                        item_rank.getTreatmentRank(),
                        item_rank.getTreatmentRankTime()
                ));
            }


            for (int i_train = 0; i_train < data.get(i).getCadreTrainList().size(); i_train++) {
                GbCadreTrainListBean item_train = data.get(i).getCadreTrainList().get(i_train);
                dbList_train.add(new DBGbCadreTrainListBean(
                        null,
                        item_train.getTrainId(),
                        item_train.getBaseId(),
                        item_train.getCadreName(),
                        item_train.getStartTime(),
                        item_train.getEndTime(),
                        item_train.getTrainingCourse(),
                        item_train.getTrainLevel(),
                        item_train.getTrainType(),
                        item_train.getTrainOrganization(),
                        item_train.getTrainMode(),
                        item_train.getTrainContent()
                ));
            }
        }

        dBGbDaoUtils.insertMulti(dbList);
        dBGbAwardDaoUtils.insertMulti(dbList_award);
        dBGbDeptDaoUtils.insertMulti(dbList_dept);
        dBGbFamilyDaoUtils.insertMulti(dbList_family);
        dBGbHistoryDaoUtils.insertMulti(dbList_history);
        dBGbNowDaoUtils.insertMulti(dbList_now);
        dBGbRankDaoUtils.insertMulti(dbList_rank);
        dBGbResumeDaoUtils.insertMulti(dbList_resume);
        dBGbTrainDaoUtils.insertMulti(dbList_train);
    }

    public void setDBYjjc(List<YjjcBean.YjjcBean2> data){
        List<DbYjjcBean> dbList = new ArrayList<>();
        List<DBYjjcCadre> dbList_cadre = new ArrayList<>();
        List<DBYjjcMeeting> dbList_meeting = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            progress.setProgress(70 + (20/data.size() * i));
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
                        item_cadre.getDismissCadreId(),
                        item_cadre.getSchemeId(),
                        item_cadre.getSchemeName(),
                        item_cadre.getBaseId(),
                        item_cadre.getCadreName(),
                        item_cadre.getGender(),
                        item_cadre.getBirthday(),
                        item_cadre.getAge(),
                        item_cadre.getJoinPartyDate(),
                        item_cadre.getCurrentPosition(),
                        item_cadre.getCurrentPositionTime(),
                        item_cadre.getNativePlace(),
                        item_cadre.getFullTimeEducation(),
                        item_cadre.getCurrentEducation(),
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
                        item_cadre.getAppointDismissResult(),
                        item_cadre.getMeetingDescribe(),
                        item_cadre.getTalkNumber(),
                        item_cadre.getRecommendNumber(),
                        item_cadre.getRanking(),
                        item_cadre.getVacantPosition(),
                        item_cadre.getValidTicket(),
                        item_cadre.getGainVotes(),
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

        dBYjjcDaoUtils.insertMulti(dbList);
        dBYjjcCadreDaoUtils.insertMulti(dbList_cadre);
        dBYjjcMeetingDaoUtils.insertMulti(dbList_meeting);
    }

}
