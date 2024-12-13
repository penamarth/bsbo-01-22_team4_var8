package com.rentSystem.project

import java.util.*

data class PaymentData(
    val ID: UUID = UUID.randomUUID(),
    var PaymentDate: Date = Date(),
    var Amount: Double,
    var PaymentMethod: String,
    var Status: String
)