package com.example.smarthouse

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.MotionEvent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.esri.arcgisruntime.geometry.GeometryEngine
import com.esri.arcgisruntime.geometry.Point
import com.esri.arcgisruntime.geometry.SpatialReferences
import com.esri.arcgisruntime.mapping.ArcGISMap
import com.esri.arcgisruntime.mapping.Basemap
import com.esri.arcgisruntime.mapping.view.DefaultMapViewOnTouchListener
import com.esri.arcgisruntime.mapping.view.Graphic
import com.esri.arcgisruntime.mapping.view.GraphicsOverlay
import com.esri.arcgisruntime.mapping.view.MapView
import com.esri.arcgisruntime.symbology.PictureMarkerSymbol
import kotlin.math.roundToInt


class MapActivity : AppCompatActivity() {

    private lateinit var mapView: MapView

    var mGraphicsOverlay: GraphicsOverlay? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        // create a map with the BasemapType topographic -- in Cluj
        val map = ArcGISMap(Basemap.Type.TOPOGRAPHIC, 46.77142091, 23.59279403, 16)

        mapView = findViewById<MapView>(R.id.mapView)
        // set the map to be displayed in the layout's MapView
        mapView.map = map

        // create a new graphics overlay and add it to the mapview
        mGraphicsOverlay = GraphicsOverlay()
        mapView.getGraphicsOverlays().add(mGraphicsOverlay)


        //[DocRef: Name=Picture Marker Symbol Drawable-android, Category=Fundamentals, Topic=Symbols and Renderers]
        //Create a picture marker symbol from an app resource
        val houseIcon =
            ContextCompat.getDrawable(this, R.drawable.house_icon) as BitmapDrawable?
        val houseIconSymbol = PictureMarkerSymbol(houseIcon)

        //Optionally set the size, if not set the image will be auto sized based on its size in pixels,
        //its appearance would then differ across devices with different resolutions.
        houseIconSymbol.height = 60f
        houseIconSymbol.width = 60f

        //Optionally set the offset, to align the base of the symbol aligns with the point geometry
        houseIconSymbol.offsetY =
            11f //The image used for the symbol has a transparent buffer around it, so the offset is not simply height/2

        houseIconSymbol.loadAsync()

        //[DocRef: END]
        //add a new graphic with the same location as the initial viewpoint
        val houseIconPoint =
            Point(
                23.59279403, 46.771420,
                SpatialReferences.getWgs84()
            )
        val houseIconGraphic = Graphic(houseIconPoint, houseIconSymbol)
        mGraphicsOverlay!!.graphics.add(houseIconGraphic)


        //mouse listener
        mapView.onTouchListener = object : DefaultMapViewOnTouchListener(this, mapView) {

            @SuppressLint("SetTextI18n")
            override fun onSingleTapConfirmed(motionEvent: MotionEvent): Boolean {
                // get the point that was tapped on the screen
                val screenPoint =
                    android.graphics.Point(motionEvent.x.roundToInt(), motionEvent.y.roundToInt())
                println(screenPoint.x)
                println(screenPoint.y)
                if (screenPoint.x > 450 && screenPoint.x < 700 && screenPoint.y > 820 && screenPoint.y < 1100) {
                    val intent = Intent(this@MapActivity, MainActivity::class.java)
                    startActivity(intent)
                }
                // create a map point from that screen point
                val mapPoint = mapView.screenToLocation(screenPoint)
                // convert the point to WGS84 for obtaining lat/lon format
                val wgs84Point =
                    GeometryEngine.project(mapPoint, SpatialReferences.getWgs84()) as Point
                // create a textview for the callout
                val calloutContent = TextView(applicationContext).apply {
                    setTextColor(Color.BLACK)
                    setSingleLine()
                    // format coordinates to 4 decimal places and display lat long read out
                    println(wgs84Point.y)
                    println(wgs84Point.x)
                    text = "Lat: " + wgs84Point.y.toFloat() + ", Long: " + wgs84Point.x.toFloat()
                }
                // get the callout, set its content and show it and the tapped location
                mapView.callout.apply {
                    location = mapPoint
                    content = calloutContent
                    show()
                }

                // center the map on the tapped location
                mapView.setViewpointCenterAsync(mapPoint)

                return true
            }
        }

    }


}