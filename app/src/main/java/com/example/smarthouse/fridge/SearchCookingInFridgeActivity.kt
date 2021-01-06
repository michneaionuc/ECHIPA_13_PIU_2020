package com.example.smarthouse.fridge

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.smarthouse.R

class SearchCookingInFridgeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_cooking_in_fridge)

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

        val inputRecipe: EditText = findViewById(R.id.search_recipe_input)
        val submit: Button = findViewById(R.id.search_button)
        submit.setOnClickListener {
            val intent = Intent(this, FoundCookingFridgeActivity::class.java)
            intent.putExtra("user", user);
            intent.putExtra("recipeToFind", inputRecipe.text.toString())
            startActivity(intent)
        }


    }
}