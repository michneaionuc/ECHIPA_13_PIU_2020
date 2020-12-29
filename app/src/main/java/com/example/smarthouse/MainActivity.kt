package com.example.smarthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var pinError: TextView
    private lateinit var pinEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val parentsButton: ImageButton = findViewById(R.id.parents_button)

        parentsButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("user", "parents");
            startActivity(intent)
        }

        val teenageButton: ImageButton = findViewById(R.id.teenage_button)

        teenageButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("user", "teenage");
            startActivity(intent)
        }

        val grandparentsButton: ImageButton = findViewById(R.id.grandparents_Button)

        grandparentsButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("user", "grandparents");
            startActivity(intent)
        }

        val kidsButton: ImageButton = findViewById(R.id.kids_button)

        kidsButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("user", "kids");
            startActivity(intent)
        }
    }
}