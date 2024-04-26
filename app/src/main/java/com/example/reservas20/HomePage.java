package com.example.reservas20;

import static com.example.reservas20.R.drawable.ic_cerrar_sesion;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TabHost;

public class HomePage extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;



        // Primera pestaña: Cubiculos
        Intent intentCubiculos = new Intent().setClass(this, CubiculosPage.class);
        spec = tabHost.newTabSpec("Cubiculos").setIndicator("Cubiculos").setContent(intentCubiculos);
        tabHost.addTab(spec);

        // Segunda pestaña: Mesas
        Intent intentMesas = new Intent().setClass(this, MesasPage.class);
        spec = tabHost.newTabSpec("Mesas");
        ImageView iconoMesas = new ImageView(this);
        iconoMesas.setImageResource(R.drawable.ic_mesa); // Asegúrate de que el nombre del icono sea correcto y esté en la carpeta res/drawable
        spec.setIndicator(iconoMesas);

        spec.setContent(intentMesas);
        tabHost.addTab(spec);

        // Tercera pestaña: casilleros
        Intent intentCasilleros = new Intent().setClass(this, CasillerosPage.class);
        spec = tabHost.newTabSpec("Casilleros");
        ImageView iconoCasilleros = new ImageView(this);
        iconoCasilleros.setImageResource(R.drawable.ic_casillero); // Asegúrate de que el nombre del icono sea correcto y esté en la carpeta res/drawable
        spec.setIndicator(iconoCasilleros);

        spec.setContent(intentCasilleros);
        tabHost.addTab(spec);

        //Cuarta pestaña: Cerrar Sesion
        Intent intentCerrar = new Intent().setClass(this, CerrarSesionPage.class);
        spec = tabHost.newTabSpec("Cerrar Sesion");
        ImageView iconoCerrarSesion = new ImageView(this);
        iconoCerrarSesion.setImageResource(R.drawable.cerrar_sesion); // Asegúrate de que el nombre del icono sea correcto y esté en la carpeta res/drawable
        spec.setIndicator(iconoCerrarSesion);

        spec.setContent(intentCerrar);
        tabHost.addTab(spec);







        tabHost.setCurrentTab(0);
    }

}
