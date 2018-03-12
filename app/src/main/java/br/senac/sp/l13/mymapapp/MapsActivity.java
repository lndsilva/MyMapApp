package br.senac.sp.l13.mymapapp;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements
        GoogleMap.OnMarkerClickListener,
        OnMapReadyCallback {

    private static final LatLng senacLargoTreze = new LatLng(-23.6471254, -46.7038018);
    private static final LatLng mercadoMunicipalSA = new LatLng(-23.6501998, -46.6998928);
    private static final LatLng casaCultutaSA = new LatLng(-23.6467935, -46.7086386);

    private Marker msenacLargoTreze;
    private Marker mmercadoMunicipalSA;
    private Marker mcasaCultutaSA;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;

        msenacLargoTreze = map.addMarker(new MarkerOptions()
                .position(senacLargoTreze)
                .title("Senac Largo Treze")
                .snippet("Cursos Técnicos e Livres")
                .draggable(true));
        msenacLargoTreze.setTag(0);

        mmercadoMunicipalSA = map.addMarker(new MarkerOptions()
                .position(mercadoMunicipalSA)
                .title("Mercado Municipal")
                .snippet(getString(R.string.m_cardomunicial))
                .draggable(true));
        mmercadoMunicipalSA.setTag(0);

        mcasaCultutaSA = map.addMarker(new MarkerOptions()
                .position(casaCultutaSA)
                .title(getString(R.string.c_cultura))
                .draggable(true));
        msenacLargoTreze.setTag(0);

        map.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        Integer clickCount = (Integer) marker.getTag();


        if (clickCount != null) {
            clickCount = clickCount + 1;
            marker.setTag(clickCount);
            Toast.makeText(this,
                    marker.getTitle() +
                            " has been clicked " + clickCount + " times.",
                    Toast.LENGTH_SHORT).show();
        }

        return false;
    }
}
