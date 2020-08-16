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

import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TyListActivity extends BaseActivity implements View.OnClickListener {

    Group group_gb,group_gwy;
    RecyclerView recyclerView;

    GbAdapter mAdapter;

    TextView tv_search_count;

    String tyTitle;

    CommonDaoUtils<DBGbBean> dBGbDaoUtils;
    List<DBGbBean> datas;

    CommonDaoUtils<DBTyHjList> dBTyhjListDaoUtils;
    List<String> ids;
    int tyType;

    LinearLayout ll_xrzsj, ll_xrzwccsj, ll_rzjsj, ll_rzjqssj, ll_cjgzsj, ll_csny;
    ImageView iv_xrzsj, iv_xrzwccsj, iv_rzjsj, iv_rzjqssj, iv_cjgzsj, iv_csny;
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
        group_gb = findViewById(R.id.group_gb);
        group_gwy = findViewById(R.id.group_gwy);

        initTitleTab();
        initRecycler();

        initDrawer();
        initDrawerGbInfo();

        initSort();
    }

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
        mAdapter.setData(getData());
    }

    private void initTitleTab() {
        group_gb.setVisibility(View.GONE);
        group_gwy.setVisibility(View.GONE);
        if(TextUtils.equals(type,"2")){
            group_gwy.setVisibility(View.VISIBLE);
        }else{
            group_gb.setVisibility(View.VISIBLE);
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
        mAdapter.setData(getData());
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

    //初始化recyclerview
    public void initRecycler() {
        recyclerView = $(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new GbAdapter(activity, new ArrayList<DBGbBean>(),"1");
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new GbAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
//                Intent intent = new Intent(context, GbDetailActivity.class);
//                intent.putExtra("ID", datas.get(pos).getBaseId());
//                startActivity(intent);

                gbDrawerData.getData(datas.get(pos).getBaseId());
                scrollView.scrollTo(0,0);
                drawer_layout.openDrawer(Gravity.RIGHT);
            }
        });
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
                sortDate(order_xrzsj);
                break;
            case R.id.ll_xrzwccsj:
                sortDate(order_xrzwccsj);
                break;
            case R.id.ll_rzjsj:
                sortDate(order_rzjsj);
                break;
            case R.id.ll_rzjqssj:
                sortDate(order_rzjqssj);
                break;
            case R.id.ll_cjgzsj:
                sortDate(order_cjgzsj);
                break;
            case R.id.ll_csny:
                sortDate(order_csny);
                break;
        }
    }
}
