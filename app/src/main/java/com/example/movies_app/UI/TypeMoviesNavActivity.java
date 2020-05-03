package com.example.movies_app.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.example.movies_app.Adapters.MovieSlideAdapter;
import com.example.movies_app.FavoriteDataMovies.MoviesSQL;
import com.example.movies_app.R;

import java.util.ArrayList;

public class TypeMoviesNavActivity extends AppCompatActivity {
  /*  public static final String comaing = "https://api.themoviedb.org/3/movie/upcoming?api_key=32c913288edad9470662db02b7263518&language=en-US&page=1&fbclid=IwAR3oC6xHTCIVh1hCy7N6cE6J99HEPKkxj2DkJXgnAnfZ_PGhtdPOY6LYpB8";
    public static final String toprate = "https://api.themoviedb.org/3/movie/top_rated?api_key=32c913288edad9470662db02b7263518&language=en-US&page=1&fbclid=IwAR0dBW1V8h7V0nqcbC3Spy8SMJbnTsxNSfAknRuxMOGKqSDGUt6ir4-5ARM";
    public static final String action = "https://api.themoviedb.org/3/movie/now_playing?api_key=32c913288edad9470662db02b7263518&language=en-US&page=2&fbclid=IwAR0rykeE6C8-WA1a38IfWPm7qairgJ0lGbw6xjojms_gNEKE1-C0lTbKUNU";*/
    public static final String Link="https://api.themoviedb.org/3/movie/now_playing?api_key=32c913288edad9470662db02b7263518&language=en-US&page=";
    public MoviesSQL moviesSQL;
    private ViewPager mSlideViewPager;
    private MovieSlideAdapter slideAdapter;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mtoggle;
    private Intent intentmovies ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_movies);
        intentmovies = new Intent(getApplicationContext(), RecycleViewMovies.class);
        drawerLayout =findViewById(R.id.drawer);
        mtoggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mSlideViewPager=(ViewPager)findViewById(R.id.sliderviewPager);
        slideAdapter=new MovieSlideAdapter(getApplicationContext());
        mSlideViewPager.setAdapter(slideAdapter);
    }

   @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation, menu);
        return super.onCreateOptionsMenu(menu);
    }
    /*  if(mtoggle.onOptionsItemSelected(item))
           {
               return  true;
           }*/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.favorite_icon:
                ArrayList arrayList = moviesSQL.getArrayListFavorite();
                intentmovies.putCharSequenceArrayListExtra("data", arrayList);
                startActivity(intentmovies);
                break;
            case R.id.action_icon:
                intentmovies.putExtra("data", "https://api.themoviedb.org/3/movie/upcoming?api_key=32c913288edad9470662db02b7263518&language=en-US&page=1&fbclid=IwAR3oC6xHTCIVh1hCy7N6cE6J99HEPKkxj2DkJXgnAnfZ_PGhtdPOY6LYpB8");
                startActivity(intentmovies);
                break;
            case R.id.upcoming_icon:
                intentmovies.putExtra("data", "https://api.themoviedb.org/3/movie/top_rated?api_key=32c913288edad9470662db02b7263518&language=en-US&page=1&fbclid=IwAR0dBW1V8h7V0nqcbC3Spy8SMJbnTsxNSfAknRuxMOGKqSDGUt6ir4-5ARM");
                startActivity(intentmovies);
                break;
            case R.id.romatic_icon:
                intentmovies.putExtra("data",  "https://api.themoviedb.org/3/movie/now_playing?api_key=32c913288edad9470662db02b7263518&language=en-US&page=2&fbclid=IwAR0rykeE6C8-WA1a38IfWPm7qairgJ0lGbw6xjojms_gNEKE1-C0lTbKUNU");
                startActivity(intentmovies);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

