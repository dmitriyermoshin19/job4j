create table clients
(
    id   serial primary key,
    name varchar(100)
);
insert into clients (name)
values ('Витя');
insert into clients (name)
values ('Коля');

create table orders
(
    id        serial primary key,
    dt        date,
    client_id int references clients (id)
);
insert into orders (dt, client_id)
values ('2020-04-10', 1);
insert into orders (dt, client_id)
values ('2020-04-11', 2);
insert into orders (dt, client_id)
values ('2020-04-12', 1);
insert into orders (dt, client_id)
values ('2020-04-13', 2);

create table orderitem
(
    id       serial primary key,
    goodid   int,
    price    int,
    cnt      int,
    order_id int references orders (id)
);
insert into orderitem (goodid, price, cnt, order_id)
values ('1', 100, 3, 1),
       ('2', 200, 3, 2),
       ('1', 100, 3, 3),
       ('2', 200, 3, 4);


select c.name as имя, sum(i.price * i.cnt) as sum_price_x_cnt
from clients as c
         inner join orders as o ON c.id = o.client_id
         inner join orderitem as i ON o.id = i.order_id
group by c.name drob table clients;
drob
table orders;
drob
table orderitem;