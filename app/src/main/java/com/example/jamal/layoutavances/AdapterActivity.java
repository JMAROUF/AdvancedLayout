package com.example.jamal.layoutavances;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AdapterActivity extends AppCompatActivity {

    String[] countries = {
            "Maroc",
            "France",
            "Tunisie",
            "Algérie",
            "Egypte",
            "Belgique",
            "Etat Unis",
            "Italie",
            "Belgique",
            "Canada",
            "Espagne",
            "Almend",
            "Angleterre",
            "Japon",
            "Russie",
            "Chinoix"
};
/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_adapter);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, countries);
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.txtCountries);
        textView.setThreshold(1);
        textView.setAdapter(adapter);
        }
    }

