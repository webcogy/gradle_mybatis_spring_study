package gradle_mybatis_spring_study.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class})
public class ContextDataSourceTest {
	protected static final Log log = LogFactory.getLog(ContextDataSourceTest.class);
	
	@Autowired
	private DataSource dataSource;
	
	@After
	public void tearDown() throws Exception { // 메소드 시작후에 한줄 띄워라 ~ 용도
		System.out.println();
	}
	
	@Test
	public void testDataSource() throws SQLException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		log.debug("DataSource " + dataSource);
		log.debug("LoginTimeout " + dataSource.getLoginTimeout());
		Assert.assertNotNull(dataSource);
	}
}
