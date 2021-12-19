package com.example.festejosapp_reto3_paolaramirez_g39.Controlador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.festejosapp_reto3_paolaramirez_g39.R;
import com.example.festejosapp_reto3_paolaramirez_g39.Vista.Fragment_Favoritos;
import com.example.festejosapp_reto3_paolaramirez_g39.Vista.Fragment_Get;
import com.example.festejosapp_reto3_paolaramirez_g39.Vista.Fragment_Inicio;
import com.example.festejosapp_reto3_paolaramirez_g39.Vista.Fragment_Productos;
import com.example.festejosapp_reto3_paolaramirez_g39.Vista.Fragment_Servicios;
import com.example.festejosapp_reto3_paolaramirez_g39.Vista.Fragment_Sucursales;


public class MainActivity extends AppCompatActivity {

    Fragment subPantalla1, subPantalla2, subPantalla3, subPantalla4, subPantallaInicio, subPantalla5;
    FragmentTransaction intercambio;

    Button boton1, boton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subPantalla1 = new Fragment_Productos();
        subPantalla2 = new Fragment_Servicios();
        subPantalla3 = new Fragment_Sucursales();
        subPantalla4 = new Fragment_Favoritos();
        subPantalla5 = new Fragment_Get();

        subPantallaInicio = new Fragment_Inicio();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragments, subPantallaInicio).commit();

        boton1 = (Button)findViewById(R.id.boton1);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intercambio = getSupportFragmentManager().beginTransaction();
                intercambio.replace(R.id.contenedor_fragments, subPantalla1).commit();
            }
        });

        boton2 = (Button)findViewById(R.id.boton2);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intercambio = getSupportFragmentManager().beginTransaction();
                intercambio.replace(R.id.contenedor_fragments, subPantalla2).commit();
            }
        });


    }
    //****************************************** MENU DE OPCIONES ***************************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuopciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.opcion1){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla1).commit();
        }
        if (id == R.id.opcion2){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla2).commit();
        }
        if (id == R.id.opcion3){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla3).commit();
        }
        if (id == R.id.opcion4){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantallaInicio).commit();
        }
        if (id == R.id.opcion5){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla4).commit();
        }

        if (id == R.id.opcion6){
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor_fragments, subPantalla5).commit();
        }
        return super.onOptionsItemSelected(item);
    }
    //*****************************************************************************************************************

}