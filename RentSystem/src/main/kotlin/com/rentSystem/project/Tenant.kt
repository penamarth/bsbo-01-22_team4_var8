package com.rentSystem.project

import java.util.*

class Tenant(
    id: UUID,
    firstName: String,
    lastName: String,
    email: String,
    phone: String,
    password: String,
    val registrationDate: Date,
    val bookingHistory: MutableList<Booking> = mutableListOf(),
    val favoriteListings: MutableList<Listing> = mutableListOf()
) : User(id, firstName, lastName, email, phone, password) {

    fun addFavoriteListing(listing: Listing) {
        favoriteListings.add(listing)
        println("Listing ${listing.id} added to favorites for tenant $firstName $lastName.")
    }

    fun addBookingToHistory(booking: Booking) {
        bookingHistory.add(booking)
        println("Booking ${booking.id} added to history for tenant $firstName $lastName.")
    }

    override fun update(notification: Notification) {
        println("Tenant $firstName $lastName received notification: ${notification.messageText}")
    }
}
