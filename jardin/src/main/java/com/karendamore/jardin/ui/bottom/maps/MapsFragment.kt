package com.karendamore.jardin.ui.bottom.maps

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.karendamore.jardin.R

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /** Manipulates the map once available. ...*/

        val iglesia = LatLng(5.5990476,-75.8189662)
        googleMap.addMarker(
            MarkerOptions()
                .position(iglesia)
                .title("Basílica de la Inmaculada Concepción")
                .snippet("Basílica "))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(iglesia,15F))

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