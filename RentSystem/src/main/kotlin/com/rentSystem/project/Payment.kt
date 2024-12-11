package com.rentSystem.project

import java.util.*

data class Payment(
    val ID: UUID = UUID.randomUUID(),
    var PaymentDate: Date = Date(),
    var Amount: Double,
    var PaymentMethod: String,
    var Status: String
) {
    override fun toString(): String {
        return "Payment(ID=$ID, PaymentDate=$PaymentDate, Amount=$Amount, PaymentMethod='$PaymentMethod', Status='$Status')"
    }
}