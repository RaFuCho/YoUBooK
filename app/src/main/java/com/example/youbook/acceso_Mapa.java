package com.example.youbook;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class acceso_Mapa extends AppCompatActivity {

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_mapa);

        Configuration.getInstance().load(getApplicationContext(), PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));

        MapView mapView = findViewById(R.id.mapView);
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);

        double LibreriaTortosaLatitude = -33.4590035;
        double LibreriaTortosaLongitude = -70.6679887;

        double LibreriaMikeLatitude = -33.4509947;
        double LibreriaMikeLongitude = -70.6744844;

        double LibreriaGamLatitude = -33.4509364;
        double LibreriaGamLongitude = -70.6928262;

        GeoPoint libreriaTortosa = new GeoPoint(LibreriaTortosaLatitude, LibreriaTortosaLongitude);
        GeoPoint libreriaMike = new GeoPoint(LibreriaMikeLatitude, LibreriaMikeLongitude);
        GeoPoint libreriaGam = new GeoPoint(LibreriaGamLatitude, LibreriaGamLongitude);

        Marker TortosaMarker = new Marker(mapView);
        TortosaMarker.setPosition(libreriaTortosa);
        TortosaMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        TortosaMarker.setTitle("Libreria la Tortosa");
        TortosaMarker.setSnippet("Libros a mejores precios");

        Marker MikeMarker = new Marker(mapView);
        MikeMarker.setPosition(libreriaMike);
        MikeMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        MikeMarker.setTitle("Libreria Mike");
        MikeMarker.setSnippet("Libreria principal de Chile");

        Marker GamMarker = new Marker(mapView);
        GamMarker.setPosition(libreriaMike);
        GamMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        GamMarker.setTitle("Libreria Gam");
        GamMarker.setSnippet("Buenos libros a buenos costos");

        mapView.getOverlays().add(TortosaMarker);
        mapView.getOverlays().add(MikeMarker);
        mapView.getOverlays().add(GamMarker);

        IMapController mapController = mapView.getController();
        mapController.setCenter(libreriaGam);
        mapController.setZoom(18);
    }

    public void accesoVideo(View view){
        Intent intent = new Intent(this, acceso_Publi.class);
        startActivity(intent);

    }
}

