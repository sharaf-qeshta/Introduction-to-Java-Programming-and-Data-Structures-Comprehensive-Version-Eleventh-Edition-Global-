create table AGSStudent 
(
 username varchar(50) not null,
 password varchar(50) not null,
 fullname varchar(200) not null,
 instructorEmail varchar(100) not null,
 constraint pkAGSStudent primary key (username)
);

create table ExerciseAssigned
(
 instructorEmail varchar(100),
 exerciseName varchar(100),
 maxscore double default 10,
 constraint pkCustomExercise primary key
 (instructorEmail, exerciseName)
);

create table AGSLog
 (
 username varchar(50), /* This is the student's user name */
 exerciseName varchar(100), /* This is the exercise */
 score double default null,
 submitted bit default 0,
 constraint pkLog primary key (username, exerciseName)
);


-- add data
insert into AGSStudent (username, password, fullname, instructorEmail)
	values ('abc', 'p1', 'John Roo', 't@gmail.com');

insert into AGSStudent (username, password, fullname, instructorEmail)
	values ('cde', 'p2', 'Yao Mi', 'c@gmail.com'); 
    
insert into AGSStudent (username, password, fullname, instructorEmail)
	values ('wbc', 'p3', 'F3', 't@gmail.com'); 
    

insert into ExerciseAssigned (instructorEmail, exerciseName, maxscore)
	values ('t@gmail.com', 'e1', 10);

insert into ExerciseAssigned (instructorEmail, exerciseName, maxscore)
	values ('t@gmail.com', 'e2', 10);
    
insert into ExerciseAssigned (instructorEmail, exerciseName, maxscore)
	values ('c@gmail.com', 'e1', 4);
    
insert into ExerciseAssigned (instructorEmail, exerciseName, maxscore)
	values ('c@gmail.com', 'e4', 20);
    

insert into AGSLog (username, exerciseName, score, submitted)
	values ('abc', 'e1', 9, 1);

insert into AGSLog (username, exerciseName, score, submitted)
	values ('wbc', 'e2', 7, 1);
    
    