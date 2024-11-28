package com.rentSystem.project

import java.util.*

class Owner(
    id: UUID,
    firstName: String,
    lastName: String,
    email: String,
    phone: String
) : User(id, firstName, lastName, email, phone) {
    val propertyList = mutableListOf<Property>()

    fun addProperty(property: Property) {
        propertyList.add(property)
    }
}

