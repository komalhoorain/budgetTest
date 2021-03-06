package com.example.test.test1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class chart extends AppCompatActivity  {

    PieChart mChart;
    private int[] yValues = {21, 2, 2};
    private String[] xValues = {"Present Days", "Absents", "Leaves"};
    // colors for different sections in pieChart
    public static  final int[] MY_COLORS = {
            Color.rgb(84,124,101), Color.rgb(64,64,64), Color.rgb(153,19,0),
            Color.rgb(38,40,53), Color.rgb(215,60,55)
    };
    ArrayList<Integer> colors = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        //
        //mChart.setHoleColorTransparent(true);
        mChart = (PieChart)findViewById(R.id.chart);
        mChart.setHoleRadius(60.0f);

        mChart.setDrawCenterText(true);

        mChart.setDrawHoleEnabled(true);

        mChart.setRotationAngle(0);

        mChart.setRotationEnabled(true);

        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

            }

            @Override
            public void onNothingSelected() {

            }
        });

        mChart.setCenterText("Attendence");

        ArrayList<PieEntry> yVals1 = new ArrayList<PieEntry>();

        yVals1.add(new PieEntry((float) 21.6, "Present"));
        yVals1.add(new PieEntry((float) 2.0, "Absent"));
        yVals1.add(new PieEntry((float) 2.0, "Leave"));



        ArrayList<Integer> colorlist = new ArrayList<Integer>();

        colorlist.add(Color.rgb(84,124,101));
        colorlist.add(Color.rgb(64, 64, 64));
        colorlist.add(Color.rgb(153, 19, 0));


        PieDataSet dataSet = new PieDataSet(yVals1, "Idades Porlande");
        dataSet.setSliceSpace(3f);
        dataSet.setColors(colorlist);


        PieData data;
        data = new PieData(dataSet);
        data.setValueTextSize(11.0f);
        data.setValueTextColor(Color.BLACK);

        //show x-axis values
        mChart.setDrawSliceText(true);

        //convert float into decimal
        //data.setValueFormatter(new MyValueFormatter());
        mChart.setData(data);

        // undo all highlights
        mChart.highlightValues(null);

        // refresh/update pie chart
        mChart.invalidate();

        // animate piechart
        mChart.animateXY(1400, 1400);



        mChart.setData(data);
        Legend l = mChart.getLegend();
        l.setFormSize(10.0f); // set the size of the legend forms/shapes
        l.setForm(Legend.LegendForm.CIRCLE); // set what type of form/shape should be used
        l.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
        l.setTextSize(12.0f);
        l.setTextColor(Color.BLACK);
        l.setXEntrySpace(5.0f); // set the space between the legend entries on the x-axis
        l.setYEntrySpace(5.0f); // set the space between the legend entries on the y-axis

        l.setWordWrapEnabled(true);

    }
    public class MyValueFormatter implements ValueFormatter {

        private DecimalFormat mFormat;

        public MyValueFormatter() {
            mFormat = new DecimalFormat("###,###,##0"); // use one decimal if needed
        }

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            // write your logic here
            return mFormat.format(value) + ""; // e.g. append a dollar-sign
        }
    }
}
