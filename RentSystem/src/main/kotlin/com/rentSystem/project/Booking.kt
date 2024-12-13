package com.rentSystem.project

import java.util.*

// --- Класс Booking ---
class Booking(
    val ID: UUID,
    var StartDate: Date,
    var EndDate: Date,
    var Status: String,
    var PaymentAmount: Double,
    var Payment: Payment,
    var userId: UUID = UUID.randomUUID(), // Добавлено свойство userId
    var propertyId: UUID = UUID.randomUUID() // Добавлено свойство propertyId
) {
    // Метод формирования арендного соглашения
    fun formRentalAgreement(): Agreement {
        println("Forming rental agreement for Booking ID: $ID")
        // Здесь можно добавить логику формирования соглашения
        // Для примера создаем соглашение с данными из бронирования
        val agreement = Agreement(
            bookingId = this.ID,
            tenantId = this.userId,
            ownerId = UUID.randomUUID(),  // В реальной реализации необходимо связать с Owner
            propertyId = this.propertyId,
            terms = "Аренда на 1 год с возможностью продления."
        )
        println("Rental Agreement formed: $agreement")
        return agreement
    }

    override fun toString(): String {
        return "Booking(ID=$ID, StartDate=$StartDate, EndDate=$EndDate, Status='$Status', PaymentAmount=$PaymentAmount, Payment=$Payment, userId=$userId, propertyId=$propertyId)"
    }
}
