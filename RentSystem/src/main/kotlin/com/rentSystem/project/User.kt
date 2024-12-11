package com.rentSystem.project

import java.util.*

open class User(
    val ID: UUID = UUID.randomUUID(),
    var FirstName: String,
    var LastName: String,
    var Email: String,
    var Phone: String,
    var Password: String
) : Observer {
    override fun update(notification: Notification) {
        println("User [$FirstName $LastName] received notification: '${notification.messageText}' at ${notification.sentDate}")
    }

    override fun toString(): String {
        return "User(ID=$ID, FirstName='$FirstName', LastName='$LastName', Email='$Email', Phone='$Phone')"
    }
}