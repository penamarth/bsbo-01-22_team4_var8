package com.rentSystem.project

// --- Интерфейс Notifier ---
interface Notifier {
    fun subscribe(observer: Observer)
    fun unsubscribe(observer: Observer)
    fun notifyObservers(notification: Notification)
}

