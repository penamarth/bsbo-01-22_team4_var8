
# Описание Системных Операций

## 1. Операция: `submitReview(text: String, rating: Integer)`

**Ссылки:**  
Прецеденты: Оценка и отзывы

**Предусловия:**
- Пользователь (Квартиросъемщик или Владелец) аутентифицирован в системе.
- Пользователь завершил аренду жилья.

**Постусловия:**
- Система получает данные отзыва и оценки.
- Запускается процесс проверки завершения аренды.

**Действия:**
1. Пользователь отправляет текст и оценку для отзыва через интерфейс системы.
2. Система получает данные и инициализирует проверку завершения аренды.

---

## 2. Операция: `checkLeaseCompletion()`

**Ссылки:**  
Прецеденты: Оценка и отзывы

**Предусловия:**
- Пользователь отправил запрос на добавление отзыва и оценки.
- Доступ к базе данных активен.

**Постусловия:**
- Система получает информацию о статусе завершения аренды.

**Действия:**
1. Система отправляет запрос в базу данных для проверки статуса завершения аренды для конкретного пользователя.
2. База данных возвращает статус завершения аренды.

---

## 3. Операция: `saveReview(rating: Integer, text: String)`

**Ссылки:**  
Прецеденты: Оценка и отзывы

**Предусловия:**
- Система подтвердила, что аренда завершена.
- База данных доступна для записи.

**Постусловия:**
- Отзыв и оценка успешно сохранены в базе данных.

**Действия:**
1. Система сохраняет отзыв и оценку пользователя в базе данных.
2. База данных подтверждает успешное сохранение данных.

---

## 4. Операция: `sendForModeration(reviewId: Integer)`

**Ссылки:**  
Прецеденты: Оценка и отзывы

**Предусловия:**
- Отзыв и оценка успешно сохранены в базе данных.
- Администратор доступен для проверки.

**Постусловия:**
- Отзыв отправлен администратору для проверки и модерации.

**Действия:**
1. Система отправляет идентификатор отзыва администратору для проверки.
2. Администратор получает уведомление о необходимости модерации отзыва.

---

## 5. Операция: `approveOrRejectReview(reviewId: Integer, status: String)`

**Ссылки:**  
Прецеденты: Оценка и отзывы

**Предусловия:**
- Администратор получил запрос на модерацию отзыва.
- Администратор проверил содержание отзыва.

**Постусловия:**
- Отзыв либо одобрен, либо отклонен в зависимости от его содержания.

**Действия:**
1. Администратор подтверждает или отклоняет отзыв, устанавливая статус для идентификатора отзыва.
2. Система принимает статус и обновляет данные в базе данных.

---

## 6. Операция: `updateReviewStatus(reviewId: Integer, status: String)`

**Ссылки:**  
Прецеденты: Оценка и отзывы

**Предусловия:**
- Администратор установил статус отзыва (одобрен/отклонен).
- База данных доступна для обновления.

**Постусловия:**
- Статус отзыва в базе данных обновлен.

**Действия:**
1. Система обновляет статус отзыва в базе данных согласно решению администратора.
2. База данных подтверждает успешное обновление статуса.

---

## 7. Операция: `notifyReviewStatus(reviewId: Integer, status: String)`

**Ссылки:**  
Прецеденты: Оценка и отзывы

**Предусловия:**
- Отзыв прошел проверку и имеет финальный статус (одобрен или отклонен).

**Постусловия:**
- Пользователь уведомлен о статусе своего отзыва.

**Действия:**
1. Система отправляет уведомление пользователю с информацией об окончательном статусе отзыва.
2. Пользователь получает уведомление о том, был ли отзыв опубликован или отклонен.

---
