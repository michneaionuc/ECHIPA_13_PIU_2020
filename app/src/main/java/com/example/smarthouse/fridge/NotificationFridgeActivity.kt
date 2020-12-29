package com.example.smarthouse.fridge

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.R

class NotificationFridgeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_fridge)

        val notification1: ImageButton = findViewById(R.id.notification_fridge_1)
        notification1.setOnClickListener {
            notification1.visibility = View.GONE
        }

        val notification2: ImageButton = findViewById(R.id.notification_fridge_2)
        notification2.setOnClickListener {
            notification2.visibility = View.GONE
        }

        val notification3: ImageButton = findViewById(R.id.notification_fridge_3)
        notification3.setOnClickListener {
            notification3.visibility = View.GONE
        }

        val notification4: ImageButton = findViewById(R.id.notification_fridge_4)
        notification4.setOnClickListener {
            notification4.visibility = View.GONE
        }
    }
}