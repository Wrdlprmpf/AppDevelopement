package com.example.a43

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.textservice.TextInfo
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val browser = findViewById<WebView>(R.id.webView)
        val url = findViewById<TextView>(R.id.textInput)
        val button = findViewById<Button>(R.id.button)

        browser.loadUrl("https://www.google.at/")

    }
}