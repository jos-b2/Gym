package com.example.gym;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class VerEjercicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_ejercicio);

        // Referencias de la vista
        ImageView btnBackVer = findViewById(R.id.btnBackVer);
        TextView tvNombreEjercicioVer = findViewById(R.id.tvNombreEjercicioVer);
        TextView tvRutinaDetalle = findViewById(R.id.tvRutinaDetalle);
        VideoView videoViewEjercicio = findViewById(R.id.videoViewEjercicio);

        // Botón regresar a la vista anterior
        btnBackVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Recibir los datos enviados desde la lista de ejercicios
        String tituloEjercicio = getIntent().getStringExtra("TITULO");
        String detalleEjercicio = getIntent().getStringExtra("DETALLE");

        if (tituloEjercicio != null) {
            tvNombreEjercicioVer.setText(tituloEjercicio);
        }
        if (detalleEjercicio != null) {
            tvRutinaDetalle.setText(detalleEjercicio);
        }

        // Configurar y reproducir video (Nota: El video debe estar ubicado en la carpeta res/raw/ con un nombre en minúsculas y sin espacios, ej: res/raw/video_pecho.mp4)
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.ejercico_prueva;
        Uri uri = Uri.parse(videoPath);
        videoViewEjercicio.setVideoURI(uri);

        // Iniciar reproducción automática
        videoViewEjercicio.start();
    }
}