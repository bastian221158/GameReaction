package com.example.gamereaction;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {

    private static final int REQUEST_LOCATION = 1;
    private TextView ubicacionTxt, nombreJugadortxt, areaJuego;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_juego);

        ubicacionTxt = findViewById(R.id.ubicacionTxt);
        nombreJugadortxt = findViewById(R.id.nombreJugadortxt);
        areaJuego = findViewById(R.id.areaJuego);

        String nombre = getIntent().getStringExtra("NOMBRE_JUGADOR");
        if (nombre != null) {
            nombreJugadortxt.setText(nombre);
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        } else {
            obtenerCiudad();
        }
    }

    private void obtenerCiudad() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                Geocoder geocoder = new Geocoder(SecondActivity.this, Locale.getDefault());
                try {
                    List<Address> direcciones = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                    if (direcciones != null && !direcciones.isEmpty()) {
                        String ciudad = direcciones.get(0).getLocality();
                        if (ciudad != null) {
                            ubicacionTxt.setText("📍 Ciudad: " + ciudad);
                        } else {
                            ubicacionTxt.setText("📍 Ciudad desconocida");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    ubicacionTxt.setText("Error obteniendo ciudad");
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_LOCATION && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            obtenerCiudad();
        } else {
            ubicacionTxt.setText("Permiso de ubicación denegado");
        }
    }
}