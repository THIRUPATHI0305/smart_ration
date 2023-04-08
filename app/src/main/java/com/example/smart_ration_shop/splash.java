package com.example.smart_ration_shop;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splash extends AppCompatActivity {

    Animation zoomIn, slideIn;
    ImageView logo;
    ImageView animVec;
    TextView title;

    @SuppressLint({"MissingInflatedId", "ResourceType", "ObsoleteSdkInt"})
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );

        getWindow().setStatusBarColor(Color.TRANSPARENT);

        zoomIn = AnimationUtils.loadAnimation(this, R.animator.zoom_in);
        slideIn = AnimationUtils.loadAnimation(this, R.animator.slide_in_bottom);

        logo = findViewById(R.id.logo12);
        animVec = findViewById(R.id.animatedVector12);
        title = findViewById(R.id.title12);

        if (logo != null && animVec != null && title != null) {
            logo.setVisibility(View.VISIBLE);
            animVec.setVisibility(View.VISIBLE);
            title.setVisibility(View.VISIBLE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                AnimatedVectorDrawable drawable = (AnimatedVectorDrawable) animVec.getDrawable();
                drawable.start();
            }
            logo.startAnimation(zoomIn);
            title.startAnimation(slideIn);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(splash.this, login.class);
                    startActivity(i);
                }
            }, 5000);
        } else {
            Log.e("splash", "One or more views are null.");
        }
    }
}
