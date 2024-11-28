package com.rentSystem.project

class NotificationModule : Notifier {
    private val observers = mutableMapOf<String, MutableList<Observer>>() // Карта: тип уведомления -> список наблюдателей

    override fun subscribe(observer: Observer, notificationType: String) {
        observers.computeIfAbsent(notificationType) { mutableListOf() }.add(observer)
        println("${observer::class.simpleName} с ID ${observer.id} подписан на уведомления типа: $notificationType")
    }

    override fun unsubscribe(observer: Observer, notificationType: String) {
        observers[notificationType]?.remove(observer)
        println("${observer::class.simpleName} с ID ${observer.id} отписан от уведомлений типа: $notificationType")
    }

    override fun notifyObservers(notification: Notification) {
        val observersForType = observers[notification.notificationType] ?: emptyList()
        observersForType.forEach { it.update(notification) }
        println("Уведомление отправлено: ${notification.messageText}")
    }
}


