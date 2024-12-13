package com.rentSystem.project

import java.util.*

data class ListingData(
    val ID: UUID = UUID.randomUUID(),
    var Description: String,
    var Price: Double,
    var Photos: MutableList<String> = mutableListOf(),
    var RentalTerms: String,
    var PublicationDate: Date = Date(),
    var Status: String
)