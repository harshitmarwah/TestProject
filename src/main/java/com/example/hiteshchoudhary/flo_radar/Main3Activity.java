package com.example.hiteshchoudhary.flo_radar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class Main3Activity extends AppCompatActivity {

    Button btn,btn2;
    TextView tw1,tw2;
    // ListView lv,lv1;
    CalendarView c;
    String curDate = null;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btn = (Button) findViewById(R.id.button);
        tw1 = (TextView) findViewById(R.id.textView);
        btn2 = (Button) findViewById(R.id.button2);
        //tw.setText((CharSequence) yr.execute());


        c = (CalendarView) findViewById(R.id.calendarView2);

        c.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {

                int d = i1;
                d = d + 1;
                int d1 = i2;
                String s1 = "0";
                if (d1 < 10) {
                    s1 = s1 + i2;
                } else {
                    s1 = String.valueOf(i2);
                }
                String s = String.valueOf(d);
                curDate = i + "-" + s + "-" + s1;
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String fm = df.format(c.getDate());
             //   Log.d("Date Requested:",curDate);

                Intent in = new Intent(Main3Activity.this, Main2Activity.class);
                in.putExtra("curDate", curDate);
                startActivity(in);


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Main3Activity.this, Main4Activity.class);
                in.putExtra("curDate", curDate);
                startActivity(in);
            }
        });
    }
}
