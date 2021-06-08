package com.example.zad1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    TextView t6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (TextView)findViewById(R.id.textView);
        t2 = (TextView)findViewById(R.id.textView2);
        t3 = (TextView)findViewById(R.id.textView3);
        t4 = (TextView)findViewById(R.id.textView4);
        t5 = (TextView)findViewById(R.id.textView5);
        t6 = (TextView)findViewById(R.id.textView6);

        View.OnClickListener listener1= v -> {
            Intent i = new Intent(getApplicationContext(), squareActivity.class);
            startActivity(i);
        };
        View.OnClickListener listener2= v -> {
            Intent i = new Intent(getApplicationContext(), rectangleActivity.class);
            startActivity(i);
        };
        View.OnClickListener listener3= v -> {
            Intent i = new Intent(getApplicationContext(), circleActivity.class);
            startActivity(i);
        };
        View.OnClickListener listener4= v -> {
            Intent i = new Intent(getApplicationContext(), diamondActivity.class);
            startActivity(i);
        };
        View.OnClickListener listener5= v -> {
            Intent i = new Intent(getApplicationContext(), right_angledActivity.class);
            startActivity(i);
        };
        View.OnClickListener listener6 = v -> {
            Intent i = new Intent(getApplicationContext(), equila_teralActivity.class);
            startActivity(i);
        };

        t1.setOnClickListener(listener1);
        t2.setOnClickListener(listener2);
        t3.setOnClickListener(listener3);
        t4.setOnClickListener(listener4);
        t5.setOnClickListener(listener5);
        t6.setOnClickListener(listener6);
    }
}