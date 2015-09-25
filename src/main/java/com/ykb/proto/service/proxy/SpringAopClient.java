package com.ykb.proto.service.proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ykb.proto.service.TestService;

public class SpringAopClient {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-aop.xml");
		TestService testService = (TestService) applicationContext.getBean("springAopProxy");
		try {
			testService.test();
		} catch (Exception e) {
			System.out.println("trace");
		}
		testService.ttA();
		testService.ttB();
	}

}
