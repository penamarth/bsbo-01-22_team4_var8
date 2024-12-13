package com.rentSystem.project

import java.util.*

open class OwnerData(
    ID: UUID = UUID.randomUUID(),
    FirstName: String,
    LastName: String,
    Email: String,
    Phone: String,
    Password: String,
    RegistrationDate: Date = Date(),
    PropertyList: MutableList<Property> = mutableListOf()
): UserData(ID, FirstName, LastName, Email, Phone, Password)