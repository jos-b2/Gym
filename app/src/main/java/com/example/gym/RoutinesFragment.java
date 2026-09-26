package com.example.gym;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.card.MaterialCardView;

public class RoutinesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_routines, container, false);

        // Enlazamos la tarjeta de pecho con su ID
        MaterialCardView cardPecho = view.findViewById(R.id.cardPecho);

        // Programamos el evento de clic para abrir la actividad de lista de ejercicios
        cardPecho.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ListaEjercicio.class);
            startActivity(intent);
        });

        return view;
    }
}