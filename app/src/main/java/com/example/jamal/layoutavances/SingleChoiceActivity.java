package com.example.jamal.layoutavances;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.InputStream;

public class SingleChoiceActivity extends AppCompatActivity {

    private ImageView imageView;
    Context context;
    private  ListView maListe ;
    Integer[] imageIDS = {R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
            R.drawable.pic7 ,
            R.drawable.pic8 };
    private String[] imageNames = {"pic1",
            "pic2",
            "pic3",
            "pic4",
            "pic5",
            "pic6",
            "pic7",
            "pic8"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

         setContentView(R.layout.content_single_choice);

         context= getApplicationContext();
         imageView = (ImageView) findViewById(R.id.myImage);
         maListe= (ListView) findViewById(R.id.myList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_single_choice,imageNames);
         adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
         maListe.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
         maListe.setAdapter(adapter);

         maListe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //new DownloadImage(context,imageView).execute(imageIDS[position]);
                imageView.setImageResource(imageIDS[position]);
               // maListe.setItemChecked(position,true);

                }

        });
    }


}


