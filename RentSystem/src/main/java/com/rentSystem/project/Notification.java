package com.rentSystem.project;

import java.util.Date;
import java.util.UUID;

public class Notification {
    private final UUID id; // Уникальный идентификатор уведомления
    private final UUID recipientID; // ID получателя (например, Owner, Tenant, Administrator)
    private final String messageText; // Текст уведомления
    private final Date sentDate; // Дата отправки
    private final String notificationType; // Тип уведомления ("Booking", "Payment", и т.д.)

    // Конструктор
    public Notification(UUID id, UUID recipientID, String messageText, Date sentDate, String notificationType) {
        this.id = id;
        this.recipientID = recipientID;
        this.messageText = messageText;
        this.sentDate = sentDate;
        this.notificationType = notificationType;
    }

    // Геттеры
    public UUID getId() {
        return id;
    }

    public UUID getRecipientID() {
        return recipientID;
    }

    public String getMessageText() {
        return messageText;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public String getNotificationType() {
        return notificationType;
    }

    // Метод для отображения деталей уведомления
    public void displayDetails() {
        System.out.println("Notification Details:");
        System.out.println("ID: " + id);
        System.out.println("Recipient ID: " + recipientID);
        System.out.println("Message: " + messageText);
        System.out.println("Sent Date: " + sentDate);
        System.out.println("Notification Type: " + notificationType);
    }

    // Фабричный метод для упрощения создания объектов Notification
    public static Notification createNotification(UUID recipientID, String messageText, String notificationType) {
        return new Notification(
                UUID.randomUUID(),
                recipientID,
                messageText,
                new Date(),
                notificationType
        );
    }

    public static void main(String[] args) {
        // Пример создания объекта Notification с использованием фабричного метода
        UUID ownerId = UUID.randomUUID();  // Пример ID владельца
        Notification notification1 = Notification.createNotification(
                ownerId,
                "Ваше имущество было забронировано!",
                "Booking"
        );

        // Печать деталей уведомления
        notification1.displayDetails();
    }
}
