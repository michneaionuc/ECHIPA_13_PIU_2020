package com.example.smarthouse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class ParentsMainPage: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.parents_main_page)

        val vacuumButton: ImageButton = findViewById(R.id.vacuum_button)

        vacuumButton.setOnClickListener {
            val intent = Intent(this, VacuumOffActivity::class.java)
            startActivity(intent)
        }

        val temperatureButton: ImageButton = findViewById(R.id.temperature_button)

        temperatureButton.setOnClickListener {
            val intent = Intent(this, TemperatureActivity::class.java)
            startActivity(intent)
        }

        val securityButton: Button = findViewById(R.id.security_button)

        securityButton.setOnClickListener {
            val intent = Intent(this, SecurityMainActivity::class.java)
            startActivity(intent)
        }
    }
}