-- add courses
insert into Course (courseId, subjectId, courseNumber, title,  numOfCredits)
	values('PROG1', 'CS01', 1, 'Intro to Java I', 4);

insert into Course (courseId, subjectId, courseNumber, title,  numOfCredits)
	values('PROG2', 'CS01', 1, 'Intro to Java II', 4);

insert into Course (courseId, subjectId, courseNumber, title,  numOfCredits)
	values('DATA', 'CS01', 2, 'Database System', 4);


-- add marks
insert into Enrollment (ssn, courseId, dateRegistered, grade)
	values('444111111', 'PROG1', '2022-10-29', 'D');

insert into Enrollment (ssn, courseId, dateRegistered, grade)
	values('444111111', 'PROG2', '2022-10-29', 'F');

insert into Enrollment (ssn, courseId, dateRegistered, grade)
	values('444111111', 'DATA', '2022-10-29', 'A');

insert into Enrollment (ssn, courseId, dateRegistered, grade)
	values('444111112', 'PROG1', '2022-10-29', 'A');

insert into Enrollment (ssn, courseId, dateRegistered, grade)
	values('444111112', 'DATA', '2022-10-29', 'A');