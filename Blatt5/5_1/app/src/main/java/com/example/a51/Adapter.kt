package com.example.a51


import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView


class Adapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var sentmsg = 1
    var recievemsg = 2
    lateinit var messages: ArrayList<Message>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            sentmsg -> {
                return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.message_outgoing, parent, false))
            }
            recievemsg -> {
                return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.message_incoming, parent, false))
            }
            else -> {
                return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.message_incoming, parent,false))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ViewHolder ->{
                holder.connect(messages[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    fun loadList(messages: ArrayList<Message>){
        this.messages = messages
    }

    fun getMessageType(position: Int): Int {
        if(messages[position].isMe){
            return sentmsg
        }
        else if(messages[position].isMe==false){
            return recievemsg
        }
        else{
            return 0
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sender: TextView = itemView.findViewById(R.id.messageSender)
        val date: TextView = itemView.findViewById(R.id.messageDate)
        val message: TextView = itemView.findViewById(R.id.messageText)

        fun connect(msg: Message){
            sender.text = msg.sender
            date.text = msg.date
            message.text = msg.message
        }
    }

}