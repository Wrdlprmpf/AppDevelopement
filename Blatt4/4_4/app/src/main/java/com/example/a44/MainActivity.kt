package com.example.a44

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.DEBUG
import android.view.View
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var units = arrayOf<String>("centimeter to inch","feet to inches","mile to kilometer","seamile to kilometer","yard to meter")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spin = findViewById<Spinner>(R.id.spinner)
        spin.onItemSelectedListener = this

        val adapter: ArrayAdapter<*> = ArrayAdapter<Any>(this,android.R.layout.simple_spinner_item,units)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin.adapter = adapter

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            conversion()
        }



    }

    var pos = 0;
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(applicationContext,units[position],Toast.LENGTH_SHORT).show()
        Log.i("InfoPosition",position.toString())
        pos = position
        conversion()

    }

    fun conversion(){
        val inputText = findViewById<EditText>(R.id.number1)
        val outputText = findViewById<TextView>(R.id.number2)

        when(pos){
            0 -> outputText.setText((inputText.text.toString().toInt()/2.54).toString())
            1 -> outputText.setText((inputText.text.toString().toInt()*12).toString())
            2 -> outputText.setText((inputText.text.toString().toInt()*1.609).toString())
            3 -> outputText.setText((inputText.text.toString().toInt()*1.852).toString())
            4 -> outputText.setText((inputText.text.toString().toInt()/1.094).toString())
        }

    }



    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}