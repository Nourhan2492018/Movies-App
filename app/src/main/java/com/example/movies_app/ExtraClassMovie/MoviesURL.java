package com.example.movies_app.ExtraClassMovie;

import android.content.Context;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.movies_app.Adapters.MovieAdapter;
import com.example.movies_app.Model.CardOnClickMovie;
import com.example.movies_app.Model.MovieItem;
import com.example.movies_app.R;
import com.example.movies_app.UI.RecycleViewMovies;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

 public class MoviesURL {

    public ArrayList<MovieItem> parseJSON(String url,Context context)//string url;parmeter for 3 linked//
    {
        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        RequestQueue mRequestQueue= Volley.newRequestQueue(context);
         final ArrayList<MovieItem> Movielist = new ArrayList<MovieItem>();
      //  Log.e("parseJSON: ","nour" );
        JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("results");
                            for (int i=0; i<jsonArray.length();i++)
                            {
                                JSONObject object =jsonArray.getJSONObject(i);
                                MovieItem movieItem=new MovieItem();
                                movieItem.setId(i);
                                movieItem.setmImageUrl(object.getString("poster_path"));
                                movieItem.setmTitle(object.getString("title"));
                                movieItem.setmOriginTitle(object.getString("release_date"));
                                movieItem.setmOverview(object.getString("overview"));

                                Movielist.add(movieItem);
                                /*
                                String title=object.getString("title");
                                String origin_title=object.getString("release_date");
                                String imageUrl=object.getString("poster_path");
                                String overview=object.getString("overview");*/

                            }
                            System.out.println(String.valueOf(Movielist.size()));

                        }
                        catch ( JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }

        });
        //TODO:???
        mRequestQueue.add(request);
        return Movielist;
    }
}
