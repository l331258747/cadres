package com.example.cadres.view.Gb;

import android.content.Intent;
import android.database.Cursor;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cadres.greendao.gen.DBBmBeanDao;
import com.cadres.greendao.gen.DBGbBeanDao;
import com.cadres.greendao.gen.DBGbCadreDeptListBeanDao;
import com.example.cadres.R;
import com.example.cadres.adapter.GbListAdapterLeft;
import com.example.cadres.adapter.GbListAdapterRight;
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

public class GbActivity2 extends BaseActivity implements View.OnClickListener {

    Group group_View_top;
    TextView tv_top_title, tv_top_btn, tv_top_hdzs2, tv_top_sjpb2, tv_top_cpqk2, tv_top_kqqk2;
    TextView tv_right_btn, tv_right_content;
    View view_menu;
    EditText et_search, et_left_search;
    RecyclerView recyclerViewListRight;
    RecyclerView recyclerViewListLeft;

    private final int order_xrzsj = 1;
    private final int order_xrzwccsj = 2;
    private final int order_rzjsj = 3;
    private final int order_rzjqssj = 4;
    private final int order_cjgzsj = 5;
    private final int order_csny = 6;

    DrawerLayout drawer_layout;
    NestedScrollView scrollView;
    ConstraintLayout layout_bm;
    LinearLayout layout_info;
    GbDrawerData gbDrawerData;

    GbListAdapterRight mAdapterListRight;
    GbListAdapterLeft mAdapterListLeft;

    CommonDaoUtils<DBGbBean> dBGbDaoUtils;
    List<DBGbBean> datas;

    DialogBmData dialogBmData;
    List<BmLeftBean> bmLeftBeans2 = new ArrayList<>();

    String type;
    String title;

    @Override
    public int getLayoutId() {
        return R.layout.activity_gb_drawer2;
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

        initRecyclerListLeft();
        initRecyclerListRight();

        initDrawer();
        initDrawerLeft();
        initDrawerRight();
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

        ll_xrzsj.setOnClickListener(this);
        ll_xrzwccsj.setOnClickListener(this);
        ll_rzjsj.setOnClickListener(this);
        ll_rzjqssj.setOnClickListener(this);
        ll_cjgzsj.setOnClickListener(this);
        ll_csny.setOnClickListener(this);
    }

    int mSortType;

    private void sortDate(int sortType) {
        iv_xrzsj.setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.ic_sort_defult));
        iv_xrzwccsj.setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.ic_sort_defult));
        iv_rzjsj.setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.ic_sort_defult));
        iv_rzjqssj.setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.ic_sort_defult));
        iv_cjgzsj.setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.ic_sort_defult));
        iv_csny.setImageDrawable(ContextCompat.getDrawable(context, R.mipmap.ic_sort_defult));

        recyclerViewListLeft.scrollToPosition(0);
        recyclerViewListRight.scrollToPosition(0);

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
        setAdapterData(getGbBmData());
    }

    public void setAdapterData(List<DBGbBean> list){
        if(list == null) return;
        mAdapterListRight.setData(list);
        mAdapterListLeft.setData(list);
    }

    TextView tv_xrzwcc,tv_zwjb;
    private void initTitleTab() {
        tv_xrzwcc = $(R.id.tv_xrzwcc);
        tv_zwjb = $(R.id.tv_zwjb);

        ll_xrzsj.setVisibility(View.GONE);
        tv_xrzwcc.setVisibility(View.GONE);
        ll_xrzwccsj.setVisibility(View.GONE);
        tv_zwjb.setVisibility(View.GONE);
        ll_rzjsj.setVisibility(View.GONE);
        ll_rzjqssj.setVisibility(View.GONE);
        ll_cjgzsj.setVisibility(View.GONE);

        if (TextUtils.equals(type, "3") || TextUtils.equals(type, "4")) {
            ll_xrzsj.setVisibility(View.VISIBLE);
            ll_rzjqssj.setVisibility(View.VISIBLE);
            ll_cjgzsj.setVisibility(View.VISIBLE);
        } else if(TextUtils.equals(type, "2")){
        } else {
            ll_xrzsj.setVisibility(View.VISIBLE);
            tv_xrzwcc.setVisibility(View.VISIBLE);
            ll_xrzwccsj.setVisibility(View.VISIBLE);
            tv_zwjb.setVisibility(View.VISIBLE);
            ll_rzjsj.setVisibility(View.VISIBLE);
        }
    }

    private void initDrawerLeft() {
        initLeftSearch();
        initRecyclerLeft();
    }

    private void initDrawerRight() {
        layout_bm = findViewById(R.id.layout_bm);
        tv_right_btn = findViewById(R.id.tv_right_btn);
        tv_right_content = findViewById(R.id.tv_right_content);

        tv_right_content.setMovementMethod(new ScrollingMovementMethod());//设置textview可以滑动
        tv_right_content.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tv_right_content.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        tv_right_btn.setOnClickListener(this);
    }

    private void initDrawerGbInfo() {
        scrollView = findViewById(R.id.scrollView);
        layout_info = findViewById(R.id.layout_info);
        gbDrawerData = new GbDrawerData(context, layout_info);
        gbDrawerData.initView();
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

    private void initLeftSearch() {
        et_left_search = findViewById(R.id.et_left_search);
        et_left_search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                /*判断是否是“搜索”键*/
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String key = et_left_search.getText().toString().trim();
                    if (!TextUtils.isEmpty(key)) {
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
                if (TextUtils.isEmpty(et_left_search.getText().toString())) {
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
        sortDate(0);
        setAdapterData(getGbBmData());
        getDbBmList("");
        leftAdapter.setData(bmLeftBeans2, deptId);
    }

    //初始化recyclerview
    public void initRecyclerListLeft() {
        recyclerViewListLeft = $(R.id.recycler_view_list_left);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerViewListLeft.setLayoutManager(linearLayoutManager);

        recyclerViewListLeft.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (RecyclerView.SCROLL_STATE_IDLE != recyclerView.getScrollState()) {
                    recyclerViewListRight.scrollBy(dx, dy);
                }

            }
        });

        mAdapterListLeft = new GbListAdapterLeft(activity, new ArrayList<DBGbBean>());
        recyclerViewListLeft.setAdapter(mAdapterListLeft);
        recyclerViewListLeft.getItemAnimator().setChangeDuration(0);
        mAdapterListLeft.setOnItemClickListener(new GbListAdapterLeft.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                gbDrawerData.getData(datas.get(pos).getBaseId());

                layout_bm.setVisibility(View.GONE);
                layout_info.setVisibility(View.VISIBLE);
                scrollView.scrollTo(0, 0);

                drawer_layout.openDrawer(Gravity.RIGHT);
            }
        });
    }

    //初始化recyclerview
    public void initRecyclerListRight() {
        recyclerViewListRight = $(R.id.recycler_view_list_right);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerViewListRight.setLayoutManager(linearLayoutManager);

        recyclerViewListRight.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (RecyclerView.SCROLL_STATE_IDLE != recyclerView.getScrollState()) {
                    recyclerViewListLeft.scrollBy(dx, dy);
                }

            }
        });

        mAdapterListRight = new GbListAdapterRight(activity, new ArrayList<DBGbBean>(),type);
        recyclerViewListRight.setAdapter(mAdapterListRight);
        recyclerViewListRight.getItemAnimator().setChangeDuration(0);
        mAdapterListRight.setOnItemClickListener(new GbListAdapterRight.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                gbDrawerData.getData(datas.get(pos).getBaseId());

                layout_bm.setVisibility(View.GONE);
                layout_info.setVisibility(View.VISIBLE);
                scrollView.scrollTo(0, 0);

                drawer_layout.openDrawer(Gravity.RIGHT);
            }
        });
    }

    //--------------left
    List<DBBmBean> dbBmList;

    public List<DBBmBean> getDbBmList(String key) {
        dbBmList = new ArrayList<>();
        DBBmBeanDao dbBmBeanDao = DaoManager.getInstance().getDaoSession().getDBBmBeanDao();
        QueryBuilder<DBBmBean> queryBuilder = dbBmBeanDao.queryBuilder();

        if (!TextUtils.isEmpty(key)) {
            String sql = " " + DBBmBeanDao.Properties.ParentId.columnName
                    + " in ( "
                    + " select " + DBBmBeanDao.Properties.DeptId.columnName
                    + " from " + DBBmBeanDao.TABLENAME
                    + " where " + DBBmBeanDao.Properties.DeptName.columnName + " like ? "
                    + " ) "
                    + " or " + DBBmBeanDao.Properties.DeptName.columnName + " like ? ";
            String[] values = new String[]{"%" + key + "%","%" + key + "%"};
            queryBuilder.where(new WhereCondition.StringCondition(sql,values));
        }
        dbBmList = queryBuilder.list();
        LogUtil.e("数据库条数：" + dbBmList.size());

        if (!TextUtils.isEmpty(key)) {
            bmLeftBeans2 = dialogBmData.getBmLeftBean2(dbBmList);
        }else {
            bmLeftBeans2 = dialogBmData.getBmLeftBean(dbBmList);
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
                if (item == null) return;
                leftAdapter.setItemData(item.getDeptId());

                if (TextUtils.equals(item.getDeptType(), "1")) {
                    group_View_top.setVisibility(View.VISIBLE);
                    tv_top_title.setText(item.getDeptName());
                    tv_top_hdzs2.setText(item.getVerification());
                    tv_top_sjpb2.setText(item.getActual());
                    tv_top_cpqk2.setText(item.getOvermatch());
                    tv_top_kqqk2.setText(item.getMismatch());
                } else {
                    group_View_top.setVisibility(View.GONE);
                }

                deptId = item.getDeptId();
                drawer_layout.closeDrawer(Gravity.LEFT);
                AppUtils.HideKeyboard(et_left_search);

                if (item.getParentId() == 0) {
                    deptId = 0;
                }
                sortDate(0);
                setAdapterData(getGbBmData());
            }
        });
    }



    public DBBmBean getDBBmBean(int pos) {
        for (int i = 0; i < dbBmList.size(); i++) {
            if (bmLeftBeans2.get(pos).getId() == dbBmList.get(i).getDeptId()) {
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
                scrollView.scrollTo(0, 0);

                drawer_layout.openDrawer(Gravity.RIGHT);
                break;
            case R.id.et_search:
                Intent intent = new Intent(context, SearchActivity.class);
//                intent.putExtra("type", type);
                startActivity(intent);
                break;
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


    //-----------------------------搜部门干部 多表查询 orderAsc正序 orderDesc倒序
    public List<DBGbBean> getDbGbBmList(int deptId, Property orderBy, boolean isAsc) {
        List<DBGbBean> dbList;

        if (deptId != 0 && orderBy == null) {
            dbList = getDbGbBmListRanking(deptId);
        } else {
            DBGbBeanDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBGbBeanDao();
            QueryBuilder<DBGbBean> queryBuilder = dbGbBeanDao.queryBuilder();
            queryBuilder.where(DBGbBeanDao.Properties.Type.like("%" + type + "%"));
            if (deptId != 0) {
                queryBuilder.join(DBGbBeanDao.Properties.BaseId, DBGbCadreDeptListBean.class, DBGbCadreDeptListBeanDao.Properties.BaseId)
                        .where(DBGbCadreDeptListBeanDao.Properties.DeptId.eq(deptId));
            }
            if (orderBy != null) {
                if (isAsc) {
                    queryBuilder.orderAsc(orderBy);
                } else {
                    queryBuilder.orderDesc(orderBy);
                }
            }
            queryBuilder.distinct();
            dbList = queryBuilder.list();
            LogUtil.e("2数据库条数：" + dbList.size());
        }

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
        if (dates == null || dates.size() == 0)
            return 0;
        else
            return dates.get(0).getDeptId();
    }

    private List<DBGbBean> getDbGbBmListRanking(int deptId) {
        List<DBGbBean> dbList = new ArrayList<>();

        Cursor cursor = null;

        String queryString =
                "SELECT DISTINCT "
                        + "b.*"
                        + ", d." + DBGbCadreDeptListBeanDao.Properties.Ranking.columnName + " AS _RANKING "
                        + " FROM " + DBGbBeanDao.TABLENAME + " b"
                        + " JOIN " + DBGbCadreDeptListBeanDao.TABLENAME + " d"
                        + " ON "
                        + " b." + DBGbBeanDao.Properties.BaseId.columnName + " = " + " d." + DBGbCadreDeptListBeanDao.Properties.BaseId.columnName
                        + " WHERE "
                        + " d." + DBGbCadreDeptListBeanDao.Properties.DeptId.columnName + " = " + deptId
                        + " AND "
                        + " b." + DBGbBeanDao.Properties.Type.columnName + " LIKE ?"
                        + " ORDER BY _RANKING ASC";
        try {
            cursor = DaoManager.getInstance().getDaoSession().getDatabase().rawQuery(queryString, new String[]{"%" + type + "%"});
            if (cursor != null) {
                while (cursor.moveToNext()){
                    dbList.add(new DBGbBean(
                            null,
                            cursor.getInt(cursor.getColumnIndex(DBGbBeanDao.Properties.BaseId.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.Name.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.PhotoFileName.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.Gender.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.IdCard.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.Birthday.columnName)),
                            cursor.getInt(cursor.getColumnIndex(DBGbBeanDao.Properties.Age.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.Nation.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.PoliticalOutlook.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.JoinPartyDate.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.NativePlace.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.Birthplace.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.WorkTime.columnName)),
                            cursor.getInt(cursor.getColumnIndex(DBGbBeanDao.Properties.PersonnelRelationsDeptId.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.PersonnelRelationsDeptName.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.EnterUnitTime.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.CurrentRank.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.CurrentRankTime.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.Health.columnName)),
                            cursor.getInt(cursor.getColumnIndex(DBGbBeanDao.Properties.FunctionaryRankId.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.FunctionaryRankName.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.FunctionaryRankTime.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.CadreType.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.CurrentPosition.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.CurrentPositionTime.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.PersonnelType.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.TechnicalTitle.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.Expertise.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.FullTime.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.FullTimeEducation.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.FullTimeSchool.columnName)),
                            cursor.getInt(cursor.getColumnIndex(DBGbBeanDao.Properties.FullTimeDegreeId.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.FullTimeDegreeName.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.FullTimeSchoolType.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.Current.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.CurrentEducation.columnName)),
                            cursor.getInt(cursor.getColumnIndex(DBGbBeanDao.Properties.CurrentDegreeId.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.CurrentDegreeName.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.CurrentSchool.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.CurrentSchoolType.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.WorkPhone.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.PhoneNumber.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.HomeAddress.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.Responsibilities.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.AffectedState.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.FullTimeMajor.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.CurrentMajor.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.FullTimeSchoolMajor.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.CurrentSchoolMajor.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.NativePlaceReplenish.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.FunctionaryRegisterTime.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.PositionType.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.EstablishmentType.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.Remark.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.Type.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.CadreResume.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.CadreAward.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.CadrePunish.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.CadreTrain.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.PoliticalConstruction.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.CadreAssessment.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.FunctionaryRankStartTime.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.FunctionaryRankParentName.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.PostLabel.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.WorkExperience.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.SpouseName.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.SpouseWorkUnit.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.ServiceStartTime.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.ServiceYears.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.ServiceYearsState.columnName)),
                            cursor.getString(cursor.getColumnIndex(DBGbBeanDao.Properties.CadreQuarterAssessment.columnName))
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return dbList;
    }
}
