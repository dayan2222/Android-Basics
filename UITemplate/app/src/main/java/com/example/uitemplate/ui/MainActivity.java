package com.example.uitemplate.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.uitemplate.models.Movie;
import com.example.uitemplate.adapters.MovieAdapter;
import com.example.uitemplate.adapters.MovieItemClickListner;
import com.example.uitemplate.R;
import com.example.uitemplate.models.Slide;
import com.example.uitemplate.adapters.SliderPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListner {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView MovieRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        MovieRV = findViewById(R.id.RV_movies);
//        list of slider here
        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.bungalows1, "Bunalow Title \n more text here"));
        lstSlides.add(new Slide(R.drawable.bunglows2, "Bunalow Title \n more text here"));
        lstSlides.add(new Slide(R.drawable.bungalows1, "Bunalow Title \n more text here"));
        lstSlides.add(new Slide(R.drawable.bunglows2, "Bunalow Title \n more text here"));
        lstSlides.add(new Slide(R.drawable.bungalows1, "Bunalow Title \n more text here"));
        lstSlides.add(new Slide(R.drawable.bunglows2, "Bunalow Title \n more text here"));
        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);
        sliderpager.setAdapter(adapter);
        indicator.setupWithViewPager(sliderpager,true);
        // setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MainActivity.SliderTimer(),4000,6000);

        // Recyclerview Setup
        // ini data

        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Dubai",R.drawable.thumb_dubai,R.drawable.bunglows2));
        lstMovies.add(new Movie("Africa",R.drawable.thumb_africa,R.drawable.bunglows2));
        lstMovies.add(new Movie("Egypt",R.drawable.thumb_egipt));
        lstMovies.add(new Movie("Hawai",R.drawable.thumb_hawaii));
        lstMovies.add(new Movie("Machupicchu",R.drawable.thumb_machupicchu));
        lstMovies.add(new Movie("Santorini",R.drawable.thumb_santorini));

        MovieAdapter movieAdapter = new MovieAdapter(this,lstMovies, this);
        MovieRV.setAdapter(movieAdapter);
        MovieRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
        // here we send movie information to detail activity
        // also we'll create the transition animation between the two activity

        Intent intent = new Intent(this, movie_details.class);
        // send movie information to detail Activity
        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgURL", movie.getThumbnail());
        intent.putExtra("imgCover", movie.getCoverPhoto());

        // lets create animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, movieImageView,"sharedName");
        startActivity(intent,options.toBundle());
        // make a simple test to see if the click listner is working or not
        Toast.makeText(this, "item clicked :" + movie.getTitle(),Toast.LENGTH_LONG).show();
    }

    class SliderTimer extends TimerTask {

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem()<lstSlides.size()-1){
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    }
                    else
                        sliderpager.setCurrentItem(0);
                }
            });
        }
    }
}
