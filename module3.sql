CREATE DATABASE module3; 
USE module3; 

CREATE TABLE Category (
    CategoryID INT PRIMARY KEY AUTO_INCREMENT,
    CategoryName NVARCHAR(255) NOT NULL
);

CREATE TABLE Product (
    ProductID INT PRIMARY KEY AUTO_INCREMENT,
    ProductName NVARCHAR(255) NOT NULL,
    Price DECIMAL(18,2) NOT NULL, -- Không dùng CHECK
    Quantity INT CHECK (Quantity > 0) NOT NULL,
    Color NVARCHAR(50) CHECK (Color IN ('Đỏ', 'Xanh', 'Đen', 'Trắng', 'Vàng')) NOT NULL,
    Description NVARCHAR(255),
    CategoryID INT NOT NULL,
    FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID)
);

-- Chèn dữ liệu vào bảng Category
INSERT INTO Category (CategoryName) VALUES 
('Điện thoại'),
('Máy tính bảng'),
('Phụ kiện');

-- Chèn dữ liệu vào bảng Product
INSERT INTO Product (ProductName, Price, Quantity, Color, Description, CategoryID) VALUES 
('iPhone 15 Pro Max', 29990000, 10, 'Đen', 'Điện thoại cao cấp của Apple', 1),
('Samsung Galaxy S23 Ultra', 24990000, 15, 'Xanh', 'Điện thoại flagship của Samsung', 1),
('iPad Pro M2', 31990000, 8, 'Trắng', 'Máy tính bảng cao cấp của Apple', 2),
('Samsung Galaxy Tab S9', 22990000, 12, 'Vàng', 'Máy tính bảng mạnh mẽ của Samsung', 2),
('Tai nghe AirPods Pro', 5990000, 25, 'Trắng', 'Tai nghe không dây chống ồn của Apple', 3),
('Sạc nhanh 65W', 1290000, 50, 'Đen', 'Củ sạc nhanh công suất cao', 3);
