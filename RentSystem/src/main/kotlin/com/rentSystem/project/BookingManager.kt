package com.rentSystem.project

import java.util.*

// BookingManager реализует IBookingManager
class BookingManager : IBookingManager {
    private val bookings: MutableList<Booking> = mutableListOf()

    override fun createBooking(booking: Booking): UUID {
        bookings.add(booking)
        println("Booking created: $booking")
        return booking.ID
    }

    override fun getBookingByID(bookingID: UUID): Booking {
        val booking = bookings.find { it.ID == bookingID }
        return if (booking != null) {
            println("Retrieved Booking: $booking")
            booking
        } else {
            println("Booking with ID $bookingID not found")
            throw BookingNotFoundException()
        }
    }

    override fun getBookingsByUser(userID: UUID): List<Booking> {
        val userBookings = bookings.filter { it.userId == userID }
        println("Retrieved ${userBookings.size} bookings for User ID $userID")
        return userBookings
    }

    override fun updateBooking(bookingID: UUID, updatedBooking: Booking) {
        val index = bookings.indexOfFirst { it.ID == bookingID }
        if (index != -1) {
            bookings[index] = updatedBooking
            println("Booking with ID $bookingID updated to: $updatedBooking")
        } else {
            println("Cannot update. Booking with ID $bookingID not found")
            throw BookingNotFoundException()
        }
    }

    override fun cancelBooking(bookingID: UUID) {
        val booking = bookings.find { it.ID == bookingID }
        if (booking != null) {
            booking.Status = "Cancelled"
            println("Booking with ID $bookingID has been cancelled")
        } else {
            println("Cannot cancel. Booking with ID $bookingID not found")
            throw BookingNotFoundException()
        }
    }
}
