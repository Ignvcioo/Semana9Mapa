package com.example.semana9mapa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mapa;
    private SupportMapFragment mapaFragmento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapaFragmento = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa);
        mapaFragmento.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mapa = googleMap;
        mapa.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        LatLng ubicacion = new LatLng(-30.60437199913577, -71.20482335957078);
        mapa.addMarker(new MarkerOptions().position(ubicacion).title("IP SANTO TOMAS"));
        mapa.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));
        mapa.moveCamera(CameraUpdateFactory.zoomTo(15f));

        mapa.getUiSettings().setZoomControlsEnabled(true);
        mapa.getUiSettings().setCompassEnabled(true);

        mapa.getUiSettings().setZoomGesturesEnabled(false);
        mapa.getUiSettings().setScrollGesturesEnabled(false);
    }
}