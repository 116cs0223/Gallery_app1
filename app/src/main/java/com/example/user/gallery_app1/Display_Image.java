package com.example.user.gallery_app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Display_Image extends AppCompatActivity {
    RecyclerView recyclerview;
    RecycleAdapter adapter;
    ArrayList<images>arrayList = new ArrayList<images>();
    //ArrayList<images1>arrayList1 = new ArrayList<images1>();
            RecyclerView.LayoutManager layoutManager;
    String url ="http://mondaymorning.nitrkl.ac.in/api/post/get/featured";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__image);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setHasFixedSize(true);
       JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
           @Override
           public void onResponse(JSONArray response) {
               int count =0;
               while(count<response.length())
               {
                   try {
                       JSONObject jsonObject =response.getJSONObject(count);
                       arrayList.add(new images(jsonObject.getString("imageUrlPrefix"),jsonObject.getString("featured_image")));
                       count++;


                   } catch (JSONException e) {
                       e.printStackTrace();
                   }
               }
               adapter = new RecycleAdapter(arrayList,Display_Image.this);
               recyclerview.setAdapter(adapter);


           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {

           }
       });
        MySingleton.getInstance(Display_Image.this).addToRequest(jsonArrayRequest);


    }
}
