package com.example.smarthouse.vacuum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.R

class VacuumOffActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vacuum_off_page)

        val powerOnButton :ImageButton = findViewById(R.id.power_on_button)

        val userIcon: ImageView = findViewById(R.id.user_icon)

        val user = intent.getStringExtra("user")

        when(user) {
            "parents" -> {
                userIcon.setBackgroundResource(R.drawable.parents_icon)
            }
            "teenage" -> {
                userIcon.setBackgroundResource(R.drawable.teenage_girl_icon)
            }
        }

        powerOnButton.setOnClickListener {
            val intent = Intent(this, VacuumOnActivity::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        }
    }
}