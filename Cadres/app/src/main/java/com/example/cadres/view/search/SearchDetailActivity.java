package com.example.cadres.view.search;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.TextView;

import com.cadres.greendao.gen.DBGbBeanDao;
import com.cadres.greendao.gen.DBGbCadreDeptListBeanDao;
import com.cadres.greendao.gen.DBGbCadreNowPositionListBeanDao;
import com.cadres.greendao.gen.DBGbCadreResumeListBeanDao;
import com.example.cadres.R;
import com.example.cadres.adapter.GbAdapter;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.Gb.GbBean;
import com.example.cadres.bean.Gb.GbCadreNowPositionListBean;
import com.example.cadres.bean.common.SearchBean;
import com.example.cadres.beanDB.DBGbBean;
import com.example.cadres.beanDB.DBGbCadreDeptListBean;
import com.example.cadres.beanDB.DBGbCadreResumeListBean;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoManager;
import com.example.cadres.utils.greendao.DaoUtilsStore;
import com.example.cadres.view.Gb.GbDetailActivity;

import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.Join;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SearchDetailActivity extends BaseActivity {

    RecyclerView recyclerView;

    GbAdapter mAdapter;

    CommonDaoUtils<DBGbBean> dBGbDaoUtils;
    List<GbBean.GbBean2> datas;

    TextView tv_search_content,tv_search_count;

    SearchBean searchBean;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search_detail;
    }

    @Override
    public void initView() {
        showLeftIcon();
        showLLRightGoHome();
        showTitleTv("筛选结果");

        tv_search_content = findViewById(R.id.tv_search_content);
        tv_search_count = findViewById(R.id.tv_search_count);

        initRecycler();


    }

    @Override
    public void initData() {
        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
        dBGbDaoUtils = _Store.getGbDaoUtils();

        searchBean = (SearchBean) intent.getSerializableExtra("data");
        if(!TextUtils.isEmpty(searchBean.getSearch())){
            getDbList(searchBean.getSearch());
        }else{
            getDbList();
        }
        mAdapter.setData(getData());
    }


    List<DBGbBean> dbList;
    public void getDbList(String key) {
        DBGbBeanDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBGbBeanDao();
        QueryBuilder<DBGbBean> queryBuilder = dbGbBeanDao.queryBuilder();
        queryBuilder.whereOr(
                DBGbBeanDao.Properties.Name.like("%"+key + "%"),
                DBGbBeanDao.Properties.Name.like("%"+key + "%")
        );
        dbList = queryBuilder.list();

        tv_search_content.setText(searchBean.getSearch());
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

        if(searchBean.getGblxLists().size() > 0){
            queryBuilder.where(DBGbBeanDao.Properties.CadreType.in(searchBean.getGblxLists()));
            LogUtil.e("干部类型 数据条数："+queryBuilder.count());
        }
        if(searchBean.getBmlxLists().size() > 0){
            queryBuilder.join(DBGbBeanDao.Properties.BaseId,DBGbCadreDeptListBean.class,DBGbCadreDeptListBeanDao.Properties.BaseId)
                    .where(DBGbCadreDeptListBeanDao.Properties.DeptId.in(searchBean.getBmlxLists()));
            queryBuilder.distinct();
            LogUtil.e("部门类型 数据条数："+queryBuilder.count());
        }
        if(searchBean.getCsnLists().size() > 0){
            queryBuilder.where(DBGbBeanDao.Properties.Birthday.between(searchBean.getCsnLists().get(0),searchBean.getCsnLists().get(1)));
            LogUtil.e("出生年 数据条数："+queryBuilder.count());
        }
        if(searchBean.getZwjbLists().size() > 0){
            queryBuilder.where(DBGbBeanDao.Properties.CurrentRank.in(searchBean.getZwjbLists()));
            LogUtil.e("职务级别 数据条数："+queryBuilder.count());
        }

        if(searchBean.getXlLists().size() > 0){
            queryBuilder.whereOr(DBGbBeanDao.Properties.FullTimeEducation.in(searchBean.getXlLists())
                    ,DBGbBeanDao.Properties.CurrentEducation.in(searchBean.getXlLists()));
            LogUtil.e("学历 数据条数："+queryBuilder.count());
        }

        if(searchBean.getXxlxLists().size() > 0){
            queryBuilder.whereOr(DBGbBeanDao.Properties.FullTimeSchoolType.in(searchBean.getXxlxLists())
                    ,DBGbBeanDao.Properties.CurrentSchoolType.in(searchBean.getXxlxLists()));
            LogUtil.e("学校类型 数据条数："+queryBuilder.count());
        }

        if(searchBean.getGzjlLists().size() > 0){
            queryBuilder.join(DBGbBeanDao.Properties.BaseId,DBGbCadreResumeListBean.class,DBGbCadreResumeListBeanDao.Properties.BaseId)
                    .where(DBGbCadreResumeListBeanDao.Properties.WorkType.in(searchBean.getGzjlLists()));
            queryBuilder.distinct();
            LogUtil.e("工作经历 数据条数："+queryBuilder.count());
        }

        if(searchBean.getXrzjnxLists().size() > 0){
            queryBuilder.where(DBGbBeanDao.Properties.CurrentPositionTime.between(searchBean.getXrzjnxLists2().get(0),searchBean.getXrzjnxLists2().get(1)));
            LogUtil.e("现任职级年限 数据条数："+queryBuilder.count());
        }

        if(searchBean.getXbLists().size() > 0){
            queryBuilder.where(DBGbBeanDao.Properties.Gender.in(searchBean.getXbLists()));
            LogUtil.e("性别 数据条数："+queryBuilder.count());
        }

        if(searchBean.getDpLists().size() > 0){
            queryBuilder.where(DBGbBeanDao.Properties.PoliticalOutlook.in(searchBean.getDpLists()));
            LogUtil.e("党派 数据条数："+queryBuilder.count());
        }

        dbList = queryBuilder.list();

        tv_search_content.setText(searchBean.toString());
        tv_search_count.setText("据符合筛选条件的数据共" + dbList.size() + "条");
    }


    public List<GbBean.GbBean2> getData() {
        datas = new ArrayList<>();
        if (dbList != null) {
            for (int i = 0; i < dbList.size(); i++) {
                DBGbBean item = dbList.get(i);
                datas.add(new GbBean.GbBean2(
                        item.getBaseId(),
                        item.getName(),
                        item.getPhotoFileName(),
                        item.getGender(),
                        item.getIdCard(),
                        item.getBirthday(),
                        item.getAge(),
                        item.getNation(),
                        item.getPoliticalOutlook(),
                        item.getJoinPartyDate(),
                        item.getNativePlace(),
                        item.getBirthplace(),
                        item.getWorkTime(),
                        item.getPersonnelRelationsDeptId(),
                        item.getPersonnelRelationsDeptName(),
                        item.getEnterUnitTime(),
                        item.getCurrentRank(),
                        item.getCurrentRankTime(),
                        item.getHealth(),
                        item.getFunctionaryRankId(),
                        item.getFunctionaryRankName(),
                        item.getFunctionaryRankTime(),
                        item.getCadreType(),
                        item.getCurrentPosition(),
                        item.getCurrentPositionTime(),
                        item.getPersonnelType(),
                        item.getTechnicalTitle(),
                        item.getExpertise(),
                        item.getFullTimeEducation(),
                        item.getFullTimeSchool(),
                        item.getFullTimeDegreeId(),
                        item.getFullTimeDegreeName(),
                        item.getFullTimeSchoolType(),
                        item.getCurrentEducation(),
                        item.getCurrentDegreeId(),
                        item.getCurrentDegreeName(),
                        item.getCurrentSchool(),
                        item.getCurrentSchoolType(),
                        item.getWorkPhone(),
                        item.getPhoneNumber(),
                        item.getHomeAddress(),
                        item.getResponsibilities(),
                        item.getAffectedState()
                ));
            }
        }
        return datas;
    }


    //初始化recyclerview
    public void initRecycler() {
        recyclerView = $(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new GbAdapter(activity, new ArrayList<GbBean.GbBean2>());
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new GbAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Intent intent = new Intent(context, GbDetailActivity.class);
                intent.putExtra("ID", datas.get(pos).getBaseId());
                startActivity(intent);
            }
        });
    }





}
