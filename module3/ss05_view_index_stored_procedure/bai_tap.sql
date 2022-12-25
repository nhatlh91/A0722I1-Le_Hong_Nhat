-- Tạo CSDL
create database demo;

-- Tạo bảng Product
drop table Products;
create table Products (
id tinyint primary key auto_increment,
productCode varchar(10) not null unique,
productName varchar(30) not null unique,
productPrice int not null check (productPrice >= 0),
productAmount int not null check (productAmount >= 0),
productDesciption varchar(50),
productStatus varchar(10) not null
);

-- Đưa dữ liệu mẫu vào bảng
insert into Products (productCode, productName, productPrice, productAmount, productDesciption, productStatus)
values ('Candy01','Double Mint',10000,20,'Hương vị truyền thống','Good'),
	   ('Candy02','Cool-Air',20000,30,'Cực the mát','Bad'),
	   ('Candy03','Playmore',32000,20,'Vị trái cây','Good'),
	   ('Biscuit01','Danisa',55000,25,'Hoàng gia Đan Mạch','Good'),	
	   ('Biscuit02','Oreo',20000,30,'Gấp đôi Socola','Bad'),
	   ('Biscuit03','Choco-pie',40000,25,'Kem dày hơn','Good');
       
-- Tạo Unique index cho cột ProductCode
ALTER TABLE Products ADD INDEX idx_productCode(productCode);

-- Tạo Composite index cho cột ProductName và ProductPrice
ALTER TABLE Products ADD INDEX idx_name_and_price(productName,productPrice);

-- Sử dụng câu lệnh Explain
explain select * from products where productCode = 'Biscuit01';

-- Tạo view
create view product_view as 
select productCode, productName, productPrice, productStatus
from products;

-- Dùng view
select * from product_view;

-- Sửa view
update product_view
set productPrice = 35000
where productCode = 'Candy03';

-- Xóa view
drop view product_view;

-- Tạo procedure lấy thông tin sản phẩm
DELIMITER //
CREATE PROCEDURE showAll()
BEGIN
  SELECT * FROM products;
END //
DELIMITER ;

-- Tạo procedure thêm sản phẩm mới
DELIMITER //
CREATE PROCEDURE addNewProduct(newCode varchar(10) , newName varchar(30) , newPrice int , newAmount int , newDescription varchar(50) , newStatus varchar(10))
BEGIN
  INSERT INTO Products(productCode, productName, productPrice, productAmount, productDesciption, productStatus)
  values (newCode, newName, newPrice, newAmount, newDesciption, newStatus);
END //
DELIMITER ;

-- Tạo procedure sửa sản phẩm theo ID
DELIMITER //
CREATE PROCEDURE editByID(id tinyint, newCode varchar(10) , newName varchar(30) , newPrice int , newAmount int , newDescription varchar(50) , newStatus varchar(10))
BEGIN
  UPDATE Product
  set productCode = newCode, productName = newName, productPrice = newPrice, productAmount = newAmount, productDesciption = newDescription, productStatus = newStatus
  where productID = id;
END //
DELIMITER ;

-- -- Tạo procedure xóa sản phẩm theo ID
DELIMITER //
CREATE PROCEDURE deleteByID(id tinyint)
BEGIN
  delete from Product
  where productID = id;
END //
DELIMITER ;
