package com.rentSystem.project

import java.util.*

data class Listing(
    val id: UUID,
    val propertyID: UUID,
    var description: String,
    var price: Double,
    var rentalTerms: String,
    val publicationDate: Date,
    var status: String = "Available" // По умолчанию статус "Доступно"
) {

    fun updateDescription(newDescription: String) {
        description = newDescription
        println("Listing $id: Description updated to '$newDescription'.")
    }

    fun updatePrice(newPrice: Double) {
        price = newPrice
        println("Listing $id: Price updated to $$newPrice.")
    }

    fun updateStatus(newStatus: String) {
        status = newStatus
        println("Listing $id: Status updated to '$newStatus'.")
    }

    fun displayDetails() {
        println("Listing Details:")
        println("ID: $id")
        println("Property ID: $propertyID")
        println("Description: $description")
        println("Price: $price")
        println("Rental Terms: $rentalTerms")
        println("Publication Date: $publicationDate")
        println("Status: $status")
    }
}
