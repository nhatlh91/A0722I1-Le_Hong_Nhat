create database student_management;
use purchasing_management;
create table student (
student_id int not null auto_increment primary key,
student_name varchar(30) not null,
student_age tinyint check (customer_age<100 and customer_age>10),
student_country varchar(50) not null
);
create table class (
class_id int not null auto_increment primary key,
class_name varchar(30) not null
);
create table teacher (
teacher_id int not null auto_increment primary key,
teacher_name varchar(30) not null,
teacher_age tinyint check (customer_age<100 and customer_age>10),
teacher_country varchar(50) not null
);