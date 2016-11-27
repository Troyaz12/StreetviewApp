package com.example.android.grandcanyonapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class MainActivity extends FragmentActivity implements OnStreetViewPanoramaReadyCallback {

    LatLng colosseum = new LatLng(41.8900487,12.4926753);
    LatLng stoneHenge = new LatLng(51.1788898,-1.8262146);
    LatLng grandCanyon = new LatLng(36.0579667,-112.1430996);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StreetViewPanoramaFragment streetViewPanoramaFragment =
                (StreetViewPanoramaFragment) getFragmentManager()
                        .findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);

    //    StreetViewPanoramaFragment frag = (StreetViewPanoramaFragment) getFragmentManager().findFragmentById(R.id.streetviewpanorama);
      //  frag.getStreetViewPanoramaAsync(this);

    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        streetViewPanorama.setPosition(stoneHenge);
     //   streetViewPanorama.setPosition(new LatLng(36.0579667,-112.1430996));

        StreetViewPanoramaCamera camera = new StreetViewPanoramaCamera.Builder()
                .bearing(180)
                .build();

        streetViewPanorama.animateTo(camera,10000);
/*
        @Override
        public void onStreetViewPanoramaReady(StreetViewPanorama panorama) {
            // Set the panorama location on startup, when no
            // panoramas have been loaded.

            panorama.setPosition(new LatLng(36.0579667,-112.1430996));
            StreetViewPanoramaCamera camera = new StreetViewPanoramaCamera.Builder()
                    .bearing(180)
                    .build();
            panorama.animateTo(camera,10000);
*/
        }
}
