package cn.tedu.store.test.text;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TextRegexpTestCase {
	
//	@Test(timeout = 10000)
//	public void testA(){
//		System.out.println(555);
//	}

	private AbstractApplicationContext ac;
	
	@Before
	public void doBefore() {
		// ����Spring�����ļ�����ȡSpring����
		ac = new ClassPathXmlApplicationContext(
				"spring-mvc.xml");
				
//		// ��Spring�����л�ȡ����
//		// bean-id��ӿ���һ�£�����ĸΪСд
//		userMapper
//			= ac.getBean("userMapper", UserMapper.class);
	}
	
	@After
	public void doAfter() {
		// �ͷ���Դ
		ac.close();
	}
	
	
	@Test
	public void getConnection() throws SQLException {
		BasicDataSource ds
			= ac.getBean("dataSource", BasicDataSource.class);
		
		Connection conn = ds.getConnection();
		System.out.println(conn);
	}
}



