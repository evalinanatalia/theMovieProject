package com.example.bri.themoviesproject.Listing.Sorting;

/**
 * @author arun
 */
public interface SortingDialogPresenter
{
    void setLastSavedOption();

    void onPopularMoviesSelected();

    void onHighestRatedMoviesSelected();

    void onFavoritesSelected();

    void onNewestMoviesSelected();

    void setView(SortingDialogView view);

    void destroy();
}
