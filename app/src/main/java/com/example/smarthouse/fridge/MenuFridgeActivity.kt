package com.example.smarthouse.fridge

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.R

class MenuFridgeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_fridge)

        val notificationButton: ImageButton = findViewById(R.id.button_fridge_notification)
        notificationButton.setOnClickListener {
            val intent = Intent(this, NotificationFridgeActivity::class.java)
            startActivity(intent)
        }

        val settingsButton: ImageButton = findViewById(R.id.button_fridge_settings)
        settingsButton.setOnClickListener {
            val intent = Intent(this, SettingsFridgeActivity::class.java)
            startActivity(intent)
        }
    }


}