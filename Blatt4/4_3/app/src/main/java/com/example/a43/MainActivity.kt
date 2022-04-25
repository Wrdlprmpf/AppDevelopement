package com.example.a43

import android.os.Bundle
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
        val btn_search = findViewById<Button>(R.id.button)
        val btn_backward = findViewById<Button>(R.id.btn_back)
        val btn_forward = findViewById<Button>(R.id.btn_forward)


        val searchQString = "https://www.google.at/search?hl=de&q="


        webView.webViewClient = WebViewClient()

        webView.loadUrl("https://www.wikipedia.org/")
        btn_search.setOnClickListener{
            val input = textInput.text.toString()
            if (!(input.startsWith("http")) && !(input.startsWith("www"))) {
                webView.loadUrl(searchQString + input)
            } else {
                webView.loadUrl("https://" + input)
            }
        }

        btn_backward.setOnClickListener{
            if(webView.canGoBack()) webView.goBack()
        }
        btn_forward.setOnClickListener{
            if(webView.canGoForward()) webView.goForward()
        }
    }

}

