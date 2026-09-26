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

    private String nivelSeleccionado = "Principiante";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_routines, container, false);

        layoutSeleccionNivel = view.findViewById(R.id.layoutSeleccionNivel);
        layoutContenidoRutinas = view.findViewById(R.id.layoutContenidoRutinas);
        txtNivelSeleccionado = view.findViewById(R.id.txtNivelSeleccionado);
        spinnerNivel = view.findViewById(R.id.spinnerNivel);
        MaterialButton btnCambiarNivel = view.findViewById(R.id.btnCambiarNivel);

        String[] niveles = {
                "Seleccionar dificultad",
                "Principiante",
                "Intermedio",
                "Avanzado"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, niveles);
        spinnerNivel.setAdapter(adapter);

        spinnerNivel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                if (position > 0) {
                    nivelSeleccionado = niveles[position];
                    txtNivelSeleccionado.setText("NIVEL: " + nivelSeleccionado.toUpperCase() + " ★");
                    layoutSeleccionNivel.setVisibility(View.GONE);
                    layoutContenidoRutinas.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        btnCambiarNivel.setOnClickListener(v -> {
            spinnerNivel.setSelection(0);
            layoutContenidoRutinas.setVisibility(View.GONE);
            layoutSeleccionNivel.setVisibility(View.VISIBLE);
        });

        // Configurar las 9 tarjetas de músculos
        configurarTarjeta(view, R.id.cardPecho, "PECHO");
        configurarTarjeta(view, R.id.cardEspalda, "ESPALDA");
        configurarTarjeta(view, R.id.cardPiernas, "PIERNAS");
        configurarTarjeta(view, R.id.cardHombros, "HOMBROS");
        configurarTarjeta(view, R.id.cardBiceps, "BÍCEPS");
        configurarTarjeta(view, R.id.cardTriceps, "TRÍCEPS");
        configurarTarjeta(view, R.id.cardAbdomen, "ABDOMEN");
        configurarTarjeta(view, R.id.cardCardio, "CARDIO");
        configurarTarjeta(view, R.id.cardMixta, "MIXTA");

        return view;
    }

    private void configurarTarjeta(View rootView, int cardId, String nombreMusculo) {
        MaterialCardView card = rootView.findViewById(cardId);
        if (card != null) {
            card.setOnClickListener(v -> {
                Intent intent = new Intent(getActivity(), ListaEjercicio.class);
                intent.putExtra("EXTRA_NIVEL", nivelSeleccionado);
                intent.putExtra("EXTRA_MUSCULO", nombreMusculo);
                startActivity(intent);
            });
        }
    }
}