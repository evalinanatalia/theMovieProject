package com.example.bri.themoviesproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.bri.themoviesproject.Model.MovieModel;
import com.example.bri.themoviesproject.Model.PageModel;
import com.example.bri.themoviesproject.Retrofit.IMyAPI;
import com.example.bri.themoviesproject.Retrofit.RetrofitClient;
import com.example.bri.themoviesproject.Util.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by BRI on 30/10/2018.
 */

public class DetailMovieActivity extends AppCompatActivity{
    public IMyAPI iMyAPI = null;
    private final static String API_KEY = "3b561a9deada4994d60aa22b621966e9";
    String movie_id = "";
    MovieModel movieModel;
    ImageView imageView;
    TextView vote, title, overview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movie_activity);
        Bundle b = getIntent().getExtras();
        if(b != null) {
            movie_id = b.getString("movie_id");
        }
        imageView = (ImageView) findViewById(R.id.image_view);
        vote = (TextView) findViewById(R.id.vote);
        title = (TextView) findViewById(R.id.title);
        overview = (TextView) findViewById(R.id.overview);

        Retrofit retrofit = RetrofitClient.getInstance();
        iMyAPI = retrofit.create(IMyAPI.class);
        Call<MovieModel> MovieDetail_Call = iMyAPI.getMovie_detail(movie_id, API_KEY);
        if (Utils.isConnected(this)) {
            MovieDetail_Call.enqueue(new Callback<MovieModel>() {
                @Override
                public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                    movieModel = response.body();
                    vote.setText(movieModel.getVote_average()+"");
                    title.setText(movieModel.getTitle());
                    overview.setText(movieModel.getOverview());
                    Glide.with(DetailMovieActivity.this)
                            .load(BuildConfig.URL_BASE_IMAGE+""+movieModel.getPoster_path().toString())
                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                            .into(imageView);
                }

                @Override
                public void onFailure(Call<MovieModel> call, Throwable t) {
//                    Log.e("Error", t.toString());
                    Utils.getToastMessage(getBaseContext(), t.toString()).show();
                }
            });
        }else{
            //progressBar.setVisibility(View.GONE);
            Utils.getToastMessage(this, "Network is not available").show();
        }
    }
}
