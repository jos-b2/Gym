package com.example.gym;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

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

        // Capturar datos enviados por el Intent
        String nivelSeleccionado = getIntent().getStringExtra("EXTRA_NIVEL");
        String musculoSeleccionado = getIntent().getStringExtra("EXTRA_MUSCULO");

        if (nivelSeleccionado == null) nivelSeleccionado = "Principiante";
        if (musculoSeleccionado == null) musculoSeleccionado = "PECHO";

        // Referencias de textos superiores
        TextView tvNivelSubtitulo = findViewById(R.id.tvNivelSubtitulo);
        TextView tvDetalleMusculo = findViewById(R.id.tvDetalleMusculo);

        // Referencias de los textos dentro de las tarjetas de ejercicios
        TextView tvCard1Titulo = findViewById(R.id.tvCard1Titulo);
        TextView tvCard1Sub = findViewById(R.id.tvCard1Sub);
        TextView tvCard2Titulo = findViewById(R.id.tvCard2Titulo);
        TextView tvCard2Sub = findViewById(R.id.tvCard2Sub);
        TextView tvCard3Titulo = findViewById(R.id.tvCard3Titulo);
        TextView tvCard3Sub = findViewById(R.id.tvCard3Sub);
        TextView tvCard4Titulo = findViewById(R.id.tvCard4Titulo);
        TextView tvCard4Sub = findViewById(R.id.tvCard4Sub);

        // Actualizamos toda la información de la pantalla dinámicamente
        actualizarInformacionVista(nivelSeleccionado, musculoSeleccionado,
                tvNivelSubtitulo, tvDetalleMusculo,
                tvCard1Titulo, tvCard1Sub,
                tvCard2Titulo, tvCard2Sub,
                tvCard3Titulo, tvCard3Sub,
                tvCard4Titulo, tvCard4Sub);
    }

    /**
     * Función que personaliza los textos, series, repeticiones y pesos orientativos (en libras/kilos).
     */
    private void actualizarInformacionVista(String nivel, String musculo,
                                            TextView tvNivel, TextView tvDetalle,
                                            TextView t1Title, TextView t1Sub,
                                            TextView t2Title, TextView t2Sub,
                                            TextView t3Title, TextView t3Sub,
                                            TextView t4Title, TextView t4Sub) {
        tvNivel.setText("Nivel " + nivel + " ");

        switch (musculo.toUpperCase()) {
            case "PECHO":
                tvDetalle.setText("Fundamentos y Fuerza de " + musculo);
                break;
            default:
                tvDetalle.setText("Rutina de " + musculo);
                break;
        }

        // CAMBIO DE CONTENIDO CON PESOS ORIENTATIVOS CLAROS
        if (nivel.equalsIgnoreCase("Intermedio")) {
            t1Title.setText("Press de Banca Plano con Barra");
            t1Sub.setText("4 series · 8-10 reps · Peso orientativo: 40-50 kg (90-110 lbs)");

            t2Title.setText("Press Inclinado con Mancuernas");
            t2Sub.setText("3 series · 10 reps · Mancuernas de 14-18 kg (30-40 lbs)");

            t3Title.setText("Fondos en Paralelas (Dips)");
            t3Sub.setText("3 series · al fallo · Peso corporal");

            t4Title.setText("Supercompensación de Pecho");
            t4Sub.setText("Descanso activo y estiramientos con calma");

        } else if (nivel.equalsIgnoreCase("Avanzado")) {
            t1Title.setText("Press de Banca Pesado");
            t1Sub.setText("5 series · 5 reps · Peso orientativo: 60-80 kg (135-175 lbs)");

            t2Title.setText("Press Guillotina");
            t2Sub.setText("4 series · 8 reps · Barra o mancuernas de 20-25 kg (45-55 lbs)");

            t3Title.setText("Flexiones con Lastre");
            t3Sub.setText("4 series · 10 reps · Con disco de 10 kg (22 lbs) en espalda");

            t4Title.setText("Recuperación Avanzada");
            t4Sub.setText("Estiramientos profundos y descarga muscular");

        } else {
            // Principiante (Por defecto)
            t1Title.setText("Press de Banca Inclinado con Mancuernas");
            t1Sub.setText("4 series · 10 reps · Mancuernas de 6-10 kg (15-20 lbs)");

            t2Title.setText("Aperturas con Mancuernas");
            t2Sub.setText("3 series · 12 reps · Mancuernas ligeras de 4-6 kg (10-15 lbs)");

            t3Title.setText("Flexiones de Pecho (Push-ups) de Rodillas");
            t3Sub.setText("3 series · al fallo · Solo peso corporal (rodillas apoyadas)");

            t4Title.setText("Recuperación Activa");
            t4Sub.setText("Descanso y estiramientos suaves de pecho");
        }
    }
}