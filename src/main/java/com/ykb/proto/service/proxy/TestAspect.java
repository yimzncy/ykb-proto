package com.ykb.proto.service.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ykb.proto.service.CestService;
import com.ykb.proto.service.TestService;
import com.ykb.proto.service.impl.CestServiceImpl;

// Aspect注解表示Aspect(Advisor)类
@Aspect
@Component
public class TestAspect {

	/*
	 * JoinPoint对象指AOP中的连接点，可通过该对象获取方法任何信息
	 * 环绕增强用ProceedingJoinPoint，JoinPoint的子类
	 * 
	 * execution() 表示拦截方法
	 * 第一个*表示方法返回任意值，第二个*表示匹配类中所有方法，(..)表示方法参数任意
	 */
	@Around("execution(* com.ykb.proto.service.impl.TestServiceImpl.*(..))")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		before();
		pjp.proceed();
		after();
	}
	
	private void before() {
		System.out.println("--Before--");
	}
	
	private void after() {
		System.out.println("--After--");
	}
	
	@Pointcut("execution(* com.ykb.proto.service.impl.TestServiceImpl.*(..))")
	public void pointcut() {
	}
	
	@AfterReturning("pointcut()")
	public void afterReturning() {
		System.out.println("---END---");
	}
	
	@AfterThrowing(pointcut = "pointcut()", throwing = "error")
	public void afterThrowing(JoinPoint jp, Throwable error) {
		System.out.println("......");
		System.out.println(jp.getTarget().getClass().getName());
		System.out.println(error.getMessage());
		System.out.println("......");
	}
	
	/*
	 * 引入增强
	 * 对方法的增强叫织入(weaving)，对类的增强叫引入(Introduction)
	 * 
	 * value:目标类　　defaultImpl:引入接口的默认实现类
	 */
	@DeclareParents(value = "com.ykb.proto.service.impl.TestServiceImpl", defaultImpl = CestServiceImpl.class)
	private CestService cestService;
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-aop.xml");
		TestService testService = (TestService) applicationContext.getBean("testServiceImpl");
		try {
			testService.test();
		} catch (Exception e) {
			System.out.println("eeeeeeeeeeeeeeee");
		}
		testService.ttA();
		testService.ttB();
		
		CestService cestService = (CestService) testService;
		cestService.cest();
	}

}
