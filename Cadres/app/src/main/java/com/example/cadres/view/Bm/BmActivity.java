package com.example.cadres.view.Bm;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.cadres.greendao.gen.DBBmBeanDao;
import com.example.cadres.R;
import com.example.cadres.adapter.BmLeftAdapter;
import com.example.cadres.adapter.BmRightAdapter;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoManager;
import com.example.cadres.utils.greendao.DaoUtilsStore;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BmActivity extends BaseActivity {

    EditText et_search;
    RecyclerView recyclerViewRight;
    RecyclerView recyclerViewLeft;

    BmLeftAdapter mAdapterLeft;
    BmRightAdapter mAdapterRight;

    CommonDaoUtils<DBBmBean> dBBmDaoUtils;
    List<DBBmBean> datas;

    TextView tv_dw_title,tv_dr_dwjb2,tv_dr_dwxz2,tv_dr_hdzs2,tv_dr_sjpb2,tv_dr_cpqk2,tv_dr_kqqk2,tv_dr_cz2;
    DrawerLayout drawer_layout;

    TextView num_hdzs_zz,num_hdzs_fz,num_hdzs_qt,num_spqk_zz,num_spqk_fz,num_spqk_qt,num_cpqk_zz,num_cpqk_fz,num_cpqk_qt,num_kqqk_zz,num_kqqk_fz,num_kqqk_qt;

    @Override
    public int getLayoutId() {
        return R.layout.activity_bm_drawer;
    }

    @Override
    public void initView() {
        showLeftIcon();
        showLLRightGoHome();
        showTitleTv("职务名册表");

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
                    String key = et_search.getText().toString().trim();
                    getData(key);
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

        getData("");
    }

    public List<DBBmBean> getDbList(String key) {
        List<DBBmBean> dbList = new ArrayList<>();
        DBBmBeanDao dbBmBeanDao = DaoManager.getInstance().getDaoSession().getDBBmBeanDao();
        QueryBuilder<DBBmBean> queryBuilder = dbBmBeanDao.queryBuilder();

        if(!TextUtils.isEmpty(key)){
            queryBuilder.where(DBBmBeanDao.Properties.DeptName.like("%" + key + "%")
                    ,DBBmBeanDao.Properties.DeptType.eq(1));
            dbList = queryBuilder.list();
        }else{
            queryBuilder.where(DBBmBeanDao.Properties.DeptType.eq(1));
            dbList = queryBuilder.list();
        }
        LogUtil.e("数据库条数：" + dbList.size());
        return dbList;
    }

    public void getData(String key) {
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

        recyclerViewLeft.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
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

        recyclerViewRight.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
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
}
