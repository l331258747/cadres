package com.example.cadres.view.Bm;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.cadres.greendao.gen.DBGwyDWLBDao;
import com.cadres.greendao.gen.DBGwyFGDJDao;
import com.cadres.greendao.gen.DBGwyFGZLDJDao;
import com.cadres.greendao.gen.DBGwyJWJSDao;
import com.cadres.greendao.gen.DBGwyZHGLDao;
import com.cadres.greendao.gen.DBGwyZQDao;
import com.example.cadres.R;
import com.example.cadres.adapter.BmLeftAdapter;
import com.example.cadres.adapter.BmRightFgdjAdapter;
import com.example.cadres.adapter.BmRightFgdjzlAdapter;
import com.example.cadres.adapter.BmRightJwjsAdapter;
import com.example.cadres.adapter.BmRightZhAdapter;
import com.example.cadres.adapter.BmRightZqAdapter;
import com.example.cadres.adapter.ListDialogAdapter;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.common.ListDialogBean;
import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.beanDB.DBGwyDWLB;
import com.example.cadres.beanDB.DBGwyFGDJ;
import com.example.cadres.beanDB.DBGwyFGZLDJ;
import com.example.cadres.beanDB.DBGwyJWJS;
import com.example.cadres.beanDB.DBGwyZHGL;
import com.example.cadres.beanDB.DBGwyZQ;
import com.example.cadres.dialog.ListDialog;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.greendao.DaoManager;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BmGwyActivity extends BaseActivity implements View.OnClickListener {

    EditText et_search;

    RecyclerView recyclerViewRight;
    RecyclerView recyclerViewLeft;

    BmLeftAdapter mAdapterLeft;
    BmRightZhAdapter bmRightZhAdapter;
    BmRightFgdjAdapter bmRightFgdjAdapter;
    BmRightFgdjzlAdapter bmRightFgdjzlAdapter;
    BmRightJwjsAdapter bmRightJwjsAdapter;
    BmRightZqAdapter bmRightZqAdapter;

    List<DBGwyZHGL> datasZHGL;
    List<DBGwyZQ> datasZQ;
    List<DBGwyFGDJ> datasFGDJ;
    List<DBGwyFGZLDJ> datasFGZLDJ;
    List<DBGwyJWJS> datasJWJS;

    List<DBBmBean> datasLeft;

    TextView num_hdzs_1,num_hdzs_2,num_hdzs_3,num_hdzs_4,num_hdzs_5;
    TextView num_spqk_1,num_spqk_2,num_spqk_3,num_spqk_4,num_spqk_5,num_spqk_6,num_spqk_7,num_spqk_8,num_spqk_9;
    TextView num_cpqk_1,num_cpqk_2,num_cpqk_3,num_cpqk_4,num_cpqk_5;
    TextView num_kqqk_1,num_kqqk_2,num_kqqk_3,num_kqqk_4,num_kqqk_5;

    TextView tv_screen_dwlb;

    TextView table_zh,table_zq,table_jwjs,table_fgdj,table_fgzldj;
    ConstraintLayout title_gwy_zh,title_gwy_zq,title_gwy_jwjs,title_gwy_fgdj,title_gwy_fgzldj;
    int tableIndex = 1;//

    @Override
    public int getLayoutId() {
        return R.layout.activity_bm_gwy;
    }

    @Override
    public void initView() {
        showLeftIcon();
        showLLRightGoHome();
        showTitleTv("公务员职数配备表");

        et_search = findViewById(R.id.et_search);

        table_zh = findViewById(R.id.table_zh);
        table_zq = findViewById(R.id.table_zq);
        table_jwjs = findViewById(R.id.table_jwjs);
        table_fgdj = findViewById(R.id.table_fgdj);
        table_fgzldj = findViewById(R.id.table_fgzldj);

        title_gwy_zh = findViewById(R.id.title_gwy_zh);
        title_gwy_zq = findViewById(R.id.title_gwy_zq);
        title_gwy_jwjs = findViewById(R.id.title_gwy_jwjs);
        title_gwy_fgdj = findViewById(R.id.title_gwy_fgdj);
        title_gwy_fgzldj = findViewById(R.id.title_gwy_fgzldj);

        table_zh.setOnClickListener(this);
        table_zq.setOnClickListener(this);
        table_jwjs.setOnClickListener(this);
        table_fgdj.setOnClickListener(this);
        table_fgzldj.setOnClickListener(this);

        num_hdzs_1 = findViewById(R.id.num_hdzs_1);
        num_hdzs_2 = findViewById(R.id.num_hdzs_2);
        num_hdzs_3 = findViewById(R.id.num_hdzs_3);
        num_hdzs_4 = findViewById(R.id.num_hdzs_4);
        num_hdzs_5 = findViewById(R.id.num_hdzs_5);
        num_spqk_1 = findViewById(R.id.num_spqk_1);
        num_spqk_2 = findViewById(R.id.num_spqk_2);
        num_spqk_3 = findViewById(R.id.num_spqk_3);
        num_spqk_4 = findViewById(R.id.num_spqk_4);
        num_spqk_5 = findViewById(R.id.num_spqk_5);
        num_spqk_6 = findViewById(R.id.num_spqk_6);
        num_spqk_7 = findViewById(R.id.num_spqk_7);
        num_spqk_8 = findViewById(R.id.num_spqk_8);
        num_spqk_9 = findViewById(R.id.num_spqk_9);
        num_cpqk_1 = findViewById(R.id.num_cpqk_1);
        num_cpqk_2 = findViewById(R.id.num_cpqk_2);
        num_cpqk_3 = findViewById(R.id.num_cpqk_3);
        num_cpqk_4 = findViewById(R.id.num_cpqk_4);
        num_cpqk_5 = findViewById(R.id.num_cpqk_5);
        num_kqqk_1 = findViewById(R.id.num_kqqk_1);
        num_kqqk_2 = findViewById(R.id.num_kqqk_2);
        num_kqqk_3 = findViewById(R.id.num_kqqk_3);
        num_kqqk_4 = findViewById(R.id.num_kqqk_4);
        num_kqqk_5 = findViewById(R.id.num_kqqk_5);

        tv_screen_dwlb = findViewById(R.id.tv_screen_dwlb);
        tv_screen_dwlb.setOnClickListener(this);

        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                /*判断是否是“搜索”键*/
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    orgId = "";
                    tv_screen_dwlb.setText("单位类别");
                    key = et_search.getText().toString().trim();
                    getData();
                    return true;
                }
                return false;
            }
        });

        initRecyclerLeft();
        initRecyclerRight();
        setSelectView();
    }

    @Override
    public void initData() {
        getData();
        getDbOrgData();
    }

    public List<DBGwyZHGL> getDbListZh(String key) {
        List<DBGwyZHGL> dbList = new ArrayList<>();
        DBGwyZHGLDao dbBmBeanDao = DaoManager.getInstance().getDaoSession().getDBGwyZHGLDao();
        QueryBuilder<DBGwyZHGL> queryBuilder = dbBmBeanDao.queryBuilder();

        if(!TextUtils.isEmpty(key)){
            queryBuilder.where(DBGwyZHGLDao.Properties.DeptName.like("%" + key + "%"),DBGwyZHGLDao.Properties.Display.eq(0));
            dbList = queryBuilder.list();
        }else{
            queryBuilder.where(DBGwyZHGLDao.Properties.Display.eq(0));
            if(!TextUtils.isEmpty(orgId))
                queryBuilder.where(DBGwyZHGLDao.Properties.GwyType.eq(orgId));
            dbList = queryBuilder.list();
        }
        LogUtil.e("数据库条数：" + dbList.size());
        return dbList;
    }

    public List<DBGwyZQ> getDbListZq(String key) {
        List<DBGwyZQ> dbList = new ArrayList<>();
        DBGwyZQDao dbBmBeanDao = DaoManager.getInstance().getDaoSession().getDBGwyZQDao();
        QueryBuilder<DBGwyZQ> queryBuilder = dbBmBeanDao.queryBuilder();

        if(!TextUtils.isEmpty(key)){
            queryBuilder.where(DBGwyZQDao.Properties.DeptName.like("%" + key + "%"),DBGwyZQDao.Properties.Display.eq(0));
            dbList = queryBuilder.list();
        }else{
            queryBuilder.where(DBGwyZQDao.Properties.Display.eq(0));
//            if(!TextUtils.isEmpty(orgId))
//                queryBuilder.where(DBGwyZQDao.Properties.gwyType.eq(orgId)).orderAsc(DBGwyZQDao.Properties.OrderNum);
            dbList = queryBuilder.list();
        }
        LogUtil.e("数据库条数：" + dbList.size());
        return dbList;
    }

    public List<DBGwyJWJS> getDbListJwjs(String key) {
        List<DBGwyJWJS> dbList = new ArrayList<>();
        DBGwyJWJSDao dbBmBeanDao = DaoManager.getInstance().getDaoSession().getDBGwyJWJSDao();
        QueryBuilder<DBGwyJWJS> queryBuilder = dbBmBeanDao.queryBuilder();

        if(!TextUtils.isEmpty(key)){
            queryBuilder.where(DBGwyJWJSDao.Properties.DeptName.like("%" + key + "%"),DBGwyJWJSDao.Properties.Display.eq(0));
            dbList = queryBuilder.list();
        }else{
            queryBuilder.where(DBGwyJWJSDao.Properties.Display.eq(0));
//            if(!TextUtils.isEmpty(orgId))
//                queryBuilder.where(DBGwyJWJSDao.Properties.gwyType.eq(orgId)).orderAsc(DBGwyJWJSDao.Properties.OrderNum);
            dbList = queryBuilder.list();
        }
        LogUtil.e("数据库条数：" + dbList.size());
        return dbList;
    }

    public List<DBGwyFGDJ> getDbListFgdj(String key) {
        List<DBGwyFGDJ> dbList = new ArrayList<>();
        DBGwyFGDJDao dbBmBeanDao = DaoManager.getInstance().getDaoSession().getDBGwyFGDJDao();
        QueryBuilder<DBGwyFGDJ> queryBuilder = dbBmBeanDao.queryBuilder();

        if(!TextUtils.isEmpty(key)){
            queryBuilder.where(DBGwyFGDJDao.Properties.DeptName.like("%" + key + "%"),DBGwyFGDJDao.Properties.Display.eq(0));
            dbList = queryBuilder.list();
        }else{
            queryBuilder.where(DBGwyFGDJDao.Properties.Display.eq(0));
            if(!TextUtils.isEmpty(orgId))
                queryBuilder.where(DBGwyFGDJDao.Properties.GwyType.eq(orgId));
            dbList = queryBuilder.list();
        }
        LogUtil.e("数据库条数：" + dbList.size());
        return dbList;
    }

    public List<DBGwyFGZLDJ> getDbListFgzldj(String key) {
        List<DBGwyFGZLDJ> dbList = new ArrayList<>();
        DBGwyFGZLDJDao dbBmBeanDao = DaoManager.getInstance().getDaoSession().getDBGwyFGZLDJDao();
        QueryBuilder<DBGwyFGZLDJ> queryBuilder = dbBmBeanDao.queryBuilder();

        if(!TextUtils.isEmpty(key)){
            queryBuilder.where(DBGwyFGZLDJDao.Properties.DeptName.like("%" + key + "%"),DBGwyFGZLDJDao.Properties.Display.eq(0));
            dbList = queryBuilder.list();
        }else{
            queryBuilder.where(DBGwyFGZLDJDao.Properties.Display.eq(0));
            if(!TextUtils.isEmpty(orgId))
                queryBuilder.where(DBGwyFGZLDJDao.Properties.GwyType.eq(orgId));
            dbList = queryBuilder.list();
        }
        LogUtil.e("数据库条数：" + dbList.size());
        return dbList;
    }

    public void getData() {
        datasLeft = new ArrayList<>();
        datasZHGL = new ArrayList<>();
        datasZQ = new ArrayList<>();
        datasFGDJ = new ArrayList<>();
        datasFGZLDJ = new ArrayList<>();
        datasJWJS = new ArrayList<>();

        if(tableIndex == 1){
            List<DBGwyZHGL> dbList = getDbListZh(key);
            if (dbList != null) {
                datasZHGL = dbList;
                for (int i = 0;i<datasZHGL.size();i++){
                    DBBmBean item = new DBBmBean();
                    item.setDeptName(datasZHGL.get(i).getDeptName());
                    item.setSubset(datasZHGL.get(i).getSubset());
                    datasLeft.add(item);
                }
            }
            mAdapterLeft.setData(datasLeft);
            recyclerViewRight.setAdapter(bmRightZhAdapter);
            bmRightZhAdapter.setData(datasZHGL);
            setNum();
        }else if(tableIndex == 2){
            List<DBGwyZQ> dbList = getDbListZq(key);
            if (dbList != null) {
                datasZQ = dbList;
                for (int i = 0;i<datasZQ.size();i++){
                    DBBmBean item = new DBBmBean();
                    item.setDeptName(datasZQ.get(i).getDeptName());
                    item.setSubset(datasZQ.get(i).getSubset());
                    datasLeft.add(item);
                }
            }
            mAdapterLeft.setData(datasLeft);
            recyclerViewRight.setAdapter(bmRightZqAdapter);
            bmRightZqAdapter.setData(datasZQ);
        }else if(tableIndex == 3){
            List<DBGwyJWJS> dbList = getDbListJwjs(key);
            if (dbList != null) {
                datasJWJS = dbList;
                for (int i = 0;i<datasJWJS.size();i++){
                    DBBmBean item = new DBBmBean();
                    item.setDeptName(datasJWJS.get(i).getDeptName());
                    item.setSubset(datasJWJS.get(i).getSubset());
                    datasLeft.add(item);
                }
            }
            mAdapterLeft.setData(datasLeft);
            recyclerViewRight.setAdapter(bmRightJwjsAdapter);
            bmRightJwjsAdapter.setData(datasJWJS);
        }else if(tableIndex == 4){
            List<DBGwyFGDJ> dbList = getDbListFgdj(key);
            if (dbList != null) {
                datasFGDJ = dbList;
                for (int i = 0;i<datasFGDJ.size();i++){
                    DBBmBean item = new DBBmBean();
                    item.setDeptName(datasFGDJ.get(i).getDeptName());
                    item.setSubset(datasFGDJ.get(i).getSubset());
                    datasLeft.add(item);
                }
            }
            mAdapterLeft.setData(datasLeft);
            recyclerViewRight.setAdapter(bmRightFgdjAdapter);
            bmRightFgdjAdapter.setData(datasFGDJ);
        }else if(tableIndex == 5){
            List<DBGwyFGZLDJ> dbList = getDbListFgzldj(key);
            if (dbList != null) {
                datasFGZLDJ = dbList;
                for (int i = 0;i<datasFGZLDJ.size();i++){
                    DBBmBean item = new DBBmBean();
                    item.setDeptName(datasFGZLDJ.get(i).getDeptName());
                    item.setSubset(datasFGZLDJ.get(i).getSubset());
                    datasLeft.add(item);
                }
            }
            mAdapterLeft.setData(datasLeft);
            recyclerViewRight.setAdapter(bmRightFgdjzlAdapter);
            bmRightFgdjzlAdapter.setData(datasFGZLDJ);
        }
    }

    public void setNum(){
        int hdzs_1 = 0,hdzs_2 = 0,hdzs_3 = 0,hdzs_4 = 0,hdzs_5 = 0;
        int spqk_1 = 0,spqk_2 = 0,spqk_3 = 0,spqk_4 = 0,spqk_5 = 0,spqk_6 = 0,spqk_7 = 0,spqk_8 = 0,spqk_9 = 0;
        int cpqk_1 = 0,cpqk_2 = 0,cpqk_3 = 0,cpqk_4 = 0,cpqk_5 = 0;
        int kqqk_1 = 0,kqqk_2 = 0,kqqk_3 = 0,kqqk_4 = 0,kqqk_5 = 0;
        for (int i=0;i<datasZHGL.size();i++){
            hdzs_1 = hdzs_1 + datasZHGL.get(i).getVerificationed();
            hdzs_2 = hdzs_2 + datasZHGL.get(i).getVerificationsd();
            hdzs_3 = hdzs_3 + datasZHGL.get(i).getVerificationsid();
            hdzs_4 = hdzs_4 + datasZHGL.get(i).getVerificationyez();
            hdzs_5 = hdzs_5 + datasZHGL.get(i).getVerificationssz();

            spqk_1 = spqk_1 + datasZHGL.get(i).getActualed();
            spqk_2 = spqk_2 + datasZHGL.get(i).getActualsd();
            spqk_3 = spqk_3 + datasZHGL.get(i).getActualsid();
            spqk_4 = spqk_4 + datasZHGL.get(i).getActualyz();
            spqk_5 = spqk_5 + datasZHGL.get(i).getActualez();
            spqk_6 = spqk_6 + datasZHGL.get(i).getActualsz();
            spqk_7 = spqk_7 + datasZHGL.get(i).getActualsiz();
            spqk_8 = spqk_8 + datasZHGL.get(i).getActualyk();
            spqk_9 = spqk_9 + datasZHGL.get(i).getActualek();

            cpqk_1 = cpqk_1 + datasZHGL.get(i).getSurpassed();
            cpqk_2 = cpqk_2 + datasZHGL.get(i).getSurpasssd();
            cpqk_3 = cpqk_3 + datasZHGL.get(i).getSurpasssid();
            cpqk_4 = cpqk_4 + datasZHGL.get(i).getSurpassyez();
            cpqk_5 = cpqk_5 + datasZHGL.get(i).getSurpassssz();

            kqqk_1 = kqqk_1 + datasZHGL.get(i).getVacancyed();
            kqqk_2 = kqqk_2 + datasZHGL.get(i).getVacancysd();
            kqqk_3 = kqqk_3 + datasZHGL.get(i).getVacancysid();
            kqqk_4 = kqqk_4 + datasZHGL.get(i).getVacancyyez();
            kqqk_5 = kqqk_5 + datasZHGL.get(i).getVacancyssz();

        }
        num_hdzs_1.setText("（" + hdzs_1 + "）");
        num_hdzs_2.setText("（" + hdzs_2 + "）");
        num_hdzs_3.setText("（" + hdzs_3 + "）");
        num_hdzs_4.setText("（" + hdzs_4 + "）");
        num_hdzs_5.setText("（" + hdzs_5 + "）");

        num_spqk_1.setText("（" + spqk_1 + "）");
        num_spqk_2.setText("（" + spqk_2 + "）");
        num_spqk_3.setText("（" + spqk_3 + "）");
        num_spqk_4.setText("（" + spqk_4 + "）");
        num_spqk_5.setText("（" + spqk_5 + "）");
        num_spqk_6.setText("（" + spqk_6 + "）");
        num_spqk_7.setText("（" + spqk_7 + "）");
        num_spqk_8.setText("（" + spqk_8 + "）");
        num_spqk_9.setText("（" + spqk_9 + "）");

        num_cpqk_1.setText("（" + cpqk_1 + "）");
        num_cpqk_2.setText("（" + cpqk_2 + "）");
        num_cpqk_3.setText("（" + cpqk_3 + "）");
        num_cpqk_4.setText("（" + cpqk_4 + "）");
        num_cpqk_5.setText("（" + cpqk_5 + "）");

        num_kqqk_1.setText("（" + kqqk_1 + "）");
        num_kqqk_2.setText("（" + kqqk_2 + "）");
        num_kqqk_3.setText("（" + kqqk_3 + "）");
        num_kqqk_4.setText("（" + kqqk_4 + "）");
        num_kqqk_5.setText("（" + kqqk_5 + "）");

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
    }


    public void initRecyclerRight(){
        recyclerViewRight = $(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerViewRight.setLayoutManager(linearLayoutManager);
        bmRightZhAdapter = new BmRightZhAdapter(activity, new ArrayList<DBGwyZHGL>());
        bmRightJwjsAdapter = new BmRightJwjsAdapter(activity, new ArrayList<DBGwyJWJS>());
        bmRightZqAdapter = new BmRightZqAdapter(activity, new ArrayList<DBGwyZQ>());
        bmRightFgdjAdapter = new BmRightFgdjAdapter(activity, new ArrayList<DBGwyFGDJ>());
        bmRightFgdjzlAdapter = new BmRightFgdjzlAdapter(activity, new ArrayList<DBGwyFGZLDJ>());
//        recyclerViewRight.setAdapter(mAdapterRight);

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
    }

    ListDialog listDialogOrg;
    List<ListDialogBean> dialogDatasOrg;
    String orgId;
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
            case R.id.table_zh:
                tableIndex = 1;
                setSelectView();
                getData();
                break;
            case R.id.table_zq:
                tableIndex = 2;
                setSelectView();
                getData();
                break;
            case R.id.table_jwjs:
                tableIndex = 3;
                setSelectView();
                getData();
                break;
            case R.id.table_fgdj:
                tableIndex = 4;
                setSelectView();
                getData();
                break;
            case R.id.table_fgzldj:
                tableIndex = 5;
                setSelectView();
                getData();
                break;
        }
    }

    public void setSelectView(){
        orgId = "";
        tv_screen_dwlb.setText("单位类别");
        key = "";
        et_search.setText("");

        table_zh.setTextColor(ContextCompat.getColor(context,R.color.color_bd1b21));
        table_zq.setTextColor(ContextCompat.getColor(context,R.color.color_bd1b21));
        table_jwjs.setTextColor(ContextCompat.getColor(context,R.color.color_bd1b21));
        table_fgdj.setTextColor(ContextCompat.getColor(context,R.color.color_bd1b21));
        table_fgzldj.setTextColor(ContextCompat.getColor(context,R.color.color_bd1b21));

        table_zh.setBackgroundColor(ContextCompat.getColor(context,R.color.transparent));
        table_zq.setBackgroundColor(ContextCompat.getColor(context,R.color.transparent));
        table_jwjs.setBackgroundColor(ContextCompat.getColor(context,R.color.transparent));
        table_fgdj.setBackgroundColor(ContextCompat.getColor(context,R.color.transparent));
        table_fgzldj.setBackgroundColor(ContextCompat.getColor(context,R.color.transparent));

        title_gwy_zh.setVisibility(View.GONE);
        title_gwy_zq.setVisibility(View.GONE);
        title_gwy_jwjs.setVisibility(View.GONE);
        title_gwy_fgdj.setVisibility(View.GONE);
        title_gwy_fgzldj.setVisibility(View.GONE);

        if(tableIndex == 1){
            table_zh.setTextColor(ContextCompat.getColor(context,R.color.white));
            table_zh.setBackgroundColor(ContextCompat.getColor(context,R.color.color_bd1b21));
            title_gwy_zh.setVisibility(View.VISIBLE);
        }else if(tableIndex == 2){
            table_zq.setTextColor(ContextCompat.getColor(context,R.color.white));
            table_zq.setBackgroundColor(ContextCompat.getColor(context,R.color.color_bd1b21));
            title_gwy_zq.setVisibility(View.VISIBLE);
        }else if(tableIndex == 3){
            table_jwjs.setTextColor(ContextCompat.getColor(context,R.color.white));
            table_jwjs.setBackgroundColor(ContextCompat.getColor(context,R.color.color_bd1b21));
            title_gwy_jwjs.setVisibility(View.VISIBLE);
        }else if(tableIndex == 4){
            table_fgdj.setTextColor(ContextCompat.getColor(context,R.color.white));
            table_fgdj.setBackgroundColor(ContextCompat.getColor(context,R.color.color_bd1b21));
            title_gwy_fgdj.setVisibility(View.VISIBLE);
        }else if(tableIndex == 5){
            table_fgzldj.setTextColor(ContextCompat.getColor(context,R.color.white));
            table_fgzldj.setBackgroundColor(ContextCompat.getColor(context,R.color.color_bd1b21));
            title_gwy_fgzldj.setVisibility(View.VISIBLE);
        }
    }

    public void getDbOrgData(){
        DBGwyDWLBDao dbBmOrgTypeBeanDao = DaoManager.getInstance().getDaoSession().getDBGwyDWLBDao();
        QueryBuilder<DBGwyDWLB> queryBuilder = dbBmOrgTypeBeanDao.queryBuilder();
        List<DBGwyDWLB> orgs = queryBuilder.list();

        dialogDatasOrg = new ArrayList<>();
        dialogDatasOrg.add(new ListDialogBean("","全部"));
        for (int i=0;i<orgs.size();i++){
            dialogDatasOrg.add(new ListDialogBean(orgs.get(i).getDictValue(),orgs.get(i).getDictLabel()));
        }
    }
}
