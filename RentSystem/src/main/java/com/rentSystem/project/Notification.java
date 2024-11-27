package com.rentSystem.project;
import java.util.UUID;

public class Notification {
    private final UUID id;
    private final String messageText;
    private final String notificationType;

    public Notification(String messageText, String notificationType) {
        this.id = UUID.randomUUID();
        this.messageText = messageText;
        this.notificationType = notificationType;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getNotificationType() {
        return notificationType;
    }
}
