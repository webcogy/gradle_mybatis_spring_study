package gradle_mybatis_spring_study.mapper;

import java.util.Date;
import java.util.GregorianCalendar;

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
@ContextConfiguration(classes = {ContextRoot.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentServiceTest {
	protected static final Log log = LogFactory.getLog(StudentServiceTest.class);

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Autowired
	private StudentMapper mapper;

//	@Test
//	public void testSelectStudentForMap() {
//		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
//		Map<Integer, String> map = service.selectStudentForMap(1);
//		Assert.assertNotNull(map);
//		for (Entry<Integer, String> entry : map.entrySet()) {
//			System.out.printf("key(%s) - value(%s)%n", entry.getKey(), entry.getValue());
//		}
//	}

//	@Test
//	public void testSelectStudentForMa2p() {
//		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
//		Map<Integer, Student> map = service.selectStudentForMap2(1);
//		Assert.assertNotNull(map);
//		for (Entry<Integer, Student> entry : map.entrySet()) {
//			System.out.printf("key(%s) - value(%s)%n", entry.getKey(), entry.getValue());
//		}
//	}
	
	@Test
	public void test14UpdateSetStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Student student = new Student();
		student.setStudId(1);
		student.setPhone(new PhoneNumber("987-654-3211"));
		student.setDob(new Date());
		
		int result = mapper.updateSetStudent(student);
		Assert.assertSame(1, result);
		
		student.setPhone(new PhoneNumber("123-123-1234"));
		student.setDob(new GregorianCalendar(1988, 04, 25).getTime());

		result = mapper.updateSetStudent(student);
		Assert.assertSame(1, result);
	}
}
