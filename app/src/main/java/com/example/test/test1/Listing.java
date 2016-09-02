package com.example.test.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import Adapters.MyAdapter;
import Model.CountryModel;

public class Listing extends AppCompatActivity {

    private List<CountryModel> countary_list = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        //
        RecyclerView listView = (RecyclerView) findViewById(R.id.countaries);

        mAdapter = new MyAdapter(countary_list,this,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        listView.setLayoutManager(mLayoutManager);
        listView.setItemAnimator(new DefaultItemAnimator());
        listView.setAdapter(mAdapter);

        prepareMovieData();
    }
    private void prepareMovieData() {
        CountryModel movie = new CountryModel("Mad Max: Fury Road", "2015");
        countary_list.add(movie);

        movie = new CountryModel("Inside Out", "2015");
        countary_list.add(movie);

        movie = new CountryModel("Star Wars: Episode VII - The Force Awakens", "2015");
        countary_list.add(movie);

        movie = new CountryModel("Shaun the Sheep", "2015");
        countary_list.add(movie);

        movie = new CountryModel("The Martian", "2015");
        countary_list.add(movie);

        movie = new CountryModel("Mission: Impossible Rogue Nation", "2015");
        countary_list.add(movie);

        movie = new CountryModel("Up", "2009");
        countary_list.add(movie);

        movie = new CountryModel("Star Trek", "2009");
        countary_list.add(movie);

        movie = new CountryModel("The LEGO Movie", "2014");
        countary_list.add(movie);

        movie = new CountryModel("Iron Man", "2008");
        countary_list.add(movie);

        movie = new CountryModel("Aliens", "1986");
        countary_list.add(movie);

        movie = new CountryModel("Chicken Run", "2000");
        countary_list.add(movie);

        movie = new CountryModel("Back to the Future", "1985");
        countary_list.add(movie);

        movie = new CountryModel("Raiders of the Lost Ark", "1981");
        countary_list.add(movie);

        movie = new CountryModel("Goldfinger", "1965");
        countary_list.add(movie);

        movie = new CountryModel("Guardians of the Galaxy", "2014");
        countary_list.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}
