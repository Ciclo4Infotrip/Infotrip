package com.karendamore.jardin.maps

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.karendamore.jardin.R

class MapsFragment : Fragment() {

    private val args : MapsFragmentArgs by navArgs()

    private val callback = OnMapReadyCallback { googleMap ->
        /** Manipulates the map once available. ...*/

        val jardin= args.jardin

        val posJardin= LatLng(jardin.latitud,jardin.longitud)
        googleMap.addMarker(
            MarkerOptions()
                .position(posJardin)
                .title(jardin.nombre)
                .snippet(jardin.puntuacion))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(posJardin,15F))


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}