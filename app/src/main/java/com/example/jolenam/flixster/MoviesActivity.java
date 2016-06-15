package com.example.jolenam.flixster;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MoviesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        // 1. Get actual movies
        ArrayList<Movie> movies = Movie.getFakeMovies();

        // 2. Get the ListView we want to populate
        ListView lvMovies = (ListView) findViewById(R.id.lvMovies);

        // 3. Create an ArrayAdapter
        // below is old, generic adapter:
        // ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(this, android.R.layout.simple_list_item_1, movies);

       //new customized adapter we just created:
        MoviesAdapter adapter = new MoviesAdapter(this, movies);

        // 4. Associate the adapter with the ListView
        if (lvMovies != null) {
            lvMovies.setAdapter(adapter);
        }
    }
}
