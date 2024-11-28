```plantuml
@startuml

actor "Пользователь" as User
actor "Администратор" as Admin

participant "BookingSystem" as System
participant "UserManager" as UserManager
participant "Payment" as Payment
participant "NotificationModule" as Notifier

== Основной успешный сценарий ==

User -> System : Open account settings
activate System

System -> UserManager : getUserByID(userID)
activate UserManager
UserManager --> System : Account data
deactivate UserManager

System --> User : Display account data

User -> System : Change contact information
System -> UserManager : validateData(data)
alt Data is valid
    System -> UserManager : addUser(userID, data)
    activate UserManager
    UserManager --> System : Save confirmation
    deactivate UserManager

    System -> Notifier : notifyObservers(notification)
    activate Notifier
    Notifier --> User : Notification of data change
    deactivate Notifier
else Data is invalid
    System --> User : Message about data errors
end

User -> System : Change payment information
System -> Payment : updateDetails(paymentInfo)
activate Payment
Payment --> System : Update confirmation
deactivate Payment

System -> Notifier : notifyObservers(notification)
activate Notifier
Notifier --> User : Notification of payment information change
deactivate Notifier

User -> System : Delete account
System -> UserManager : getUserByID(userID)
activate UserManager
UserManager --> System : Deletion confirmation
deactivate UserManager

alt Confirmed
    System -> UserManager : deleteUser(userID)
    activate UserManager
    UserManager --> System : Account deleted
    deactivate UserManager

    System -> Notifier : notifyObservers(notification)
    activate Notifier
    Notifier --> User : Account deletion notification
    deactivate Notifier
else Not confirmed
    System --> User : Account deletion cancelled
end

== Альтернативный поток: *2.1 Пользователь вводит некорректные данные ==

User -> System : Enter data with errors
System -> UserManager : validateData(data)
alt Validation error
    System --> User : Message about data errors
end

== Альтернативный поток: *3.1 Пользователь запрашивает удаление платежных данных без замены ==

User -> System : Delete payment information
System -> Payment : requireUpdate()
activate Payment
Payment --> System : Notification of required new data
deactivate Payment

System --> User : Message about needing to provide new payment information

== Альтернативный поток: *4.1 Пользователь пытается восстановить удаленный аккаунт ==

User -> System : Log in after account deletion
System -> UserManager : getUserByID(userID)
activate UserManager
UserManager --> System : Account deleted message
deactivate UserManager

System --> User : Notification of inability to restore account

== Альтернативный поток: *5.1 Ошибка при сохранении данных ==

User -> System : Change personal data
System -> UserManager : addUser(userID, data)
activate UserManager
alt Data saving error
    UserManager --> System : Error while saving data
    deactivate UserManager

    System -> Notifier : notifyObservers(errorNotification)
    activate Notifier
    Notifier --> User : Error notification with recommendation
    deactivate Notifier
else Data saved successfully
    UserManager --> System : Save confirmation
    deactivate UserManager
end

== Расширение: *a. Периодическая проверка неактивности аккаунта ==

System -> Admin : checkInactivity()
activate Admin
Admin --> System : Report on inactive accounts
deactivate Admin

System -> Notifier : notifyObservers(inactivityNotification)
activate Notifier
Notifier --> User : Notification of prolonged inactivity
deactivate Notifier

== Расширение: *b. Восстановление доступа после сбоя системы ==

User -> System : Report system failure
System -> Admin : restart()
activate Admin
Admin --> System : System restored
deactivate Admin

System --> User : Return to last action

@enduml
```