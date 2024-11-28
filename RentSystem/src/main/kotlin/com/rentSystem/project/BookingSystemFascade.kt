package com.rentSystem.project

import java.util.*

class BookingSystemFacade(
    private val userManager: UserManager,
    private val bookingManager: BookingManager,
    private val propertyManager: PropertyManager,
    private val notificationModule: NotificationModule
) {
    fun registerOwner(owner: Owner) {
        userManager.addUser(owner)
        notificationModule.subscribe(owner, "Бронирование")
        notificationModule.subscribe(owner, "Отзыв")
        println("Владелец ${owner.firstName} ${owner.lastName} зарегистрирован и подписан на уведомления.")
    }

    fun registerTenant(tenant: Tenant) {
        userManager.addUser(tenant)
        notificationModule.subscribe(tenant, "Оплата")
        println("Арендатор ${tenant.firstName} ${tenant.lastName} зарегистрирован и подписан на уведомления.")
    }

    fun createBooking(booking: Booking) {
        bookingManager.addBooking(booking)

        val notification = Notification(
            id = UUID.randomUUID(),
            messageText = "Новое бронирование для вашей недвижимости: ${booking.property.address}",
            sentDate = Date(),
            notificationType = "Бронирование"
        )
        notificationModule.notifyObservers(notification)
    }
}


