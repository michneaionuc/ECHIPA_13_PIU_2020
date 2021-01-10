package com.example.smarthouse

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.bathtub.BathtubMenuActivity
import com.example.smarthouse.light.LightActivity

class KidsMainPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kids_main_page)

        val user = intent.getStringExtra("user")

        val bathtubButton: ImageButton = findViewById(R.id.bathtub_button)

        bathtubButton.setOnClickListener {
            val intent = Intent(this, BathtubMenuActivity::class.java)
            intent.putExtra("user", user);
            startActivity(intent)
        }

        val lightButton: ImageButton = findViewById(R.id.light_button)

        lightButton.setOnClickListener {
            val intent = Intent(this, LightActivity::class.java)
            intent.putExtra("user", user);
            startActivity(intent)
        }
    }
}