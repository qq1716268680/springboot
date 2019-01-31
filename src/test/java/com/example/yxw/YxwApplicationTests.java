package com.example.yxw;

import com.example.yxw.controller.SpringUtil;
import com.example.yxw.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YxwApplicationTests {

	private static  ApplicationContext context;
	@Test
	public void contextLoads() {
	}

	@Test
	public void test(){
		UserService userService = (UserService) SpringUtil.getBean("UserService");
	}
}

