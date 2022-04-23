CREATE TABLE IF NOT EXISTS product
(
    product_id          SERIAL PRIMARY KEY,
    product_title       VARCHAR(128) NOT NULL,
    product_description VARCHAR(128) NOT NULL,
    product_stockLevel  varchar(128) NOT NULL
);


