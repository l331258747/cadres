package com.example.cadres.view.Gb;

import android.content.Intent;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.cadres.greendao.gen.DBGbBeanDao;
import com.cadres.greendao.gen.DBGbCadreDeptListBeanDao;
import com.example.cadres.R;
import com.example.cadres.adapter.GbAdapter;
import com.example.cadres.adapter.GbLeftAdapter;
import com.example.cadres.adapter.ListDialogAdapter;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.Gb.GbBean;
import com.example.cadres.bean.common.BmLeftBean;
import com.example.cadres.bean.common.ListDialogBean;
import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.beanDB.DBBmExplainBean;
import com.example.cadres.beanDB.DBGbBean;
import com.example.cadres.beanDB.DBGbCadreDeptListBean;
import com.example.cadres.beanDB.DBGbCadreNowPositionListBean;
import com.example.cadres.dialog.ListDialog;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoManager;
import com.example.cadres.utils.greendao.DaoUtilsStore;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import androidx.constraintlayout.widget.Group;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GbActivity extends BaseActivity implements View.OnClickListener {

    Group group_View_top;
    TextView tv_top_title, tv_top_btn, tv_top_hdzs2, tv_top_sjpb2, tv_top_cpqk2, tv_top_kqqk2;
    TextView tv_right_title, tv_right_btn, tv_right_content;
    View view_menu;
    EditText et_search;

    RecyclerView recyclerView;

    GbAdapter mAdapter;

    CommonDaoUtils<DBGbBean> dBGbDaoUtils;
    List<GbBean.GbBean2> datas;

    DrawerLayout drawer_layout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_gb_drawer;
    }

    @Override
    public void initView() {
        showLeftIcon();
        showLLRightGoHome();
        showTitleTv("干部名册");

        et_search = findViewById(R.id.et_search);

        group_View_top = findViewById(R.id.group_View_top);
        tv_top_title = findViewById(R.id.tv_top_title);
        tv_top_btn = findViewById(R.id.tv_top_btn);
        tv_top_hdzs2 = findViewById(R.id.tv_top_hdzs2);
        tv_top_sjpb2 = findViewById(R.id.tv_top_sjpb2);
        tv_top_cpqk2 = findViewById(R.id.tv_top_cpqk2);
        tv_top_kqqk2 = findViewById(R.id.tv_top_kqqk2);
        view_menu = findViewById(R.id.view_menu);

        tv_right_title = findViewById(R.id.tv_right_title);
        tv_right_btn = findViewById(R.id.tv_right_btn);
        tv_right_content = findViewById(R.id.tv_right_content);

        tv_right_btn.setOnClickListener(this);
        view_menu.setOnClickListener(this);
        tv_top_btn.setOnClickListener(this);

        et_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                /*判断是否是“搜索”键*/
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String key = et_search.getText().toString().trim();
                    mAdapter.setData(getData(key));

                    group_View_top.setVisibility(View.GONE);

                    return true;
                }
                return false;
            }
        });

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

        initRecycler();
        initRecyclerLeft();

    }

    @Override
    public void initData() {

        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
        dBGbDaoUtils = _Store.getGbDaoUtils();
        dBBmDaoUtils = _Store.getBmDaoUtils();
        dBBmExplainDaoUtils = _Store.getBmExplainDaoUtils();

        mAdapter.setData(getData(""));
        getDbBmList();
        leftAdapter.setData(bmLeftBeans);
    }

    public List<DBGbBean> getDbList(String key) {
        List<DBGbBean> dbList = new ArrayList<>();
        if (!TextUtils.isEmpty(key)) {
            String sql = "where NAME like ?";
            String[] condition = new String[]{"%" + key + "%"};
            dbList = dBGbDaoUtils.queryByNativeSql(sql, condition);
        } else {
            dbList = dBGbDaoUtils.queryAll();
        }
        LogUtil.e("数据库条数：" + dbList.size());
        return dbList;
    }


    public List<GbBean.GbBean2> getData(String key) {
        datas = new ArrayList<>();
        List<DBGbBean> dbList = getDbList(key);
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

    //--------------left
    List<DBBmBean> dbBmList;

    public List<DBBmBean> getDbBmList() {
        dbBmList = new ArrayList<>();
        dbBmList = dBBmDaoUtils.queryAll();
        LogUtil.e("数据库条数：" + dbBmList.size());

        setBmLeftBean();

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
                group_View_top.setVisibility(View.VISIBLE);
                tv_top_title.setText(item.getDeptName());
                tv_top_btn.setText(item.getDeptTypeName());
                tv_top_hdzs2.setText(item.getVerification());
                tv_top_sjpb2.setText(item.getActual());
                tv_top_cpqk2.setText(item.getOvermatch());
                tv_top_kqqk2.setText(item.getMismatch());

                deptId = item.getDeptId();
                deptName = item.getDeptName();

                drawer_layout.closeDrawer(Gravity.LEFT);

                mAdapter.setData(getGbBmData(deptId));

            }
        });
    }

    public DBBmBean getDBBmBean(int pos){
        for (int i=0;i<dbBmList.size();i++){
            if(bmLeftBeans.get(pos).getId() == dbBmList.get(i).getDeptId()){
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
    String deptName;

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

                        tv_right_title.setText(deptName);
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

                tv_right_title.setText(deptName);
                tv_right_btn.setText(item.getYearStr());
                tv_right_content.setText(item.getOrgExplain());

                drawer_layout.openDrawer(Gravity.RIGHT);
                break;
        }
    }


    //-----------------------------搜部门干部 多表查询
    public List<DBGbBean> getDbGbBmList(int deptId) {
        List<DBGbBean> dbList = new ArrayList<>();

        DBGbBeanDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBGbBeanDao();
        QueryBuilder<DBGbBean> queryBuilder = dbGbBeanDao.queryBuilder();
        queryBuilder.join(DBGbBeanDao.Properties.BaseId, DBGbCadreDeptListBean.class, DBGbCadreDeptListBeanDao.Properties.BaseId)
                .where(DBGbCadreDeptListBeanDao.Properties.DeptId.eq(deptId));
        dbList = queryBuilder.list();

        LogUtil.e("数据库条数：" + dbList.size());
        return dbList;
    }


    public List<GbBean.GbBean2> getGbBmData(int deptId) {
        datas = new ArrayList<>();
        List<DBGbBean> dbList = getDbGbBmList(deptId);
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


    public void setBmLeftBean() {
        List<BmLeftBean> bmLeftBeans = new ArrayList<>();
        for (int i = 0; i < dbBmList.size(); i++) {
            DBBmBean dbItem = dbBmList.get(i);
            BmLeftBean item = new BmLeftBean(dbItem.getDeptId(), dbItem.getParentId(), dbItem.getDeptName());
            bmLeftBeans.add(item);
        }

        List<BmLeftBean> rootTrees = new ArrayList<BmLeftBean>();
        for (BmLeftBean tree : bmLeftBeans) {
            if (tree.getParentId() == 0) {
                rootTrees.add(tree);
            }
            for (BmLeftBean t : bmLeftBeans) {
                if (t.getParentId() == tree.getId()) {
                    if (tree.getLists() == null) {
                        List<BmLeftBean> myChildrens = new ArrayList<BmLeftBean>();
                        myChildrens.add(t);
                        tree.setLists(myChildrens);
                    } else {
                        tree.getLists().add(t);
                    }
                }
            }
        }
        sysout(rootTrees,"");
    }

    List<BmLeftBean> bmLeftBeans = new ArrayList<BmLeftBean>();
    public void sysout(List<BmLeftBean> trees, String str) {
        if (trees != null && trees.size() > 0) {
            for (BmLeftBean tree : trees) {
                tree.setName(str + tree.getName());
                bmLeftBeans.add(tree);
                sysout(tree.getLists(), str + "   ");
            }
        }

    }

}
