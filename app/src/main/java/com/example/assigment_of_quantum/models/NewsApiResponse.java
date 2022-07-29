package com.example.assigment_of_quantum.models;

import java.util.List;

public class NewsApiResponse {
    String statue;
    int totalResults;
    List<newsHeadlines> articles;

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<newsHeadlines> getArticles() {
        return articles;
    }

    public void setArticles(List<newsHeadlines> articles) {
        this.articles = articles;
    }
}
