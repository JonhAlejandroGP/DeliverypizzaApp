package com.example.loginsprint1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    //Se identifican los componentes visuales
    TextInputEditText usuario, contraseña;
    TextInputLayout inputUsuario;
    MaterialButton btnlogin;
    private FirebaseAuth mAuth;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Se asigna a cada componente un elemento de la vista
        usuario = findViewById(R.id.user_edit_text);
        contraseña = findViewById(R.id.password_edit_text);
        inputUsuario = findViewById(R.id.user_text_input);
        btnlogin = findViewById(R.id.next_button);
        mAuth = FirebaseAuth.getInstance();
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
                inputUsuario.setError("El correo electrónico no es valido");
                usuario.setText("");
                contraseña.setText("");
            } else {
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                   // Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                   // Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(LoginActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }
                            }
                        });
                //Toast.makeText(this, "Ya se puede validar el usuario en la BD", Toast.LENGTH_SHORT).show();

            }
        }
    }
    public void updateUI(FirebaseUser user){
        if(user!=null)
        {
            Intent newIntent = new Intent(this, MainActivity.class);
            startActivity(newIntent);
            finish();
        }
    }
    public void toRegister(View v){
        Intent toRegisterActivity = new Intent(this, RegisterActivity.class);
        startActivity(toRegisterActivity);
    }
}