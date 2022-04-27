CREATE TABLE IF NOT EXISTS product
(
    product_id          SERIAL PRIMARY KEY,
    title       VARCHAR(128) NOT NULL,
    description VARCHAR(128) NOT NULL,
    stockLevel  INTEGER NOT NULL
);


