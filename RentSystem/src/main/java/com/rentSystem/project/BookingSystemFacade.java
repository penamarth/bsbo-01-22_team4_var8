package com.rentSystem.project;


import java.util.Date;
import java.util.UUID;

public class BookingSystemFacade {
    public final IUserManager userManager;
    public final IBookingManager bookingManager;
    public final IPropertyManager propertyManager;
    public final NotificationModule notificationModule;

    public BookingSystemFacade(IUserManager userManager, IBookingManager bookingManager, IPropertyManager propertyManager, NotificationModule notificationModule) {
        this.userManager = userManager;
        this.bookingManager = bookingManager;
        this.propertyManager = propertyManager;
        this.notificationModule = notificationModule;
    }

    public void registerUser(User user) {
        userManager.addUser(user);
    }

    public void createBooking(Booking booking) {
        bookingManager.createBooking(booking);
        // Получаем уникальный ID для уведомления
        UUID id = UUID.randomUUID();

// Пример ID получателя, например, владельца (Owner)
        UUID recipientID = booking.getTenantID();  // Предположим, что у вас есть объект owner

// Текущее время для sentDate
        Date sentDate = new Date();

// Теперь создаем Notification с нужными параметрами
        Notification notification = new Notification(id, recipientID, "New booking created!", sentDate, "Booking");

// Отправляем уведомление наблюдателям
        notificationModule.notifyObservers(notification);
    }

    public void sendNotification(Notification notification) {
        notificationModule.notifyObservers(notification);
    }
}
