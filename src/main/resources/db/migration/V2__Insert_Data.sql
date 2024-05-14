-- Inserting Customers
INSERT INTO customer (name, email)
VALUES ('Alice Johnson', 'alice.johnson@example.com'),
       ('Bob Smith', 'bob.smith@example.com'),
       ('Charlie Brown', 'charlie.brown@example.com'),
       ('David Wilson', 'david.wilson@example.com'),
       ('Eva Davis', 'eva.davis@example.com'),
       ('Frank Moore', 'frank.moore@example.com'),
       ('Grace Taylor', 'grace.taylor@example.com'),
       ('Hank Anderson', 'hank.anderson@example.com'),
       ('Ivy Thompson', 'ivy.thompson@example.com'),
       ('Jack White', 'jack.white@example.com');

-- Inserting Products
INSERT INTO product (name, description, price, quantity)
VALUES ('Laptop', 'High-performance laptop', 999.99, 50),
       ('Smartphone', 'Latest model smartphone', 699.99, 100),
       ('Tablet', 'Lightweight tablet', 299.99, 75),
       ('Headphones', 'Noise-cancelling headphones', 199.99, 150),
       ('Smartwatch', 'Feature-rich smartwatch', 149.99, 200),
       ('Camera', 'Digital SLR camera', 499.99, 60),
       ('Printer', 'Wireless color printer', 89.99, 80),
       ('Monitor', '27-inch 4K monitor', 329.99, 40),
       ('Keyboard', 'Mechanical keyboard', 79.99, 120),
       ('Mouse', 'Ergonomic wireless mouse', 49.99, 140),
       ('Speaker', 'Bluetooth portable speaker', 59.99, 90),
       ('Router', 'High-speed Wi-Fi router', 129.99, 50),
       ('External Hard Drive', '1TB external hard drive', 59.99, 70),
       ('Webcam', 'HD webcam', 39.99, 130),
       ('Microphone', 'USB condenser microphone', 69.99, 110);

-- Inserting Orders and Order Items
INSERT INTO order_table (customer_id, order_date, total_amount)
VALUES (1, '2024-05-01', 1499.97),
       (2, '2024-05-02', 299.98),
       (3, '2024-05-03', 999.99),
       (4, '2024-05-04', 199.99);

INSERT INTO order_item (order_id, product_id, quantity, price)
VALUES (1, 1, 1, 999.99),
       (1, 2, 1, 699.99),
       (1, 4, 2, 199.99),
       (2, 3, 1, 299.99),
       (2, 6, 1, 199.99),
       (3, 1, 1, 999.99),
       (4, 4, 1, 199.99);

-- Inserting Sales and Sale Items
INSERT INTO sale (sale_date, total_amount)
VALUES ('2024-05-05', 1499.97),
       ('2024-05-06', 599.98);

INSERT INTO sale_item (sale_id, product_id, quantity, price)
VALUES (1, 1, 1, 999.99),
       (1, 4, 1, 199.99),
       (1, 5, 2, 149.99),
       (2, 2, 1, 699.99),
       (2, 3, 1, 299.99);

-- Inserting Wishlist Items
INSERT INTO wish_list (customer_id, product_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (2, 4),
       (3, 5),
       (3, 6),
       (4, 7),
       (4, 8),
       (5, 9),
       (5, 10),
       (6, 11),
       (6, 12),
       (7, 13),
       (7, 14),
       (8, 15);
