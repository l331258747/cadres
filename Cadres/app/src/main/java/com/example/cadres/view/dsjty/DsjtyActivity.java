package com.example.cadres.view.dsjty;

import android.content.Intent;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cadres.greendao.gen.DBTyHjDao;
import com.cadres.greendao.gen.DBTyZsNqgbDao;
import com.cadres.greendao.gen.DbTyJgDao;
import com.cadres.greendao.gen.DbTyZsDao;
import com.example.cadres.R;
import com.example.cadres.adapter.ListDialogAdapter2;
import com.example.cadres.base.BaseActivity;
import com.example.cadres.bean.ChartBean;
import com.example.cadres.bean.common.BmLeftBean;
import com.example.cadres.bean.common.ListDialogBean;
import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.beanDB.DBTyHj;
import com.example.cadres.beanDB.DBTyZsNqgb;
import com.example.cadres.beanDB.DbTyJg;
import com.example.cadres.beanDB.DbTyZs;
import com.example.cadres.dialog.ListDialog2;
import com.example.cadres.utils.AppUtils;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.StatusBarUtil;
import com.example.cadres.utils.chart.HjPercentFormatter;
import com.example.cadres.utils.chart.MyPieChartRenderer;
import com.example.cadres.utils.chart.XYMarkerView;
import com.example.cadres.utils.chart.ZsPercentFormatter;
import com.example.cadres.utils.greendao.CommonDaoUtils;
import com.example.cadres.utils.greendao.DaoManager;
import com.example.cadres.utils.greendao.DaoUtilsStore;
import com.example.cadres.utils.myData.DialogBmData;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;

public class DsjtyActivity extends BaseActivity implements View.OnClickListener {

    NestedScrollView id_ty_zs_layout, id_ty_jg_layout, id_ty_swbz_layout;
    ImageView iv_title_left, iv_title_center, iv_title_right;
    TextView tv_title_left, tv_title_center, tv_title_right;
    View view_back, view_home;

    Group group_title_right;

    TextView tv_dialog;
    Group group_dialog;

    int deptId;

    DialogBmData dialogBmData;
    List<BmLeftBean> bmLeftBeans2 = new ArrayList<BmLeftBean>();

    String type;

    @Override
    public int getLayoutId() {
        return R.layout.activity_dsjty;
    }

    @Override
    public void initView() {
        type = intent.getStringExtra("type");

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
        group_title_right = findViewById(R.id.group_title_right);

        view_back = findViewById(R.id.view_back);
        view_home = findViewById(R.id.view_home);
        tv_dialog = findViewById(R.id.tv_dialog);

        tv_dialog.setOnClickListener(this);
        view_home.setOnClickListener(this);
        view_back.setOnClickListener(this);
        iv_title_left.setOnClickListener(this);
        iv_title_center.setOnClickListener(this);
        iv_title_right.setOnClickListener(this);

        initJgtyView();
        initHjtyView();
        initZstyView();
    }

    @Override
    public void initData() {
        setType(1);

        dialogBmData = new DialogBmData();

        DaoUtilsStore _Store = DaoUtilsStore.getInstance();
        dBBmDaoUtils = _Store.getBmDaoUtils();

        getDbBmList("");

        if (dbBmList != null && dbBmList.size() > 0) {
            tv_dialog.setText(dbBmList.get(0).getDeptName());
            deptId = dbBmList.get(0).getDeptId();

            // 获取三个推演的数据
            getDbZsTyData();
            getDbJgTyData();
            getDbHjTyData();

            // 设置三个推演的界面
            if(dbTyJg != null){
                initJgtyChart(chart_jg_zzmm);
                initJgtyChart(chart_jg_mz);
                initJgtyChart(chart_jg_nljg);
                initJgtyChart(chart_jg_xl);
                initJgtyChart(chart_jg_zy);
                setJgtyData();
            }

            if(dbTyHj != null){
                initHjtyChart(chart_swbz, dbTyHj.getSwbzcount());
                initHjtyChart(chart_szfbz, dbTyHj.getSzfbzcount());
                initHjtyChart(chart_srdcwhbz, dbTyHj.getSrdbzcount());
                initHjtyChart(chart_szxbz, dbTyHj.getSzxzcount());
                setHjtyData();
            }

            if(dbTyZs != null){
                setZstyData();
            }
            if(dbTyZsNqgb != null){
                setZstyNqgbData();
            }
        }
    }

    //-------------职数推演 start
    CombinedChart chart_zs;
    LineChart chart_zs_nqgb;
    Group group_zs_nqgb;
    private CombinedData data;

    public void initZstyView() {
        chart_zs = findViewById(R.id.chart_zs);
        chart_zs_nqgb = findViewById(R.id.chart_zs_nqgb);
        group_zs_nqgb = findViewById(R.id.group_zs_nqgb);
        if(TextUtils.equals(type,"1")){
            group_zs_nqgb.setVisibility(View.VISIBLE);
        }
    }

    public void setZstyData() {
        //绘制图表数据
        data = new CombinedData();
        //设置折线图数据
        data.setData(getLineData());
        //设置柱状图数据
        data.setData(getBarData());
        chart_zs.setData(data);
        //设置横坐标数据
        setAxisXBottom();
        //设置左侧纵坐标数据
        setAxisYLeft();

        chart_zs.getAxisRight().setEnabled(false);
        //是否展示网格线
        chart_zs.setDrawGridBackground(false);
        chart_zs.getDescription().setEnabled(false);
        chart_zs.getLegend().setEnabled(false);
        //是否显示边界
        chart_zs.setDrawBorders(false);
        //是否可以拖动
        chart_zs.setDragEnabled(false);
        //是否有触摸事件
        chart_zs.setTouchEnabled(true);
        //取消缩放
        chart_zs.setScaleEnabled(false);

        XYMarkerView mv = new XYMarkerView(this, dbTyZs);
        mv.setChartView(chart_zs);
        chart_zs.setMarker(mv);
    }

    /**
     * 设置横坐标数据
     */
    private void setAxisXBottom() {
        XAxis xAxis = chart_zs.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);
        xAxis.setDrawGridLines(false);
        xAxis.setTextColor(ContextCompat.getColor(context,R.color.white));
        xAxis.setAxisMinimum(-0.2f);
        xAxis.setAxisMaximum(dbTyZs.size() - 0.8f);
        xAxis.setTextSize(12f);

        //传入X轴的值，所以自定义X轴的值可以 写在该方法内
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return dbTyZs.get((int) value).getYear() + "年";
            }
        });
    }

    /**
     * 设置左侧纵坐标数据
     */
    private void setAxisYLeft() {
        YAxis leftYAxis = chart_zs.getAxisLeft();
        leftYAxis.setAxisMinimum(0f);
        leftYAxis.setTextColor(ContextCompat.getColor(context,R.color.white));
        //但还是显示了网格线，而且不是我们想要的 虚线 。其实那是 X Y轴自己的网格线，禁掉即可

        leftYAxis.setDrawGridLines(true);
        //设置X Y轴网格线为虚线（实体线长度、间隔距离、偏移量：通常使用 0）
        leftYAxis.enableGridDashedLine(10f, 10f, 0f);
    }

    /**
     * 设置折线图绘制数据
     * 温度
     *
     * @return
     */
    public LineData getLineData() {
        LineData lineData = new LineData();
        List<Entry> customCounts = new ArrayList<>();
        //人数
        for (int i = 0; i < dbTyZs.size(); i++) {
            customCounts.add(new Entry(i, dbTyZs.get(i).getOvermatch()));
        }
        LineDataSet lineDataSet = new LineDataSet(customCounts, "超配");
        lineDataSet.setColor(Color.rgb(1,183,255));
        lineDataSet.setCircleColor(Color.WHITE);
        lineDataSet.setValueTextColor(Color.WHITE);
        lineDataSet.setValueFormatter(new ZsPercentFormatter());
        lineDataSet.setDrawValues(true);
        lineDataSet.setLineWidth(2f);
        lineDataSet.setCircleRadius(5f);
        //设置曲线值的圆点是实心还是空心
        lineDataSet.setDrawCircleHole(false);
        lineDataSet.setValueTextSize(14f);
        //设置折线图填充
        lineDataSet.setDrawFilled(false);
        lineDataSet.setFormLineWidth(1f);
        lineDataSet.setFormSize(15.f);
        lineDataSet.setMode(LineDataSet.Mode.LINEAR);

        List<Entry> customCounts2 = new ArrayList<>();
        //人数
        for (int i = 0; i < dbTyZs.size(); i++) {
            customCounts2.add(new Entry(i, dbTyZs.get(i).getVacancy()));
        }
        LineDataSet lineDataSet2 = new LineDataSet(customCounts2, "可用空缺");
        lineDataSet2.setColor(Color.rgb(213,100,107));
        lineDataSet2.setCircleColor(Color.WHITE);
        lineDataSet2.setValueTextColor(Color.WHITE);
        lineDataSet2.setValueFormatter(new ZsPercentFormatter());
        lineDataSet2.setDrawValues(true);
        lineDataSet2.setLineWidth(2f);
        lineDataSet2.setCircleRadius(5f);
        //设置曲线值的圆点是实心还是空心
        lineDataSet2.setDrawCircleHole(false);
        lineDataSet2.setValueTextSize(14f);
        //设置折线图填充
        lineDataSet2.setDrawFilled(false);
        lineDataSet2.setFormLineWidth(1f);
        lineDataSet2.setFormSize(15.f);
        lineDataSet2.setMode(LineDataSet.Mode.LINEAR);

        lineData.addDataSet(lineDataSet);
        lineData.addDataSet(lineDataSet2);
        return lineData;
    }

    /**
     * 设置柱状图绘制数据
     *
     * @return chart_zs
     */
    public BarData getBarData() {
        List<BarEntry> yvalue=new ArrayList<>();
        for (int i = 0; i < dbTyZs.size(); i++) {
            yvalue.add(new BarEntry(i, new float[]{dbTyZs.get(i).getRankAge(),dbTyZs.get(i).getParallel(),dbTyZs.get(i).getToVacancy()}));
        }
        BarDataSet set=new BarDataSet(yvalue,"");
        set.setColors(new int[]{Color.rgb(222,148,109),Color.rgb(1,183,255),Color.rgb(0,231,213)});//set会循环这里的颜色进行添加
        set.setDrawValues(false);
//        //设置平均的柱状图
        BarData barData = new BarData();
        barData.addDataSet(set);

        //设置柱状图显示的大小
        float barWidth = 0.3f;
        barData.setBarWidth(barWidth);
        barData.setDrawValues(false);

        return barData;
    }








    public void setZstyNqgbData(){
        //设置横坐标数据
        setAxisXBottomNqgb();
        //设置左侧纵坐标数据
        setAxisYLeftNqgb();

        chart_zs_nqgb.getAxisRight().setEnabled(false);
        //是否展示网格线
        chart_zs_nqgb.setDrawGridBackground(false);
        chart_zs_nqgb.getDescription().setEnabled(false);
        chart_zs_nqgb.getLegend().setEnabled(false);
        //是否显示边界
        chart_zs_nqgb.setDrawBorders(false);
        //是否可以拖动
        chart_zs_nqgb.setDragEnabled(false);
        //是否有触摸事件
        chart_zs_nqgb.setTouchEnabled(true);
        //取消缩放
        chart_zs_nqgb.setScaleEnabled(false);

        chart_zs_nqgb.setData(getLineDataNqgb());

//        XYMarkerView mv = new XYMarkerView(this, dbTyZs);
//        mv.setChartView(chart_zs);
//        chart_zs.setMarker(mv);
    }

    /**
     * 设置横坐标数据
     */
    private void setAxisXBottomNqgb() {
        XAxis xAxis = chart_zs_nqgb.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);
        xAxis.setDrawGridLines(false);
        xAxis.setTextColor(ContextCompat.getColor(context,R.color.white));
        xAxis.setAxisMinimum(-0.2f);
        xAxis.setAxisMaximum(dbTyZsNqgb.size() - 0.8f);
        xAxis.setTextSize(12f);

        //传入X轴的值，所以自定义X轴的值可以 写在该方法内
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return dbTyZsNqgb.get((int) value).getYear() + "年";
            }
        });
    }

    /**
     * 设置左侧纵坐标数据
     */
    private void setAxisYLeftNqgb() {
        YAxis leftYAxis = chart_zs_nqgb.getAxisLeft();
        leftYAxis.setAxisMinimum(0f);
        leftYAxis.setTextColor(ContextCompat.getColor(context,R.color.white));
        //但还是显示了网格线，而且不是我们想要的 虚线 。其实那是 X Y轴自己的网格线，禁掉即可

        leftYAxis.setDrawGridLines(true);
        //设置X Y轴网格线为虚线（实体线长度、间隔距离、偏移量：通常使用 0）
        leftYAxis.enableGridDashedLine(10f, 10f, 0f);
    }

    public LineData getLineDataNqgb() {
        LineData lineData = new LineData();
        List<Entry> customCounts = new ArrayList<>();
        //人数
        for (int i = 0; i < dbTyZsNqgb.size(); i++) {
            customCounts.add(new Entry(i, dbTyZsNqgb.get(i).getPrincipal()));
        }
        LineDataSet lineDataSet = new LineDataSet(customCounts, "乡科正职");
        lineDataSet.setColor(Color.rgb(1,183,255));
        lineDataSet.setCircleColor(Color.WHITE);
        lineDataSet.setValueTextColor(Color.WHITE);
        lineDataSet.setValueFormatter(new ZsPercentFormatter());
        lineDataSet.setDrawValues(true);
        lineDataSet.setLineWidth(2f);
        lineDataSet.setCircleRadius(5f);
        //设置曲线值的圆点是实心还是空心
        lineDataSet.setDrawCircleHole(false);
        lineDataSet.setValueTextSize(14f);
        //设置折线图填充
        lineDataSet.setDrawFilled(false);
        lineDataSet.setFormLineWidth(1f);
        lineDataSet.setFormSize(15.f);
        lineDataSet.setMode(LineDataSet.Mode.LINEAR);

        List<Entry> customCounts2 = new ArrayList<>();
        //人数
        for (int i = 0; i < dbTyZsNqgb.size(); i++) {
            customCounts2.add(new Entry(i, dbTyZsNqgb.get(i).getDeputy()));
        }
        LineDataSet lineDataSet2 = new LineDataSet(customCounts2, "乡科副职");
        lineDataSet2.setColor(Color.rgb(213,100,107));
        lineDataSet2.setCircleColor(Color.WHITE);
        lineDataSet2.setValueTextColor(Color.WHITE);
        lineDataSet2.setValueFormatter(new ZsPercentFormatter());
        lineDataSet2.setDrawValues(true);
        lineDataSet2.setLineWidth(2f);
        lineDataSet2.setCircleRadius(5f);
        //设置曲线值的圆点是实心还是空心
        lineDataSet2.setDrawCircleHole(false);
        lineDataSet2.setValueTextSize(14f);
        //设置折线图填充
        lineDataSet2.setDrawFilled(false);
        lineDataSet2.setFormLineWidth(1f);
        lineDataSet2.setFormSize(15.f);
        lineDataSet2.setMode(LineDataSet.Mode.LINEAR);

        lineData.addDataSet(lineDataSet);
        lineData.addDataSet(lineDataSet2);
        return lineData;
    }





    //-------------职数推演 end

    //----------------换届推演界面 start
    TextView btn_swbz, btn_szfbz, btn_srdcwhbz, btn_szxbz;
    PieChart chart_swbz, chart_szfbz, chart_srdcwhbz, chart_szxbz;

    public void initHjtyView() {
        btn_swbz = findViewById(R.id.btn_swbz);
        btn_szfbz = findViewById(R.id.btn_szfbz);
        btn_srdcwhbz = findViewById(R.id.btn_srdcwhbz);
        btn_szxbz = findViewById(R.id.btn_szxbz);
        chart_swbz = findViewById(R.id.chart_swbz);
        chart_szfbz = findViewById(R.id.chart_szfbz);
        chart_srdcwhbz = findViewById(R.id.chart_srdcwhbz);
        chart_szxbz = findViewById(R.id.chart_szxbz);

        btn_swbz.setOnClickListener(this);
        btn_szfbz.setOnClickListener(this);
        btn_srdcwhbz.setOnClickListener(this);
        btn_szxbz.setOnClickListener(this);

    }

    public void setHjtyData() {
        List<PieEntry> entriesSwbz = new ArrayList<>();
        for (int i = 0; i < dbTyHj.getSwbz().size(); i++) {
            ChartBean data = dbTyHj.getSwbz().get(i);
            PieEntry entry = new PieEntry((float) data.getAmount(), data.getName(), data);
            entriesSwbz.add(entry);
        }
        // 设置颜色list，让不同的块显示不同颜色，下面是我觉得不错的颜色集合，比较亮
        ArrayList<Integer> colorsSwbz = new ArrayList<Integer>();
        colorsSwbz.add(Color.rgb(0, 180, 255));
        colorsSwbz.add(Color.rgb(254, 84, 85));
        showHjtyChart(chart_swbz, entriesSwbz, colorsSwbz, "");


        List<PieEntry> entriesSzfbz = new ArrayList<>();
        for (int i = 0; i < dbTyHj.getSzfbz().size(); i++) {
            ChartBean data = dbTyHj.getSzfbz().get(i);
            PieEntry entry = new PieEntry((float) data.getAmount(), data.getName(), data);
            entriesSzfbz.add(entry);
        }
        // 设置颜色list，让不同的块显示不同颜色，下面是我觉得不错的颜色集合，比较亮
        ArrayList<Integer> colorsSzfbz = new ArrayList<Integer>();
        colorsSzfbz.add(Color.rgb(0,180,255));
        colorsSzfbz.add(Color.rgb(254,137,84));
        showHjtyChart(chart_szfbz, entriesSzfbz, colorsSzfbz, "");


        List<PieEntry> entriesSrdcwhbz = new ArrayList<>();
        for (int i = 0; i < dbTyHj.getSrdcwz().size(); i++) {
            ChartBean data = dbTyHj.getSrdcwz().get(i);
            PieEntry entry = new PieEntry((float) data.getAmount(), data.getName(), data);
            entriesSrdcwhbz.add(entry);
        }
        // 设置颜色list，让不同的块显示不同颜色，下面是我觉得不错的颜色集合，比较亮
        ArrayList<Integer> colorsSrdcwhbz = new ArrayList<Integer>();
        colorsSrdcwhbz.add(Color.rgb(0,180,255));
        colorsSrdcwhbz.add(Color.rgb(254,137,84));
        showHjtyChart(chart_srdcwhbz, entriesSrdcwhbz, colorsSrdcwhbz, "");

        List<PieEntry> entriesSzxbz = new ArrayList<>();
        for (int i = 0; i < dbTyHj.getSzxbz().size(); i++) {
            ChartBean data = dbTyHj.getSzxbz().get(i);
            PieEntry entry = new PieEntry((float) data.getAmount(), data.getName(), data);
            entriesSzxbz.add(entry);
        }
        // 设置颜色list，让不同的块显示不同颜色，下面是我觉得不错的颜色集合，比较亮
        ArrayList<Integer> colorsSzxbz = new ArrayList<Integer>();
        colorsSzxbz.add(Color.rgb(0,180,255));
        colorsSzxbz.add(Color.rgb(254,137,84));
        showHjtyChart(chart_szxbz, entriesSzxbz, colorsSzxbz, "");

    }

    private void initHjtyChart(PieChart chart_jg_zzmm, int count) {
        //描述
        Description description = chart_jg_zzmm.getDescription();
        description.setEnabled(false);

        //设置半透明圆环的半径, 0为透明
        chart_jg_zzmm.setTransparentCircleRadius(0f);
        //设置初始旋转角度
        chart_jg_zzmm.setRotationAngle(-15);
        // 和四周相隔一段距离,显示数据
        chart_jg_zzmm.setExtraOffsets(30, 40, 30, 20);

        // 设置pieChart图表是否可以手动旋转
        chart_jg_zzmm.setRotationEnabled(false);
        // 设置piecahrt图表点击Item高亮是否可用
        chart_jg_zzmm.setHighlightPerTapEnabled(true);
        // 设置pieChart图表展示动画效果，动画运行1.4秒结束
//        chart_jg_zzmm.animateY(1400, Easing.EaseInQuad);
        //设置pieChart是否只显示饼图上百分比不显示文字
        chart_jg_zzmm.setDrawEntryLabels(true);
        chart_jg_zzmm.setEntryLabelTextSize(10f);
        //是否绘制PieChart内部中心文本
        chart_jg_zzmm.setDrawCenterText(false);
        // 百分比显示
        chart_jg_zzmm.setUsePercentValues(false);

        // 设置 pieChart 内部圆环属性
        chart_jg_zzmm.setDrawHoleEnabled(true);              //是否显示PieChart内部圆环(true:下面属性才有意义)
        chart_jg_zzmm.setHoleRadius(50f);                    //设置PieChart内部圆的半径(这里设置28.0f)
        chart_jg_zzmm.setTransparentCircleRadius(31f);       //设置PieChart内部透明圆的半径(这里设置31.0f)
        chart_jg_zzmm.setTransparentCircleColor(Color.TRANSPARENT);//设置PieChart内部透明圆与内部圆间距(31f-28f)填充颜色
        chart_jg_zzmm.setTransparentCircleAlpha(50);         //设置PieChart内部透明圆与内部圆间距(31f-28f)透明度[0~255]数值越小越透明
        chart_jg_zzmm.setHoleColor(Color.TRANSPARENT);             //设置PieChart内部圆的颜色
        chart_jg_zzmm.setDrawCenterText(true);               //是否绘制PieChart内部中心文本（true：下面属性才有意义）
        chart_jg_zzmm.setCenterText("总人数\n" + count);                 //设置PieChart内部圆文字的内容
        chart_jg_zzmm.setCenterTextSize(14f);                //设置PieChart内部圆文字的大小
        chart_jg_zzmm.setCenterTextColor(Color.WHITE);         //设置PieChart内部圆文字的颜色

        // 不显示图例
        Legend legend = chart_jg_zzmm.getLegend();
        legend.setEnabled(false);

        MyPieChartRenderer customPieChartRenderer = new MyPieChartRenderer(chart_jg_zzmm, chart_jg_zzmm.getAnimator(),chart_jg_zzmm.getViewPortHandler()); //new 一个类对象
        chart_jg_zzmm.setRenderer(customPieChartRenderer); //设置给piechart。 这里的holder 就是我的pirechart对象

    }

    private void showHjtyChart(PieChart chart_jg_zzmm, List<PieEntry> entries, ArrayList<Integer> colors, String name) {
        // 每一个LineDataSet代表一条线
        PieDataSet pieDataSet = new PieDataSet(entries, name);
        initHjtyDataSet(pieDataSet, colors);
        PieData pieData = new PieData(pieDataSet);
        chart_jg_zzmm.setData(pieData);
    }

    private void initHjtyDataSet(PieDataSet dataSet, ArrayList<Integer> colors) {
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
        dataSet.setValueFormatter(new HjPercentFormatter());
        dataSet.setValueTextSize(14f);
        dataSet.setValueTextColor(Color.WHITE);

        dataSet.setValueLinePart1Length(0.4f);//当值位置为外边线时，表示线的前半段长度。
        dataSet.setValueLinePart2Length(0.4f);//当值位置为外边线时，表示线的后半段长度。

    }


    //----------------环节推演界面 end


    //---------------结构推演界面 start

    TextView tv_jg_nan,tv_gj_nv;
    PieChart chart_jg_zzmm,chart_jg_nljg,chart_jg_mz,chart_jg_xl,chart_jg_zy;
    public void initJgtyView(){
        tv_jg_nan = findViewById(R.id.tv_jg_nan);
        tv_gj_nv = findViewById(R.id.tv_gj_nv);
        chart_jg_zzmm = findViewById(R.id.chart_jg_zzmm);
        chart_jg_nljg = findViewById(R.id.chart_jg_nljg);
        chart_jg_mz = findViewById(R.id.chart_jg_mz);
        chart_jg_xl = findViewById(R.id.chart_jg_xl);
        chart_jg_zy = findViewById(R.id.chart_jg_zy);
    }

    public void setJgtyData(){
        tv_jg_nan.setText(dbTyJg.getSexNan());
        tv_gj_nv.setText(dbTyJg.getSexNv());

        List<PieEntry> entries1 = new ArrayList<>();
        for (int i = 0; i < dbTyJg.getChartBeanOutlookList().size(); i++) {
            ChartBean data = dbTyJg.getChartBeanOutlookList().get(i);
            PieEntry entry = new PieEntry((float) data.getAmount(), data.getName(), data);
            entries1.add(entry);
        }
        // 设置颜色list，让不同的块显示不同颜色，下面是我觉得不错的颜色集合，比较亮
        ArrayList<Integer> colors1 = new ArrayList<Integer>();
        colors1.add(Color.rgb(0,180,255));
        colors1.add(Color.rgb(148,78,254));
        showJgtyChart(chart_jg_zzmm, entries1 , colors1,"");

        List<PieEntry> entries2 = new ArrayList<>();
        for (int i = 0; i < dbTyJg.getChartBeanNation().size(); i++) {
            ChartBean data = dbTyJg.getChartBeanNation().get(i);
            PieEntry entry = new PieEntry((float) data.getAmount(), data.getName(), data);
            entries2.add(entry);
        }
        // 设置颜色list，让不同的块显示不同颜色，下面是我觉得不错的颜色集合，比较亮
        ArrayList<Integer> colors2 = new ArrayList<Integer>();
        colors2.add(Color.rgb(28,103,218));
        colors2.add(Color.rgb(255,211,2));
        showJgtyChart(chart_jg_mz, entries2 , colors2,"");

        List<PieEntry> entries3 = new ArrayList<>();
        for (int i = 0; i < dbTyJg.getChartBeanAgeList().size(); i++) {
            ChartBean data = dbTyJg.getChartBeanAgeList().get(i);
            PieEntry entry = new PieEntry((float) data.getAmount(), data.getName(), data);
            entries3.add(entry);
        }
        // 设置颜色list，让不同的块显示不同颜色，下面是我觉得不错的颜色集合，比较亮
        ArrayList<Integer> colors3 = new ArrayList<Integer>();
        colors3.add(Color.rgb(28,103,218));
        colors3.add(Color.rgb(254,84,85));
        colors3.add(Color.rgb(0,180,255));
        colors3.add(Color.rgb(255,210,2));
        colors3.add(Color.rgb(255,137,85));
        colors3.add(Color.rgb(0,234,203));
        showJgtyChart(chart_jg_nljg, entries3 , colors3,"");

        List<PieEntry> entries4 = new ArrayList<>();
        for (int i = 0; i < dbTyJg.getChartBeanEducationList().size(); i++) {
            ChartBean data = dbTyJg.getChartBeanEducationList().get(i);
            PieEntry entry = new PieEntry((float) data.getNum(), data.getName(), data);
            entries4.add(entry);
        }
        showJgtyChart(chart_jg_xl, entries4 , colors3,"");

        List<PieEntry> entries5 = new ArrayList<>();
        for (int i = 0; i < dbTyJg.getChartBeanMajorList().size(); i++) {
            ChartBean data = dbTyJg.getChartBeanMajorList().get(i);
            PieEntry entry = new PieEntry((float) data.getNum(), data.getName(), data);
            entries5.add(entry);
        }
        showJgtyChart(chart_jg_zy, entries5 , colors3,"");
    }

    private void initJgtyChart(PieChart chart_jg_zzmm) {
        //描述
        Description description = chart_jg_zzmm.getDescription();
        description.setEnabled(false);

        //设置半透明圆环的半径, 0为透明
        chart_jg_zzmm.setTransparentCircleRadius(0f);
        //设置初始旋转角度
        chart_jg_zzmm.setRotationAngle(-15);
        // 和四周相隔一段距离,显示数据
        chart_jg_zzmm.setExtraOffsets(30, 40, 30, 20);

        // 设置pieChart图表是否可以手动旋转
        chart_jg_zzmm.setRotationEnabled(false);
        // 设置piecahrt图表点击Item高亮是否可用
        chart_jg_zzmm.setHighlightPerTapEnabled(true);
        // 设置pieChart图表展示动画效果，动画运行1.4秒结束
//        chart_jg_zzmm.animateY(1400, Easing.EaseInQuad);
        //设置pieChart是否只显示饼图上百分比不显示文字
        chart_jg_zzmm.setDrawEntryLabels(true);
        chart_jg_zzmm.setEntryLabelTextSize(10f);
        //是否绘制PieChart内部中心文本
        chart_jg_zzmm.setDrawCenterText(false);
        // 百分比显示
        chart_jg_zzmm.setUsePercentValues(true);

        // 设置 pieChart 内部圆环属性
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
        l.setEnabled(true);                    //是否启用图列（true：下面属性才有意义）
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setForm(Legend.LegendForm.DEFAULT); //设置图例的形状
        l.setFormSize(10);					  //设置图例的大小
        l.setFormToTextSpace(10f);			  //设置每个图例实体中标签和形状之间的间距
        l.setDrawInside(false);
        l.setWordWrapEnabled(true);			  //设置图列换行(注意使用影响性能,仅适用legend位于图表下面)
        l.setXEntrySpace(10f);				  //设置图例实体之间延X轴的间距（setOrientation = HORIZONTAL有效）
        l.setYEntrySpace(8f);				  //设置图例实体之间延Y轴的间距（setOrientation = VERTICAL 有效）
        l.setYOffset(0f);					  //设置比例块Y轴偏移量
        l.setTextSize(12f);					  //设置图例标签文本的大小
        l.setTextColor(Color.parseColor("#23CEFD"));//设置图例标签文本的颜色

        MyPieChartRenderer customPieChartRenderer = new MyPieChartRenderer(chart_jg_zzmm, chart_jg_zzmm.getAnimator(),chart_jg_zzmm.getViewPortHandler()); //new 一个类对象
        chart_jg_zzmm.setRenderer(customPieChartRenderer); //设置给piechart。 这里的holder 就是我的pirechart对象

    }

    private void showJgtyChart(PieChart chart_jg_zzmm, List<PieEntry> entries, ArrayList<Integer> colors, String name) {
        // 每一个LineDataSet代表一条线
        PieDataSet pieDataSet = new PieDataSet(entries, name);
        initJgtyDataSet(chart_jg_zzmm,pieDataSet,colors);
        PieData pieData = new PieData(pieDataSet);
        chart_jg_zzmm.setData(pieData);
        chart_jg_zzmm.notifyDataSetChanged();
        chart_jg_zzmm.invalidate();
    }

    private void initJgtyDataSet(PieChart chart_jg_zzmm, PieDataSet dataSet, ArrayList<Integer> colors){
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
        dataSet.setValueTextSize(14f);
        dataSet.setValueTextColor(Color.WHITE);

        dataSet.setValueLinePart1Length(0.4f);//当值位置为外边线时，表示线的前半段长度。
        dataSet.setValueLinePart2Length(0.4f);//当值位置为外边线时，表示线的后半段长度。

    }


    //---------------结构推演界面 end


    DBTyHj dbTyHj;

    private void getDbHjTyData() {
        DBTyHjDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBTyHjDao();
        QueryBuilder<DBTyHj> queryBuilder = dbGbBeanDao.queryBuilder();
        if(queryBuilder.count() != 0)
            dbTyHj = queryBuilder.unique();
    }


    DbTyJg dbTyJg;

    private void getDbJgTyData() {
        DbTyJgDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDbTyJgDao();
        QueryBuilder<DbTyJg> queryBuilder = dbGbBeanDao.queryBuilder();
        queryBuilder.where(DbTyJgDao.Properties.DeptId.eq(deptId));
        if(queryBuilder.count() != 0)
            dbTyJg = queryBuilder.unique();
    }


    List<DbTyZs> dbTyZs;
    List<DBTyZsNqgb> dbTyZsNqgb;

    public void getDbZsTyData() {
        DbTyZsDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDbTyZsDao();
        QueryBuilder<DbTyZs> queryBuilder = dbGbBeanDao.queryBuilder();
        dbTyZs = queryBuilder.list();

        DBTyZsNqgbDao dbGbBeanDao2 = DaoManager.getInstance().getDaoSession().getDBTyZsNqgbDao();
        QueryBuilder<DBTyZsNqgb> queryBuilder2 = dbGbBeanDao2.queryBuilder();
        dbTyZsNqgb = queryBuilder2.list();
    }


    //------------------------------父类界面设置
    public void setType(int type) {
        clean();
        if (type == 1) {
            id_ty_zs_layout.setVisibility(View.VISIBLE);
            iv_title_left.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_left));
            tv_title_left.setTextColor(ContextCompat.getColor(context, R.color.white));
        } else if (type == 2) {
            id_ty_jg_layout.setVisibility(View.VISIBLE);
            group_dialog.setVisibility(View.VISIBLE);
            if(TextUtils.equals(this.type,"2")){
                iv_title_center.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_right));
            }else{
                iv_title_center.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_center));
            }
            tv_title_center.setTextColor(ContextCompat.getColor(context, R.color.white));
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

        if(TextUtils.equals(type,"2")){
            iv_title_left.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_left_un));
            iv_title_center.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_right_un));
            group_title_right.setVisibility(View.GONE);
            tv_title_center.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);

        }else{
            iv_title_left.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_left_un));
            iv_title_center.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_center_un));
            iv_title_right.setBackground(ContextCompat.getDrawable(context, R.mipmap.ic_tab_right_un));
        }

        tv_title_left.setTextColor(ContextCompat.getColor(context, R.color.color_23cffd));
        tv_title_center.setTextColor(ContextCompat.getColor(context, R.color.color_23cffd));
        tv_title_right.setTextColor(ContextCompat.getColor(context, R.color.color_23cffd));

        group_dialog.setVisibility(View.GONE);
    }


    //------------------------点击事件
    ListDialog2 listDialog;

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
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
            case R.id.btn_swbz:
                intent.putExtra("title","符合市委班子提名条件人选");
                intent.putExtra("type",0);
                intent.setClass(context,TyListActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_szfbz:
                intent.putExtra("title","符合市政府班子提名条件人选");
                intent.putExtra("type",1);
                intent.setClass(context,TyListActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_srdcwhbz:
                intent.putExtra("title","符合市人大常委会班子提名条件人选");
                intent.putExtra("type",2);
                intent.setClass(context,TyListActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_szxbz:
                intent.putExtra("title","符合市政协班子提名条件人选");
                intent.putExtra("type",3);
                intent.setClass(context,TyListActivity.class);
                startActivity(intent);
                break;

        }
    }


    //----------------------------Dialog

    List<DBBmBean> dbBmList;
    CommonDaoUtils<DBBmBean> dBBmDaoUtils;

    public List<DBBmBean> getDbBmList(String key) {
        dbBmList = new ArrayList<>();
        if(TextUtils.isEmpty(key)){
            dbBmList = dBBmDaoUtils.queryAll();
            LogUtil.e("数据库条数：" + dbBmList.size());
            bmLeftBeans2 = dialogBmData.getBmLeftBean(dbBmList);
        }else{
            String sql = "where DEPT_NAME like ?";
            String[] condition = new String[]{"%" + key + "%"};
            dbBmList = dBBmDaoUtils.queryByNativeSql(sql, condition);
            bmLeftBeans2 = dialogBmData.getBmLeftBean2(dbBmList);
        }
        return dbBmList;
    }

//    public void setBmLeftBean() {
//        List<BmLeftBean> bmLeftBeans = new ArrayList<>();
//        for (int i = 0; i < dbBmList.size(); i++) {
//            DBBmBean dbItem = dbBmList.get(i);
//            BmLeftBean item = new BmLeftBean(dbItem.getDeptId(), dbItem.getParentId(), dbItem.getDeptName(), dbItem.getDeptType());
//            bmLeftBeans.add(item);
//        }
//
//        List<BmLeftBean> rootTrees = new ArrayList<BmLeftBean>();
//        for (BmLeftBean tree : bmLeftBeans) {
//            if (tree.getParentId() == 0) {
//                rootTrees.add(tree);
//            }
//            for (BmLeftBean t : bmLeftBeans) {
//                if (t.getParentId() == tree.getId()) {
//                    if (tree.getLists() == null) {
//                        List<BmLeftBean> myChildrens = new ArrayList<BmLeftBean>();
//                        myChildrens.add(t);
//                        tree.setLists(myChildrens);
//                    } else {
//                        tree.getLists().add(t);
//                    }
//                }
//            }
//        }
//        this.bmLeftBeans = new ArrayList<>();
//        sysout(rootTrees, "");
//    }
//
//    List<BmLeftBean> bmLeftBeans = new ArrayList<BmLeftBean>();
//
//    public void sysout(List<BmLeftBean> trees, String str) {
//        if (trees != null && trees.size() > 0) {
//            for (BmLeftBean tree : trees) {
//                tree.setName(str + tree.getName());
//                bmLeftBeans.add(tree);
//                sysout(tree.getLists(), str + "   ");
//            }
//        }
//    }
//
//    public void setBmLeftBean2(){
//        bmLeftBeans = new ArrayList<>();
//        for (int i = 0; i < dbBmList.size(); i++) {
//            DBBmBean dbItem = dbBmList.get(i);
//            BmLeftBean item = new BmLeftBean(dbItem.getDeptId(), dbItem.getParentId(), dbItem.getDeptName(),dbItem.getDeptType());
//            bmLeftBeans.add(item);
//        }
//    }

}
