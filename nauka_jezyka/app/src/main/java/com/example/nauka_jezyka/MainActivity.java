package com.example.nauka_jezyka;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    Button learn, test, about;
    boolean learn_bool = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        learn = findViewById(R.id.learning_button);
        test = findViewById(R.id.test_button);
        about = findViewById(R.id.aboutButton);
        Spinner select_lang = findViewById(R.id.spinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.languages));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        select_lang.setAdapter(myAdapter);

        test.setOnClickListener((v) ->{
            learn_bool = true;
            int selectedLanguage = select_lang.getSelectedItemPosition();
            Intent i = new Intent(getApplicationContext(), LearnTestActivity.class);
            Bundle spinnerValues = new Bundle();
            spinnerValues.putInt ("language",selectedLanguage);
            spinnerValues.putBoolean("mode", learn_bool);
            i.putExtras(spinnerValues);
            startActivity(i);
        });
        learn.setOnClickListener((v) ->{
            Intent i = new Intent(getApplicationContext(), LearnTestActivity.class);
            Bundle spinnerValues = new Bundle();
            spinnerValues.putBoolean("mode", learn_bool);
            i.putExtras(spinnerValues);
            startActivity(i);
        });
        about.setOnClickListener((v) ->{
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("O programie")
                        .setMessage("Łukasz Porębski grupa ISI3")
                        .setPositiveButton("Wróć", (dialog, which) -> {})
                        .show();
        });
    }
}