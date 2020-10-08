package gradle_mybatis_spring_study.mapper;

import java.util.List;
import java.util.Map;

import gradle_mybatis_spring_study.dto.Student;

public interface StudentMapper {
	
	//TypeHandler 이용
	Student selectStudentByNo(Student student);
	
	//ResultMap 이용
	Student selectStudentByNoWithResultMap(Student student);
	
	List<Student> selectStudentByAll();
	
	int insertStudent(Student student);
	
	int deleteStudent(int id);
	
	int updateStudent(Student student);
	
	// 결과 매핑
	List<Map<String, Object>> selectStudentByAllForHashMap();
}