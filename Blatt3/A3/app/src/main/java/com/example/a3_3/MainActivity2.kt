package com.example.a3_3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        title="About"
    }

    fun goToMail(view: View){
        val intent = Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, "support@pornhub.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Model Agency");
        intent.putExtra(Intent.EXTRA_TEXT, "I need money.");

        startActivity(Intent.createChooser(intent, "Send Email"));
    }

    fun goToTwitter(view: View){
        var link= "https://twitter.com/elonmusk"
        val webIntent: Intent = Intent(Intent.ACTION_VIEW,Uri.parse(link))
        startActivity(webIntent)
    }

    fun goToInsta(view: View){
        var link= "https://www.instagram.com/willsmith/"
        val webIntent: Intent = Intent(Intent.ACTION_VIEW,Uri.parse(link))
        startActivity(webIntent)
    }
}