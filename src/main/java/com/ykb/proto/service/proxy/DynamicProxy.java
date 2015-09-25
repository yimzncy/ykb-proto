package com.ykb.proto.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

import com.ykb.proto.service.TestService;
import com.ykb.proto.service.impl.TestServiceImpl;

public class DynamicProxy implements InvocationHandler {
	
	private Object target;
	
	public DynamicProxy(Object target) {
		this.target = target;
	}
	
	// Object强转为T，向下转型
	@SuppressWarnings("unchecked")
	public <T> T getProxy() {
		return (T) Proxy.newProxyInstance(
				target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), 
				this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		before();
		Object result = method.invoke(target, args);
		after();
		return result;
	}
	
	private void before() {
		System.out.println("start " + new Date().getTime());
	}
	
	private void after() {
		System.out.println("end " + new Date().getTime());
	}
	
	public static void main(String[] args) {
		DynamicProxy dynamicProxy = new DynamicProxy(new TestServiceImpl());
		TestService testServiceProxy = dynamicProxy.getProxy();
		testServiceProxy.test();
	}

}
