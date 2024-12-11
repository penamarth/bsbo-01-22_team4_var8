package com.rentSystem.project

import java.util.*

// --- Интерфейс Observer ---
interface Observer {
    fun update(notification: Notification)
}
