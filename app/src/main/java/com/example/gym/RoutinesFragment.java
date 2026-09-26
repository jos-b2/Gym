package com.example.gym;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class RoutinesFragment extends Fragment {

    private LinearLayout layoutSeleccionNivel;
    private LinearLayout layoutContenidoRutinas;
    private TextView txtNivelSeleccionado;
    private Spinner spinnerNivel;

    // Variable para almacenar el nivel seleccionado (por defecto Principiante)
    private String nivelSeleccionado = "Principiante";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_routines, container, false);

        // Enlaces de vistas
        layoutSeleccionNivel = view.findViewById(R.id.layoutSeleccionNivel);
        layoutContenidoRutinas = view.findViewById(R.id.layoutContenidoRutinas);
        txtNivelSeleccionado = view.findViewById(R.id.txtNivelSeleccionado);
        spinnerNivel = view.findViewById(R.id.spinnerNivel);
        MaterialCardView cardPecho = view.findViewById(R.id.cardPecho);
        MaterialButton btnCambiarNivel = view.findViewById(R.id.btnCambiarNivel);

        // Opciones del Spinner
        String[] niveles = {
                "Seleccionar dificultad",
                "Principiante",
                "Intermedio",
                "Avanzado"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, niveles);
        spinnerNivel.setAdapter(adapter);

        // Evento al seleccionar una dificultad
        spinnerNivel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                if (position > 0) {
                    // Guardar el nivel elegido en la variable global
                    nivelSeleccionado = niveles[position];

                    // Actualizamos el texto con el nivel seleccionado y una estrella
                    txtNivelSeleccionado.setText("NIVEL: " + nivelSeleccionado.toUpperCase() + " ★");

                    // Ocultamos la sección de selección central y mostramos las rutinas
                    layoutSeleccionNivel.setVisibility(View.GONE);
                    layoutContenidoRutinas.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Sin acción
            }
        });

        // Botón "Cambiar" para volver al estado inicial de selección
        btnCambiarNivel.setOnClickListener(v -> {
            spinnerNivel.setSelection(0); // Regresa el spinner a la opción predeterminada
            layoutContenidoRutinas.setVisibility(View.GONE);
            layoutSeleccionNivel.setVisibility(View.VISIBLE);
        });

        // Evento de clic para la tarjeta de pecho enviando los datos mediante el Intent
        cardPecho.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ListaEjercicio.class);
            intent.putExtra("EXTRA_NIVEL", nivelSeleccionado);
            intent.putExtra("EXTRA_MUSCULO", "PECHO");
            startActivity(intent);
        });

        return view;
    }
}