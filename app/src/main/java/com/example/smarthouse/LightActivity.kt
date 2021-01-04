package com.example.smarthouse;

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class LightActivity: AppCompatActivity() {

    var selected_room = "All"
    var mainLightVals = IntArray(7) { 0 }
    var ledLightVals = IntArray(7) { 0 }
    var rLightVals = IntArray(7) { 0 }
    var gLightVals = IntArray(7) { 0 }
    var bLightVals = IntArray(7) { 0 }
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
    var allLedLight = 0
    var allRLight = 0
    var allGLight = 0
    var allBLight = 0

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.light_page)

        val user = intent.getStringExtra("user")

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
        val userIcon: ImageView = findViewById(R.id.user_icon)

        when(user) {
            "parents" -> {
                userIcon.setBackgroundResource(R.drawable.parents_icon)
            }
            "teenage" -> {
                userIcon.setBackgroundResource(R.drawable.teenage_girl_icon)
            }
            "grandparents" -> {
                userIcon.setBackgroundResource(R.drawable.grand_parents_icon)
            }
            "kids" -> {
                userIcon.setBackgroundResource(R.drawable.kids_icon)
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
                    setDisplayedMainLight(selected_room)
                    setDisplayedLedLight(selected_room)
                    setDisplayedRLight(selected_room)
                    setDisplayedGLight(selected_room)
                    setDisplayedBLight(selected_room)
                    lightBarMain.progress = displayed_mainLight
                    lightBarLed.progress = displayed_ledLight
                    lightBarR.progress = displayed_rLight
                    lightBarG.progress = displayed_gLight
                    lightBarB.progress = displayed_bLight
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
                if(selected_room == "All") {
                    previous_mainLight = barVal
                }
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
                if(selected_room == "All") {
                    previous_ledLight = barVal
                }
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
                if(selected_room == "All") {
                    previous_rLight = barVal
                }
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
                if(selected_room == "All") {
                    previous_gLight = barVal
                }
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
                    previous_bLight = barVal
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
                ledLightVals[0] = value;
                ledLightVals[1] = value;
                ledLightVals[2] = value;
                ledLightVals[3] = value;
                ledLightVals[4] = value;
                ledLightVals[5] = value;
                ledLightVals[6] = value;
            }
            "Kitchen" -> {
                ledLightVals[0] = value;
            }
            "Living room" -> {
                ledLightVals[1] = value;
            }
            "Bath" -> {
                ledLightVals[2] = value;
            }
            "Bedroom parents" -> {
                ledLightVals[3] = value;
            }
            "Bedroom grandparents" -> {
                ledLightVals[4] = value;
            }
            "Bedroom teen" -> {
                ledLightVals[5] = value;
            }
            "Bedroom kids" -> {
                ledLightVals[6] = value;
            }
        }
    }

    fun setDisplayedLedLight(room: String) {
        when(room) {
            "Kitchen" -> {
                displayed_ledLight = ledLightVals[0];
            }
            "Living room" -> {
                displayed_ledLight = ledLightVals[1];
            }
            "Bath" -> {
                displayed_ledLight = ledLightVals[2];
            }
            "Bedroom parents" -> {
                displayed_ledLight = ledLightVals[3];
            }
            "Bedroom grandparents" -> {
                displayed_ledLight = ledLightVals[4];
            }
            "Bedroom teen" -> {
                displayed_ledLight = ledLightVals[5];
            }
            "Bedroom kids" -> {
                displayed_ledLight = ledLightVals[6];
            }
        }
    }

    fun setRLight(room: String, value: Int) {
        when(room) {
            "All" -> {
                rLightVals[0] = value;
                rLightVals[1] = value;
                rLightVals[2] = value;
                rLightVals[3] = value;
                rLightVals[4] = value;
                rLightVals[5] = value;
                rLightVals[6] = value;
            }
            "Kitchen" -> {
                rLightVals[0] = value;
            }
            "Living room" -> {
                rLightVals[1] = value;
            }
            "Bath" -> {
                rLightVals[2] = value;
            }
            "Bedroom parents" -> {
                rLightVals[3] = value;
            }
            "Bedroom grandparents" -> {
                rLightVals[4] = value;
            }
            "Bedroom teen" -> {
                rLightVals[5] = value;
            }
            "Bedroom kids" -> {
                rLightVals[6] = value;
            }
        }
    }

    fun setDisplayedRLight(room: String) {
        when(room) {
            "Kitchen" -> {
                displayed_rLight = rLightVals[0];
            }
            "Living room" -> {
                displayed_rLight = rLightVals[1];
            }
            "Bath" -> {
                displayed_rLight = rLightVals[2];
            }
            "Bedroom parents" -> {
                displayed_rLight = rLightVals[3];
            }
            "Bedroom grandparents" -> {
                displayed_rLight = rLightVals[4];
            }
            "Bedroom teen" -> {
                displayed_rLight = rLightVals[5];
            }
            "Bedroom kids" -> {
                displayed_rLight = rLightVals[6];
            }
        }
    }

    fun setGLight(room: String, value: Int) {
        when(room) {
            "All" -> {
                gLightVals[0] = value;
                gLightVals[1] = value;
                gLightVals[2] = value;
                gLightVals[3] = value;
                gLightVals[4] = value;
                gLightVals[5] = value;
                gLightVals[6] = value;
            }
            "Kitchen" -> {
                gLightVals[0] = value;
            }
            "Living room" -> {
                gLightVals[1] = value;
            }
            "Bath" -> {
                gLightVals[2] = value;
            }
            "Bedroom parents" -> {
                gLightVals[3] = value;
            }
            "Bedroom grandparents" -> {
                gLightVals[4] = value;
            }
            "Bedroom teen" -> {
                gLightVals[5] = value;
            }
            "Bedroom kids" -> {
                gLightVals[6] = value;
            }
        }
    }

    fun setDisplayedGLight(room: String) {
        when(room) {
            "Kitchen" -> {
                displayed_gLight = gLightVals[0];
            }
            "Living room" -> {
                displayed_gLight = gLightVals[1];
            }
            "Bath" -> {
                displayed_gLight = gLightVals[2];
            }
            "Bedroom parents" -> {
                displayed_gLight = gLightVals[3];
            }
            "Bedroom grandparents" -> {
                displayed_gLight = gLightVals[4];
            }
            "Bedroom teen" -> {
                displayed_gLight = gLightVals[5];
            }
            "Bedroom kids" -> {
                displayed_gLight = gLightVals[6];
            }
        }
    }

    fun setBLight(room: String, value: Int) {
        when(room) {
            "All" -> {
                bLightVals[0] = value;
                bLightVals[1] = value;
                bLightVals[2] = value;
                bLightVals[3] = value;
                bLightVals[4] = value;
                bLightVals[5] = value;
                bLightVals[6] = value;
            }
            "Kitchen" -> {
                bLightVals[0] = value;
            }
            "Living room" -> {
                bLightVals[1] = value;
            }
            "Bath" -> {
                bLightVals[2] = value;
            }
            "Bedroom parents" -> {
                bLightVals[3] = value;
            }
            "Bedroom grandparents" -> {
                bLightVals[4] = value;
            }
            "Bedroom teen" -> {
                bLightVals[5] = value;
            }
            "Bedroom kids" -> {
                bLightVals[6] = value;
            }
        }
    }

    fun setDisplayedBLight(room: String) {
        when(room) {
            "Kitchen" -> {
                displayed_bLight = bLightVals[0];
            }
            "Living room" -> {
                displayed_bLight = bLightVals[1];
            }
            "Bath" -> {
                displayed_bLight = bLightVals[2];
            }
            "Bedroom parents" -> {
                displayed_bLight = bLightVals[3];
            }
            "Bedroom grandparents" -> {
                displayed_bLight = bLightVals[4];
            }
            "Bedroom teen" -> {
                displayed_bLight = bLightVals[5];
            }
            "Bedroom kids" -> {
                displayed_bLight = bLightVals[6];
            }
        }
    }

}
