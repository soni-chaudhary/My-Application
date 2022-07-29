package com.example.assigment_of_quantum;

import com.example.assigment_of_quantum.models.newsHeadlines;

import java.util.List;

public interface onFetchDataListener <NewsApiResponse>{
    void onFetchData(List<newsHeadlines>list , String message);
    void onError(String message);
}
