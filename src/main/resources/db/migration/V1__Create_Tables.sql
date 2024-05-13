-- Create Customer table
CREATE TABLE customer
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(100)        NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

-- Create Product table
CREATE TABLE product
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100)   NOT NULL,
    description TEXT,
    price       DECIMAL(10, 2) NOT NULL,
    quantity    INT            NOT NULL
);

-- Create Order table
CREATE TABLE order_table
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    customer_id  INT            NOT NULL,
    order_date   DATE           NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL
);

-- Create OrderItem table
CREATE TABLE order_item
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    order_id   INT            NOT NULL,
    product_id INT            NOT NULL,
    quantity   INT            NOT NULL,
    price      DECIMAL(10, 2) NOT NULL
);

-- Create Sale table
CREATE TABLE sale
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    sale_date    DATE           NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL
);

-- Create SaleItem table
CREATE TABLE sale_item
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    sale_id    INT            NOT NULL,
    product_id INT            NOT NULL,
    quantity   INT            NOT NULL,
    price      DECIMAL(10, 2) NOT NULL
);

-- Create Wishlist table
CREATE TABLE wish_list
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    product_id  INT NOT NULL
);
