package com.example.kolkokrzyzyk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int player1;
    int player2;
    int clicked;
    TextView player1Score;
    TextView player2Score;
    ImageView field0x0;
    ImageView field0x1;
    ImageView field0x2;
    ImageView field1x0;
    ImageView field1x1;
    ImageView field1x2;
    ImageView field2x0;
    ImageView field2x1;
    ImageView field2x2;
    int[][] board = new int [3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        field0x0=findViewById(R.id.field00);
        field0x0.setOnClickListener(this);
        field0x1=findViewById(R.id.field01);
        field0x1.setOnClickListener(this);
        field0x2=findViewById(R.id.field02);
        field0x2.setOnClickListener(this);
        field1x0=findViewById(R.id.field10);
        field1x0.setOnClickListener(this);
        field1x1=findViewById(R.id.field11);
        field1x1.setOnClickListener(this);
        field1x2=findViewById(R.id.field12);
        field1x2.setOnClickListener(this);
        field2x0=findViewById(R.id.field20);
        field2x0.setOnClickListener(this);
        field2x1=findViewById(R.id.field21);
        field2x1.setOnClickListener(this);
        field2x2=findViewById(R.id.field22);
        field2x2.setOnClickListener(this);
        player1Score=findViewById(R.id.player1Wins);
        player2Score=findViewById(R.id.player2Wins);
    }
    public void resetBoard(){
        field0x0.setEnabled(true);
        field0x1.setEnabled(true);
        field0x2.setEnabled(true);
        field1x0.setEnabled(true);
        field1x1.setEnabled(true);
        field1x2.setEnabled(true);
        field2x0.setEnabled(true);
        field2x1.setEnabled(true);
        field2x2.setEnabled(true);
        field0x0.setImageResource(R.drawable.tlo);
        field0x1.setImageResource(R.drawable.tlo);
        field0x2.setImageResource(R.drawable.tlo);
        field1x0.setImageResource(R.drawable.tlo);
        field1x1.setImageResource(R.drawable.tlo);
        field1x2.setImageResource(R.drawable.tlo);
        field2x0.setImageResource(R.drawable.tlo);
        field2x1.setImageResource(R.drawable.tlo);
        field2x2.setImageResource(R.drawable.tlo);
        clicked=0;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                board[i][j]=0;
            }
        }
    }
    public void alert(String message){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Czy chcesz zagrać ponownie?")
                .setMessage(message)
                .setPositiveButton("Tak", (dialog, which) -> resetBoard())
                .show();
    }
    public boolean checkWin(){
        for(int i=0; i<3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][2] != 0) {
                return true;
            } else if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[2][i] != 0) {
                return true;
            }
        }
            if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]&&board[2][2]!=0){
                return true;
            }
            if(board[0][2]==board[1][1]&&board[1][1]==board[2][0]&&board[2][0]!=0){
                return true;
            }

        return false;
    }
    public char checkPlayerTurn(){
        if(clicked%2==0){
            return 2;
        }else
            return 1;
    }
    @Override
    public void onClick(View v) {
        clicked++;
        if(checkPlayerTurn()==2){
            ImageView im=findViewById(v.getId());
            String idString = v.getResources().getResourceEntryName(v.getId());
            board[idString.charAt(5)-48][idString.charAt(6)-48] = 2;
            im.setImageResource(R.drawable.krzyzyk);
            im.setEnabled(false);

            if(checkWin()){
                alert("Wygrał gracz nr 2");
                player2++;
                player2Score.setText(valueOf(player2));
                resetBoard();
            }
        }
        else if(checkPlayerTurn()==1){
            ImageView im=findViewById(v.getId());
            im.setImageResource(R.drawable.kolko);
            im.setEnabled(false);
            String idString = v.getResources().getResourceEntryName(v.getId());
            board[idString.charAt(5)-48][idString.charAt(6)-48] = 1;
            if(checkWin()){
                alert("Wygrał gracz nr 1");
                player1++;
                player1Score.setText(valueOf(player1));
                resetBoard();
            }
        }
        if(clicked==9){
            alert("Zremisowaliście");
        }
    }
}