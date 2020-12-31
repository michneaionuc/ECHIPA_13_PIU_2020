package com.example.smarthouse

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResetPinActivity: AppCompatActivity() {

    private lateinit var pinError: TextView
    private lateinit var pinEditText: EditText
    private lateinit var retypePinEditText: EditText
    private lateinit var emailEditText: EditText

    var user = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reset_pin_page)

        user = intent.getStringExtra("user").toString()

        val userIcon: ImageView = findViewById(R.id.user_icon)

        when(user) {
            "parents" -> {
                userIcon.setBackgroundResource(R.drawable.parents_icon)
            }
            "teenage" -> {
                userIcon.setBackgroundResource(R.drawable.teenage_girl_icon)
            }
        }
        println(user)
        pinEditText = findViewById(R.id.pinEditText)
        retypePinEditText = findViewById(R.id.retypePinEditText)
        emailEditText = findViewById(R.id.emailEditText)
        pinError = findViewById(R.id.pinError)

    }

    fun save(view: View) {
        val pinValue = pinEditText.text
        val retypePinValue = retypePinEditText.text
        val emailValue = emailEditText.text
        var isPinValid: Boolean = false

        if(pinValue.isEmpty() || retypePinValue.isEmpty() || emailValue.isEmpty()) {
            isPinValid = false
            pinError.visibility = View.VISIBLE
            pinError.text="You have empty fields!"
        } else if(pinValue.toString().length != 4 || retypePinValue.toString().length != 4) {
            isPinValid = false
            pinError.visibility = View.VISIBLE
            pinError.text="PIN has wrong length!"
        } else if(pinValue.toString().compareTo(retypePinValue.toString()) != 0) {
            isPinValid = false
            pinError.visibility = View.VISIBLE
            pinError.text="The retyped PIN is wrong!"
        } else {
            isPinValid = true
        }

        if(isPinValid) {

            if (emailValue.toString().compareTo("team13@email.com") == 0 ) {
                pinError.visibility = View.GONE
                val intent = Intent()
                intent.putExtra("pin", pinValue.toString())

                setResult(Activity.RESULT_OK, intent)
                finish()
            } else {
                pinError.visibility = View.VISIBLE
                pinError.text = "Email is wrong!"
            }
        }
    }

    //back to home page
    fun back(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}