SELECT * FROM COURSES;
SELECT * FROM STUDENTS;

DELETE FROM COURSES WHERE COURSE_ID = 1;

SELECT * FROM USER_CONSTRAINTS;

CONSTRAINT fk_code FOREIGN KEY(parentPk)
     REFERENCES parentTable(parentPk) ON DELETE CASCADE;
     
ALTER TABLE COURSES DROP CONSTRAINT PK_COURSE_ID CASCADE;
   
update students SET NAME = '홍길동'  WHERE STUD_ID = 3;

UPDATE COURSES 
SET NAME = 'DHCP', DESCRIPTION = 'hihi'
WHERE COURSE_ID = 3;