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


public class Fragment_Productos extends Fragment {

    int [] imagen = {R.drawable.p1, R.drawable.p2, R.drawable.p3 };

    String TAG = "Fragment_Productos";

    View v;

    ListView listaProductos;
    Adaptador adaptador;

    // CONEXION A LA BASE DE DATOS: SQLite
    MotorBaseDatosSQLite conectar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__productos, container, false);
        //-----------------------------------------------------------------------------
        listaProductos = (ListView) v.findViewById(R.id.lista_productos);
        adaptador = new Adaptador(GetListItems(), getContext());

        listaProductos.setAdapter(adaptador);


        //-----------------------------------------------------------------------------
        return v;

    }
    private ArrayList<Entidad> getTablaProductos(){
        ArrayList<Entidad> listaProductos = new ArrayList<>();
        conectar = new MotorBaseDatosSQLite(getContext(),"TiendaProductos", null, 1);
        SQLiteDatabase db_leer = conectar.getReadableDatabase();
        Cursor cursor = db_leer.rawQuery("SELECT * FROM productos", null);
        Log.v(TAG, "Leyendo la base de datos");

        while(cursor.moveToNext()){
            Log.v(TAG, "ciclo while");
            listaProductos.add(new Entidad(imagen[cursor.getInt(0)], cursor.getString(0), cursor.getString(1)));
            Log.v(TAG, "final ciclo while");
        }


        return listaProductos;
    }

    private ArrayList<Entidad> GetListItems(){
        ArrayList<Entidad> listaItems = new ArrayList<>();
        listaItems.add(new Entidad(R.drawable.p1, "Comida", "TENEMOS TODO TIPO DE COMIDA PARA CATERING, FIESTAS INFANTILES Y MATRIMONIOS"));
        listaItems.add(new Entidad(R.drawable.p2, "Decoracion", "TE OFRECEMOS DECORACION PARA  TODO TIPO DE FIESTAS"));
        listaItems.add(new Entidad(R.drawable.p3, "Tarjetas", "INVITACIONES A TU MEDIDA, PARA TODOS TUS EVENTOS ESPECIALES"));
        return listaItems;
    }


}