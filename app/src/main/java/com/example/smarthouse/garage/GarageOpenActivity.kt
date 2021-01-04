package com.example.smarthouse.garage

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.R

class GarageOpenActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.garage_open_page)

        val garageImage = findViewById<ImageView>(R.id.garage_open_icon)

        Handler().postDelayed({
            garageImage.visibility = View.GONE
        }, 1000)
        Handler().postDelayed({
            garageImage.visibility = View.VISIBLE
        }, 2000)
        Handler().postDelayed({
            garageImage.visibility = View.GONE
        }, 3000)
        Handler().postDelayed({
            garageImage.visibility = View.VISIBLE
        }, 4000)
        Handler().postDelayed({
            garageImage.visibility = View.GONE
        }, 5000)
        Handler().postDelayed({
            garageImage.visibility = View.VISIBLE
        }, 6000)
        Handler().postDelayed({
            garageImage.visibility = View.GONE
        }, 7000)
        Handler().postDelayed({
            garageImage.visibility = View.VISIBLE
        }, 8000)
        Handler().postDelayed({
            garageImage.visibility = View.GONE
        }, 9000)
        Handler().postDelayed({
            garageImage.visibility = View.VISIBLE
        }, 10000)

        Handler().postDelayed({
            finish()
        }, 11000)
    }
}