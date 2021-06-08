package com.example.nauka_jezyka;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class LearnTestActivity extends AppCompatActivity{
    String[] words_pol = {"dodać", "wiek", "tani", "dziecko", "zegar"};
    String[] words_eng = {"add", "age", "cheap", "child", "clock"};
    ArrayList<String> pol_vocabulary = new ArrayList<>(Arrays.asList(words_pol));
    ArrayList<String> eng_vocabulary = new ArrayList<>(Arrays.asList(words_eng));
    Button nextBtn, returnBtn;
    TextView word1;
    EditText word2;
    int i = 0;
    int score = 0;
    private static final String TAG = "MyActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_test);
        nextBtn = findViewById(R.id.next_button);
        returnBtn = findViewById(R.id.returnButton);
        word1 = findViewById(R.id.wordView);
        word2 = findViewById(R.id.scoreText);
        Intent myCallerIntent = getIntent();
        Bundle myBundle = myCallerIntent.getExtras();
        int val1 = myBundle.getInt("language");
        boolean mode = myBundle.getBoolean("mode");
        long seed = System.nanoTime();
        Collections.shuffle(pol_vocabulary, new Random(seed));
        Collections.shuffle(eng_vocabulary, new Random(seed));

        if(val1 == 0 && mode){
            testPol();
        }
        else if(val1 == 1 && mode){
            testEng();
        }
        else if(!mode){
            learn();
        }
        returnBtn.setOnClickListener((v) ->{
            alert("Czy chcesz wyjść?");
        });
    }
    public void alert(String message){
        new AlertDialog.Builder(LearnTestActivity.this)
                .setTitle("Czy chcesz wrócić do menu?")
                .setMessage(message)
                .setNegativeButton("Nie", (dialog, which) -> {})
                .setPositiveButton("Tak", (dialog, which) -> menu())
                .show();
    }
    protected void menu(){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
    protected void testPol(){
        word1.setText(pol_vocabulary.get(i));
            nextBtn.setOnClickListener((v) ->{
                i++;
                if(i<pol_vocabulary.size()){
                    word1.setText(pol_vocabulary.get(i));
                    if(word2.getText().toString().equals(eng_vocabulary.get(i-1))){
                        score++;
                    }
                }else{
                    if(word2.getText().toString().equals(eng_vocabulary.get(eng_vocabulary.size()-1))){
                        score++;
                    }
                    Intent i = new Intent(getApplicationContext(), ScoreActivity.class);
                    Bundle scoreValue = new Bundle();
                    scoreValue.putInt ("score", score);
                    i.putExtras(scoreValue);
                    startActivity(i);
                }
            });
    }
    protected void testEng(){
        word1.setText(eng_vocabulary.get(i));
        nextBtn.setOnClickListener((v) ->{
            i++;
            if(i<pol_vocabulary.size()) {
                word1.setText(eng_vocabulary.get(i));
                if (word2.getText().toString().equals(pol_vocabulary.get(i - 1))) {
                    score++;
                }

            }else{
                if(word2.getText().toString().equals(pol_vocabulary.get(eng_vocabulary.size()-1))){
                    score++;
                }
                Intent i = new Intent(getApplicationContext(), ScoreActivity.class);
                Bundle scoreValue = new Bundle();
                scoreValue.putInt ("score", score);
                i.putExtras(scoreValue);
                startActivity(i);
            }
        });
    }
    protected void learn(){
        word1.setText(eng_vocabulary.get(i));
        word2.setText(pol_vocabulary.get(i));
        i++;
        nextBtn.setOnClickListener((v) ->{
            word1.setText(eng_vocabulary.get(i));
            word2.setText(pol_vocabulary.get(i));
            i++;
            if(i >= eng_vocabulary.size()){
                nextBtn.setEnabled(false);
            }
        });

    }
}