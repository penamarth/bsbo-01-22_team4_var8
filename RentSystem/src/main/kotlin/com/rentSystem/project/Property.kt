package com.rentSystem.project

import java.util.*

data class Property(
    val id: UUID,
    val ownerID: UUID,
    var address: String,
    var description: String,
    var pricePerDay: Double,
    var numberOfRooms: Int,
    var photos: List<String> = emptyList(),
    var amenities: List<String> = emptyList(),
    var availabilityStatus: String = "Available" // Возможные значения: Available, Unavailable
) {
    // Метод для изменения статуса доступности
    fun changeAvailabilityStatus(newStatus: String) {
        availabilityStatus = newStatus
        println("Property $id availability status changed to $availabilityStatus.")
    }

    // Метод для добавления удобств
    fun addAmenity(amenity: String) {
        amenities = amenities + amenity
        println("Amenity '$amenity' has been added to property $id.")
    }

    // Метод для добавления фотографий
    fun addPhoto(photoUrl: String) {
        photos = photos + photoUrl
        println("Photo '$photoUrl' has been added to property $id.")
    }

    // Метод для обновления цены
    fun updatePrice(newPrice: Double) {
        pricePerDay = newPrice
        println("Property $id price updated to $$newPrice per day.")
    }

    // Метод для отображения информации о недвижимости
    fun displayDetails() {
        println("Property Details:")
        println("ID: $id")
        println("Owner ID: $ownerID")
        println("Address: $address")
        println("Description: $description")
        println("Price per day: $$pricePerDay")
        println("Number of rooms: $numberOfRooms")
        println("Photos: ${photos.joinToString(", ")}")
        println("Amenities: ${amenities.joinToString(", ")}")
        println("Availability status: $availabilityStatus")
    }
}
