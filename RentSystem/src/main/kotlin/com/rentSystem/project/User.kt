package com.rentSystem.project

import java.util.*

open class User(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val password: String
) : Observer {

    override fun update(notification: Notification) {
        println("User $firstName $lastName received notification: ${notification.messageText}")
    }

    fun displayInfo() {
        println("User Info:")
        println("ID: $id")
        println("Name: $firstName $lastName")
        println("Email: $email")
        println("Phone: $phone")
    }
}
