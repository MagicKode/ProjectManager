CREATE TABLE IF NOT EXISTS retailer
(
    retailer_id   SERIAL PRIMARY KEY,
    name VARCHAR(128) NOT NULL UNIQUE

);

insert into "retailer" (name) values ('RET_A');
insert into "retailer" (name) values ('RET_B');
