package com.rentSystem.project

import java.util.*

import java.util.*

data class Booking(
    val id: UUID,
    val tenantID: UUID,
    val propertyID: UUID,
    var startDate: Date,
    var endDate: Date,
    var status: String = "Pending", // По умолчанию статус "Ожидание"
    var paymentAmount: Double,
    var payment: Payment? = null // Может быть `null`, пока оплата не произведена
) {

    fun updateDates(newStartDate: Date, newEndDate: Date) {
        startDate = newStartDate
        endDate = newEndDate
        println("Booking $id: Dates updated to start=$newStartDate, end=$newEndDate.")
    }

    fun updateStatus(newStatus: String) {
        status = newStatus
        println("Booking $id: Status updated to '$newStatus'.")
    }

    fun addPayment(payment: Payment) {
        this.payment = payment
        println("Booking $id: Payment added with ID ${payment.id} and amount $${payment.amount}.")
    }

    fun displayDetails() {
        println("Booking Details:")
        println("ID: $id")
        println("Tenant ID: $tenantID")
        println("Property ID: $propertyID")
        println("Start Date: $startDate")
        println("End Date: $endDate")
        println("Status: $status")
        println("Payment Amount: $paymentAmount")
        println("Payment Info: ${payment?.let { "Paid on ${it.paymentDate} with method ${it.paymentMethod}, status: ${it.status}" } ?: "No payment yet."}")
    }
}

