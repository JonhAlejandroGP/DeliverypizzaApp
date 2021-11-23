package com.example.loginsprint1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.login.LoginManager;
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

    //crear menu de navegación
    public boolean onCreateOptionsMenu (Menu menu) {
        //Infla el menu y la actividad y se asegura cual menu poner
        getMenuInflater().inflate(R.menu.menu_navegacion, menu);
        return true;
    }

    //Estar atento cuando el usuario toca algun aparte de la pantalla grande
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        //Variable almacena un codigo del el usuario cuando toque un boton
        int id = menuItem.getItemId();
        if (id == R.id.vista_compras) {
            Intent newIntent = new Intent(this, CompraActivity.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            //newIntent.putExtra("usuario","El usuario inicio sesión");
            //newIntent.putExtra("numero",2021);
            startActivity(newIntent);

            return super.onOptionsItemSelected(menuItem);
        }else if (id == R.id.vista_menu){
            Intent newIntent = new Intent(this, MenuActivity.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            //newIntent.putExtra("usuario","El usuario inicio sesión");
            //newIntent.putExtra("numero",2021);
            startActivity(newIntent);

            return super.onOptionsItemSelected(menuItem);
        } else if (id==R.id.Cierra_sesion){
            FirebaseAuth.getInstance().signOut();
            LoginManager.getInstance().logOut();
            Intent newIntent = new Intent(this, LoginActivity.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(newIntent);
            return super.onOptionsItemSelected(menuItem);
        }
        else {
            return super.onOptionsItemSelected(menuItem);
        }
    }
}