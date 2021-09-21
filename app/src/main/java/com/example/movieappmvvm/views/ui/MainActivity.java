package com.example.movieappmvvm.views.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.movieappmvvm.R;
import com.example.movieappmvvm.services.repositories.IMovieRepository;
import com.example.movieappmvvm.services.repositories.MovieRepositoryImpl;
import com.google.gson.internal.GsonBuildConfig;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IMovieRepository movieRepository = new MovieRepositoryImpl();
        movieRepository.getTopRatedMovies(1);
    }
}