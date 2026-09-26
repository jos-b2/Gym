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

        ImageView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        String nivelSeleccionado = getIntent().getStringExtra("EXTRA_NIVEL");
        String musculoSeleccionado = getIntent().getStringExtra("EXTRA_MUSCULO");

        if (nivelSeleccionado == null) nivelSeleccionado = "Principiante";
        if (musculoSeleccionado == null) musculoSeleccionado = "PECHO";

        TextView tvNivelSubtitulo = findViewById(R.id.tvNivelSubtitulo);
        TextView tvDetalleMusculo = findViewById(R.id.tvDetalleMusculo);

        TextView tvCard1Titulo = findViewById(R.id.tvCard1Titulo);
        TextView tvCard1Sub = findViewById(R.id.tvCard1Sub);
        TextView tvCard2Titulo = findViewById(R.id.tvCard2Titulo);
        TextView tvCard2Sub = findViewById(R.id.tvCard2Sub);
        TextView tvCard3Titulo = findViewById(R.id.tvCard3Titulo);
        TextView tvCard3Sub = findViewById(R.id.tvCard3Sub);
        TextView tvCard4Titulo = findViewById(R.id.tvCard4Titulo);
        TextView tvCard4Sub = findViewById(R.id.tvCard4Sub);

        actualizarInformacionVista(nivelSeleccionado, musculoSeleccionado,
                tvNivelSubtitulo, tvDetalleMusculo,
                tvCard1Titulo, tvCard1Sub,
                tvCard2Titulo, tvCard2Sub,
                tvCard3Titulo, tvCard3Sub,
                tvCard4Titulo, tvCard4Sub);
    }

    private void actualizarInformacionVista(String nivel, String musculo,
                                            TextView tvNivel, TextView tvDetalle,
                                            TextView t1Title, TextView t1Sub,
                                            TextView t2Title, TextView t2Sub,
                                            TextView t3Title, TextView t3Sub,
                                            TextView t4Title, TextView t4Sub) {
        if (tvNivel != null) tvNivel.setText("Nivel " + nivel + " ");
        if (tvDetalle != null) tvDetalle.setText("Rutina enfocada en " + musculo);

        switch (musculo.toUpperCase()) {
            case "PECHO":
                if (nivel.equalsIgnoreCase("Intermedio")) {
                    t1Title.setText("Press de Banca Plano con Barra");
                    t1Sub.setText("4 series · 8-10 reps · Peso: 40-50 kg");
                    t2Title.setText("Press Inclinado con Mancuernas");
                    t2Sub.setText("3 series · 10 reps · 14-18 kg");
                    t3Title.setText("Fondos en Paralelas (Dips)");
                    t3Sub.setText("3 series · al fallo · Peso corporal");
                    t4Title.setText("Supercompensación de Pecho");
                    t4Sub.setText("Descanso activo y estiramientos");
                } else if (nivel.equalsIgnoreCase("Avanzado")) {
                    t1Title.setText("Press de Banca Pesado");
                    t1Sub.setText("5 series · 5 reps · Peso: 60-80 kg");
                    t2Title.setText("Press Guillotina");
                    t2Sub.setText("4 series · 8 reps · Barra de 20-25 kg");
                    t3Title.setText("Flexiones con Lastre");
                    t3Sub.setText("4 series · 10 reps · Disco de 10 kg");
                    t4Title.setText("Recuperación Avanzada");
                    t4Sub.setText("Estiramientos profundos y descarga");
                } else { // Principiante
                    t1Title.setText("Press de Banca Inclinado con Mancuernas");
                    t1Sub.setText("4 series · 10 reps · 6-10 kg");
                    t2Title.setText("Aperturas con Mancuernas");
                    t2Sub.setText("3 series · 12 reps · 4-6 kg");
                    t3Title.setText("Flexiones de Rodillas");
                    t3Sub.setText("3 series · al fallo · Peso corporal");
                    t4Title.setText("Recuperación Activa");
                    t4Sub.setText("Descanso y estiramientos suaves");
                }
                break;

            case "ESPALDA":
                if (nivel.equalsIgnoreCase("Intermedio")) {
                    t1Title.setText("Dominadas en Barra");
                    t1Sub.setText("4 series · 8 reps · Peso corporal");
                    t2Title.setText("Jalón al Pecho en Polea");
                    t2Sub.setText("3 series · 10 reps · 40-50 kg");
                    t3Title.setText("Remo con Barra");
                    t3Sub.setText("3 series · 10 reps · 35-45 kg");
                    t4Title.setText("Estiramiento de Dorsales");
                    t4Sub.setText("Descanso activo");
                } else if (nivel.equalsIgnoreCase("Avanzado")) {
                    t1Title.setText("Dominadas Lastradas");
                    t1Sub.setText("5 series · 6 reps · Disco de 10 kg");
                    t2Title.setText("Remo Pendlay");
                    t2Sub.setText("4 series · 8 reps · 60 kg");
                    t3Title.setText("Remo en Punta");
                    t3Sub.setText("4 series · 8 reps · 55 kg");
                    t4Title.setText("Descarga de Espalda");
                    t4Sub.setText("Estiramientos de columna");
                } else { // Principiante
                    t1Title.setText("Jalón al Pecho en Máquina");
                    t1Sub.setText("4 series · 12 reps · 25-35 kg");
                    t2Title.setText("Remo en Polea Baja");
                    t2Sub.setText("3 series · 12 reps · 25 kg");
                    t3Title.setText("Pull-over con Mancuerna");
                    t3Sub.setText("3 series · 10 reps · 8 kg");
                    t4Title.setText("Estiramiento Libre");
                    t4Sub.setText("Descanso y relajación");
                }
                break;

            case "PIERNAS":
                if (nivel.equalsIgnoreCase("Intermedio")) {
                    t1Title.setText("Sentadilla Libre");
                    t1Sub.setText("4 series · 8 reps · 50-70 kg");
                    t2Title.setText("Prensa de Piernas");
                    t2Sub.setText("3 series · 10 reps · 90-120 kg");
                    t3Title.setText("Curl de Isquiotibiales");
                    t3Sub.setText("3 series · 12 reps · 30 kg");
                    t4Title.setText("Vuelta a la Calma");
                    t4Sub.setText("Estiramiento de cuádriceps");
                } else if (nivel.equalsIgnoreCase("Avanzado")) {
                    t1Title.setText("Sentadilla Profunda Pesada");
                    t1Sub.setText("5 series · 5 reps · 90-110 kg");
                    t2Title.setText("Peso Muerto Rumano");
                    t2Sub.setText("4 series · 8 reps · 80 kg");
                    t3Title.setText("Zancadas con Barra");
                    t3Sub.setText("4 series · 10 reps · 40 kg");
                    t4Title.setText("Descarga de Tren Inferior");
                    t4Sub.setText("Estiramiento profundo");
                } else { // Principiante
                    t1Title.setText("Sentadilla en Smith o Libre Ligera");
                    t1Sub.setText("4 series · 12 reps · Barra sola");
                    t2Title.setText("Extensiones de Cuádriceps");
                    t2Sub.setText("3 series · 12 reps · 20-30 kg");
                    t3Title.setText("Elevación de Talones (Pantorrillas)");
                    t3Sub.setText("3 series · 15 reps · Peso corporal");
                    t4Title.setText("Movilidad Articular");
                    t4Sub.setText("Caminata suave");
                }
                break;

            case "BÍCEPS":
                if (nivel.equalsIgnoreCase("Intermedio")) {
                    t1Title.setText("Curl con Barra Z");
                    t1Sub.setText("4 series · 10 reps · 15-20 kg");
                    t2Title.setText("Curl Martillo con Mancuernas");
                    t2Sub.setText("3 series · 10 reps · 12-14 kg");
                    t3Title.setText("Curl Concentrado");
                    t3Sub.setText("3 series · 12 reps · 10 kg");
                    t4Title.setText("Estiramiento de Bíceps");
                    t4Sub.setText("Relajación muscular");
                } else if (nivel.equalsIgnoreCase("Avanzado")) {
                    t1Title.setText("Curl con Barra Recta Pesado");
                    t1Sub.setText("5 series · 6 reps · 30 kg");
                    t2Title.setText("Curl en Banco Inclinado");
                    t2Sub.setText("4 series · 8 reps · 14 kg");
                    t3Title.setText("Curl Zottman");
                    t3Sub.setText("4 series · 10 reps · 12 kg");
                    t4Title.setText("Congestión Máxima");
                    t4Sub.setText("Descanso activo");
                } else { // Principiante
                    t1Title.setText("Curl Alterno con Mancuernas");
                    t1Sub.setText("4 series · 12 reps · 6-8 kg");
                    t2Title.setText("Curl en Polea Baja");
                    t2Sub.setText("3 series · 12 reps · 15 kg");
                    t3Title.setText("Curl Predicador en Máquina");
                    t3Sub.setText("3 series · 10 reps · 20 kg");
                    t4Title.setText("Recuperación");
                    t4Sub.setText("Estiramientos suaves");
                }
                break;

            case "TRÍCEPS":
                if (nivel.equalsIgnoreCase("Intermedio")) {
                    t1Title.setText("Press Francés con Barra Z");
                    t1Sub.setText("4 series · 10 reps · 20 kg");
                    t2Title.setText("Extensiones en Polea Alta");
                    t2Sub.setText("3 series · 12 reps · 25-35 kg");
                    t3Title.setText("Fondos en Banco");
                    t3Sub.setText("3 series · al fallo · Peso corporal");
                    t4Title.setText("Elongación de Tríceps");
                    t4Sub.setText("Descanso activo");
                } else if (nivel.equalsIgnoreCase("Avanzado")) {
                    t1Title.setText("Press Cerrado Pesado");
                    t1Sub.setText("5 series · 6 reps · 50-60 kg");
                    t2Title.setText("Extensiones Tras Nuca");
                    t2Sub.setText("4 series · 8 reps · 20 kg");
                    t3Title.setText("Extensiones con Cuerda al Fallo");
                    t3Sub.setText("4 series · al fallo · 40 kg");
                    t4Title.setText("Descarga de Brazos");
                    t4Sub.setText("Estiramientos");
                } else { // Principiante
                    t1Title.setText("Extensiones de Tríceps con Cuerda");
                    t1Sub.setText("4 series · 12 reps · 15-20 kg");
                    t2Title.setText("Patada de Tríceps con Mancuerna");
                    t2Sub.setText("3 series · 12 reps · 5-7 kg");
                    t3Title.setText("Press Aguja Cerrada Ligero");
                    t3Sub.setText("3 series · 10 reps · 20 kg");
                    t4Title.setText("Recuperación");
                    t4Sub.setText("Estiramientos suaves");
                }
                break;

            default:
                t1Title.setText("Ejercicio Principal de " + musculo);
                t1Sub.setText("4 series · 10 reps · Intensidad adecuada");
                t2Title.setText("Ejercicio Secundario de " + musculo);
                t2Sub.setText("3 series · 12 reps · Ritmo controlado");
                t3Title.setText("Ejercicio Complementario");
                t3Sub.setText("3 series · al fallo");
                t4Title.setText("Recuperación y Enfriamiento");
                t4Sub.setText("Estiramientos generales de la zona");
                break;
        }
    }
}