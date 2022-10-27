create table Course
(
 courseId char(5),
 subjectId char(4) not null,
 courseNumber integer,
 title varchar(50) not null,
 numOfCredits integer,
 primary key (courseId)
);

create table Student
(
 ssn char(9),
 firstName varchar(25),
 mi char(1),
 lastName varchar(25),
 birthDate date,
 street varchar(25),
 phone char(11),
 zipCode char(5),
 deptId char(4),
 primary key (ssn)
);


create table Enrollment
(
 ssn char(9),
 courseId char(5),
 dateRegistered date,
 grade char(1),
 primary key (ssn, courseId),
 foreign key (ssn) references
 Student(ssn),
 foreign key (courseId) references
 Course(courseId)
);



-- add data

insert into Student (ssn, firstName, mi, lastName, birthDate, street, phone, zipCode, deptId)
	values('444111111', 'Sharaf', 'M', 'Qeshta', '2001-06-13', 'Kirby Drive', '123456789', '77001', 'Math');

insert into Student (ssn, firstName, mi, lastName, birthDate, street, phone, zipCode, deptId)
	values('444111112', 'Eliott', 'M', 'Harve', '2000-09-13', 'Sabine Street', '123456789', '77005', 'Math');

insert into Student (ssn, firstName, mi, lastName, birthDate, street, phone, zipCode, deptId)
	values('444111113', 'Annmarie', 'F', 'Lindy', '1998-05-19', 'Main Street', '123456789', '77005', 'CS');

insert into Student (ssn, firstName, mi, lastName, birthDate, street, phone, zipCode, deptId)
	values('444111114', 'Muna', 'F', 'Fakhri', '2002-05-01', '19th Street', '123456789', '77006', 'CS');

insert into Student (ssn, firstName, mi, lastName, birthDate, street, phone, zipCode, deptId)
	values('444111115', 'Andrina', 'F', 'Waldo', '2001-03-01', 'Washington Avenue', '123456789', '77006', 'CHEM');

insert into Student (ssn, firstName, mi, lastName, birthDate, street, phone, zipCode, deptId)
	values('444111116', 'Lawrie', 'M', 'Montgomery', '2000-08-06', 'Washington Avenue', '123456789', '77006', 'CHEM');

insert into Student (ssn, firstName, mi, lastName, birthDate, street, phone, zipCode, deptId)
	values('444111117', 'Branda', 'F', 'Harve', '2000-09-06', 'Broadway Street', '123456789', '77006', 'BIOL');

insert into Student (ssn, firstName, mi, lastName, birthDate, street, phone, zipCode, deptId)
	values('444111118', 'Arline', 'M', 'Wat', '2003-12-06', 'Kirby Drive', '123456789', '77006', 'BIOL');

insert into Student (ssn, firstName, mi, lastName, birthDate, street, phone, zipCode, deptId)
	values('444111119', 'Hayes', 'M', 'Stirling', '2001-04-12', 'St Emanuel Street', '123456789', '77006', 'BIOL');

insert into Student (ssn, firstName, mi, lastName, birthDate, street, phone, zipCode, deptId)
	values('444111120', 'Avis', 'M', 'Jason', '2000-02-12', 'St Emanuel Street', '123456789', '77006', 'BIOL');

