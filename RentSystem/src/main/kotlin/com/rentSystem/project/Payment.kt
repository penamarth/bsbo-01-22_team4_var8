package com.rentSystem.project

import java.util.*

data class Payment(
    val id: UUID,
    val paymentDate: Date,
    val amount: Double,
    val paymentMethod: String, // Например, "Credit Card", "PayPal", "Bank Transfer"
    var status: String = "Pending" // По умолчанию статус "Ожидание"
) {

    fun updateStatus(newStatus: String) {
        status = newStatus
        println("Payment $id: Status updated to '$newStatus'.")
    }

    fun displayDetails() {
        println("Payment Details:")
        println("ID: $id")
        println("Date: $paymentDate")
        println("Amount: $amount")
        println("Method: $paymentMethod")
        println("Status: $status")
    }
}
