package com.example.jamal.layoutavances;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Intent intent;
    Button choice1,choice2,choice3,choice4,
    choice5,choice6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        choice1 = (Button) findViewById(R.id.gridExample);
        choice2 = (Button) findViewById(R.id.simpleChoiceExample);
        choice3 = (Button) findViewById(R.id.arrayAdapterExample);
        choice4 = (Button) findViewById(R.id.testExample);
        choice5 = (Button) findViewById(R.id.menuTest);
        choice6 = (Button) findViewById(R.id.alertTest);

        choice1.setOnClickListener(this);
        choice2.setOnClickListener(this);
        choice3.setOnClickListener(this);
        choice4.setOnClickListener(this);
        choice5.setOnClickListener(this);
        choice6.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gridExample :   intent= new Intent(this , ListeViewExample.class);
                startActivity(intent);
                break ;
            case  R.id.simpleChoiceExample : intent= new Intent(this , SingleChoiceActivity.class);
                startActivity(intent) ;
                break ;
            case  R.id.testExample : intent= new Intent(this , Test.class);
            startActivity(intent) ;
            break ;

            case R.id.arrayAdapterExample : intent= new Intent(this , AdapterActivity.class);
                startActivity(intent) ;
                break;

            case R.id.menuTest : intent= new Intent(this , MenuActivity.class);
                startActivity(intent) ;
                break;

            case R.id.alertTest : intent= new Intent(this , AlertExample.class);
                startActivity(intent) ;
                break;


        }
    }
}
