package com.example.user.gallery_app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class image_onclick extends AppCompatActivity {
    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_onclick);
        imageview =(ImageView) findViewById(R.id.imgview1);
        Intent intent = getIntent();
        String url = intent.getStringExtra("img");
        Glide.with(image_onclick.this).load(url).into(imageview);
    }
}
