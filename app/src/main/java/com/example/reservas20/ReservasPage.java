package com.example.reservas20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ReservasPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas_page);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ReservasPage.this, HomePage.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}