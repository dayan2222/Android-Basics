package com.example.uitemplate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);


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
