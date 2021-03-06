package com.example.smarthouse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.bathtub.BathtubMenuActivity
import com.example.smarthouse.fridge.MenuFridgeActivity
import com.example.smarthouse.light.LightActivity
import com.example.smarthouse.temperature.TemperatureActivity

class GrandparentsMainPage: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grandparents_main_page)

        val user = intent.getStringExtra("user")

        val temperatureButton: ImageButton = findViewById(R.id.temperature_button)

        temperatureButton.setOnClickListener {
            val intent = Intent(this, TemperatureActivity::class.java)
            intent.putExtra("user", user);
            startActivity(intent)
        }

        val fridgeButton: ImageButton = findViewById(R.id.fridge_button)

        fridgeButton.setOnClickListener{
            val intent = Intent(this, MenuFridgeActivity::class.java)
            intent.putExtra("user", user);
            startActivity(intent)
        }

        val bathtubButton: ImageButton = findViewById(R.id.bathtub_button)

        bathtubButton.setOnClickListener{
            val intent = Intent(this, BathtubMenuActivity::class.java)
            intent.putExtra("user", user);
            startActivity(intent)
        }

        val backButton: Button = findViewById(R.id.back_button)

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val lightButton: ImageButton = findViewById(R.id.light_button)

        lightButton.setOnClickListener {
            val intent = Intent(this, LightActivity::class.java)
            intent.putExtra("user", user);
            startActivity(intent)
        }
    }
}