package com.rentSystem.project

import java.util.*

data class Notification(
    val id: UUID,
    val messageText: String,
    val sentDate: Date,
    val notificationType: String // Тип уведомления: "Бронирование", "Оплата", "Отзыв" и т.д.
)
