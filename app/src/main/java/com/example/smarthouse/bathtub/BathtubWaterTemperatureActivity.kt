package com.example.smarthouse.bathtub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.smarthouse.R

class BathtubWaterTemperatureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bathtub_water_temperature)

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

        val level: TextView = findViewById(R.id.level_temp)
        findViewById<SeekBar>(R.id.water_temp_bar)?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            var barVal = 0;
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int, fromUser: Boolean
            ) {
                barVal = progress;
                level.text = barVal.toString()

            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
            }
        })

        val setButton: Button = findViewById(R.id.button_set)
        setButton.setOnClickListener {
            level.text.toString().toIntOrNull()?.let { it1 ->
                findViewById<SeekBar>(R.id.water_temp_bar)?.setProgress(
                    it1
                )
            }

        }

        val adjust: RadioButton = findViewById(R.id.adjust_button)
        adjust.setOnClickListener {
            findViewById<SeekBar>(R.id.water_temp_bar).visibility = View.GONE
            findViewById<Button>(R.id.button_set).visibility = View.GONE
            findViewById<TextView>(R.id.grade).visibility = View.GONE
            findViewById<EditText>(R.id.level_temp).visibility = View.GONE
        }

        val manual: RadioButton = findViewById(R.id.manual_button)
        manual.setOnClickListener {
            findViewById<SeekBar>(R.id.water_temp_bar).visibility = View.VISIBLE
            findViewById<Button>(R.id.button_set).visibility = View.VISIBLE
            findViewById<TextView>(R.id.grade).visibility = View.VISIBLE
            findViewById<EditText>(R.id.level_temp).visibility = View.VISIBLE
        }


    }
}