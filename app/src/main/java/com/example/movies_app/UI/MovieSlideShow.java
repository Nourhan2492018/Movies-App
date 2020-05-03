package com.example.movies_app.UI;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.movies_app.Adapters.MovieSlideAdapter;
import com.example.movies_app.R;

public class MovieSlideShow extends AppCompatActivity {
    private ViewPager mSlideViewPager;
    private LinearLayout linearLayout;
    private MovieSlideAdapter slideAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speechscreen);
        mSlideViewPager=(ViewPager)findViewById(R.id.sliderviewPager);
        slideAdapter=new MovieSlideAdapter(getApplicationContext());
        mSlideViewPager.setAdapter(slideAdapter);
    }
}
