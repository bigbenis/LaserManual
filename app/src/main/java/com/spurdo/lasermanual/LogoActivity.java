package com.spurdo.lasermanual;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class LogoActivity extends Activity {
    private Animation logoAnim;
    private ImageView logoImage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_activity);
        init();
        startMainActivity();
    }

    @SuppressLint("WrongViewCast")
    private void init() {
        logoAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logo_anim);
        logoImage = findViewById(R.id.logoView);
        //start animation
        logoImage.startAnimation(logoAnim);
    }

    public void onClickStart(View view) {
        Intent i = new Intent(LogoActivity.this, MainActivity.class);
        startActivity(i);
        onDestroy();
    }

    private void startMainActivity() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent i = new Intent(LogoActivity.this, MainActivity.class);
                startActivity(i);
            }
        }).start();
    }

}
