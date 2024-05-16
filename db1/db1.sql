
create table customer(
cusId int primary key,
cusName varchar(30),
cusEmail varchar(30)

);
create table product(
proId int primary key,
proName varchar(30),
price int
);

create table orders(
orderId int primary key,
cusId int,
proId int,
quanity int,
orderDate  varchar(30),
foreign key (cusId) references customer(cusId),
foreign key (proId) references product(proId)
);

insert into customer (cusId, cusName, cusEmail)
values (1,"idiot","1@idiot.com"),
(4,"dumby","1@dumby.com"),
(2,"dumdum","1@dumdum.com"),
(3,"honk","1@peepeepee.com");
;
insert into product (proId, proName, price)
values (1,"apple",100000),
(4,"pear",1234),
(2,"pineapple",32),
(3,"pen",123123123);
;
insert into orders (orderId,cusId,proId, quanity, orderDate)
values (1,1,1,4,"december 33 2023"),
(4,4,4,5,"feb 30 2022"),
(2,2,2,56,"january 1 1"),
(3,3,3,999,"june 9, 6969");
;
