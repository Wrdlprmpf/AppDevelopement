package com.example.a41

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var items:Array<String> = arrayOf(" ","Apfel","Banane","Pferdefleisch","Birne","Katze","Hund","Fußball","Nix","Ahja","Help")
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1 ,items)
        listView.adapter = adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener{
            _, _, position, _ ->
            val currentItem = listView.getItemAtPosition(position)
            Toast.makeText(applicationContext,currentItem.toString(),Toast.LENGTH_SHORT).show()
        }





    }
}