drop table `employee`;
create table `employee`(
employee_id int primary key auto_increment,
employee_name varchar(45),
employee_birthday date,
employee_id_card varchar(45),
employee_salary double,
employee_phone varchar(45),
employee_email varchar(45),
employee_address varchar(45),
position_id int,
education_degree_id int,
division_id int,
username varchar(255),
foreign key(position_id) references `position`(position_id),
foreign key(education_degree_id) references education_degree(education_degree_id),
foreign key(division_id) references division(division_id),
foreign key(username) references user(username)
);

insert into 
`employee`(employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username)
values ("Nhat","1991-08-16","049091018446",20000000,"0905598909","nhatlg@gmail.com","Da Nang",1,1,1,"nhatlh"),
		("Nhan","2001-12-04","049091017546",15000000,"0905509905","nhantq@gmail.com","Da Nang",2,1,1,"nhantq");
        
insert into
education_degree(education_degree_id, education_degree_name)
values (1,"Trung cấp"),
		(2,"Cao đẳng"),
		(3,"Đại học"),
		(4,"Sau đại học");

insert into
`position`(position_id,position_name)
value (1,"Lễ tân"),
		(2,"Phục vụ"),
		(3,"Chuyên viên"),
		(4,"Giám sát"),
		(5,"Quản lý"),
		(6,"Giám đốc");
        
insert into
division(division_id, division_name)
value (1,"Sale-Marketing"),
(2,"Hành chính"),
(3,"Phục vụ"),
(4,"Quản lý");

insert into
`user`(`username`,`password`)
value ("nhatlh","abcd1234"),
("nhantq","123456");