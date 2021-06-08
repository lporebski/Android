package com.example.zad1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class equila_teralActivity extends AppCompatActivity {

    Button calculate;
    TextView result;
    EditText side_a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equila_teral);
        calculate= (Button) findViewById(R.id.button6);
        side_a= (EditText) findViewById(R.id.editTextNumberDecimal9);
        result= (TextView) findViewById(R.id.textView33);
        calculate.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                result.setText(((Double.parseDouble(side_a.getText().toString())*Double.parseDouble(side_a.getText().toString()))*Math.sqrt(3))/4 + "");
            }
        });
    }
}