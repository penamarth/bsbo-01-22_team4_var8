package com.rentSystem.project

import java.util.*

interface IUserManager {
    fun addUser(user: User): UUID
    fun getUserByID(userID: UUID): User?
    fun getAllUsers(): List<User>
}

interface IBookingManager {
    fun createBooking(booking: Booking): UUID
    fun getBookingByID(bookingID: UUID): Booking?
    fun getBookingsByUser(userID: UUID): List<Booking>
}

interface IPropertyManager {
    fun addProperty(property: Property): UUID
    fun getPropertyByID(propertyID: UUID): Property?
    fun getPropertiesByOwner(ownerID: UUID): List<Property>
}
