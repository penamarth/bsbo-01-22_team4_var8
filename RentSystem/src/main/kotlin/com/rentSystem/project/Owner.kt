package com.rentSystem.project

import java.util.*

class Owner(
    ID: UUID = UUID.randomUUID(),
    FirstName: String,
    LastName: String,
    Email: String,
    Phone: String,
    Password: String,
    var RegistrationDate: Date = Date(),
    var PropertyList: MutableList<Property> = mutableListOf()
) : User(ID, FirstName, LastName, Email, Phone, Password) {

    override fun toString(): String {
        return "Owner(${super.toString()}, RegistrationDate=$RegistrationDate, PropertyList=${PropertyList.size})"
    }

    // Пример метода добавления объекта недвижимости
    fun addProperty(property: Property) {
        PropertyList.add(property)
        println("Property added to Owner [$FirstName $LastName]: $property")
    }
}

