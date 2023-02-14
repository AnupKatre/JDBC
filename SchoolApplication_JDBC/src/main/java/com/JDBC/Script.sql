create table student (
studentId varchar(6) primary key,
studentName varchar(15) not null,
studentAddress varchar(50) not null,
studentEmail varchar(50) not null,
);
INSERT INTO student VALUES('S1001', 'John’, ‘Bangalore’,’john@gmail.com’);
select * from student;



--===============================================================
--Creating Procedure
--===============================================================

DELIMITER &&
CREATE PROCEDURE getStudents ()
BEGIN
    SELECT * FROM StudentApplication.student  ;
END


DELIMITER &&
CREATE PROCEDURE addStudent (In id int, name varchar(255), address varchar(255), email varchar(255))
BEGIN
    INSERT INTO StudentApplication.student VALUES(id, name, address,email);
END

DELIMITER &&
CREATE PROCEDURE updateStudent (In findId int,id int, name varchar(255), address varchar(255), email varchar(255))
BEGIN
    Update StudentApplication.student set studentId = id,studentName=name,studentAddress = address,studentEmail = email where studentId = findId;
END


DELIMITER &&
CREATE PROCEDURE findStudent (In id int)
BEGIN
       Select * from StudentApplication.student where  studentId = id;
END

DELIMITER &&
CREATE PROCEDURE deleteStudent (In id int)
BEGIN
       Delete from StudentApplication.student where  studentId = id;
END
