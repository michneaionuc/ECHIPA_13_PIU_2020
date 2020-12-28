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

class SecurityEmergencyCallActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.security_emergency_call_page)

        val yesButton: ImageButton = findViewById(R.id.yes)
        val noButton: ImageButton = findViewById(R.id.no)

        yesButton.setOnClickListener {
            val intent = Intent(this, SecurityCallingActivity::class.java)
            startActivity(intent)
        }

        noButton.setOnClickListener {
            finish()
        }
    }
}