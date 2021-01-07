package com.example.smarthouse.bathtub

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.smarthouse.R

class BathtubMassageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bathtub_massage)

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
        }

        val intensityCheck: CheckBox = findViewById(R.id.check_intensity)
        intensityCheck.setOnClickListener {
            if (findViewById<SeekBar>(R.id.massage_bar).isVisible) {
                findViewById<SeekBar>(R.id.massage_bar).visibility = View.GONE
            } else {
                findViewById<SeekBar>(R.id.massage_bar).visibility = View.VISIBLE
            }
        }

        val musicButton: ImageButton = findViewById(R.id.music_button)
        musicButton.setOnClickListener {
            val intent = Intent(this, BathtubMusicActivity::class.java)
            intent.putExtra("user", user);
            startActivity(intent)
        }
    }
}