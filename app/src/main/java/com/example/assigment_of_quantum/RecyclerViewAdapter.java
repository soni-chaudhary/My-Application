package com.example.assigment_of_quantum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assigment_of_quantum.models.newsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<newsHeadlines> headlines;

    public RecyclerViewAdapter(Context context, List<newsHeadlines> headlines) {
        this.context = context;
        this.headlines = headlines;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.information_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.title.setText(headlines.get(position).getTitle());
        holder.dataText.setText(headlines.get(position).getSource().getName());
        if(headlines.get(position).getUrlToImage()!=null){
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.imageView);
        }

    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
