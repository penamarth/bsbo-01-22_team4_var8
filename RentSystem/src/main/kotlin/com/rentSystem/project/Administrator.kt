package com.rentSystem.project

import java.util.*

class Administrator(
    ID: UUID = UUID.randomUUID(),
    FirstName: String,
    LastName: String,
    Email: String,
    Phone: String,
    Password: String
) : User(ID, FirstName, LastName, Email, Phone, Password) {

    override fun toString(): String {
        return "Administrator(${super.toString()})"
    }

    // Пример метода управления уведомлениями
    fun manageNotification(notification: Notification) {
        println("Administrator [$FirstName $LastName] is managing notification: $notification")
    }
}
