CREATE TABLE IF NOT EXISTS retailers
(
    retailer_id   SERIAL PRIMARY KEY,
    retailer_name VARCHAR(128) NOT NULL UNIQUE

);

insert into "retailers" (retailer_name)
values ('RET_A');
insert into "retailers" (retailer_name)
values ('RET_B');
