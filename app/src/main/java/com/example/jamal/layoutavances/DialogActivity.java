package com.example.jamal.layoutavances;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DialogActivity extends AppCompatActivity {

    private static  int compteur=0 ;
    private static final int IDENTIFIANT_BOITE_UN=1,IDENTIFIANT_BOITE_DEUX=2;
    private Dialog boite1,boite2;
    private Button dialogButton;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        dialogButton = (Button) findViewById(R.id.dialogButton);
        AlertDialog.Builder alert = new AlertDialog.Builder(this).setNegativeButton("finish", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).setMessage("test d'une alerte ");
        alert.show();

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(compteur <5){
                    showDialog(IDENTIFIANT_BOITE_UN);
                }else{
                    showDialog(IDENTIFIANT_BOITE_DEUX);
                }
            }
        });

    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
        if(id==IDENTIFIANT_BOITE_UN && compteur >1)
        dialog.setTitle(String.valueOf(compteur));
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Dialog box = null;
        //En fonction de l'identifiant de la boîte qu'on veut créer
        switch(id) {
            case IDENTIFIANT_BOITE_UN :
                 box = new Dialog(this);
                 box.setTitle(String.valueOf(compteur));
                break;

            case IDENTIFIANT_BOITE_DEUX :
                box = new Dialog(this);
                box.setTitle("ET MOI ALORS !");
                // On construit la seconde boîte de dialogue, que l'on insère dans « box »
                break;
        }
        return box;
    }
}
