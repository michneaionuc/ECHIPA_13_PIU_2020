package com.example.smarthouse.chef

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.R

class ChefFoundRecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chef_found_recipe)

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

    }
}