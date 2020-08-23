package com.example.cadres.view.dsjty;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cadres.greendao.gen.DBTyHjDao;
import com.example.cadres.R;
import com.example.cadres.base.BaseFragment;
import com.example.cadres.bean.ChartBean;
import com.example.cadres.beanDB.DBTyHj;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.chart.HjPercentFormatter;
import com.example.cadres.utils.chart.MyPieChartRenderer;
import com.example.cadres.utils.greendao.DaoManager;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DsjtyHjFragment extends BaseFragment implements View.OnClickListener {
    String type;

    public static Fragment newInstance(String type) {
        DsjtyHjFragment fragment = new DsjtyHjFragment();
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
        return R.layout.item_ty_swbz;
    }

    @Override
    public void initView() {
        initHjtyView();
    }

    @Override
    public void initData() {
        getDbHjTyData();

        if(dbTyHj != null){
            initHjtyChart(chart_swbz, dbTyHj.getSwbzcount());
            initHjtyChart(chart_szfbz, dbTyHj.getSzfbzcount());
            initHjtyChart(chart_srdcwhbz, dbTyHj.getSrdbzcount());
            initHjtyChart(chart_szxbz, dbTyHj.getSzxzcount());
            setHjtyData();
        }
    }

    //----------------换届推演界面 start
    TextView btn_swbz, btn_szfbz, btn_srdcwhbz, btn_szxbz;
    PieChart chart_swbz, chart_szfbz, chart_srdcwhbz, chart_szxbz;

    public void initHjtyView() {
        btn_swbz = $(R.id.btn_swbz);
        btn_szfbz = $(R.id.btn_szfbz);
        btn_srdcwhbz = $(R.id.btn_srdcwhbz);
        btn_szxbz = $(R.id.btn_szxbz);
        chart_swbz = $(R.id.chart_swbz);
        chart_szfbz = $(R.id.chart_szfbz);
        chart_srdcwhbz = $(R.id.chart_srdcwhbz);
        chart_szxbz = $(R.id.chart_szxbz);

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
        colorsSrdcwhbz.add(Color.rgb(254, 84, 85));
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


    DBTyHj dbTyHj;

    private void getDbHjTyData() {
        DBTyHjDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDBTyHjDao();
        QueryBuilder<DBTyHj> queryBuilder = dbGbBeanDao.queryBuilder();
        if(queryBuilder.count() != 0)
            dbTyHj = queryBuilder.unique();

        LogUtil.e("数据库条数：" + dbTyHj != null? "有" : "无");
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.btn_swbz:
                intent.putExtra("tyTitle","符合市委班子提名条件人选");
                intent.putExtra("tyType",0);
                intent.setClass(context,TyListActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_szfbz:
                intent.putExtra("tyTitle","符合市政府班子提名条件人选");
                intent.putExtra("tyType",1);
                intent.setClass(context,TyListActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_srdcwhbz:
                intent.putExtra("tyTitle","符合市人大常委会班子提名条件人选");
                intent.putExtra("tyType",2);
                intent.setClass(context,TyListActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_szxbz:
                intent.putExtra("tyTitle","符合市政协班子提名条件人选");
                intent.putExtra("tyType",3);
                intent.setClass(context,TyListActivity.class);
                startActivity(intent);
                break;
        }
    }
}
