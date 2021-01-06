package com.example.smarthouse.bathtub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.smarthouse.R
import com.example.smarthouse.fridge.SettingsFridgeActivity
import pl.droidsonroids.gif.GifImageView

class BathtubMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bathtub_menu)

        val user = intent.getStringExtra("user")
        val userIcon: ImageView = findViewById(R.id.user_icon)

        when (user) {
            "parents" -> {
                userIcon.setBackgroundResource(R.drawable.parents_icon)
            }
            "teenage" -> {
                userIcon.setBackgroundResource(R.drawable.teenage_girl_icon)
            }
            "grandparents" -> {
                userIcon.setBackgroundResource(R.drawable.grand_parents_icon)
            }
            "kids" -> {
                userIcon.setBackgroundResource(R.drawable.kids_icon)
                findViewById<Button>(R.id.button_water_temp).isEnabled = false
                findViewById<Button>(R.id.button_water_level).isEnabled = false
                findViewById<Button>(R.id.button_water_massage).isEnabled = false
            }
        }

        val bubbleButton: Button = findViewById(R.id.button_bubble)
        val bubbleGif: GifImageView = findViewById(R.id.bubble_gif)
        bubbleButton.setOnClickListener {
            if (bubbleGif.visibility == View.VISIBLE) {
                bubbleGif.visibility = View.GONE
            } else {
                bubbleGif.visibility = View.VISIBLE
            }
        }

        val foamButton: Button = findViewById(R.id.button_foam)
        val foamGif: GifImageView = findViewById(R.id.foam_gif)
        foamButton.setOnClickListener {
            if (foamGif.visibility == View.VISIBLE) {
                foamGif.visibility = View.GONE
            } else {
                foamGif.visibility = View.VISIBLE
            }
        }

        val waterLevelButton: Button = findViewById(R.id.button_water_level)
        waterLevelButton.setOnClickListener {
            val intent = Intent(this, BathtubWaterLevelActivity::class.java)
            intent.putExtra("user", user);
            startActivity(intent)
        }

        val waterTempButton: Button = findViewById(R.id.button_water_temp)
        waterTempButton.setOnClickListener {
            val intent = Intent(this, BathtubWaterTemperatureActivity::class.java)
            intent.putExtra("user", user);
            startActivity(intent)
        }
    }
}