package com.example.smarthouse.bathtub

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.R

class BathtubWaterLevelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bathtub_water_level)

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

        val level: TextView = findViewById(R.id.level_water)
        findViewById<SeekBar>(R.id.water_level_bar)?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            var barVal = 0;
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int, fromUser: Boolean
            ) {
                barVal = progress;
                level.text = barVal.toString() + "%"

            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
            }
        })

        val fullRadio: RadioButton = findViewById(R.id.full_button)
        fullRadio.setOnClickListener {
            level.text = "100%"
            findViewById<SeekBar>(R.id.water_level_bar).visibility = View.GONE
        }

        val mediumRadio: RadioButton = findViewById(R.id.medium_button)
        mediumRadio.setOnClickListener {
            level.text = "50%"
            findViewById<SeekBar>(R.id.water_level_bar).visibility = View.GONE
        }


        val lowRadio: RadioButton = findViewById(R.id.low_button)
        lowRadio.setOnClickListener {
            level.text = "10%"
            findViewById<SeekBar>(R.id.water_level_bar).visibility = View.GONE
        }
        val customRadio: RadioButton = findViewById(R.id.customize_button)
        customRadio.setOnClickListener {
            findViewById<SeekBar>(R.id.water_level_bar).visibility = View.VISIBLE
        }

    }
}