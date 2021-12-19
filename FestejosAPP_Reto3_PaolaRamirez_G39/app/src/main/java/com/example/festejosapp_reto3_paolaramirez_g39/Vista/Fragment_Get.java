package com.example.festejosapp_reto3_paolaramirez_g39.Vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.festejosapp_reto3_paolaramirez_g39.Modelo.Adaptador;
import com.example.festejosapp_reto3_paolaramirez_g39.Modelo.Entidad;
import com.example.festejosapp_reto3_paolaramirez_g39.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Fragment_Get extends Fragment {

    int [] imagen = {R.drawable.p1, R.drawable.p2, R.drawable.p3};

    String TAG = "Fragment_Get";

    View v;

    ListView listaGet;
    Adaptador adaptador;

    TextView prueba;

    // CONEXION A LA BASE DE DATOS: instancia APEX de SQL en Oracle Cloud


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__get2, container, false);
        //-----------------------------------------------------------------------------
        listaGet = (ListView) v.findViewById(R.id.lista_Get);
        adaptador = new Adaptador(getTablaGastos(), getContext());

        listaGet.setAdapter(adaptador);

        prueba = (TextView) v.findViewById(R.id.prueba);
        //-----------------------------------------------------------------------------
        return v;
    }

    private ArrayList<Entidad> getTablaGastos(){
        ArrayList<Entidad> listaGet = new ArrayList<>();

        /* ================================================================================================== */

        String url = "https://ge66797f0b4653f-modulo4reto4.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/productos/productos";
        //String url = "https://g08f2d84f649fb9-reto1db.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/open-api-catalog/client/";


        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //***********************************************************
                try {
                    JSONArray jsonArray = response.getJSONArray("items");
                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);


                        String titulo = jsonObject.getString("titulo");
                        String descripcion = jsonObject.getString("descripcion");

                        listaGet.add(new Entidad(imagen[i], titulo, descripcion));
                        prueba.append(titulo + '\n');

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //***********************************************************
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);
        /* ================================================================================================== */

        return listaGet;
    }

}

