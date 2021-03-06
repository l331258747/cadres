package com.example.cadres.view.search;

import android.database.Cursor;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cadres.greendao.gen.DBBmBeanDao;
import com.cadres.greendao.gen.DBGbBeanDao;
import com.cadres.greendao.gen.DBGbCadreDeptListBeanDao;
import com.cadres.greendao.gen.DBGbCadreNowPositionListBeanDao;
import com.cadres.greendao.gen.DBGbCadreResumeListBeanDao;
import com.example.cadres.R;
import com.example.cadres.adapter.GbAdapter;
import com.example.cadres.adapter.GbAdapterGwy;
import com.example.cadres.adapter.GbAdapterHbgb;
import com.example.cadres.adapter.GbAdapterLdgb;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.common.SearchDetailBean;
import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.beanDB.DBGbBean;
import com.example.cadres.beanDB.DBGbCadreDeptListBean;
import com.example.cadres.beanDB.DBGbCadreNowPositionListBean;
import com.example.cadres.beanDB.DBGbCadreResumeListBean;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoManager;
import com.example.cadres.utils.greendao.DaoUtilsStore;
import com.example.cadres.utils.myData.GbDrawerData;

import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.ArrayList;
import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SearchDetailActivity extends BaseActivity implements View.OnClickListener {
    RecyclerView recyclerView;

    GbAdapterLdgb mAdapterLdgb;
//    GbAdapterGwy mAdapterGwy;
//    GbAdapterHbgb mAdapterHbgb;

    CommonDaoUtils<DBGbBean> dBGbDaoUtils;
    List<DBGbBean> datas;

    TextView tv_search_content, tv_search_count;

    SearchDetailBean searchDetailBean;

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

//    String type;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search_detail_drawer;
    }

    @Override
    public void initView() {
//        type = intent.getStringExtra("type");
        searchDetailBean = (SearchDetailBean) intent.getSerializableExtra("data");

        showLeftIcon();
        showLLRightGoHome();
        showTitleTv("筛选结果");

        tv_search_content = findViewById(R.id.tv_search_content);
        tv_search_count = findViewById(R.id.tv_search_count);


        initRecycler();

        initDrawer();
        initDrawerGbInfo();

        initSort();

        initTitleTab();

    }

    LinearLayout ll_xrzsj, ll_xrzwccsj, ll_rzjsj, ll_rzjqssj, ll_cjgzsj, ll_csny;
    ImageView iv_xrzsj, iv_xrzwccsj, iv_rzjsj, iv_rzjqssj, iv_cjgzsj, iv_csny;

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

//        if (TextUtils.equals(type, "3")) {
//            ll_csny = findViewById(R.id.ll_csny_hbgb);
//            iv_csny = findViewById(R.id.iv_csny_hbgb);
//        } else if (TextUtils.equals(type, "2")) {
//            ll_xrzsj = findViewById(R.id.ll_xrzsj_gwy);
//            ll_rzjqssj = findViewById(R.id.ll_rzjqssj_gwy);
//            ll_cjgzsj = findViewById(R.id.ll_cjgzsj_gwy);
//            ll_csny = findViewById(R.id.ll_csny_gwy);
//            iv_xrzsj = findViewById(R.id.iv_xrzsj_gwy);
//            iv_rzjqssj = findViewById(R.id.iv_rzjqssj_gwy);
//            iv_cjgzsj = findViewById(R.id.iv_cjgzsj_gwy);
//            iv_csny = findViewById(R.id.iv_csny_gwy);
//        } else {
//            ll_xrzsj = findViewById(R.id.ll_xrzsj_ldgb);
//            ll_xrzwccsj = findViewById(R.id.ll_xrzwccsj_ldgb);
//            ll_rzjsj = findViewById(R.id.ll_rzjsj_ldgb);
//            ll_csny = findViewById(R.id.ll_csny_ldgb);
//            iv_xrzsj = findViewById(R.id.iv_xrzsj_ldgb);
//            iv_xrzwccsj = findViewById(R.id.iv_xrzwccsj_ldgb);
//            iv_rzjsj = findViewById(R.id.iv_rzjsj_ldgb);
//            iv_csny = findViewById(R.id.iv_csny_ldgb);
//        }
        ll_xrzsj = findViewById(R.id.ll_xrzsj_ldgb);
        ll_xrzwccsj = findViewById(R.id.ll_xrzwccsj_ldgb);
        ll_rzjsj = findViewById(R.id.ll_rzjsj_ldgb);
        ll_csny = findViewById(R.id.ll_csny_ldgb);
        iv_xrzsj = findViewById(R.id.iv_xrzsj_ldgb);
        iv_xrzwccsj = findViewById(R.id.iv_xrzwccsj_ldgb);
        iv_rzjsj = findViewById(R.id.iv_rzjsj_ldgb);
        iv_csny = findViewById(R.id.iv_csny_ldgb);

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
        getTypeDbList();
        setAdapterData(getData());
    }

    public void setAdapterData(List<DBGbBean> list) {
//        if (TextUtils.equals(type, "3")) {
//            mAdapterHbgb.setData(list);
//        } else if (TextUtils.equals(type, "2")) {
//            mAdapterGwy.setData(list);
//        } else {
//            mAdapterLdgb.setData(list);
//        }
        mAdapterLdgb.setData(list);
    }

    ConstraintLayout cl_gb_list_title_ldgb, cl_gb_list_title_gwy, cl_gb_list_title_hbgb;

    private void initTitleTab() {
        cl_gb_list_title_ldgb = findViewById(R.id.cl_gb_list_title_ldgb);
        cl_gb_list_title_gwy = findViewById(R.id.cl_gb_list_title_gwy);
        cl_gb_list_title_hbgb = findViewById(R.id.cl_gb_list_title_hbgb);

//        if (TextUtils.equals(type, "3")) {
//            cl_gb_list_title_ldgb.setVisibility(View.GONE);
//            cl_gb_list_title_gwy.setVisibility(View.GONE);
//            cl_gb_list_title_hbgb.setVisibility(View.VISIBLE);
//        } else if (TextUtils.equals(type, "2")) {
//            cl_gb_list_title_ldgb.setVisibility(View.GONE);
//            cl_gb_list_title_gwy.setVisibility(View.VISIBLE);
//            cl_gb_list_title_hbgb.setVisibility(View.GONE);
//        } else if (TextUtils.equals(type, "1")) {
//            cl_gb_list_title_ldgb.setVisibility(View.VISIBLE);
//            cl_gb_list_title_gwy.setVisibility(View.GONE);
//            cl_gb_list_title_hbgb.setVisibility(View.GONE);
//        }
        cl_gb_list_title_ldgb.setVisibility(View.VISIBLE);
        cl_gb_list_title_gwy.setVisibility(View.GONE);
        cl_gb_list_title_hbgb.setVisibility(View.GONE);
    }

    @Override
    public void initData() {
        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
        dBGbDaoUtils = _Store.getGbDaoUtils();

        sortDate(0);

        getTypeDbList();
        setAdapterData(getData());
    }

    public void getTypeDbList() {
        if (!TextUtils.isEmpty(searchDetailBean.getCyssGd())) {
            getDbCyssGdList(searchDetailBean.getCyssGd());
        } else if (!TextUtils.isEmpty(searchDetailBean.getCyssZwlx())) {
            getDbCyssZwlxList(searchDetailBean.getCyssZwlx());
        } else if (!TextUtils.isEmpty(searchDetailBean.getCyssZwbqlx())) {
            getDbCyssZwbqlxList(searchDetailBean.getCyssZwbqlx());
        } else {
            getDbList();
        }
    }

    List<DBGbBean> dbList;

    public void getDbCyssGdList(String key) {
        DBGbBeanDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBGbBeanDao();
        QueryBuilder<DBGbBean> queryBuilder = dbGbBeanDao.queryBuilder();
//        queryBuilder.where(DBGbBeanDao.Properties.Type.like("%" + type + "%"));
//        LogUtil.e("干部type 数据条数：" + queryBuilder.count());

        if (TextUtils.equals(key, "90后干部")) {
            queryBuilder.where(DBGbBeanDao.Properties.Birthday.between(1990, searchDetailBean.getCurrentYear()));
        } else if (TextUtils.equals(key, "35岁及以下年轻干部")) {
            queryBuilder.where(DBGbBeanDao.Properties.Birthday.between(searchDetailBean.getCurrentYear() - 35, searchDetailBean.getCurrentYear()));
        } else if (TextUtils.equals(key, "党外干部")) {
            queryBuilder.where(DBGbBeanDao.Properties.PoliticalOutlook.notIn("中共党员"));
        } else {
            queryBuilder.join(DBGbBeanDao.Properties.BaseId, DBGbCadreNowPositionListBean.class, DBGbCadreNowPositionListBeanDao.Properties.BaseId)
                    .where(DBGbCadreNowPositionListBeanDao.Properties.PositionTitleName.like("%" + key + "%"));
            queryBuilder.distinct();
        }

        if (orderBy != null) {
            if (isAsc) {
                queryBuilder.orderAsc(orderBy);
            } else {
                queryBuilder.orderDesc(orderBy);
            }
        }

        LogUtil.e("常用搜索固定条件 数据条数：" + queryBuilder.count());

        dbList = queryBuilder.list();

        tv_search_content.setText(searchDetailBean.getCyssGd());
        tv_search_count.setText("据符合筛选条件的数据共" + dbList.size() + "条");
    }

    public void getDbCyssZwlxList(String key) {
        DBGbBeanDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBGbBeanDao();
        QueryBuilder<DBGbBean> queryBuilder = dbGbBeanDao.queryBuilder();
//        queryBuilder.where(DBGbBeanDao.Properties.Type.like("%" + type + "%"));
//        LogUtil.e("干部type 数据条数：" + queryBuilder.count());
        queryBuilder.where(DBGbBeanDao.Properties.CurrentPosition.like("%" + key + "%"));
        LogUtil.e("常用搜索职务类型 数据条数：" + queryBuilder.count());

        if (orderBy != null) {
            if (isAsc) {
                queryBuilder.orderAsc(orderBy);
            } else {
                queryBuilder.orderDesc(orderBy);
            }
        }

        dbList = queryBuilder.list();

        tv_search_content.setText(searchDetailBean.getCyssZwlx());
        tv_search_count.setText("据符合筛选条件的数据共" + dbList.size() + "条");
    }

    public void getDbCyssZwbqlxList(String key) {
        DBGbBeanDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBGbBeanDao();
        QueryBuilder<DBGbBean> queryBuilder = dbGbBeanDao.queryBuilder();
//        queryBuilder.where(DBGbBeanDao.Properties.Type.like("%" + type + "%"));
//        LogUtil.e("干部type 数据条数：" + queryBuilder.count());
        queryBuilder.where(DBGbBeanDao.Properties.PostLabel.like("%" + key + "%"));
        LogUtil.e("常用搜索职务标签类型 数据条数：" + queryBuilder.count());

        if (orderBy != null) {
            if (isAsc) {
                queryBuilder.orderAsc(orderBy);
            } else {
                queryBuilder.orderDesc(orderBy);
            }
        }

        dbList = queryBuilder.list();

        tv_search_content.setText(searchDetailBean.getCyssZwbqlx());
        tv_search_count.setText("据符合筛选条件的数据共" + dbList.size() + "条");
    }

    /**
     * public List<HistoryData> getDbGbBmList(List<String> historys,List<String> hellos) {
     * List<HistoryData> dbList = new ArrayList<>();
     * <p>
     * HistoryDataDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getHistoryDataDao();
     * QueryBuilder<HistoryData> queryBuilder = dbGbBeanDao.queryBuilder();
     * queryBuilder.where(HistoryDataDao.Properties.History.in(historys));
     * Log.e("--------------","数据库条数：" + queryBuilder.count());
     * <p>
     * queryBuilder.join(HistoryDataDao.Properties.Date,HelloData.class,HelloDataDao.Properties.Date)
     * .where(HelloDataDao.Properties.Hello.in(hellos));
     * queryBuilder.distinct();
     * Log.e("--------------","数据库条数：" + queryBuilder.list().size());
     * <p>
     * queryBuilder.whereOr(HistoryDataDao.Properties.History.in(historys),HistoryDataDao.Properties.Date.in(historys));
     * Log.e("--------------","数据库条数：" + queryBuilder.list().size());
     * <p>
     * return dbList;
     * }
     */

    public void getDbList() {
        DBGbBeanDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBGbBeanDao();
        QueryBuilder<DBGbBean> queryBuilder = dbGbBeanDao.queryBuilder();
//        queryBuilder.where(DBGbBeanDao.Properties.Type.like("%" + type + "%"));
//        LogUtil.e("干部type 数据条数：" + queryBuilder.count());

        if (!TextUtils.isEmpty(searchDetailBean.getSearch())) {
            String key = searchDetailBean.getSearch();
            StringBuffer sql = new StringBuffer("");

            sql.append(" (T." + DBGbBeanDao.Properties.BaseId.columnName
                    + " IN ( SELECT " + " d." + DBGbCadreDeptListBeanDao.Properties.BaseId.columnName
                    + " FROM " + DBGbCadreDeptListBeanDao.TABLENAME + " d"
                    + " WHERE " + " d." + DBGbCadreDeptListBeanDao.Properties.ParentId.columnName
                    + " IN ( SELECT " + " e." + DBGbCadreDeptListBeanDao.Properties.DeptId.columnName
                    + " FROM " + DBGbCadreDeptListBeanDao.TABLENAME + " e"
                    + " WHERE " + " e." + DBGbCadreDeptListBeanDao.Properties.DeptName.columnName + " LIKE ? )"
                    + " OR " + " d." + DBGbCadreDeptListBeanDao.Properties.DeptName.columnName + " LIKE ? )"
                    + " OR " + " T." + DBGbBeanDao.Properties.Name.columnName + " LIKE ?"
                    + " OR " + " T." + DBGbBeanDao.Properties.NativePlace.columnName + " LIKE ?"
                    + " OR " + " T." + DBGbBeanDao.Properties.TechnicalTitle.columnName + " LIKE ?"
                    + " OR " + " T." + DBGbBeanDao.Properties.CurrentPosition.columnName + " LIKE ?"
                    + " OR " + " T." + DBGbBeanDao.Properties.Expertise.columnName + " LIKE ?"
                    + " OR " + " T." + DBGbBeanDao.Properties.FullTimeSchool.columnName + " LIKE ?"
                    + " OR " + " T." + DBGbBeanDao.Properties.FullTimeMajor.columnName + " LIKE ?"
                    + " OR " + " T." + DBGbBeanDao.Properties.FullTimeDegreeName.columnName + " LIKE ?)");

            String[] values = new String[]{
                    "%" + key + "%",
                    "%" + key + "%",
                    "%" + key + "%",
                    "%" + key + "%",
                    "%" + key + "%",
                    "%" + key + "%",
                    "%" + key + "%",
                    "%" + key + "%",
                    "%" + key + "%",
                    "%" + key + "%"
            };

            queryBuilder.where(new WhereCondition.StringCondition(sql.toString(), values));
            LogUtil.e("干部关键字 搜索条数：" + queryBuilder.count());
        }

        if (searchDetailBean.getLxLists().size() > 0) {
            StringBuffer sql = new StringBuffer("");
            String[] values = new String[searchDetailBean.getLxLists().size()];
            for (int i = 0; i < searchDetailBean.getLxLists().size(); i++) {
                values[i] = "%" + searchDetailBean.getLxLists().get(i) + "%";
                if (i == 0) {
                    sql.append(" " + DBGbBeanDao.Properties.Type.columnName + " like " + "?");
                } else {
                    sql.append(" and " + DBGbBeanDao.Properties.Type.columnName + " like " + " ?");
                }
            }
            queryBuilder.where(new WhereCondition.StringCondition(sql.toString(), values));
            LogUtil.e("干部type 数据条数：" + queryBuilder.count());
        }

        if (searchDetailBean.getGllbLists().size() > 0) {

            StringBuffer sql = new StringBuffer("");
            String[] values = new String[searchDetailBean.getGllbLists().size()];
            for (int i = 0; i < searchDetailBean.getGllbLists().size(); i++) {
                values[i] = "%" + searchDetailBean.getGllbLists().get(i) + "%";
                if (i == 0) {
                    sql.append(" " + DBGbBeanDao.Properties.CadreType.columnName + " like " + "?");
                } else {
                    sql.append(" and " + DBGbBeanDao.Properties.CadreType.columnName + " like " + " ?");
                }
            }
            queryBuilder.where(new WhereCondition.StringCondition(sql.toString(), values));

//            queryBuilder.where(DBGbBeanDao.Properties.CadreType.like("%" + searchDetailBean.getGllbListsStr() + "%"));
            LogUtil.e("干部类型 数据条数：" + queryBuilder.count());
        }
        if (searchDetailBean.getBmlbLists().size() > 0) {
            queryBuilder.join(DBGbBeanDao.Properties.BaseId, DBGbCadreDeptListBean.class, DBGbCadreDeptListBeanDao.Properties.BaseId)
                    .where(DBGbCadreDeptListBeanDao.Properties.DeptType.in(searchDetailBean.getBmlbLists()));
            queryBuilder.distinct();
            LogUtil.e("部门类型 数据条数：" + queryBuilder.count());
        }
        if (searchDetailBean.getXbLists().size() > 0) {
            queryBuilder.where(DBGbBeanDao.Properties.Gender.in(searchDetailBean.getXbLists()));
            LogUtil.e("性别 数据条数：" + queryBuilder.count());
        }
        if (searchDetailBean.getCsnLists().size() > 0) {
            List<String> lists = searchDetailBean.getCsnLists();
            queryBuilder.whereOr(DBGbBeanDao.Properties.Birthday.between(lists.get(0), lists.get(1)),
                    DBGbBeanDao.Properties.Birthday.like(lists.get(0) + "%"),
                    DBGbBeanDao.Properties.Birthday.like(lists.get(1) + "%"));
            LogUtil.e("出生年 数据条数：" + queryBuilder.count());
        }
        if (searchDetailBean.getDpLists().size() > 0) {
//            if(searchBean.isDpFzgdn()){
//                queryBuilder.whereOr(DBGbBeanDao.Properties.PoliticalOutlook.in(searchBean.getDpLists()),
//                        DBGbBeanDao.Properties.PoliticalOutlook.notIn("中共党员"));
//                LogUtil.e("党派 数据条数："+queryBuilder.count());
//            }else{
//                queryBuilder.where(DBGbBeanDao.Properties.PoliticalOutlook.in(searchBean.getDpLists()));
//                LogUtil.e("党派 数据条数："+queryBuilder.count());
//            }
            queryBuilder.where(DBGbBeanDao.Properties.PoliticalOutlook.in(searchDetailBean.getDpLists()));
            LogUtil.e("党派 数据条数：" + queryBuilder.count());
        }

        if (searchDetailBean.getRxznxLists().size() > 0) {
            List<String> lists = searchDetailBean.getRxznxLists2();
            queryBuilder.whereOr(DBGbBeanDao.Properties.CurrentPositionTime.between(lists.get(0), lists.get(1)),
                    DBGbBeanDao.Properties.CurrentPositionTime.like(lists.get(0) + "%"),
                    DBGbBeanDao.Properties.CurrentPositionTime.like(lists.get(1) + "%"));
            LogUtil.e("现任职年限 数据条数：" + queryBuilder.count());
        }

        if (searchDetailBean.getXrzwccLists().size() > 0) {
            queryBuilder.where(DBGbBeanDao.Properties.CurrentRank.in(searchDetailBean.getXrzwccLists()));
            LogUtil.e("现任职务层次 数据条数：" + queryBuilder.count());
        }
        if (searchDetailBean.getXrzwccnxLists().size() > 0) {
            List<String> lists = searchDetailBean.getXrzwccnxLists2();
            queryBuilder.whereOr(DBGbBeanDao.Properties.CurrentRankTime.between(lists.get(0), lists.get(1)),
                    DBGbBeanDao.Properties.CurrentRankTime.like(lists.get(0) + "%"),
                    DBGbBeanDao.Properties.CurrentRankTime.like(lists.get(1) + "%"));
            LogUtil.e("现任职务层次年限 数据条数：" + queryBuilder.count());
        }
        if (searchDetailBean.getXlLists().size() > 0) {
            if (searchDetailBean.getXllxType() == 1) {
                queryBuilder.where(DBGbBeanDao.Properties.FullTimeEducation.in(searchDetailBean.getXlLists()));
                LogUtil.e("全日制学历 数据条数：" + queryBuilder.count());
            } else if (searchDetailBean.getXllxType() == 2) {
                queryBuilder.where(DBGbBeanDao.Properties.CurrentEducation.in(searchDetailBean.getXlLists()));
                LogUtil.e("在职教育学历 数据条数：" + queryBuilder.count());
            } else {
                queryBuilder.whereOr(DBGbBeanDao.Properties.FullTimeEducation.in(searchDetailBean.getXlLists())
                        , DBGbBeanDao.Properties.CurrentEducation.in(searchDetailBean.getXlLists()));
                LogUtil.e("学历 数据条数：" + queryBuilder.count());
            }
        }
        if (searchDetailBean.getXxlxLists().size() > 0) {

            StringBuffer sql = new StringBuffer("");
            StringBuffer sql2 = new StringBuffer("");
            String[] values = new String[searchDetailBean.getXxlxLists().size()];
            for (int i = 0; i < searchDetailBean.getXxlxLists().size(); i++) {
                values[i] = "%" + searchDetailBean.getXxlxLists().get(i) + "%";
                if (i == 0) {
                    sql.append(" " + DBGbBeanDao.Properties.FullTimeSchoolType.columnName + " like " + "?");
                    sql2.append(" " + DBGbBeanDao.Properties.CurrentSchoolType.columnName + " like " + "?");
                } else {
                    sql.append(" or " + DBGbBeanDao.Properties.FullTimeSchoolType.columnName + " like " + " ?");
                    sql2.append(" or " + DBGbBeanDao.Properties.CurrentSchoolType.columnName + " like " + " ?");
                }
            }
            queryBuilder.whereOr(new WhereCondition.StringCondition(sql.toString(), values), new WhereCondition.StringCondition(sql2.toString(), values));

//            queryBuilder.whereOr(DBGbBeanDao.Properties.FullTimeSchoolType.like("%" + searchDetailBean.getXxlxListsStr() + "%")
//                    ,DBGbBeanDao.Properties.CurrentSchoolType.like("%" + searchDetailBean.getXxlxListsStr() + "%"));
            LogUtil.e("学校类型 数据条数：" + queryBuilder.count());
        }
        if (searchDetailBean.getGzjlLists().size() > 0) {

            StringBuffer sql = new StringBuffer("");
            String[] values = new String[searchDetailBean.getGzjlLists().size()];
            for (int i = 0; i < searchDetailBean.getGzjlLists().size(); i++) {
                values[i] = "%" + searchDetailBean.getGzjlLists().get(i) + "%";
                if (i == 0) {
                    sql.append(" " + DBGbBeanDao.Properties.WorkExperience.columnName + " like " + "?");
                } else {
                    sql.append(" and " + DBGbBeanDao.Properties.WorkExperience.columnName + " like " + " ?");
                }
            }
            queryBuilder.where(new WhereCondition.StringCondition(sql.toString(), values));

//            queryBuilder.where(DBGbBeanDao.Properties.WorkExperience.like("%" + searchDetailBean.getGzjlListsStr() + "%"));
            LogUtil.e("工作经历 数据条数：" + queryBuilder.count());
        }
        if (searchDetailBean.getXrzjlxLists().size() > 0) {
            queryBuilder.where(DBGbBeanDao.Properties.FunctionaryRankParentName.in(searchDetailBean.getXrzjlxLists()));
            LogUtil.e("现任职级类型 数据条数：" + queryBuilder.count());
        }
        if (searchDetailBean.getXrzjLists().size() > 0) {
            queryBuilder.where(DBGbBeanDao.Properties.FunctionaryRankName.in(searchDetailBean.getXrzjLists()));
            LogUtil.e("现任职级 数据条数：" + queryBuilder.count());
        }
        if (searchDetailBean.getXrzjnxLists().size() > 0) {
            List<String> lists = searchDetailBean.getXrzjnxLists2();
            queryBuilder.whereOr(DBGbBeanDao.Properties.FunctionaryRankTime.between(lists.get(0), lists.get(1)),
                    DBGbBeanDao.Properties.FunctionaryRankTime.like(lists.get(0) + "%"),
                    DBGbBeanDao.Properties.FunctionaryRankTime.like(lists.get(1) + "%"));
            LogUtil.e("现任职级年限 数据条数：" + queryBuilder.count());
        }

        if (orderBy != null) {
            if (isAsc) {
                queryBuilder.orderAsc(orderBy);
            } else {
                queryBuilder.orderDesc(orderBy);
            }
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


//    //初始化recyclerview
//    public void initRecycler() {
//        recyclerView = $(R.id.recycler_view);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        mAdapter = new GbAdapter(activity, new ArrayList<DBGbBean>(),type);
//        recyclerView.setAdapter(mAdapter);
//
//        mAdapter.setOnItemClickListener(new GbAdapter.OnItemClickListener() {
//            @Override
//            public void onClick(int pos) {
////                Intent intent = new Intent(context, GbDetailActivity.class);
////                intent.putExtra("ID", datas.get(pos).getBaseId());
////                startActivity(intent);
//
//                gbDrawerData.getData(datas.get(pos).getBaseId());
//                scrollView.scrollTo(0,0);
//                drawer_layout.openDrawer(Gravity.RIGHT);
//            }
//        });
//    }

    //初始化recyclerview
    public void initRecycler() {
        recyclerView = $(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

//        if (TextUtils.equals(type, "3")) {
//            mAdapterHbgb = new GbAdapterHbgb(activity, new ArrayList<DBGbBean>());
//            recyclerView.setAdapter(mAdapterHbgb);
//            recyclerView.getItemAnimator().setChangeDuration(0);
//            mAdapterHbgb.setOnItemClickListener(new GbAdapterHbgb.OnItemClickListener() {
//                @Override
//                public void onClick(int pos) {
//                    gbDrawerData.getData(datas.get(pos).getBaseId());
//                    scrollView.scrollTo(0, 0);
//                    drawer_layout.openDrawer(Gravity.RIGHT);
//                }
//            });
//        } else if (TextUtils.equals(type, "2")) {
//            mAdapterGwy = new GbAdapterGwy(activity, new ArrayList<DBGbBean>());
//            recyclerView.setAdapter(mAdapterGwy);
//            recyclerView.getItemAnimator().setChangeDuration(0);
//            mAdapterGwy.setOnItemClickListener(new GbAdapterGwy.OnItemClickListener() {
//                @Override
//                public void onClick(int pos) {
//                    gbDrawerData.getData(datas.get(pos).getBaseId());
//                    scrollView.scrollTo(0, 0);
//                    drawer_layout.openDrawer(Gravity.RIGHT);
//                }
//            });
//        } else {
//            mAdapterLdgb = new GbAdapterLdgb(activity, new ArrayList<DBGbBean>());
//            recyclerView.setAdapter(mAdapterLdgb);
//            recyclerView.getItemAnimator().setChangeDuration(0);
//            mAdapterLdgb.setOnItemClickListener(new GbAdapterLdgb.OnItemClickListener() {
//                @Override
//                public void onClick(int pos) {
//                    gbDrawerData.getData(datas.get(pos).getBaseId());
//                    scrollView.scrollTo(0, 0);
//                    drawer_layout.openDrawer(Gravity.RIGHT);
//                }
//            });
//        }
        mAdapterLdgb = new GbAdapterLdgb(activity, new ArrayList<DBGbBean>());
        recyclerView.setAdapter(mAdapterLdgb);
        recyclerView.getItemAnimator().setChangeDuration(0);
        mAdapterLdgb.setOnItemClickListener(new GbAdapterLdgb.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                gbDrawerData.getData(datas.get(pos).getBaseId());
                scrollView.scrollTo(0, 0);
                drawer_layout.openDrawer(Gravity.RIGHT);
            }
        });
    }


    private void initDrawer() {
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

    private void initDrawerGbInfo() {
        scrollView = findViewById(R.id.scrollView);
        layout_info = findViewById(R.id.layout_info);
        gbDrawerData = new GbDrawerData(context, layout_info);
        gbDrawerData.initView();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_xrzsj:
            case R.id.ll_xrzsj_ldgb:
            case R.id.ll_xrzsj_gwy:
                sortDate(order_xrzsj);
                break;
            case R.id.ll_xrzwccsj:
            case R.id.ll_xrzwccsj_ldgb:
                sortDate(order_xrzwccsj);
                break;
            case R.id.ll_rzjsj:
            case R.id.ll_rzjsj_ldgb:
                sortDate(order_rzjsj);
                break;
            case R.id.ll_rzjqssj:
            case R.id.ll_rzjqssj_gwy:
                sortDate(order_rzjqssj);
                break;
            case R.id.ll_cjgzsj:
            case R.id.ll_cjgzsj_gwy:
                sortDate(order_cjgzsj);
                break;
            case R.id.ll_csny:
            case R.id.ll_csny_ldgb:
            case R.id.ll_csny_gwy:
            case R.id.ll_csny_hbgb:
                sortDate(order_csny);
                break;
        }
    }
}
