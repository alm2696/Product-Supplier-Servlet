-- create_products.sql

-- Create a table named 'products' to store product information
CREATE TABLE products (
    product_id INT PRIMARY KEY,                   -- Unique identifier for each product (Primary Key)
    product_name VARCHAR(50) NOT NULL,           -- Name of the product (mandatory field)
    category VARCHAR(50),                          -- Category to which the product belongs
    price DECIMAL(10, 2),                         -- Price of the product
    stock_quantity INT,                            -- Quantity of the product available in stock
    supplier_id INT,                              -- Identifier for the supplier (foreign key)
    -- Note: The supplier_id should reference the supplier_id in the suppliers table for referential integrity
);

-- Insert initial records into the 'products' table
INSERT INTO products (product_id, product_name, category, price, stock_quantity, supplier_id) VALUES
    (1, 'Laptop', 'Electronics', 999.99, 50, 1),         -- Product 1: Laptop supplied by supplier 1
    (2, 'Smartphone', 'Electronics', 499.99, 100, 1),    -- Product 2: Smartphone supplied by supplier 1
    (3, 'Tablet', 'Electronics', 299.99, 75, 2),         -- Product 3: Tablet supplied by supplier 2
    (4, 'Headphones', 'Audio', 89.99, 200, 3),           -- Product 4: Headphones supplied by supplier 3
    (5, 'Smartwatch', 'Wearables', 199.99, 150, 2);      -- Product 5: Smartwatch supplied by supplier 2
