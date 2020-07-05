package com.example.cadres.view.dsjty;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cadres.greendao.gen.DBTyHjDao;
import com.cadres.greendao.gen.DbTyJgDao;
import com.cadres.greendao.gen.DbTyZsDao;
import com.example.cadres.R;
import com.example.cadres.adapter.ListDialogAdapter2;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.common.BmLeftBean;
import com.example.cadres.bean.common.ListDialogBean;
import com.example.cadres.bean.dsjty.ZstyBean;
import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.beanDB.DBTyHj;
import com.example.cadres.beanDB.DbTyJg;
import com.example.cadres.beanDB.DbTyZs;
import com.example.cadres.dialog.ListDialog2;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.StatusBarUtil;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoManager;
import com.example.cadres.utils.greendao.DaoUtilsStore;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;

public class DsjtyActivity extends BaseActivity implements View.OnClickListener {

    NestedScrollView id_ty_zs_layout, id_ty_jg_layout, id_ty_swbz_layout;
    ImageView iv_title_left, iv_title_center, iv_title_right;
    TextView tv_title_left, tv_title_center, tv_title_right;
    View view_back, view_home;

    TextView tv_dialog;
    Group group_dialog;

    int deptId;


    @Override
    public int getLayoutId() {
        return R.layout.activity_dsjty;
    }

    @Override
    public void initView() {
        hideTitleLayout();

        StatusBarUtil.setStatusBar(this, getResources().getColor(R.color.color_0b1342));

        group_dialog = findViewById(R.id.group_dialog);
        id_ty_zs_layout = findViewById(R.id.id_ty_zs_layout);
        id_ty_jg_layout = findViewById(R.id.id_ty_jg_layout);
        id_ty_swbz_layout = findViewById(R.id.id_ty_swbz_layout);
        iv_title_left = findViewById(R.id.iv_title_left);
        iv_title_center = findViewById(R.id.iv_title_center);
        iv_title_right = findViewById(R.id.iv_title_right);
        tv_title_left = findViewById(R.id.tv_title_left);
        tv_title_center = findViewById(R.id.tv_title_center);
        tv_title_right = findViewById(R.id.tv_title_right);
        view_back = findViewById(R.id.view_back);
        view_home = findViewById(R.id.view_home);
        tv_dialog = findViewById(R.id.tv_dialog);

        tv_dialog.setOnClickListener(this);

        view_home.setOnClickListener(this);
        view_back.setOnClickListener(this);
        iv_title_left.setOnClickListener(this);
        iv_title_center.setOnClickListener(this);
        iv_title_right.setOnClickListener(this);

        initZsLayout();
    }

    @Override
    public void initData() {
        setType(1);

        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
        dBBmDaoUtils = _Store.getBmDaoUtils();

        getDbBmList();

        if (dbBmList != null && dbBmList.size() > 0) {
            tv_dialog.setText(dbBmList.get(0).getDeptName());
            deptId = dbBmList.get(0).getDeptId();

            //TODO 获取三个推演的数据
            getDbZsTyData();
            getDbJgTyData();
            getDbHjTyData();
            //TODO 设置三个推演的界面
            setZstyLayout();

        }
    }

    TextView tv_1_zs_content, tv_2_zs_content, tv_3_zs_content, tv_4_zs_content,tv_zs_tx;
//    LineChart lineChart;

    public void initZsLayout() {
        tv_1_zs_content = findViewById(R.id.tv_1_zs_content);
        tv_2_zs_content = findViewById(R.id.tv_2_zs_content);
        tv_3_zs_content = findViewById(R.id.tv_3_zs_content);
        tv_4_zs_content = findViewById(R.id.tv_4_zs_content);
        tv_zs_tx = findViewById(R.id.tv_zs_tx);
//        lineChart = findViewById(R.id.lineChart);

    }

    public void setZstyLayout(){
        if(dbTyZs == null) return;
        tv_1_zs_content.setText(dbTyZs.getToVacancy() + "");
        tv_2_zs_content.setText(dbTyZs.getParallel()+ "");
        tv_3_zs_content.setText(dbTyZs.getOvermatch()+ "");
        tv_4_zs_content.setText(dbTyZs.getVacancy()+ "");
        tv_zs_tx.setText("退休人数：" + dbTyZs.getRankAgeListNum());

//        setZstyChart();

    }

//    private void setZstyChart() {
//        //显示边界
//        lineChart.setDrawBorders(false);
//
//        List<Entry> entries = new ArrayList<>();
//        String[] xData = new String[dbTyZs.getMyRankAgeList().size()];
//        for (int i = 0; i < dbTyZs.getMyRankAgeList().size(); i++) {
//            entries.add(new Entry(dbTyZs.getMyRankAgeList().get(i).getNum(), i));
//            xData[i] = dbTyZs.getMyRankAgeList().get(i).getName() + "年";
//        }
//        LineDataSet lineDataSet = new LineDataSet(entries, "人数");
//        lineDataSet.setColor(ContextCompat.getColor(context,R.color.color_1eb0fc));                     // 设置数据中线的颜色
//        lineDataSet.setDrawValues(false);                     // 设置是否显示数据点的值
//        lineDataSet.setDrawCircleHole(false);                 // 设置数据点是空心还是实心，默认空心
//        lineDataSet.setCircleColor(ContextCompat.getColor(context,R.color.white));              // 设置数据点的颜色
//        lineDataSet.setCircleSize(3);                         // 设置数据点的大小
//        LineData lineData = new LineData(xData, lineDataSet);
//
//        // 把X轴放到下面
//        XAxis xAxis = lineChart.getXAxis();
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setTextColor(ContextCompat.getColor(context,R.color.white));
//        // 不需要右面显示Y轴
//        YAxis axisRight = lineChart.getAxisRight();
//        axisRight.setEnabled(false);
//        YAxis axisLeft = lineChart.getAxisLeft();
//        axisLeft.setTextColor(ContextCompat.getColor(context,R.color.white));
//        Legend legend = lineChart.getLegend();
//        legend.setEnabled(false);                                // 不需要Legend
//
//        // 设置默认右下角的描述
//        lineChart.setDescription("");
//        lineChart.setDragEnabled(false);                   // 不可以拖动
//        lineChart.setDoubleTapToZoomEnabled(false);        // 不可以双击缩放
//        lineChart.setScaleEnabled(false);
//        lineChart.setData(lineData);
//    }

    DBTyHj dbTyHj;
    private void getDbHjTyData() {
        DBTyHjDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBTyHjDao();
        QueryBuilder<DBTyHj> queryBuilder = dbGbBeanDao.queryBuilder();
        queryBuilder.unique();
        dbTyHj = queryBuilder.unique();
    }


    DbTyJg dbTyJg;

    private void getDbJgTyData() {
        DbTyJgDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDbTyJgDao();
        QueryBuilder<DbTyJg> queryBuilder = dbGbBeanDao.queryBuilder();
        queryBuilder.where(DbTyJgDao.Properties.DeptId.eq(deptId));
        dbTyJg = queryBuilder.unique();
    }


    DbTyZs dbTyZs;

    public void getDbZsTyData() {
        DbTyZsDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDbTyZsDao();
        QueryBuilder<DbTyZs> queryBuilder = dbGbBeanDao.queryBuilder();
        queryBuilder.where(DbTyZsDao.Properties.Deptid.eq(deptId));
        dbTyZs = queryBuilder.unique();
    }


    //------------------------------父类界面设置
    public void setType(int type) {
        clean();
        if (type == 1) {
            id_ty_zs_layout.setVisibility(View.VISIBLE);
            iv_title_left.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_left));
            tv_title_left.setTextColor(ContextCompat.getColor(context, R.color.white));
            group_dialog.setVisibility(View.VISIBLE);
        } else if (type == 2) {
            id_ty_jg_layout.setVisibility(View.VISIBLE);
            iv_title_center.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_center));
            tv_title_center.setTextColor(ContextCompat.getColor(context, R.color.white));

            group_dialog.setVisibility(View.VISIBLE);
        } else if (type == 3) {
            id_ty_swbz_layout.setVisibility(View.VISIBLE);
            iv_title_right.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_right));
            tv_title_right.setTextColor(ContextCompat.getColor(context, R.color.white));
        }
    }

    private void clean() {
        id_ty_zs_layout.setVisibility(View.GONE);
        id_ty_jg_layout.setVisibility(View.GONE);
        id_ty_swbz_layout.setVisibility(View.GONE);

        iv_title_left.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_left_un));
        iv_title_center.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_center_un));
        iv_title_right.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_right_un));

        tv_title_left.setTextColor(ContextCompat.getColor(context, R.color.color_23cffd));
        tv_title_center.setTextColor(ContextCompat.getColor(context, R.color.color_23cffd));
        tv_title_right.setTextColor(ContextCompat.getColor(context, R.color.color_23cffd));

        group_dialog.setVisibility(View.GONE);
    }


    //------------------------点击事件
    ListDialog2 listDialog;
    List<ListDialogBean> dialogDatas = new ArrayList<>();

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_dialog:
                if (listDialog == null) {
                    dialogDatas = new ArrayList<>();
                    for (int i = 0; i < bmLeftBeans.size(); i++) {
                        ListDialogBean item = new ListDialogBean(bmLeftBeans.get(i).getId(), bmLeftBeans.get(i).getName());
                        dialogDatas.add(item);
                    }
                    listDialog = new ListDialog2(context, dialogDatas);
                    listDialog.setItemClickListener(new ListDialogAdapter2.OnItemClickListener() {
                        @Override
                        public void onClick(int position) {
                            listDialog.dismiss();
                            tv_dialog.setText(dialogDatas.get(position).getName());

                            deptId = dialogDatas.get(position).getId();

                            //TODO 切换职数，结构推演数据
                            getDbZsTyData();
                            getDbJgTyData();

                            //TODO 设置两个推演的界面

                        }
                    });
                }
                listDialog.show();
                break;
            case R.id.view_home:
            case R.id.view_back:
                finish();
                break;
            case R.id.iv_title_left:
                setType(1);
                break;
            case R.id.iv_title_center:
                setType(2);
                break;
            case R.id.iv_title_right:
                setType(3);
                break;

        }
    }


    //----------------------------Dialog

    List<DBBmBean> dbBmList;
    CommonDaoUtils<DBBmBean> dBBmDaoUtils;

    public List<DBBmBean> getDbBmList() {
        dbBmList = new ArrayList<>();
        dbBmList = dBBmDaoUtils.queryAll();
        LogUtil.e("数据库条数：" + dbBmList.size());

        setBmLeftBean();

        return dbBmList;
    }

    public void setBmLeftBean() {
        List<BmLeftBean> bmLeftBeans = new ArrayList<>();
        for (int i = 0; i < dbBmList.size(); i++) {
            DBBmBean dbItem = dbBmList.get(i);
            BmLeftBean item = new BmLeftBean(dbItem.getDeptId(), dbItem.getParentId(), dbItem.getDeptName(), dbItem.getDeptType());
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
        sysout(rootTrees, "");
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
