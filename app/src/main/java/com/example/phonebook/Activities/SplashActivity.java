package com.example.phonebook.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.phonebook.R;

public class SplashActivity extends AppCompatActivity {
    private static int splash_timeout = 8000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        ImageView logo =  findViewById(R.id.logo);

        logo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                blink(v);
            }

        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, splash_timeout);
    }

    public void blink(View view){
        ImageView logo = findViewById(R.id.logo);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        logo.startAnimation(animation);
    }
}
