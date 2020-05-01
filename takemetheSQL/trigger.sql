/*
CREATE TRIGGER trigger_name
{BEFORE|AFTER}
{INSERT|UPDATE|DELETE}
ON table_name
FRO EACH ROW
trigger_body
*/


DELIMITER $$
CREATE TRIGGER tr_ins_teacher
BEFORE INSERT ON TEACHER
FOR EACH ROW
BEGIN
	DECLARE varNextTeacherId INTEGER;
	SELECT MAX(TeacherId)+1 INTO varNextTeacherId FROM TEACHER;
	SET NEW.TeacherId = varNextTeacherId;
END $$
DELIMITER ;

INSERT INTO TEACHER(TeacherName, Position) VALUES('Огурцов Иван Васильевич', 'доцент');

/*One more*/

CREATE TABLE LOG (Message VARCHAR(256), MessageData TIMESTAMP);

DELIMITER $$

CREATE TRIGGER tr_up_teacher
AFTER UPDATE ON TEACHER FOR EACH ROW
BEGIN
	IF OLD.TeacherId <> NEW.TeacherId OR OLD.TeacherName <> NEW.TeacherName
		OR OLD.Position <> NEW.Position
	THEN INSERT INTO LOG(Message) VALUES('');
		 INSERT INTO LOG(Message) VALUES(CONCAT_WS(' ', 'Старые значения: ', 
			OLD.TeacherId, OLD.TeacherName, OLD.Position));
		 INSERT INTO LOG(Message) VALUES(CONCAT_WS(' ', 'Новые значения: ',
			NEW.TeacherId, NEW.TeacherName, NEW.Position));
	END IF;
END $$
DELIMITER ;

UPDATE TEACHER SET Position = 'профессор' WHERE TeacherId = 3;





