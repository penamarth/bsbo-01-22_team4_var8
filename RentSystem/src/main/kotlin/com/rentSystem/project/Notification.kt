package com.rentSystem.project

import java.util.*

data class Notification(
    val id: UUID = UUID.randomUUID(),
    val messageText: String,
    val sentDate: Date = Date(),
    val notificationType: String
)
