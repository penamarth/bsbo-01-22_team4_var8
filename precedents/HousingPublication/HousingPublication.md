
# Прецедент: "Публикация жилья"

**Информационная система жилищного агентства.**

**Уровень**: Задача, определённая пользователем.

**Основной исполнитель**: Владелец недвижимости.

---

## Заинтересованные лица и их требования:

- **Владелец недвижимости:**
  - Хочет публиковать информацию о своей недвижимости для потенциальных арендаторов.
  - Иметь возможность редактировать или удалять данные о недвижимости.

---

## Предусловия:

- Владелец зарегистрирован как объект `Owner` и аутентифицирован.
- Имеется доступ к функционалу через `PropertyManager`.

---

## Результаты (Постусловия):

1. Данные о недвижимости успешно обновлены или удалены.
2. Владелец уведомлен об успешном завершении операции.

---

## Основной успешный сценарий:

1. **Добавление новой недвижимости:**
    - Владелец инициирует добавление информации через интерфейс.
    - Система через `BookingSystemFacade` вызывает метод `PropertyManager.addProperty(newProperty)`.
    - `PropertyManager` сохраняет данные о недвижимости в базе.
    - После успешного добавления система уведомляет владельца через `Notification.notifyObservers(propertyAddedNotification)`.
    - Владелец получает подтверждение об успешном добавлении.

2. **Обновление информации о недвижимости:**
    - Владелец инициирует обновление информации через интерфейс.
    - Система через `BookingSystemFacade` вызывает метод `PropertyManager.updateProperty(propertyID, updatedProperty)`.
    - `PropertyManager` обновляет существующую запись о недвижимости в базе.
    - После успешного обновления система уведомляет владельца через `Notification.notifyObservers(propertyUpdatedNotification)`.
    - Владелец получает подтверждение об успешном обновлении.

3. **Удаление информации о недвижимости:**
    - Владелец инициирует удаление информации через интерфейс.
    - Система через `BookingSystemFacade` вызывает метод `PropertyManager.removeProperty(propertyID)`.
    - `PropertyManager` удаляет запись о недвижимости из базы.
    - Система уведомляет владельца через `Notification.notifyObservers(propertyRemovedNotification)`.
    - Владелец получает подтверждение об удалении.

---

## Варианты альтернативных решений:

1. **Некорректные данные при добавлении или обновлении:**
    - Если данные некорректны, система уведомляет владельца об ошибках через `Notification`.
    - Владелец исправляет данные и повторяет попытку.

2. **Удаление администратором:**
    - Если администратор удаляет данные, система уведомляет владельца через `Notification` о причинах удаления.

---

## Специальные требования:

- Информация о недвижимости должна включать адрес, описание, цену и фотографии.
- Уведомления отправляются на e-mail и в личный кабинет.
