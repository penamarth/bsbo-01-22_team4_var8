package com.rentSystem.project

import java.util.*

// --- Фасад ---
// --- BookingSystemFacade ---
class BookingSystemFacade(
    private val userManager: IUserManager,
    private val bookingManager: IBookingManager,
    private val propertyManager: IPropertyManager
) {
    // Добавление пользователя
    fun addUser(user: User): UUID {
        println("Facade: Adding user $user")
        return userManager.addUser(user)
    }

    // Получение пользователя по ID
    fun getUserByID(userID: UUID): User {
        println("Facade: Getting user by ID $userID")
        return userManager.getUserByID(userID)
    }

    // Получение всех пользователей
    fun getAllUsers(): List<User> {
        println("Facade: Getting all users")
        return userManager.getAllUsers()
    }

    // Обновление пользователя
    fun updateUser(userID: UUID, updatedUser: User) {
        println("Facade: Updating user with ID $userID")
        userManager.updateUser(userID, updatedUser)
    }

    // Удаление пользователя
    fun deleteUser(userID: UUID) {
        println("Facade: Deleting user with ID $userID")
        userManager.deleteUser(userID)
    }

    // Добавление недвижимости
    fun addProperty(property: Property): UUID {
        println("Facade: Adding property $property")
        return propertyManager.addProperty(property)
    }

    // Получение недвижимости по ID
    fun getPropertyByID(propertyID: UUID): Property {
        println("Facade: Getting property by ID $propertyID")
        return propertyManager.getPropertyByID(propertyID)
    }

    // Получение недвижимости по владельцу
    fun getPropertiesByOwner(ownerID: UUID): List<Property> {
        println("Facade: Getting properties by owner ID $ownerID")
        return propertyManager.getPropertiesByOwner(ownerID)
    }

    // Обновление недвижимости
    fun updateProperty(propertyID: UUID, updatedProperty: Property) {
        println("Facade: Updating property with ID $propertyID")
        propertyManager.updateProperty(propertyID, updatedProperty)
    }

    // Удаление недвижимости
    fun removeProperty(propertyID: UUID) {
        println("Facade: Removing property with ID $propertyID")
        propertyManager.removeProperty(propertyID)
    }

    // Создание бронирования
    fun createBooking(booking: Booking): UUID {
        println("Facade: Creating booking $booking")
        return bookingManager.createBooking(booking)
    }

    // Получение бронирования по ID
    fun getBookingByID(bookingID: UUID): Booking {
        println("Facade: Getting booking by ID $bookingID")
        return bookingManager.getBookingByID(bookingID)
    }

    // Получение бронирований пользователя
    fun getBookingsByUser(userID: UUID): List<Booking> {
        println("Facade: Getting bookings for user ID $userID")
        return bookingManager.getBookingsByUser(userID)
    }

    // Обновление бронирования
    fun updateBooking(bookingID: UUID, updatedBooking: Booking) {
        println("Facade: Updating booking with ID $bookingID")
        bookingManager.updateBooking(bookingID, updatedBooking)
    }

    // Отмена бронирования
    fun cancelBooking(bookingID: UUID) {
        println("Facade: Cancelling booking with ID $bookingID")
        bookingManager.cancelBooking(bookingID)
    }
}


