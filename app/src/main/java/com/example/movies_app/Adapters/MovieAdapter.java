package com.example.movies_app.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies_app.Model.CardOnClickMovie;
import com.example.movies_app.Model.MovieItem;
import com.example.movies_app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieView> {
    private Context mcontext;
    private ArrayList<MovieItem> MoviesList;
    private CardOnClickMovie clickMovie;

    public  void setOnItemClickListner(CardOnClickMovie listner)
    {
        clickMovie =listner;

    }
    public MovieAdapter(Context context, ArrayList<MovieItem>movieItemArrayList)
    {
        mcontext=context;
        MoviesList =movieItemArrayList;

    }

    @NonNull
    @Override
    public MovieView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mcontext).inflate(R.layout.movie_item,parent,false);
        return new MovieView(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieView holder, int position) {
        MovieItem movieItem= MoviesList.get(position);
        holder.mTextViewTitle.setText(movieItem.getmTitle());
        holder.mViewOriginTitle.setText(movieItem.getmOriginTitle());
        holder.mViewOvrerview.setText(movieItem.getmOverview());
        Picasso.with(mcontext).load("https://image.tmdb.org/t/p/w500"+movieItem.getmImageUrl()).fit().centerInside().into(holder.mIamageView);
    }

    @Override
    public int getItemCount() {
        return MoviesList.size();
    }

        public class MovieView extends RecyclerView.ViewHolder{
        public ImageView mIamageView;
        public TextView mTextViewTitle;
        public TextView   mViewOvrerview;
        public TextView   mViewOriginTitle;
        public MovieView(@NonNull View ItemMovie) {
            super(ItemMovie);
            mIamageView=ItemMovie.findViewById(R.id.image_view);
            mTextViewTitle=ItemMovie.findViewById(R.id.text_View_detail_title);
            mViewOvrerview=ItemMovie.findViewById(R.id.text_view_detail_overview);
            mViewOriginTitle=ItemMovie.findViewById(R.id.text_View_detail_origin);

            ItemMovie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(clickMovie !=null)
                    {
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {
                            clickMovie.OnClickMovieItem(position);
                        }
                    }
                }
            });
        }
    }

}


