/*What about functions from MYSql?*/

DELIMITER $$
DROP FUNCTION IF EXISTS GetMobilePhoneByStudentId $$

CREATE FUNCTION GetMobilePhoneByStudentId (p_StudentId INTEGER)
RETURNS VARCHAR(11)
BEGIN 
	DECLARE varPhone VARCHAR(11);
	SELECT Phone INTO varPhone
	FROM PHONE_LIST
	WHERE StudentId = p_StudentId AND PhoneType = 'моб'
	LIMIT 1;
	
	RETURN varPhone;
END $$

DELIMITER ;
select GetMobilePhoneByStudentId(345568);

SELECT GetMobilePhoneByStudentId(StudentId) AS StudentName, PhoneType, Phone FROM PHONE_LIST;

/*Function counter for student mark*/

DELIMITER $$
DROP FUNCTION IF EXISTS GetStudentAvgMark $$

CREATE FUNCTION GetStudentAvgMark (p_StudentId INTEGER)
RETURNS REAL
BEGIN 
	DECLARE varStudentAvgMark REAL;
	SELECT AVG(Mark) INTO varStudentAvgMark
	FROM EXAM_RESULT
	WHERE EXAM_RESULT.StudentId = p_StudentId;
	
	RETURN varStudentAvgMark;
END $$
DELIMITER ;

SELECT StudentId, StudentName, GetStudentAvgMark(StudentId) AS AvgMark
FROM STUDENT;



