package com.example.cadres.view.dsjty;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cadres.greendao.gen.DBGbBeanDao;
import com.cadres.greendao.gen.DBTyHjListDao;
import com.example.cadres.R;
import com.example.cadres.adapter.GbAdapter;
import com.example.cadres.adapter.GbAdapterGwy;
import com.example.cadres.adapter.GbAdapterHbgb;
import com.example.cadres.adapter.GbAdapterLdgb;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.beanDB.DBGbBean;
import com.example.cadres.beanDB.DBTyHjList;
import com.example.cadres.utils.GsonUtil;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoManager;
import com.example.cadres.utils.greendao.DaoUtilsStore;
import com.example.cadres.utils.myData.GbDrawerData;

import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TyListActivity extends BaseActivity implements View.OnClickListener {

    RecyclerView recyclerView;

    GbAdapterLdgb mAdapterLdgb;
    GbAdapterGwy mAdapterGwy;
    GbAdapterHbgb mAdapterHbgb;

    TextView tv_search_count;

    String tyTitle;

    CommonDaoUtils<DBGbBean> dBGbDaoUtils;
    List<DBGbBean> datas;

    CommonDaoUtils<DBTyHjList> dBTyhjListDaoUtils;
    List<String> ids;
    int tyType;

    private final int order_xrzsj = 1;
    private final int order_xrzwccsj = 2;
    private final int order_rzjsj = 3;
    private final int order_rzjqssj = 4;
    private final int order_cjgzsj = 5;
    private final int order_csny = 6;


    DrawerLayout drawer_layout;
    NestedScrollView scrollView;
    LinearLayout layout_info;
    GbDrawerData gbDrawerData;

    String type;

    @Override
    public int getLayoutId() {
        return R.layout.activity_ty_list_drawer;
    }

    @Override
    public void initView() {
        tyTitle = intent.getStringExtra("tyTitle");
        tyType = intent.getIntExtra("tyType",0);

        type = "1";

        showLeftIcon();
        showLLRightGoHome();
        showTitleTv(tyTitle);

        tv_search_count = findViewById(R.id.tv_search_count);

        initRecycler();

        initDrawer();
        initDrawerGbInfo();

        initSort();

        initTitleTab();
    }

    LinearLayout ll_xrzsj, ll_xrzwccsj, ll_rzjsj, ll_rzjqssj, ll_cjgzsj, ll_csny;
    ImageView iv_xrzsj, iv_xrzwccsj, iv_rzjsj, iv_rzjqssj, iv_cjgzsj, iv_csny;
    private void initSort() {
        ll_xrzsj = findViewById(R.id.ll_xrzsj);
        ll_xrzwccsj = findViewById(R.id.ll_xrzwccsj);
        ll_rzjsj = findViewById(R.id.ll_rzjsj);
        ll_rzjqssj = findViewById(R.id.ll_rzjqssj);
        ll_cjgzsj = findViewById(R.id.ll_cjgzsj);
        ll_csny = findViewById(R.id.ll_csny);
        iv_xrzsj = findViewById(R.id.iv_xrzsj);
        iv_xrzwccsj = findViewById(R.id.iv_xrzwccsj);
        iv_rzjsj = findViewById(R.id.iv_rzjsj);
        iv_rzjqssj = findViewById(R.id.iv_rzjqssj);
        iv_cjgzsj = findViewById(R.id.iv_cjgzsj);
        iv_csny = findViewById(R.id.iv_csny);

        if (TextUtils.equals(type, "3")) {
            ll_csny = findViewById(R.id.ll_csny_hbgb);
            iv_csny = findViewById(R.id.iv_csny_hbgb);
        } else if(TextUtils.equals(type, "2")){
            ll_xrzsj = findViewById(R.id.ll_xrzsj_gwy);
            ll_rzjqssj = findViewById(R.id.ll_rzjqssj_gwy);
            ll_cjgzsj = findViewById(R.id.ll_cjgzsj_gwy);
            ll_csny = findViewById(R.id.ll_csny_gwy);
            iv_xrzsj = findViewById(R.id.iv_xrzsj_gwy);
            iv_rzjqssj = findViewById(R.id.iv_rzjqssj_gwy);
            iv_cjgzsj = findViewById(R.id.iv_cjgzsj_gwy);
            iv_csny = findViewById(R.id.iv_csny_gwy);
        } else {
            ll_xrzsj = findViewById(R.id.ll_xrzsj_ldgb);
            ll_xrzwccsj = findViewById(R.id.ll_xrzwccsj_ldgb);
            ll_rzjsj = findViewById(R.id.ll_rzjsj_ldgb);
            ll_csny = findViewById(R.id.ll_csny_ldgb);
            iv_xrzsj = findViewById(R.id.iv_xrzsj_ldgb);
            iv_xrzwccsj = findViewById(R.id.iv_xrzwccsj_ldgb);
            iv_rzjsj = findViewById(R.id.iv_rzjsj_ldgb);
            iv_csny = findViewById(R.id.iv_csny_ldgb);
        }

        ll_xrzsj.setOnClickListener(this);
        ll_xrzwccsj.setOnClickListener(this);
        ll_rzjsj.setOnClickListener(this);
        ll_rzjqssj.setOnClickListener(this);
        ll_cjgzsj.setOnClickListener(this);
        ll_csny.setOnClickListener(this);
    }

    int mSortType;
    Property orderBy;
    boolean isAsc;

    private void sortDate(int sortType) {
        iv_xrzsj.setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.ic_sort_defult));
        iv_xrzwccsj.setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.ic_sort_defult));
        iv_rzjsj.setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.ic_sort_defult));
        iv_rzjqssj.setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.ic_sort_defult));
        iv_cjgzsj.setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.ic_sort_defult));
        iv_csny.setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.ic_sort_defult));

        recyclerView.scrollToPosition(0);

        if (sortType == 0) {
            isAsc = true;
            mSortType = sortType;
            orderBy = null;
            return;
        }
        isAsc = mSortType == sortType ? !isAsc : true;

        if (sortType == order_xrzsj) {
            orderBy = DBGbBeanDao.Properties.CurrentPositionTime;
            iv_xrzsj.setImageDrawable(ContextCompat.getDrawable(context, isAsc ? R.mipmap.ic_sort_down : R.mipmap.ic_sort_up));
        } else if (sortType == order_xrzwccsj) {
            orderBy = DBGbBeanDao.Properties.CurrentRankTime;
            iv_xrzwccsj.setImageDrawable(ContextCompat.getDrawable(context, isAsc ? R.mipmap.ic_sort_down : R.mipmap.ic_sort_up));
        } else if (sortType == order_rzjsj) {
            orderBy = DBGbBeanDao.Properties.FunctionaryRankTime;
            iv_rzjsj.setImageDrawable(ContextCompat.getDrawable(context, isAsc ? R.mipmap.ic_sort_down : R.mipmap.ic_sort_up));
        } else if (sortType == order_rzjqssj) {
            orderBy = DBGbBeanDao.Properties.FunctionaryRankStartTime;
            iv_rzjqssj.setImageDrawable(ContextCompat.getDrawable(context, isAsc ? R.mipmap.ic_sort_down : R.mipmap.ic_sort_up));
        } else if (sortType == order_cjgzsj) {
            orderBy = DBGbBeanDao.Properties.WorkTime;
            iv_cjgzsj.setImageDrawable(ContextCompat.getDrawable(context, isAsc ? R.mipmap.ic_sort_down : R.mipmap.ic_sort_up));
        } else if (sortType == order_csny) {
            orderBy = DBGbBeanDao.Properties.Birthday;
            iv_csny.setImageDrawable(ContextCompat.getDrawable(context, isAsc ? R.mipmap.ic_sort_down : R.mipmap.ic_sort_up));
        } else {
            orderBy = null;
        }
        mSortType = sortType;

        if (orderBy == null)
            return;
        getDbList();
        setAdapterData(getData());
    }

    public void setAdapterData(List<DBGbBean> list){
        if(TextUtils.equals(type,"3")){
            mAdapterHbgb.setData(list);
        }else if(TextUtils.equals(type,"2")){
            mAdapterGwy.setData(list);
        }else{
            mAdapterLdgb.setData(list);
        }
    }

    ConstraintLayout cl_gb_list_title_ldgb,cl_gb_list_title_gwy,cl_gb_list_title_hbgb;
    private void initTitleTab() {
        cl_gb_list_title_ldgb = findViewById(R.id.cl_gb_list_title_ldgb);
        cl_gb_list_title_gwy = findViewById(R.id.cl_gb_list_title_gwy);
        cl_gb_list_title_hbgb = findViewById(R.id.cl_gb_list_title_hbgb);

        if (TextUtils.equals(type, "3")) {
            cl_gb_list_title_ldgb.setVisibility(View.GONE);
            cl_gb_list_title_gwy.setVisibility(View.GONE);
            cl_gb_list_title_hbgb.setVisibility(View.VISIBLE);
        } else if(TextUtils.equals(type, "2")){
            cl_gb_list_title_ldgb.setVisibility(View.GONE);
            cl_gb_list_title_gwy.setVisibility(View.VISIBLE);
            cl_gb_list_title_hbgb.setVisibility(View.GONE);
        } else if(TextUtils.equals(type, "1")){
            cl_gb_list_title_ldgb.setVisibility(View.VISIBLE);
            cl_gb_list_title_gwy.setVisibility(View.GONE);
            cl_gb_list_title_hbgb.setVisibility(View.GONE);
        }
    }

    @Override
    public void initData() {
        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
        dBGbDaoUtils = _Store.getGbDaoUtils();
        dBTyhjListDaoUtils = _Store.getTyHjListDaoUtils();

        sortDate(0);

        getDbHjList();
        getDbList();
        setAdapterData(getData());

    }

    private void getDbHjList() {
        DBTyHjListDao dbHjListBeanDao = DaoManager.getInstance().getDaoSession().getDBTyHjListDao();
        QueryBuilder<DBTyHjList> queryBuilder = dbHjListBeanDao.queryBuilder();

        if(queryBuilder.count() == 0) return;

        DBTyHjList dbTyHjList = queryBuilder.unique();

        switch (tyType){
            case 0:
                ids = GsonUtil.convertJson2Array(dbTyHjList.getScw());
                break;
            case 1:
                ids = GsonUtil.convertJson2Array(dbTyHjList.getSzf());
                break;
            case 2:
                ids = GsonUtil.convertJson2Array(dbTyHjList.getSrd());
                break;
            case 3:
                ids = GsonUtil.convertJson2Array(dbTyHjList.getSzx());
                break;
        }
    }

    List<DBGbBean> dbList;
    public void getDbList() {
        if(ids == null || ids.size() == 0) return;
        if(ids.size() > 900){
            ids = ids.subList(0,998);
        }

        DBGbBeanDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBGbBeanDao();
        QueryBuilder<DBGbBean> queryBuilder = dbGbBeanDao.queryBuilder();
        queryBuilder.where(DBGbBeanDao.Properties.BaseId.in(ids));
        LogUtil.e("干部 数据条数："+queryBuilder.count());

        if (orderBy != null) {
            if (isAsc) {
                queryBuilder.orderAsc(orderBy);
            } else {
                queryBuilder.orderDesc(orderBy);
            }
        }

        dbList = queryBuilder.list();
        tv_search_count.setText("据符合筛选条件的数据共" + dbList.size() + "条");
    }

    public List<DBGbBean> getData() {
        datas = new ArrayList<>();
        if (dbList != null) {
            datas = dbList;
        }
        return datas;
    }

//    //初始化recyclerview
//    public void initRecycler() {
//        recyclerView = $(R.id.recycler_view);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        mAdapter = new GbAdapter(activity, new ArrayList<DBGbBean>(),"1");
//        recyclerView.setAdapter(mAdapter);
//
//        mAdapter.setOnItemClickListener(new GbAdapter.OnItemClickListener() {
//            @Override
//            public void onClick(int pos) {
////                Intent intent = new Intent(context, GbDetailActivity.class);
////                intent.putExtra("ID", datas.get(pos).getBaseId());
////                startActivity(intent);
//
//                gbDrawerData.getData(datas.get(pos).getBaseId());
//                scrollView.scrollTo(0,0);
//                drawer_layout.openDrawer(Gravity.RIGHT);
//            }
//        });
//    }

    //初始化recyclerview
    public void initRecycler() {
        recyclerView = $(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        if(TextUtils.equals(type,"3")){
            mAdapterHbgb = new GbAdapterHbgb(activity, new ArrayList<DBGbBean>());
            recyclerView.setAdapter(mAdapterHbgb);
            recyclerView.getItemAnimator().setChangeDuration(0);
            mAdapterHbgb.setOnItemClickListener(new GbAdapterHbgb.OnItemClickListener() {
                @Override
                public void onClick(int pos) {
                    gbDrawerData.getData(datas.get(pos).getBaseId());
                    scrollView.scrollTo(0, 0);
                    drawer_layout.openDrawer(Gravity.RIGHT);
                }
            });
        }else if(TextUtils.equals(type,"2")){
            mAdapterGwy = new GbAdapterGwy(activity, new ArrayList<DBGbBean>());
            recyclerView.setAdapter(mAdapterGwy);
            recyclerView.getItemAnimator().setChangeDuration(0);
            mAdapterGwy.setOnItemClickListener(new GbAdapterGwy.OnItemClickListener() {
                @Override
                public void onClick(int pos) {
                    gbDrawerData.getData(datas.get(pos).getBaseId());
                    scrollView.scrollTo(0, 0);
                    drawer_layout.openDrawer(Gravity.RIGHT);
                }
            });
        }else{
            mAdapterLdgb = new GbAdapterLdgb(activity, new ArrayList<DBGbBean>());
            recyclerView.setAdapter(mAdapterLdgb);
            recyclerView.getItemAnimator().setChangeDuration(0);
            mAdapterLdgb.setOnItemClickListener(new GbAdapterLdgb.OnItemClickListener() {
                @Override
                public void onClick(int pos) {
                    gbDrawerData.getData(datas.get(pos).getBaseId());
                    scrollView.scrollTo(0, 0);
                    drawer_layout.openDrawer(Gravity.RIGHT);
                }
            });
        }
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_xrzsj:
            case R.id.ll_xrzsj_ldgb:
            case R.id.ll_xrzsj_gwy:
                sortDate(order_xrzsj);
                break;
            case R.id.ll_xrzwccsj:
            case R.id.ll_xrzwccsj_ldgb:
                sortDate(order_xrzwccsj);
                break;
            case R.id.ll_rzjsj:
            case R.id.ll_rzjsj_ldgb:
                sortDate(order_rzjsj);
                break;
            case R.id.ll_rzjqssj:
            case R.id.ll_rzjqssj_gwy:
                sortDate(order_rzjqssj);
                break;
            case R.id.ll_cjgzsj:
            case R.id.ll_cjgzsj_gwy:
                sortDate(order_cjgzsj);
                break;
            case R.id.ll_csny:
            case R.id.ll_csny_ldgb:
            case R.id.ll_csny_gwy:
            case R.id.ll_csny_hbgb:
                sortDate(order_csny);
                break;
        }
    }
}
