package com.rentSystem.project

import java.util.*

data class Review(
    val id: UUID = UUID.randomUUID(),   // Уникальный идентификатор отзыва
    val rating: Int,                   // Оценка от 1 до 5
    val comment: String,               // Комментарий к отзыву
    val date: Date,                    // Дата оставления отзыва
    val userId: UUID,                  // Идентификатор пользователя, оставившего отзыв
    val propertyId: UUID               // Идентификатор объекта недвижимости
)
