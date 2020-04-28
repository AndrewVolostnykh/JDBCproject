use STUDENT_INFO;

/*UNION Example*/
(SELECT StudentId FROM PHONE_LIST WHERE PhoneType = 'дом')
UNION /*There is disctinct operation, for all using all*/
(SELECT StudentId FROM PHONE_LIST WHERE PhoneType = 'моб')
ORDER BY StudentId;

/*Included requests*/
SELECT StudentId, StudentName
FROM STUDENT
WHERE StudentId IN (SELECT DISTINCT StudentId FROM EXAM_RESULT WHERE Mark = 2);

SELECT * FROM TEACHER WHERE EXISTS (SELECT * FROM EXAM_SHEET WHERE EXAM_SHEET.CourseId = (
SELECT COURSE.CourseId FROM COURSE WHERE COURSE.CourseTitle = "Базы данных")
AND TEACHER.TeacherId = EXAM_SHEET.TeacherId);

SELECT * FROM STUDENT 
WHERE 5 = ALL(SELECT Mark FROM EXAM_RESULT
WHERE EXAM_RESULT.StudentId = STUDENT.StudentId); /* Foud all excelent students */

SELECT StudentName FROM STUDENT
WHERE StudentId IN (SELECT StudentId
					FROM PHONE_LIST
					GROUP BY StudentId HAVING COUNT(*) > 1);
					
SELECT StudentName,
		(SELECT AVG(Mark) FROM EXAM_RESULT
		WHERE EXAM_RESULT.StudentId = STUDENT.StudentId) AVG_MARK
FROM STUDENT;

SELECT GroupNumber, AVG(MARK) AVG_MARK
FROM 
(SELECT StudentID, Mark, (SELECT GroupNumber FROM STUDENT WHERE StudentId = EXAM_RESULT.StudentId)
GroupNumber FROM EXAM_RESULT) TEMP GROUP BY GroupNumber;

/*Joining tables*/
SELECT CourseTitle, TeacherName, GroupNumber, ExamDate
FROM COURSE, EXAM_SHEET, TEACHER
WHERE COURSE.CourseId = EXAM_SHEET.CourseId AND TEACHER.TeacherId = EXAM_SHEET.TeacherId;

SELECT StudentName, Phone
FROM STUDENT LEFT OUTER JOIN PHONE_LIST
ON STUDENT.StudentId = PHONE_LIST.StudentId;

/*Aggregating*/
SELECT GroupNumber AS "GROUP NUMBER" COUNT(*) AS "NUMBER OF STUDENTS IN GROUP" FROM STUDENT GROUP BY GroupNumber;

SELECT COUNT(*) AS "NUMBER OF STUDENTS " FROM STUDENT;

SELECT COUNT(DISTINCT GroupNumber) AS GroupCount FROM STUDENT;

SELECT AVG(MARK) AS AvgMark FROM EXAM_RESULT;

SELECT ClassRoom, ExamDate, COUNT(*) AS ExamCount
FROM EXAM_SHEET
GROUP BY ClassRoom, ExamDate;

SELECT YEAR(BirthDate) AS "Year", COUNT(*) AS "Count of Students" 
FROM STUDENT GROUP BY YEAR(BirthDate);



/* EASILY AND UNINTERESTING */
select * from TEACHER;
select * from COURSE;
select * from ST_GROUP;
select * from STUDENT;
select * from PHONE_LIST;
select distinct * from EXAM_SHEET;
select * from EXAM_RESULT;

/*
select [all | distinct] {* | table_name [AS new_name]} [INTO переменнная]
 FROM table names [[AS] псевдоним]
[WHERE <условие_поиска>]
[GROUP BY имя_столбца[,...]]
[HAVING <критериц выбора групп>]
[ORDER BY имя_столбца [,...]]
[LIMIT n[,m]]
*/

select distinct groupNumber from student; /*Also can use 'all'*/
select StudentId, StudentName, MonthName(BirthDate) MonthName_of_BirthDate from Student;

/*Using where*/

SELECT StudentId, StudentName, BirthDate
FROM STUDENT
WHERE Month(BirthDate) >= 6 AND Month(BirhtDate) <= 8;

SELECT DISTINCT StudentId FROM EXAM_RESULT
WHERE Mark BETWEEN 3 AND 5;

SELECT * FROM exam_sheet WHERE classRoom IS NULL;

SELECT * FROM STUDENT WHERE Address LIKE '%Малый пр%';

SELECT DISTINCT StudentId
FROM EXAM_RESULT 
WHERE Mark IN (2,4);

SELECT StudentName FROM STUDENT ORDER BY StudentName;

SELECT StudentName FROM STUDENT ORDER BY StudentName LIMIT 5;




