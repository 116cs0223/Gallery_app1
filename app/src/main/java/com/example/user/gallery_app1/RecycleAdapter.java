package com.example.user.gallery_app1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
    ArrayList<images> array = new ArrayList<images>();
    Activity activity;

    public RecycleAdapter(ArrayList<images> array,Context context) {
        this.array = array;
        activity =(Activity)context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_element,parent,false);
        return new MyViewHolder(view,activity,array);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       // String path = array.get(position).getImage_url_prefix()+array.get(position).getFeaturedimage();
        Glide.with(activity).load(array.get(position).getUrl()).into(holder.ImgView);

    }

    @Override
    public int getItemCount() {
        return array.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView ImgView;
        ArrayList<images>arrayList = new ArrayList<images>();
        Context ctx;
        public MyViewHolder(View itemView,Context ctx,ArrayList<images> arrayList) {
            super(itemView);
            this.arrayList = arrayList;
            this.ctx= ctx;
            itemView.setOnClickListener(this);
            ImgView=(ImageView)itemView.findViewById(R.id.imgview);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            images img = this.arrayList.get(position);
            Intent intent = new Intent(this.ctx,image_onclick.class);
            intent.putExtra("img",img.getUrl());
            this.ctx.startActivity(intent);

        }
    }
}
