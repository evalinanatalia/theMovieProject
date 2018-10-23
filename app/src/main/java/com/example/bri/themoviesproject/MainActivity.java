package com.example.bri.themoviesproject;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.support.v7.widget.SearchView;
import android.widget.ProgressBar;
import android.widget.Switch;

import com.example.bri.themoviesproject.Adapter.MovieAdapter;
import com.example.bri.themoviesproject.Dialogs.DialogFilter;
import com.example.bri.themoviesproject.Listing.MoviesListingPresenter;
import com.example.bri.themoviesproject.Listing.MoviesListingView;
import com.example.bri.themoviesproject.Model.MovieModel;
import com.example.bri.themoviesproject.Model.PageModel;
import com.example.bri.themoviesproject.Retrofit.IMyAPI;
import com.example.bri.themoviesproject.Retrofit.RetrofitClient;
import com.example.bri.themoviesproject.Util.Utils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements MoviesListingView {
    MoviesListingPresenter moviesPresenter;
    public IMyAPI iMyAPI = null;
    GridView rows;
    ProgressBar progressBar;
    private Realm mRealm;
    List<MovieModel> pageModels = new ArrayList<>();

    private final static String API_KEY = "3b561a9deada4994d60aa22b621966e9";

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Realm.init(MainActivity.this);
        mRealm = Realm.getDefaultInstance();

        setContentView(R.layout.activity_main);
//        moviesPresenter.setView(this);

        Retrofit retrofit = RetrofitClient.getInstance();
        iMyAPI = retrofit.create(IMyAPI.class);

        rows = (GridView) findViewById(R.id.rows);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_cyclic);

        rows.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        fetchPosts("4");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem filter = menu.findItem(R.id.action_sort);
        MenuItem search = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                List<MovieModel> pageModelsSearch = new ArrayList<>();
                for (MovieModel movieModel : pageModels) {
                    if(movieModel.title.toLowerCase().contains(s.toLowerCase())) {
                        pageModelsSearch.add(movieModel);
                    }

                }
                displayData(pageModelsSearch);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;

            }
        });

        filter.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                DialogFilter dialogFilter = new DialogFilter(MainActivity.this);
                dialogFilter.initView();
                dialogFilter.callback(new OnCallback() {
                    @Override
                    public void setOnCallback(Object object) {
                        switch ((String) object)
                        {
                            case "1":
                                fetchPosts("1");
                                break;

                            case "2":
                                fetchPosts("2");
                                break;

                            case "3":
                                fetchPosts("3");
                                break;
                            case "4":
                                fetchPosts("4");
                                break;
                        }
                    }
                });
                return false;
            }
        });

        return true;
    }



    private void fetchPosts(String check) {
        Call<PageModel> pageModelCall = iMyAPI.getMovies_topRated(API_KEY);
        switch (check){
            case "1":
                pageModelCall = iMyAPI.getMovies_popular(API_KEY);
                break;
            case "2":
                pageModelCall = iMyAPI.getMovies_topRated(API_KEY);
                break;
            case "3":
                pageModelCall = iMyAPI.getMovies_topRated(API_KEY);
                break;
            case "4":
                pageModelCall = iMyAPI.getMovies_upcoming(API_KEY);
                break;

        }
        if (Utils.isConnected(this)) {
//            if(Utils.isInternetAvailable()) {
                pageModelCall.enqueue(new Callback<PageModel>() {
                    @Override
                    public void onResponse(Call<PageModel> call, Response<PageModel> response) {
                        pageModels = response.body().getResults();
                        displayData(pageModels);
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFailure(Call<PageModel> call, Throwable t) {
//                    Log.e("Error", t.toString());
                        Utils.getToastMessage(getBaseContext(), t.toString()).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });
//            }else {
//                progressBar.setVisibility(View.GONE);
//                Utils.getToastMessage(this, "Network Disconnect").show();
//            }
        }else{
            progressBar.setVisibility(View.GONE);
            Utils.getToastMessage(this, "Network is not available").show();
        }
    }

    private void displayData(List<MovieModel> movieModels) {
        MovieAdapter adapter = new MovieAdapter(this, movieModels);
        rows.setAdapter(adapter);
    }
    private void displayData() {
        List<MovieModel> movieModels=  mRealm.where(MovieModel.class).findAll();
        MovieAdapter adapter = new MovieAdapter(this, movieModels);
        rows.setAdapter(adapter);
    }

    @Override
    public void showMovies(List<MovieModel> movies) {

    }

    @Override
    public void loadingStarted() {

    }

    @Override
    public void loadingFailed(String errorMessage) {

    }

    @Override
    public void onMovieClicked(MovieModel movie) {

    }
}
