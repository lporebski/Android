package com.example.zad1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class circleActivity extends AppCompatActivity {

    Button calculate;
    TextView result;
    EditText radius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        calculate= (Button) findViewById(R.id.button2);
        radius= (EditText) findViewById(R.id.editTextNumberDecimal2);
        result= (TextView) findViewById(R.id.textView13);
        calculate.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                result.setText(Math.PI*(Double.parseDouble(radius.getText().toString())*
                        Double.parseDouble(radius.getText().toString())) +"");
            }
        });
    }
}