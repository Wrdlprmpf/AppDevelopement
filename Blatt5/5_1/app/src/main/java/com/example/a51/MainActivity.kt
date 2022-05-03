package com.example.a51

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*


class MainActivity : AppCompatActivity() {
    private
    var d = Date(2022,10,10)

    var messages = ArrayList<Message>()
    var adapter: Adapter = Adapter()
    lateinit var btn:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var fabBtn = findViewById<FloatingActionButton>(R.id.fab)
        val btn = findViewById<Button>(R.id.popupButton)
        val text = findViewById<EditText>(R.id.popupText)
        val invbtn:View = findViewById<Button>(R.id.invbutton)
        val invtext:View = findViewById<EditText>(R.id.invtext)


        messages.add(Message("Ivan","Wg",false))
        messages.add(Message("Ivan","yo aksjdaskdj alksdj alksdj aklsjd lkasjdlkasjdlaksj dlaksjd lkadjsk ad",true))
        messages.add(Message("Ivan","dude",false))
        messages.add(Message("Ivan","eyyyyy",false))
        messages.add(Message("Ivan","ok",true))
        messages.add(Message("Ivan","ok",true))
        messages.add(Message("Ivan","ok",true))
        messages.add(Message("Ivan","ok",true))
        messages.add(Message("Ivan","ok",true))
        messages.add(Message("Ivan","ok",true))
        messages.add(Message("Ivan","ok",true))
        messages.add(Message("Ivan","ok",true))
        messages.add(Message("Ivan","ok",true))
        messages.add(Message("Ivan","ok",true))
        messages.add(Message("Ivan","eyyyyy",false))
        messages.add(Message("Ivan","eyyyyy",false))
        messages.add(Message("Ivan","eyyyyy",false))
        messages.add(Message("Ivan","eyyyyy",false))
        messages.add(Message("Ivan","eyyyyy",false))


        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.loadList(this.messages)
        println(adapter.itemCount)

        fabBtn.setOnClickListener{
            if(invtext.visibility == View.VISIBLE){
                invtext.setVisibility(View.GONE)
                invbtn.visibility = View.GONE
            }
            else{
                invbtn.visibility = View.VISIBLE
                invtext.visibility = View.VISIBLE
            }

        }

        invbtn.setOnClickListener{
            var newText = findViewById<EditText>(R.id.invtext)

            messages.add(Message("Me",newText.text.toString(),true))
            adapter.refreshDataset(messages)


        }


        /*
        btn.setOnClickListener{

            messages.add(Message("Me",text.text.toString(),true))
            adapter.refreshDataset(messages)

        }

         */
        /*
        fabBtn.setOnClickListener{
            // inflate the layout of the popup window
            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView: View = inflater.inflate(R.layout.popup, null)

            // create the popup window
            val width = LinearLayout.LayoutParams.WRAP_CONTENT
            val height = LinearLayout.LayoutParams.WRAP_CONTENT
            val focusable = true // lets taps outside the popup also dismiss it

            val popupWindow = PopupWindow(popupView, width, height, focusable)

            // show the popup window
            // which view you pass in doesn't matter, it is only used for the window tolken
            popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
        }

         */


    }
    fun popupWindow(){


        // inflate the layout of the popup window
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView: View = inflater.inflate(R.layout.popup, null)

        // create the popup window
        val width = LinearLayout.LayoutParams.WRAP_CONTENT
        val height = LinearLayout.LayoutParams.WRAP_CONTENT
        val focusable = true // lets taps outside the popup also dismiss it

        val popupWindow = PopupWindow(popupView, width, height, focusable)

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)

    }
}