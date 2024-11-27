package com.rentSystem.project

import java.util.*

class UserManager : IUserManager {
    private val users: MutableList<User> = mutableListOf()

    override fun addUser(user: User): UUID {
        users.add(user)
        return user.id
    }

    override fun getUserByID(userID: UUID): User? {
        return users.find { it.id == userID }
    }

    override fun getAllUsers(): List<User> {
        return users
    }
}

class BookingManager : IBookingManager {
    private val bookings: MutableList<Booking> = mutableListOf()

    override fun createBooking(booking: Booking): UUID {
        bookings.add(booking)
        return booking.id
    }

    override fun getBookingByID(bookingID: UUID): Booking? {
        return bookings.find { it.id == bookingID }
    }

    override fun getBookingsByUser(userID: UUID): List<Booking> {
        return bookings.filter { it.tenantID == userID }
    }
}

class PropertyManager : IPropertyManager {
    private val properties: MutableList<Property> = mutableListOf()

    override fun addProperty(property: Property): UUID {
        properties.add(property)
        return property.id
    }

    override fun getPropertyByID(propertyID: UUID): Property? {
        return properties.find { it.id == propertyID }
    }

    override fun getPropertiesByOwner(ownerID: UUID): List<Property> {
        return properties.filter { it.ownerID == ownerID }
    }
}



