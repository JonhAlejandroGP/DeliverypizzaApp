package com.example.loginsprint1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private  TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=(TextView) findViewById(R.id.Welcomeid);
        tv2=(TextView) findViewById(R.id.textView12);
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            tv2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
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

    public void irMapa(View v)
    {
        Intent newIntent = new Intent(this, MapsActivity.class);
        newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(newIntent);
    }

    //crear menu de navegación
    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        //Infla el menu y la actividad y se asegura cual menu poner
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_navegacion, menu);
        //getMenuInflater().inflate(R.menu.menu_nav, menu);
        return true;
    }

    //Estar atento cuando el usuario toca algun aparte de la pantalla grande
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        //Variable almacena un codigo del el usuario cuando toque un boton
        int id = menuItem.getItemId();
        if (id == R.id.vista_compras) {
            Intent newIntent = new Intent(this, CompraActivity.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);
            return super.onOptionsItemSelected(menuItem);
        }else if (id == R.id.vista_menu){
            Intent newIntent = new Intent(this, MenuActivity.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);
            return super.onOptionsItemSelected(menuItem);
        } else if (id==R.id.Cierra_sesion){
            FirebaseAuth.getInstance().signOut();
            LoginManager.getInstance().logOut();
            Intent newIntent = new Intent(this, LoginActivity.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(newIntent);
            return super.onOptionsItemSelected(menuItem);
        }else if (id == R.id.lista_pedidos){
            Intent newIntent = new Intent(this, PedidoActivity.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);
            return super.onOptionsItemSelected(menuItem);
        }else if(id== R.id.vista_map){
            Intent newIntent = new Intent(this, MapsActivity.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);
            return super.onOptionsItemSelected(menuItem);
        }
        else if(id== R.id.vista_perfil){
            Intent newIntent = new Intent(this, PerfilActivity.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(newIntent);
            return super.onOptionsItemSelected(menuItem);
        }
        else {
            return super.onOptionsItemSelected(menuItem);
        }
    }
}