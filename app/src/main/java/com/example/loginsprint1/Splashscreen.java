package com.example.loginsprint1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Primero vamos a bloquear la rotación de pantalla (Modo vertical)
        getSupportActionBar().hide();

        TimerTask timertask = new TimerTask() {
            @Override
            public void run() {
                Intent toLogin = new Intent(Splashscreen.this, LoginActivity.class);
                startActivity(toLogin);
            }
        };
        Timer timer = new Timer();
        timer.schedule(timertask, 3000);
    }
}