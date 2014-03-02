package com.obrero.cmycountry.services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.obrero.cmycountry.R;
import com.obrero.cmycountry.activities.Home;

/**
 * Created by Eefret on 3/2/14.
 */
public class SplashScreen extends Activity {
    private static final int TIME = 4 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Home.class);
                finish();
                startActivity(intent);

                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        }, TIME);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, TIME);
    }

    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }
}