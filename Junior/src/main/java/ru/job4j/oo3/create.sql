CREATE
DATABASE tracker;

--Роли
create table roles
(
    Id   serial primary key,
    Name varchar(20)
);

--Права ролей
create table rules
(
    Id   serial primary key,
    Name varchar(20),
);

--roles - rules = many-to-many
create table roles_rules
(
    Id       serial primary key,
    roles_id int references roles (Id),
    rules_id int references rules (Id)
);

--Пользователи user - role = many-to-one
create table users
(
    Id       serial primary key,
    Name     varchar(10),
    roles_id int references roles (Id)
);

--Категория заявки
create table category
(
    Id   serial primary key,
    Name varchar(20)
);

--Состояние заявки
create table state
(
    Id    serial primary key,
    State boolean
);

--2 Создать SQL скрипт создающий таблицы для хранения структуры системы заявок.
--Заявки
--item - user = many-to-one
--item - comments = one-to-many
--item - attachs = one-to-many
--item - category = many-to-one
--item - state = many-to-one
create table items
(
    Id          serial primary key,
    Name        varchar(10),
    users_id    int references users (Id),
    category_id int references category (Id),
    state_id    int references state (Id)
);

--Приложенные файлы
create table attachs
(
    Id       serial primary key,
    Name     varchar(20),
    items_id int references items (Id)
);
--Комментарии заявок
create table comments
(
    Id       serial primary key,
    Name     varchar(20),
    items_id int references items (Id)
);

--3 Создать SQL скрипт заполняющий начальные данные для системы заявок.
insert into roles (id, Name)
VALUES (1, 'admin');
insert into roles (id, Name)
VALUES (2, 'user');

insert into rules (id, Name)
VALUES (1, 'editing');
insert into rules (id, Name)
VALUES (2, 'record');

insert into roles_rules (roles_id, rules_id)
VALUES (1, 1);
insert into roles_rules (roles_id, rules_id)
VALUES (1, 2);

insert into users (id, Name, roles_id)
VALUES (1, 'sergei', 1);
insert into users (id, Name, roles_id)
VALUES (2, 'vitaliy', 2);

insert into category (id, Name)
VALUES (1, 'important');
insert into category (id, Name)
VALUES (2, 'unimportant');

insert into state (id, State)
VALUES (1, true);
insert into state (id, State)
VALUES (2, false);

insert into items (id, Name, users_id, category_id, state_id)
VALUES (1, 'ItemOne', 1, 1, 1);
insert into items (id, Name, users_id, category_id, state_id)
VALUES (2, 'ItemTwo', 2, 1, 1);

insert into attachs (id, Name, items_id)
VALUES (1, 'Anything attach 1', 1);
insert into attachs (id, Name, items_id)
VALUES (2, 'Anything attach 2', 2);

insert into comments (id, Name, items_id)
VALUES (1, 'ItemOne sergei', 1);
insert into comments (id, Name, items_id)
VALUES (2, 'ItemOne sergei', 2);

