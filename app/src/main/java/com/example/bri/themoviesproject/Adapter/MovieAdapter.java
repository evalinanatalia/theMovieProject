package com.example.bri.themoviesproject.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.bri.themoviesproject.Model.MovieModel;
import com.example.bri.themoviesproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BRI on 11/08/2018.
 */

public class MovieAdapter extends BaseAdapter {
        Context context;
        List<MovieModel> movies = new ArrayList<>();

        public MovieAdapter(Context context, List<MovieModel> movies) {
                this.context = context;
                this.movies = movies;
        }

        @Override
        public int getCount() {
                return movies.size();
        }

        @Override
        public Object getItem(int i) {
                return movies.get(i);
        }

        @Override
        public long getItemId(int i) {
                return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
                if(view == null){
                        final LayoutInflater layoutInflater = LayoutInflater.from(context);
                        view = layoutInflater.inflate(R.layout.post_layout, null);
                }
                TextView title = (TextView) view.findViewById(R.id.title);
                TextView content= (TextView)view.findViewById(R.id.content);
                TextView author= (TextView)view.findViewById(R.id.author);
                ImageView imgView = (ImageView)view.findViewById(R.id.image_view);

                String baseUrl = "https://image.tmdb.org/t/p/w500/";
                title.setText(movies.get(i).getTitle().toString());
                content.setText(movies.get(i).getRelease_date().toString());
                author.setText(String.valueOf(movies.get(i).getOriginal_title()));
                Glide.with(context)
                        .load(baseUrl+""+movies.get(i).getPoster_path().toString())
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .into(imgView);

                return view;
        }

//
//@NonNull
//@Override
//public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//        .inflate(R.layout.post_layout, parent, false);
//        return new MovieViewHolder(view);
//        }
//
//@Override
//public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
//        String baseUrl = "https://image.tmdb.org/t/p/w500/";
//        holder.title.setText(movies.get(position).getTitle().toString());
//        holder.content.setText(movies.get(position).getRelease_date().toString());
//        holder.author.setText(String.valueOf(movies.get(position).getOriginal_title()));
//        Glide.with(context)
//                .load(baseUrl+""+movies.get(position).getPoster_path().toString())
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .into(holder.imgView);
//        }
//
//@Override
//public int getItemCount() {
//        return movies.size();
//        }
        }
