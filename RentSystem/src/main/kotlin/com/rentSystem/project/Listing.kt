package com.rentSystem.project

import java.util.*

data class Listing(
    val id: UUID = UUID.randomUUID(),
    val description: String,
    val price: Double,
    val photos: List<String>,
    val rentalTerms: String,
    val publicationDate: Date,
    val status: String,
    val propertyId: UUID
)