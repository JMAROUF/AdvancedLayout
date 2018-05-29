package com.example.jamal.layoutavances;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class GridActivity extends AppCompatActivity {

    GridView gridView;
    FrameLayout fullScreen;
    ImageView fullImage;
    Animation alphaAnimation;
    TranslateAnimation translateAnimation;
    float x,y;
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
        setContentView(R.layout.activity_grid);

        initialization();

        fullScreen.setVisibility(View.INVISIBLE);

        gridView.setAdapter(new MyGrid(this, imageIDS));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fullImage.setImageResource(imageIDS[position]);
                showFull();
            }
        });


    }

    //initializing views
    public void initialization(){
        gridView= (GridView) findViewById(R.id.gridView);
        fullScreen = (FrameLayout) findViewById(R.id.fullScreen);
        fullImage = (ImageView) findViewById(R.id.imageFull);
    }
    //show fullImage
    public void showFull(){
        // Alpha Animation
         alphaAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.alphaanimation);
         alphaAnimation.setDuration(4000);
         // Translate Animation
         translateAnimation = new TranslateAnimation(0,0,fullScreen.getHeight(),0);
        translateAnimation.setDuration(1500);
        //animation.setInterpolator(new AccelerateInterpolator(100){ });
        fullScreen.startAnimation(translateAnimation);
        gridView.startAnimation(alphaAnimation);
        fullScreen.setVisibility(View.VISIBLE);

    }

}
