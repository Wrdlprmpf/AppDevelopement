package com.example.a51

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class Message(var sender:String,
              var message:String,
              var isMe:Boolean) {
    var date : String

    init{
        if(isMe){
            this.sender = "Me"
        }
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd-MM HH-mm")
        val formatted = current.format(formatter)
        date = formatted
    }

}