create table Student1
 (
 username varchar(50) not null,
 password varchar(50) not null,
 fullname varchar(200) not null,
 constraint pkStudent primary key (username)
);

create table Student2 
(
 username varchar(50) not null,
 password varchar(50) not null,
 firstname varchar(100),
 lastname varchar(100),
 constraint pkStudent primary key (username)
);