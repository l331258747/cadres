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

import com.example.cadres.R;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.bm.BmBean;
import com.example.cadres.bean.bm.BmExplainBean;
import com.example.cadres.bean.login.LoginBean;
import com.example.cadres.bean.login.MySelfInfo;
import com.example.cadres.bean.zcfg.ZcfgBean;
import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.beanDB.DBBmExplainBean;
import com.example.cadres.beanDB.DBZcfgBean;
import com.example.cadres.dialog.DialogUtil;
import com.example.cadres.mvp.HomeContract;
import com.example.cadres.mvp.HomePresenter;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.SPUtils;
import com.example.cadres.utils.ToastUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoUtilsStore;
import com.example.cadres.view.Bm.BmActivity;
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

        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                /*判断是否是“搜索”键*/
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String key = et_search.getText().toString().trim();
                    if (TextUtils.isEmpty(key)) {
                        ToastUtil.showShortToast(context, "请输入您想要搜索的内容");
                        return true;
                    }

                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void initData() {
        SPUtils.getInstance().putBoolean(SPUtils.IS_LOGIN, true);

        mPresenter = new HomePresenter(context, this);

        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
        dBZcfgDaoUtils = _Store.getZcfgDaoUtils();
        dBBmDaoUtils = _Store.getBmDaoUtils();
        dBBmExplainDaoUtils = _Store.getBmExplainDaoUtils();

        fistOne();
        initProgress();
    }

    private void initProgress() {
        progress = new ProgressDialog(context);
        progress.setTitle("文件下载");
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
            case R.id.view_mcb:
                startActivity(new Intent(context, BmActivity.class));
                break;
            case R.id.view_gbmc:
                ToastUtil.showShortToast(context, "干部名册");
                break;
            case R.id.view_yjjc:
                ToastUtil.showShortToast(context, "研究决策");
                break;
            case R.id.view_zcfg:
                startActivity(new Intent(context, ZcfgActivity.class));
                break;
            case R.id.view_dsj:
                ToastUtil.showShortToast(context, "大数据");
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
//        progress.show();
        mPresenter.findUserInfo(SPUtils.getInstance().getInt(SPUtils.SP_USER_ID));
    }

    @Override
    public void findUserInfoSuccess(LoginBean.LoginBean2 data) {
        MySelfInfo.getInstance().setData(data);
        //数据库数据
        cleanDBData();

        mPresenter.getZcfgList();
    }

    public void cleanDBData() {
        if (dBZcfgDaoUtils.queryAll() != null) {
            LogUtil.e("政策法规 条数：" + dBZcfgDaoUtils.queryAll().size());
        } else {
            LogUtil.e("政策法规 没有数据");
        }
        if (dBBmDaoUtils.queryAll() != null) {
            LogUtil.e("部门 条数：" + dBBmDaoUtils.queryAll().size());
        } else {
            LogUtil.e("部门 没有数据");
        }
        if (dBBmExplainDaoUtils.queryAll() != null) {
            LogUtil.e("部门描述 条数：" + dBBmExplainDaoUtils.queryAll().size());
        } else {
            LogUtil.e("部门描述 没有数据");
        }

        dBZcfgDaoUtils.deleteAll();
        dBBmDaoUtils.deleteAll();
        dBBmExplainDaoUtils.deleteAll();
    }

    @Override
    public void findUserInfoFailed(String msg) {
        ToastUtil.showShortToast(context, "同步数据失败 " + msg);
    }


    @Override
    public void getZcfgListSuccess(List<ZcfgBean.ZcfgBean2> data) {
        List<DBZcfgBean> dbList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
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

        mPresenter.getBmList();
    }

    @Override
    public void getZcfgListFailed(String msg) {

    }

    @Override
    public void getBmListSuccess(List<BmBean.BmBean2> data) {
        List<DBBmBean> dbList = new ArrayList<>();
        List<DBBmExplainBean> dbList_a = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
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
                    item.getActualOther()
            ));

            for (int a = 0; a < data.get(i).getOrganizationExplain().size(); a++) {
                BmExplainBean item_a = data.get(i).getOrganizationExplain().get(a);
                dbList_a.add(new DBBmExplainBean(
                        null,
                        item_a.getExplainId(),
                        item_a.getDeptId(),
                        item_a.getOrgExplain(),
                        item_a.getYear()
                ));
            }
        }

        dBBmDaoUtils.insertMulti(dbList);
        dBBmExplainDaoUtils.insertMulti(dbList_a);
    }

    @Override
    public void getBmListFailed(String msg) {

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
}
