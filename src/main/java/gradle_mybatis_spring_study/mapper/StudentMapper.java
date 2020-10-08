package gradle_mybatis_spring_study.mapper;

import gradle_mybatis_spring_study.dto.Student;

public interface StudentMapper {
	Student selectStudentByNo(Student student);
}
