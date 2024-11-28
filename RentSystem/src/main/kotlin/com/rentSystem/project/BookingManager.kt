package com.rentSystem.project

import java.util.*

class BookingManager : IBookingManager {
    private val bookings = mutableListOf<Booking>()

    override fun createBooking(booking: Booking): UUID {
        bookings.add(booking)
        println("Бронирование создано: ${booking.id}, Статус: ${booking.status}")
        return booking.id
    }

    override fun getBookingByID(bookingID: UUID): Booking? {
        return bookings.find { it.id == bookingID }
    }

    override fun getBookingsByUser(userID: UUID): List<Booking> {
        return bookings.filter { it.tenantID == userID }
    }

    override fun addBooking(booking: Booking): UUID {
        bookings.add(booking)
        println("Новое бронирование добавлено: ${booking.id}")
        return booking.id
    }
}
