package com.rentSystem.project;

import java.util.Date;
import java.util.UUID;

public class Message {
    private UUID id;
    private UUID senderID;
    private UUID recipientID;
    private String messageText;
    private Date sentDate;

    public Message(UUID senderID, UUID recipientID, String messageText) {
        this.id = UUID.randomUUID();
        this.senderID = senderID;
        this.recipientID = recipientID;
        this.messageText = messageText;
        this.sentDate = new Date();
    }

    public UUID getId() {
        return id;
    }

    public UUID getSenderID() {
        return senderID;
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
}

