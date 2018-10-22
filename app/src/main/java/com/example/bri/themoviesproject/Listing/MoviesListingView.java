package com.example.bri.themoviesproject.Listing;

import com.example.bri.themoviesproject.Model.MovieModel;

import java.util.List;

/**
 * @author arun
 */
public interface MoviesListingView
{
    void showMovies(List<MovieModel> movies);
    void loadingStarted();
    void loadingFailed(String errorMessage);
    void onMovieClicked(MovieModel movie);
}
