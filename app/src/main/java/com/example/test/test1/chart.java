package com.example.test.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.view.Chart;
import lecho.lib.hellocharts.view.PieChartView;

public class chart extends AppCompatActivity {
    PieChartView piechart;
    PieChartData piedata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        //
        piechart = (PieChartView) findViewById(R.id.chart);

    }
}
