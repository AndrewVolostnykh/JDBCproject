USE STUDENT_INFO;

CREATE VIEW V_EXAM_RESULT AS SELECT StudentId, Mark
FROM EXAM_RESULT WHERE Mark = 5; /*Merge algorithm example*/

SELECT StudentId, Mark FROM V_Exam_Result
WHERE StudentId = 345567;

SELECT StudentId, Mark FROM exam_result WHERE mark = 5 AND studentId = 345567;

/*TEMPTABLE algorithm example*/
CREATE VIEW V_STUDENT_EXAM_RESULT AS SELECT StudentId, COUNT(*) AS TheBestMarkCount
FROM EXAM_RESULT WHERE Mark = 5 GROUP BY StudentId; /*Merge here */

SELECT MAX(TheBestMarkCount) FROM V_STUDENT_EXAM_RESULT;

/*temp here*/
CREATE TEMPORARY TABLE tmp_table SELECT StudentId, COUNT(*) AS TheBestMarkCount
FROM EXAM_RESULT WHERE Mark = 5 GROUP BY StudentId;

SELECT MAX(TheBestMarkCount) FROM tmp_table;

DROP TABLE tmp_table;



/* Attempt to change view and use options */
CREATE VIEW V_HOME_PHONE_LIST
AS SELECT StudentId, PhoneType, Phone
FROM PHONE_LIST
WHERE PhoneType = 'дом' WITH CHECK OPTION;

/*After that, i can add some information*/
INSERT INTO V_HOME_PHONE_LIST (StudentId, PhoneType, Phone) VALUES (345572, 'моб', 881278780);

/*result
+-------------+
| Phone       |
+-------------+
| 88121564567 |
| 88127878780 |
+-------------+*/



