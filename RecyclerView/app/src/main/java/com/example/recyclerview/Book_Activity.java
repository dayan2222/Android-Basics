package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Book_Activity extends AppCompatActivity {

    private TextView tvtitle,tvcategory,tvdescription;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_);

        tvtitle = (TextView) findViewById(R.id.txt_title);
        tvcategory = (TextView) findViewById(R.id.txt_category);
        tvdescription = (TextView) findViewById(R.id.txt_description);
        img = (ImageView) findViewById(R.id.bookthumbnail);

        // Receive data
        Intent intent  = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail");

        // Setting Values

        tvtitle.setText(Title);
        tvdescription.setText(Description);
        img.setImageResource(image);


    }
}
