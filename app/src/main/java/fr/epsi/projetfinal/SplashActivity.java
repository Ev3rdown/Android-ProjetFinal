package fr.epsi.projetfinal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class SplashActivity extends ProjetActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                HomeActivity.displayActivity(SplashActivity.this);
                finish();
            }
        },1000);
    }
}