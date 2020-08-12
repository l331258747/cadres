package com.example.cadres.view.Gb;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cadres.greendao.gen.DBBmBeanDao;
import com.cadres.greendao.gen.DBGbBeanDao;
import com.cadres.greendao.gen.DBGbCadreDeptListBeanDao;
import com.example.cadres.R;
import com.example.cadres.adapter.GbAdapter;
import com.example.cadres.adapter.GbLeftAdapter;
import com.example.cadres.adapter.ListDialogAdapter;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.common.BmLeftBean;
import com.example.cadres.bean.common.ListDialogBean;
import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.beanDB.DBBmExplainBean;
import com.example.cadres.beanDB.DBGbBean;
import com.example.cadres.beanDB.DBGbCadreDeptListBean;
import com.example.cadres.dialog.ListDialog;
import com.example.cadres.utils.AppUtils;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoManager;
import com.example.cadres.utils.greendao.DaoUtilsStore;
import com.example.cadres.utils.myData.DialogBmData;
import com.example.cadres.utils.myData.GbDrawerData;
import com.example.cadres.view.search.SearchActivity;

import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GbActivity extends BaseActivity implements View.OnClickListener {

    Group group_View_top,group_gb,group_gwy;
    TextView tv_top_title, tv_top_btn, tv_top_hdzs2, tv_top_sjpb2, tv_top_cpqk2, tv_top_kqqk2;
    TextView tv_right_btn,tv_right_content;
    View view_menu;
    EditText et_search,et_left_search;
    RecyclerView recyclerView;

    DrawerLayout drawer_layout;
    NestedScrollView scrollView;
    ConstraintLayout layout_bm;
    LinearLayout layout_info;
    GbDrawerData gbDrawerData;

    GbAdapter mAdapter;

    CommonDaoUtils<DBGbBean> dBGbDaoUtils;
    List<DBGbBean> datas;

    DialogBmData dialogBmData;
    List<BmLeftBean> bmLeftBeans2 = new ArrayList<>();

    String type;
    String title;

    @Override
    public int getLayoutId() {
        return R.layout.activity_gb_drawer;
    }

    @Override
    public void initView() {
        title = intent.getStringExtra("title");
        type = intent.getStringExtra("type");

        showLeftIcon();
        showLLRightGoHome();

        showTitleTv(title);

        et_search = findViewById(R.id.et_search);

        group_View_top = findViewById(R.id.group_View_top);
        group_gb = findViewById(R.id.group_gb);
        group_gwy = findViewById(R.id.group_gwy);

        tv_top_title = findViewById(R.id.tv_top_title);
        tv_top_btn = findViewById(R.id.tv_top_btn);
        tv_top_hdzs2 = findViewById(R.id.tv_top_hdzs2);
        tv_top_sjpb2 = findViewById(R.id.tv_top_sjpb2);
        tv_top_cpqk2 = findViewById(R.id.tv_top_cpqk2);
        tv_top_kqqk2 = findViewById(R.id.tv_top_kqqk2);
        view_menu = findViewById(R.id.view_menu);

        view_menu.setOnClickListener(this);
        tv_top_btn.setOnClickListener(this);

        et_search.setOnClickListener(this);

        initTitleTab();

        initRecycler();

        initDrawer();
        initDrawerLeft();
        initDrawerRight();
        initDrawerGbInfo();
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

    private void initDrawerLeft() {
        initLeftSearch();
        initRecyclerLeft();
    }

    private void initDrawerRight(){
        layout_bm = findViewById(R.id.layout_bm);
        tv_right_btn = findViewById(R.id.tv_right_btn);
        tv_right_content = findViewById(R.id.tv_right_content);
        tv_right_btn.setOnClickListener(this);
    }

    private void initDrawerGbInfo(){
        scrollView = findViewById(R.id.scrollView);
        layout_info = findViewById(R.id.layout_info);
        gbDrawerData = new GbDrawerData(context, layout_info);
        gbDrawerData.initView();
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

    private void initLeftSearch() {
        et_left_search = findViewById(R.id.et_left_search);
        et_left_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                /*判断是否是“搜索”键*/
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String key = et_left_search.getText().toString().trim();
                    if(!TextUtils.isEmpty(key)){
                        getDbBmList(key);
                        leftAdapter.setData(bmLeftBeans2);
                        AppUtils.HideKeyboard(et_left_search);
                    }
                    return true;
                }
                return false;
            }
        });

        et_left_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(TextUtils.isEmpty(et_left_search.getText().toString())){
                    getDbBmList("");
                    leftAdapter.setData(bmLeftBeans2);
                }
            }
        });
    }

    @Override
    public void initData() {
        dialogBmData = new DialogBmData();

        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
        dBGbDaoUtils = _Store.getGbDaoUtils();
        dBBmDaoUtils = _Store.getBmDaoUtils();
        dBBmExplainDaoUtils = _Store.getBmExplainDaoUtils();

        deptId = getDefaultDeptId();
        mAdapter.setData(getGbBmData());
        getDbBmList("");
        leftAdapter.setData(bmLeftBeans2,deptId);
    }

    //初始化recyclerview
    public void initRecycler() {
        recyclerView = $(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new GbAdapter(activity, new ArrayList<DBGbBean>(),type);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new GbAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
//                Intent intent = new Intent(context, GbDetailActivity.class);
//                intent.putExtra("ID", datas.get(pos).getBaseId());
//                startActivity(intent);
                gbDrawerData.getData(datas.get(pos).getBaseId());

                layout_bm.setVisibility(View.GONE);
                layout_info.setVisibility(View.VISIBLE);
                scrollView.scrollTo(0,0);

                drawer_layout.openDrawer(Gravity.RIGHT);
            }
        });
    }

    //--------------left
    List<DBBmBean> dbBmList;

    public List<DBBmBean> getDbBmList(String key) {
        dbBmList = new ArrayList<>();
        if(TextUtils.isEmpty(key)){
            dbBmList = dBBmDaoUtils.queryAll();
            LogUtil.e("数据库条数：" + dbBmList.size());
            bmLeftBeans2 = dialogBmData.getBmLeftBean(dbBmList);
        }else{
            String sql = "where DEPT_NAME like ?";
            String[] condition = new String[]{"%" + key + "%"};
            dbBmList = dBBmDaoUtils.queryByNativeSql(sql, condition);
            bmLeftBeans2 = dialogBmData.getBmLeftBean2(dbBmList);
        }
        return dbBmList;
    }

    RecyclerView recyclerViewLeft;
    GbLeftAdapter leftAdapter;
    CommonDaoUtils<DBBmBean> dBBmDaoUtils;

    //初始化recyclerview
    public void initRecyclerLeft() {
        recyclerViewLeft = $(R.id.recycler_view_left);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerViewLeft.setLayoutManager(linearLayoutManager);
        leftAdapter = new GbLeftAdapter(activity, new ArrayList<BmLeftBean>());
        recyclerViewLeft.setAdapter(leftAdapter);

        leftAdapter.setOnItemClickListener(new GbLeftAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                DBBmBean item = getDBBmBean(pos);
                if(item == null) return;
                leftAdapter.setItemData(item.getDeptId());

                if(TextUtils.equals(item.getDeptType(),"1")){
                    group_View_top.setVisibility(View.VISIBLE);
                    tv_top_title.setText(item.getDeptName());
                    tv_top_hdzs2.setText(item.getVerification());
                    tv_top_sjpb2.setText(item.getActual());
                    tv_top_cpqk2.setText(item.getOvermatch());
                    tv_top_kqqk2.setText(item.getMismatch());
                }else{
                    group_View_top.setVisibility(View.GONE);
                }

                deptId = item.getDeptId();
                drawer_layout.closeDrawer(Gravity.LEFT);
                AppUtils.HideKeyboard(et_left_search);

                if(item.getParentId() == 0){
                    deptId = 0;
                }
                mAdapter.setData(getGbBmData());

            }
        });
    }

    public DBBmBean getDBBmBean(int pos){
        for (int i=0;i<dbBmList.size();i++){
            if(bmLeftBeans2.get(pos).getId() == dbBmList.get(i).getDeptId()){
                return dbBmList.get(i);
            }
        }
        return null;
    }

    //------------------right

    List<ListDialogBean> dialogDatas;
    ListDialog listDialog;
    List<DBBmExplainBean> dbBmExplainList;
    CommonDaoUtils<DBBmExplainBean> dBBmExplainDaoUtils;
    int deptId;

    public List<DBBmExplainBean> getDbBmExplainList(int id) {
        dbBmExplainList = new ArrayList<>();
        String sql = "where DEPT_ID = ?";
        String[] condition = new String[]{"" + id};
        dbBmExplainList = dBBmExplainDaoUtils.queryByNativeSql(sql, condition);
        LogUtil.e("数据库条数：" + dbBmExplainList.size());

        return dbBmExplainList;
    }

    public DBBmExplainBean getRightData(int pos) {
        if (dbBmExplainList.size() == 0) return null;
        DBBmExplainBean item = dbBmExplainList.get(pos);
        return item;
    }

    public void setDialogDatas() {
        dialogDatas = new ArrayList<>();
        for (int i = 0; i < dbBmExplainList.size(); i++) {
            DBBmExplainBean dbBmExplainBean = dbBmExplainList.get(i);
            ListDialogBean item = new ListDialogBean(dbBmExplainBean.getExplainId(), dbBmExplainBean.getYearStr());
            dialogDatas.add(item);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_right_btn:
                listDialog = new ListDialog(context, dialogDatas);
                listDialog.setItemClickListener(new ListDialogAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(int position) {

                        DBBmExplainBean item = getRightData(position);
                        if (item == null) return;

                        tv_right_btn.setText(item.getYearStr());
                        tv_right_content.setText(item.getOrgExplain());

                        listDialog.dismiss();
                    }
                });
                listDialog.show();
                break;
            case R.id.view_menu:
                drawer_layout.openDrawer(Gravity.LEFT);
                break;

            case R.id.tv_top_btn:
                getDbBmExplainList(deptId);
                setDialogDatas();

                DBBmExplainBean item = getRightData(0);
                if (item == null) return;

                tv_right_btn.setText(item.getYearStr());
                tv_right_content.setText(item.getOrgExplain());

                layout_bm.setVisibility(View.VISIBLE);
                layout_info.setVisibility(View.GONE);
                scrollView.scrollTo(0,0);

                drawer_layout.openDrawer(Gravity.RIGHT);
                break;
            case R.id.et_search:
                Intent intent = new Intent(context, SearchActivity.class);
                intent.putExtra("type",type);
                startActivity(intent);
                break;
        }
    }


    //-----------------------------搜部门干部 多表查询 orderAsc正序 orderDesc倒序
    public List<DBGbBean> getDbGbBmList(int deptId, Property orderBy, boolean isAsc) {
        List<DBGbBean> dbList = new ArrayList<>();
        DBGbBeanDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBGbBeanDao();
        QueryBuilder<DBGbBean> queryBuilder = dbGbBeanDao.queryBuilder();
        queryBuilder.where(DBGbBeanDao.Properties.Type.like("%" + type + "%"));
        if(deptId != 0){
            queryBuilder.join(DBGbBeanDao.Properties.BaseId, DBGbCadreDeptListBean.class, DBGbCadreDeptListBeanDao.Properties.BaseId)
                    .where(DBGbCadreDeptListBeanDao.Properties.DeptId.eq(deptId));
            queryBuilder.orderAsc(DBGbBeanDao.Properties.Ranking);
            queryBuilder.distinct();
        }
        if(orderBy != null){
            if (isAsc) {
                queryBuilder.orderAsc(orderBy);
            } else {
                queryBuilder.orderDesc(orderBy);
            }
        }
        dbList = queryBuilder.list();
        LogUtil.e("数据库条数：" + dbList.size());
        return dbList;
    }

    Property orderBy;
    boolean isAsc;
    public List<DBGbBean> getGbBmData() {
        datas = new ArrayList<>();
        List<DBGbBean> dbList = getDbGbBmList(deptId, orderBy, isAsc);
        if (dbList != null) {
            datas = dbList;
        }
        return datas;
    }

    private int getDefaultDeptId() {
        DBBmBeanDao dbBmBeanDao = DaoManager.getInstance().getDaoSession().getDBBmBeanDao();
        QueryBuilder<DBBmBean> queryBuilder = dbBmBeanDao.queryBuilder();
        queryBuilder.where(DBBmBeanDao.Properties.DefulatOrg.eq(1));
        List<DBBmBean> dates = queryBuilder.list();
        LogUtil.e("数据库条数：" + dates.size());
        if(dates == null || dates.size() == 0)
            return 0;
        else
            return dates.get(0).getDeptId();
    }
}
