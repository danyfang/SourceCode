package com.example.autocompletedemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    AutoCompleteTextView autocomplete, autocomplete2;

    String[] arr = { "Paries,France", "PA,United States","Parana,Brazil",
            "Padua,Italy", "Pasadena,CA,United States"};
    String[] cou = {"China", "Germany", "Netherlands", "Portugla", "France", "Spain"};

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autocomplete = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, arr);

        autocomplete.setThreshold(2);
        autocomplete.setAdapter(adapter);

        autocomplete2 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView2);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, cou);


        autocomplete2.setThreshold(2);
        autocomplete2.setAdapter(adapter2);

        autocomplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (autocomplete.isPopupShowing()) {
                    autocomplete2.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS);
                }
            }
        });
    }


}