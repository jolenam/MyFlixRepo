package com.example.jolenam.flixster.models;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Movie {

    String posterPath;
    String backdropPath;
    String originalTitle;
    String overview;
    Double score;
    String releaseDate;

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w780/%s", backdropPath);
    }

    public String getScore() {
        return score + " / 10";
    }

    public String getRating() { return "" + ((score / 2) % 10); }

    public String getReleaseDate() {
        return "Release Date: " + releaseDate;
    }

    public boolean isPopular() {
        return score > 5.0;
    }


    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterPath = jsonObject.getString("poster_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.score = jsonObject.getDouble("vote_average");
        this.releaseDate = jsonObject.getString("release_date");
    }

    // accept list of JSON movies; convert each element
    // in JSONArray moviesJsonResults to a Movie object
    public static ArrayList<Movie> fromJSONArray(JSONArray array) {
        ArrayList<Movie> results = new ArrayList<>();

        for(int x = 0; x < array.length(); x++) {
            try {
                results.add(new Movie(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return results;
    }
}
