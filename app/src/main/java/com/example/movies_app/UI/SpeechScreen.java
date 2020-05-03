package com.example.movies_app.UI;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.movies_app.R;

public class SpeechScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speechscreen);
        Thread thread=new Thread(){
            @Override
            public void run(){
                try {
                    sleep(3000);
                    Intent russplash=new Intent(getApplicationContext(), TypeMoviesNavActivity.class);
                    startActivities(new Intent[]{russplash});
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }}};
        thread.start();

    }
}
