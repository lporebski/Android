package com.example.quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAns1, btnAns2, btnAns3, btnAns4;
    ImageView picture;
    int questionCounter=1;
    int playerScore=0;
    TextView playerPoints;
    public void question1(){
        picture.setImageResource(R.drawable.bentley);
        btnAns1.setText("Bentley");
        btnAns2.setText("Audi");
        btnAns3.setText("Citroen");
        btnAns4.setText("BMW");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAns1=findViewById(R.id.button);
        btnAns1.setOnClickListener(this);
        btnAns2=findViewById(R.id.button2);
        btnAns2.setOnClickListener(this);
        btnAns3=findViewById(R.id.button3);
        btnAns3.setOnClickListener(this);
        btnAns4=findViewById(R.id.button4);
        btnAns4.setOnClickListener(this);
        picture=findViewById(R.id.imageView);
        playerPoints=findViewById(R.id.playerPoints);
        playerPoints.setText("0");
        question1();
    }
    public void alert(String message){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Twoja liczba punktów")
                .setPositiveButton("Tak", (dialog, which) -> reset())
                .setMessage(message)
                .show();
    }
    public void question2(){
        picture.setImageResource(R.drawable.chevrolet);
        btnAns1.setText("Ferrari");
        btnAns2.setText("Fiat");
        btnAns3.setText("Ford");
        btnAns4.setText("Chevrolet");
    }
    public void question3(){
        picture.setImageResource(R.drawable.audi);
        btnAns1.setText("Renault");
        btnAns2.setText("Audi");
        btnAns3.setText("SAAB");
        btnAns4.setText("Seat");
    }
    public void question4(){
        picture.setImageResource(R.drawable.citroen);
        btnAns1.setText("Peugeot");
        btnAns2.setText("Porshe");
        btnAns3.setText("Subaru");
        btnAns4.setText("Citroen");
    }
    public void question5(){
        picture.setImageResource(R.drawable.hyundai);
        btnAns1.setText("Hyundai");
        btnAns2.setText("Mini");
        btnAns3.setText("Suzuki");
        btnAns4.setText("Skoda");
    }
    public void reset(){
        playerScore=0;
        questionCounter=1;
        playerPoints.setText(valueOf(playerScore));
    }
    @Override
    public void onClick(View v) {
        question1();
        if(questionCounter==1){
            if(v.getId()==btnAns1.getId()){
                playerScore++;
                playerPoints.setText(valueOf(playerScore));
            }
            questionCounter++;
            question2();
        }
        else if(questionCounter==2){
            if(v.getId()==btnAns4.getId()){
                playerScore++;
                playerPoints.setText(valueOf(playerScore));
            }
            questionCounter++;
            question3();
        }
        else if(questionCounter==3){
            if(v.getId()==btnAns2.getId()){
                playerScore++;
                playerPoints.setText(valueOf(playerScore));
            }
            question4();
            questionCounter++;
        }
        else if(questionCounter==4){
            if(v.getId()==btnAns4.getId()){
                playerScore++;
                playerPoints.setText(valueOf(playerScore));
            }
            question5();
            questionCounter++;
        }
        else if(questionCounter==5){
            if(v.getId()==btnAns1.getId()){
                playerScore++;
                playerPoints.setText(valueOf(playerScore));
            }
            questionCounter++;
        }
        if(questionCounter>=6){
            alert(""+playerScore+"\n\nZagraj ponownie");
            reset();
        }
    }
}