create database furama;
use furama;
drop table service;
drop table rent_type;
create table rent_type(
rent_type_id int primary key auto_increment,
rent_type_name varchar(45),
rent_type_cost double
);
drop table service_type;
create table service_type(
service_type_id int primary key auto_increment,
service_type_name varchar(45)
);
create table service(
service_id int primary key auto_increment,
service_name varchar(45),
service_area int,
service_cost double,
service_max_people int,
rent_type_id int,
service_type_id int,
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floors int,
foreign key (rent_type_id) references rent_type(rent_type_id),
foreign key (service_type_id) references service_type(service_type_id)
);

insert into service_type(service_type_name)
values("Villa"),("House"),("Room");

insert into rent_type(rent_type_name)
values("Year"),("Month"),("Day"),("Hour");

insert into service(service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors)
values ("Font Beach Villa",500,10000000,10,3,1,"VIP","Best view to the beach",50.0,4),
	("Princess House",400,7000000,5,2,2,"VIP","Decorated for night party",null,2);