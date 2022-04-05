package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var sendButton: Button
    lateinit var sendText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "1"
        sendButton = findViewById(R.id.send_button_id)
        sendText = findViewById(R.id.send_text_id)

    }

    fun sendmsg(view: View) {
        sendButton.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("Text", sendText.text.toString())

            startActivity(intent)
        }


    }
}

