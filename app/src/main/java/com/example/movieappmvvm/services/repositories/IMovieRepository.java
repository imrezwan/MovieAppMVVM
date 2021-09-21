package com.example.movieappmvvm.services.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.movieappmvvm.services.models.Result;

import java.util.List;

public interface IMovieRepository {
    public MutableLiveData<List<Result>> getTopRatedMovies(int pageNo);
}
