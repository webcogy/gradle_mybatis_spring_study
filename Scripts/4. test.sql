SELECT * FROM USER_TABLES;
SELECT * FROM STUDENTS;

SELECT STUD_ID AS studId, NAME, EMAIL, DOB, PHONE 
FROM STUDENTS
WHERE STUD_ID = 1;


select stud_id, name, email, dob,
		substr(phone, 1, 3) as f,
		substr(phone, 5, 3) as m,
		substr(phone, 9, 4) as l
from students where stud_id = 1;

ALTER TABLE STUDENTS ADD GENDER NUMBER(1,0);

DELETE FROM STUDENTS s 
WHERE STUD_ID = 3;

SELECT STUD_ID AS studId, NAME, EMAIL, DOB, PHONE
		FROM
		STUDENTS
		WHERE GENDER = 1;
		
SELECT * 
FROM USER_PICS;