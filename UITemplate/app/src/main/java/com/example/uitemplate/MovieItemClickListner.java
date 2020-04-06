package com.example.uitemplate;

import android.widget.ImageView;

public interface MovieItemClickListner {

    void onMovieClick(Movie movie, ImageView movieImageView); // we will need the image view to make the shared animation two activities

}
