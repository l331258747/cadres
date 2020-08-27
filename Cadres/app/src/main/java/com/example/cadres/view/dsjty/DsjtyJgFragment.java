package com.example.cadres.view.dsjty;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.cadres.greendao.gen.DBBmBeanDao;
import com.cadres.greendao.gen.DbTyJgDao;
import com.example.cadres.R;
import com.example.cadres.adapter.ListDialogAdapter2;
import com.example.cadres.base.BaseFragment;
import com.example.cadres.bean.ChartBean;
import com.example.cadres.bean.common.BmLeftBean;
import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.beanDB.DbTyJg;
import com.example.cadres.dialog.ListDialog2;
import com.example.cadres.utils.AppUtils;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.chart.MyPieChartRenderer;
import com.example.cadres.utils.chart.MyPieChartRenderer2;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoManager;
import com.example.cadres.utils.greendao.DaoUtilsStore;
import com.example.cadres.utils.myData.DialogBmData;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;

public class DsjtyJgFragment extends BaseFragment implements View.OnClickListener {

    String type;

    public static Fragment newInstance(String type) {
        DsjtyJgFragment fragment = new DsjtyJgFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            type = bundle.getString("type");
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_ty_jgty;
    }

    @Override
    public void initView() {
        group_dialog = $(R.id.group_dialog);
        tv_dialog = $(R.id.tv_dialog);

        tv_dialog.setOnClickListener(this);

        initJgtyView();
    }

    @Override
    public void initData() {
        dialogBmData = new DialogBmData();
        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
        dBBmDaoUtils = _Store.getBmDaoUtils();

        getDbBmList("");

        if (dbBmList != null && dbBmList.size() > 0) {
            tv_dialog.setText(dbBmList.get(0).getDeptName());
            deptId = dbBmList.get(0).getDeptId();

            getDbJgTyData();

            if (dbTyJg != null) {
                initJgtyChart(chart_jg_zzmm);
                initJgtyChart(chart_jg_mz);
                initJgtyChart(chart_jg_nljg);
                initJgtyChart(chart_jg_xl);
                initJgtyChart(chart_jg_zy);
                setJgtyData();
            }
        }
    }


    //---------------结构推演界面 start

    TextView tv_jg_nan, tv_gj_nv;
    PieChart chart_jg_zzmm, chart_jg_nljg, chart_jg_mz, chart_jg_xl, chart_jg_zy;

    public void initJgtyView() {
        tv_jg_nan = $(R.id.tv_jg_nan);
        tv_gj_nv = $(R.id.tv_gj_nv);
        chart_jg_zzmm = $(R.id.chart_jg_zzmm);
        chart_jg_nljg = $(R.id.chart_jg_nljg);
        chart_jg_mz = $(R.id.chart_jg_mz);
        chart_jg_xl = $(R.id.chart_jg_xl);
        chart_jg_zy = $(R.id.chart_jg_zy);
    }

    public void setJgtyData() {
        tv_jg_nan.setText(dbTyJg.getSexNan());
        tv_gj_nv.setText(dbTyJg.getSexNv());

        List<PieEntry> entries1 = new ArrayList<>();
        for (int i = 0; i < dbTyJg.getChartBeanOutlookList().size(); i++) {
            ChartBean data = dbTyJg.getChartBeanOutlookList().get(i);
            PieEntry entry = new PieEntry((float) data.getAmount(), data.getNameAmout(), data);
            entries1.add(entry);
        }
        // 设置颜色list，让不同的块显示不同颜色，下面是我觉得不错的颜色集合，比较亮
        ArrayList<Integer> colors1 = new ArrayList<Integer>();
        colors1.add(Color.rgb(0, 180, 255));
        colors1.add(Color.rgb(148, 78, 254));
        showJgtyChart(chart_jg_zzmm, entries1, colors1, "");

        List<PieEntry> entries2 = new ArrayList<>();
        for (int i = 0; i < dbTyJg.getChartBeanNation().size(); i++) {
            ChartBean data = dbTyJg.getChartBeanNation().get(i);
            PieEntry entry = new PieEntry((float) data.getAmount(), data.getNameAmout(), data);
            entries2.add(entry);
        }
        // 设置颜色list，让不同的块显示不同颜色，下面是我觉得不错的颜色集合，比较亮
        ArrayList<Integer> colors2 = new ArrayList<Integer>();
        colors2.add(Color.rgb(28, 103, 218));
        colors2.add(Color.rgb(255, 211, 2));
        showJgtyChart(chart_jg_mz, entries2, colors2, "");

        List<PieEntry> entries3 = new ArrayList<>();
        for (int i = 0; i < dbTyJg.getChartBeanAgeList().size(); i++) {
            ChartBean data = dbTyJg.getChartBeanAgeList().get(i);
            PieEntry entry = new PieEntry((float) data.getAmount(), data.getNameAmout(), data);
            entries3.add(entry);
        }
        // 设置颜色list，让不同的块显示不同颜色，下面是我觉得不错的颜色集合，比较亮
        ArrayList<Integer> colors3 = new ArrayList<Integer>();
        colors3.add(Color.rgb(28, 103, 218));
        colors3.add(Color.rgb(254, 84, 85));
        colors3.add(Color.rgb(0, 180, 255));
        colors3.add(Color.rgb(255, 210, 2));
        colors3.add(Color.rgb(255, 137, 85));
        colors3.add(Color.rgb(0, 234, 203));
        showJgtyChart(chart_jg_nljg, entries3, colors3, "");

        List<PieEntry> entries4 = new ArrayList<>();
        for (int i = 0; i < dbTyJg.getChartBeanEducationList().size(); i++) {
            ChartBean data = dbTyJg.getChartBeanEducationList().get(i);
            PieEntry entry = new PieEntry((float) data.getNum(), data.getNameNum(), data);
            entries4.add(entry);
        }
        showJgtyChart(chart_jg_xl, entries4, colors3, "");

        List<PieEntry> entries5 = new ArrayList<>();
        for (int i = 0; i < dbTyJg.getChartBeanMajorList().size(); i++) {
            ChartBean data = dbTyJg.getChartBeanMajorList().get(i);
            PieEntry entry = new PieEntry((float) data.getNum(), data.getNameNum(), data);
            entries5.add(entry);
        }
        showJgtyChart(chart_jg_zy, entries5, colors3, "");
    }

    private void initJgtyChart(PieChart chart_jg_zzmm) {
        //描述
        Description description = chart_jg_zzmm.getDescription();
        description.setEnabled(false);

        //设置半透明圆环的半径, 0为透明
        chart_jg_zzmm.setTransparentCircleRadius(0f);
//        //设置初始旋转角度
//        chart_jg_zzmm.setRotationAngle(-15);
        // 和四周相隔一段距离,显示数据
        chart_jg_zzmm.setExtraOffsets(10, 10, 10, 10);

        // 设置pieChart图表是否可以手动旋转
        chart_jg_zzmm.setRotationEnabled(false);
        // 设置piecahrt图表点击Item高亮是否可用
        chart_jg_zzmm.setHighlightPerTapEnabled(true);
        // 设置pieChart图表展示动画效果，动画运行1.4秒结束
//        chart_jg_zzmm.animateY(1400, Easing.EaseInQuad);
        //设置pieChart是否只显示饼图上百分比不显示文字
        chart_jg_zzmm.setDrawEntryLabels(true);////设置pieChart是否只显示饼图上百分比不显示文字（true：下面属性才有效果）
        chart_jg_zzmm.setEntryLabelTextSize(10f);////设置pieChart图表文本字体大小
        // 百分比显示
        chart_jg_zzmm.setUsePercentValues(true);////使用百分比显示

        // 设置 pieChart 内部圆环属性   //设置了透明的中心区域
        chart_jg_zzmm.setDrawHoleEnabled(true);              //是否显示PieChart内部圆环(true:下面属性才有意义)
        chart_jg_zzmm.setHoleRadius(50f);                    //设置PieChart内部圆的半径(这里设置28.0f)
        chart_jg_zzmm.setTransparentCircleRadius(31f);       //设置PieChart内部透明圆的半径(这里设置31.0f)
        chart_jg_zzmm.setTransparentCircleColor(Color.TRANSPARENT);//设置PieChart内部透明圆与内部圆间距(31f-28f)填充颜色
        chart_jg_zzmm.setTransparentCircleAlpha(50);         //设置PieChart内部透明圆与内部圆间距(31f-28f)透明度[0~255]数值越小越透明
        chart_jg_zzmm.setHoleColor(Color.TRANSPARENT);             //设置PieChart内部圆的颜色
        chart_jg_zzmm.setDrawCenterText(true);               //是否绘制PieChart内部中心文本（true：下面属性才有意义）
        chart_jg_zzmm.setCenterText("");                 //设置PieChart内部圆文字的内容
        chart_jg_zzmm.setCenterTextSize(14f);                //设置PieChart内部圆文字的大小
        chart_jg_zzmm.setCenterTextColor(Color.WHITE);         //设置PieChart内部圆文字的颜色

        // 不显示图例
//        Legend legend = pieChart.getLegend();
//        legend.setEnabled(false);

        Legend l = chart_jg_zzmm.getLegend();
        l.setEnabled(false);                    //是否启用图列（true：下面属性才有意义）
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setForm(Legend.LegendForm.DEFAULT); //设置图例的形状
        l.setFormSize(10);                      //设置图例的大小
        l.setFormToTextSpace(10f);              //设置每个图例实体中标签和形状之间的间距
        l.setDrawInside(false);
        l.setWordWrapEnabled(true);              //设置图列换行(注意使用影响性能,仅适用legend位于图表下面)
        l.setXEntrySpace(10f);                  //设置图例实体之间延X轴的间距（setOrientation = HORIZONTAL有效）
        l.setYEntrySpace(8f);                  //设置图例实体之间延Y轴的间距（setOrientation = VERTICAL 有效）
        l.setYOffset(0f);                      //设置比例块Y轴偏移量
        l.setTextSize(12f);                      //设置图例标签文本的大小
        l.setTextColor(Color.parseColor("#23CEFD"));//设置图例标签文本的颜色

        MyPieChartRenderer2 customPieChartRenderer = new MyPieChartRenderer2(chart_jg_zzmm, chart_jg_zzmm.getAnimator(), chart_jg_zzmm.getViewPortHandler()); //new 一个类对象
        chart_jg_zzmm.setRenderer(customPieChartRenderer); //设置给piechart。 这里的holder 就是我的pirechart对象

    }

    private void showJgtyChart(PieChart chart_jg_zzmm, List<PieEntry> entries, ArrayList<Integer> colors, String name) {
        // 每一个LineDataSet代表一条线
        PieDataSet pieDataSet = new PieDataSet(entries, name);
        initJgtyDataSet(chart_jg_zzmm, pieDataSet, colors);
        PieData pieData = new PieData(pieDataSet);
        chart_jg_zzmm.setData(pieData);
        chart_jg_zzmm.notifyDataSetChanged();
        chart_jg_zzmm.invalidate();
    }

    private void initJgtyDataSet(PieChart chart_jg_zzmm, PieDataSet dataSet, ArrayList<Integer> colors) {
        dataSet.setColors(colors);
        //数据连接线距图形片内部边界的距离，为百分数
        dataSet.setValueLinePart1OffsetPercentage(80f);
        //设置连接线的颜色
        dataSet.setValueLineColor(Color.WHITE);
        // 连接线在饼状图外面
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        // 设置饼块之间的间隔
        dataSet.setSliceSpace(0f);
        dataSet.setHighlightEnabled(true);

        // 绘制内容value，设置字体颜色大小
        dataSet.setDrawValues(true);
        dataSet.setValueFormatter(new PercentFormatter(chart_jg_zzmm));
        dataSet.setValueTextSize(12f);//百分比大小
        dataSet.setValueTextColor(Color.WHITE);

        dataSet.setValueLinePart1Length(0.4f);//当值位置为外边线时，表示线的前半段长度。
        dataSet.setValueLinePart2Length(0.4f);//当值位置为外边线时，表示线的后半段长度。

    }


    //---------------结构推演界面 end


    DbTyJg dbTyJg;

    private void getDbJgTyData() {
        DbTyJgDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDbTyJgDao();
        QueryBuilder<DbTyJg> queryBuilder = dbGbBeanDao.queryBuilder();
        queryBuilder.where(DbTyJgDao.Properties.DeptId.eq(deptId));
        if (TextUtils.equals(type, "1")) {
            queryBuilder.where(DbTyJgDao.Properties.IsGwy.eq(false));
        } else {
            queryBuilder.where(DbTyJgDao.Properties.IsGwy.eq(true));
        }
        if (queryBuilder.count() != 0)
            dbTyJg = queryBuilder.unique();

        LogUtil.e("数据库条数：" + dbTyJg != null? "有" : "无");
    }


    //----------------------------Dialog

    TextView tv_dialog;
    Group group_dialog;

    int deptId;

    DialogBmData dialogBmData;
    List<BmLeftBean> bmLeftBeans2 = new ArrayList<BmLeftBean>();

    List<DBBmBean> dbBmList;
    CommonDaoUtils<DBBmBean> dBBmDaoUtils;

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
            String[] values = new String[]{"%" + key + "%", "%" + key + "%"};
            queryBuilder.where(new WhereCondition.StringCondition(sql, values));
        }
        dbBmList = queryBuilder.list();
        LogUtil.e("数据库条数：" + dbBmList.size());

        if (!TextUtils.isEmpty(key)) {
            bmLeftBeans2 = dialogBmData.getBmLeftBean2(dbBmList);
        } else {
            bmLeftBeans2 = dialogBmData.getBmLeftBean(dbBmList);
        }
        return dbBmList;
    }

    ListDialog2 listDialog;
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_dialog:
                if (listDialog == null) {
                    listDialog = new ListDialog2(context, bmLeftBeans2);
                    listDialog.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                        @Override
                        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                            /*判断是否是“搜索”键*/
                            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                                String key = listDialog.getEt_left_search().getText().toString().trim();
                                if(!TextUtils.isEmpty(key)){
                                    getDbBmList(key);
                                    listDialog.getAdapter().setData(bmLeftBeans2);
                                    AppUtils.HideKeyboard(listDialog.getEt_left_search());
                                }
                                return true;
                            }
                            return false;
                        }
                    });
                    listDialog.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {
                            if(TextUtils.isEmpty(listDialog.getEt_left_search().getText().toString())){
                                getDbBmList("");
                                listDialog.getAdapter().setData(bmLeftBeans2);
                            }
                        }
                    });
                    listDialog.setItemClickListener(new ListDialogAdapter2.OnItemClickListener() {
                        @Override
                        public void onClick(int position) {
                            listDialog.dismiss();
                            tv_dialog.setText(bmLeftBeans2.get(position).getName());
                            deptId = bmLeftBeans2.get(position).getId();
                            listDialog.getAdapter().setItemData(bmLeftBeans2.get(position).getId());

                            // 切换结构推演数据
                            getDbJgTyData();
                            // 设置结构推演的界面
                            if(dbTyJg != null){
                                setJgtyData();
                            }
                        }
                    });
                }
                listDialog.show();
                break;
        }
    }
}
