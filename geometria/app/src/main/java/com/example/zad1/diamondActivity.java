package com.example.zad1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class diamondActivity extends AppCompatActivity {

    Button calculate;
    TextView result;
    EditText side_a;
    EditText height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamond);
        calculate= (Button) findViewById(R.id.button4);
        side_a= (EditText) findViewById(R.id.editTextNumberDecimal3);
        height= (EditText) findViewById(R.id.editTextNumberDecimal6);
        result= (TextView) findViewById(R.id.textView24);
        calculate.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                result.setText((Double.parseDouble(side_a.getText().toString())*
                        Double.parseDouble(height.getText().toString())) + "");
            }
        });
    }
}