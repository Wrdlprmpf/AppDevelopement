package com.example.myapplication


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

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

        fragmentManagement(1)
    }

    fun fragmentManagement(type: Int) {
        //Implement of fragment
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)

        fragmentTransaction.replace(R.id.viewGroup, fragmentOne)
        if (type == 1) {
            fragmentTransaction.replace(R.id.viewGroup, fragmentOne)

        } else if (type == 2) {
            fragmentTransaction.replace(R.id.viewGroup, fragmentTwo)
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
}