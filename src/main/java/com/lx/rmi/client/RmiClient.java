package com.lx.rmi.client;

import java.rmi.RemoteException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lx.rmi.service.IRmiService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		//"file:src/main/webapp/WEB-INF/config/spring/applicationContext.xml"	//配置文件放到WEB-INF下时需要指定路径使用绝对路径去加载配置文件
		"classpath*:applicationContext.xml"
})
public class RmiClient {
	
	@Autowired
	private IRmiService rmiService;
	
	//public static ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"classpath*:applicationContext.xml"});

	@Test
	public void testRmiClient() {
		try {
			
			//rmiService = ctx.getBean("rmiProxyFactoryBean", IRmiService.class);
			String sayHello = rmiService.sayHello(" this is a spring rmi demo");
			System.out.println("\nRMI接口调用成功"+sayHello+"\n");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
