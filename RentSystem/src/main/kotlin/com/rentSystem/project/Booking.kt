package com.rentSystem.project

import java.util.*

data class Booking(
    val id: UUID,
    val startDate: Date,
    val endDate: Date,
    var status: String,
    val paymentAmount: Double,
    val tenantID: UUID,
    val ownerID: UUID,
    val property: Property,
) {
    // Метод для формирования соглашения аренды
    fun formRentalAgreement(): RentalAgreement {
        return RentalAgreement(
            id = UUID.randomUUID(),
            bookingID = id,
            tenantID = tenantID,
            ownerID = ownerID,
            propertyAddress = property.address,
            rentalPeriod = "${startDate} - ${endDate}",
            rentalAmount = paymentAmount,
            agreementDate = Date()
        ).also {
            println("Соглашение аренды сформировано: ${it.id}")
        }
    }
}

data class RentalAgreement(
    val id: UUID,
    val bookingID: UUID,
    val tenantID: UUID,
    val ownerID: UUID,
    val propertyAddress: String,
    val rentalPeriod: String,
    val rentalAmount: Double,
    val agreementDate: Date
)
