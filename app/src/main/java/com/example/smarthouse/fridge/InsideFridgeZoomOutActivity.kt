package com.example.smarthouse.fridge

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.R


class InsideFridgeZoomOutActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inside_fridge_zoom_out)

        val user = intent.getStringExtra("user")
        val userIcon: ImageView = findViewById(R.id.user_icon)

        when (user) {
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

        val buttonRaft1: Button = findViewById(R.id.button_raft_1)
        buttonRaft1.setOnClickListener {
            buttonRaft1.setBackgroundColor(Color.TRANSPARENT)
            val intent = Intent(this, InsideFridgeZoomInActivity::class.java)
            intent.putExtra("user", user);
            intent.putExtra("raft", 1)
            startActivity(intent)
        }

        val buttonRaft2: Button = findViewById(R.id.button_raft_2)
        buttonRaft2.setOnClickListener {
            buttonRaft2.setBackgroundColor(Color.TRANSPARENT)
            val intent = Intent(this, InsideFridgeZoomInActivity::class.java)
            intent.putExtra("user", user);
            intent.putExtra("raft", 2)
            startActivity(intent)
        }

        val buttonRaft3: Button = findViewById(R.id.button_raft_3)
        buttonRaft3.setOnClickListener {
            buttonRaft3.setBackgroundColor(Color.TRANSPARENT)
            val intent = Intent(this, InsideFridgeZoomInActivity::class.java)
            intent.putExtra("user", user);
            intent.putExtra("raft", 3)
            startActivity(intent)
        }

        val buttonRaft4: Button = findViewById(R.id.button_door_1)
        buttonRaft4.setOnClickListener {
            buttonRaft4.setBackgroundColor(Color.TRANSPARENT)
            val intent = Intent(this, InsideFridgeZoomInActivity::class.java)
            intent.putExtra("user", user);
            intent.putExtra("raft", 4)
            startActivity(intent)
        }

        val buttonRaft5: Button = findViewById(R.id.button_door_2)
        buttonRaft5.setOnClickListener {
            buttonRaft5.setBackgroundColor(Color.TRANSPARENT)
            val intent = Intent(this, InsideFridgeZoomInActivity::class.java)
            intent.putExtra("user", user);
            intent.putExtra("raft", 5)
            startActivity(intent)
        }


    }
}