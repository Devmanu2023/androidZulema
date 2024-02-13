package com.example.maps.fragments

import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.maps.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment(), OnMapReadyCallback {

    private lateinit var googleMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = view.findViewById<MapView>(R.id.map)
        mapFragment.onCreate(savedInstanceState)
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {

        googleMap = map

        if (map != null) {


             // Mover la cámara a una ubicación específica (por ejemplo, latitud y longitud)
            val sena = LatLng(2.482846578974007, -76.56253853293643)
            googleMap.addMarker(MarkerOptions().position(sena).title("Sena"))


            // Agregar más marcadores según sea necesario
            val morro = LatLng(2.4449261743007327, -76.6001259041013)
            googleMap.addMarker(MarkerOptions().position(morro).title("Morro"))

            val parque = LatLng(2.442081779401729, -76.60630609060665)
            googleMap.addMarker(MarkerOptions().position(parque).title("Parque Caldas"))

            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sena, 15f))





        }


    }


}