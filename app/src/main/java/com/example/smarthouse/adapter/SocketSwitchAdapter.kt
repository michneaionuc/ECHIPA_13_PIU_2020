package com.example.smarthouse.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Switch
import android.widget.TextView
import com.example.smarthouse.R
import com.example.smarthouse.model.Socket

class SocketSwitchAdapter (private val context: Context, private var socketList: ArrayList<Socket>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var item = inflater.inflate(R.layout.socket_switch_item, parent, false)

        val name = item.findViewById<TextView>(R.id.switch_name)
        val switch = item.findViewById<Switch>(R.id.switch_item)

        name.text = socketList[position].name
        switch.isChecked = socketList[position].state
        switch?.setOnCheckedChangeListener { _, isChecked ->
            socketList[position].state = isChecked
        }
        return item
    }

    override fun getItem(position: Int): Any {
        return socketList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return socketList.size
    }

}