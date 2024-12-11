package com.rentSystem.project

import java.util.*

// --- Класс Property ---
data class Property(
    val ID: UUID = UUID.randomUUID(),
    var ownerId: UUID?, // Добавлено свойство ownerId
    var Address: String,
    var Description: String,
    var Price: Double,
    var NumberOfRooms: Int,
    var Photos: MutableList<String> = mutableListOf(),
    var Amenities: MutableList<String> = mutableListOf(),
    var AvailabilityStatus: String = "Available"
) : Notifier {
    private val Observers: MutableList<Observer> = mutableListOf()

    override fun subscribe(observer: Observer) {
        Observers.add(observer)
        println("Observer subscribed: $observer to Property at $Address")
    }

    override fun unsubscribe(observer: Observer) {
        if (Observers.remove(observer)) {
            println("Observer unsubscribed: $observer from Property at $Address")
        } else {
            println("Observer not found: $observer for Property at $Address")
        }
    }

    override fun notifyObservers(notification: Notification) {
        println("Property at $Address is notifying observers about: '${notification.messageText}'")
        for (observer in Observers) {
            observer.update(notification)
        }
    }

    // Метод обновления деталей объекта недвижимости
    fun updateDetails(updatedProperty: Property) {
        println("Updating property details from: $this to $updatedProperty")
        this.Address = updatedProperty.Address
        this.Description = updatedProperty.Description
        this.Price = updatedProperty.Price
        this.NumberOfRooms = updatedProperty.NumberOfRooms
        this.Photos = updatedProperty.Photos
        this.Amenities = updatedProperty.Amenities
        this.AvailabilityStatus = updatedProperty.AvailabilityStatus
        // Создаем уведомление об обновлении
        val notification = Notification(
            messageText = "Property details have been updated.",
            notificationType = "Update"
        )
        notifyObservers(notification)
    }

    override fun toString(): String {
        return "Property(ID=$ID, Address='$Address', Description='$Description', Price=$Price, NumberOfRooms=$NumberOfRooms, AvailabilityStatus='$AvailabilityStatus')"
    }
}