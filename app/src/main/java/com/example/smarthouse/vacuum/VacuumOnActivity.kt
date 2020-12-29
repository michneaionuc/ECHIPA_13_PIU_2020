package com.example.smarthouse.vacuum

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

class VacuumOnActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vacuum_on_page)

        val powerOffButton :ImageButton = findViewById(R.id.power_off_button)
        val vacuumSettingsButton :ImageButton = findViewById(R.id.vacuum_settings)

        val batteryLifeTextView :TextView = findViewById(R.id.battery_life)
        val dustStorageTextView :TextView = findViewById(R.id.dust_storage)

        val batteryLifeProgressBar :ProgressBar = findViewById(R.id.battery_life_progress_bar)
        val dustStorageProgressBar :ProgressBar = findViewById(R.id.dust_storage_progress_bar)

        var batteryLifeValue = 100
        var dustsStorageValue = 100

        var timerBattery = 100
        var timerDust = 100

        val current = LocalDateTime.now()

        batteryLifeTextView.text = "Battery life    " + batteryLifeValue + "%"
        dustStorageTextView.text = "Dust storage  " + dustsStorageValue + "%"

        powerOffButton.setOnClickListener {
            finish()
        }

        vacuumSettingsButton.setOnClickListener {
            val intent = Intent(this, VacuumSettingsActivity::class.java)
            startActivity(intent)
        }

        val batteryLifeHandler = Handler(Looper.getMainLooper())

        batteryLifeHandler.post(object : Runnable {
            override fun run() {
                if(batteryLifeValue > 0) {
                    batteryLifeValue -= 1
                    batteryLifeProgressBar.progress -= 1
                }
                batteryLifeTextView.text = "Battery life    " + batteryLifeValue + "%"
                batteryLifeHandler.postDelayed(this, 5000)
            }
        })

        val dustStorageHandler = Handler(Looper.getMainLooper())

        dustStorageHandler.post(object : Runnable {
            override fun run() {
                if(dustsStorageValue > 0) {
                    dustsStorageValue -= 1
                    dustStorageProgressBar.progress -= 1
                }
                dustStorageTextView.text = "Dust storage  " + dustsStorageValue + "%"
                dustStorageHandler.postDelayed(this, 3000)
            }
        })
    }
}