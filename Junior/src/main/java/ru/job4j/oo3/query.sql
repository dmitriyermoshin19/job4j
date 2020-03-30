CREATE DATABASE shop;

CREATE TABLE type(
    id SERIAL PRIMARY KEY,
    name VARCHAR(20)
);
CREATE TABLE product(
    id SERIAL PRIMARY KEY,
    name VARCHAR(20),
    expired_date DATE,
    price INT,
    type_id INT REFERENCES type(id)
);

INSERT INTO type (id, name) VALUES (1, 'СЫР');
INSERT INTO type (id, name) VALUES (2, 'МОЛОКО');
INSERT INTO type (id, name) VALUES (3, 'РАЗНОЕ');
INSERT INTO product (id, name, expired_date, price, type_id) VALUES (1, 'Сыр дешевый', '2020-04-10', 100, 1);
INSERT INTO product (id, name, expired_date, price, type_id) VALUES (2, 'Молоко эконом', '2020-04-10', 110, 2);
INSERT INTO product (id, name, expired_date, price, type_id) VALUES (3, 'Мороженое-стакан', '2020-05-05', 66, 3);
INSERT INTO product (id, name, expired_date, price, type_id) VALUES (4, 'Рыба', '2020-12-19', 85, 3);
INSERT INTO product (id, name, expired_date, price, type_id) VALUES (5, 'Мороженое пломбир', '2020-06-21', 251, 3);
INSERT INTO product (id, name, expired_date, price, type_id) VALUES (6, 'Сыр обычный', '2020-07-25', 21, 1);
INSERT INTO product (id, name, expired_date, price, type_id) VALUES (7, 'Сыр дорогой', '2020-06-06', 145, 1);
INSERT INTO product (id, name, expired_date, price, type_id) VALUES (8, 'Молоко не эконом', '2020-04-30', 46, 2);
INSERT INTO product (id, name, expired_date, price, type_id) VALUES (9, 'Молоко свежее', '2020-04-09', 125, 2);
INSERT INTO product (id, name, expired_date, price, type_id) VALUES (10, 'Сыр с плесенью', '2020-05-05', 79, 1);

--запрос получение всех продуктов с типом "СЫР"
SELECT * FROM product as p
INNER JOIN type as t on p.type_id = t.id AND t.name = 'СЫР';

--запрос получения всех продуктов, у кого в имени есть слово "мороженное"
SELECT * FROM product
WHERE name LIKE '%Мороженое%';

--запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT name, expired_date FROM product
WHERE expired_date BETWEEN  '2020-04-01' and '2020-04-30';

--запрос, который выводит самый дорогой продукт.
SELECT  price FROM product
WHERE  price=(SELECT MAX(price) FROM product)

--запрос, который выводит количество всех продуктов определенного типа.
SELECT t.name, COUNT(p.id) FROM product as p
INNER JOIN type as t on p.type_id = t.id
GROUP BY t.name;

--запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT * FROM product as p
INNER JOIN type as t on p.type_id = t.id WHERE t.name = 'СЫР' OR t.name = 'МОЛОКО';

--запрос, который выводит тип продуктов, которых осталось меньше 4 штук.
SELECT name FROM type
WHERE (SELECT COUNT(id)< 4 FROM product WHERE type_id = type.id);

--Вывести все продукты и их тип.
SELECT p.name, t.name FROM product as p
INNER JOIN type as t on p.type_id = t.id;