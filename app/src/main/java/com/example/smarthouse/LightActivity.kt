package com.example.smarthouse;

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class LightActivity: AppCompatActivity() {

    var selected_room = "All"
    var mainLightVals = IntArray(7) { i -> 0 }
    var ledLightVals = IntArray(7) { i -> 0 }
    var rLightVals = IntArray(7) { i -> 0 }
    var gLightVals = IntArray(7) { i -> 0 }
    var bLightVals = IntArray(7) { i -> 0 }
    var previous_mainLight = 0
    var previous_ledLight = 0
    var previous_rLight = 0
    var previous_gLight = 0
    var previous_bLight = 0
    var displayed_mainLight = 0
    var displayed_ledLight = 0
    var displayed_rLight = 0
    var displayed_gLight = 0
    var displayed_bLight = 0
    var allMainLight = 0

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.light_page)

        val rooms = arrayOf<String>("All", "Kitchen", "Living room", "Bath", "Bedroom parents", "Bedroom grandparents", "Bedroom teen", "Bedroom kids")

        val spinner: Spinner = findViewById(R.id.spinner)
        val lightBarMain: SeekBar = findViewById(R.id.main_light_seek_bar)
        val lightBarLed: SeekBar = findViewById(R.id.led_light_seek_bar)
        val lightBarR: SeekBar = findViewById(R.id.r_light_seek_bar)
        val lightBarG: SeekBar = findViewById(R.id.g_light_seek_bar)
        val lightBarB: SeekBar = findViewById(R.id.b_light_seek_bar)
        val mainLightValue: TextView = findViewById(R.id.main_light_value)
        val ledLightValue: TextView = findViewById(R.id.led_light_value)
        val rLightValue: TextView = findViewById(R.id.r_light_value)
        val gLightValue: TextView = findViewById(R.id.g_light_value)
        val bLightValue: TextView = findViewById(R.id.b_light_value)

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
                    setDisplayedMainLight(selected_room)
                    println(mainLightVals[0])
                    println(mainLightVals[1])
                    println(mainLightVals[2])
                    println(mainLightVals[3])
                    println(mainLightVals[4])
                    println(mainLightVals[5])
                    println(mainLightVals[6])
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        lightBarMain?.setOnSeekBarChangeListener(object :
                SeekBar.OnSeekBarChangeListener {
            var barVal = 0;
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                barVal = progress;
                setMainLight(selected_room, barVal)
                setDisplayedMainLight(selected_room)
                mainLightValue.text = progress.toString() + "%"
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
            }
        })

        lightBarLed?.setOnSeekBarChangeListener(object :
                SeekBar.OnSeekBarChangeListener {
            var barVal = 0;
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                barVal = progress;
                setLedLight(selected_room, barVal)
                setDisplayedLedLight(selected_room)
                ledLightValue.text = progress.toString() + "%"
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
            }
        })

        lightBarR?.setOnSeekBarChangeListener(object :
                SeekBar.OnSeekBarChangeListener {
            var barVal = 0;
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                barVal = progress;
                setRLight(selected_room, barVal)
                setDisplayedRLight(selected_room)
                rLightValue.text = "R:" + progress.toString() + "%"
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
            }
        })

        lightBarG?.setOnSeekBarChangeListener(object :
                SeekBar.OnSeekBarChangeListener {
            var barVal = 0;
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                barVal = progress;
                setGLight(selected_room, barVal)
                setDisplayedGLight(selected_room)
                gLightValue.text = "G:" + progress.toString() + "%"
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
            }
        })

        lightBarB?.setOnSeekBarChangeListener(object :
                SeekBar.OnSeekBarChangeListener {
            var barVal = 0;
            override fun onProgressChanged(seek: SeekBar,
                                           progress: Int, fromUser: Boolean) {
                barVal = progress;
                if(selected_room == "All") {
                    previous_mainLight = barVal
                }
                setBLight(selected_room, barVal)
                setDisplayedBLight(selected_room)
                bLightValue.text = "B:" + progress.toString() + "%"
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
            }
        })

        mainLightValue.addTextChangedListener {
            lightBarMain.progress = displayed_mainLight
        }

    }

    fun setMainLight(room: String, value: Int) {
        when(room) {
            "All" -> {
                allMainLight = value;
                if(previous_mainLight != displayed_mainLight) {
                    mainLightVals[0] = value;
                    mainLightVals[1] = value;
                    mainLightVals[2] = value;
                    mainLightVals[3] = value;
                    mainLightVals[4] = value;
                    mainLightVals[5] = value;
                    mainLightVals[6] = value;
                }
            }
            "Kitchen" -> {
                mainLightVals[0] = value;
            }
            "Living room" -> {
                mainLightVals[1] = value;
            }
            "Bath" -> {
                mainLightVals[2] = value;
            }
            "Bedroom parents" -> {
                mainLightVals[3] = value;
            }
            "Bedroom grandparents" -> {
                mainLightVals[4] = value;
            }
            "Bedroom teen" -> {
                mainLightVals[5] = value;
            }
            "Bedroom kids" -> {
                mainLightVals[6] = value;
            }
        }
    }

    fun setDisplayedMainLight(room: String) {
        when(room) {
            "All" -> {
                displayed_mainLight = allMainLight;
            }
            "Kitchen" -> {
                displayed_mainLight = mainLightVals[0];
            }
            "Living room" -> {
                displayed_mainLight = mainLightVals[1];
            }
            "Bath" -> {
                displayed_mainLight = mainLightVals[2];
            }
            "Bedroom parents" -> {
                displayed_mainLight = mainLightVals[3];
            }
            "Bedroom grandparents" -> {
                displayed_mainLight = mainLightVals[4];
            }
            "Bedroom teen" -> {
                displayed_mainLight = mainLightVals[5];
            }
            "Bedroom kids" -> {
                displayed_mainLight = mainLightVals[6];
            }
        }
    }

    fun setLedLight(room: String, value: Int) {
        when(room) {
            "All" -> {
                mainLightVals[0] = value;
                mainLightVals[1] = value;
                mainLightVals[2] = value;
                mainLightVals[3] = value;
                mainLightVals[4] = value;
                mainLightVals[5] = value;
                mainLightVals[6] = value;
            }
            "Kitchen" -> {
                mainLightVals[0] = value;
            }
            "Living room" -> {
                mainLightVals[1] = value;
            }
            "Bath" -> {
                mainLightVals[2] = value;
            }
            "Bedroom parents" -> {
                mainLightVals[3] = value;
            }
            "Bedroom grandparents" -> {
                mainLightVals[4] = value;
            }
            "Bedroom teen" -> {
                mainLightVals[5] = value;
            }
            "Bedroom kids" -> {
                mainLightVals[6] = value;
            }
        }
    }

    fun setDisplayedLedLight(room: String) {
        when(room) {
            "Kitchen" -> {
                displayed_mainLight = mainLightVals[0];
            }
            "Living room" -> {
                displayed_mainLight = mainLightVals[1];
            }
            "Bath" -> {
                displayed_mainLight = mainLightVals[2];
            }
            "Bedroom parents" -> {
                displayed_mainLight = mainLightVals[3];
            }
            "Bedroom grandparents" -> {
                displayed_mainLight = mainLightVals[4];
            }
            "Bedroom teen" -> {
                displayed_mainLight = mainLightVals[5];
            }
            "Bedroom kids" -> {
                displayed_mainLight = mainLightVals[6];
            }
        }
    }

    fun setRLight(room: String, value: Int) {
        when(room) {
            "All" -> {
                mainLightVals[0] = value;
                mainLightVals[1] = value;
                mainLightVals[2] = value;
                mainLightVals[3] = value;
                mainLightVals[4] = value;
                mainLightVals[5] = value;
                mainLightVals[6] = value;
            }
            "Kitchen" -> {
                mainLightVals[0] = value;
            }
            "Living room" -> {
                mainLightVals[1] = value;
            }
            "Bath" -> {
                mainLightVals[2] = value;
            }
            "Bedroom parents" -> {
                mainLightVals[3] = value;
            }
            "Bedroom grandparents" -> {
                mainLightVals[4] = value;
            }
            "Bedroom teen" -> {
                mainLightVals[5] = value;
            }
            "Bedroom kids" -> {
                mainLightVals[6] = value;
            }
        }
    }

    fun setDisplayedRLight(room: String) {
        when(room) {
            "Kitchen" -> {
                displayed_mainLight = mainLightVals[0];
            }
            "Living room" -> {
                displayed_mainLight = mainLightVals[1];
            }
            "Bath" -> {
                displayed_mainLight = mainLightVals[2];
            }
            "Bedroom parents" -> {
                displayed_mainLight = mainLightVals[3];
            }
            "Bedroom grandparents" -> {
                displayed_mainLight = mainLightVals[4];
            }
            "Bedroom teen" -> {
                displayed_mainLight = mainLightVals[5];
            }
            "Bedroom kids" -> {
                displayed_mainLight = mainLightVals[6];
            }
        }
    }

    fun setGLight(room: String, value: Int) {
        when(room) {
            "All" -> {
                mainLightVals[0] = value;
                mainLightVals[1] = value;
                mainLightVals[2] = value;
                mainLightVals[3] = value;
                mainLightVals[4] = value;
                mainLightVals[5] = value;
                mainLightVals[6] = value;
            }
            "Kitchen" -> {
                mainLightVals[0] = value;
            }
            "Living room" -> {
                mainLightVals[1] = value;
            }
            "Bath" -> {
                mainLightVals[2] = value;
            }
            "Bedroom parents" -> {
                mainLightVals[3] = value;
            }
            "Bedroom grandparents" -> {
                mainLightVals[4] = value;
            }
            "Bedroom teen" -> {
                mainLightVals[5] = value;
            }
            "Bedroom kids" -> {
                mainLightVals[6] = value;
            }
        }
    }

    fun setDisplayedGLight(room: String) {
        when(room) {
            "Kitchen" -> {
                displayed_mainLight = mainLightVals[0];
            }
            "Living room" -> {
                displayed_mainLight = mainLightVals[1];
            }
            "Bath" -> {
                displayed_mainLight = mainLightVals[2];
            }
            "Bedroom parents" -> {
                displayed_mainLight = mainLightVals[3];
            }
            "Bedroom grandparents" -> {
                displayed_mainLight = mainLightVals[4];
            }
            "Bedroom teen" -> {
                displayed_mainLight = mainLightVals[5];
            }
            "Bedroom kids" -> {
                displayed_mainLight = mainLightVals[6];
            }
        }
    }

    fun setBLight(room: String, value: Int) {
        when(room) {
            "All" -> {
                mainLightVals[0] = value;
                mainLightVals[1] = value;
                mainLightVals[2] = value;
                mainLightVals[3] = value;
                mainLightVals[4] = value;
                mainLightVals[5] = value;
                mainLightVals[6] = value;
            }
            "Kitchen" -> {
                mainLightVals[0] = value;
            }
            "Living room" -> {
                mainLightVals[1] = value;
            }
            "Bath" -> {
                mainLightVals[2] = value;
            }
            "Bedroom parents" -> {
                mainLightVals[3] = value;
            }
            "Bedroom grandparents" -> {
                mainLightVals[4] = value;
            }
            "Bedroom teen" -> {
                mainLightVals[5] = value;
            }
            "Bedroom kids" -> {
                mainLightVals[6] = value;
            }
        }
    }

    fun setDisplayedBLight(room: String) {
        when(room) {
            "Kitchen" -> {
                displayed_mainLight = mainLightVals[0];
            }
            "Living room" -> {
                displayed_mainLight = mainLightVals[1];
            }
            "Bath" -> {
                displayed_mainLight = mainLightVals[2];
            }
            "Bedroom parents" -> {
                displayed_mainLight = mainLightVals[3];
            }
            "Bedroom grandparents" -> {
                displayed_mainLight = mainLightVals[4];
            }
            "Bedroom teen" -> {
                displayed_mainLight = mainLightVals[5];
            }
            "Bedroom kids" -> {
                displayed_mainLight = mainLightVals[6];
            }
        }
    }

}
