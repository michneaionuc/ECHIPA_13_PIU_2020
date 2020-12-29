package com.example.smarthouse

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.security.SecurityMainActivity
import com.example.smarthouse.temperature.TemperatureActivity
import com.example.smarthouse.vacuum.VacuumOffActivity

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
    }

    //back to log in
    fun login(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}