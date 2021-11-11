package com.example.loginsprint1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    //Metodo para el boton ingreso

    public void Ingres(View view){

        Intent ingres = new Intent (this, IngresActivity.class);
        startActivity(ingres);

    }
    //Metodo para el boton registro

    public void Register(View view){
        Intent register = new Intent (this, RegisterActivity.class);
        startActivity(register);
    }
}