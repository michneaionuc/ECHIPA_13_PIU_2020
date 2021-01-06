package com.example.smarthouse.bathtub

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.smarthouse.R
import pl.droidsonroids.gif.GifImageView

class BathtubMusicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bathtub_music)

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

        val buttonStart: Button = findViewById<Button>(R.id.start_music_button)
        buttonStart.setOnClickListener {
            if (findViewById<GifImageView>(R.id.massage_gif).isVisible) {
                findViewById<GifImageView>(R.id.massage_gif).visibility = View.GONE
                buttonStart.text = "START"
            } else {
                findViewById<GifImageView>(R.id.massage_gif).visibility = View.VISIBLE
                buttonStart.text = "STOP"
            }
        }

    }
}