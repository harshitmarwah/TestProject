package com.example.hiteshchoudhary.flo_radar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView tw, tw2;
    Button btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tw = (TextView) findViewById(R.id.textView2);
       // tw.setText("Flo-Radar");
        //btn = (Button) findViewById(R.id.button2);
        //tw2.setText("SAVE WATER");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent in1 = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(in1);
                finish();
            }
        },5000);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent in1 = new Intent(MainActivity.this, Main3Activity.class);
//                startActivity(in1);
//            }
//
//
//        });
        Log.d("Creation","Created");
    }
}
