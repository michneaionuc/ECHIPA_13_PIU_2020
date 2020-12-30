package com.example.smarthouse.fridge

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.R

class MenuFridgeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_fridge)

        val user = intent.getStringExtra("user")
        val userIcon: ImageView = findViewById(R.id.user_icon)

        val notificationButton: ImageButton = findViewById(R.id.button_fridge_notification)
        notificationButton.setOnClickListener {
            val intent = Intent(this, NotificationFridgeActivity::class.java)
            intent.putExtra("user", user);
            startActivity(intent)
        }

        val settingsButton: ImageButton = findViewById(R.id.button_fridge_settings)
        settingsButton.setOnClickListener {
            val intent = Intent(this, SettingsFridgeActivity::class.java)
            intent.putExtra("user", user);
            startActivity(intent)
        }

        when(user) {
            "parents" -> {
                userIcon.setBackgroundResource(R.drawable.parents_icon)
            }
            "teenage" -> {
                userIcon.setBackgroundResource(R.drawable.teenage_girl_icon)
            }
            "grandparents" -> {
                userIcon.setBackgroundResource(R.drawable.grand_parents_icon)
            }
        }

    }


}