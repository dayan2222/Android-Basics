package com.example.uitemplate.adapters;

import android.widget.ImageView;

import com.example.uitemplate.models.Movie;

public interface MovieItemClickListner {

    void onMovieClick(Movie movie, ImageView movieImageView); // we will need the image view to make the shared animation two activities

}
