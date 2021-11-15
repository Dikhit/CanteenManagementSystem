show databases;

create database canteenManagementSystem;
use canteenManagementSystem;

--Creating user table
create table users(
	id varchar(50) primary key,
    name varchar(50) not null,
    email varchar(50) unique not null,
    walletPrice int not null,
    password varchar(50) not null,
    role varchar(50) not null,
    createdAt datetime default CURRENT_TIMESTAMP
);

--Creating Product Table
create table products(
	id varchar(50) primary key,
    name varchar(50) not null,
    price int not null,
    description varchar(1000),
    vendorID varchar(50) references users(id),
    createdAt datetime default CURRENT_TIMESTAMP
);

--Creating Order Table

create table orders(
	id varchar(50) primary key,
    buyer varchar(50) references users(id),
    product varchar(50) references products(id),
    quantity int not null,
    orderedAt datetime default CURRENT_TIMESTAMP
);