package com.example.smarthouse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class VacuumOffActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vacuum_off_page)

        val powerOnButton :ImageButton = findViewById(R.id.power_on_button)

        powerOnButton.setOnClickListener {
            val intent = Intent(this, VacuumOnActivity::class.java)
            startActivity(intent)
        }
    }
}