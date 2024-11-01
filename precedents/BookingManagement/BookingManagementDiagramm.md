@startuml
actor Квартиросъёмщик
actor Владелец
participant "Система" as System
participant "Бронирование" as Booking
participant "Сервис уведомлений" as NotificationService

== Просмотр текущего бронирования ==
Квартиросъёмщик -> System: Переход в управление бронированием
System -> Booking: getBookingStatus(bookingID)
Booking -> System: Статус бронирования
System -> Квартиросъёмщик: Отображение статуса бронирования

== Изменение или отмена бронирования ==
Квартиросъёмщик -> System: Изменение/отмена бронирования
System -> Booking: modifyBooking(bookingID, data)
Booking -> System: Подтверждение изменений
System -> Владелец: Уведомление об изменениях (notifyUsers)

== Подтверждение бронирования владельцем ==
Владелец -> System: Подтверждение бронирования
System -> Booking: confirmBooking(bookingID)
Booking -> System: Подтверждение
System -> Квартиросъёмщик: Уведомление о подтверждении (notifyUsers)

== Отклонение бронирования владельцем ==
Владелец -> System: Отклонение бронирования
System -> Booking: rejectBooking(bookingID, reason)
Booking -> System: Подтверждение
System -> Квартиросъёмщик: Уведомление об отказе (notifyUsers)

== Продление бронирования ==
Квартиросъёмщик -> System: Запрос продления
System -> Booking: extendBooking(bookingID, duration)
Booking -> System: Подтверждение продления
System -> Владелец: Уведомление о продлении (notifyUsers)

== Уведомление участников ==
System -> NotificationService: notifyUsers(bookingID, message)
NotificationService -> Квартиросъёмщик: Уведомление
NotificationService -> Владелец: Уведомление

@enduml