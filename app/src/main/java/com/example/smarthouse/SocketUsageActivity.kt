package com.example.smarthouse

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.adapter.SocketSwitchAdapter
import com.example.smarthouse.adapter.SocketUsageAdapter
import com.example.smarthouse.model.Socket
import java.util.ArrayList

class SocketUsageActivity: AppCompatActivity() {

    var socketAdapter : SocketUsageAdapter?= null
    private lateinit var listView: ListView
    private var socketList : ArrayList<Socket> = arrayListOf()
    var selected_room = "Kitchen"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.socket_usage_page)

        val switchesButton = findViewById<Button>(R.id.switches)

        switchesButton.setOnClickListener {
            finish()
        }

        // by default
        var sockets = displaySockets("Kitchen")
        listView = findViewById(R.id.socketsUsageListView)
        listView.visibility = View.VISIBLE
        socketAdapter = SocketUsageAdapter(this@SocketUsageActivity, sockets)
        listView.adapter = socketAdapter

        val rooms = arrayOf<String>("Kitchen", "Living room", "Bath", "Bedroom parents", "Bedroom grandparents", "Bedroom teen", "Bedroom kids")

        val spinner: Spinner = findViewById(R.id.spinner)

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
                    sockets = displaySockets(selected_room)
                    listView = findViewById(R.id.socketsUsageListView)
                    listView.visibility = View.VISIBLE
                    socketAdapter = SocketUsageAdapter(this@SocketUsageActivity, sockets)
                    listView.adapter = socketAdapter
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }

    fun displaySockets(room: String): ArrayList<Socket> {
        var sockets: ArrayList<Socket> = ArrayList<Socket>()
        when(room) {
            "Kitchen" -> {
                sockets.add(0, Socket("Fridge", false, 75))
                sockets.add(0, Socket("Kitchen robot", false, 25))
                sockets.add(0, Socket("Tools", false, 36))
            }
            "Living room" -> {
                sockets.add(0, Socket("TV", false, 54))
                sockets.add(0, Socket("Sound system", false, 23))
            }
            "Bath" -> {
                sockets.add(0, Socket("Hair dryer", false, 34))
                sockets.add(0, Socket("Washing machine", false, 76))
            }
            "Bedroom parents" -> {
                sockets.add(0, Socket("TV", false, 23))
                sockets.add(0, Socket("Others", false, 45))
            }
            "Bedroom grandparents" -> {
                sockets.add(0, Socket("Radio", false, 56))
                sockets.add(0, Socket("Others", false, 42))
            }
            "Bedroom teen" -> {
                sockets.add(0, Socket("Computer", false, 35))
                sockets.add(0, Socket("Others", false, 45))
            }
            "Bedroom kids" -> {
                sockets.add(0, Socket("Video game", false, 56))
                sockets.add(0, Socket("Others", false, 34))
            }
        }
        return sockets
    }
}