package com.example.festejosapp_reto3_paolaramirez_g39.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.festejosapp_reto3_paolaramirez_g39.Modelo.Adaptador;
import com.example.festejosapp_reto3_paolaramirez_g39.Modelo.BaseDatos.MotorBaseDatosSQLite;
import com.example.festejosapp_reto3_paolaramirez_g39.Modelo.Entidad;
import com.example.festejosapp_reto3_paolaramirez_g39.R;

import java.util.ArrayList;
public class Fragment_Servicios extends Fragment {

    String TAG = "Fragment_Servicios";
    View v;

    ListView listaServicios;
    Adaptador adaptador;

    // CONEXION A LA BASE DE DATOS: SQLite
    MotorBaseDatosSQLite conectar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__servicios, container, false);
        //-----------------------------------------------------------------------------
        listaServicios = (ListView) v.findViewById(R.id.lista_servicios);
        adaptador = new Adaptador(GetArrayItems(), getContext());

        listaServicios.setAdapter(adaptador);

        //-----------------------------------------------------------------------------
        return v;
    }

    private ArrayList<Entidad> getTablaServicios(){
        ArrayList<Entidad> listaProductos = new ArrayList<>();
        conectar = new MotorBaseDatosSQLite(getContext(),"TiendaProductos", null, 1);
        SQLiteDatabase db_leer = conectar.getReadableDatabase();
        Cursor cursor = db_leer.rawQuery("SELECT * FROM servicios", null);
        Log.v(TAG, "leyendo la base de datos");

        while(cursor.moveToNext()){
            Log.v(TAG, "dentro del ciclo while");
            listaProductos.add(new Entidad(R.drawable.s1, cursor.getString(0), cursor.getString(1)));
            Log.v(TAG, "Finalizó el ciclo while");
        }


        return listaProductos;
    }
    private ArrayList<Entidad> GetArrayItems(){
        ArrayList<Entidad> listaItems = new ArrayList<Entidad>();
        listaItems.add(new Entidad(R.drawable.s1, "Musica", "PONEMOS LA MUSICA A TU ESTILO PARA TU REUNION"));
        listaItems.add(new Entidad(R.drawable.s2, "Salones", "OFRECEMOS UNA AMPLIA VARIEDAD DE SALONES PARA TODO TIPO DE REUNIONES SOCIALES"));
        listaItems.add(new Entidad(R.drawable.s3, "Meseros", "MESEROS QUE  REPARTEN LA COMIDA Y ATIENDEN DE LA MEJOR MANERA A TODOS TUS INVITADOS"));

        return listaItems;
    }
}