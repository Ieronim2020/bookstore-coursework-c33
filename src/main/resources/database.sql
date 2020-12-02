-- Insert data

-- CREATE SEQUENCE SEQUENCE_USERS START WITH 3 INCREMENT BY 1;

INSERT INTO users VALUES (1, 'tms@email.com', '$2y$12$9qr5Fa.nazJQa5pMrFjPlOnKKaVfuMmldSB1JrAWJkyFja1EIH9nW', 'TMS');
INSERT INTO users VALUES (2, 'user@email.com', '$2y$12$LEUF4uh0MOgh16tSsKcQJuT7nNROKnkuuMGZpbLIquPlaMEqWfKyS', 'Sebastian Bach');

INSERT INTO user_roles VALUES (1, 'ADMIN');
INSERT INTO user_roles VALUES (2, 'USER');

INSERT INTO books VALUES (1, 'Java. Полное руководство', 199.70, 1488, 2018);
INSERT INTO authors VALUES (1, 'Шилдт', 'Герберт', 1);

INSERT INTO books VALUES (2, 'Философия Java', 70.10, 1168, 2019);
INSERT INTO authors VALUES (2, 'Брюс', 'Эккель', 2);

INSERT INTO books VALUES (3, 'Паттерны объектно-ориентированного проектирования', 31.90, 448, 2020);
INSERT INTO authors (id, first_name, last_name, book_id) VALUES (3, 'Эрих', 'Гамма', 3);
INSERT INTO authors (id, first_name, last_name, book_id) VALUES (4, 'Ричард', 'Хелм', 3);
INSERT INTO authors (id, first_name, last_name, book_id) VALUES (5, 'Ральф', 'Джонсон', 3);
