package com.rentSystem.project

import java.util.*
import kotlin.concurrent.thread

fun main() {
    // Инициализация компонентов системы
    val userManager = UserManager()
    val bookingManager = BookingManager()
    val propertyManager = PropertyManager()
    val notificationModule = NotificationModule()

    val facade = BookingSystemFacade(userManager, bookingManager, propertyManager, notificationModule)

    // Регистрация владельца
    val owner = Owner(UUID.randomUUID(), "Иван", "Иванов", "ivanov@example.com", "123456789")
    facade.registerOwner(owner)
    Thread.sleep(1000) // Пауза для симуляции

    // Регистрация арендатора
    val tenant = Tenant(UUID.randomUUID(), "Анна", "Петрова", "petrova@example.com", "987654321")
    facade.registerTenant(tenant)
    Thread.sleep(1000)

    // Добавление недвижимости
    val property = Property(
        "Улица Ленина, 10",
        "Квартира с видом на парк",
        100.0,
        3,
        listOf("photo1.jpg", "photo2.jpg")
    )
    propertyManager.addProperty(property)
    println("Недвижимость добавлена: ${property.description}")
    Thread.sleep(1000)

    // Создание объявления
    val listing = Listing(
        id = UUID.randomUUID(),
        description = "Уютная квартира в центре города",
        price = 150.0,
        photos = listOf("listing1.jpg", "listing2.jpg"),
        rentalTerms = "Минимальный срок аренды - 1 месяц",
        publicationDate = Date(),
        status = "Активно",
        propertyId = property.id
    )
    tenant.addToFavorites(listing)
    println("Объявление создано и добавлено в избранное арендатора: ${listing.description}")
    Thread.sleep(1000)

    // Создание бронирования
    val booking = Booking(
        id = UUID.randomUUID(),
        startDate = Date(),
        endDate = Date(System.currentTimeMillis() + 86400000), // +1 день
        status = "Забронировано",
        paymentAmount = 150.0,
        tenantID = tenant.id,
        ownerID = owner.id,
        property = property
    )

// Сформировать соглашение аренды
    val agreement = booking.formRentalAgreement()
    println("Договор аренды: ${agreement.id}, Сумма: ${agreement.rentalAmount}, Адрес: ${agreement.propertyAddress}")

    facade.createBooking(booking)
    Thread.sleep(1000)

    // Уведомление об оплате
    val paymentNotification = Notification(
        id = UUID.randomUUID(),
        messageText = "Платеж в размере ${booking.paymentAmount} выполнен",
        sentDate = Date(),
        notificationType = "Оплата"
    )
    notificationModule.notifyObservers(paymentNotification)
    Thread.sleep(1000)

    // Арендатор оставляет отзыв
    val review = Review(
        id = UUID.randomUUID(),
        rating = 5,
        comment = "Отличная квартира! Очень понравилось!",
        date = Date(),
        userId = tenant.id, // Идентификатор арендатора, оставившего отзыв
        propertyId = property.id // Идентификатор недвижимости
    )
    tenant.leaveReview(review)
    val reviewNotification = Notification(
        id = UUID.randomUUID(),
        messageText = "Новый отзыв на вашу недвижимость: ${review.comment}",
        sentDate = Date(),
        notificationType = "Отзыв"
    )
    notificationModule.notifyObservers(reviewNotification)
    Thread.sleep(1000)

    // Вывод избранных объявлений арендатора
    println("Избранные объявления арендатора:")
    tenant.favoriteListings.forEach {
        println(" - ${it.description}, Цена: ${it.price}")
    }
    Thread.sleep(1000)

    println("Симуляция завершена.")
}






