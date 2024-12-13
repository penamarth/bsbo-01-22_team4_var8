package com.rentSystem.project

import java.util.*
open class UserData(
    val ID: UUID = UUID.randomUUID(),
    var FirstName: String,
    var LastName: String,
    var Email: String,
    var Phone: String,
    var Password: String
)
