package com.rentSystem.project

import java.util.*

class Tenant(
    id: UUID,
    firstName: String,
    lastName: String,
    email: String,
    phone: String
) : User(id, firstName, lastName, email, phone) {
    val favoriteListings = mutableListOf<Listing>()

    fun addToFavorites(listing: Listing) {
        favoriteListings.add(listing)
    }

    fun leaveReview(review: Review) {
        println("Отзыв оставлен: ${review.comment}")
    }
}

