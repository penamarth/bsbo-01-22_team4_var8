package com.rentSystem.project

import java.util.*

data class Administrator(
    val id: UUID = UUID.randomUUID(),
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String
) {

    val notificationModule = NotificationModule()
    // Администратор может отправлять уведомления
    fun sendNotification(notification: Notification) {
        println("Уведомление от администратора: ${notification.messageText}")
        notificationModule.notifyObservers(notification)
    }

    // Администратор может управлять пользователями
    fun addUser(userManager: UserManager, user: User) {
        val userId = userManager.addUser(user)
        println("Пользователь ${user.firstName} ${user.lastName} добавлен в систему.")
    }

    // Администратор может управлять объявлениями
    fun addProperty(propertyManager: PropertyManager, property: Property) {
        val propertyId = propertyManager.addProperty(property)
        println("Недвижимость добавлена: ${property.description}")
    }

    // Администратор может управлять бронированиями
    fun createBooking(bookingManager: BookingManager, booking: Booking) {
        val bookingId = bookingManager.createBooking(booking)
        println("Бронирование создано: ${bookingId}")
    }

    // Администратор может просматривать и управлять уведомлениями
    fun manageNotifications(notificationModule: NotificationModule, notification: Notification) {
        notificationModule.notifyObservers(notification)
        println("Уведомление отправлено: ${notification.messageText}")
    }
}
