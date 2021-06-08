package com.example.flashlight;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button whiteBtn;
    Button redBtn;
    Button greenBtn;
    Button blueBtn;
    TextView LightTv;
    int alpha=255, r=255, g=255, b=255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        redBtn=findViewById(R.id.redButton);
        redBtn.setOnClickListener(this);
        whiteBtn=findViewById(R.id.whiteButton);
        whiteBtn.setOnClickListener(this);
        greenBtn=findViewById(R.id.greenButton);
        greenBtn.setOnClickListener(this);
        blueBtn=findViewById(R.id.blueButton);
        blueBtn.setOnClickListener(this);
        LightTv=findViewById(R.id.tvLight);

        SeekBar BarOpacity=findViewById(R.id.sbrOpacity);
        BarOpacity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                alpha=255-progress;
                int myBackColor = android.graphics.Color.argb(alpha, r, g, b);
                LightTv.setBackgroundColor(myBackColor);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    @Override
    public void onClick(View v) {
        if(v.getId()==whiteBtn.getId()){
            r=255;
            g=255;
            b=255;
        }
        if(v.getId()==redBtn.getId()){
            r=255;
            g=0;
            b=0;
        }
        if(v.getId()==greenBtn.getId()){
            r=0;
            g=255;
            b=0;
        }
        if(v.getId()==blueBtn.getId()){
            r=0;
            g=0;
            b=255;
        }
        int myBackColor = android.graphics.Color.argb(alpha, r, g, b);
        LightTv.setBackgroundColor(myBackColor);
    }
}