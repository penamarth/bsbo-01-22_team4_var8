package com.rentSystem.project

interface Notifier {
    fun subscribe(observer: Observer, notificationType: String)
    fun unsubscribe(observer: Observer, notificationType: String)
    fun notifyObservers(notification: Notification)
}

