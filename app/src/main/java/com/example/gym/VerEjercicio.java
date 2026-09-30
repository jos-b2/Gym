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
        TextView tvNotasAdicionales = findViewById(R.id.tvNotasAdicionales);
        VideoView videoViewEjercicio = findViewById(R.id.videoViewEjercicio);
        TextView tvAvisoVideo = findViewById(R.id.tvAvisoVideo);

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

        // =========================================================================
        // SELECCIÓN DINÁMICA DEL VIDEO
        // =========================================================================
        boolean tieneVideo = true;
        int resourceIdVideo = R.raw.ejercico_prueva; // Valor base por si acaso

        if (tituloEjercicio != null) {
            String tituloLower = tituloEjercicio.toLowerCase().trim();

            // CASO UNIFICADO DE DESCANSO -> Muestra siempre el video R.raw.descansar
            if (tituloLower.contains("descanso") || tituloLower.contains("descansar")) {
                resourceIdVideo = R.raw.descansar;
                tieneVideo = true;

                // EJERCICIOS DE FUERZA Y CARDIO (Mapeo de videos existentes)
            } else if (tituloLower.contains("banca inclinado") || tituloLower.contains("pres de banca inclinado")) {
                resourceIdVideo = R.raw.pres_de_banca_inclinado_con_mancuernas;
            } else if (tituloLower.contains("apertura con mancuernas")) {
                resourceIdVideo = R.raw.apertura_con_mancuernas;
            } else if (tituloLower.contains("flexiones de pecho")) {
                resourceIdVideo = R.raw.flexiones_de_pecho;
            } else if (tituloLower.contains("remo en polea baja")) {
                resourceIdVideo = R.raw.remo_en_polea_baja;
            } else if (tituloLower.contains("tirón hacia abajo") || tituloLower.contains("tiron hacia abajo")) {
                resourceIdVideo = R.raw.tiron_hacia_abajo;
            } else if (tituloLower.contains("dominadas")) {
                resourceIdVideo = R.raw.dominadas;
            } else if (tituloLower.contains("sentadilla sumo") && !tituloLower.contains("pesa rusa")) {
                resourceIdVideo = R.raw.sentadilla_sumo;
            } else if (tituloLower.contains("sentadilla sumo con pesa rusa")) {
                resourceIdVideo = R.raw.sentadilla_sumo_con_pesa_rusa;
            } else if (tituloLower.contains("puente de glúteos") || tituloLower.contains("puente de gluteos")) {
                resourceIdVideo = R.raw.puente_de_gluteos_con_peso;
            } else if (tituloLower.contains("isquiotibiales") || tituloLower.contains("curl de isquiotibiales")) {
                resourceIdVideo = R.raw.curl_de_isquiotibiales_acostado;
            } else if (tituloLower.contains("press militar")) {
                resourceIdVideo = R.raw.press_militar;
            } else if (tituloLower.contains("elevaciones laterales")) {
                resourceIdVideo = R.raw.elevaciones_laterales;
            } else if (tituloLower.contains("elevaciones frontales")) {
                resourceIdVideo = R.raw.elevaciones_frontales_con_mancuernas;
            } else if (tituloLower.contains("banco scott") || tituloLower.contains("curl en banco scott")) {
                resourceIdVideo = R.raw.curl_de_biceps_en_banco_scott;
            } else if (tituloLower.contains("curl inclinado")) {
                resourceIdVideo = R.raw.curl_inclinado_con_mancuernas;
            } else if (tituloLower.contains("curl alterno")) {
                resourceIdVideo = R.raw.curl_de_biceps_alterno;
            } else if (tituloLower.contains("polea alta") || tituloLower.contains("extensiones en polea alta")) {
                resourceIdVideo = R.raw.extensiones_de_triceps_en_polea_alta;
            } else if (tituloLower.contains("copa de tríceps") || tituloLower.contains("copa de triceps")) {
                resourceIdVideo = R.raw.extensiones_de_triceps_con_mancuerna_tras_la_cabeza;
            } else if (tituloLower.contains("fondos en banco")) {
                resourceIdVideo = R.raw.fondos_en_banco;
            } else if (tituloLower.contains("rueda abdominal")) {
                resourceIdVideo = R.raw.rueda_abdominal;
            } else if (tituloLower.contains("encogimientos")) {
                resourceIdVideo = R.raw.encogimientos_abdominales;
            } else if (tituloLower.contains("giros rusos")) {
                resourceIdVideo = R.raw.giros_rusos_con_peso;
            } else if (tituloLower.contains("escaladores")) {
                resourceIdVideo = R.raw.escaladores;
            } else if (tituloLower.contains("peso muerto")) {
                resourceIdVideo = R.raw.peso_muerto;
            } else if (tituloLower.contains("thrusters")) {
                resourceIdVideo = R.raw.thrusters_con_mancuernas;
            } else if (tituloLower.contains("burpees")) {
                resourceIdVideo = R.raw.burpees_con_salto;
            } else if (tituloLower.contains("clean and press")) {
                resourceIdVideo = R.raw.clean_and_press;
            } else {
                tieneVideo = false;
            }
        }

        // Si es descanso, podemos inyectarle directamente el texto detallado que pediste si lo deseas, o dejar que lo reciba del Intent
        if (tituloEjercicio != null && (tituloEjercicio.toLowerCase().contains("descanso") || tituloEjercicio.toLowerCase().contains("descansar"))) {
            tvRutinaDetalle.setText("Descanso para los músculos");
            if (tvNotasAdicionales != null) {
                tvNotasAdicionales.setText("El descanso insuficiente arruina las ganancias musculares porque, tras someter a los músculos al estrés y daño del entrenamiento en el gimnasio, es durante el sueño cuando el cuerpo se encarga de reparar los tejidos dañados y hacerlos crecer. Además, dormir permite reponer las reservas de glucógeno necesarias como fuente de energía, por lo que se recomienda un promedio de 7 a 9 horas de sueño para lograr un descanso óptimo y asegurar el crecimiento muscular.");
            }
        }

        // Controlar si se muestra el video o el mensaje de aviso
        if (tieneVideo) {
            if (tvAvisoVideo != null) tvAvisoVideo.setVisibility(View.GONE);
            videoViewEjercicio.setVisibility(View.VISIBLE);

            String videoPath = "android.resource://" + getPackageName() + "/" + resourceIdVideo;
            Uri uri = Uri.parse(videoPath);
            videoViewEjercicio.setVideoURI(uri);
            videoViewEjercicio.start();
        } else {
            videoViewEjercicio.setVisibility(View.GONE);
            if (tvAvisoVideo != null) {
                tvAvisoVideo.setVisibility(View.VISIBLE);
                tvAvisoVideo.setText("Video no disponible por el momento");
            }
        }
    }
}