package com.example.jamal.layoutavances;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

public class ListeViewExample extends AppCompatActivity {

    ListView myListe ;
    ImageView image ;
    Integer[] imageIDS = {R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
            R.drawable.pic7 ,
            R.drawable.pic8 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_test);

        myListe=(ListView) findViewById(R.id.scrollListe);
        image= (ImageView) findViewById(R.id.ImageList);
        myListe.setAdapter(new MyGrid(this, imageIDS));

        myListe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                image.setImageResource(imageIDS[position]);

            }
        });

    }

}
