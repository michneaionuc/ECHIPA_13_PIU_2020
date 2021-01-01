package com.example.smarthouse.fridge

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.R

class FoundCookingFridgeActivity : AppCompatActivity() {
    var listItemsHave = ArrayList<String>()
    var adapterHave: ArrayAdapter<String>? = null

    var listItemsNeed = ArrayList<String>()
    var adapterNeed: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_found_cooking_fridge)

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

        val recipeName = intent.getStringExtra("recipeToFind")
        val recipeInput: TextView = findViewById(R.id.recipe_name)
        recipeInput.text = recipeName

        listItemsHave.add("Cabbage")
        listItemsHave.add("Onion")
        listItemsHave.add("Peppers")

        val listHave: ListView = findViewById(R.id.list_have)
        adapterHave = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            listItemsHave
        )

        listItemsNeed.add("Meat")
        listItemsNeed.add("Rice")
        listItemsNeed.add("Spices")

        listHave.adapter = adapterHave
        val listNeed: ListView = findViewById(R.id.list_need)
        adapterNeed = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            listItemsNeed
        )
        listNeed.adapter = adapterNeed


    }
}