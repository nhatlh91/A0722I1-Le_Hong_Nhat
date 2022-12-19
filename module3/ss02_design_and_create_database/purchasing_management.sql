create database purchasing_management;
use purchasing_management;
create table customer (
customer_id int not null auto_increment primary key,
customer_name varchar(30) not null,
customer_age tinyint check (customer_age<100 and customer_age>10)
);
create table `order` (
order_id int not null auto_increment primary key,
customer_id int,
order_date date not null,
ordet_total_amount int not null check (ordet_total_amount>0),
foreign key (customer_id) references customer (customer_id)
);
create table product (
product_id int not null auto_increment primary key,
product_name varchar(50) not null,
product_price tinyint not null check (product_price>0)
);
create table order_details (
product_id int not null,
order_id int not null,
order_qty int not null check (order_qty>0),
primary key (product_id, order_id),
foreign key (product_id) references product (product_id),
foreign key (order_id) references `order` (order_id)
);