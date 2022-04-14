CREATE TABLE IF NOT EXISTS retailers
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(128) NOT NULL UNIQUE

);

insert into "retailers" (name) values ('RET_A');
insert into "retailers" (name) values ('RET_B');
