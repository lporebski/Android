package com.example.zad1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class right_angledActivity extends AppCompatActivity {

    Button calculate;
    TextView result;
    EditText side_a;
    EditText side_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_angled);
        calculate= (Button) findViewById(R.id.button5);
        side_a= (EditText) findViewById(R.id.editTextNumberDecimal7);
        side_b= (EditText) findViewById(R.id.editTextNumberDecimal8);
        result= (TextView) findViewById(R.id.textView29);
        calculate.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                result.setText((Double.parseDouble(side_a.getText().toString())*Double.parseDouble(side_b.getText().toString()))/2 + "");
            }
        });
    }
}