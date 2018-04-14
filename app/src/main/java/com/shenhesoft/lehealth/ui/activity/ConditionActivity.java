package com.shenhesoft.lehealth.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.shenhesoft.lehealth.R;
import com.shenhesoft.lehealth.present.ConditionPresent;
import com.shenhesoft.lehealth.view.ConditionView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
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

public class ConditionActivity extends XTitleActivity<ConditionPresent> implements View.OnClickListener,ConditionView {
    private static final String TAG = "ConditionActivity";
    @BindView(R.id.chart)
    LineChartView lineChart;
    @BindView(R.id.btn_message)
    Button btnMessage;
    @BindView(R.id.et_boold)
    EditText etBoold;
    @BindView(R.id.tv_measure)
    TextView tvMeasure;
    @BindView(R.id.btn_add_data)
    Button btnAddData;

    private static int type;
    private List<PointValue> mPointValues = new ArrayList<PointValue>();
    private List<AxisValue> mAxisXValues = new ArrayList<AxisValue>();
    //    List<String> date = new ArrayList<>();//X轴的标注
    List<Float> score = new ArrayList<>();//图表的数据点

    @Override
    protected void initTitle() {
        if (type == 0) {
            setTitle("血压");
        } else if (type == 1) {
            setTitle("体温");
        } else if (type == 2) {
            setTitle("脉搏");
        }
        setBackAction();
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        type = getIntent().getIntExtra("type", 0);
        setMeasureType();
        btnAddData.setOnClickListener(this);
        score.add(0f);
        addAxisXLables();//获取x轴的标注
        addAxisPoints();//获取坐标点
        initLineChart();//初始化
    }

    private void setMeasureType() {
        if (type == 0) {
            etBoold.setHint("请输入您的血压");
            tvMeasure.setText("mmHg");
        } else if (type == 1) {
            etBoold.setHint("请输入您的体温");
            tvMeasure.setText("℃");
        } else if (type == 2) {
            etBoold.setHint("请输入您的脉搏");
            tvMeasure.setText("次/分");
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_condition;
    }

    @Override
    public ConditionPresent newP() {
        return new ConditionPresent();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_data:
                addData(etBoold.getText().toString().trim());
                break;
            default:
                break;
        }
    }

    private void addData(String data) {
        if (TextUtils.isEmpty(data)) {
            return;
        }
        checkIsNormal(data);
        score.add(Float.valueOf(data));
        addAxisPoints();
        addAxisXLables();
        initLineChart();
    }


    protected void checkIsNormal(String data) {
        float num = Float.valueOf(data);
        if (type == 0) {
            if (num < 90) {
                btnMessage.setText("您的血压偏低");
            } else if (90 < num && num < 140) {
                btnMessage.setText("您的血压正常");
            } else {
                btnMessage.setText("您的血压偏高");
            }
        } else if (type == 1) {
            if (num < 36.3) {
                btnMessage.setText("您的体温偏低");
            } else if (36.3 < num && num < 37.2) {
                btnMessage.setText("您的体温正常");
            } else {
                btnMessage.setText("您的体温偏高");
            }
        } else if (type == 2) {
            if (num < 60) {
                btnMessage.setText("您的脉搏很慢");
            } else if (60 < num && num < 100) {
                btnMessage.setText("您的脉搏正常");
            } else {
                btnMessage.setText("您的脉搏很快");
            }
        }
    }

    /**
     * X 轴的显示
     */
    protected void addAxisXLables() {
        if (!mAxisXValues.isEmpty()) {
            mAxisXValues.clear();
        }
        for (int i = 0; i < score.size(); i++) {
            mAxisXValues.add(new AxisValue(i).setLabel(String.valueOf(i)));
        }
    }

    /**
     * 图表的每个点的显示
     */
    protected void addAxisPoints() {
        if (!mPointValues.isEmpty()) {
            mPointValues.clear();
        }
        for (int i = 0; i < score.size(); i++) {
            Log.e(TAG, "addAxisPoints: "+score.get(i) );
            mPointValues.add(new PointValue(i, score.get(i)));
        }
    }


    /**
     * 初始化LineChart的一些设置
     */
    protected void initLineChart() {
        Line line = new Line(mPointValues).setColor(Color.parseColor("#FFCD41"));  //折线的颜色
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
        axisX.setValues(mAxisXValues);  //填充X轴的坐标名称
        data.setAxisXBottom(axisX); //x 轴在底部
//	    data.setAxisXTop(axisX);  //x 轴在顶部
        axisX.setHasLines(true); //x 轴分割线

        Axis axisY = new Axis();  //Y轴
        if (type == 0) {
            axisY.setName("血压");//y轴标注
        } else if (type == 1) {
            axisY.setName("体温");
        } else if (type == 2) {
            axisY.setName("脉搏");
        }
        axisY.setTextSize(11);//设置字体大小
        data.setAxisYLeft(axisY);  //Y轴设置在左边
        //data.setAxisYRight(axisY);  //y轴设置在右边
        //设置行为属性，支持缩放、滑动以及平移
        lineChart.setInteractive(true);
        lineChart.setZoomType(ZoomType.HORIZONTAL);  //缩放类型，水平
        lineChart.setMaxZoom((float) 3);//缩放比例
        lineChart.setLineChartData(data);
        lineChart.setVisibility(View.VISIBLE);
        /**注：下面的7，10只是代表一个数字去类比而已
         * 尼玛搞的老子好辛苦！！！见（http://forum.xda-developers.com/tools/programming/library-hellocharts-charting-library-t2904456/page2）;
         * 下面几句可以设置X轴数据的显示个数（x轴0-7个数据），当数据点个数小于（29）的时候，缩小到极致hellochart默认的是所有显示。当数据点个数大于（29）的时候，
         * 若不设置axisX.setMaxLabelChars(int count)这句话,则会自动适配X轴所能显示的尽量合适的数据个数。
         * 若设置axisX.setMaxLabelChars(int count)这句话,
         * 33个数据点测试，若 axisX.setMaxLabelChars(10);里面的10大于v.right= 7; 里面的7，则
         刚开始X轴显示7条数据，然后缩放的时候X轴的个数会保证大于7小于10
         若小于v.right= 7;中的7,反正我感觉是这两句都好像失效了的样子 - -!
         * 并且Y轴是根据数据的大小自动设置Y轴上限
         * 若这儿不设置 v.right= 7; 这句话，则图表刚开始就会尽可能的显示所有数据，交互性太差
         */
        Viewport v = new Viewport(lineChart.getMaximumViewport());
        v.left = 0;
        v.right = 7;
        lineChart.setCurrentViewport(v);
    }

}
