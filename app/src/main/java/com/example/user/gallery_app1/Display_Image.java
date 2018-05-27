package com.example.user.gallery_app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class Display_Image extends AppCompatActivity {
    RecyclerView recyclerview;
    RecycleAdapter adapter;
    String full ;
    String da;
    public ArrayList<images>arrayList = new ArrayList<images>();

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
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject k = response.getJSONObject("slider");
                    full=k.getString("imageUrlPrefix");
                    JSONArray f =k.getJSONArray("posts");
                    JSONObject q = f.getJSONObject(0);
                     da = q.getString("featured_image");
                    full =full +da;
                    arrayList.add(new images(full));
                    k =response.getJSONObject("top4");
                    String image = k.getString("imageUrlPrefix");
                    f =k.getJSONArray("posts");
                    for(int g =0;g<f.length();g++)
                    {
                        q=f.getJSONObject(g);
                        da = q.getString("featured_image");
                        arrayList.add(new images(image+da));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                adapter = new RecycleAdapter(arrayList,Display_Image.this);
                recyclerview.setAdapter(adapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });



           MySingleton.getInstance(Display_Image.this).addToRequest(jsonObjectRequest);


    }
}
