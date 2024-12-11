package com.rentSystem.project

import java.util.*

class Tenant(
    ID: UUID = UUID.randomUUID(),
    FirstName: String,
    LastName: String,
    Email: String,
    Phone: String,
    Password: String,
    var RegistrationDate: Date = Date(),
    var BookingHistory: MutableList<Booking> = mutableListOf(),
    var FavoriteListings: MutableList<Listing> = mutableListOf()
) : User(ID, FirstName, LastName, Email, Phone, Password) {

    override fun toString(): String {
        return "Tenant(${super.toString()}, RegistrationDate=$RegistrationDate, BookingHistory=${BookingHistory.size}, FavoriteListings=${FavoriteListings.size})"
    }

    // Пример метода добавления бронирования
    fun addBooking(booking: Booking) {
        BookingHistory.add(booking)
        println("Booking added to Tenant [$FirstName $LastName]: $booking")
    }

    // Пример метода добавления объявления в избранное
    fun addFavoriteListing(listing: Listing) {
        FavoriteListings.add(listing)
        println("Listing added to favorites for Tenant [$FirstName $LastName]: $listing")
    }
}

