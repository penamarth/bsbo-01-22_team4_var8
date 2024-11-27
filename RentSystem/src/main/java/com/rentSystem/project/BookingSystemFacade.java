package com.rentSystem.project;
import java.util.UUID;

public class BookingSystemFacade {
    private final NotificationModule notificationModule;

    public BookingSystemFacade(NotificationModule notificationModule) {
        this.notificationModule = notificationModule;
    }

    public void sendNotification(String message, String type) {
        Notification notification = new Notification(message, type);
        notificationModule.notifyObservers(notification);
    }
}

