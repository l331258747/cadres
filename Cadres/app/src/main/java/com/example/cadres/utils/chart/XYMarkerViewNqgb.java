package com.example.cadres.utils.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cadres.R;
import com.example.cadres.beanDB.DBTyZsNqgb;
import com.example.cadres.beanDB.DbTyZs;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.List;

public class XYMarkerViewNqgb extends MarkerView {
    public static final int ARROW_SIZE = 40; // 箭头的大小
    private static final float CIRCLE_OFFSET = 10;//因为我这里的折点是圆圈，所以要偏移，防止直接指向了圆心
    private static final float STOKE_WIDTH = 5;//这里对于stroke_width的宽度也要做一定偏移
    private LinearLayout ll_cprs_xkjzz,ll_cprs_xkjfz,ll_gb;
    private TextView tv_cprs_xkjzz,tv_cprs_xkjfz,tv_gb;
    private List<DBTyZsNqgb> stepListModels;
    private int index;
    private int oldIndex = -1;

    Context context;

    public XYMarkerViewNqgb(Context context, List<DBTyZsNqgb> stepListModels) {
        super(context, R.layout.custom_marker_view_nqgb);
        this.context = context;
        ll_cprs_xkjzz = (LinearLayout) findViewById(R.id.ll_cprs_xkjzz);//
        ll_cprs_xkjfz = (LinearLayout) findViewById(R.id.ll_cprs_xkjfz);//
        ll_gb = (LinearLayout) findViewById(R.id.ll_gb);//
        tv_cprs_xkjzz = (TextView) findViewById(R.id.tv_cprs_xkjzz);//
        tv_cprs_xkjfz = (TextView) findViewById(R.id.tv_cprs_xkjfz);//
        tv_gb = (TextView) findViewById(R.id.tv_gb);//
        this.stepListModels = stepListModels;
    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        index = (int)highlight.getX();//这个方法用于获得折线是哪根
        DBTyZsNqgb stepListModel = stepListModels.get(index);

        ll_cprs_xkjzz.setVisibility(GONE);
        ll_cprs_xkjfz.setVisibility(GONE);
        ll_gb.setVisibility(GONE);

        if(stepListModel.getPrincipal() != 0){
            ll_cprs_xkjzz.setVisibility(VISIBLE);
            tv_cprs_xkjzz.setText(stepListModel.getPrincipal() + "人");
        }
        if(stepListModel.getDeputy() != 0){
            ll_cprs_xkjfz.setVisibility(VISIBLE);
            tv_cprs_xkjfz.setText(stepListModel.getDeputy() + "人");
        }
        if(stepListModel.getJlh() != 0){
            ll_gb.setVisibility(VISIBLE);
            tv_gb.setText(stepListModel.getJlh() + "人");
        }
        super.refreshContent(e, highlight);
    }

    @Override
    public MPPointF getOffsetForDrawingAtPoint(float posX, float posY) {
        MPPointF offset = getOffset();
        Chart chart = getChartView();
        float width = getWidth();
        float height = getHeight();
// posY \posX 指的是markerView左上角点在图表上面的位置
//处理Y方向
        if (posY <= height + ARROW_SIZE) {// 如果点y坐标小于markerView的高度，如果不处理会超出上边界，处理了之后这时候箭头是向上的，我们需要把图标下移一个箭头的大小
            offset.y = ARROW_SIZE;
        } else {//否则属于正常情况，因为我们默认是箭头朝下，然后正常偏移就是，需要向上偏移markerView高度和arrow size，再加一个stroke的宽度，因为你需要看到对话框的上面的边框
            offset.y = -height - ARROW_SIZE - STOKE_WIDTH; // 40 arrow height   5 stroke width
        }
//处理X方向，分为3种情况，1、在图表左边 2、在图表中间 3、在图表右边
//
        if (posX > chart.getWidth() - width) {//如果超过右边界，则向左偏移markerView的宽度
            offset.x = -width;
        } else {//默认情况，不偏移（因为是点是在左上角）
            offset.x = 0;
            if (posX > width / 2) {//如果大于markerView的一半，说明箭头在中间，所以向右偏移一半宽度
                offset.x = -(width / 2);
            }
        }
        return offset;
    }

    @Override
    public void draw(Canvas canvas, float posX, float posY) {


        Chart chart = getChartView();
        float width = getWidth();
        float height = getHeight();

        MPPointF offset = getOffsetForDrawingAtPoint(posX, posY);
        int saveId = canvas.save();

        Path path = new Path();
        if (posY < height + ARROW_SIZE) {//处理超过上边界
            path = new Path();
            path.moveTo(0, 0);
            if (posX > chart.getWidth() - width) {//超过右边界
                path.lineTo(width - ARROW_SIZE, 0);
                path.lineTo(width, -ARROW_SIZE + CIRCLE_OFFSET);
                path.lineTo(width, 0);
            } else {
                if (posX > width / 2) {//在图表中间
                    path.lineTo(width / 2 - ARROW_SIZE / 2, 0);
                    path.lineTo(width / 2, -ARROW_SIZE + CIRCLE_OFFSET);
                    path.lineTo(width / 2 + ARROW_SIZE / 2, 0);
                } else {//超过左边界
                    path.lineTo(0, -ARROW_SIZE + CIRCLE_OFFSET);
                    path.lineTo(0 + ARROW_SIZE, 0);
                }
            }
            path.lineTo(0 + width, 0);
            path.lineTo(0 + width, 0 + height);
            path.lineTo(0, 0 + height);
            path.lineTo(0, 0);
            path.offset(posX + offset.x, posY + offset.y);
        } else {//没有超过上边界
            path = new Path();
            path.moveTo(0, 0);
            path.lineTo(0 + width, 0);
            path.lineTo(0 + width, 0 + height);
            if (posX > chart.getWidth() - width) {
                path.lineTo(width, height + ARROW_SIZE - CIRCLE_OFFSET);
                path.lineTo(width - ARROW_SIZE, 0 + height);
                path.lineTo(0, 0 + height);
            } else {
                if (posX > width / 2) {
                    path.lineTo(width / 2 + ARROW_SIZE / 2, 0 + height);
                    path.lineTo(width / 2, height + ARROW_SIZE - CIRCLE_OFFSET);
                    path.lineTo(width / 2 - ARROW_SIZE / 2, 0 + height);
                    path.lineTo(0, 0 + height);
                } else {
                    path.lineTo(0 + ARROW_SIZE, 0 + height);
                    path.lineTo(0, height + ARROW_SIZE - CIRCLE_OFFSET);
                    path.lineTo(0, 0 + height);
                }
            }
            path.lineTo(0, 0);
            path.offset(posX + offset.x, posY + offset.y);
        }

        // translate to the correct position and draw
        canvas.translate(posX + offset.x, posY + offset.y);
        draw(canvas);
        canvas.restoreToCount(saveId);
    }
}