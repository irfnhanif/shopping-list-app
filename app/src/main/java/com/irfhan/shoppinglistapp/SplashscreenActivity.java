package com.irfhan.shoppinglistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class SplashscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen_layout);

        getSupportActionBar().hide();

        Handler h = new Handler(Looper.getMainLooper());
        h.postDelayed(()->{
            Intent i = new Intent(SplashscreenActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        }, 500);
    }
}