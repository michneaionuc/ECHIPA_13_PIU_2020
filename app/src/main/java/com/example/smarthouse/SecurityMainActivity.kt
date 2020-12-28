package com.example.smarthouse

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime
import java.util.*

class SecurityMainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.security_main_page)

        val lockButton :ImageButton  =findViewById(R.id.lock_button)
        val phoneButton :ImageButton  =findViewById(R.id.phone_button)
        val viewButton :ImageButton  =findViewById(R.id.view_button)
        val frontDoorButton :ImageButton  =findViewById(R.id.front_door_button)

        val homeStatus : TextView = findViewById(R.id.home_status)

        lockButton.setOnClickListener {
            if(homeStatus.text.toString() == "Your house is locked!") {
                lockButton.setBackgroundResource(R.drawable.unlock)
                homeStatus.text = "Your house is unlocked!"
            } else {
                lockButton.setBackgroundResource(R.drawable.lock)
                homeStatus.text = "Your house is locked!"
            }
        }

        phoneButton.setOnClickListener {
            val intent = Intent(this, SecurityEmergencyCallActivity::class.java)
            startActivity(intent)
        }

        viewButton.setOnClickListener {
            val intent = Intent(this, SecurityViewActivity::class.java)
            startActivity(intent)
        }

        frontDoorButton.setOnClickListener {
            val intent = Intent(this, SecurityFrontDoorActivity::class.java)
            startActivity(intent)
        }
    }
}