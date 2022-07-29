package com.example.assigment_of_quantum;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView dataText,title;
    ImageView imageView;
    CardView container;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        dataText=  itemView.findViewById(R.id.dataText);
        imageView=itemView.findViewById(R.id.infoImage);
        container=itemView.findViewById(R.id.condition);
    }
}
