package com.example.jolenam.flixster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MoreInfoActivity extends AppCompatActivity {

    TextView tvMoreTitle;
    TextView tvRelease;
    TextView tvMoreOverview;
    ImageView ivMorePoster;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);

        tvMoreTitle = (TextView) findViewById(R.id.tVMoreTitle);
        String title = getIntent().getStringExtra("title");
        tvMoreTitle.setText(title);

        tvRelease = (TextView) findViewById(R.id.tvRelease);
        String release = getIntent().getStringExtra("release");
        tvRelease.setText(release);

        tvMoreOverview = (TextView) findViewById(R.id.tvMoreOverview);
        String overview = getIntent().getStringExtra("overview");
        tvMoreOverview.setText(overview);

        ivMorePoster = (ImageView) findViewById(R.id.ivMorePoster);
        String posterUrl = getIntent().getStringExtra("posterUrl");
        Picasso.with(this).load(posterUrl).into(ivMorePoster);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        String rating = getIntent().getStringExtra("rating");

        ratingBar.setRating(Float.parseFloat(rating));
    }

}
