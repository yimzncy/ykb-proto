package com.ykb.proto.service.proxy;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.stereotype.Component;

import com.ykb.proto.service.TestService;
import com.ykb.proto.service.impl.TestServiceImpl;

@Component
public class TestBeforeAndAfterAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		System.out.println("test before");
	}
	
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		System.out.println("test after");
	}
	
	public static void main(String[] args) {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(new TestServiceImpl());
		proxyFactory.addAdvice(new TestBeforeAndAfterAdvice());
		TestService testService = (TestService) proxyFactory.getProxy();
		testService.test();
	}

}
