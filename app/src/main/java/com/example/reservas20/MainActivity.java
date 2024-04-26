package com.example.reservas20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    TextInputEditText editTextEmail, editTextContraseña;

    Button btnIniciarSesion;

    TextView txtregistrate;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.email);
        editTextContraseña = findViewById(R.id.contraseña);
        btnIniciarSesion = findViewById(R.id.btn_IniciarSesion);
        txtregistrate = findViewById(R.id.txt_Registrate);

        txtregistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterPage.class);
                startActivity(intent);
                finish();
            }
        });
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, contraseña;
                email = String.valueOf(editTextEmail.getText());
                contraseña = String.valueOf(editTextContraseña.getText());

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(MainActivity.this, "Escriba su correo electronico", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(contraseña)){
                    Toast.makeText(MainActivity.this, "Escriba su contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(email,contraseña)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>(){

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(MainActivity.this, "Inicio de Sesion exitoso", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else {
                                    Toast.makeText(MainActivity.this, "Error de Inicio de sesion intruduzca un correo o contraseña valido", Toast.LENGTH_LONG).show();
                                }

                            }
                        });
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainActivity.this, WelcomePage.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
