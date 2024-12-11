package com.rentSystem.project

import java.util.*

data class Review(
    val ID: UUID = UUID.randomUUID(),
    var Rating: Int,
    var Comment: String,
    var Date: Date = Date()
) {
    override fun toString(): String {
        return "Review(ID=$ID, Rating=$Rating, Comment='$Comment', Date=$Date)"
    }
}
