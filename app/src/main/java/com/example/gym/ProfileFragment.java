package com.example.gym;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MaterialButton btnVerMembresia = view.findViewById(R.id.btnVerMembresia);
        MaterialCardView cardTarjetaDigital = view.findViewById(R.id.cardTarjetaDigital);

        cardTarjetaDigital.setVisibility(View.GONE);

        btnVerMembresia.setOnClickListener(v -> {
            if (cardTarjetaDigital.getVisibility() == View.VISIBLE) {
                cardTarjetaDigital.setVisibility(View.GONE);
                btnVerMembresia.setText("VER TARJETA DE MEMBRESÍA");
            } else {
                cardTarjetaDigital.setVisibility(View.VISIBLE);
                btnVerMembresia.setText("OCULTAR TARJETA");
            }
        });
    }
}