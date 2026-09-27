package com.example.gym;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MaterialButton btnVerDetalles = view.findViewById(R.id.btnVerDetallesClase);

        if (btnVerDetalles != null) {
            btnVerDetalles.setOnClickListener(v -> mostrarDetallesClase());
        }
    }

    private void mostrarDetallesClase() {
        new MaterialAlertDialogBuilder(requireContext())
                .setTitle("Fuerza y Potencia")
                .setMessage("• Horario: Hoy a las 18:00 hrs\n" +
                        "• Instructor: Carlos Mendoza\n" +
                        "• Ubicación: Sala Principal\n" +
                        "• Duración: 60 minutos\n" +
                        "• Estado: Confirmada ✅\n\n" +
                        "Recuerda llegar 10 minutos antes con tu toalla e hidratación lista.")
                .setPositiveButton("Entendido", (dialog, which) -> dialog.dismiss())
                .show();
    }
}