
create table customer(
cusId int primary key,
cusName varchar(30),
cusEmail varchar(30)

);
create table product(
productId int primary key,
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

