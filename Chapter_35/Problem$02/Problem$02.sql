create table Address 
(
 firstname varchar(25),
 mi char(1),
 lastname varchar(25),
 street varchar(40),
 city varchar(20),
 state varchar(2),
 zip varchar(5),
 telephone varchar(10),
 email varchar(30),
 primary key (firstname, mi, lastname)
);
