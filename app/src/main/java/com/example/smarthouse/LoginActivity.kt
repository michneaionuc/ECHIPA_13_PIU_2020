package com.example.smarthouse

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    private lateinit var pinError: TextView
    private lateinit var pinEditText: EditText

    var user = ""
    val REQUEST_CODE = 100
    var pin = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        user = intent.getStringExtra("user").toString()

        val userIcon: ImageView = findViewById(R.id.user_icon)

        when (user) {
            "parents" -> {
                userIcon.setBackgroundResource(R.drawable.parents_icon)
            }
            "teenage" -> {
                userIcon.setBackgroundResource(R.drawable.teenage_girl_icon)
            }
        }

        pinEditText = findViewById(R.id.pinEditText)
        pinError = findViewById(R.id.pinError)

        val backButton: Button = findViewById(R.id.back_button)

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.forgot_pin).setOnClickListener {
            val intent = Intent(this, ResetPinActivity::class.java)
            intent.putExtra("user", user);
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    fun login(view: View) {
        val pinValue = pinEditText.text
        var isPinValid: Boolean = false

        if (pinValue.isEmpty()) {
            isPinValid = false
            pinError.visibility = View.VISIBLE
            pinError.text = "PIN cannot be empty!"
        } else if (pinValue.toString().length != 4) {
            isPinValid = false
            pinError.visibility = View.VISIBLE
            pinError.text = "PIN has wrong length!"
        } else {
            isPinValid = true
        }

        if (isPinValid) {
            if (pinValue.toString().compareTo(pin) == 0) {
                pinError.visibility = View.GONE
                when (user) {
                    "parents" -> {
                        val intent = Intent(this, ParentsMainPage::class.java)
                        intent.putExtra("user", user);
                        startActivity(intent)
                    }
                    "teenage" -> {
                        val intent = Intent(this, TeenageMainPage::class.java)
                        intent.putExtra("user", user);
                        startActivity(intent)
                    }
                }
            } else {
                pinError.visibility = View.VISIBLE
                pinError.text = "PIN is wrong!"
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            pin = data?.getStringExtra("pin").toString()
        }
    }

    //back to home page
    fun back(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}