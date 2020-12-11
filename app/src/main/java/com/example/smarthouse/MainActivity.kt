package com.example.smarthouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var pinError: TextView
    private lateinit var pinEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pinEditText = findViewById(R.id.pinEditText)
        pinError = findViewById(R.id.pinError)
    }

    fun login(view: View) {
        System.out.println(pinEditText.text)
        val pinValue = pinEditText.text
        var isPinValid: Boolean = false

        if(pinValue.isEmpty()) {
            isPinValid = false
            pinError.visibility = View.VISIBLE
            pinError.text="PIN cannot be empty!"
        } else if(pinValue.toString().length != 4) {
            isPinValid = false
            pinError.visibility = View.VISIBLE
            pinError.text="PIN has wrong length!"
        } else {
            isPinValid = true
        }

        if(isPinValid) {
            if (pinValue.toString() == "1234") {
                pinError.visibility = View.GONE
                val intent = Intent(this, ParentsMainPage::class.java)
                startActivity(intent)
            } else {
                pinError.visibility = View.VISIBLE
                pinError.text = "PIN is wrong!"
            }
        }
    }
}