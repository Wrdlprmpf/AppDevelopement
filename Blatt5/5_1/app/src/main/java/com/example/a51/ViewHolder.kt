package com.example.a51

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val text:TextView
    val name:TextView
    val time:TextView

    init {
        text = view.findViewById(R.id.messageText)
        name = view.findViewById(R.id.messageSender)
        time = view.findViewById(R.id.messageDate)

    }
}
