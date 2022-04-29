CREATE TABLE IF NOT EXISTS product
(
    product_id  SERIAL PRIMARY KEY,
    title       VARCHAR(128) NOT NULL,
    description VARCHAR(128) NOT NULL,
    stock_level BIGINT       NOT NULL
);
/*UPDATE product
SET stock_level = stock_level + 5
WHERE is_called;

UPDATE product
SET stock_level = stock_level + 8
WHERE retailer_retailer_id_seq.is_called;
*/