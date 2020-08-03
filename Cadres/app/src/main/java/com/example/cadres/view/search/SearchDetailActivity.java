package com.example.cadres.view.search;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cadres.greendao.gen.DBGbBeanDao;
import com.cadres.greendao.gen.DBGbCadreDeptListBeanDao;
import com.cadres.greendao.gen.DBGbCadreNowPositionListBeanDao;
import com.cadres.greendao.gen.DBGbCadreResumeListBeanDao;
import com.example.cadres.R;
import com.example.cadres.adapter.GbAdapter;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.common.SearchDetailBean;
import com.example.cadres.beanDB.DBGbBean;
import com.example.cadres.beanDB.DBGbCadreDeptListBean;
import com.example.cadres.beanDB.DBGbCadreNowPositionListBean;
import com.example.cadres.beanDB.DBGbCadreResumeListBean;
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

public class SearchDetailActivity extends BaseActivity {

    RecyclerView recyclerView;

    GbAdapter mAdapter;

    CommonDaoUtils<DBGbBean> dBGbDaoUtils;
    List<DBGbBean> datas;

    TextView tv_search_content,tv_search_count;

    SearchDetailBean searchDetailBean;

    DrawerLayout drawer_layout;
    NestedScrollView scrollView;
    LinearLayout layout_info;
    GbDrawerData gbDrawerData;

    String type;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search_detail_drawer;
    }

    @Override
    public void initView() {
        showLeftIcon();
        showLLRightGoHome();
        showTitleTv("筛选结果");

        tv_search_content = findViewById(R.id.tv_search_content);
        tv_search_count = findViewById(R.id.tv_search_count);

        initRecycler();

        initDrawer();
        initDrawerGbInfo();

    }

    @Override
    public void initData() {
        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
        dBGbDaoUtils = _Store.getGbDaoUtils();

        searchDetailBean = (SearchDetailBean) intent.getSerializableExtra("data");
        type = intent.getStringExtra("type");
        if(!TextUtils.isEmpty(searchDetailBean.getSearch())){
            getDbList(searchDetailBean.getSearch());
        }else if(!TextUtils.isEmpty(searchDetailBean.getCyssGd())){
            getDbCyssGdList(searchDetailBean.getCyssGd());
        }else if(!TextUtils.isEmpty(searchDetailBean.getCyssZwlx())){
            getDbCyssZwlxList(searchDetailBean.getCyssZwlx());
        }else if(!TextUtils.isEmpty(searchDetailBean.getCyssZwbqlx())){
            getDbCyssZwbqlxList(searchDetailBean.getCyssZwbqlx());
        }else{
            getDbList();
        }
        mAdapter.setData(getData());
    }


    List<DBGbBean> dbList;

    public void getDbCyssGdList(String key){
        DBGbBeanDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBGbBeanDao();
        QueryBuilder<DBGbBean> queryBuilder = dbGbBeanDao.queryBuilder();
        queryBuilder.where(DBGbBeanDao.Properties.Type.like("%" + type + "%"));
        LogUtil.e("干部type 数据条数："+queryBuilder.count());

        if(TextUtils.equals(key,"90后干部")){
            queryBuilder.where(DBGbBeanDao.Properties.Birthday.between(1990, searchDetailBean.getCurrentYear()));
        }else if(TextUtils.equals(key,"35岁及以下年轻干部")){
            queryBuilder.where(DBGbBeanDao.Properties.Birthday.between(searchDetailBean.getCurrentYear() - 35, searchDetailBean.getCurrentYear()));
        }else if(TextUtils.equals(key,"党外干部")){
            queryBuilder.where(DBGbBeanDao.Properties.PoliticalOutlook.notIn("中共党员"));
        } else{
            queryBuilder.join(DBGbBeanDao.Properties.BaseId, DBGbCadreNowPositionListBean.class,DBGbCadreNowPositionListBeanDao.Properties.BaseId)
                    .where(DBGbCadreNowPositionListBeanDao.Properties.PositionTitleName.like( "%" + key + "%"));
            queryBuilder.distinct();
        }
        LogUtil.e("常用搜索固定条件 数据条数："+queryBuilder.count());

        dbList = queryBuilder.list();

        tv_search_content.setText(searchDetailBean.getCyssGd());
        tv_search_count.setText("据符合筛选条件的数据共" + dbList.size() + "条");
    }

    public void getDbCyssZwlxList(String key){
        DBGbBeanDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBGbBeanDao();
        QueryBuilder<DBGbBean> queryBuilder = dbGbBeanDao.queryBuilder();
        queryBuilder.where(DBGbBeanDao.Properties.Type.like("%" + type + "%"));
        LogUtil.e("干部type 数据条数："+queryBuilder.count());
        queryBuilder.where(DBGbBeanDao.Properties.CurrentPosition.like("%" + key + "%"));
        LogUtil.e("常用搜索职务类型 数据条数："+queryBuilder.count());
        dbList = queryBuilder.list();

        tv_search_content.setText(searchDetailBean.getCyssZwlx());
        tv_search_count.setText("据符合筛选条件的数据共" + dbList.size() + "条");
    }

    public void getDbCyssZwbqlxList(String key){
        DBGbBeanDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBGbBeanDao();
        QueryBuilder<DBGbBean> queryBuilder = dbGbBeanDao.queryBuilder();
        queryBuilder.where(DBGbBeanDao.Properties.Type.like("%" + type + "%"));
        LogUtil.e("干部type 数据条数："+queryBuilder.count());
        queryBuilder.where(DBGbBeanDao.Properties.PostLabel.like("%" + key + "%"));
        LogUtil.e("常用搜索职务标签类型 数据条数："+queryBuilder.count());

        dbList = queryBuilder.list();

        tv_search_content.setText(searchDetailBean.getCyssZwbqlx());
        tv_search_count.setText("据符合筛选条件的数据共" + dbList.size() + "条");
    }

    public void getDbList(String key) {
        DBGbBeanDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBGbBeanDao();
        QueryBuilder<DBGbBean> queryBuilder = dbGbBeanDao.queryBuilder();
        queryBuilder.where(DBGbBeanDao.Properties.Type.like("%" + type + "%"));
        LogUtil.e("干部type 数据条数："+queryBuilder.count());

        queryBuilder.whereOr(
                DBGbBeanDao.Properties.Name.like("%"+key + "%"),
                DBGbBeanDao.Properties.NativePlace.like("%"+key + "%"),
                DBGbBeanDao.Properties.TechnicalTitle.like("%"+key + "%"),
                DBGbBeanDao.Properties.Expertise.like("%"+key + "%"),
                DBGbBeanDao.Properties.FullTimeSchool.like("%"+key + "%"),
                DBGbBeanDao.Properties.CurrentSchool.like("%"+key + "%")
        );
        dbList = queryBuilder.list();

        tv_search_content.setText(searchDetailBean.getSearch());
        tv_search_count.setText("据符合筛选条件的数据共" + dbList.size() + "条");
    }

    /**
     public List<HistoryData> getDbGbBmList(List<String> historys,List<String> hellos) {
     List<HistoryData> dbList = new ArrayList<>();

     HistoryDataDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getHistoryDataDao();
     QueryBuilder<HistoryData> queryBuilder = dbGbBeanDao.queryBuilder();
     queryBuilder.where(HistoryDataDao.Properties.History.in(historys));
     Log.e("--------------","数据库条数：" + queryBuilder.count());

     queryBuilder.join(HistoryDataDao.Properties.Date,HelloData.class,HelloDataDao.Properties.Date)
     .where(HelloDataDao.Properties.Hello.in(hellos));
     queryBuilder.distinct();
     Log.e("--------------","数据库条数：" + queryBuilder.list().size());

     queryBuilder.whereOr(HistoryDataDao.Properties.History.in(historys),HistoryDataDao.Properties.Date.in(historys));
     Log.e("--------------","数据库条数：" + queryBuilder.list().size());

     return dbList;
     }
     */

    public void getDbList(){
        DBGbBeanDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBGbBeanDao();
        QueryBuilder<DBGbBean> queryBuilder = dbGbBeanDao.queryBuilder();
        queryBuilder.where(DBGbBeanDao.Properties.Type.like("%" + type + "%"));
        LogUtil.e("干部type 数据条数："+queryBuilder.count());

        if(searchDetailBean.getGllbLists().size() > 0){
            queryBuilder.where(DBGbBeanDao.Properties.CadreType.in(searchDetailBean.getGllbLists()));
            LogUtil.e("干部类型 数据条数："+queryBuilder.count());
        }
        if(searchDetailBean.getBmlbLists().size() > 0){
            queryBuilder.join(DBGbBeanDao.Properties.BaseId,DBGbCadreDeptListBean.class,DBGbCadreDeptListBeanDao.Properties.BaseId)
                    .where(DBGbCadreDeptListBeanDao.Properties.DeptType.in(searchDetailBean.getBmlbLists()));
            queryBuilder.distinct();
            LogUtil.e("部门类型 数据条数："+queryBuilder.count());
        }
        if(searchDetailBean.getCsnLists().size() > 0){
            queryBuilder.where(DBGbBeanDao.Properties.Birthday.between(searchDetailBean.getCsnLists().get(0), searchDetailBean.getCsnLists().get(1)));
            LogUtil.e("出生年 数据条数："+queryBuilder.count());
        }
        if(searchDetailBean.getXrzjlxLists().size() > 0){
            queryBuilder.where(DBGbBeanDao.Properties.FunctionaryRankParentName.in(searchDetailBean.getXrzjlxLists()));
            LogUtil.e("现任职级类型 数据条数："+queryBuilder.count());
        }
        if(searchDetailBean.getXrzjLists().size() > 0){
            queryBuilder.where(DBGbBeanDao.Properties.FunctionaryRankName.in(searchDetailBean.getXrzjLists()));
            LogUtil.e("现任职级 数据条数："+queryBuilder.count());
        }

        if(searchDetailBean.getXlLists().size() > 0){
            if(searchDetailBean.getXllxType() == 1){
                queryBuilder.where(DBGbBeanDao.Properties.FullTimeEducation.in(searchDetailBean.getXlLists()));
                LogUtil.e("全日制学历 数据条数："+queryBuilder.count());
            }else if(searchDetailBean.getXllxType() == 2){
                queryBuilder.where(DBGbBeanDao.Properties.CurrentEducation.in(searchDetailBean.getXlLists()));
                LogUtil.e("在职教育学历 数据条数："+queryBuilder.count());
            }else{
                queryBuilder.whereOr(DBGbBeanDao.Properties.FullTimeEducation.in(searchDetailBean.getXlLists())
                        ,DBGbBeanDao.Properties.CurrentEducation.in(searchDetailBean.getXlLists()));
                LogUtil.e("学历 数据条数："+queryBuilder.count());
            }
        }

        if(searchDetailBean.getXxlxLists().size() > 0){
            queryBuilder.whereOr(DBGbBeanDao.Properties.FullTimeSchoolType.in(searchDetailBean.getXxlxLists())
                    ,DBGbBeanDao.Properties.CurrentSchoolType.in(searchDetailBean.getXxlxLists()));
            LogUtil.e("学校类型 数据条数："+queryBuilder.count());
        }

        if(searchDetailBean.getGzjlLists().size() > 0){
            queryBuilder.join(DBGbBeanDao.Properties.BaseId,DBGbCadreResumeListBean.class,DBGbCadreResumeListBeanDao.Properties.BaseId)
                    .where(DBGbCadreResumeListBeanDao.Properties.WorkType.in(searchDetailBean.getGzjlLists()));
            queryBuilder.distinct();
            LogUtil.e("工作经历 数据条数："+queryBuilder.count());
        }

        if(searchDetailBean.getXrzjnxLists().size() > 0){
            List<String> lists = searchDetailBean.getXrzjnxLists2();
            queryBuilder.where(DBGbBeanDao.Properties.CurrentPositionTime.between(lists.get(0),lists.get(1)));
            LogUtil.e("现任职级年限 数据条数："+queryBuilder.count());
        }

        if(searchDetailBean.getXbLists().size() > 0){
            queryBuilder.where(DBGbBeanDao.Properties.Gender.in(searchDetailBean.getXbLists()));
            LogUtil.e("性别 数据条数："+queryBuilder.count());
        }
        if(searchDetailBean.getXrzwccLists().size() > 0){
            queryBuilder.where(DBGbBeanDao.Properties.CurrentRank.in(searchDetailBean.getXrzwccLists()));
            LogUtil.e("现任职务层次 数据条数："+queryBuilder.count());
        }

        if(searchDetailBean.getXrzwccnxLists().size() > 0){
            List<String> lists = searchDetailBean.getXrzwccnxLists2();
            queryBuilder.where(DBGbBeanDao.Properties.CurrentRankTime.between(lists.get(0),lists.get(1)));
            LogUtil.e("现任职务层次年限 数据条数："+queryBuilder.count());
        }

        if(searchDetailBean.getDpLists().size() > 0){
//            if(searchBean.isDpFzgdn()){
//                queryBuilder.whereOr(DBGbBeanDao.Properties.PoliticalOutlook.in(searchBean.getDpLists()),
//                        DBGbBeanDao.Properties.PoliticalOutlook.notIn("中共党员"));
//                LogUtil.e("党派 数据条数："+queryBuilder.count());
//            }else{
//                queryBuilder.where(DBGbBeanDao.Properties.PoliticalOutlook.in(searchBean.getDpLists()));
//                LogUtil.e("党派 数据条数："+queryBuilder.count());
//            }
            queryBuilder.where(DBGbBeanDao.Properties.PoliticalOutlook.in(searchDetailBean.getDpLists()));
            LogUtil.e("党派 数据条数："+queryBuilder.count());
        }

        dbList = queryBuilder.list();

        tv_search_content.setText(searchDetailBean.toString());
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
        mAdapter = new GbAdapter(activity, new ArrayList<DBGbBean>(),type);
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
