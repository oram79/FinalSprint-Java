-- User Table --
CREATE TABLE IF NOT EXISTS users(
 id SERIAL PRIMARY KEY,
 username VARCHAR(50) NOT NULL UNIQUE,
 password VARCHAR(225) NOT NULL,
 email VARCHAR(100) NOT NULL UNIQUE,
 role VARCHAR(10) NOT NULL
);
-- Products Table --
CREATE TABLE IF NOT EXISTS products (
 id SERIAL PRIMARY KEY,
 name VARCHAR(100) NOT NULL,
 price DECIMAL(10, 2) NOT NULL,
 quantity INT NOT NULL,
 seller_id INT NOT NULL REFERENCES users(id)
);

-- Authenticating A User --
SELECT * FROM users
WHERE username = 'Logan' AND password = 'password1';

-- Display All Active Products --
SELECT * FROM products;

-- List Products by a Seller --
SELECT * FROM products
WHERE seller_id = (SELECT id FROM users WHERE username = 'Declan');

-- Add A New Product --
INSERT INTO products (name, price, quantity, seller_id)
VALUES ('Gaming PC', 1450.00, 5, 4);

-- Updating Certain Products --
UPDATE products
SET price = 699.99, quantity = 12
WHERE id = 4 AND seller_id = (SELECT id FROM users WHERE username = 'Declan');

-- Delete A Product --
DELETE FROM products
WHERE id = 5 AND seller_id = (SELECT id FROM users WHERE username = 'John');

-- Viewing all Users (Admin) --
SELECT id, username, email, role FROM users;

-- Delete A User (Admin) --
DELETE FROM users
WHERE id = (SELECT id FROM users WHERE username = 'John');

-- Searching For A Product --
SELECT * FROM products
WHERE name ILIKE 'TV';

-- Listing Products With Sellers Info --
SELECT p.id, p.name, p.price, p.quantity, u.username AS seller_name, u.email AS seller_email
FROM products p
JOIN users u ON p.seller_id = u.id;



