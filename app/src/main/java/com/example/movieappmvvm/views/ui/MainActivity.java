package com.example.movieappmvvm.views.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.movieappmvvm.R;
import com.example.movieappmvvm.services.models.Result;
import com.example.movieappmvvm.services.repositories.IMovieRepository;
import com.example.movieappmvvm.services.repositories.MovieRepositoryImpl;
import com.example.movieappmvvm.viewmodels.TopMovieViewModel;
import com.example.movieappmvvm.views.adapters.TopMovieAdapter;
import com.google.gson.internal.GsonBuildConfig;

import java.util.List;
import java.util.Observable;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mMovieRecycler;
    private TopMovieViewModel topMovieViewModel;
    private TopMovieAdapter movieAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMovieRecycler = findViewById(R.id.rv_top_movies);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mMovieRecycler.setLayoutManager(gridLayoutManager);

        topMovieViewModel = new ViewModelProvider(this).get(TopMovieViewModel.class);

        topMovieViewModel.getTopRatedMovies(1).observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                movieAdapter = new TopMovieAdapter(MainActivity.this, results);
                mMovieRecycler.setAdapter(movieAdapter);
            }
        });


    }
}