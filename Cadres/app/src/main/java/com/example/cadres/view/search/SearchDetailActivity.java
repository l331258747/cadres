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

        //TODO 根据内容写sql语句
        mAdapter.setData(getData());

    }


    List<DBGbBean> dbList;
    public void getDbList(String key) {
        DBGbBeanDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBGbBeanDao();
        QueryBuilder<DBGbBean> queryBuilder = dbGbBeanDao.queryBuilder();
        queryBuilder.where(DBGbBeanDao.Properties.Name.like("%"+key + "%"));
        dbList = queryBuilder.list();

        tv_search_content.setText(searchBean.getSearch());
        tv_search_count.setText("据符合筛选条件的数据共" + dbList.size() + "条");
    }

    public void getDbList(){
        DBGbBeanDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBGbBeanDao();
        QueryBuilder<DBGbBean> queryBuilder = dbGbBeanDao.queryBuilder();
        buildWhereOr(queryBuilder,searchBean.getGblxLists(),DBGbBeanDao.Properties.CadreType);
        LogUtil.e("干部类型 数据条数："+queryBuilder.count());

        Join join_bm = queryBuilder.join(DBGbBeanDao.Properties.BaseId, DBGbCadreDeptListBean.class, DBGbCadreDeptListBeanDao.Properties.BaseId);
        joinWhereOr(join_bm,searchBean.getBmlxLists(),DBGbCadreDeptListBeanDao.Properties.DeptId);
        LogUtil.e("部门类型 数据条数："+queryBuilder.count());

//        queryBuilder.where(DBGbBeanDao.Properties.Birthday.between())//TODO 年范围sql

        buildWhereOr(queryBuilder,searchBean.getZwjbLists(),DBGbBeanDao.Properties.CurrentRank);
        LogUtil.e("职务级别 数据条数："+queryBuilder.count());

        buildWhereOr(queryBuilder,searchBean.getGblxLists(),DBGbBeanDao.Properties.FullTimeSchool);//TODO 在职教育
        LogUtil.e("学历 数据条数："+queryBuilder.count());

        buildWhereOr(queryBuilder,searchBean.getXxlxLists(),DBGbBeanDao.Properties.FullTimeSchoolType);//TODO 在职教育
        LogUtil.e("学校类型 数据条数："+queryBuilder.count());

        Join join_gzjl = queryBuilder.join(DBGbBeanDao.Properties.BaseId, DBGbCadreDeptListBean.class, DBGbCadreNowPositionListBeanDao.Properties.BaseId);
        joinWhereOr(join_gzjl,searchBean.getBmlxLists(), DBGbCadreResumeListBeanDao.Properties.WorkType);
        LogUtil.e("工作经历 数据条数："+queryBuilder.count());

        //        queryBuilder.where(DBGbBeanDao.Properties.Birthday.between())//TODO 任职年限 范围sql

        buildWhereOr(queryBuilder,searchBean.getXbLists(),DBGbBeanDao.Properties.Gender);
        LogUtil.e("性别 数据条数："+queryBuilder.count());

        buildWhereOr(queryBuilder,searchBean.getXbLists(),DBGbBeanDao.Properties.PoliticalOutlook);
        LogUtil.e("党派 数据条数："+queryBuilder.count());

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
                        item.getResponsibilities()
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


//    public List<HistoryData> getDbGbBmList(List<String> historys,List<String> hellos) {
//        List<HistoryData> dbList = new ArrayList<>();
//        if(historys.size() == 0) return dbList;
//        HistoryDataDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getHistoryDataDao();
//        QueryBuilder<HistoryData> queryBuilder = dbGbBeanDao.queryBuilder();
//
//        buildWhereOr(queryBuilder,historys,HistoryDataDao.Properties.History);
//
//        Join join = queryBuilder.join(HistoryDataDao.Properties.Date, HelloData.class, HelloDataDao.Properties.Date);
//        joinWhereOr(join,hellos,HelloDataDao.Properties.Hello);
//
//        dbList = queryBuilder.list();
//        Log.e("Lgq","数据库条数2：" + queryBuilder.count());
//        return dbList;
//    }

    public void joinWhereOr(Join join, List<String> lists, Property property){
        if(lists.size() == 0){
            return;
        }else if(lists.size() == 1){
            WhereCondition whereCondition0 = property.eq(lists.get(0));
            join.where(whereCondition0);
        }else if(lists.size() == 2){
            WhereCondition whereCondition0 = property.eq(lists.get(0));
            WhereCondition whereCondition1 = property.eq(lists.get(1));
            join.whereOr(whereCondition0,whereCondition1);
        }else{
            WhereCondition whereCondition0 = property.eq(lists.get(0));
            WhereCondition whereCondition1 = property.eq(lists.get(1));
            WhereCondition[] whereConditions = new WhereCondition[lists.size() - 2];
            for (int i=2;i<lists.size();i++){
                whereConditions[i-2] = property.eq(lists.get(i));
            }
            join.whereOr(whereCondition0,whereCondition1,whereConditions);
        }
    }

    public void buildWhereOr(QueryBuilder queryBuilder, List<String> lists, Property property){
        if(lists.size() == 0){
            return;
        }else if(lists.size() == 1){
            WhereCondition whereCondition0 = property.eq(lists.get(0));
            queryBuilder.where(whereCondition0);
        }else if(lists.size() == 2){
            WhereCondition whereCondition0 = property.eq(lists.get(0));
            WhereCondition whereCondition1 = property.eq(lists.get(1));
            queryBuilder.whereOr(whereCondition0,whereCondition1);
        }else{
            WhereCondition whereCondition0 = property.eq(lists.get(0));
            WhereCondition whereCondition1 = property.eq(lists.get(1));
            WhereCondition[] whereConditions = new WhereCondition[lists.size() - 2];
            for (int i=2;i<lists.size();i++){
                whereConditions[i-2] = property.eq(lists.get(i));
            }
            queryBuilder.whereOr(whereCondition0,whereCondition1,whereConditions);
        }
    }

}
