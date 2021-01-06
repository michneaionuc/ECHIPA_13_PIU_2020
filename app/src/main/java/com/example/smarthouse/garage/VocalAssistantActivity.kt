package com.example.smarthouse.garage

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.R

class VocalAssistantActivity: AppCompatActivity() {

    var garageState: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vocal_assistant_page)

        // after 5 sec open the garage
        Handler().postDelayed({
            val intent = Intent(this, GarageOpenActivity::class.java)
            startActivity(intent)
        }, 5000)

        // after garage opens then closes
        Handler().postDelayed({
            val intent = Intent(this, GarageCloseActivity::class.java)
            startActivity(intent)
        }, 21000)

        Handler().postDelayed({
            finish()
        }, 32000)
    }
}