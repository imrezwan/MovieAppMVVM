package com.example.movieappmvvm.services.networks;

import com.example.movieappmvvm.services.models.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    @GET("movie/top_rated")//?api_key=&language=en-US&page=1
    Call<MovieModel> getTopRatedMovies(@Query("api_key") String api_key,
                                       @Query("language") String Lang,
                                       @Query("page") int page_no);


}
