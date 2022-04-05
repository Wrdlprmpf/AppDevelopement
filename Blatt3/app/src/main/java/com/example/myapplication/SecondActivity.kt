package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent = getIntent()
        var textView: TextView = findViewById(R.id.textView2)
        var recievedmsg = intent.getStringExtra("Text")
        textView.setText(recievedmsg)
    }

    fun startmap(view: View) {
        var location = "https://www.google.com/maps/place/"
        location += findViewById<TextView>(R.id.textView2).text.toString()
        val webIntent: Intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(location)
        )
        startActivity(webIntent)
    }
}