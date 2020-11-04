package com.spurdo.lasermanual;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

public class TextContentActivity extends AppCompatActivity {
    //private ActionBar actionBar;
    private TextView textContent;
    private ImageView imageView;
    private Typeface face1;
    private int category = 0;
    private int position = 0;
    private int [] arrayMaterial = {R.string.rowmark,R.string.rowmark2,R.string.steel,R.string.paintMetal,R.string.wood,R.string.ftoroplast,R.string.viniplast,R.string.trafaret,R.string.vraschenie,R.string.polycarbonat,R.string.ruber,R.string.nomakon};
    private int [] arrayMachines = {R.string.venus,R.string.yhg5030,R.string.pst1212};
    private int [] arrayService = {R.string.mirrors,R.string.dirt,R.string.lubrication,R.string.soft};
    private int [] arrayYoba = {R.string.yobaNow};
    private int [] arrayImageMaterial = {R.drawable.rowmark,R.drawable.rowmark2,R.drawable.steel,R.drawable.paint,R.drawable.wood,R.drawable.ftoroplast,R.drawable.viniplast,R.drawable.trafaret,R.drawable.vraschenie,R.drawable.polycarbonat,R.drawable.ruber,R.drawable.nomakon};
    private int [] arrayImageMachines = {R.drawable.venus,R.drawable.yhg5030,R.drawable.pst1212};
    private int [] arrayImageService = {R.drawable.mirrors,R.drawable.dirt,R.drawable.lubrication,R.drawable.soft};
    //private String [] arrayTitleMaterial = {"Пластик LaserLight для наклеек","Пластик для разрушаемых наклеек","Нержавейка","Окрашенный металл","Фанера","Фторопласт","Винипалст","Обложки прозрачные","Гравировка на цилиндрических поверхностях","Поликарбонат","Резина","Пластик","Номакон"};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        init();
        reciveIntent();


    }

    private void reciveIntent() {

        Intent i = getIntent();
        if (i != null) {
            category = i.getIntExtra("category", 0);
            position = i.getIntExtra("position", 0);

        }
        switch (category){
            case 0:
                imageView.setImageResource(arrayImageMaterial[position]);
                textContent.setText(arrayMaterial[position]);
                //actionBar.setTitle(arrayTitleMaterial[position]);

                break;
            case 1:
                imageView.setImageResource(arrayImageMachines[position]);
                textContent.setText(arrayMachines[position]);

                break;
            case 2:
                imageView.setImageResource(arrayImageService[position]);
                textContent.setText(arrayService[position]);

                break;
            case 3:
                imageView.setImageResource(R.drawable.yoba);
                textContent.setText(arrayYoba[position]);

                break;
        }

    }

    private void init () {
        textContent = findViewById(R.id.textMainContent);
        imageView = findViewById(R.id.imageContent);
        face1 =Typeface.createFromAsset(this.getAssets(),"fonts/Roboto-Regular.ttf");
        textContent.setTypeface(face1);
        //actionBar = getSupportActionBar();
    }

}
