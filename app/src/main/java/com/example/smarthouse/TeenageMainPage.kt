package com.example.smarthouse

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.security.SecurityMainActivity
import com.example.smarthouse.temperature.TemperatureActivity
import com.example.smarthouse.vacuum.VacuumOffActivity

class TeenageMainPage: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teenage_main_page)

        val vacuumButton: ImageButton = findViewById(R.id.vacuum_button)

        val user = intent.getStringExtra("user")

        vacuumButton.setOnClickListener {
            val intent = Intent(this, VacuumOffActivity::class.java)
            intent.putExtra("user", user);
            startActivity(intent)
        }

        val temperatureButton: ImageButton = findViewById(R.id.temperature_button)

        temperatureButton.setOnClickListener {
            val intent = Intent(this, TemperatureActivity::class.java)
            intent.putExtra("user", user);
            startActivity(intent)
        }

        val socketButton: ImageButton = findViewById(R.id.socket_button)

        socketButton.setOnClickListener {
            val intent = Intent(this, SocketSwitchesActivity::class.java)
            intent.putExtra("user", user);
            startActivity(intent)
        }
    }
}