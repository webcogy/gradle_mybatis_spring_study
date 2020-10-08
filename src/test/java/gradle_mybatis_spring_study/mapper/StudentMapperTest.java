package gradle_mybatis_spring_study.mapper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gradle_mybatis_spring_study.config.ContextRoot;
import gradle_mybatis_spring_study.dto.PhoneNumber;
import gradle_mybatis_spring_study.dto.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentMapperTest {

	private static final Log log = LogFactory.getLog(StudentMapperTest.class);

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Autowired
	private StudentMapper mapper;

	@Test
	public void testSelectStudentByNo() {
		System.out.println("testSelectStudentByNo");
		Student student = new Student();
		student.setStudId(1);
		Student selectedStd = mapper.selectStudentByNo(student);
		Assert.assertNotNull(selectedStd);
		log.debug(selectedStd.toString());
	}

	@Test
	public void selectStudentByNoWithResultMap() {
		System.out.println("selectStudentByNoWithResultMap");
		Student student = new Student();
		student.setStudId(1);
		Student selectedStd = mapper.selectStudentByNoWithResultMap(student);
		Assert.assertNotNull(selectedStd);
		log.debug(selectedStd.toString());
	}

	@Test
	public void testSelectStudentByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Student> list = mapper.selectStudentByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void testInsertStudent() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);
		Student student = new Student();
		student.setStudId(3);
		student.setName("홍길동3");
		student.setEmail("lee@test.co.kr");
		student.setPhone(new PhoneNumber("010-1234-1234"));
		student.setDob(newDate.getTime());
		int res = mapper.insertStudent(student);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test5DeleteStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int deleteStudent = mapper.deleteStudent(3);
		Assert.assertSame(1, deleteStudent);
	}

	@Test
	public void test7UpdateStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(1);
		student.setName("Timothy");
		student.setEmail("test@test.co.kr");
		student.setPhone(new PhoneNumber("987-654-3211"));
		student.setDob(new Date());
		int result = mapper.updateStudent(student);
		Assert.assertSame(1, result);
		student.setEmail("timothy@gmail.com");
		student.setPhone(new PhoneNumber("123-123-1234"));
		student.setDob(new GregorianCalendar(1988, 04, 25).getTime());
		result = mapper.updateStudent(student);
		Assert.assertSame(1, result);
	}
}
