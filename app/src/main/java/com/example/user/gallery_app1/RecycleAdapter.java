package com.example.user.gallery_app1;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
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
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String path = array.get(position).getImage_url_prefix()+array.get(position).getFeaturedimage();
        Glide.with(activity).load(path).into(holder.ImgView);
    }

    @Override
    public int getItemCount() {
        return array.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView ImgView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ImgView=(ImageView)itemView.findViewById(R.id.imgview);
        }
    }
}
