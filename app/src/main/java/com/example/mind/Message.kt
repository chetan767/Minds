package com.example.mind

import android.content.Context
import java.util.*

interface ChatEvent {
    val sentAt: Date
}

data class Message(
    val msg: String,
    val senderId: String,
    val msgId: String,
    val type: String = "TEXT",
    val status: Int = 1,
    var liked: Boolean = false,
    val time: Long = System.currentTimeMillis(),
    override val sentAt: Date = Date()
) : ChatEvent {

    /** Empty [Constructor] for Firebase */
    constructor() : this("", "", "", "", 1, false, System.currentTimeMillis(), Date(0L))
}

data class DateHeader(override val sentAt: Date, val context: Context) : ChatEvent {
    val date: String = sentAt.formatAsHeader(context)
}