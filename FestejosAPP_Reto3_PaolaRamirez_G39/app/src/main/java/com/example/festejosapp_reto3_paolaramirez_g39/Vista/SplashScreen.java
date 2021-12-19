package com.example.festejosapp_reto3_paolaramirez_g39.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.festejosapp_reto3_paolaramirez_g39.Controlador.MainActivity;
import com.example.festejosapp_reto3_paolaramirez_g39.R;

public class SplashScreen extends AppCompatActivity implements Runnable {

    Thread h1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        ImageView logo = (ImageView)findViewById(R.id.logoSplash);
        logo.setBackgroundResource(R.drawable.logo);

        AnimationDrawable ejecutarAnim = (AnimationDrawable)logo.getBackground();
        ejecutarAnim.start();

        //***********************
        h1= new Thread(this);
        h1.start();
        //***********************

    }

    @Override
    public void run() {
        try {
            // valida conexion a internet
            // valida conexion con oracle
            // valida cargue de mapas
            Thread.sleep(5000);
            Intent pasarPantalla = new Intent(getApplicationContext(), MainActivity.class );
            startActivity(pasarPantalla);
        } catch (InterruptedException e) {
            e.printStackTrace();

    }
    }
}