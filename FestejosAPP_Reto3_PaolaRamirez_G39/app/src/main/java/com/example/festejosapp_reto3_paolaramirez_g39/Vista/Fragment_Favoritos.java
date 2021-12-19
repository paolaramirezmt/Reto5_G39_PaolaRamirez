package com.example.festejosapp_reto3_paolaramirez_g39.Vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.festejosapp_reto3_paolaramirez_g39.Modelo.BaseDatos.MotorBaseDatosSQLite;
import com.example.festejosapp_reto3_paolaramirez_g39.R;


public class Fragment_Favoritos extends Fragment {

   View v;

    // CONEXION A LA BASE DE DATOS: SQLite
    MotorBaseDatosSQLite conector = new MotorBaseDatosSQLite(getContext(),"TiendaProductos", null, 1);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__favoritos, container, false);
        //-----------------------------------------------------------------------------

        //-----------------------------------------------------------------------------
        return v;
    }

}