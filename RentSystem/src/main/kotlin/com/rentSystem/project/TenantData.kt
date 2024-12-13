package com.rentSystem.project

import java.util.*

open class TenantData(
    ID: UUID = UUID.randomUUID(),
    FirstName: String,
    LastName: String,
    Email: String,
    Phone: String,
    Password: String,
    var RegistrationDate: Date? = Date(),
    var BookingHistory: MutableList<Booking> = mutableListOf(),
    var FavoriteListings: MutableList<Listing> = mutableListOf()
) : UserData( ID, FirstName, LastName, Email, Phone, Password)