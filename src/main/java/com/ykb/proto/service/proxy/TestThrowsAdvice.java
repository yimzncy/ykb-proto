package com.ykb.proto.service.proxy;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

@Component
public class TestThrowsAdvice implements ThrowsAdvice {
	
	public void afterThrowing(Method method, Object[] args, Object target, Exception e) {
		System.out.println("...");
		System.out.println(target.getClass().getName());
		System.out.println(method.getName());
		System.out.println(e.getMessage());
		System.out.println("...");
	}

}
