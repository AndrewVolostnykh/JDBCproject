use STUDENT_INFO;

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




