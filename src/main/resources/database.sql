-- Insert data

INSERT INTO users VALUES (1, 'tms@email.com', 'TMS', 'Admin', '$2y$12$9qr5Fa.nazJQa5pMrFjPlOnKKaVfuMmldSB1JrAWJkyFja1EIH9nW', 'ADMIN', 'ACTIVE');
INSERT INTO users VALUES (2, 'user@email.com', 'Sebastian', 'Bach', '$2y$12$SEFT3FjxBjrVj5esIhpBjukvnxVAAud6C/awWNAkPrOHsTr10t0Qy', 'USER', 'ACTIVE');

INSERT INTO books VALUES (1, 'Java. Полное руководство', 199.70, 1488, 2018);
INSERT INTO authors VALUES (1, 'Шилдт', 'Герберт', 1);

INSERT INTO books VALUES (2, 'Философия Java', 70.10, 1168, 2019);
INSERT INTO authors VALUES (2, 'Брюс', 'Эккель', 2);

INSERT INTO books VALUES (3, 'Паттерны объектно-ориентированного проектирования', 31.90, 448, 2020);
INSERT INTO authors (id, first_name, last_name, book_id) VALUES (3, 'Эрих', 'Гамма', 3);
INSERT INTO authors (id, first_name, last_name, book_id) VALUES (4, 'Ричард', 'Хелм', 3);
INSERT INTO authors (id, first_name, last_name, book_id) VALUES (5, 'Ральф', 'Джонсон', 3);
