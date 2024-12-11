package com.rentSystem.project

import java.util.*

// --- Класс Listing ---
data class Listing(
    val ID: UUID = UUID.randomUUID(),
    var Description: String,
    var Price: Double,
    var Photos: MutableList<String> = mutableListOf(),
    var RentalTerms: String,
    var PublicationDate: Date = Date(),
    var Status: String
) {
    override fun toString(): String {
        return "Listing(ID=$ID, Description='$Description', Price=$Price, Status='$Status')"
    }
}