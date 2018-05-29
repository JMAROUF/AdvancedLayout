package com.example.jamal.layoutavances;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Tdi201 extends Activity {
    ListView vue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdi201);

        //On récupère une ListView de notre layout en XML, c'est la vue qui représente la liste
        vue = (ListView) findViewById(R.id.listView);

        String[][] repertoire = new String[][]{
                {"Bill Gates", "06 06 06 06 06"},
                {"Niels Bohr", "05 05 05 05 05"},
                {"Alexandre III de Macédoine", "04 04 04 04 04"}};


        List<HashMap<String, String>> liste = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> element;
        //Pour chaque personne dans notre répertoire…
        for(int i = 0 ; i < repertoire.length ; i++) {
            //… on crée un élément pour la liste…
            element = new HashMap<String, String>();
            element.put("nom", repertoire[i][0]);
            element.put("numero", repertoire[i][1]);
            liste.add(element);
        }

        ListAdapter adapter = new SimpleAdapter(this,
                //Valeurs à insérer
                liste,
                android.R.layout.simple_list_item_2,

                new String[] {"numero","nom"},
                new int[] {android.R.id.text1, android.R.id.text2 });
        //Pour finir, on donne à la ListView le SimpleAdapter
        vue.setAdapter(adapter);
    }
}
