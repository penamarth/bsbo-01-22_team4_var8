package com.rentSystem.project

import java.util.*

interface IBookingManager {
    fun createBooking(booking: Booking): UUID
    fun getBookingByID(bookingID: UUID): Booking
    fun getBookingsByUser(userID: UUID): List<Booking>
    fun updateBooking(bookingID: UUID, updatedBooking: Booking)
    fun cancelBooking(bookingID: UUID)
}