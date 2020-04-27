USE STUDENT_INFO;

/*Add techers*/
INSERT INTO TEACHER(TeacherId, TeacherName, Position) VALUES(1,'Петров Иван Семенович', 'профессор');
INSERT INTO TEACHER(TeacherId,TeacherName, Position) VALUES(2,'Семенова Анна Ивановна', 'доцент');

/*Add courses*/
INSERT INTO COURSE(CourseId,CourseTitle) VALUES(1,'Физика');
INSERT INTO COURSE(CourseId, CourseTitle) VALUES(2,'Базы данных');

/*Add goups/specialisations*/
INSERT INTO ST_GROUP(GroupNumber, Specialization) VALUES(341, 'Информационно-аналитические системы');
INSERT INTO ST_GROUP(GroupNumber, Specialization) VALUES(371, 'Системное программирование');

/*Add students*/
INSERT INTO STUDENT(StudentId, StudentName, GroupNumber, BirthDate, Address) VALUES(345567,'Иванов Александр', 341, "1999-01-20", 'Петергоф, Библиотечная пл., дом 2');
INSERT INTO STUDENT(StudentId, StudentName, GroupNumber, BirthDate, Address) VALUES(345568,'Широков Федор', 341, "1998-03-21", 'Санкт-Петербург, ул. Гаванская 34');
INSERT INTO STUDENT(StudentId, StudentName, GroupNumber, BirthDate, Address) VALUES(345569,'Антонова Даша', 341, "1999-05-17", 'Санкт-Петербург, ул. Широкая 45');
INSERT INTO STUDENT(StudentId, StudentName, GroupNumber, BirthDate, Address) VALUES(345570,'Антипенко Денис', 371, "1998-08-11", 'Санкт-Петербург, Малый пр. 15');
INSERT INTO STUDENT(StudentId, StudentName, GroupNumber, BirthDate, Address) VALUES(345571,'Сидоров Александр', 371, "1999-07-12", 'Санкт-Петербург, Средний пр. 4');
INSERT INTO STUDENT(StudentId, StudentName, GroupNumber, BirthDate, Address) VALUES(345572,'Фадеев Дмитрий', 371, "1999-11-24", 'Санкт-Петербург, Невский пр.23');

/*Add phones*/
INSERT INTO PHONE_LIST(StudentId, PhoneType, Phone) VALUES(345567, 'моб', '89211264567');
INSERT INTO PHONE_LIST(StudentId, PhoneType, Phone) VALUES(345567, 'дом', '88121564567');
INSERT INTO PHONE_LIST (StudentId, PhoneType, Phone) VALUES(345568,'моб', '89217234567');
INSERT INTO PHONE_LIST (StudentId, PhoneType, Phone) VALUES(345571, 'моб', '89071254567');
INSERT INTO PHONE_LIST (StudentId, PhoneType, Phone) VALUES(345572, 'моб', '88121239567');

/*Add exams*/
INSERT INTO EXAM_SHEET    (ExamSheetId,GroupNumber,CourseId,TeacherId,ClassRoom,ExamDate) VALUES(1,341,1,1,2408,"2017-01-25");
INSERT INTO EXAM_SHEET    (ExamSheetId,GroupNumber,CourseId,TeacherId,ClassRoom,ExamDate) VALUES(2,371,1,1,2408,"2017-01-27");
INSERT INTO EXAM_SHEET    (ExamSheetId,GroupNumber,CourseId,TeacherId,ClassRoom,ExamDate) VALUES(3,341,2,2,2446,"2017-01-28");
INSERT INTO EXAM_SHEET    (ExamSheetId,GroupNumber,CourseId,TeacherId,ExamDate)           VALUES(4,371,2,2,"2017-01-26");

/*Add exam results*/
INSERT INTO EXAM_RESULT(StudentId,ExamSheetId,Mark) VALUES(345567,1,5);
INSERT INTO EXAM_RESULT(StudentId,ExamSheetId,Mark) VALUES(345567,3,5);
INSERT INTO EXAM_RESULT(StudentId,ExamSheetId,Mark) VALUES(345568,1,3);
INSERT INTO EXAM_RESULT(StudentId,ExamSheetId,Mark) VALUES(345568,3,4);
INSERT INTO EXAM_RESULT(StudentId,ExamSheetId,Mark) VALUES(345569,1,5);
INSERT INTO EXAM_RESULT(StudentId,ExamSheetId,Mark) VALUES(345569,3,2);
INSERT INTO EXAM_RESULT(StudentId,ExamSheetId,Mark) VALUES(345570,2,4);
INSERT INTO EXAM_RESULT(StudentId,ExamSheetId,Mark) VALUES(345570,4,5);
INSERT INTO EXAM_RESULT(StudentId,ExamSheetId,Mark) VALUES(345571,2,3);
INSERT INTO EXAM_RESULT(StudentId,ExamSheetId,Mark) VALUES(345571,4,2);
INSERT INTO EXAM_RESULT(StudentId,ExamSheetId,Mark) VALUES(345572,2,5);
INSERT INTO EXAM_RESULT(StudentId,ExamSheetId,Mark) VALUES(345572,4,5);




