USE STUDENT_INFO;

/*What about some procedures?*/

/* ---Example of declaring vars
DECLARE varN INTEGER DEFAULT 3;
DECLARE varString VARCHAR(15) DEFAULT 'Kate';
SELECT COUNT(*) INTO varN From Table1
*/

/* --Example of setter
SET varN = 4;
SET varN := 4;
SET varString = 'Bob';
*/

/* Example of condition operator
IF varN > 3
THEN delete from temp where if>40;
ELSE delete from temp;
END IF;
*/

/* Like a switch operator
CASE varN
WHEN 2 THEN set varstring := 'Donald'; // must be atomic
WHEN 5 THEN set varstring := 'Kate';
ELSE set varstring := 'Andrew';
END CASE;
*/

/* Example of loops

WHILE varN < 10 DO 
set varN := varN+1;
END WHILE;

// as break and continue here we use LEAVE and ITERATE

// what is that ?
M1: loop set varN: = k+1;
if varN = 5 then ITERATE M1; end if;
...
if varN > 11 then LEAVE M1; end if;
end loop M1;
*/

DELIMITER $$
CREATE PROCEDURE AddNewCourse (IN P_CourseTitle VARCHAR(50))
BEGIN
	DECLARE varCount INTEGER;
	SELECT COUNT(*) INTO varCount  FROM COURSE WHERE CourseTitle = P_CourseTitle;
	IF varCount = 0
	THEN 
		INSERT INTO COURSE (CourseId, CourseTitle)
		SELECT MAX(CourseId) + 1, P_CourseTitle FROM COURSE;
	END IF;
END $$

DELIMITER ;
CALL AddNewCourse('Математическая статистика');

SELECT * FROM COURSE;







