-- create_suppliers.sql

-- Create a table named 'suppliers' to store supplier information
CREATE TABLE suppliers (
    supplier_id INT PRIMARY KEY,                -- Unique identifier for each supplier (Primary Key)
    supplier_name VARCHAR(50) NOT NULL,        -- Name of the supplier (mandatory field)
    contact_name VARCHAR(50),                   -- Name of the contact person at the supplier
    contact_email VARCHAR(50),                  -- Email address of the contact person
    phone_number VARCHAR(15)                    -- Phone number of the supplier
);

-- Insert initial records into the 'suppliers' table
INSERT INTO suppliers (supplier_id, supplier_name, contact_name, contact_email, phone_number) VALUES
    (1, 'Tech Supplies Co.', 'Alice Johnson', 'alice@techsupplies.com', '123-456-7890'),  -- Supplier 1
    (2, 'Gadgets Inc.', 'Bob Smith', 'bob@gadgets.com', '234-567-8901'),                  -- Supplier 2
    (3, 'Audio Masters', 'Charlie Brown', 'charlie@audiomasters.com', '345-678-9012');    -- Supplier 3
