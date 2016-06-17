package com.example.jolenam.flixster.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jolenam.flixster.R;
import com.example.jolenam.flixster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public int getViewTypeCount() {
        return 2;
    }

    public int getItemViewType(int position) {
        Movie movie = getItem(position);
        if (movie.isPopular()) { return 0; }
        else { return 1; }
    }


    public static class ViewHolder {
        ImageView ivPoster;
        TextView tvTitle;
        TextView tvOverview;
        TextView tvScore;
    }

    public static class ViewHolderPop {
        ImageView ivPopPoster;
    }

    public MovieArrayAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the data item for position
        Movie movie = getItem(position);
        int viewType = this.getItemViewType(position);

        if (viewType == 1) {

            //check existing view being reused
            ViewHolder viewHolder;
            if (convertView == null) {


                viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.item_movie, parent, false);

                ImageView ivPoster = (ImageView) convertView.findViewById(R.id.ivPoster);
                TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
                TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);
                TextView tvScore = (TextView) convertView.findViewById(R.id.tvScore);

                viewHolder.ivPoster = ivPoster;
                viewHolder.tvTitle = tvTitle;
                viewHolder.tvOverview = tvOverview;
                viewHolder.tvScore = tvScore;

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.ivPoster.setImageResource(0);
            viewHolder.tvTitle.setText(movie.getOriginalTitle());
            viewHolder.tvOverview.setText(movie.getOverview());
            viewHolder.tvScore.setText(movie.getScore());

            boolean isLandscape = getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

            if (isLandscape) {
                Picasso.with(getContext()).load(movie.getBackdropPath()).transform(new RoundedCornersTransformation(5, 5)).placeholder(R.drawable.placeholder_image).into(viewHolder.ivPoster);
            } else {
                Picasso.with(getContext()).load(movie.getPosterPath()).transform(new RoundedCornersTransformation(5, 5)).placeholder(R.drawable.placeholder_image).into(viewHolder.ivPoster);
            }
            // return the view that just got populated
            return convertView;
        }

        else {
            //check existing view being reused
            ViewHolderPop viewHolderPop;

            if (convertView == null) {
                viewHolderPop = new ViewHolderPop();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.item_movie_popular, parent, false);

                ImageView ivPopPoster = (ImageView) convertView.findViewById(R.id.ivPopPoster);


                viewHolderPop.ivPopPoster = ivPopPoster;


                convertView.setTag(viewHolderPop);
            } else {
                viewHolderPop = (ViewHolderPop) convertView.getTag();
            }

            Picasso.with(getContext()).load(movie.getBackdropPath()).transform(new RoundedCornersTransformation(5, 5)).into(viewHolderPop.ivPopPoster);

            // return the view that just got populated
            return convertView;
        }

    }



}
