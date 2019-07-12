package com.example.geek;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalenderActivity extends AppCompatActivity {
    private static final String TAG = "CalenderActivity";
    private Toolbar tb;
    private MaterialCalendarView materialCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        initView();
    }

    private void initView() {
        tb = (Toolbar) findViewById(R.id.tb);
        tb.setTitle("选择日期");
        setSupportActionBar(tb);
        //日历
        materialCalendarView = (MaterialCalendarView) findViewById(R.id.materialCalendarView);
        Calendar calendar = Calendar.getInstance();
        materialCalendarView.state().edit()
                .setFirstDayOfWeek(Calendar.MONDAY)
                .setMinimumDate(CalendarDay.from(2013,4,3))
                .setMaximumDate(CalendarDay.from(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE)))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();

        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                //格式化日期
                SimpleDateFormat yyMMdd = new SimpleDateFormat("yyyyMMdd");
                String dateS = yyMMdd.format(date.getDate()).toString();
                Log.d(TAG, "onDateSelected: "+dateS);
                Intent intent = new Intent();
                intent.setAction("com.geek.calender");
                intent.putExtra("date",dateS);
                Log.d(TAG, "onDateSelected: "+dateS);
                //本地广播发送
                LocalBroadcastManager.getInstance(CalenderActivity.this).sendBroadcast(intent);
                finish();
            }
        });

    }
}
