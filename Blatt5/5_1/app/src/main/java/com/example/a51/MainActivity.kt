package com.example.a51

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*
import android.util.Log.*
import androidx.recyclerview.widget.RecyclerView
import java.util.logging.Level.INFO

class MainActivity : AppCompatActivity() {
    private
    var d = Date(2022,10,10)
    var test = Message("Ivan","Hallo",false)

    var messages = ArrayList<Message>()
    val list:RecyclerView = findViewById(R.id.recyclerView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        messages.add(Message("Ivan","Wg",false))
        messages.add(Message("Ivan","yo",false))
        messages.add(Message("Ivan","dude",false))
        messages.add(Message("Ivan","eyyyyy",false))
        messages.add(Message("Ivan","ok",false))
    }
}