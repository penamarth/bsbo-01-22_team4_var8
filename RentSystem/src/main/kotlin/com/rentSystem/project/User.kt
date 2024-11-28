package com.rentSystem.project

import java.util.*

open class User(
    override val id: UUID,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String
) : Observer {
    override fun update(notification: Notification) {
        println("$firstName $lastName получил уведомление: ${notification.messageText}")
    }
}