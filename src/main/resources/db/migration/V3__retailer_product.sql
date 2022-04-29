CREATE TABLE IF NOT EXISTS retailer_product
(
    id_retailer int NOT NULL,
    id_product  int NOT NULL,
    PRIMARY KEY (id_retailer, id_product),
    CONSTRAINT retailer_product_ibfk_1
        FOREIGN KEY (id_retailer) REFERENCES retailer (retailer_id),
    CONSTRAINT retailer_product_ibfk_2
        FOREIGN KEY (id_product) REFERENCES product (product_id)
)
