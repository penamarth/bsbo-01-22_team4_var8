
# Прецедент: "Оценка и отзывы"

**Информационная система жилищного агентства.**

**Уровень**: Задача, определенная пользователем.

**Основной исполнитель**: Квартиросъёмщик, Владелец недвижимости.

## Заинтересованные лица и их требования:

- **Квартиросъёмщик**: Хочет иметь возможность оставить отзыв и оценку после аренды жилья для того, чтобы поделиться своим опытом и помочь другим пользователям выбрать подходящее жилье.
- **Владелец недвижимости**: Хочет получить обратную связь о качестве своего сервиса и жилого помещения, чтобы улучшить свой сервис или обратить внимание на возможные проблемы.
- **Администратор системы**: Хочет убедиться, что отзывы соответствуют правилам системы, не содержат оскорблений или некорректной информации.
- **Компания (владелец платформы)**: Хочет обеспечить систему прозрачных и честных отзывов, которые помогут повысить доверие к платформе.

## Предусловия:

- Квартиросъёмщик или владелец недвижимости зарегистрированы и аутентифицированы в системе.
- Состоялся процесс аренды (заключён договор аренды, жилье было использовано).
- Квартиросъёмщик или владелец могут оставлять отзывы только после завершения аренды.

## Результаты (Постусловия):

- Квартиросъёмщик оставил отзыв и оценку о владельце или о жилье.
- Владелец оставил отзыв и оценку о квартиросъёмщике.
- Оценки и отзывы отображаются в профилях пользователей и в информации о жилье.
- Система уведомляет пользователей о новых отзывах.

## Основной успешный сценарий:

1. **Оставление отзыва**:
    - Квартиросъёмщик или владелец заходит в личный кабинет и выбирает опцию "Оставить отзыв".
    - Система отображает форму для ввода отзыва и оценки (например, текстовый комментарий и рейтинг по пятибалльной шкале).
    - Пользователь заполняет форму и отправляет её.
    - Система проверяет корректность введённых данных (проверка на ненормативную лексику, соответствие правилам).
  
2. **Публикация отзыва**:
    - После успешной проверки система сохраняет отзыв в базе данных и делает его видимым в профиле пользователя или в карточке недвижимости.
    - Оценка учитывается в общем рейтинге пользователя или объекта.

3. **Уведомление о новом отзыве**:
    - Система уведомляет владельца или квартиросъёмщика о новом отзыве через метод `notifyUser(user_id, message)`.

## Варианты альтернативных решений:

* **1.1 Пользователь оставляет некорректные данные (оскорбления или спам)**:
    1. Система обнаруживает недопустимые слова через метод `Review::checkContent()`.
    2. Пользователь получает уведомление с просьбой отредактировать отзыв.

* **2.1 Отзыв требует модерации**:
    1. Отзыв автоматически отправляется на модерацию, если система обнаружила потенциальные проблемы (например, жалобы на отзыв от других пользователей).
    2. Администратор системы проверяет отзыв и принимает решение о его публикации или отклонении.

* **3.1 Пользователь хочет изменить или удалить отзыв**:
    1. Квартиросъёмщик или владелец выбирает опцию "Редактировать" или "Удалить отзыв" в личном кабинете.
    2. Система вызывает методы `Review::update()` или `Review::delete()`, чтобы внести изменения или удалить отзыв.

## Расширения (или альтернативные потоки):

*а. **Возможность ответа на отзыв**:
1. Пользователь, получивший отзыв (владелец или квартиросъёмщик), может оставить ответ на отзыв через метод `Review::reply()`.

*б. **Анонимные отзывы**:
1. Пользователь может выбрать опцию "Оставить отзыв анонимно", и его имя не будет отображаться рядом с отзывом.
2. Система сохраняет анонимность, скрывая личные данные пользователя при просмотре отзыва другими.

## Специальные требования:

- Отзывы должны быть отображены как в веб-версии системы, так и в мобильном приложении.
- Система должна обеспечивать фильтрацию нецензурных выражений и оскорблений.
- Система должна поддерживать возможность жалоб на отзывы и их последующую проверку модераторами.
- Время на модерацию и публикацию отзыва не должно превышать 24 часов.

## Список технологий и типов данных:

- Данные отзывов хранятся в зашифрованной форме для обеспечения конфиденциальности (используются технологии шифрования SSL/TLS).

## Частота использования:

- Ожидается увеличение количества отзывов после завершения аренды или окончания периода использования жилья.

## Открытые вопросы:

- Нужно ли добавить возможность сортировки отзывов по дате или рейтингу?
- Следует ли добавить дополнительные параметры для оценки, такие как чистота, местоположение, соотношение цены и качества?
- Как лучше интегрировать отзывы в систему рекомендаций жилья для новых пользователей?
