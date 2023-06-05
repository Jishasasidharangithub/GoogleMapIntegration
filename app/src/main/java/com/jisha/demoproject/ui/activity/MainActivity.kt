package com.jisha.demoproject.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.jisha.demoproject.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding?.maps?.onCreate(savedInstanceState)
        setContentView(binding?.root)
        init()

    }

    private fun init() {
        binding?.maps?.getMapAsync(this)
    }

     override fun onMapReady(googleMap: GoogleMap) {
         val location = LatLng(11.2485, 75.8336)
         binding?.maps?.getMapAsync {gmp->
             gmp.clear()
             gmp.addMarker(MarkerOptions().position(location).title("Marker in San Francisco"))
             gmp.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 18f))
    }
     }
    override fun onResume() {
        binding?.maps?.onResume()
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding?.maps?.onDestroy()
    }
    override fun onLowMemory() {
        super.onLowMemory()
        binding?.maps?.onLowMemory()
    }

    override fun onPause() {
        super.onPause()
        binding?.maps?.onPause()

    }
}