package com.example.jamal.layoutavances;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jamal.layoutavances.R;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by jamal on 04/01/2018.
 */

class MyGrid extends BaseAdapter {

    static {

        TimeZone tzone = TimeZone.getTimeZone("Africa/Timbuktu");
        TimeZone.setDefault(tzone);
    }

    Integer[] photo_album_id = new Integer[8];
    Context context ;
    Button nextBtn, prevBtn;
    ImageView iv;
    TextView picName,dateCreation;
    SimpleDateFormat dateFromat =new SimpleDateFormat("HH:mm:ss" ,new Locale("FR","fr"));
    private String[] imageNames={"pic1",
            "pic2",
            "pic3",
            "pic4",
            "pic5",
            "pic6",
            "pic7",
            "pic8"};

    public MyGrid(Context context,Integer[] photo_album_id) {
        this.photo_album_id=photo_album_id;
        this.context=context;

    }

    @Override
    public int getCount() {
        return photo_album_id.length;
    }

    @Override
    public Object getItem(int position) {
        return photo_album_id[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //ViewHolder holder;

        ImageView monImage;
        TextView picName,dateCreation ;
        if (convertView == null) {

           // holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.target, null);
            monImage = (ImageView) convertView.findViewById(R.id.grid_item_image);
            picName=(TextView) convertView.findViewById(R.id.picName);
            dateCreation= (TextView) convertView.findViewById(R.id.dateCreation);

            /*
             holder.imageView = (ImageView) convertView.findViewById(R.id.grid_item_image);
             holder.picName=(TextView) convertView.findViewById(R.id.picName);
             holder.dateCreation=(TextView) convertView.findViewById(R.id.dateCreation);
             convertView.setTag(holder);
             */
           // iv.setImageResource(photo_album_id[position]);

        }else {
           // holder= (ViewHolder)convertView.getTag();

            monImage = (ImageView) convertView.findViewById(R.id.grid_item_image);
            picName=(TextView) convertView.findViewById(R.id.picName);
            dateCreation= (TextView) convertView.findViewById(R.id.dateCreation);


        }

        picName.setText(imageNames[position]);
        dateCreation.setText(dateFromat.format(new Date()));
        new DownloadImage(context,monImage).execute(photo_album_id[position]);
        //monImage.setImageResource(photo_album_id[position]);
        /*
        new DownloadImage(context,holder.imageView).execute(photo_album_id[position]);
        holder.picName.setText(imageNames[position]);
        holder.dateCreation.setText(dateFromat.format(new Date()));
        */

        return convertView;
    }

    public class ViewHolder {
        ImageView imageView;
        TextView dateCreation,picName;
    }


}