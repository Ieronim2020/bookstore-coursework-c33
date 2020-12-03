-- Insert data

-- CREATE SEQUENCE SEQUENCE_USERS START WITH 3 INCREMENT BY 1;

INSERT INTO users VALUES (1, 'tms@email.com', '$2y$12$9qr5Fa.nazJQa5pMrFjPlOnKKaVfuMmldSB1JrAWJkyFja1EIH9nW', 'TMS');
INSERT INTO users VALUES (2, 'user@email.com', '$2y$12$LEUF4uh0MOgh16tSsKcQJuT7nNROKnkuuMGZpbLIquPlaMEqWfKyS', 'Sebastian Bach');

INSERT INTO user_roles VALUES (1, 'ADMIN');
INSERT INTO user_roles VALUES (2, 'USER');

INSERT INTO books VALUES (1, 'Java. Полное руководство', 199.70, 1488, 2018);
INSERT INTO authors VALUES (1, 'Шилдт', 'Герберт', 1);

INSERT INTO books VALUES (2, 'Философия Java', 74.21, 1168, 2021);
INSERT INTO authors VALUES (2, 'Брюс', 'Эккель', 2);

INSERT INTO books VALUES (3, 'Паттерны объектно-ориентированного проектирования', 31.90, 448, 2020);
INSERT INTO authors (id, first_name, last_name, book_id) VALUES (3, 'Эрих', 'Гамма', 3);

INSERT INTO books VALUES (4, 'Чистый код. Создание, анализ и рефакторинг', 28.83, 464, 2019);
INSERT INTO authors (id, first_name, last_name, book_id) VALUES (4, 'Роберт', 'Мартин', 4);

INSERT INTO books VALUES (5, 'Легкий способ выучить Java', 29.60, 400, 2020);
INSERT INTO authors (id, first_name, last_name, book_id) VALUES (5, 'Пейн', 'Брайсон', 5);

INSERT INTO books VALUES (6, 'Java за 24 часа. Руководство', 41.71, 480, 2019);
INSERT INTO authors (id, first_name, last_name, book_id) VALUES (6, 'Роджерс', 'Кейденхед', 6);

INSERT INTO books VALUES (7, 'Программирование на Java для начинающих', 30.24, 480, 2017);
INSERT INTO authors (id, first_name, last_name, book_id) VALUES (7, 'Алексей', 'Васильев', 7);

INSERT INTO books VALUES (8, 'Основы Java', 55.67, 768, 2019);
INSERT INTO authors (id, first_name, last_name, book_id) VALUES (8, 'Николай', 'Прохоренок', 8);

INSERT INTO books VALUES (9, 'Spring Boot 2. Лучшие практики для профессионалов', 87.56, 464, 2020);
INSERT INTO authors (id, first_name, last_name, book_id) VALUES (9, 'Фелипе', 'Гутьеррес', 9);

INSERT INTO books VALUES (10, 'Java. Эффективное программирование', 29.85, 294, 2013);
INSERT INTO authors (id, first_name, last_name, book_id) VALUES (10, 'Джошуа', 'Блох', 10);