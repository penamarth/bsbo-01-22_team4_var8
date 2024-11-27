package com.rentSystem.project

import java.util.*

class Owner(
    id: UUID,
    firstName: String,
    lastName: String,
    email: String,
    phone: String,
    password: String,
    val registrationDate: Date,
    val propertyList: MutableList<Property> = mutableListOf()
) : User(id, firstName, lastName, email, phone, password) {

    fun addProperty(property: Property) {
        propertyList.add(property)
        println("Property ${property.id} added to owner $firstName $lastName.")
    }

    override fun update(notification: Notification) {
        println("Owner $firstName $lastName received notification: ${notification.messageText}")
    }
}
