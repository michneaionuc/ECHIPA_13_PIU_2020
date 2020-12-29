package com.example.smarthouse.temperature

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.smarthouse.R

class TemperatureActivity: AppCompatActivity() {

    var allTemperature = "0 Celsius"
    var kitchenTemperature = "0 Celsius"
    var livingRoomTemperature = "0 Celsius"
    var bathTemperature = "0 Celsius"
    var parentsTemperature = "0 Celsius"
    var grandparentsTemperature = "0 Celsius"
    var teenTemperature = "0 Celsius"
    var kidsTemperature = "0 Celsius"
    var selected_room = "All"
    var displayed_temp = "0 Celsius"
    var previous_Temp = "0 Celsius"
    var tempVal = 0

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.temperature_page)

        val user = intent.getStringExtra("user")

        val userIcon: ImageView = findViewById(R.id.user_icon)

        when(user) {
            "parents" -> {
                userIcon.setBackgroundResource(R.drawable.parents_icon)
            }
            "teenage" -> {
                userIcon.setBackgroundResource(R.drawable.teenage_girl_icon)
            }
        }

        val rooms = arrayOf<String>("All", "Kitchen", "Living room", "Bath", "Bedroom parents", "Bedroom grandparents", "Bedroom teen", "Bedroom kids")

        val spinner: Spinner = findViewById(R.id.spinner)
        val temperatureBar: SeekBar = findViewById(R.id.temperature_seek_bar)
        val temperatureValue: TextView = findViewById(R.id.temperature_value)
        val plusButton :Button = findViewById(R.id.increase_temperature)
        val minusButton :Button = findViewById(R.id.decrease_temperature)

        plusButton.setOnClickListener {
            if(tempVal < 40) {
                tempVal += 1;
                if(selected_room == "All") {
                    previous_Temp = tempVal.toString() + " Celsius";
                }
                setTemperature(selected_room, tempVal.toString() + " Celsius")
                setDisplayedTemp(selected_room)
                temperatureValue.text = displayed_temp
            }
        }

        minusButton.setOnClickListener {
            if(tempVal > 0) {
                tempVal -= 1;
                if(selected_room == "All") {
                    previous_Temp = tempVal.toString() + " Celsius";
                }
                setTemperature(selected_room, tempVal.toString() + " Celsius")
                setDisplayedTemp(selected_room)
                temperatureValue.text = displayed_temp
            }
        }

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
                    selected_room = rooms[position]
                    setDisplayedTemp(selected_room);
                    temperatureValue.text = displayed_temp
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        temperatureValue.text = "0 Celsius"

        temperatureBar?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            var barVal = 0;
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                barVal = progress;
                if(selected_room == "All") {
                    previous_Temp = barVal.toString() + " Celsius";
                }
                setTemperature(selected_room, barVal.toString() + " Celsius")
                setDisplayedTemp(selected_room)
                temperatureValue.text = displayed_temp
                tempVal = progress
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
            }
        })

        temperatureValue.addTextChangedListener {
            temperatureBar.progress = getTempValue(displayed_temp)
        }
    }


    fun setTemperature(room: String, temp: String) {
        when(room) {
            "All" -> {
                allTemperature = temp;
                if(previous_Temp != displayed_temp) {
                    kitchenTemperature = temp;
                    livingRoomTemperature = temp;
                    bathTemperature = temp;
                    parentsTemperature = temp;
                    grandparentsTemperature = temp;
                    teenTemperature = temp;
                    kidsTemperature = temp;
                }
            }
            "Kitchen" -> {
                kitchenTemperature = temp;
            }
            "Living room" -> {
                livingRoomTemperature = temp;
            }
            "Bath" -> {
                bathTemperature = temp;
            }
            "Bedroom parents" -> {
                parentsTemperature = temp;
            }
            "Bedroom grandparents" -> {
                grandparentsTemperature = temp;
            }
            "Bedroom teen" -> {
                teenTemperature = temp;
            }
            "Bedroom kids" -> {
                kidsTemperature = temp;
            }
        }
    }

    fun setDisplayedTemp(room: String) {
        when(room) {
            "All" -> {
                displayed_temp = allTemperature;
            }
            "Kitchen" -> {
                displayed_temp = kitchenTemperature;
            }
            "Living room" -> {
                displayed_temp = livingRoomTemperature;
            }
            "Bath" -> {
                displayed_temp = bathTemperature;
            }
            "Bedroom parents" -> {
                displayed_temp = parentsTemperature;
            }
            "Bedroom grandparents" -> {
                displayed_temp = grandparentsTemperature;
            }
            "Bedroom teen" -> {
                displayed_temp = teenTemperature;
            }
            "Bedroom kids" -> {
                displayed_temp = kidsTemperature;
            }
        }
    }

    fun getTempValue(temp: String): Int {
        var tempValue = 0;

        if(temp[1] == ' ') {
            tempValue = Integer.parseInt(temp.substring(0, 2).dropLast(1));
        } else {
            tempValue = Integer.parseInt(temp.substring(0, 2));
        }
        return tempValue;
    }
}