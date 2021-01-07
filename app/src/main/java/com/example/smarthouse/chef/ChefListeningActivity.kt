package com.example.smarthouse.chef

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.R


class ChefListeningActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chef_listening)

        val user = intent.getStringExtra("user")
        val userIcon: ImageView = findViewById(R.id.user_icon)

        Handler().postDelayed(Runnable {
            val i = Intent(this@ChefListeningActivity, ChefProcessingActivity::class.java)
            i.putExtra("user", user);
            startActivity(i)
            finish()
        }, 3500)

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
    }
}