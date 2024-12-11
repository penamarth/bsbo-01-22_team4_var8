package com.rentSystem.project

import java.util.*

data class Message(
    val ID: UUID = UUID.randomUUID(),
    var SenderID: UUID,
    var RecipientID: UUID,
    var MessageText: String,
    var SentDate: Date = Date()
) {
    override fun toString(): String {
        return "Message(ID=$ID, SenderID=$SenderID, RecipientID=$RecipientID, MessageText='$MessageText', SentDate=$SentDate)"
    }
}