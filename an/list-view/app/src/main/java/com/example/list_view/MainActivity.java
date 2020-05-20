package com.example.list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] fruits={"Apple", "Pear", "Banana", "Orange", "Watermelon",
            "Grape", "Cherry", "Strawberry", "Mango", "Lemon", "Pineapple", "Plum", "Apricot", "Peach",
    "Litchi", "Kiwi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, fruits);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
