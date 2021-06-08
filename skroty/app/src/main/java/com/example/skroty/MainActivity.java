package com.example.skroty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView list;
    private String countries[];
    private String abb[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.list);
        Resources res=getResources();
        countries=res.getStringArray(R.array.countries_array);
        abb=res.getStringArray(R.array.shortcuts_array);
        ArrayAdapter adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, abb);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String msg=countries[position];
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}