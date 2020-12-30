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

        val securityButton: ImageButton = findViewById(R.id.security_button)

        securityButton.setOnClickListener {
            val intent = Intent(this, SecurityMainActivity::class.java)
            startActivity(intent)
        }

        val lightButton: ImageButton = findViewById(R.id.light_button)

        lightButton.setOnClickListener {
            val intent = Intent(this, LightActivity::class.java)
            startActivity(intent)
        }

        val socketButton: ImageButton = findViewById(R.id.socket_button)

        socketButton.setOnClickListener {
            val intent = Intent(this, SocketSwitchesActivity::class.java)
            startActivity(intent)
        }
    }
}