package com.rentSystem.project

import java.util.*

data class PropertyData(
    val ID: UUID = UUID.randomUUID(),
    var ownerId: UUID?,
    var Address: String,
    var Description: String,
    var Price: Double,
    var NumberOfRooms: Int,
    var Photos: MutableList<String> = mutableListOf(),
    var Amenities: MutableList<String> = mutableListOf(),
    var AvailabilityStatus: String = "Available"
)
