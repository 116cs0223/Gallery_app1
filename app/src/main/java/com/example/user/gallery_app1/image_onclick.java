package com.example.user.gallery_app1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import android.support.design.widget.Snackbar;

import android.support.design.widget.CoordinatorLayout;
import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class image_onclick extends AppCompatActivity {
    ImageView imageview;
    //Bitmap bit =null;
    Display_Image dpimage;
    String url;
    CoordinatorLayout cdlayout;
    int currposition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_onclick);
        imageview =(ImageView) findViewById(R.id.imgview1);
        cdlayout =(CoordinatorLayout)findViewById(R.id.cdl);

        Intent intent = getIntent();
         url = intent.getStringExtra("img");
        Glide.with(image_onclick.this).load(url).into(imageview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch(id)
        {
            case R.id.share:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, url);
                startActivity(Intent.createChooser(sharingIntent, "Share Image Using"));
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
