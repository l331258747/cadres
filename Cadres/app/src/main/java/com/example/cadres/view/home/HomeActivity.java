package com.example.cadres.view.home;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
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
import com.example.cadres.bean.apk.ApkBean;
import com.example.cadres.bean.bm.BmBean;
import com.example.cadres.bean.bm.BmBean1;
import com.example.cadres.bean.bm.BmBean2;
import com.example.cadres.bean.bm.BmExplainBean;
import com.example.cadres.bean.bm.BmFinanceTypeBean;
import com.example.cadres.bean.bm.BmOrgTypeBean;
import com.example.cadres.bean.dsjty.HjtyBean;
import com.example.cadres.bean.dsjty.HjtyListBean;
import com.example.cadres.bean.dsjty.JgtyBean;
import com.example.cadres.bean.dsjty.ZstyBean;
import com.example.cadres.bean.login.LoginBean;
import com.example.cadres.bean.login.MySelfInfo;
import com.example.cadres.bean.yjjc.AppointDismissCadreVoListBean;
import com.example.cadres.bean.yjjc.AppointDismissMeetingListBean;
import com.example.cadres.bean.yjjc.YjjcBean;
import com.example.cadres.bean.zcfg.ZcfgBean;
import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.beanDB.DBBmExplainBean;
import com.example.cadres.beanDB.DBBmFinanceTypeBean;
import com.example.cadres.beanDB.DBBmOrgTypeBean;
import com.example.cadres.beanDB.DBGbBean;
import com.example.cadres.beanDB.DBGbCadreAwardPunishList;
import com.example.cadres.beanDB.DBGbCadreDeptListBean;
import com.example.cadres.beanDB.DBGbCadreFamilyMemberList;
import com.example.cadres.beanDB.DBGbCadreHistoryPositionListBean;
import com.example.cadres.beanDB.DBGbCadreNowPositionListBean;
import com.example.cadres.beanDB.DBGbCadreRankListBean;
import com.example.cadres.beanDB.DBGbCadreResumeListBean;
import com.example.cadres.beanDB.DBGbCadreTrainListBean;
import com.example.cadres.beanDB.DBTyHj;
import com.example.cadres.beanDB.DBTyHjList;
import com.example.cadres.beanDB.DBYjjcCadre;
import com.example.cadres.beanDB.DBYjjcMeeting;
import com.example.cadres.beanDB.DBZcfgBean;
import com.example.cadres.beanDB.DbTyJg;
import com.example.cadres.beanDB.DbTyZs;
import com.example.cadres.beanDB.DbYjjcBean;
import com.example.cadres.constant.Constant;
import com.example.cadres.dialog.DialogUtil;
import com.example.cadres.mvp.HomeContract;
import com.example.cadres.mvp.HomePresenter;
import com.example.cadres.utils.FileUtil;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.SPUtils;
import com.example.cadres.utils.ToastUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoUtilsStore;
import com.example.cadres.view.Bm.BmActivity;
import com.example.cadres.view.Gb.GbActivity;
import com.example.cadres.view.Gb.GbSelectActivity;
import com.example.cadres.view.dsjty.DsjtyActivity;
import com.example.cadres.view.search.SearchActivity;
import com.example.cadres.view.yjjc.YjjcActivity;
import com.example.cadres.view.zcfg.ZcfgActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class HomeActivity extends BaseActivity implements HomeContract.View, View.OnClickListener {

    EditText et_search;
    View view_mcb, view_gbmc, view_yjjc, view_zcfg, view_dsj;

    HomePresenter mPresenter;

    ProgressDialog progress;

    CommonDaoUtils<DBZcfgBean> dBZcfgDaoUtils;

    CommonDaoUtils<DBBmBean> dBBmDaoUtils;
    CommonDaoUtils<DBBmExplainBean> dBBmExplainDaoUtils;
    CommonDaoUtils<DBBmOrgTypeBean> dBBmOrgDaoUtils;
    CommonDaoUtils<DBBmFinanceTypeBean> dBBmFinanceDaoUtils;

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

    CommonDaoUtils<DBTyHj> dBTyHjDaoUtils;
    CommonDaoUtils<DBTyHjList> dBTyHjListDaoUtils;
    CommonDaoUtils<DbTyJg> dBTyJgDaoUtils;
    CommonDaoUtils<DbTyZs> dBTyZsDaoUtils;

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
        dBBmOrgDaoUtils = _Store.getBmOrgDaoUtils();
        dBBmFinanceDaoUtils = _Store.getBmFinanceDaoUtils();

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

        dBTyHjDaoUtils = _Store.getTyHjDaoUtils();
        dBTyHjListDaoUtils = _Store.getTyHjListDaoUtils();
        dBTyJgDaoUtils = _Store.getTyJgDaoUtils();
        dBTyZsDaoUtils = _Store.getTyZsDaoUtils();

        initProgress();
    }

    private void initProgress() {
        progress = new ProgressDialog(context);
        progress.setTitle("同步数据");
        progress.setMessage("数据正在更新中，请勿中途退出系统！");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(false);//设置为fase等待进度更新，设置为true则左右循环滚动
        progress.setMax(100);
        progress.setCancelable(false);
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
        if (!isPermissions) return;

        switch (view.getId()) {
            case R.id.et_search:
                startActivity(new Intent(context, SearchActivity.class));
                break;
            case R.id.view_mcb:
                startActivity(new Intent(context, BmActivity.class));
                break;
            case R.id.view_gbmc:
                startActivity(new Intent(context, GbSelectActivity.class));
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
    public void getBmListSuccess(BmBean1 data) {
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
        mPresenter.getJgty();
    }

    @Override
    public void getGbListFailed(String msg) {
        progress.setProgress(70);
        mPresenter.getJgty();
    }

    @Override
    public void getJgtySuccess(List<JgtyBean.jgtyBean2> data) {
        setDBJgty(data);
        mPresenter.getZsty();
    }

    @Override
    public void getJgtyFailed(String msg) {
        mPresenter.getZsty();
    }

    @Override
    public void getZstySuccess(List<ZstyBean.ZstyBean2> data) {
        setDBZsty(data);
        mPresenter.getHjty();
    }

    @Override
    public void getZstyFailed(String msg) {
        mPresenter.getHjty();
    }

    @Override
    public void getHjtySuccess(HjtyBean.HjtyBean2 data) {
        setDBHjty(data);
        mPresenter.getHjtyList();
    }

    @Override
    public void getHjtyFailed(String msg) {
        mPresenter.getHjtyList();
    }

    @Override
    public void getHjtyListSuccess(HjtyListBean.HjtyListBean2 data) {
        setDBHjtyList(data);
        mPresenter.getYjjcList();
    }

    @Override
    public void getHjtyListFailed(String msg) {
        mPresenter.getYjjcList();
    }

    @Override
    public void getYjjcListSuccess(List<YjjcBean.YjjcBean2> data) {
        setDBYjjc(data);
        mPresenter.getFiles();
    }

    @Override
    public void getYjjcListFailed(String msg) {
        progress.setProgress(90);
        mPresenter.getFiles();
    }

    @Override
    public void getFilesSuccess(List<String> data) {
        pos = 0;
        files = data;
        loadImages();
    }

    @Override
    public void getFilesFailed(String msg) {
        progress.setProgress(100);
        progress.dismiss();
    }

    //图片数量
    private void printImgAll() {
        File file = FileUtil.getFolder(Constant.IMAGE_PATH);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            LogUtil.e("文件夹图片数量：" + files.length);
            for (int i = 0; i < files.length; i++) {
                File f = files[i];
                LogUtil.e("文件：：" + f.getAbsolutePath());
            }
        }
    }

    String informationId;
    File dir;
    List<String> files;
    int pos = 0;
    String fileName;

    private void loadImages() {
        if (pos >= files.size()) {
            progress.dismiss();
            return;
        }
        String url = files.get(pos);

        dir = FileUtil.getFolder(Constant.IMAGE_PATH);
        //取得最后一个/的下标
        int index = url.lastIndexOf("/");
        //将字符串转为字符数组
        char[] ch = url.toCharArray();
        //根据 copyValueOf(char[] data, int offset, int count) 取得最后一个字符串
        informationId = String.copyValueOf(ch, index + 1, ch.length - index - 1);
        fileName = dir + File.separator + informationId;

        if (FileUtil.isFileExist(FileUtil.getFile(fileName))) {
            LogUtil.e("已存在： " + fileName);
            pos++;
            loadImages();
            progress.setProgress((int) (90 + (10f / files.size() * pos)));
            return;
        }


        Glide.with(context).load(url).asBitmap().toBytes().into(new SimpleTarget<byte[]>() {
            @Override
            public void onResourceReady(byte[] bytes, GlideAnimation<? super byte[]> glideAnimation) {
                try {
                    FileOutputStream fos = new FileOutputStream(fileName, true);
                    fos.write(bytes);
                    fos.flush();
                    fos.close();
                    LogUtil.e("下载完成： " + fileName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                pos++;
                loadImages();
                progress.setProgress((int) (90 + (10f / files.size() * pos)));
            }

            @Override
            public void onLoadFailed(Exception e, Drawable errorDrawable) {
                super.onLoadFailed(e, errorDrawable);
                LogUtil.e("下载失败： " + fileName);
                pos++;
                loadImages();
                progress.setProgress((int) (90 + (10f / files.size() * pos)));
            }
        });
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
        LogUtil.e("部门类别 条数：" + dBBmOrgDaoUtils.queryAll().size());
        LogUtil.e("部门性质 条数：" + dBBmFinanceDaoUtils.queryAll().size());

        LogUtil.e("干部 条数：" + dBGbDaoUtils.queryAll().size());
        LogUtil.e("干部奖惩记录信息 条数：" + dBGbAwardDaoUtils.queryAll().size());
        LogUtil.e("干部所属部门信息 条数：" + dBGbDeptDaoUtils.queryAll().size());
        LogUtil.e("干部家庭成员信息 条数：" + dBGbFamilyDaoUtils.queryAll().size());
        LogUtil.e("干部曾任职信息 条数：" + dBGbHistoryDaoUtils.queryAll().size());
        LogUtil.e("干部现任职信息 条数：" + dBGbNowDaoUtils.queryAll().size());
        LogUtil.e("干部职级信息 条数：" + dBGbRankDaoUtils.queryAll().size());
        LogUtil.e("干部简历 条数：" + dBGbResumeDaoUtils.queryAll().size());
        LogUtil.e("干部培训情况 条数：" + dBGbTrainDaoUtils.queryAll().size());

        LogUtil.e("任免决策 条数：" + dBYjjcDaoUtils.queryAll().size());
        LogUtil.e("任免决策 任免会议信息 条数：" + dBYjjcCadreDaoUtils.queryAll().size());
        LogUtil.e("任免决策 任免干部名册列表 条数：" + dBYjjcMeetingDaoUtils.queryAll().size());

        LogUtil.e("推演 换届 条数：" + dBTyHjDaoUtils.queryAll().size());
        LogUtil.e("推演 换届 列表 条数：" + dBTyHjListDaoUtils.queryAll().size());
        LogUtil.e("推演 结构 条数：" + dBTyJgDaoUtils.queryAll().size());
        LogUtil.e("推演 职数 条数：" + dBTyZsDaoUtils.queryAll().size());


        dBZcfgDaoUtils.deleteAll();
        dBBmDaoUtils.deleteAll();
        dBBmExplainDaoUtils.deleteAll();
        dBBmOrgDaoUtils.deleteAll();
        dBBmFinanceDaoUtils.deleteAll();

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

        dBTyHjDaoUtils.deleteAll();
        dBTyHjListDaoUtils.deleteAll();
        dBTyJgDaoUtils.deleteAll();
        dBTyZsDaoUtils.deleteAll();

        printImgAll();
    }

    private void setDBZcfg(List<ZcfgBean.ZcfgBean2> data) {
        List<DBZcfgBean> dbList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            progress.setProgress((int) (10 + (20f / data.size() * i)));
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

    private void setDBBm(BmBean1 bean) {
        List<DBBmBean> dbList = new ArrayList<>();
        List<DBBmExplainBean> dbList_explain = new ArrayList<>();
        List<BmBean2> data = bean.getZzbOrganization();
        if(data != null){
            for (int i = 0; i < data.size(); i++) {
                progress.setProgress((int) (30 + (20f / data.size() * i)));
                BmBean2 item = data.get(i);
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
                        item.getOrgLevelName(),
                        item.getSurpassPosition(),
                        item.getSurpassDeputy(),
                        item.getSurpassOther(),
                        item.getLackPosition(),
                        item.getLackDeputy(),
                        item.getLackOther(),
                        item.getOvermatchPosition(),
                        item.getOvermatchDeputy(),
                        item.getOvermatchOther(),
                        item.getMismatchPosition(),
                        item.getMismatchDeputy(),
                        item.getMismatchOther()
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
        }

        dBBmDaoUtils.insertMulti(dbList);
        dBBmExplainDaoUtils.insertMulti(dbList_explain);

        List<DBBmOrgTypeBean> dbOrgList = new ArrayList<>();
        List<BmOrgTypeBean> dataOrg = bean.getOrgType();
        if(dataOrg != null){
            for (int i = 0; i < dataOrg.size(); i++) {
                BmOrgTypeBean item = dataOrg.get(i);
                dbOrgList.add(new DBBmOrgTypeBean(
                        null,
                        item.getDictLabel(),
                        item.getDictValue()
                ));
            }
        }
        dBBmOrgDaoUtils.insertMulti(dbOrgList);

        List<DBBmFinanceTypeBean> dbFinanceList = new ArrayList<>();
        List<BmFinanceTypeBean> dataFinance = bean.getFinanceType();
        if(dataFinance != null){
            for (int i = 0; i < dataFinance.size(); i++) {
                BmFinanceTypeBean item = dataFinance.get(i);
                dbFinanceList.add(new DBBmFinanceTypeBean(
                        null,
                        item.getDictValue(),
                        item.getDictLabel()
                ));
            }
        }

        dBBmFinanceDaoUtils.insertMulti(dbFinanceList);

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
            progress.setProgress((int) (50 + (20f / data.size() * i)));
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
                    item.getAffectedState(),
                    item.getFullTimeMajor(),
                    item.getCurrentMajor(),
                    item.getFullTimeSchoolMajor(),
                    item.getCurrentSchoolMajor(),
                    item.getNativePlaceReplenish(),
                    item.getFunctionaryRegisterTime(),
                    item.getPositionType(),
                    item.getEstablishmentType(),
                    item.getRemark(),
                    item.getType(),
                    item.getCadreResume(),
                    item.getCadreAward(),
                    item.getCadrePunish(),
                    item.getCadreTrain(),
                    item.getPoliticalConstruction()
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
                        item_family.getWorkUnit(),
                        item_family.getAge()
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

    public void setDBYjjc(List<YjjcBean.YjjcBean2> data) {
        List<DbYjjcBean> dbList = new ArrayList<>();
        List<DBYjjcCadre> dbList_cadre = new ArrayList<>();
        List<DBYjjcMeeting> dbList_meeting = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            progress.setProgress((int) (70 + (20f / data.size() * i)));
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

        dBYjjcDaoUtils.insertMulti(dbList);
        dBYjjcCadreDaoUtils.insertMulti(dbList_cadre);
        dBYjjcMeetingDaoUtils.insertMulti(dbList_meeting);
    }


    private void setDBJgty(List<JgtyBean.jgtyBean2> data) {
        List<DbTyJg> dbList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            JgtyBean.jgtyBean2 item = data.get(i);
            dbList.add(new DbTyJg(
                    null,
                    item.getDeptId(),
                    item.getSexListStr(),
                    item.getNationListStr(),
                    item.getOutlookListStr(),
                    item.getAgeListStr()
            ));
        }

        dBTyJgDaoUtils.insertMulti(dbList);
    }

    private void setDBZsty(List<ZstyBean.ZstyBean2> data) {
        List<DbTyZs> dbList = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            ZstyBean.ZstyBean2 item = data.get(i);
            dbList.add(new DbTyZs(
                    null,
                    item.getYear(),
                    item.getRankAge(),
                    item.getToVacancy(),
                    item.getParallel(),
                    item.getOvermatch(),
                    item.getVacancy(),
                    item.getDigestion()
            ));
        }
        dBTyZsDaoUtils.insertMulti(dbList);
    }

    private void setDBHjty(HjtyBean.HjtyBean2 data) {
        DBTyHj db = new DBTyHj(
                null,
                data.getSwbzcount(),
                data.getInconformityswbz(),
                data.getSzfbzcount(),
                data.getInconformityszfbz(),
                data.getSrdbzcount(),
                data.getInconformitysrdbz(),
                data.getSzxzcount(),
                data.getInconformityszx()
        );
        dBTyHjDaoUtils.insert(db);
    }

    private void setDBHjtyList(HjtyListBean.HjtyListBean2 data) {
        DBTyHjList db = new DBTyHjList(
                null,
                data.getScwStr(),
                data.getSzfStr(),
                data.getSrdStr(),
                data.getSzxStr()
        );
        dBTyHjListDaoUtils.insert(db);
    }


    //---------------start权限-----------------
    public static final int BASE_VALUE_PERMISSION = 0X0001;
    public static final int PERMISSION_REQ_ID_WRITE_EXTERNAL_STORAGE = BASE_VALUE_PERMISSION + 2;
    private boolean isPermissions = false;

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isFinishing()) {
                    return;
                }

                boolean checkPermissionResult = checkSelfPermissions();
                LogUtil.e("checkPermissionResult: " + checkPermissionResult);

                if ((Build.VERSION.SDK_INT < Build.VERSION_CODES.M)) {
                    // so far we do not use OnRequestPermissionsResultCallback
                }
            }
        }, 500);
    }

    /**
     * WRITE_EXTERNAL_STORAGE sd写权限
     */
    private boolean checkSelfPermissions() {
        return checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE, PERMISSION_REQ_ID_WRITE_EXTERNAL_STORAGE);
    }

    public boolean checkSelfPermission(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager
                .PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{permission}, requestCode);
            return false;
        }
        if (permission == android.Manifest.permission.WRITE_EXTERNAL_STORAGE) {
            isPermissions = true;
            fistOne();
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQ_ID_WRITE_EXTERNAL_STORAGE: {
                if (grantResults[0] == PackageManager.PERMISSION_DENIED) {//选择了不再提示按钮
                    showAccreditDialog();
                    return;
                }
                if (grantResults.length > 0) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        isPermissions = true;
                        fistOne();
                    } else {
                        checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                PERMISSION_REQ_ID_WRITE_EXTERNAL_STORAGE);
                    }
                }
                break;
            }
        }
    }

    //----------------end权限--------------

    //----------start 权限不再询问处理-------------

    private void showAccreditDialog() {
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setMessage("温馨提示\n" +
                        "您需要同意系统使用【储存】权限才能正常使用系统，" +
                        "由于您选择了【禁止（不再提示）】，将导致无法使用系统，" +
                        "需要到设置页面手动授权开启【存储】权限，才能继续使用。")
                .setPositiveButton("去授权", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //引导用户至设置页手动授权
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", getApplicationContext().getPackageName
                                (), null);
                        intent.setData(uri);
                        startActivityForResult(intent, REQUEST_PERMISSION_SETTING);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //引导用户手动授权，权限请求失败
                        finish();
                    }
                }).setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                //引导用户手动授权，权限请求失败
            }
        }).show();
    }

    public static final int REQUEST_PERMISSION_SETTING = 6;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_PERMISSION_SETTING) {
            checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    PERMISSION_REQ_ID_WRITE_EXTERNAL_STORAGE);
        }
        //TODO 升级
//        else if (requestCode == 10086) {
//            LogUtil.e("设置了安装未知应用后的回调。。。");
//            String successDownloadApkPath = FileUtil.getFolderPath(Constant.APK_PATH) + File.separator + apkName;
//            installApkO(context, successDownloadApkPath);
//        }
    }

    //----------end 权限不再询问处理-------------
    @Override
    public void getApkSuccess(ApkBean.ApkBean2 data) {
    }

    @Override
    public void getApkFailed(String msg) {
    }

////    //------------------start 下载
////
////    //TODO 升级
//    public void getApk() {
//        mPresenter.getApk();
//    }
////
//    String apkName;
//    @Override
//    public void getApkSuccess(ApkBean.ApkBean2 data) {
//        LogUtil.e("版本下载成功：" + data.toString());
//        int cVersionCode = AppUtils.getVersionCodeInt();
//        int sVersionCode = data.getVersion();
//        String apkUrl = data.getUrl();
////        String apkUrl = "https://www.njzou.com/najiuzou.apk";
//        String content = data.getContent();
//        apkName = "宁乡市干部大数据管理系统" + sVersionCode + ".apk";
//
//        if (sVersionCode > cVersionCode) {
//            initProgress(content);
//            downLoadProgress.show();
//            goDownload(apkUrl);
//
//        } else {
////            goHome();
//            LogUtil.e("最新版本");
//        }
//    }
//
//    Subscription subscription;
//
//    private void goDownload(String url) {
//        subscription = RxDownload.getInstance()
//                .download(url, apkName, FileUtil.getFolderPath(Constant.APK_PATH))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<DownloadStatus>() {
//
//                    @Override
//                    public void onCompleted() {
//                        //下载完成
//                        downLoadProgress.dismiss();
//                        installApkO(context,FileUtil.getFolderPath(Constant.APK_PATH) + File.separator + apkName);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        //下载出错
////                        goHome();
//                        LogUtil.e("版本下载错误：" + e);
//                    }
//
//                    @Override
//                    public void onNext(final DownloadStatus status) {
//                        String str = status.getPercent();
//                        float num = Float.valueOf(str.substring(0, str.length() - 1));
//
//                        LogUtil.e("s :" + num);
//                        //下载状态
//                        downLoadProgress.setProgress((int) num);
//                    }
//                });
//    }
//
//    @Override
//    public void getApkFailed(String msg) {
//        LogUtil.e("版本下载错误：" + msg);
////        goHome();
//    }
//
//    // 3.下载成功，开始安装,兼容8.0安装位置来源的权限
//    private void installApkO(Context context, String downloadApkPath) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            //是否有安装位置来源的权限
//            boolean haveInstallPermission = getPackageManager().canRequestPackageInstalls();
//            if (haveInstallPermission) {
//                LogUtil.e("8.0手机已经拥有安装未知来源应用的权限，直接安装！");
//                AppUtils.installApk(context, downloadApkPath);
//            } else {
//
//                DialogUtil.getInstance().getDefaultDialog(context, "安装应用需要打开安装未知来源应用权限，请去设置中开启权限", new DialogUtil.DialogCallBack() {
//                    @Override
//                    public void exectEvent(DialogInterface alterDialog) {
//                        Uri packageUri = Uri.parse("package:"+ AppUtils.getPakgeName());
//                        Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES,packageUri);
//                        startActivityForResult(intent,10086);
//                    }
//                }).show();
//            }
//        } else {
//            AppUtils.installApk(context, downloadApkPath);
//        }
//    }
//    //4.开启了安装未知来源应用权限后，再次进行步骤3的安装。
////    @Override
////    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
////        super.onActivityResult(requestCode, resultCode, data);
////        if (requestCode == 10086) {
////            LogUtil.e("设置了安装未知应用后的回调。。。");
////            String successDownloadApkPath = FileUtil.getFOlderPath(Constant.APK_PATH) + File.separator + apkName;
////            installApkO(context, successDownloadApkPath);
////        }
////    }
//
//
//    //------------------end 下载
//
//    ProgressDialog downLoadProgress;
//
//    private void initProgress(String content) {
//        downLoadProgress = new ProgressDialog(context);
//        downLoadProgress.setTitle("下载更新");
//        downLoadProgress.setMessage(content);
//        downLoadProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//        downLoadProgress.setIndeterminate(false);//设置为fase等待进度更新，设置为true则左右循环滚动
//        downLoadProgress.setMax(100);
//        downLoadProgress.setCancelable(false);
//    }
//
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (subscription != null && !subscription.isUnsubscribed()) {
//            subscription.unsubscribe();
//        }
//    }
}
