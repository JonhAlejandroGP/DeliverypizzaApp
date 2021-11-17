package com.example.loginsprint1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=(TextView) findViewById(R.id.Welcomeid);



    }

    @Override
    protected void onStart()
    {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String nombre = "hola " + user.getEmail();
            tv1.setText(nombre);
        }

    }
    /*//Metodo para el boton ingreso

    public void Ingres(View view){

        Intent ingres = new Intent (this, IngresActivity.class);
        startActivity(ingres);

    }
    //Metodo para el boton registro

    public void Register(View view){
        Intent register = new Intent (this, RegisterActivity.class);
        startActivity(register);
    }*/
}