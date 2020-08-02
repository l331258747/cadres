package com.example.cadres.view.dsjty;

import android.view.Gravity;
import android.view.View;
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

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TyListActivity extends BaseActivity {

    RecyclerView recyclerView;

    GbAdapter mAdapter;

    TextView tv_search_count;

    String title;

    CommonDaoUtils<DBGbBean> dBGbDaoUtils;
    List<DBGbBean> datas;

    CommonDaoUtils<DBTyHjList> dBTyhjListDaoUtils;
    List<String> ids;
    int type;

    DrawerLayout drawer_layout;
    NestedScrollView scrollView;
    LinearLayout layout_info;
    GbDrawerData gbDrawerData;

    @Override
    public int getLayoutId() {
        return R.layout.activity_ty_list_drawer;
    }

    @Override
    public void initView() {
        title = intent.getStringExtra("title");
        type = intent.getIntExtra("type",0);

        showLeftIcon();
        showLLRightGoHome();
        showTitleTv(title);

        tv_search_count = findViewById(R.id.tv_search_count);

        initRecycler();

        initDrawer();
        initDrawerGbInfo();
    }

    @Override
    public void initData() {
        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
        dBGbDaoUtils = _Store.getGbDaoUtils();
        dBTyhjListDaoUtils = _Store.getTyHjListDaoUtils();

        getDbHjList();
        getDbList();
        mAdapter.setData(getData());
    }

    private void getDbHjList() {
        DBTyHjListDao dbHjListBeanDao = DaoManager.getInstance().getDaoSession().getDBTyHjListDao();
        QueryBuilder<DBTyHjList> queryBuilder = dbHjListBeanDao.queryBuilder();

        if(queryBuilder.count() == 0) return;

        DBTyHjList dbTyHjList = queryBuilder.unique();

        switch (type){
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
        DBGbBeanDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBGbBeanDao();
        QueryBuilder<DBGbBean> queryBuilder = dbGbBeanDao.queryBuilder();
        queryBuilder.where(DBGbBeanDao.Properties.BaseId.in(ids));
        LogUtil.e("干部 数据条数："+queryBuilder.count());

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
}
