package com.example.zad1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class squareActivity extends AppCompatActivity {
    Button calculate;
    TextView result;
    EditText side;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);
        calculate= (Button) findViewById(R.id.button);
        side= (EditText) findViewById(R.id.editTextNumberDecimal);
        result= (TextView) findViewById(R.id.textView15);
        calculate.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                result.setText((Double.parseDouble(side.getText().toString())*
                        Double.parseDouble(side.getText().toString())) + "");
            }
        });
    }
}