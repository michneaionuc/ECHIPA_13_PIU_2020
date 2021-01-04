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

class SocketUsageAdapter (private val context: Context, private var socketList: ArrayList<Socket>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var item = inflater.inflate(R.layout.socket_usage_item, parent, false)

        val name = item.findViewById<TextView>(R.id.switch_name)
        val usage = item.findViewById<TextView>(R.id.switch_usage)

        name.text = socketList[position].name
        usage.text = socketList[position].usage.toString() + "%"

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