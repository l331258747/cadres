package com.example.cadres.view.dsjty;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.cadres.greendao.gen.DBTyZsNqgbDao;
import com.cadres.greendao.gen.DbTyZsDao;
import com.example.cadres.R;
import com.example.cadres.base.BaseFragment;
import com.example.cadres.beanDB.DBTyZsNqgb;
import com.example.cadres.beanDB.DbTyZs;
import com.example.cadres.utils.LogUtil;
import com.example.cadres.utils.chart.XYMarkerView;
import com.example.cadres.utils.chart.ZsPercentFormatter;
import com.example.cadres.utils.greendao.DaoManager;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class DsjtyZjFragment extends BaseFragment {

    String type;

    public static Fragment newInstance(String type) {
        DsjtyZjFragment fragment = new DsjtyZjFragment();
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
        return R.layout.item_ty_zsty;
    }

    @Override
    public void initView() {
        initZstyView();

    }

    @Override
    public void initData() {
        getDbZsTyData();

        if(dbTyZs != null){
            setZstyData();
        }
        if(dbTyZsNqgb != null){
            setZstyNqgbData();
        }
    }


    //-------------职级推演 start
    CombinedChart chart_zs;
    LineChart chart_zs_nqgb;
    Group group_zs_nqgb;
    private CombinedData data;

    public void initZstyView() {
        chart_zs = $(R.id.chart_zs);
        chart_zs_nqgb = $(R.id.chart_zs_nqgb);
        group_zs_nqgb = $(R.id.group_zs_nqgb);
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

        XYMarkerView mv = new XYMarkerView(context, dbTyZs);
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






    //------------------------年轻干部 职级推演图
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
//        List<Entry> customCounts = new ArrayList<>();
//        //人数
//        for (int i = 0; i < dbTyZsNqgb.size(); i++) {
//            customCounts.add(new Entry(i, dbTyZsNqgb.get(i).getPrincipal()));
//        }
//        LineDataSet lineDataSet = new LineDataSet(customCounts, "乡科正职");
//        lineDataSet.setColor(Color.rgb(1,183,255));
//        lineDataSet.setCircleColor(Color.WHITE);
//        lineDataSet.setValueTextColor(Color.WHITE);
//        lineDataSet.setValueFormatter(new ZsPercentFormatter());
//        lineDataSet.setDrawValues(true);
//        lineDataSet.setLineWidth(2f);
//        lineDataSet.setCircleRadius(5f);
//        //设置曲线值的圆点是实心还是空心
//        lineDataSet.setDrawCircleHole(false);
//        lineDataSet.setValueTextSize(14f);
//        //设置折线图填充
//        lineDataSet.setDrawFilled(false);
//        lineDataSet.setFormLineWidth(1f);
//        lineDataSet.setFormSize(15.f);
//        lineDataSet.setMode(LineDataSet.Mode.LINEAR);

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

//        lineData.addDataSet(lineDataSet);
        lineData.addDataSet(lineDataSet2);
        return lineData;
    }

    //-------------职级推演 end


    List<DbTyZs> dbTyZs;
    List<DBTyZsNqgb> dbTyZsNqgb;

    public void getDbZsTyData() {
        DbTyZsDao dbGbBeanDao = DaoManager.getInstance().getDaoSession().getDbTyZsDao();
        QueryBuilder<DbTyZs> queryBuilder = dbGbBeanDao.queryBuilder();
        if(TextUtils.equals(type,"1")){
            queryBuilder.where(DbTyZsDao.Properties.IsGwy.eq("false"));
        }else{
            queryBuilder.where(DbTyZsDao.Properties.IsGwy.eq("true"));
        }
        dbTyZs = queryBuilder.list();

        LogUtil.e("数据库条数：" + dbTyZs.size());

        DBTyZsNqgbDao dbGbBeanDao2 = DaoManager.getInstance().getDaoSession().getDBTyZsNqgbDao();
        QueryBuilder<DBTyZsNqgb> queryBuilder2 = dbGbBeanDao2.queryBuilder();
        dbTyZsNqgb = queryBuilder2.list();
    }
}
