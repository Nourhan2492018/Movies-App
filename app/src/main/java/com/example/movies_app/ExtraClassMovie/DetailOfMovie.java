package com.example.movies_app.ExtraClassMovie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies_app.FavoriteDataMovies.MoviesSQL;
import com.example.movies_app.Model.MovieItem;
import com.example.movies_app.R;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;
public class DetailOfMovie extends AppCompatActivity {
  Button favorite;
    private RecyclerView mRecyclerView;
    MoviesSQL moviesSQL=new MoviesSQL(mRecyclerView.getContext());
  // MoviesSQL movie_data=new MoviesSQL(RecycleViewMovies);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);
            Intent intent=getIntent();
            final MovieItem movieDetail=intent.getParcelableExtra("Movie Click");
             /*imageUrl=intent.getStringExtra(EXTRA_URL);
            title=intent.getStringExtra(EXTRA_TITLE);
             origintitle=intent.getStringExtra(EXTRA_ORIGINTITLE);
             overview=intent.getStringExtra(EXTRA_OVERVIEW);*/
            ImageView imageView=findViewById(R.id.image_View_detail);
            TextView textView_title=findViewById(R.id.text_View_detail_title);
            TextView textView_orgintitle=findViewById(R.id.text_View_detail_origin);
            TextView textView_overview=findViewById(R.id.text_view_detail_overview);
            Picasso.with(this).load("https://image.tmdb.org/t/p/w500"+movieDetail.getmImageUrl()).fit().centerInside().into(imageView);
            textView_title.setText(movieDetail.getmTitle());
            textView_orgintitle.setText(movieDetail.getmOriginTitle());
            textView_overview.setText(movieDetail.getmOverview());
        MaterialFavoriteButton materialFavoriteButtonNice=(MaterialFavoriteButton)findViewById(R.id.favorite_button);
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        materialFavoriteButtonNice.setOnFavoriteChangeListener(
                new MaterialFavoriteButton.OnFavoriteChangeListener() {
                    @Override
                    public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
                        if(favorite)
                        {
                            SharedPreferences.Editor editor= (SharedPreferences.Editor) getSharedPreferences("com.example.movies_app.ExtraClassMovie.DetailOfMovie",MODE_PRIVATE).edit();
                            editor.putBoolean("Favorite Added",true);
                            editor.commit();
                            moviesSQL.inset_data_movie(movieDetail);
                            Snackbar.make(buttonView,"Added To Favorite",Snackbar.LENGTH_SHORT).show();
                        }
                        else
                        {
                            SharedPreferences.Editor editor= (SharedPreferences.Editor) getSharedPreferences("com.example.movies_app.ExtraClassMovie.DetailOfMovie",MODE_PRIVATE).edit();
                            editor.putBoolean("Favorite Removed",true);
                            editor.commit();
                            String id=moviesSQL.getid(movieDetail.getmTitle());
                              moviesSQL.deletFavorite(Integer.valueOf(id));
                            Snackbar.make(buttonView,"Removed From Favorite",Snackbar.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        }
    }

