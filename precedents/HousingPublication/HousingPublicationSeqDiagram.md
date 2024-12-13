
```plantuml
@startuml

actor "Владелец недвижимости" as Owner
participant "BookingSystemFacade" as Facade
participant "PropertyManager" as Manager

== Сценарий: Добавление новой недвижимости ==

Owner -> Facade : addProperty(newProperty)
activate Facade
Facade -> Manager : addProperty(newProperty)
activate Manager
Manager --> Facade : Property added confirmation
Facade --> Owner : Property added confirmation

deactivate Manager
deactivate Facade

== Сценарий: Добавление или обновление информации о недвижимости ==

Owner -> Facade : updateProperty(propertyID, updatedProperty)
activate Facade
Facade -> Manager : updateProperty(propertyID, updatedProperty)
activate Manager
Manager --> Facade : Property updated confirmation
Facade --> Owner : Property updated confirmation

deactivate Manager
deactivate Facade

== Сценарий: Удаление информации о недвижимости ==

Owner -> Facade : removeProperty(propertyID)
activate Facade
Facade -> Manager : removeProperty(propertyID)
activate Manager
Manager --> Facade : Property removed confirmation
Facade --> Owner : Property removed confirmation

deactivate Manager
deactivate Facade

@enduml
```
