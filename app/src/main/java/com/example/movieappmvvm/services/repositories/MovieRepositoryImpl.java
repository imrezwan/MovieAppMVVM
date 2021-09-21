package com.example.movieappmvvm.services.repositories;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.movieappmvvm.R;
import com.example.movieappmvvm.services.models.MovieModel;
import com.example.movieappmvvm.services.models.Result;
import com.example.movieappmvvm.services.networks.MovieService;
import com.example.movieappmvvm.services.networks.RetrofitInstance;
import com.example.movieappmvvm.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepositoryImpl implements IMovieRepository{
    private MovieModel movieModel;
    private List<Result> movieResults;
    private MutableLiveData<List<Result>> mResultsLiveDatas;
    private static Context mContext;
    private static MovieRepositoryImpl instance;

    public static MovieRepositoryImpl getMovieRepository(Context context){
        if(instance == null){
            instance = new MovieRepositoryImpl();
            mContext = context;
        }
        return instance;
    }



    @Override
    public MutableLiveData<List<Result>> getTopRatedMovies(int pageNo) {

        if(mResultsLiveDatas == null){
            mResultsLiveDatas = new MutableLiveData<>();
        }

        MovieService movieService = RetrofitInstance.getRetrofitInstance().create(MovieService.class);
        Call<MovieModel> call = movieService.getTopRatedMovies(Constants.MOVIE_API_KEY, "en-US", pageNo);
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                movieModel = response.body();
                //Log.d("DATA", movieModel.getResults().get(0).toString());
                movieResults = movieModel.getResults();

                mResultsLiveDatas.postValue(movieResults);
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });

        return mResultsLiveDatas;
    }
}
