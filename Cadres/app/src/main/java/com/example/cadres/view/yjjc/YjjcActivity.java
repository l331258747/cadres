package com.example.cadres.view.yjjc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.cadres.R;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.yjjc.AppointDismissCadreGroupingListBean;
import com.example.cadres.bean.yjjc.AppointDismissCadreVoListBean;
import com.example.cadres.bean.yjjc.AppointDismissMeetingListBean;
import com.example.cadres.bean.yjjc.YjjcBean;
import com.example.cadres.beanDB.DBYjjcCadre;
import com.example.cadres.beanDB.DBYjjcMeeting;
import com.example.cadres.beanDB.DbYjjcBean;
import com.example.cadres.beanDB.DbYjjcCadreGrouping;
import com.example.cadres.constant.Constant;
import com.example.cadres.dialog.DefaultDialog;
import com.example.cadres.mvp.YjjcSelContract;
import com.example.cadres.mvp.YjjcSelPresenter;
import com.example.cadres.utils.FileUtil;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoUtilsStore;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class YjjcActivity extends BaseActivity implements View.OnClickListener, YjjcSelContract.View {

    ImageView iv_bw_bg, iv_sjzt_bg, iv_swcw_bg;

    boolean isMeetingModel;

    YjjcSelPresenter mPresenter;

    ProgressDialog progress;

    @Override
    public int getLayoutId() {
        return R.layout.activity_yjjc;
    }

    @Override
    public void initView() {

        isMeetingModel = intent.getBooleanExtra("isMeetingModel", false);

        if (!isMeetingModel) {
            showLeftIcon();
            showLLRightGoHome();
        } else {
            showLLRightUpData();
            getTvRight1().setText("同步会议数据");
            getLLRight1().setOnClickListener(this);
        }
        showTitleTv("任免决策");

        iv_bw_bg = $(R.id.iv_bw_bg);
        iv_sjzt_bg = $(R.id.iv_sjzt_bg);
        iv_swcw_bg = $(R.id.iv_swcw_bg);

        iv_bw_bg.setOnClickListener(this);
        iv_sjzt_bg.setOnClickListener(this);
        iv_swcw_bg.setOnClickListener(this);
    }


    @Override
    public void onBackPressed() {
        if (!isMeetingModel)
            super.onBackPressed();
    }

    @Override
    public void initData() {
        mPresenter = new YjjcSelPresenter(context, this);

        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
        dBYjjcDaoUtils = _Store.getYjjcDaoUtils();
        dBYjjcMeetingDaoUtils = _Store.getYjjcMeetingDaoUtils();
        dBYjjcCadreDaoUtils = _Store.getYjjcCadreDaoUtils();
        dbYjjcCadreGroupingDaoUtils = _Store.getYjjcCadreGroupingDaoUtils();

        initProgress();
    }

    private void initProgress() {
        progress = new ProgressDialog(context);
        progress.setTitle("同步会议数据");
        progress.setMessage("同步会议数据中，请勿中途退出系统！");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(false);//设置为fase等待进度更新，设置为true则左右循环滚动
        progress.setMax(100);
        progress.setCancelable(false);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, YjjcDetailActivity2.class);
        intent.putExtra("isMeetingModel", isMeetingModel);
        //会议类型（1部务会议，2书记专题会议，3市委常委会议）
        switch (view.getId()) {
            case R.id.iv_bw_bg:
                intent.putExtra("type", "部务会议");
                startActivity(intent);
                break;
            case R.id.iv_sjzt_bg:
                intent.putExtra("type", "书记专题会议");
                startActivity(intent);
                break;
            case R.id.iv_swcw_bg:
                intent.putExtra("type", "市委常委会议");
                startActivity(intent);
                break;
            case R.id.ll_right1:
                new DefaultDialog(context).setContent("您是否确认同步会议数据？").setSubmitListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        progress.show();
                        progress.setProgress(5);
                        mPresenter.getYjjcList();
                    }
                }).show();
                break;
        }
    }

    @Override
    public void getMeetingFilesSuccess(List<String> data) {
        pos = 0;
        files = data;
        loadImages();
    }

    @Override
    public void getMeetingFilesFailed(String msg) {
        showShortToast("同步会议数据失败 - 文件");
        LogUtil.e("同步会议数据失败 - 文件:" + msg);

        progress.dismiss();
    }

    @Override
    public void getYjjcListSuccess(List<YjjcBean.YjjcBean2> data) {
        progress.setProgress(10);

        setDBYjjc(data);
        mPresenter.getMeetingFiles();
    }

    @Override
    public void getYjjcListFailed(String msg) {
        showShortToast("同步会议数据失败");
        LogUtil.e("同步会议数据失败:" + msg);

        progress.dismiss();
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
            progress.setProgress((int) (50 + (50f / files.size() * pos)));
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
                progress.setProgress((int) (50 + (50f / files.size() * pos)));
            }

            @Override
            public void onLoadFailed(Exception e, Drawable errorDrawable) {
                super.onLoadFailed(e, errorDrawable);
                LogUtil.e("下载失败： " + fileName);
                pos++;
                loadImages();
                progress.setProgress((int) (50 + (50f / files.size() * pos)));
            }
        });
    }


    CommonDaoUtils<DbYjjcBean> dBYjjcDaoUtils;
    CommonDaoUtils<DBYjjcCadre> dBYjjcCadreDaoUtils;
    CommonDaoUtils<DBYjjcMeeting> dBYjjcMeetingDaoUtils;
    CommonDaoUtils<DbYjjcCadreGrouping> dbYjjcCadreGroupingDaoUtils;

    public void setDBYjjc(List<YjjcBean.YjjcBean2> data) {
        List<DbYjjcBean> dbList = new ArrayList<>();
        List<DBYjjcCadre> dbList_cadre = new ArrayList<>();
        List<DBYjjcMeeting> dbList_meeting = new ArrayList<>();
        List<DbYjjcCadreGrouping> dbList_grouping = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            progress.setProgress((int) (10 + (40f / data.size() * i)));
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
}
