package com.example.bri.themoviesproject.Retrofit;

import com.example.bri.themoviesproject.BuildConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by BRI on 11/08/2018.
 */

public class RetrofitClient{
    private static Retrofit ourInstance;

    public static Retrofit getInstance()
    {
        if(ourInstance == null){
            ourInstance = new Retrofit.Builder()
                    .baseUrl(BuildConfig.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return ourInstance;
    }

    private RetrofitClient() {

    }
}
