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

class SecurityFrontDoorActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.security_front_door_page)

        val lockButton :ImageButton  =findViewById(R.id.lock_button)

        val doorStatus : TextView = findViewById(R.id.door_status)

        lockButton.setOnClickListener {
            if(doorStatus.text.toString() == "The door is opened!") {
                lockButton.setBackgroundResource(R.drawable.unlock_front_door)
                doorStatus.text = "The door is closed!"
            } else {
                lockButton.setBackgroundResource(R.drawable.lock_front_door)
                doorStatus.text = "The door is opened!"
            }
        }
    }
}