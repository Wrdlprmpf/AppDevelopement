package com.example.a43

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webView)
        val textInput = findViewById<EditText>(R.id.textInput)
        val button = findViewById<Button>(R.id.button)

        val searchQString = "https://www.google.at/search?hl=de&q="


        webView.webViewClient = WebViewClient()

        webView.loadUrl("https://www.google.at/")
        button.setOnClickListener{
            val input = textInput.text.toString()
            if (!(input.startsWith("http")) && !(input.startsWith("www"))) {
                webView.loadUrl(searchQString + input)
            } else {
                webView.loadUrl("https://" + input)
            }



        }
    }

}

