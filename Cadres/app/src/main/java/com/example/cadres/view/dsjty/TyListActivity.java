package com.example.cadres.view.dsjty;

import android.content.Intent;
import android.widget.TextView;

import com.cadres.greendao.gen.DBGbBeanDao;
import com.cadres.greendao.gen.DBTyHjListDao;
import com.example.cadres.R;
import com.example.cadres.adapter.GbAdapter;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.Gb.GbBean;
import com.example.cadres.beanDB.DBGbBean;
import com.example.cadres.beanDB.DBTyHjList;
import com.example.cadres.utils.GsonUtil;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoManager;
import com.example.cadres.utils.greendao.DaoUtilsStore;
import com.example.cadres.view.Gb.GbDetailActivity;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TyListActivity extends BaseActivity {

    RecyclerView recyclerView;

    GbAdapter mAdapter;

    TextView tv_search_count;

    String title;

    CommonDaoUtils<DBGbBean> dBGbDaoUtils;
    List<GbBean.GbBean2> datas;

    CommonDaoUtils<DBTyHjList> dBTyhjListDaoUtils;
    List<String> ids;
    int type;

    @Override
    public int getLayoutId() {
        return R.layout.activity_ty_list;
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
        DBGbBeanDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBGbBeanDao();
        QueryBuilder<DBGbBean> queryBuilder = dbGbBeanDao.queryBuilder();
        queryBuilder.where(DBGbBeanDao.Properties.BaseId.in(ids));
        LogUtil.e("干部 数据条数："+queryBuilder.count());

        dbList = queryBuilder.list();
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
