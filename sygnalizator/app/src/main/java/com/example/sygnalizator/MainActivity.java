package com.example.sygnalizator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView im1;
    ImageView im2;
    ImageView im3;
    boolean red=false;
    boolean yellow=false;
    boolean green=false;
    Button btnGreen;
    Button btnRed;
    Button btnYellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGreen=findViewById(R.id.greenButton);
        btnGreen.setOnClickListener(this);
        btnRed=findViewById(R.id.redButton);
        btnRed.setOnClickListener(this);
        btnYellow=findViewById(R.id.yellowButton);
        btnYellow.setOnClickListener(this);
        im1=findViewById(R.id.imageView);
        im2=findViewById(R.id.imageView2);
        im3=findViewById(R.id.imageView3);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btnRed.getId()){
            red=true;
            im1.setImageResource(R.drawable.red_on);
            im2.setImageResource(R.drawable.light_off);
            if(red==true){
                btnGreen.setEnabled(false);

            }
        }
        if(v.getId()==btnYellow.getId()){
            im2.setImageResource(R.drawable.yellow_on);
            im3.setImageResource(R.drawable.light_off);
            yellow=true;
            if(green==true){
                btnGreen.setEnabled(false);
                btnRed.setEnabled(true);
                green=false;
            }
            if(red==true&&yellow==true){
                btnRed.setEnabled(false);
                btnGreen.setEnabled(true);
            }
        }
        if(v.getId()==btnGreen.getId()){
            im3.setImageResource(R.drawable.green_on);
            green=true;
            red=false;
            yellow=false;
            btnRed.setEnabled(false);
        }
        if(red==false&&yellow==false){
            im1.setImageResource(R.drawable.light_off);
            im2.setImageResource(R.drawable.light_off);
        }
    }
}