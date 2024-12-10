-- Insert Users
INSERT INTO Users (username, password, email, role)
VALUES
('Logan', 'password1', 'logan@gmail.com', 'admin'),
('Declan', 'password2', 'declan@gmail.com', 'seller'),
('Nick', 'password3', 'nick@gmail.com', 'buyer');

-- Insert Products
INSERT INTO Products (name, price, quantity, seller_id)
VALUES
('Product 1', 100.00, 10, 2),
('Product 2', 50.00, 5, 2),
('Product 3', 75.00, 20, 2);
