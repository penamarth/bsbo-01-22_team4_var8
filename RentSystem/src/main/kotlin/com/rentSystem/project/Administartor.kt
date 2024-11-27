package com.rentSystem.project

import java.util.*

class Administrator(
    id: UUID = UUID.randomUUID(),
    firstName: String,
    lastName: String,
    email: String,
    phone: String,
    password: String
): User(id, firstName, lastName, email, phone, password)