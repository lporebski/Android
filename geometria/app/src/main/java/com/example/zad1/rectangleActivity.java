package com.example.zad1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class rectangleActivity extends AppCompatActivity {

    Button calculate;
    TextView result;
    EditText side_a;
    EditText side_b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);
        calculate= (Button) findViewById(R.id.button3);
        side_a= (EditText) findViewById(R.id.editTextNumberDecimal4);
        side_b= (EditText) findViewById(R.id.editTextNumberDecimal5);
        result= (TextView) findViewById(R.id.textView20);
        calculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                result.setText((Double.parseDouble(side_a.getText().toString())*
                        Double.parseDouble(side_b.getText().toString())) + "");
            }
        });
    }
}