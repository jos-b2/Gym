package com.example.gym;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ListaEjercicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_ejercicio);

        // Referenciamos el botón de retroceso
        ImageView btnBack = findViewById(R.id.btnBack);

        // Configuramos el evento para cerrar la actividad actual al hacer clic
        btnBack.setOnClickListener(v -> finish());
    }
}