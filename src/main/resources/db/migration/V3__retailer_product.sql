CREATE TABLE IF NOT EXISTS retailer_product
(
    retailer_id int NOT NULL,
    product_id  int NOT NULL,
    PRIMARY KEY (retailer_id, product_id)
        );
