package com.rentSystem.project

import java.util.*

interface Observer {
    val id: UUID
    fun update(notification: Notification)
}
