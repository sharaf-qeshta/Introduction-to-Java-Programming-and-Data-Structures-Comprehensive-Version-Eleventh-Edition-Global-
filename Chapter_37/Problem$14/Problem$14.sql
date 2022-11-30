create table Poll
 (
 question varchar(40) primary key,
 yesCount int,
 noCount int
 );
 
 insert into Poll values ('Are you a CS major? ', 0, 0);