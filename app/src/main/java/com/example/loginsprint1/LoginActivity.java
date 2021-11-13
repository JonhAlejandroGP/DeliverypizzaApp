package com.example.loginsprint1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    //Se identifican los componentes visuales
    TextInputEditText usuario, contraseña;
    MaterialButton btnlogin;

    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Se asigna a cada componente un elemento de la vista
        usuario = findViewById(R.id.user_edit_text);
        contraseña = findViewById(R.id.password_edit_text);
        btnlogin = findViewById(R.id.next_button);
    }

    //Se crea una función para determinar que el correo si sea valido
    public void login(View v){
        email =  usuario.getText().toString();
        password = contraseña.getText().toString();
        int accountant = 0, acc = 0;
        char symbol = '@';
        char point = '.';
        if (email.length() == 0 | password.length() == 0){
            Toast.makeText(this, "El correo electrónico y/o contraseña están vacíos", Toast.LENGTH_LONG).show();
            usuario.setText("");
            contraseña.setText("");
        }else {
            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == symbol) {
                    accountant = accountant + 1;
                } else if (email.charAt(i) == point) {
                    acc = acc + 1;
                }
            }
            if (accountant > 1 | accountant < 1 | acc > 1 | acc < 1) {
                Toast.makeText(this, "El correo electrónico no es valido", Toast.LENGTH_LONG).show();
                usuario.setText("");
                contraseña.setText("");
            } else {
                Toast.makeText(this, "Ya se puede validar el usuario en la BD", Toast.LENGTH_SHORT).show();
            }
        }
    }
}