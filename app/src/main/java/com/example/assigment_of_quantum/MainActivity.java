package com.example.assigment_of_quantum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.assigment_of_quantum.databinding.ActivityMainBinding;
import com.example.assigment_of_quantum.models.NewsApiResponse;
import com.example.assigment_of_quantum.models.newsHeadlines;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private FirebaseAuth mAuth;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    TextView textSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        textSearch= findViewById(R.id.textSearch);



        mAuth = FirebaseAuth.getInstance();
        textSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              mAuth.signOut();
              finish();
            }
        });


        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.blue));
        RequestManager requestManager= new RequestManager(this);
        requestManager.getNewHeadlines(listener,"general",null);


    }

    private  final onFetchDataListener<NewsApiResponse> listener=new onFetchDataListener<NewsApiResponse>() {
        @Override
        public void onFetchData(List<newsHeadlines> list, String message) {
            showNews(list);
        }

        @Override
        public void onError(String message) {

        }
    };

    private void showNews(List<newsHeadlines> list) {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter = new RecyclerViewAdapter(this,list);
        recyclerView.setAdapter(adapter);
    }

}