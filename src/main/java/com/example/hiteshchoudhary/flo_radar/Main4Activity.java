package com.example.hiteshchoudhary.flo_radar;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

class Main4Activity extends AppCompatActivity {
    android.widget.ListView lv;
    TextView tw2;
    String dt=null;
    Intent mIntent = getIntent();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
//tw2=(TextView)findViewById(R.id.textView2);

        tw2=(TextView)findViewById(R.id.textView3);


        Bundle bundle = getIntent().getExtras();
        String dt = bundle.getString("curDate");
        //  Log.d("DAGFWEAF",dt);
        //  String dt ="2018-12-02" ;
        // tw2.setText(dt);
        //lv1=(ListView)findViewById(R.id.lv2);
        yourDataTask1 yr= new yourDataTask1(Main4Activity.this,tw2,dt);
        //    Log.d("Date:", dt);
        yr.doInBackground();
        yr.onPostExecute("DONE SUCCESSFULLY");
        // yourDataTask1 yr1 = new yourDataTask1(Main2Activity.this,tv,dt);
    }
}
