package com.example.movieappmvvm.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieappmvvm.R;
import com.example.movieappmvvm.services.models.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TopMovieAdapter extends RecyclerView.Adapter<TopMovieAdapter.TopViewHolder> {

    Context context;
    List<Result> movielist;

    public TopMovieAdapter(Context context, List<Result> movielist) {
        this.context = context;
        this.movielist = movielist;
    }

    @NonNull
    @Override
    public TopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_movie, null);


        return new TopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopViewHolder holder, int position) {

        holder.mTitle.setText(movielist.get(position).getTitle());
        holder.mRating.setText(movielist.get(position).getVoteAverage()+"");
        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+movielist.get(position).getPosterPath())
                .into(holder.movieImage);

    }

    @Override
    public int getItemCount() {
        return movielist.size();
    }

    public class TopViewHolder extends RecyclerView.ViewHolder {
        ImageView movieImage;
        TextView mTitle, mRating;
        public TopViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.iv_movie_image);
            mTitle = itemView.findViewById(R.id.tv_movie_title);
            mRating = itemView.findViewById(R.id.tv_vote_rate);
        }
    }
}
