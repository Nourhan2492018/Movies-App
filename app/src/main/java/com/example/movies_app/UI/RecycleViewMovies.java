package com.example.movies_app.UI;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.Volley;
import com.example.movies_app.Adapters.MovieAdapter;
import com.example.movies_app.ExtraClassMovie.DetailOfMovie;
import com.example.movies_app.ExtraClassMovie.MoviesURL;
import com.example.movies_app.Model.CardOnClickMovie;
import com.example.movies_app.Model.MovieItem;
import com.example.movies_app.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;

import java.io.Serializable;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.net.ssl.SSLContext;

public class RecycleViewMovies extends AppCompatActivity implements CardOnClickMovie {

    private RecyclerView mRecyclerView;
    private MovieAdapter mExampleAdapter;
    private ArrayList<MovieItem>mExamplelist;
   private MoviesURL url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            ///???
            ProviderInstaller.installIfNeeded(getApplicationContext());
            SSLContext sslContext;
            sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, null, null);
            sslContext.createSSLEngine();
        } catch ( GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException
                | NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
        Intent intent=getIntent();
        ArrayList arrayList=intent.getIntegerArrayListExtra("data");
      //  String URL=intent.getStringExtra("data");
        url=new MoviesURL();
        setContentView(R.layout.recycle_view_movies);
        mRecyclerView=findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);//
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//??
        mExamplelist=new ArrayList<MovieItem>();
      //mRequestQueue= Volley.newRequestQueue(this);
        String d=intent.getStringExtra("data");

        Toast.makeText(getApplicationContext(),d,Toast.LENGTH_LONG).show();
        mExamplelist=url.parseJSON(d,this);
        int u=mExamplelist.size();
        //System.out.println(u);
        Toast.makeText(getApplicationContext(),""+String.valueOf(u) , Toast.LENGTH_LONG).show();
        mExampleAdapter = new MovieAdapter(RecycleViewMovies.this, mExamplelist);
        mRecyclerView.setAdapter(mExampleAdapter);
        //Animation Active code
        LayoutAnimationController controller = null;
        Context context = mRecyclerView.getContext();

        controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_slide_bottom);
        mRecyclerView.setLayoutAnimation(controller);
        mRecyclerView.getAdapter().notifyDataSetChanged();
        mRecyclerView.scheduleLayoutAnimation();
        //
        mExampleAdapter.setOnItemClickListner((CardOnClickMovie) RecycleViewMovies.this);
    }

    @Override
    public void OnClickMovieItem(int position) {
        Intent datailIntent =new Intent(this, DetailOfMovie.class);
        MovieItem clickitem=mExamplelist.get(position);
        datailIntent.putExtra("Movie Click", (Serializable) clickitem);
        startActivity(datailIntent);
    }
}
