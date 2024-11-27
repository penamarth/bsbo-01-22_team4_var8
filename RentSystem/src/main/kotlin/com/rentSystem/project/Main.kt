package com.rentSystem.project

import java.util.*

fun main() {
    // Создаем модули системы
    val userManager = UserManager()
    val bookingManager = BookingManager()
    val propertyManager = PropertyManager()
    val notificationModule = NotificationModule()

    // Создаем фасад системы
    val bookingSystem = BookingSystemFacade(
        userManager,
        bookingManager,
        propertyManager,
        notificationModule
    )

    // --- Тестируем добавление пользователей ---
    println("=== Добавление пользователей ===")
    val tenant = Tenant(
        id = UUID.randomUUID(),
        firstName = "Alice",
        lastName = "Johnson",
        email = "alice@example.com",
        phone = "+123456789",
        password = "password123",
        registrationDate = Date()
    )
    val owner = Owner(
        id = UUID.randomUUID(),
        firstName = "Bob",
        lastName = "Smith",
        email = "bob@example.com",
        phone = "+987654321",
        password = "password456",
        registrationDate = Date()
    )

    val admin = Administrator(
        id = UUID.randomUUID(),
        firstName = "Admin",
        lastName = "User",
        email = "admin@example.com",
        phone = "+1122334455",
        password = "12345"
    )

    bookingSystem.userManager.addUser(tenant)
    bookingSystem.userManager.addUser(owner)

    println("Добавлено пользователей: ${userManager.getAllUsers().size}")
    println()

    // --- Подписка пользователей на уведомления ---
    println("=== Подписка на уведомления ===")
    bookingSystem.notificationModule.subscribe(tenant, "Subscribe")
    bookingSystem.notificationModule.subscribe(owner, "Subscribe")

    // --- Тестируем добавление недвижимости ---
    println("=== Добавление недвижимости ===")
    val property1 = Property(
        id = UUID.randomUUID(),
        ownerID = owner.id,
        address = "123 Main Street, New York",
        description = "Spacious apartment with a great view.",
        pricePerDay = 150.0,
        numberOfRooms = 3
    )
    val property2 = Property(
        id = UUID.randomUUID(),
        ownerID = owner.id,
        address = "456 Ocean Drive, Miami",
        description = "Luxury villa near the beach.",
        pricePerDay = 500.0,
        numberOfRooms = 5
    )

    propertyManager.addProperty(property1)
    propertyManager.addProperty(property2)

    println("Добавлено недвижимости: ${propertyManager.getPropertiesByOwner(owner.id).size}")
    println()

    // --- Тестируем бронирование ---
    println("=== Создание бронирования ===")
    val booking = Booking(
        id = UUID.randomUUID(),
        tenantID = tenant.id,
        propertyID = property1.id,
        startDate = Date(),
        endDate = Date(System.currentTimeMillis() + 86400000L * 7), // 7 дней
        status = "Pending",
        paymentAmount = 1050.0
    )
    bookingManager.createBooking(booking)
    println("Бронирование создано: ${booking.id}")
    println()

    // --- Тестируем отправку уведомлений ---
    println("=== Отправка уведомлений ===")
    val notification1 = Notification(
        UUID.randomUUID(),
        owner.id,
        "Ваше имущество было забронировано!",
        Date(),
        "Booking"
    )
    val notification2 = Notification(
        UUID.randomUUID(),       // id
        tenant.id,               // recipientID
        "Ваше бронирование подтверждено!",  // messageText
        Date(),                  // sentDate
        "Booking"                // notificationType
    )

    bookingSystem.sendNotification(notification1)
    bookingSystem.sendNotification(notification2)
    println()

    // --- Тестируем управление статусами ---
    println("=== Управление статусами ===")
    property1.changeAvailabilityStatus("Unavailable")
    booking.updateStatus("Confirmed")
    println()

    // --- Тестируем просмотр информации ---
    println("=== Просмотр информации ===")
    property1.displayDetails()
    println("Бронирование пользователя ${tenant.firstName}:")
    booking.displayDetails()

    // --- Тестируем подписку и отписку ---
    println("=== Тест подписки и отписки ===")
    notificationModule.unsubscribe(owner, "UnSubscribe")
    val notification3 = Notification(
        UUID.randomUUID(),       // id
        owner.id,                // recipientID
        "Вы больше не подписаны на уведомления.",  // messageText
        Date(),                  // sentDate
        "System"                 // notificationType
    )

    bookingSystem.sendNotification(notification3)
    println()
}

