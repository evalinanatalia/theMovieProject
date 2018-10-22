package com.example.bri.themoviesproject.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bri.themoviesproject.R;

/**
 * Created by BRI on 11/08/2018.
 */

public class MovieViewHolder extends RecyclerView.ViewHolder{
    TextView title, content, author;
    ImageView imgView;

    public MovieViewHolder(View itemView){
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.title);
        content = (TextView) itemView.findViewById(R.id.content);
        author = (TextView) itemView.findViewById(R.id.author);
        imgView = (ImageView) itemView.findViewById(R.id.image_view);

    }

}
