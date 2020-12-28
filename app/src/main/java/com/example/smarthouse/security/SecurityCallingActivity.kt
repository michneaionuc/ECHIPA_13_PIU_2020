package com.example.smarthouse.security

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.R
import java.time.LocalDateTime
import java.util.*

class SecurityCallingActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.security_calling_page)

        val closeButton: ImageButton = findViewById(R.id.close_button)

        closeButton.setOnClickListener {
            finish()
        }
    }
}