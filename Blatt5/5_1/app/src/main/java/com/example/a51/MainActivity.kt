package com.example.a51

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*
import android.util.Log.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.logging.Level.INFO

class MainActivity : AppCompatActivity() {
    private
    var d = Date(2022,10,10)

    var messages = ArrayList<Message>()
    lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val view = findViewById<RecyclerView>(R.id.recyclerView)

        messages.add(Message("Ivan","Wg",false))
        messages.add(Message("Ivan","yo",false))
        messages.add(Message("Ivan","dude",false))
        messages.add(Message("Ivan","eyyyyy",false))
        messages.add(Message("Ivan","ok",true))

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = Adapter()
        recyclerView.adapter = adapter

        adapter.loadList(this.messages)
    }
}