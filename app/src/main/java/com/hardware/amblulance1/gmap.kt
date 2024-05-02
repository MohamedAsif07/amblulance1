package com.hardware.amblulance1



import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class gmap : AppCompatActivity() {

    private lateinit var mapFragment: SupportMapFragment
    private lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gmap)

        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync {
            googleMap = it
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return@getMapAsync
            }
            googleMap.isMyLocationEnabled = true

            // Create a green marker icon
            val greenMarkerIcon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)

            val location1 = LatLng(13.0178, 80.2711)
            googleMap.addMarker(MarkerOptions().position(location1).title("apollo spectra hospitals thoraipakkam").icon(greenMarkerIcon))

            val location2 = LatLng(12.9111164, 80.2286787)
            googleMap.addMarker(MarkerOptions().position(location2).title("Chettinad Multispecility Hospital - karapakkam"))

            val location3 = LatLng(2.9490, 80.2090)
            googleMap.addMarker(MarkerOptions().position(location3).title("DR.KAMAKSHI MEMORIAL HOSPITALS").icon(greenMarkerIcon))

            val location4 = LatLng(12.9328, 80.2317)
            googleMap.addMarker(MarkerOptions().position(location4).title("Nanthini Hospitals").icon(greenMarkerIcon))

            val location5 = LatLng(12.9151,80.2298)
            googleMap.addMarker(MarkerOptions().position(location5).title("Apollo Medical Center Karapakkam").icon(greenMarkerIcon))

            val location6 = LatLng(12.8978, 80.2062)
            googleMap.addMarker(MarkerOptions().position(location6).title("Gleneagles HealthCity Chenna").icon(greenMarkerIcon))

            val location7 = LatLng(12.9403, 80.2412)
            googleMap.addMarker(MarkerOptions().position(location7).title("Mount SuperSpecialty Hospital").icon(greenMarkerIcon))

            val location8 = LatLng(12.939266,80.234695)
            googleMap.addMarker(MarkerOptions().position(location8).title("Cloudine hospital"))


            // Move camera to the first marker
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location1, 10f))

            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, Call::class.java))
                finish() // optional, if you want to close this activity
            }, 30000) //
            // Inside the getMapAsync callback

            googleMap.setOnMarkerClickListener { marker ->
                // Check which marker was clicked
                when (marker.title) {
                    "Chettinad Multispecility Hospital - karapakkam" -> {
                        // Handle the click on West thambram marker
                        // For example, start a new activity or do something else
                        startActivity(Intent(this, docter1::class.java))
                        true
                    }
                    "Cloudine hospital" -> {
                        // Handle the click on porur marker
                        // For example, start a new activity or do something else
                        startActivity(Intent(this, docter2::class.java))
                        true
                    }
                    // Add cases for other markers as needed
                    else -> false
                }
            }
// 1
        }
    }
}
