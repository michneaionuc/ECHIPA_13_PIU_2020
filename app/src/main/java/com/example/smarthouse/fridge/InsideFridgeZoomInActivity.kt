package com.example.smarthouse.fridge

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.R


class InsideFridgeZoomInActivity : AppCompatActivity() {
    var listItems = ArrayList<String>()
    var adapter: ArrayAdapter<String>? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inside_fridge_zoom_in)

        val user = intent.getStringExtra("user")
        val userIcon: ImageView = findViewById(R.id.user_icon_in)
        val raft = intent.getIntExtra("raft",1)
        val imageInside: ImageView = findViewById(R.id.image_inside)

        if(raft==1) {

            imageInside.setImageResource(R.drawable.raft1)

            listItems.add("Lime")
            listItems.add("Grapes")
            listItems.add("Fruit cake")
            listItems.add("Cold drinks")
        }else
            if (raft==2){
                imageInside.setImageResource(R.drawable.raft2)

                listItems.add("Pickled cucumbers")
                listItems.add("Lentil")
                listItems.add("Corn")
                listItems.add("Pot")

            }else if (raft==3){
                imageInside.setImageResource(R.drawable.raft3)

                listItems.add("Fish")
                listItems.add("Crayfish")
                listItems.add("Spinach")
                listItems.add("Lime")

            }else if(raft==4){
                imageInside.setImageResource(R.drawable.raft4)

                listItems.add("Mushrooms")
                listItems.add("Butter")
                listItems.add("Conserve")
                listItems.add("Orange juice")

            }else if (raft ==5){
                imageInside.setImageResource(R.drawable.raft5)

                listItems.add("Eggs")
                listItems.add("Almond milk")
                listItems.add("Butter")
                listItems.add("Water")

            }

        val list: ListView = findViewById(R.id.list_items)

        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            listItems
        )

        list.adapter = adapter

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
        }

    }
}