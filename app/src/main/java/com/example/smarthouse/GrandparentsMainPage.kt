package com.example.smarthouse

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.security.SecurityMainActivity
import com.example.smarthouse.temperature.TemperatureActivity
import com.example.smarthouse.vacuum.VacuumOffActivity

class GrandparentsMainPage: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grandparents_main_page)

        val user = intent.getStringExtra("user")

        val temperatureButton: ImageButton = findViewById(R.id.temperature_button)

        temperatureButton.setOnClickListener {
            val intent = Intent(this, TemperatureActivity::class.java)
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