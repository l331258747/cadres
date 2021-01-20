package com.example.cadres.view.Bm;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.cadres.greendao.gen.DBBmBeanDao;
import com.cadres.greendao.gen.DBBmFinanceTypeBeanDao;
import com.cadres.greendao.gen.DBBmOrgTypeBeanDao;
import com.cadres.greendao.gen.DBGbBeanDao;
import com.cadres.greendao.gen.DbTyZsDao;
import com.example.cadres.R;
import com.example.cadres.adapter.BmLeftAdapter;
import com.example.cadres.adapter.BmRightAdapter;
import com.example.cadres.adapter.ListDialogAdapter;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.common.ListDialogBean;
import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.beanDB.DBBmFinanceTypeBean;
import com.example.cadres.beanDB.DBBmOrgTypeBean;
import com.example.cadres.beanDB.DbTyZs;
import com.example.cadres.dialog.ListDialog;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoManager;
import com.example.cadres.utils.greendao.DaoUtilsStore;
import com.example.cadres.widget.MyItemTouchListener;

import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BmActivity extends BaseActivity implements View.OnClickListener {

    EditText et_search;
    RecyclerView recyclerViewRight;
    RecyclerView recyclerViewLeft;
    MyItemTouchListener touchListenerLeft;
    MyItemTouchListener touchListenerRight;

    BmLeftAdapter mAdapterLeft;
    BmRightAdapter mAdapterRight;

    CommonDaoUtils<DBBmBean> dBBmDaoUtils;
    List<DBBmBean> datas;

    TextView tv_dw_title,tv_dr_dwjb2,tv_dr_dwxz2,tv_dr_hdzs2,tv_dr_sjpb2,tv_dr_cpqk2,tv_dr_kqqk2,tv_dr_cz2;
    DrawerLayout drawer_layout;

    TextView num_hdzs_zz,num_hdzs_fz,num_hdzs_qt,num_spqk_zz,num_spqk_fz,num_spqk_qt,num_cpqk_zz,num_cpqk_fz,num_cpqk_qt,num_kqqk_zz,num_kqqk_fz,num_kqqk_qt;

    TextView tv_screen_dwlb,tv_screen_dwxz,tv_screen_cpkq;

    @Override
    public int getLayoutId() {
        return R.layout.activity_bm_drawer;
    }

    @Override
    public void initView() {
        showLeftIcon();
        showLLRightGoHome();
        showTitleTv("市管职数配备表");

        et_search = findViewById(R.id.et_search);

        drawer_layout = findViewById(R.id.drawer_layout);
        tv_dw_title = findViewById(R.id.tv_dw_title);
        tv_dr_dwjb2 = findViewById(R.id.tv_dr_dwjb2);
        tv_dr_dwxz2 = findViewById(R.id.tv_dr_dwxz2);
        tv_dr_hdzs2 = findViewById(R.id.tv_dr_hdzs2);
        tv_dr_sjpb2 = findViewById(R.id.tv_dr_sjpb2);
        tv_dr_cpqk2 = findViewById(R.id.tv_dr_cpqk2);
        tv_dr_kqqk2 = findViewById(R.id.tv_dr_kqqk2);
        tv_dr_cz2 = findViewById(R.id.tv_dr_cz2);

        num_hdzs_zz = findViewById(R.id.num_hdzs_zz);
        num_hdzs_fz = findViewById(R.id.num_hdzs_fz);
        num_hdzs_qt = findViewById(R.id.num_hdzs_qt);
        num_spqk_zz = findViewById(R.id.num_spqk_zz);
        num_spqk_fz = findViewById(R.id.num_spqk_fz);
        num_spqk_qt = findViewById(R.id.num_spqk_qt);
        num_cpqk_zz = findViewById(R.id.num_cpqk_zz);
        num_cpqk_fz = findViewById(R.id.num_cpqk_fz);
        num_cpqk_qt = findViewById(R.id.num_cpqk_qt);
        num_kqqk_zz = findViewById(R.id.num_kqqk_zz);
        num_kqqk_fz = findViewById(R.id.num_kqqk_fz);
        num_kqqk_qt = findViewById(R.id.num_kqqk_qt);

        tv_screen_dwlb = findViewById(R.id.tv_screen_dwlb);
        tv_screen_dwxz = findViewById(R.id.tv_screen_dwxz);
        tv_screen_cpkq = findViewById(R.id.tv_screen_cpkq);
        tv_screen_dwlb.setOnClickListener(this);
        tv_screen_dwxz.setOnClickListener(this);
        tv_screen_cpkq.setOnClickListener(this);

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

        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                /*判断是否是“搜索”键*/
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    orgId = "";
                    tv_screen_dwlb.setText("单位类别");
                    FinanceId = "";
                    tv_screen_dwxz.setText("单位性质");
                    cpkqId = "";
                    tv_screen_cpkq.setText("超配空缺筛选");
                    key = et_search.getText().toString().trim();
                    getData();
                    return true;
                }
                return false;
            }
        });

        initRecyclerLeft();
        initRecyclerRight();
    }

    @Override
    public void initData() {
        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
        dBBmDaoUtils = _Store.getBmDaoUtils();

        getData();

        getDbOrgData();
        getDbFinanceData();
        getDbCpkqData();
    }

    public List<DBBmBean> getDbList(String key) {
        List<DBBmBean> dbList = new ArrayList<>();
        DBBmBeanDao dbBmBeanDao = DaoManager.getInstance().getDaoSession().getDBBmBeanDao();
        QueryBuilder<DBBmBean> queryBuilder = dbBmBeanDao.queryBuilder();

        if(!TextUtils.isEmpty(key)){
            String sql = " (" + DBBmBeanDao.Properties.ParentId.columnName
                    + " in ( "
                    + " select " + DBBmBeanDao.Properties.DeptId.columnName
                    + " from " + DBBmBeanDao.TABLENAME
                    + " where " + DBBmBeanDao.Properties.DeptName.columnName + " like ? "
                    + " ) "
                    + " or " + DBBmBeanDao.Properties.DeptName.columnName + " like ? )";
            String[] values = new String[]{"%" + key + "%","%" + key + "%"};
            queryBuilder.where(new WhereCondition.StringCondition(sql,values),DBBmBeanDao.Properties.Display.eq(0));
            dbList = queryBuilder.list();
        }else{
            queryBuilder.where(DBBmBeanDao.Properties.Display.eq(0));
            if(!TextUtils.isEmpty(orgId))
                queryBuilder.where(DBBmBeanDao.Properties.OrgType.eq(orgId)).orderAsc(DBBmBeanDao.Properties.OrderNum);
            if(!TextUtils.isEmpty(FinanceId))
                queryBuilder.where(DBBmBeanDao.Properties.FinanceType.eq(FinanceId)).orderAsc(DBBmBeanDao.Properties.OrderNum);
            if(!TextUtils.isEmpty(cpkqId)){
                if(TextUtils.equals(cpkqId,"1")){
                    queryBuilder.where(DBBmBeanDao.Properties.Surpass.eq("1")).orderAsc(DBBmBeanDao.Properties.OrderNum);
                }else if(TextUtils.equals(cpkqId,"2")){
                    queryBuilder.where(DBBmBeanDao.Properties.Lack.eq("1")).orderAsc(DBBmBeanDao.Properties.OrderNum);
                }
            }
            dbList = queryBuilder.list();
        }
        LogUtil.e("数据库条数：" + dbList.size());
        return dbList;
    }

    public void getData() {
        datas = new ArrayList<>();
        List<DBBmBean> dbList = getDbList(key);
        if (dbList != null) {
            datas = dbList;
        }

        mAdapterLeft.setData(datas);
        mAdapterRight.setData(datas);
        setNum();
    }

    public void setNum(){
        int hdzs_zz = 0,hdzs_fz = 0,hdzs_qt = 0,spqk_zz = 0,spqk_fz = 0,spqk_qt = 0,cpqk_zz = 0,cpqk_fz = 0,cpqk_qt = 0,kqqk_zz = 0,kqqk_fz = 0,kqqk_qt = 0;
        for (int i=0;i<datas.size();i++){
            hdzs_zz = hdzs_zz + datas.get(i).getApprovedPosition();
            hdzs_fz = hdzs_fz + datas.get(i).getApprovedDeputy();
            hdzs_qt = hdzs_qt + datas.get(i).getApprovedOther();

            spqk_zz = spqk_zz + datas.get(i).getActualPosition();
            spqk_fz = spqk_fz + datas.get(i).getActualDeputy();
            spqk_qt = spqk_qt + datas.get(i).getActualOther();

            cpqk_zz = cpqk_zz + datas.get(i).getSurpassPosition();
            cpqk_fz = cpqk_fz + datas.get(i).getSurpassDeputy();
            cpqk_qt = cpqk_qt + datas.get(i).getSurpassOther();

            kqqk_zz = kqqk_zz + datas.get(i).getLackPosition();
            kqqk_fz = kqqk_fz + datas.get(i).getLackDeputy();
            kqqk_qt = kqqk_qt + datas.get(i).getLackOther();
        }
        num_hdzs_zz.setText("（" + hdzs_zz + "）");
        num_hdzs_fz.setText("（" + hdzs_fz + "）");
        num_hdzs_qt.setText("（" + hdzs_qt + "）");
        num_spqk_zz.setText("（" + spqk_zz + "）");
        num_spqk_fz.setText("（" + spqk_fz + "）");
        num_spqk_qt.setText("（" + spqk_qt + "）");
        num_cpqk_zz.setText("（" + cpqk_zz + "）");
        num_cpqk_fz.setText("（" + cpqk_fz + "）");
        num_cpqk_qt.setText("（" + cpqk_qt + "）");
        num_kqqk_zz.setText("（" + kqqk_zz + "）");
        num_kqqk_fz.setText("（" + kqqk_fz + "）");
        num_kqqk_qt.setText("（" + kqqk_qt + "）");

    }

    public void showDrawer(DBBmBean item){
        tv_dw_title.setText(item.getDeptNameStr());
        tv_dr_dwjb2.setText(item.getOrgLevelName());
        tv_dr_dwxz2.setText(item.getOrgTypeNameStr());
        tv_dr_hdzs2.setText(item.getVerificationStr());
        tv_dr_sjpb2.setText(item.getActual());
        tv_dr_cpqk2.setText(item.getOvermatchStr());
        tv_dr_kqqk2.setText(item.getMismatchStr());
        tv_dr_cz2.setText(item.getFinanceTypeNameStr());

        drawer_layout.openDrawer(Gravity.RIGHT);
    }

    public void initRecyclerLeft(){
        recyclerViewLeft = $(R.id.recycler_view_left);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerViewLeft.setLayoutManager(linearLayoutManager);
        mAdapterLeft = new BmLeftAdapter(activity, new ArrayList<DBBmBean>());
        recyclerViewLeft.setAdapter(mAdapterLeft);

        recyclerViewLeft.addOnItemTouchListener(touchListenerLeft = new MyItemTouchListener());

        recyclerViewLeft.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                touchListenerRight.setCanTouch(newState == 0? false:true);
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (RecyclerView.SCROLL_STATE_IDLE != recyclerView.getScrollState()) {
                    recyclerViewRight.scrollBy(dx, dy);
                }

            }
        });

        mAdapterLeft.setOnItemClickListener(new BmLeftAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                showDrawer(datas.get(pos));
            }
        });
    }

    public void initRecyclerRight(){
        recyclerViewRight = $(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerViewRight.setLayoutManager(linearLayoutManager);
        mAdapterRight = new BmRightAdapter(activity, new ArrayList<DBBmBean>());
        recyclerViewRight.setAdapter(mAdapterRight);

        recyclerViewRight.addOnItemTouchListener(touchListenerRight = new MyItemTouchListener());

        recyclerViewRight.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                touchListenerLeft.setCanTouch(newState == 0? false:true);
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (RecyclerView.SCROLL_STATE_IDLE != recyclerView.getScrollState()) {
                    recyclerViewLeft.scrollBy(dx, dy);
                }

            }
        });

        mAdapterRight.setOnItemClickListener(new BmRightAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                showDrawer(datas.get(pos));
            }
        });
    }


    ListDialog listDialogOrg;
    List<ListDialogBean> dialogDatasOrg;
    ListDialog listDialogFinance;
    List<ListDialogBean> dialogDatasFinance;
    ListDialog listDialogCpkq;
    List<ListDialogBean> dialogDatasCpkq;
    String orgId,FinanceId,cpkqId;
    String key;

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_screen_dwlb:
                if(listDialogOrg == null){
                    listDialogOrg = new ListDialog(context, dialogDatasOrg);
                    listDialogOrg.setItemClickListener(new ListDialogAdapter.OnItemClickListener() {
                        @Override
                        public void onClick(int position) {
                            orgId = dialogDatasOrg.get(position).getsId();
                            tv_screen_dwlb.setText(TextUtils.isEmpty(orgId)?"单位类别":dialogDatasOrg.get(position).getName());
                            key = "";
                            et_search.setText("");
                            getData();
                            listDialogOrg.dismiss();
                        }
                    });
                }
                listDialogOrg.show();
                break;
            case R.id.tv_screen_dwxz:
                if(listDialogFinance == null){
                    listDialogFinance = new ListDialog(context, dialogDatasFinance);
                    listDialogFinance.setItemClickListener(new ListDialogAdapter.OnItemClickListener() {
                        @Override
                        public void onClick(int position) {
                            FinanceId = dialogDatasFinance.get(position).getsId();
                            tv_screen_dwxz.setText(TextUtils.isEmpty(FinanceId)?"单位类别":dialogDatasFinance.get(position).getName());
                            key = "";
                            et_search.setText("");
                            getData();
                            listDialogFinance.dismiss();
                        }
                    });
                }
                listDialogFinance.show();
                break;
            case R.id.tv_screen_cpkq:
                if(listDialogCpkq == null){
                    listDialogCpkq = new ListDialog(context, dialogDatasCpkq);
                    listDialogCpkq.setItemClickListener(new ListDialogAdapter.OnItemClickListener() {
                        @Override
                        public void onClick(int position) {
                            cpkqId = dialogDatasCpkq.get(position).getsId();
                            tv_screen_cpkq.setText(TextUtils.isEmpty(cpkqId)?"超配空缺筛选":dialogDatasCpkq.get(position).getName());
                            key = "";
                            et_search.setText("");
                            getData();
                            listDialogCpkq.dismiss();
                        }
                    });
                }
                listDialogCpkq.show();
                break;
        }
    }

    public void getDbOrgData(){
        DBBmOrgTypeBeanDao dbBmOrgTypeBeanDao = DaoManager.getInstance().getDaoSession().getDBBmOrgTypeBeanDao();
        QueryBuilder<DBBmOrgTypeBean> queryBuilder = dbBmOrgTypeBeanDao.queryBuilder();
        List<DBBmOrgTypeBean> orgs = queryBuilder.list();

        dialogDatasOrg = new ArrayList<>();
        dialogDatasOrg.add(new ListDialogBean("","全部"));
        for (int i=0;i<orgs.size();i++){
            dialogDatasOrg.add(new ListDialogBean(orgs.get(i).getDictValue(),orgs.get(i).getDictLabel()));
        }
    }

    public void getDbFinanceData(){
        DBBmFinanceTypeBeanDao dbBmFinanceTypeBeanDao = DaoManager.getInstance().getDaoSession().getDBBmFinanceTypeBeanDao();
        QueryBuilder<DBBmFinanceTypeBean> queryBuilder = dbBmFinanceTypeBeanDao.queryBuilder();
        List<DBBmFinanceTypeBean> finances = queryBuilder.list();

        dialogDatasFinance = new ArrayList<>();
        dialogDatasFinance.add(new ListDialogBean("","全部"));
        for (int i=0;i<finances.size();i++){
            dialogDatasFinance.add(new ListDialogBean(finances.get(i).getDictValue(),finances.get(i).getDictLabel()));
        }
    }

    public void getDbCpkqData(){
        dialogDatasCpkq = new ArrayList<>();
        dialogDatasCpkq.add(new ListDialogBean("","全部"));
        dialogDatasCpkq.add(new ListDialogBean("1","超配单位"));
        dialogDatasCpkq.add(new ListDialogBean("2","空缺单位"));
    }
}
