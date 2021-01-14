package com.example.smarthouse.socket

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.R
import com.example.smarthouse.adapter.SocketSwitchAdapter
import com.example.smarthouse.model.Socket
import java.util.ArrayList

class SocketSwitchesActivity: AppCompatActivity() {

    var socketAdapter : SocketSwitchAdapter?= null
    private lateinit var listView: ListView
    private var socketList : ArrayList<Socket> = arrayListOf()
    var selected_room = "Kitchen"
    var sockets1: ArrayList<Socket> = arrayListOf()
    var sockets2: ArrayList<Socket> = arrayListOf()
    var sockets3: ArrayList<Socket> = arrayListOf()
    var sockets4: ArrayList<Socket> = arrayListOf()
    var sockets5: ArrayList<Socket> = arrayListOf()
    var sockets6: ArrayList<Socket> = arrayListOf()
    var sockets7: ArrayList<Socket> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        // kitchen
        sockets1.add(0, Socket("Fridge", false, 75))
        sockets1.add(1, Socket("Kitchen robot", false, 25))
        sockets1.add(2, Socket("Tools", false, 36))

        // living room
        sockets2.add(0, Socket("TV", false, 54))
        sockets2.add(1, Socket("Sound system", false, 23))

        // bath
        sockets3.add(0, Socket("Hair dryer", false, 34))
        sockets3.add(1, Socket("Washing machine", false, 76))

        // bedroom parents
        sockets4.add(0, Socket("TV", false, 23))
        sockets4.add(1, Socket("Others", false, 45))

        // bedroom grandparents
        sockets5.add(0, Socket("Radio", false, 56))
        sockets5.add(1, Socket("Others", false, 42))

        // bedroom teen
        sockets6.add(0, Socket("Computer", false, 35))
        sockets6.add(1, Socket("Others", false, 45))

        // bedroom kids
        sockets7.add(0, Socket("Video game", false, 56))
        sockets7.add(1, Socket("Others", false, 34))

        super.onCreate(savedInstanceState)
        setContentView(R.layout.socket_switches_page)

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

        val usageButton = findViewById<Button>(R.id.usage)

        usageButton.setOnClickListener {
            val intent = Intent(this, SocketUsageActivity::class.java)
            intent.putExtra("user", user);
            startActivity(intent)
        }

        // by default
        var sockets = displaySockets("Kitchen")
        listView = findViewById(R.id.socketsListView)
        listView.visibility = View.VISIBLE
        socketAdapter = SocketSwitchAdapter(this@SocketSwitchesActivity, sockets)
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
                    listView = findViewById(R.id.socketsListView)
                    listView.visibility = View.VISIBLE
                    socketAdapter = SocketSwitchAdapter(this@SocketSwitchesActivity, sockets)
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
                return sockets1
            }
            "Living room" -> {
                return sockets2
            }
            "Bath" -> {
                return sockets3
            }
            "Bedroom parents" -> {
                return sockets4
            }
            "Bedroom grandparents" -> {
                return sockets5
            }
            "Bedroom teen" -> {
                return sockets6
            }
            "Bedroom kids" -> {
                return sockets7
            }
        }
        return sockets
    }
}