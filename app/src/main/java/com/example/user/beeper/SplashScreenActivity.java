package com.example.user.beeper;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.view.ViewGroup;

import com.example.user.beeper.utils.Constanta;
import com.example.user.beeper.utils.FontChangeCrawler;

public class SplashScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), Constanta.Jenis_Font);
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));
        setView();
    }

    public void setView()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1700);
    }

}
