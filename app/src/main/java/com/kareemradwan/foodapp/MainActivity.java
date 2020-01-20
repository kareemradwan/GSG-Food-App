package com.kareemradwan.foodapp;

import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.kareemradwan.foodapp.ui.start.OnBoardingActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    startActivity(new Intent(MainActivity.this, OnBoardingActivity.class));
                    finish();
                } catch (Exception e) {
                    Log.d("DDDD", "Ex " + e.getLocalizedMessage());
                }
            }
        }).start();
    }
}
