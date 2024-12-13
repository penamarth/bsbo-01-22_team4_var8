package com.rentSystem.project

import java.util.*

open class AdministratorData(
    ID: UUID = UUID.randomUUID(),
    FirstName: String,
    LastName: String,
    Email: String,
    Phone: String,
    Password: String
) : UserData(ID, FirstName, LastName, Email, Phone, Password)