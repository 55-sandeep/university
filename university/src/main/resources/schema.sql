create table student(
    id int primary key AUTO_INCREMENT,
    name varchar(255),
    email varchar(255)
);

create table course(
    id int primary key AUTO_INCREMENT,
    name varchar(255),
    credits varchar(255),
    profId int
);

create table professor(
    id int primary key AUTO_INCREMENT,
    name varchar(255),
    department varchar(255)
);