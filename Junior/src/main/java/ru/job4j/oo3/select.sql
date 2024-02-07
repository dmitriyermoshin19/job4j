CREATE TABLE company
(
    id   integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id         integer NOT NULL,
    name       character varying,
    company_id integer,
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

INSERT INTO company (id, name)
VALUES (1, 'Microsoft'),
       (2, 'Facebook Inc.'),
       (3, 'Google LLC'),
       (4, 'IBM'),
       (5, 'SAP');

INSERT INTO person (id, name, company_id)
VALUES (1, 'Satya Nadella', 1),
       (2, 'Larry Page', 3),
       (3, 'Virginia Rometty', 4),
       (4, 'Elena Ibragimova', 1),
       (5, 'Mark Elliot Zuckerberg', 2),
       (6, 'Vladimir Mamuka', 1),
       (7, 'Pichai Sundararajan', 3),
       (8, 'Bill McDermott', 5),
       (9, 'Alexei Sokolov', 1),
       (10, 'Hans-Werner Hector', 5),
       (11, 'Sergey Brin', 3),
       (12, 'Kingston Marie', 2),
       (13, 'Claus Wellenreuther', 5);

-- 1) Retrieve in a single query:
-- - names of all persons that are NOT in the company with id = 5
-- - company name for each person
SELECT p.name, c.name
FROM person AS p
         JOIN company AS c
              ON p.company_id = c.id AND p.company_id != 5;

-- 2) Select the name of the company with the maximum number of persons + number of persons in this company
SELECT c.name, COUNT(p.name)
FROM person AS p
         JOIN company AS c
              ON p.company_id = c.id
GROUP BY c.name
ORDER BY COUNT(p.name) desc LIMIT 1;