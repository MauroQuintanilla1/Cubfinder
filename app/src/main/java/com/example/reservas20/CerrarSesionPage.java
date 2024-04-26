package com.example.reservas20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CerrarSesionPage extends AppCompatActivity {

    Button btncerrarsesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerrar_sesion_page);

        btncerrarsesion = findViewById(R.id.btn_cerrarSesion);

        btncerrarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CerrarSesionPage.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(CerrarSesionPage.this, HomePage.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}