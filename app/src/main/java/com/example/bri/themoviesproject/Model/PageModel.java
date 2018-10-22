package com.example.bri.themoviesproject.Model;

import java.util.List;

import io.realm.RealmObject;

/**
 * Created by BRI on 11/08/2018.
 */

public class PageModel{

    public int page;
    public int total_results;
    public int total_pages;
    public List<MovieModel> results;

    public PageModel() {
    }

    public PageModel(int page, int total_results, int total_pages, List<MovieModel> results) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<MovieModel> getResults() {
        return results;
    }

    public void setResults(List<MovieModel> results) {
        this.results = results;
    }
}
