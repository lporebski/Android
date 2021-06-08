package com.example.nauka_jezyka;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {
    TextView scoreView;
    Button returnBtn;
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.score);
            scoreView = findViewById(R.id.scoreView);
            returnBtn = findViewById(R.id.menuButton);
            Intent myCallerIntent = getIntent();
            Bundle myBundle = myCallerIntent.getExtras();
            int scoreVal = myBundle.getInt("score");
            scoreView.setText(Integer.toString(scoreVal));
            returnBtn.setOnClickListener((v) ->{
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            });
        }
}

