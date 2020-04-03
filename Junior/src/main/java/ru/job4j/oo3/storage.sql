CREATE DATABASE storage;

create table car_body (
    id serial primary key,
    name varchar(20)
);

insert into car_body (name) values
    ('Грузовая'),
    ('Седан'),
    ('Хэтчбек'),
    ('Пикап'),
    ('Универсал');

create table engine (
    id serial primary key,
    name varchar(20)
);

insert into engine (name) values
    ('Бензиновый'),
    ('Дизельный'),
    ('Водный')
    ('Газовый');

create table transmission (
    id serial primary key,
    name varchar(20)
);

insert into transmission (name) values
    ('Механическая'),
    ('Робот'),
    ('Автомат'),
    ('Полуавтомат'),
    ('Вариатор');

create table car (
    id serial primary key,
    name varchar(20),
    car_body_id int references car_body(id),
    engine_id int references engine(id),
    transmission_id int references transmission(id)
);

insert into car (name, car_body_id, engine_id, transmission_id) values
    ('Газель', 1, 2, 1),
    ('Лада Веста', 2, 2, 3),
    ('Toyota Yaris', 3, 3, 4),
    ('Wollksvagen Polo', 2, 3, 2),
    ('Лада Гранта', 4, 2, 1),
    ('Shkoda Oktavia', 4, 1, 2);

--1. Вывести список всех машин и все привязанные к ним детали.
SELECT g.name, c.name, e.name, t.name
FROM car AS g
INNER JOIN car_body AS c ON c.id = g.car_body_id
INNER JOIN engine AS e ON e.id = g.engine_id
INNER JOIN transmission AS t ON t.id = g.transmission_id

--2. Вывести отдельно детали, которые не используются в машине:
--кузова, двигатели, коробки передач.

--не использованные кузова
SELECT c.name
FROM car_body AS c
LEFT JOIN car AS g ON c.id = g.car_body_id
WHERE g.id IS null

--не использованные типы двигателя
SELECT e.name
FROM engine AS e
LEFT JOIN car AS c ON e.id = c.engine_id
WHERE c.id IS null

--не использованные коробки передач
SELECT t.name
FROM transmission AS t
LEFT JOIN car AS c ON t.id = c.transmission_id
WHERE c.id IS null

