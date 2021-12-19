package com.example.festejosapp_reto3_paolaramirez_g39.Vista;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.festejosapp_reto3_paolaramirez_g39.BuildConfig;
import com.example.festejosapp_reto3_paolaramirez_g39.R;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;


public class Fragment_Sucursales extends Fragment {

    Drawable drawable1, drawable2, drawable3;
    ImageView imagen1, imagen2, imagen3;

    View v;

    private MapView myOpenMapView;
    private MapController myMapController;
    GeoPoint Bogota, Cartagena, Miami;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__sucursales, container, false);
        //------------------------------------------------------------------------------------------

        myOpenMapView = (MapView) v.findViewById(R.id.openmapview);


        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);

        /**
         * punto de geolocalizacion
         */
        Bogota = new GeoPoint(4.64751378082628, -74.10151286877934);
        Cartagena = new GeoPoint(10.405636227600224, -75.50698322669707);
        Miami = new GeoPoint(25.762603750380165, -80.20851899918023);

        myOpenMapView.setBuiltInZoomControls(true);

        myMapController = (MapController) myOpenMapView.getController();
        myMapController.setCenter(Bogota);
        myMapController.setZoom(6);

        myOpenMapView.setMultiTouchControls(true);

        /* -------------------------------------------------------------------------------------------------- */
        final MyLocationNewOverlay myLocationoverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(getContext()), myOpenMapView);
        myOpenMapView.getOverlays().add(myLocationoverlay); //No añadir si no quieres una marca
        myLocationoverlay.enableMyLocation();

        myLocationoverlay.runOnFirstFix(new Runnable() {
            public void run() {
                myMapController.animateTo(myLocationoverlay.getMyLocation());
            }
        });
        /* -------------------------------------------------------------------------------------------------- */

        /**
         * Marcas en el Mapa
         */

        ArrayList<OverlayItem> puntos = new ArrayList<OverlayItem>();
        puntos.add(new OverlayItem("Bogota", "Capital", Bogota));
        puntos.add(new OverlayItem("Cartagena", "Tienda 1", Cartagena));
        puntos.add(new OverlayItem("Miami", "Tienda 2", Miami));

        ItemizedIconOverlay.OnItemGestureListener<OverlayItem> tap = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemLongPress(int arg0, OverlayItem arg1) {
                return false;
            }
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }
        };

        ItemizedOverlayWithFocus<OverlayItem> capa = new ItemizedOverlayWithFocus<OverlayItem>(getContext(), puntos, tap);
        capa.setFocusItemsOnTap(true);
        myOpenMapView.getOverlays().add(capa);

        //------------------------------------------------------------------------------------------

        return v;
    }
}
