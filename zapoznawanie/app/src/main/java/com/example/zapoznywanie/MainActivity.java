package com.example.zapoznywanie;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView webview;
    TextView place1, place2, place3;
    Button mapBtn, infoBtn;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview =findViewById(R.id.webView);
        place1=findViewById(R.id.place1);
        place2=findViewById(R.id.place2);
        place3=findViewById(R.id.place3);
        mapBtn=findViewById(R.id.showButton);
        infoBtn=findViewById(R.id.infoButton);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        places();
    }
    private void places(){
        place1.setOnClickListener(v -> {
            mapBtn.setAlpha(1);
            place2.setBackgroundColor(Color.parseColor("#ffffff"));
            place3.setBackgroundColor(Color.parseColor("#ffffff"));
            place1.setBackgroundColor(Color.parseColor("#814BB3E3"));
            infoBtn.setAlpha(1);
            mapBtn.setOnClickListener(v1 -> {
                String mapUrl ="https://www.google.com/maps/search/Instytut+Informatyki+Sosnowiec/@50.2970105,19.1322792,16z";
                webview.loadUrl(mapUrl);
                webview.setVisibility(View.VISIBLE);
            });
            infoBtn.setOnClickListener(v1 -> {
                webview.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "Bedzińska 39, Sosnowiec 41-200\n Wydział uniwersytecki", Toast.LENGTH_LONG).show();
            });
        });
        place2.setOnClickListener(v -> {
            mapBtn.setAlpha(1);
            infoBtn.setAlpha(1);
            place1.setBackgroundColor(Color.parseColor("#ffffff"));
            place3.setBackgroundColor(Color.parseColor("#ffffff"));
            place2.setBackgroundColor(Color.parseColor("#814BB3E3"));
            mapBtn.setOnClickListener(v1 -> {
                webview.setVisibility(View.VISIBLE);
                String mapUrl ="https://www.google.com/maps/place/Wydzia%C5%82+Nauk+o+Ziemi,+41-205+Sosnowiec/@50.2993681,19.1310993,17z/data=!3m1!4b1!4m5!3m4!1s0x4716da81727875b3:0x66f14212b7aab7e8!8m2!3d50.2993681!4d19.1332881";
                webview.loadUrl(mapUrl);
            });
            infoBtn.setOnClickListener(v1 -> {
                webview.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "Będzińska 60, Sosnowiec 41-205\n", Toast.LENGTH_LONG).show();
            });
        });
        place3.setOnClickListener(v -> {
            mapBtn.setAlpha(1);
            place1.setBackgroundColor(Color.parseColor("#ffffff"));
            place2.setBackgroundColor(Color.parseColor("#ffffff"));
            place3.setBackgroundColor(Color.parseColor("#814BB3E3"));
            infoBtn.setAlpha(1);
            mapBtn.setOnClickListener(v1 -> {
                webview.setVisibility(View.VISIBLE);
                String mapUrl ="https://www.google.com/maps/place/Bar+LALAMIDO+II/@50.2953258,19.1309122,17z/data=!3m1!4b1!4m5!3m4!1s0x4716da83794eca5f:0xc713b93d182175d8!8m2!3d50.2953653!4d19.1331111";
                webview.loadUrl(mapUrl);
            });
            infoBtn.setOnClickListener(v1 -> {
                webview.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "Sucha 6, Sosnowiec 41-200\nniedziela\n" +
                        "    Zamknięte\n" +
                        "poniedziałek\n" +
                        "    12:00–18:00\n" +
                        "wtorek\n" +
                        "    12:00–18:00\n" +
                        "środa\n" +
                        "    12:00–18:00\n" +
                        "czwartek\n" +
                        "    12:00–18:00\n" +
                        "piątek\n" +
                        "12:00–18:00\n", Toast.LENGTH_LONG).show();
            });
        });

    }
}