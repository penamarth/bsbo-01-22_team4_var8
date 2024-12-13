package com.rentSystem.project

import java.util.*
import kotlin.concurrent.thread

fun main() {
    // Инициализация менеджеров
    val userManager: IUserManager = UserManager()
    val bookingManager: IBookingManager = BookingManager()
    val propertyManager: IPropertyManager = PropertyManager()

    // Инициализация фасада
    val facade = BookingSystemFacade(userManager, bookingManager, propertyManager)

    val tenant1 = TenantData(
        FirstName = "Иван",
        LastName = "Иванов",
        Email = "ivan.ivanov@example.com",
        Phone = "+1234567890",
        Password = "password123"
    )
    val owner1 = OwnerData(
        FirstName = "Иван",
        LastName = "Иванов",
        Email = "ivan.ivanov@example.com",
        Phone = "+1234567890",
        Password = "password123"
    )
    val admin1 = AdministratorData(
        FirstName = "Алексей",
        LastName = "Смирнов",
        Email = "alexey.smirnov@example.com",
        Phone = "+1122334455",
        Password = "adminPass"
    )

    val property1 = PropertyData(
        ownerId = null,
        Address = "ул. Ленина, д.1",
        Description = "Уютная квартира в центре города",
        Price = 50000.0,
        NumberOfRooms = 3,
        Photos = mutableListOf("photo1.jpg", "photo2.jpg"),
        Amenities = mutableListOf("WiFi", "Кондиционер"),
        AvailabilityStatus = "Available"
    )
    val property2 = PropertyData(
        ownerId = null,
        Address = "пр. Мира, д.5",
        Description = "Современный офисный комплекс",
        Price = 150000.0,
        NumberOfRooms = 10,
        Photos = mutableListOf("photo3.jpg", "photo4.jpg"),
        Amenities = mutableListOf("WiFi", "Парковка"),
        AvailabilityStatus = "Available"
    )
    val booking1 = BookingData(
        StartDate = Date(),
        EndDate = Date(System.currentTimeMillis() + 86400000), // +1 день
        Status = "Confirmed",
        PaymentAmount = 1500.0,
        Payment = PaymentData(
            Amount = 1500.0,
            PaymentMethod = "Credit Card",
            Status = "Completed"
        )
    )


    // Добавление пользователей через фасад
    println("\n--- Добавление Пользователей через Фасад ---")
    val tenantID = facade.addUser(tenant1)
    val ownerID = facade.addUser(owner1)
    val adminID = facade.addUser(admin1)

    // Добавление свойств через фасад
    println("\n--- Добавление Свойств через Фасад ---")
    val propertyID1 = facade.addProperty(property1)
    val propertyID2 = facade.addProperty(propertiesData["property2"]!!.apply { ownerId=ownerID })

    // Получение всех пользователей
    println("\n--- Получение Всех Пользователей ---")
    val allUsers = facade.getAllUsers()
    allUsers.forEach { println(it) }

    // Получение свойства по ID
    println("\n--- Получение Свойства по ID ---")
    val retrievedProperty = facade.getPropertyByID(propertyID1)
    println(retrievedProperty)

    // Обновление свойства
    println("\n--- Обновление Свойства ---")
    val updatedProperty = retrievedProperty.copy(Price = 55000.0, AvailabilityStatus = "Unavailable")
    facade.updateProperty(propertyID1, updatedProperty)

    // Подписка арендатора и администратора на уведомления об обновлении свойства
    println("\n--- Подписка на Уведомления ---")
    val tenant = usersData["tenant1"] as Tenant
    val admin = usersData["admin1"] as Administrator
    val owner = usersData["owner1"] as Owner
    val property = facade.getPropertyByID(propertyID1)
    property.subscribe(tenant)
    property.subscribe(admin)

    // Обновление деталей свойства (это должно уведомить подписчиков)
    println("\n--- Обновление Деталей Свойства и Уведомление Подписчиков ---")
    val updatedPropertyDetails = property.copy(Description = "Обновленная уютная квартира с новой мебелью")
    property.updateDetails(updatedPropertyDetails)

    // Создание бронирования через фасад
    println("\n--- Создание Бронирования через Фасад ---")
    val booking = bookingsData["booking1"]!!.apply {
        userId = tenantID
        propertyId = propertyID2
    }
    facade.createBooking(booking)

    // Добавление бронирования к арендатору
    println("\n--- Добавление Бронирования к Арендатору ---")
    tenant.addBooking(booking)

    // Формирование арендного соглашения
    println("\n--- Формирование Арендного Соглашения ---")
    val agreement = booking.formRentalAgreement()

    // Отправка уведомлений
    println("\n--- Отправка Уведомлений ---")
    val notification1 = Notification(
        messageText = "Ваше бронирование подтверждено.",
        notificationType = "Booking Confirmation"
    )
    tenant.update(notification1)
    admin.manageNotification(notification1)

    val notification2 = Notification(
        messageText = "Цена на вашу квартиру была обновлена.",
        notificationType = "Price Update"
    )
    owner.update(notification2)
    admin.manageNotification(notification2)

    // Обновление статуса бронирования и отправка уведомления
    println("\n--- Обновление Статуса Бронирования и Отправка Уведомления ---")
    booking.Status = "Completed"
    println("Booking status updated: $booking")
    val notification3 = Notification(
        messageText = "Ваше бронирование завершено.",
        notificationType = "Booking Completion"
    )
    tenant.update(notification3)
    admin.manageNotification(notification3)

    // Демонстрация работы Review и Message
    println("\n--- Демонстрация Review и Message ---")
    val review = Review(
        Rating = 5,
        Comment = "Отличный арендодатель и прекрасное жилье!",
        Date = Date()
    )
    println("Review created: $review")

    val message = Message(
        SenderID = tenantID,
        RecipientID = ownerID,
        MessageText = "Здравствуйте, хотел бы уточнить детали аренды.",
        SentDate = Date()
    )
    println("Message created: $message")
}






