package com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.DEBUG
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.ActionBar
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var units = arrayOf<String>(
        "centimeter to inch",
        "feet to inches",
        "mile to kilometer",
        "seamile to kilometer",
        "yard to meter"
    )
    var fragmentOne = Fragment()
    var fragmentTwo = FragmentTwo()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //ActionBar aufrufen
        val actionBar = supportActionBar
        actionBar!!.title = "FragmentApp"

        val spin = findViewById<Spinner>(R.id.spinner)
        spin.onItemSelectedListener = this

        val adapter: ArrayAdapter<*> =
            ArrayAdapter<Any>(this, android.R.layout.simple_spinner_item, units)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin.adapter = adapter

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            conversion()
        }

        fragmentManagement(1)
    }

    fun fragmentManagement(type: Int) {
        //Implement of fragment
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.viewGroup, fragmentOne)

        if (type == 1) {
            fragmentTransaction.replace(R.id.viewGroup, fragmentOne)

        } else if (type == 2) {
            fragmentTransaction.replace(R.id.viewGroup,fragmentTwo)
        }

        fragmentTransaction.commit()

    }

    // method to inflate the options menu when
    // the user opens the menu for the first time
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.fragOneMenu -> fragmentManagement(1)
            R.id.fragTwoMenu -> fragmentManagement(2)
        }


        return super.onOptionsItemSelected(item)
    }

    var pos = 0;
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(applicationContext, units[position], Toast.LENGTH_SHORT).show()
        Log.i("InfoPosition", position.toString())
        pos = position
        conversion()
    }

    fun conversion() {
        val inputText = findViewById<EditText>(R.id.number1)
        val outputText = findViewById<TextView>(R.id.number2)

        when (pos) {
            0 -> outputText.setText((inputText.text.toString().toInt() / 2.54).toString())
            1 -> outputText.setText((inputText.text.toString().toInt() * 12).toString())
            2 -> outputText.setText((inputText.text.toString().toInt() * 1.609).toString())
            3 -> outputText.setText((inputText.text.toString().toInt() * 1.852).toString())
            4 -> outputText.setText((inputText.text.toString().toInt() / 1.094).toString())
        }

    }


    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}