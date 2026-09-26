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

        ImageView imgCard1 = findViewById(R.id.imgCard1);
        ImageView imgCard2 = findViewById(R.id.imgCard2);
        ImageView imgCard3 = findViewById(R.id.imgCard3);
        ImageView imgCard4 = findViewById(R.id.imgCard4);

        actualizarInformacionVista(nivelSeleccionado, musculoSeleccionado,
                tvNivelSubtitulo, tvDetalleMusculo,
                tvCard1Titulo, tvCard1Sub,
                tvCard2Titulo, tvCard2Sub,
                tvCard3Titulo, tvCard3Sub,
                tvCard4Titulo, tvCard4Sub,
                imgCard1, imgCard2, imgCard3, imgCard4);
    }

    private void actualizarInformacionVista(String nivel, String musculo,
                                            TextView tvNivel, TextView tvDetalle,
                                            TextView t1Title, TextView t1Sub,
                                            TextView t2Title, TextView t2Sub,
                                            TextView t3Title, TextView t3Sub,
                                            TextView t4Title, TextView t4Sub,
                                            ImageView i1, ImageView i2, ImageView i3, ImageView i4) {
        if (tvNivel != null) tvNivel.setText("Nivel " + nivel + " ");
        if (tvDetalle != null) tvDetalle.setText("Rutina enfocada en " + musculo);

        // Imágenes por defecto para evitar errores de compilación
        int resImg1 = R.drawable.captura_de_pantalla_2026_09_25_182537;
        int resImg2 = R.drawable.captura_de_pantalla_2026_09_25_182710;
        int resImg3 = R.drawable.captura_de_pantalla_2026_09_25_182808;
        // La cuarta tarjeta es la de descanso/recuperación
        int resImg4 = R.drawable.captura_de_pantalla_2026_09_25_182856;

        switch (musculo.toUpperCase()) {
            case "ESPALDA":
                if (nivel.equalsIgnoreCase("Intermedio")) {
                    t1Title.setText("Remo en polea baja");
                    t1Sub.setText("4 series • 8-10 reps • Peso desafiante");
                    resImg1 = R.drawable.remo_en_polea_baja;

                    t2Title.setText("Jalón al pecho");
                    t2Sub.setText("4 series • 8-10 reps • Peso medio-alto");
                    resImg2 = R.drawable.tiron_hacia_abajo;

                    t3Title.setText("Dominadas asistidas");
                    t3Sub.setText("4 series • 8-10 reps • Asistencia moderada");
                    resImg3 = R.drawable.dominadas;

                    t4Title.setText("Recuperación de Espalda");
                    t4Sub.setText("Estiramientos y descanso activo");
                } else if (nivel.equalsIgnoreCase("Avanzado")) {
                    t1Title.setText("Remo en polea baja");
                    t1Sub.setText("4-5 series • 6-8 reps • Peso pesado");
                    resImg1 = R.drawable.remo_en_polea_baja;

                    t2Title.setText("Jalón al pecho");
                    t2Sub.setText("4-5 series • 6-8 reps • Carga pesada");
                    resImg2 = R.drawable.tiron_hacia_abajo;

                    t3Title.setText("Dominadas asistidas");
                    t3Sub.setText("4-5 series • 6-8 reps • Sin asistencia");
                    resImg3 = R.drawable.dominadas;

                    t4Title.setText("Descarga de Espalda");
                    t4Sub.setText("Estiramientos profundos de columna");
                } else { // Principiante
                    t1Title.setText("Remo en polea baja");
                    t1Sub.setText("3 series • 10-12 reps • Peso ligero");
                    resImg1 = R.drawable.remo_en_polea_baja;

                    t2Title.setText("Jalón al pecho");
                    t2Sub.setText("3 series • 10-12 reps • Carga ligera");
                    resImg2 = R.drawable.tiron_hacia_abajo;

                    t3Title.setText("Dominadas asistidas");
                    t3Sub.setText("3 series • 10-12 reps • Alta asistencia");
                    resImg3 = R.drawable.dominadas;

                    t4Title.setText("Estiramiento Libre");
                    t4Sub.setText("Descanso y relajación");
                }
                break;

            case "PIERNAS":
                if (nivel.equalsIgnoreCase("Intermedio")) {
                    t1Title.setText("Sentadilla sumo");
                    t1Sub.setText("4 series • 8-10 reps • Mancuerna media");
                    resImg1 = R.drawable.sentadilla_sumo;

                    t2Title.setText("Peso muerto");
                    t2Sub.setText("4 series • 8-10 reps • Carga media-alta");
                    resImg2 = R.drawable.puente_de_gluteos_con_peso;

                    t3Title.setText("Sentadilla goblet");
                    t3Sub.setText("4 series • 8-10 reps • Peso moderado");
                    resImg3 = R.drawable.curl_de_isquiotibiales_acostado;

                    t4Title.setText("Vuelta a la Calma");
                    t4Sub.setText("Estiramiento de cuádriceps");
                } else if (nivel.equalsIgnoreCase("Avanzado")) {
                    t1Title.setText("Sentadilla sumo");
                    t1Sub.setText("4-5 series • 6-8 reps • Carga alta");
                    resImg1 = R.drawable.sentadilla_sumo;

                    t2Title.setText("Peso muerto");
                    t2Sub.setText("4-5 series • 6-8 reps • Cargas pesadas");
                    resImg2 = R.drawable.puente_de_gluteos_con_peso;

                    t3Title.setText("Sentadilla goblet");
                    t3Sub.setText("4-5 series • 6-8 reps • Peso muy pesado");
                    resImg3 = R.drawable.curl_de_isquiotibiales_acostado;

                    t4Title.setText("Descarga de Tren Inferior");
                    t4Sub.setText("Estiramiento profundo");
                } else { // Principiante
                    t1Title.setText("Sentadilla sumo");
                    t1Sub.setText("3 series • 10-12 reps • Peso corporal");
                    resImg1 = R.drawable.sentadilla_sumo;

                    t2Title.setText("Peso muerto");
                    t2Sub.setText("3 series • 10-12 reps • Barra ligera");
                    resImg2 = R.drawable.puente_de_gluteos_con_peso;

                    t3Title.setText("Sentadilla goblet");
                    t3Sub.setText("3 series • 10-12 reps • Pesa ligera");
                    resImg3 = R.drawable.curl_de_isquiotibiales_acostado;

                    t4Title.setText("Movilidad Articular");
                    t4Sub.setText("Caminata suave");
                }
                break;

            case "HOMBROS":
                if (nivel.equalsIgnoreCase("Intermedio")) {
                    t1Title.setText("Press militar");
                    t1Sub.setText("4 series • 10 reps • Mancuernas moderadas");
                    resImg1 = R.drawable.press_militar_con_mancuernas_o_barra;

                    t2Title.setText("Elevaciones laterales");
                    t2Sub.setText("4 series • 10 reps • Mancuernas moderadas");
                    resImg2 = R.drawable.elevaciones_laterales;

                    t3Title.setText("Elevaciones frontales");
                    t3Sub.setText("4 series • 10 reps • Peso moderado");
                    resImg3 = R.drawable.elevaciones_frontales_con_mancuernas;

                    t4Title.setText("Recuperación de Hombros");
                    t4Sub.setText("Estiramientos y movilidad");
                } else if (nivel.equalsIgnoreCase("Avanzado")) {
                    t1Title.setText("Press militar");
                    t1Sub.setText("4 series • 8-10 reps • Pesos exigentes");
                    resImg1 = R.drawable.press_militar_con_mancuernas_o_barra;

                    t2Title.setText("Elevaciones laterales");
                    t2Sub.setText("4 series • 8-10 reps • Mancuernas pesadas");
                    resImg2 = R.drawable.elevaciones_laterales;

                    t3Title.setText("Elevaciones frontales");
                    t3Sub.setText("4 series • 8-10 reps • Cargas exigentes");
                    resImg3 = R.drawable.elevaciones_frontales_con_mancuernas;

                    t4Title.setText("Descarga de Hombros");
                    t4Sub.setText("Estiramientos y descarga");
                } else { // Principiante
                    t1Title.setText("Press militar");
                    t1Sub.setText("3 series • 12 reps • Muy ligeras");
                    resImg1 = R.drawable.press_militar_con_mancuernas_o_barra;

                    t2Title.setText("Elevaciones laterales");
                    t2Sub.setText("3 series • 12 reps • Bajo peso");
                    resImg2 = R.drawable.elevaciones_laterales;

                    t3Title.setText("Elevaciones frontales");
                    t3Sub.setText("3 series • 12 reps • Ligeras");
                    resImg3 = R.drawable.elevaciones_frontales_con_mancuernas;

                    t4Title.setText("Recuperación Activa");
                    t4Sub.setText("Descanso y estiramientos");
                }
                break;

            case "BÍCEPS":
                if (nivel.equalsIgnoreCase("Intermedio")) {
                    t1Title.setText("Curl en banco Scott");
                    t1Sub.setText("3-4 series • 8-10 reps • Carga moderada");
                    resImg1 = R.drawable.curl_de_biceps_en_banco_scott;

                    t2Title.setText("Curl inclinado");
                    t2Sub.setText("3-4 series • 8-10 reps • Incremento progresivo");
                    resImg2 = R.drawable.curl_inclinado_con_mancuernas;

                    t3Title.setText("Curl alterno de pie");
                    t3Sub.setText("3-4 series • 8-10 reps • Peso desafiante");
                    resImg3 = R.drawable.curl_de_biceps_alterno_con_mancuerna_de_pie;

                    t4Title.setText("Estiramiento de Bíceps");
                    t4Sub.setText("Relajación muscular");
                } else if (nivel.equalsIgnoreCase("Avanzado")) {
                    t1Title.setText("Curl en banco Scott");
                    t1Sub.setText("4 series • 6-8 reps • Cargas pesadas");
                    resImg1 = R.drawable.curl_de_biceps_en_banco_scott;

                    t2Title.setText("Curl inclinado");
                    t2Sub.setText("4 series • 6-8 reps • Mancuernas pesadas");
                    resImg2 = R.drawable.curl_inclinado_con_mancuernas;

                    t3Title.setText("Curl alterno de pie");
                    t3Sub.setText("4 series • 6-8 reps • Cargas pesadas");
                    resImg3 = R.drawable.curl_de_biceps_alterno_con_mancuerna_de_pie;

                    t4Title.setText("Congestión Máxima");
                    t4Sub.setText("Descanso activo");
                } else { // Principiante
                    t1Title.setText("Curl en banco Scott");
                    t1Sub.setText("3 series • 10-12 reps • Barra Z liviana");
                    resImg1 = R.drawable.curl_de_biceps_en_banco_scott;

                    t2Title.setText("Curl inclinado");
                    t2Sub.setText("3 series • 10-12 reps • Mancuernas ligeras");
                    resImg2 = R.drawable.curl_inclinado_con_mancuernas;

                    t3Title.setText("Curl alterno de pie");
                    t3Sub.setText("3 series • 10-12 reps • Sin balanceo");
                    resImg3 = R.drawable.curl_de_biceps_alterno_con_mancuerna_de_pie;

                    t4Title.setText("Recuperación");
                    t4Sub.setText("Estiramientos suaves");
                }
                break;

            case "TRÍCEPS":
                if (nivel.equalsIgnoreCase("Intermedio")) {
                    t1Title.setText("Extensiones en polea alta");
                    t1Sub.setText("3-4 series • 8-10 reps • Peso medio");
                    resImg1 = R.drawable.extensiones_de_triceps_en_polea_alta;

                    t2Title.setText("Copa de tríceps");
                    t2Sub.setText("3-4 series • 8-10 reps • Peso moderado");
                    resImg2 = R.drawable.extensiones_de_triceps_con_mancuerna_tras_la_cabeza;

                    t3Title.setText("Fondos en banco");
                    t3Sub.setText("3-4 series • 8-10 reps • Piernas estiradas");
                    resImg3 = R.drawable.fondos_en_banco;

                    t4Title.setText("Elongación de Tríceps");
                    t4Sub.setText("Descanso activo");
                } else if (nivel.equalsIgnoreCase("Avanzado")) {
                    t1Title.setText("Extensiones en polea alta");
                    t1Sub.setText("4 series • 6-8 reps • Cargas pesadas");
                    resImg1 = R.drawable.extensiones_de_triceps_en_polea_alta;

                    t2Title.setText("Copa de tríceps");
                    t2Sub.setText("4 series • 6-8 reps • Disco pesado");
                    resImg2 = R.drawable.extensiones_de_triceps_con_mancuerna_tras_la_cabeza;

                    t3Title.setText("Fondos en banco");
                    t3Sub.setText("4 series • 6-8 reps • Con peso adicional");
                    resImg3 = R.drawable.fondos_en_banco;

                    t4Title.setText("Descarga de Brazos");
                    t4Sub.setText("Estiramientos");
                } else { // Principiante
                    t1Title.setText("Extensiones en polea alta");
                    t1Sub.setText("3 series • 10-12 reps • Carga moderada-baja");
                    resImg1 = R.drawable.extensiones_de_triceps_en_polea_alta;

                    t2Title.setText("Copa de tríceps");
                    t2Sub.setText("3 series • 10-12 reps • Mancuerna ligera");
                    resImg2 = R.drawable.extensiones_de_triceps_con_mancuerna_tras_la_cabeza;

                    t3Title.setText("Fondos en banco");
                    t3Sub.setText("3 series • 10-12 reps • Piernas flexionadas");
                    resImg3 = R.drawable.fondos_en_banco;

                    t4Title.setText("Recuperación");
                    t4Sub.setText("Estiramientos suaves");
                }
                break;

            case "ABDOMEN":
                if (nivel.equalsIgnoreCase("Intermedio")) {
                    t1Title.setText("Rueda abdominal");
                    t1Sub.setText("4 series • 15-20 reps • Desde rodillas");
                    resImg1 = R.drawable.rueda_abdominal;

                    t2Title.setText("Encogimientos");
                    t2Sub.setText("4 series • 15-20 reps • Con disco ligero");
                    resImg2 = R.drawable.encogimientos_abdominales_con_piernas_elevadas;

                    t3Title.setText("Giros rusos con peso");
                    t3Sub.setText("4 series • 15-20 reps • Disco moderado");
                    resImg3 = R.drawable.giros_rusos_con_peso;

                    t4Title.setText("Estiramiento Abdominal");
                    t4Sub.setText("Plancha y relajación");
                } else if (nivel.equalsIgnoreCase("Avanzado")) {
                    t1Title.setText("Rueda abdominal");
                    t1Sub.setText("4-5 series • 20 reps • Desde los pies");
                    resImg1 = R.drawable.rueda_abdominal;

                    t2Title.setText("Encogimientos");
                    t2Sub.setText("4-5 series • 20 reps • Alta resistencia");
                    resImg2 = R.drawable.encogimientos_abdominales_con_piernas_elevadas;

                    t3Title.setText("Giros rusos con peso");
                    t3Sub.setText("4-5 series • 20 reps • Peso elevado");
                    resImg3 = R.drawable.giros_rusos_con_peso;

                    t4Title.setText("Core Avanzado");
                    t4Sub.setText("Estiramiento profundo");
                } else { // Principiante
                    t1Title.setText("Rueda abdominal");
                    t1Sub.setText("3 series • 15 reps • Corto desde rodillas");
                    resImg1 = R.drawable.rueda_abdominal;

                    t2Title.setText("Encogimientos");
                    t2Sub.setText("3 series • 15 reps • Peso corporal");
                    resImg2 = R.drawable.encogimientos_abdominales_con_piernas_elevadas;

                    t3Title.setText("Giros rusos");
                    t3Sub.setText("3 series • 15 reps • Sin peso");
                    resImg3 = R.drawable.giros_rusos_con_peso;

                    t4Title.setText("Recuperación de Core");
                    t4Sub.setText("Respiración y estiramiento");
                }
                break;

            case "CARDIO":
                if (nivel.equalsIgnoreCase("Intermedio")) {
                    t1Title.setText("Carrera continua");
                    t1Sub.setText("30-35 min • Ritmo constante");
                    resImg1 = R.drawable.escaladores;

                    t2Title.setText("Intervalos en máquina");
                    t2Sub.setText("30-35 min • Intensidad moderada");
                    resImg2 = R.drawable.sentadilla_sumo_con_pesa_rusa;

                    t3Title.setText("HIIT moderado");
                    t3Sub.setText("30 min • Dinámico");
                    resImg3 = R.drawable.peso_muerto;

                    t4Title.setText("Enfriamiento y Calma");
                    t4Sub.setText("Caminata ligera");
                } else if (nivel.equalsIgnoreCase("Avanzado")) {
                    t1Title.setText("Carrera continua");
                    t1Sub.setText("40+ min • Alta intensidad");
                    resImg1 = R.drawable.escaladores;

                    t2Title.setText("Intervalos en máquina");
                    t2Sub.setText("40 min • Esfuerzo máximo");
                    resImg2 = R.drawable.sentadilla_sumo_con_pesa_rusa;

                    t3Title.setText("HIIT avanzado");
                    t3Sub.setText("40 min • Sin pausas largas");
                    resImg3 = R.drawable.peso_muerto;

                    t4Title.setText("Recuperación Cardiovascular");
                    t4Sub.setText("Vuelta a la calma avanzada");
                } else { // Principiante
                    t1Title.setText("Carrera continua");
                    t1Sub.setText("20-25 min • Moderado");
                    resImg1 = R.drawable.escaladores;

                    t2Title.setText("Intervalos");
                    t2Sub.setText("20-25 min • Trote y caminata");
                    resImg2 = R.drawable.sentadilla_sumo_con_pesa_rusa;

                    t3Title.setText("HIIT suave");
                    t3Sub.setText("20 min • Descansos amplios");
                    resImg3 = R.drawable.peso_muerto;

                    t4Title.setText("Enfriamiento");
                    t4Sub.setText("Estiramientos suaves");
                }
                break;

            case "MIXTA":
                if (nivel.equalsIgnoreCase("Intermedio")) {
                    t1Title.setText("Thrusters");
                    t1Sub.setText("4 series • 10-12 reps • Ritmo fluido");
                    resImg1 = R.drawable.thrusters_con_mancuernas;

                    t2Title.setText("Burpees con salto");
                    t2Sub.setText("4 series • 10-12 reps • Continuos");
                    resImg2 = R.drawable.burpees_con_salto;

                    t3Title.setText("Clean and Press");
                    t3Sub.setText("4 series • 10-12 reps • Peso medio");
                    resImg3 = R.drawable.clean_and_press;

                    t4Title.setText("Recuperación Funcional");
                    t4Sub.setText("Estiramientos globales");
                } else if (nivel.equalsIgnoreCase("Avanzado")) {
                    t1Title.setText("Thrusters");
                    t1Sub.setText("4-5 series • 12-15 reps • Alta velocidad");
                    resImg1 = R.drawable.thrusters_con_mancuernas;

                    t2Title.setText("Burpees con salto");
                    t2Sub.setText("4-5 series • 12-15 reps • Explosivos");
                    resImg2 = R.drawable.burpees_con_salto;

                    t3Title.setText("Clean and Press");
                    t3Sub.setText("4-5 series • 12-15 reps • Cargas pesadas");
                    resImg3 = R.drawable.clean_and_press;

                    t4Title.setText("Descarga Funcional");
                    t4Sub.setText("Estiramientos completos");
                } else { // Principiante
                    t1Title.setText("Thrusters");
                    t1Sub.setText("3 series • 8-10 reps • Ligeras");
                    resImg1 = R.drawable.thrusters_con_mancuernas;

                    t2Title.setText("Burpees con salto");
                    t2Sub.setText("3 series • 8-10 reps • Paso a paso");
                    resImg2 = R.drawable.burpees_con_salto;

                    t3Title.setText("Clean and Press");
                    t3Sub.setText("3 series • 8-10 reps • Pesa ligera");
                    resImg3 = R.drawable.clean_and_press;

                    t4Title.setText("Recuperación Activa");
                    t4Sub.setText("Respiración controlada");
                }
                break;

            default:
                t1Title.setText("Ejercicio Principal de " + musculo);
                t1Sub.setText("4 series · 10 reps");

                t2Title.setText("Ejercicio Secundario");
                t2Sub.setText("3 series · 12 reps");

                t3Title.setText("Ejercicio Complementario");
                t3Sub.setText("3 series · al fallo");

                t4Title.setText("Recuperación y Enfriamiento");
                t4Sub.setText("Estiramientos generales");
                break;
        }

        if (i1 != null) i1.setImageResource(resImg1);
        if (i2 != null) i2.setImageResource(resImg2);
        if (i3 != null) i3.setImageResource(resImg3);
        if (i4 != null) i4.setImageResource(resImg4);
    }
}