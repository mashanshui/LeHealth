package com.shenhesoft.lehealth.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.shenhesoft.lehealth.R;
import com.shenhesoft.lehealth.data.model.HealthData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.droidlover.xdroidmvp.mvp.XActivity;
import cn.droidlover.xdroidmvp.mvp.XTitleActivity;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class DataAnalyzeActivity extends XTitleActivity {
    private static final String TAG = "DataAnalyzeActivity";
    @BindView(R.id.chart_blood)
    LineChartView chartBlood;
    @BindView(R.id.chart_heat)
    LineChartView chartHeat;
    @BindView(R.id.chart_pulse)
    LineChartView chartPulse;

    private List<HealthData> healthData;
    private List<PointValue> mPointValues1 = new ArrayList<PointValue>();
    private List<AxisValue> mAxisXValues1 = new ArrayList<AxisValue>();

    private List<PointValue> mPointValues2 = new ArrayList<PointValue>();
    private List<AxisValue> mAxisXValues2 = new ArrayList<AxisValue>();

    private List<PointValue> mPointValues3 = new ArrayList<PointValue>();
    private List<AxisValue> mAxisXValues3 = new ArrayList<AxisValue>();

    List<Float> score1 = new ArrayList<>();//图表的数据点
    List<Float> score2 = new ArrayList<>();//图表的数据点
    List<Float> score3 = new ArrayList<>();//图表的数据点


    @Override
    public void initData(Bundle savedInstanceState) {
        healthData = (List<HealthData>) getIntent().getSerializableExtra("data");
        score1.add(0f);
        for (HealthData healthDatum : healthData) {
            Log.e(TAG, "initData: " + Float.valueOf(healthDatum.getBlood()));
            score1.add(Float.valueOf(healthDatum.getBlood()));
        }
        addAxisXLables1();
        addAxisPoints1();
        initbloodChart();

        score2.add(0f);
        for (HealthData healthDatum : healthData) {
            Log.e(TAG, "initData: " + Float.valueOf(healthDatum.getHeat()));
            score2.add(Float.valueOf(healthDatum.getHeat()));
        }
        addAxisXLables2();
        addAxisPoints2();
        initheatChart();

        score3.add(0f);
        for (HealthData healthDatum : healthData) {
            Log.e(TAG, "initData: "+Float.valueOf(healthDatum.getPulse()) );
            score3.add(Float.valueOf(healthDatum.getPulse()));
        }
        addAxisPoints3();
        addAxisXLables3();
        initpulseChart();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_data_analyze;
    }

    @Override
    public Object newP() {
        return null;
    }

    @Override
    protected void initTitle() {
        setTitle("数据分析");
        setBackAction();
    }

    /**
     * X 轴的显示
     */
    private void addAxisXLables1() {
        if (!mAxisXValues1.isEmpty()) {
            mAxisXValues1.clear();
        }
        for (int i = 0; i < score1.size(); i++) {
            mAxisXValues1.add(new AxisValue(i).setLabel(String.valueOf(i)));
        }
    }

    /**
     * 图表的每个点的显示
     */
    private void addAxisPoints1() {
        if (!mPointValues1.isEmpty()) {
            mPointValues1.clear();
        }
        for (int i = 0; i < score1.size(); i++) {
            mPointValues1.add(new PointValue(i, score1.get(i)));
        }
    }

    /**
     * X 轴的显示
     */
    private void addAxisXLables2() {
        if (!mAxisXValues2.isEmpty()) {
            mAxisXValues2.clear();
        }
        for (int i = 0; i < score2.size(); i++) {
            mAxisXValues2.add(new AxisValue(i).setLabel(String.valueOf(i)));
        }
    }

    /**
     * 图表的每个点的显示
     */
    private void addAxisPoints2() {
        if (!mPointValues2.isEmpty()) {
            mPointValues2.clear();
        }
        for (int i = 0; i < score2.size(); i++) {
            mPointValues2.add(new PointValue(i, score2.get(i)));
        }
    }

    /**
     * X 轴的显示
     */
    private void addAxisXLables3() {
        if (!mAxisXValues3.isEmpty()) {
            mAxisXValues3.clear();
        }
        for (int i = 0; i < score3.size(); i++) {
            mAxisXValues3.add(new AxisValue(i).setLabel(String.valueOf(i)));
        }
    }

    /**
     * 图表的每个点的显示
     */
    private void addAxisPoints3() {
        if (!mPointValues3.isEmpty()) {
            mPointValues3.clear();
        }
        for (int i = 0; i < score3.size(); i++) {
            mPointValues3.add(new PointValue(i, score3.get(i)));
        }
    }


    /**
     * 初始化LineChart的一些设置
     */
    private void initbloodChart() {
        Line line = new Line(mPointValues1).setColor(Color.parseColor("#FFCD41"));  //折线的颜色
        List<Line> lines = new ArrayList<Line>();
        line.setShape(ValueShape.CIRCLE);//折线图上每个数据点的形状  这里是圆形 （有三种 ：ValueShape.SQUARE  ValueShape.CIRCLE  ValueShape.SQUARE）
        line.setCubic(false);//曲线是否平滑
//	    line.setStrokeWidth(3);//线条的粗细，默认是3
        line.setFilled(false);//是否填充曲线的面积
        line.setHasLabels(false);//曲线的数据坐标是否加上备注
//		line.setHasLabelsOnlyForSelected(true);//点击数据坐标提示数据（设置了这个line.setHasLabels(true);就无效）
        line.setHasLines(true);//是否用直线显示。如果为false 则没有曲线只有点显示
        line.setHasPoints(true);//是否显示圆点 如果为false 则没有原点只有点显示
        lines.add(line);
        LineChartData data = new LineChartData();
        data.setLines(lines);

        //坐标轴
        Axis axisX = new Axis(); //X轴
        axisX.setName("采集次数");
        axisX.setHasTiltedLabels(true);  //X轴下面坐标轴字体是斜的显示还是直的，true是斜的显示
//	    axisX.setTextColor(Color.WHITE);  //设置字体颜色
        axisX.setTextColor(Color.parseColor("#D6D6D9"));//灰色

//	    axisX.setName("未来几天的天气");  //表格名称
        axisX.setTextSize(11);//设置字体大小
        axisX.setMaxLabelChars(7); //最多几个X轴坐标，意思就是你的缩放让X轴上数据的个数7<=x<=mAxisValues.length
        axisX.setValues(mAxisXValues1);  //填充X轴的坐标名称
        data.setAxisXBottom(axisX); //x 轴在底部
//	    data.setAxisXTop(axisX);  //x 轴在顶部
        axisX.setHasLines(true); //x 轴分割线

        Axis axisY = new Axis();  //Y轴
        axisY.setName("血压");//y轴标注
        axisY.setTextSize(11);//设置字体大小
        data.setAxisYLeft(axisY);  //Y轴设置在左边
        //data.setAxisYRight(axisY);  //y轴设置在右边
        //设置行为属性，支持缩放、滑动以及平移
        chartBlood.setInteractive(true);
        chartBlood.setZoomType(ZoomType.HORIZONTAL);  //缩放类型，水平
        chartBlood.setMaxZoom((float) 3);//缩放比例
        chartBlood.setLineChartData(data);
        chartBlood.setVisibility(View.VISIBLE);
        Viewport v = new Viewport(chartBlood.getMaximumViewport());
        v.left = 0;
        v.right = 7;
        chartBlood.setCurrentViewport(v);
    }

    /**
     * 初始化LineChart的一些设置
     */
    private void initheatChart() {
        Line line = new Line(mPointValues2).setColor(Color.parseColor("#FFCD41"));  //折线的颜色
        List<Line> lines = new ArrayList<Line>();
        line.setShape(ValueShape.CIRCLE);//折线图上每个数据点的形状  这里是圆形 （有三种 ：ValueShape.SQUARE  ValueShape.CIRCLE  ValueShape.SQUARE）
        line.setCubic(false);//曲线是否平滑
//	    line.setStrokeWidth(3);//线条的粗细，默认是3
        line.setFilled(false);//是否填充曲线的面积
        line.setHasLabels(false);//曲线的数据坐标是否加上备注
//		line.setHasLabelsOnlyForSelected(true);//点击数据坐标提示数据（设置了这个line.setHasLabels(true);就无效）
        line.setHasLines(true);//是否用直线显示。如果为false 则没有曲线只有点显示
        line.setHasPoints(true);//是否显示圆点 如果为false 则没有原点只有点显示
        lines.add(line);
        LineChartData data = new LineChartData();
        data.setLines(lines);

        //坐标轴
        Axis axisX = new Axis(); //X轴
        axisX.setName("采集次数");
        axisX.setHasTiltedLabels(true);  //X轴下面坐标轴字体是斜的显示还是直的，true是斜的显示
//	    axisX.setTextColor(Color.WHITE);  //设置字体颜色
        axisX.setTextColor(Color.parseColor("#D6D6D9"));//灰色

//	    axisX.setName("未来几天的天气");  //表格名称
        axisX.setTextSize(11);//设置字体大小
        axisX.setMaxLabelChars(7); //最多几个X轴坐标，意思就是你的缩放让X轴上数据的个数7<=x<=mAxisValues.length
        axisX.setValues(mAxisXValues2);  //填充X轴的坐标名称
        data.setAxisXBottom(axisX); //x 轴在底部
//	    data.setAxisXTop(axisX);  //x 轴在顶部
        axisX.setHasLines(true); //x 轴分割线

        Axis axisY = new Axis();  //Y轴
        axisY.setName("体温");
        axisY.setTextSize(11);//设置字体大小
        data.setAxisYLeft(axisY);  //Y轴设置在左边
        //data.setAxisYRight(axisY);  //y轴设置在右边
        //设置行为属性，支持缩放、滑动以及平移
        chartHeat.setInteractive(true);
        chartHeat.setZoomType(ZoomType.HORIZONTAL);  //缩放类型，水平
        chartHeat.setMaxZoom((float) 3);//缩放比例
        chartHeat.setLineChartData(data);
        chartHeat.setVisibility(View.VISIBLE);
        Viewport v = new Viewport(chartHeat.getMaximumViewport());
        v.left = 0;
        v.right = 7;
        chartHeat.setCurrentViewport(v);

    }

    /**
     * 初始化LineChart的一些设置
     */
    private void initpulseChart() {
        Line line = new Line(mPointValues3).setColor(Color.parseColor("#FFCD41"));  //折线的颜色
        List<Line> lines = new ArrayList<Line>();
        line.setShape(ValueShape.CIRCLE);//折线图上每个数据点的形状  这里是圆形 （有三种 ：ValueShape.SQUARE  ValueShape.CIRCLE  ValueShape.SQUARE）
        line.setCubic(false);//曲线是否平滑
//	    line.setStrokeWidth(3);//线条的粗细，默认是3
        line.setFilled(false);//是否填充曲线的面积
        line.setHasLabels(false);//曲线的数据坐标是否加上备注
//		line.setHasLabelsOnlyForSelected(true);//点击数据坐标提示数据（设置了这个line.setHasLabels(true);就无效）
        line.setHasLines(true);//是否用直线显示。如果为false 则没有曲线只有点显示
        line.setHasPoints(true);//是否显示圆点 如果为false 则没有原点只有点显示
        lines.add(line);
        LineChartData data = new LineChartData();
        data.setLines(lines);

        //坐标轴
        Axis axisX = new Axis(); //X轴
        axisX.setName("采集次数");
        axisX.setHasTiltedLabels(true);  //X轴下面坐标轴字体是斜的显示还是直的，true是斜的显示
//	    axisX.setTextColor(Color.WHITE);  //设置字体颜色
        axisX.setTextColor(Color.parseColor("#D6D6D9"));//灰色

//	    axisX.setName("未来几天的天气");  //表格名称
        axisX.setTextSize(11);//设置字体大小
        axisX.setMaxLabelChars(7); //最多几个X轴坐标，意思就是你的缩放让X轴上数据的个数7<=x<=mAxisValues.length
        axisX.setValues(mAxisXValues3);  //填充X轴的坐标名称
        data.setAxisXBottom(axisX); //x 轴在底部
//	    data.setAxisXTop(axisX);  //x 轴在顶部
        axisX.setHasLines(true); //x 轴分割线

        Axis axisY = new Axis();  //Y轴
        axisY.setName("脉搏");
        axisY.setTextSize(11);//设置字体大小
        data.setAxisYLeft(axisY);  //Y轴设置在左边
        //data.setAxisYRight(axisY);  //y轴设置在右边
        //设置行为属性，支持缩放、滑动以及平移
        chartPulse.setInteractive(true);
        chartPulse.setZoomType(ZoomType.HORIZONTAL);  //缩放类型，水平
        chartPulse.setMaxZoom((float) 3);//缩放比例
        chartPulse.setLineChartData(data);
        chartPulse.setVisibility(View.VISIBLE);
        Viewport v = new Viewport(chartPulse.getMaximumViewport());
        v.left = 0;
        v.right = 7;
        chartPulse.setCurrentViewport(v);
    }


}
