package com.example.smarthouse

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class VacuumSettingsActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vacuum_settings_page)

        val rooms = arrayOf<String>("All", "Kitchen", "Living room", "Bath", "Bedroom parents", "Bedroom grandparents", "Bedroom teen", "Bedroom kids")

        val spinner: Spinner = findViewById(R.id.spinner)
        val powerTextView: TextView = findViewById(R.id.custom_power)
        val customPowerBar: SeekBar = findViewById(R.id.custom_power_seek_bar)

        val customPower :RadioButton  =findViewById(R.id.radioBtn4)
        val btn1 :RadioButton  =findViewById(R.id.radioBtn1)
        val btn2 :RadioButton  =findViewById(R.id.radioBtn2)
        val btn3 :RadioButton  =findViewById(R.id.radioBtn3)

        customPower.setOnClickListener {
            if (customPower.isChecked) {
                powerTextView.visibility = View.VISIBLE
                customPowerBar.visibility = View.VISIBLE
            }
        }
        btn1.setOnClickListener {
            if (btn1.isChecked) {
                powerTextView.visibility = View.GONE
                customPowerBar.visibility = View.GONE
            }
        }
        btn2.setOnClickListener {
            if (btn2.isChecked) {
                powerTextView.visibility = View.GONE
                customPowerBar.visibility = View.GONE
            }
        }
        btn3.setOnClickListener {
            if (btn3.isChecked) {
                powerTextView.visibility = View.GONE
                customPowerBar.visibility = View.GONE
            }
        }


        var powerValue = 50

        powerTextView.text = "Custom power   " + powerValue + "%"


        if (spinner != null) {
            val roomsAdapter = ArrayAdapter(
                this,
                R.layout.spinner_list, rooms
            )
            roomsAdapter.setDropDownViewResource(R.layout.spinner_list)
            spinner.adapter = roomsAdapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        customPowerBar?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            var barVal = 0;
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                powerValue = progress
                powerTextView.text = "Custom power   " + progress + "%"
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
            }
        })
    }
}