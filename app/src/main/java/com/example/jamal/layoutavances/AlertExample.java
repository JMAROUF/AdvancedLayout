package com.example.jamal.layoutavances;

import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.*;
public class AlertExample extends AppCompatActivity implements View.OnClickListener {
    Button b1, b2 , b3, b5, b6 , b7;
    EditText t1;
    AlertDialog alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_example);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        t1 = (EditText)findViewById(R.id.t1);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {

            case R.id.b5:
                AlertDialog.Builder adb = new AlertDialog.Builder(this);
                adb.setMessage("Message");
                adb.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(AlertExample.this,"clic sur OK",Toast.LENGTH_LONG).show();
                            }
                        });


                 alert= adb.create();
                alert.show();

                break;
            case R.id.b6:
                adb = new AlertDialog.Builder(this);
                adb.setMessage("Message");
                adb.setPositiveButton("OUI",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(AlertExample.this,"clic sur OK",Toast.LENGTH_LONG).show();
                            }
                        });

                adb.setNegativeButton("NON",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                finish();
                            }
                        });
                alert= adb.create();
                alert.show();

                break;
            case R.id.b7:
                adb = new AlertDialog.Builder(this);
                adb.setMessage("Message");
                adb.setPositiveButton("OUI",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(AlertExample.this,"clic sur OK",Toast.LENGTH_LONG).show();
                            }
                        });

                adb.setNegativeButton("NON",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                finish();
                            }
                        });
                adb.setNeutralButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                finish();
                        }
                        });
                alert= adb.create();
                alert.show();

                break;
            case R.id.b1 :
                Toast.makeText(getApplicationContext()," Message durée limitée",Toast.LENGTH_LONG).show();
                break;
            case R.id.b2 :
                Toast.makeText(getApplicationContext(),
                        " Message durée limitée",Toast.LENGTH_SHORT).show();
                break;
            case R.id.b3 :
                final Toast msg=  Toast.makeText(getApplicationContext(),
                        " Message durée limitée",Toast.LENGTH_LONG);
                msg.show();
                Handler hd = new Handler();
                hd.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        msg.cancel();
                    }
                } , Integer.parseInt(t1.getText().toString())*1000);

                break;
        }
    }
}
