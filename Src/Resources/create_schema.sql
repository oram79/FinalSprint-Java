-- User Table --
CREATE TABLE IF NOT EXISTS Users(
 id SERIAL PRIMARY KEY,
 username VARCHAR(50) NOT NULL UNIQUE,
 password VARCHAR(225) NOT NULL,
 email VARCHAR(100) NOT NULL UNIQUE,
 role VARCHAR(10) NOT NULL
);
-- Products Table --
CREATE TABLE Products (
 id SERIAL PRIMARY KEY,
 name VARCHAR(100) NOT NULL,
 price DECIMAL(10, 2) NOT NULL,
 quantity INT NOT NULL,
 seller_id INT NOT NULL REFERENCES Users(id)
);

-- Authenticating A User --
SELECT * FROM users
WHERE username = 'Logan' AND password = 'password1';

-- Display All Active Products --
SELECT * FROM products;