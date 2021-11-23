package com.example.loginsprint1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

public class CompraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);

        //Activar soporte para el actionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //Estar atento cuando el usuario toca algun aparte de la pantalla grande
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        //Variable almacena un codigo del el usuario cuando toque un boton
        int id = menuItem.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}