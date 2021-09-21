package com.example.movieappmvvm.services.networks;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    static Retrofit mInstance;
    private static String BASE_URL = "https://api.themoviedb.org/3/";

    //Singleton Design Pattern Implemented
    public static Retrofit getRetrofitInstance(){
        if(mInstance==null){
            mInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mInstance;
    }
}
