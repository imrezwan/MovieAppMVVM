package com.example.movieappmvvm.viewmodels;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movieappmvvm.services.models.Result;
import com.example.movieappmvvm.services.repositories.IMovieRepository;
import com.example.movieappmvvm.services.repositories.MovieRepositoryImpl;

import java.util.List;

public class TopMovieViewModel extends AndroidViewModel {

    private IMovieRepository movieRepository;

    public TopMovieViewModel(@NonNull Application application) {
        super(application);
        movieRepository = MovieRepositoryImpl.getMovieRepository(application);

    }

    public LiveData<List<Result>> getTopRatedMovies(int pageNo){
        return movieRepository.getTopRatedMovies(pageNo);
    }
}
