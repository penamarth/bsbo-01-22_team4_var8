# Прецедент: "Оплата и заключение договора аренды"

**Информационная система жилищного агентства.**

## Уровень
Задача, определенная пользователем.

## Основной исполнитель
Квартиросъёмщик (Tenant).

## Заинтересованные лица и их требования

- **Квартиросъёмщик (Tenant).**
  - Хочет безопасно и удобно оплатить аренду выбранного жилья, получив подтверждение об успешной оплате и бронировании.

- **Владелец (Owner).**
  - Хочет получить уведомление о создании бронирования и подтверждении оплаты арендной платы.

- **Администратор системы (Administrator).**
  - Хочет убедиться, что все платежи и бронирования обрабатываются корректно и в соответствии с законодательством.

- **Компания (владелец платформы).**
  - Хочет получать комиссионные за успешные сделки и поддерживать безопасность и стабильность работы системы.

## Предусловия

- Квартиросъёмщик и владелец зарегистрированы и аутентифицированы в системе.
- Квартиросъёмщик выбрал жильё и создал бронирование.
- Обе стороны ознакомились с условиями аренды и готовы подтвердить бронирование.

## Результаты (Постусловия)

- Квартиросъёмщик успешно оплатил аренду и получил подтверждение о бронировании.
- Владелец получил уведомление о создании бронирования и подтверждении оплаты.
- Платёж успешно обработан и зафиксирован в системе.
- Система обновила данные о текущих бронированиях.
- Электронный договор аренды сформирован и готов к юридической регистрации.

## Основной успешный сценарий

1. **Создание бронирования:**
   - Квартиросъёмщик переходит на страницу подтверждения бронирования и нажимает "Подтвердить и оплатить".
   - Система вызывает метод `BookingSystemFacade.createBooking(booking)` для создания нового бронирования, где `booking` содержит `propertyID`, `tenantID`, даты бронирования и другие необходимые данные.

2. **Обработка бронирования:**
   - Метод `BookingSystemFacade.createBooking(booking)` вызывает `BookingManager.createBooking(booking)` для обработки бронирования и платежа.
   - `BookingManager.createBooking(booking)` обрабатывает платёж и создаёт запись бронирования с уникальным `UUID`.

3. **Генерация договора аренды:**
   - После успешного создания бронирования система вызывает метод `Booking.formRentalAgreement()` для формирования договора аренды.
   - `Booking.formRentalAgreement()` создаёт объект `Agreement` (предполагается, что класс `Agreement` реализован внутри `Booking`).

4. **Уведомление участников:**
   - Система вызывает метод `PropertyManager.getPropertyByID(propertyID)` для получения информации о свойстве.
   - Затем система создает объект `Notification` с информацией о новом бронировании.
   - Система вызывает метод `Property.notifyObservers(notification)`, чтобы уведомить владельца о создании бронирования.
   - Владелец, как подписчик на уведомления от объекта `Property`, получает уведомление через метод `User.update(notification)`.

5. **Подтверждение бронирования:**
   - Квартиросъёмщик получает подтверждение о успешном создании бронирования и получении договора аренды.

## Варианты альтернативных сценариев

### *1.1 Платёж не прошёл успешно*

1. **Система** обнаруживает ошибку при обработке платежа.
2. **Система** сообщает квартиросъёмщику об ошибке оплаты и предлагает попробовать снова позже или использовать другой способ оплаты.

### *2.1 Бронирование уже существует*

1. **Система** обнаруживает, что бронирование для данного `propertyID` и `tenantID` уже существует.
2. **Система** сообщает квартиросъёмщику о существующем бронировании и предлагает просмотреть его детали или отменить.

### *3.1 Отмена бронирования*

1. **Квартиросъёмщик** решает отменить бронирование.
2. **Система** вызывает метод `BookingSystemFacade.cancelBooking(bookingID)` для отмены бронирования.
3. **Система** подтверждает успешную отмену бронирования и уведомляет владельца о данном действии через механизм **Observer**.

## Специальные требования

- Процесс оплаты должен быть интуитивно понятным для всех пользователей.
- Система должна обеспечивать безопасность платежных и персональных данных (SSL/TLS).
- Время обработки платежа и создания бронирования не должно превышать 5 минут.
- Платформа должна поддерживать различные платёжные методы (банковские карты, электронные кошельки и т.д.).

## Список технологий и типов данных

- Платёжные данные защищены с использованием SSL/TLS.
- Все операции взаимодействия с пользователями и уведомлениями реализуются через методы фасада и паттерн **Observer**.

## Частота использования

- Ожидается средняя частота использования, особенно во время активных периодов бронирования жилья.

## Открытые вопросы

- Нужно ли добавлять возможность заморозки оплаты до полного подтверждения бронирования?
- Какие способы оплаты наиболее предпочтительны для российских пользователей?
- Как решать вопросы с возвратом средств в случае отмены бронирования?
