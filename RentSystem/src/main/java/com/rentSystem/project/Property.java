package com.rentSystem.project;

import java.util.List;
import java.util.UUID;

public class Property {
    private UUID id;
    private String address;
    private String description;
    private double price;
    private int numberOfRooms;

    private List<String> photos;

    public Property(String address, String description, double price, int numberOfRooms, List<String> photos) {
        this.id = UUID.randomUUID();
        this.address = address;
        this.description = description;
        this.price = price;
        this.numberOfRooms = numberOfRooms;
        this.photos = photos;
    }

    public UUID getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public List<String> getPhotos(){ return photos; }
}

