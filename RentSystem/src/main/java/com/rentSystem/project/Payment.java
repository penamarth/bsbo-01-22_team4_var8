package com.rentSystem.project;

import java.util.Date;
import java.util.UUID;

public class Payment {
    private UUID id;
    private Date paymentDate;
    private double amount;
    private String paymentMethod;
    private String status;

    public Payment(double amount, String paymentMethod, String status) {
        this.id = UUID.randomUUID();
        this.paymentDate = new Date();
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getStatus() {
        return status;
    }
}

