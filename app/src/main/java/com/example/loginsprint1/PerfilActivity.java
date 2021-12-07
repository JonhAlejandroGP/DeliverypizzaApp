package com.example.loginsprint1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;


public class PerfilActivity extends AppCompatActivity {

    //private TextView txt_nombre;
    private EditText txt_nombre,txtcorreo;
    private FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        txt_nombre= findViewById(R.id.TxtNusuario);
        txtcorreo=findViewById(R.id.TxtCorreo);

    }

    @Override
    protected void onStart() {
        super.onStart();
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            txtcorreo.setText(user.getEmail());
            if(user.getDisplayName()!=null)
                txt_nombre.setText(user.getDisplayName());
        }
    }

    public void actualizaPerfil(View v)
    {
        if(txt_nombre.getText().toString()!=null) {
            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName(txt_nombre.getText().toString())
                    //   .setPhotoUri(Uri.parse("https://example.com/jane-q-user/profile.jpg"))
                    .build();

            user.updateProfile(profileUpdates)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Log.d("Actualizacion", "User profile updated.");
                            }
                        }
                    });
        }
    }
}