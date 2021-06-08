package com.example.projekt_pamih;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {
    Button addButton, saveButton, editButton;
    EditText editText;
    CalendarView calendarView;
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = findViewById(R.id.addButton);
        editButton = findViewById(R.id.editButton);
        calendarView = findViewById(R.id.calendarView);
        listView = findViewById(R.id.listView);
        saveButton = findViewById(R.id.saveButton);
        editText = findViewById(R.id.editText);
        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_checked, items);
        listView.setAdapter(itemsAdapter);
        calendarView.setVisibility(View.INVISIBLE);
        editButton.setVisibility(View.INVISIBLE);
        editText.setVisibility(View.INVISIBLE);

        //dodawanie zadania
        addButton.setOnClickListener(v -> {
            EditText addInput =findViewById(R.id.addInput);

            String itemText = addInput.getText().toString();
            if(itemText.length()!=0){
                listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                calendarView.setVisibility(View.VISIBLE);
                calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
                    items.add(itemText +", "+ dayOfMonth +"-"+ month +"-"+ year);
                    itemsAdapter.notifyDataSetChanged();
                    calendarView.setVisibility(View.INVISIBLE);

                });
                addInput.setText("");
                itemsAdapter.notifyDataSetChanged();
            }else{
                Toast.makeText(getApplicationContext(), "Wpisz zadanie", Toast.LENGTH_LONG).show();
            }

        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Co chcesz zrobić?")

                    //Edycja zadania
                    .setNegativeButton("Edytuj", (dialog, which) -> {
                        editButton.setVisibility(View.VISIBLE);
                        editText.setVisibility(View.VISIBLE);
                        String selectedFromList = (String) (listView.getItemAtPosition(position));
                        editText.setText(selectedFromList);
                        editText.requestFocus();
                        editButton.setOnClickListener(v -> {

                            String itemText = editText.getText().toString();
                            listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                                items.add(itemText);
                                items.remove(position);
                                itemsAdapter.notifyDataSetChanged();
                                calendarView.setVisibility(View.INVISIBLE);
                            editText.setText("");
                            editButton.setVisibility(View.INVISIBLE);
                            editText.setVisibility(View.INVISIBLE);
                            itemsAdapter.notifyDataSetChanged();
                        });
                    })
                    //Usuwanie zadania
                    .setPositiveButton("Usuń", (dialog, which) -> {
                        items.remove(position);
                        itemsAdapter.notifyDataSetChanged();
                    })
                    //Priorytet
                    .setNeutralButton("Nadaj priorytet", (dialog, which) -> {
                        String selectedFromList = (String) (listView.getItemAtPosition(position));

                        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                        editText.setText(selectedFromList);
                        String itemText = editText.getText().toString();
                        items.add("1, "+ itemText);
                        items.remove(position);
                        editText.setText("");
                        itemsAdapter.notifyDataSetChanged();
                    })
                    .show();

            return true;
        });
    }

}