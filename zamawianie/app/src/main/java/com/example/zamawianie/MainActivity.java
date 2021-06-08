package com.example.zamawianie;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button pay;
    RadioGroup radGroupType;
    RadioGroup radGroupSize;
    CheckBox cheese, ham, chicken, mushrooms, olives, bacon, onion, salami, tuna, garlicSauce, tomatoSauce, oregano, garlic, capers, prawns;
    RadioButton radioSizeText;
    RadioButton radioTypeText;
    int primaryCount=0;
    int secondaryCount=0;
    String mainIngredients="";
    String additIngredients="";
    EditText input_name, input_surname, input_adress;
    int sum=0;
    String order="";
    String name = "";
    String surname = "";
    String adres = "";
    String emailSubject = "Zamówienie";
    String[] emailReceiverList={"pizzeria@nieistniejacyemail.com"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pay=findViewById(R.id.button);
        pay.setOnClickListener(this);
        radGroupType=findViewById(R.id.radioGroupType);
        radGroupSize=findViewById(R.id.radioGroupSize);
        cheese=findViewById(R.id.cheese);
        ham=findViewById(R.id.ham);
        chicken=findViewById(R.id.chicken);
        mushrooms=findViewById(R.id.mushrooms);
        olives=findViewById(R.id.olives);
        bacon=findViewById(R.id.bacon);
        onion=findViewById(R.id.onion);
        salami=findViewById(R.id.salami);
        tuna=findViewById(R.id.tuna);
        garlicSauce=findViewById(R.id.garlicSauce);
        tomatoSauce=findViewById(R.id.tomatoSauce);
        oregano=findViewById(R.id.oregano);
        garlic=findViewById(R.id.garlic);
        capers=findViewById(R.id.capers);
        prawns=findViewById(R.id.prawns);
        input_name = findViewById(R.id.input_name);
        input_surname = findViewById(R.id.input_surname);
        input_adress = findViewById(R.id.input_adress);
    }
    public void createOrder(){
        int radioIdType=radGroupType.getCheckedRadioButtonId();
        int radioIdSize=radGroupSize.getCheckedRadioButtonId();
        radioSizeText=findViewById(radioIdSize);
        radioTypeText=findViewById(radioIdType);
        CheckBox[] chkBoxIdPrimary={cheese, ham, chicken, mushrooms, olives, bacon, onion};
        CheckBox[] chkBoxIdSecondary={salami, tuna, garlicSauce, tomatoSauce, oregano, garlic, capers, prawns};
        switch (radioIdType){
            case R.id.thin: sum+=10;break;
            case R.id.thick: sum+=15;break;
        }
        switch (radioIdSize){
            case R.id.small: sum+=10;break;
            case R.id.medium: sum+=15;break;
            case R.id.big: sum+=15;break;
        }
        for(int i=0; i<chkBoxIdPrimary.length; i++){
            if(chkBoxIdPrimary[i].isChecked()){
                sum+=5;
                mainIngredients+=chkBoxIdPrimary[i].getText()+", ";
                primaryCount++;
            }
        }
        for(int i=0; i<chkBoxIdSecondary.length; i++){
            if(chkBoxIdSecondary[i].isChecked()){
                sum+=2;
                additIngredients+=chkBoxIdSecondary[i].getText()+", ";
                secondaryCount++;
            }
        }
    }
    public void alert(){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("W jaki sposób wysyłasz zamówienie?")
                .setNegativeButton("SMS", (dialog, which) -> {
                    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto: 222-111-333"));
                    intent.putExtra("sms_body", order);
                    startActivity(intent);
                    order="";
                })
                .setPositiveButton("Email", (dialog, which) -> {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("vnd.android.cursor.dir/email");
                    intent.putExtra(Intent.EXTRA_EMAIL,  emailReceiverList);
                    intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
                    intent.putExtra(Intent.EXTRA_TEXT, order);
                    startActivity(Intent.createChooser(intent,"Wybierz aplikację :"));
                    order="";
                })
                .show();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==pay.getId()){
            name = input_name.getText().toString();
            surname = input_surname.getText().toString();
            adres = input_adress.getText().toString();
            createOrder();
            order+="Imię: " + name + "\nNazwisko: " + surname  + "\nAdres zamieszkania: " + adres +  "\nZamówiona pizza\nrozmiar pizzy: "+radioSizeText.getText().toString()+"\ntyp ciasta: "+radioTypeText.getText().toString()+
                    "\nskładniki: "+mainIngredients+additIngredients+"\n\nKoszt twojego zamówienia wynosi: "+sum+"zł";
            if(primaryCount<3){
                Toast.makeText(getApplicationContext(), "Wybierz trzy składniki", Toast.LENGTH_SHORT).show();
            }else if(secondaryCount>2){
                Toast.makeText(getApplicationContext(), "Możesz wybrać maksymalnie dwa składniki", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), order, Toast.LENGTH_LONG).show();
                alert();
            }
        }
        mainIngredients="";
        additIngredients="";
        secondaryCount=0;
        primaryCount=0;
        sum=0;
    }
}