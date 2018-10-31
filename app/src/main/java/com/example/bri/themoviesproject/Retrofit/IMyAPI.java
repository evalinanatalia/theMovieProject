package com.example.bri.themoviesproject.Retrofit;

import com.example.bri.themoviesproject.Model.MovieModel;
import com.example.bri.themoviesproject.Model.PageModel;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by BRI on 11/08/2018.
 */

public interface IMyAPI {
    @GET("popular")
    Call<PageModel> getMovies_popular(
            @Query("api_key") String api_Key
    );

    @GET("top_rated")
    Call<PageModel> getMovies_topRated(
            @Query("api_key") String api_Key
    );

    @GET("upcoming")
    Call<PageModel> getMovies_upcoming(
            @Query("api_key") String api_Key
    );

    @GET("{movieId}")
    Call<MovieModel> getMovie_detail(
            @Path("movieId") String movieId,
            @Query("api_key") String api_Key

    );

}
