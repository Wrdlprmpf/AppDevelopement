package com.example.a51

import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import java.util.*


class MainActivity : AppCompatActivity() {
    private
    var d = Date(2022, 10, 10)

    var messages = ArrayList<Message>()
    var adapter: Adapter = Adapter()
    lateinit var btn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var fabBtn = findViewById<FloatingActionButton>(R.id.fab)
        val btn = findViewById<Button>(R.id.popupButton)
        val text = findViewById<EditText>(R.id.popupText)

        messages.add(Message("Ivan", "Wg", false))
        messages.add(
            Message(
                "Ivan",
                "yo aksjdaskdj alksdj alksdj aklsjd lkasjdlkasjdlaksj dlaksjd lkadjsk ad",
                true
            )
        )
        messages.add(Message("Ivan", "dude", false))
        messages.add(Message("Ivan", "eyyyyy", false))
        messages.add(Message("Ivan", "ok", true))
        messages.add(Message("Ivan", "ok", true))
        messages.add(Message("Ivan", "ok", true))
        messages.add(Message("Ivan", "ok", true))
        messages.add(Message("Ivan", "ok", true))
        messages.add(Message("Ivan", "ok", true))
        messages.add(Message("Ivan", "ok", true))
        messages.add(Message("Ivan", "ok", true))
        messages.add(Message("Ivan", "ok", true))
        messages.add(Message("Ivan", "ok", true))
        messages.add(Message("Ivan", "eyyyyy", false))
        messages.add(Message("Ivan", "eyyyyy", false))
        messages.add(Message("Ivan", "eyyyyy", false))
        messages.add(Message("Ivan", "eyyyyy", false))
        messages.add(Message("Ivan", "eyyyyy", false))

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.loadList(this.messages)
        println(adapter.itemCount)

        showSnack(0)

        var alert: AlertDialog.Builder = AlertDialog.Builder(this)

        fabBtn.setOnClickListener {
            var alert: AlertDialog.Builder = AlertDialog.Builder(this)
            alert.setTitle("Message")
            var txt: EditText = EditText(this)
            alert.setView(txt)
            alert.setPositiveButton("send", DialogInterface.OnClickListener { dialog, which ->
                println("Gesendet")
                messages.add(Message("Me", txt.text.toString(), true))
                adapter.refreshDataset(messages)
                showSnack(1)
            })
            alert.setNegativeButton("cancel", DialogInterface.OnClickListener { dialog, which ->
                println("Abgebrochen")
            })
            alert.show()
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

    fun showSnack(type: Int) {
        var contextView = findViewById<View>(android.R.id.content)

        if (type == 0) {
            var contentText =
                "" + adapter.itemCount.toString() + " Nachrichten. Letzte Nachricht gesendet: " + adapter.messages[adapter.itemCount - 1].date.toString()

            Snackbar.make(contextView, contentText, Snackbar.LENGTH_SHORT)
                .show()
        } else if(type == 1){
            Snackbar.make(contextView, "Neue Nachricht versendet", Snackbar.LENGTH_SHORT)
                .setAction("UNDO") {
                    messages.removeLast()
                    adapter.refreshDataset(messages)
                    showSnack(2)
                }
                .show()
        }
        else if(type == 2){
            Snackbar.make(contextView, "Nachricht wurde zurückgenommen", Snackbar.LENGTH_SHORT)
                .show()
        }
    }

    fun popupWindow() {


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