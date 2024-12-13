package com.rentSystem.project

import java.util.*

data class BookingData(
    val ID: UUID = UUID.randomUUID(),
    var StartDate: Date,
    var EndDate: Date,
    var Status: String,
    var PaymentAmount: Double,
    var Payment: PaymentData,
    var userId: UUID = UUID.randomUUID(), // Добавлено свойство userId
    var propertyId: UUID = UUID.randomUUID() // Добавлено свойство propertyId
)
