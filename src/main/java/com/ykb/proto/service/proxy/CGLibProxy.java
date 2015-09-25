package com.ykb.proto.service.proxy;

import java.lang.reflect.Method;
import java.util.Date;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.ykb.proto.service.TestService;
import com.ykb.proto.service.impl.TestServiceImpl;

public class CGLibProxy implements MethodInterceptor {
	
	private static CGLibProxy INSTANCE = new CGLibProxy();
	
	private CGLibProxy() {
	}
	
	public static CGLibProxy getInstance() {
		return INSTANCE;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> cls) {
		return (T) Enhancer.create(cls, this);
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		before();
		Object result = proxy.invokeSuper(obj, args);
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
		TestService testService = CGLibProxy.getInstance().getProxy(TestServiceImpl.class);
		testService.test();
	}

}
