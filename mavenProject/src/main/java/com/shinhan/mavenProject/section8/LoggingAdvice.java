package com.shinhan.mavenProject.section8;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

// 보조업무
/* @Component : <bean id="loggingAdvice" class="패키지이름.LoggingAdvice"></bean>
 * @Aspect : Pointcut과 Advise를 합쳐 놓은 코드(보조업무)
 */

@Component
@Aspect
public class LoggingAdvice {
	
	@Pointcut("execution(* add(int)) || execution(* add(int,int))")
	public void targetMethod2() {
		// 로직 없음
		// 왜? ▶ @Pointcut이 method 위에 쓸 수 있어서 임의로 생성한거일뿐!
		//		method명은 임의대로 만들 수 있음
	}
	
	// DeptService의 모든 메서드가 로그가 남도록 구현
	@Pointcut("within(com.shinhan.mavenProject.section8.DeptService)")
	public void deptServicePointcut() {
		
	}
	
	@Around("deptServicePointcut()")
	public Object f1(ProceedingJoinPoint jp) throws Throwable {
		//보조업무
		System.out.println("[Before]호출된 함수명:"+jp.getSignature().getName());
		
		Object obj = jp.proceed();
		
		//보조업무
		System.out.println("[After]호출된 함수명:"+jp.getSignature().getName());
		
		return obj;
	}
	
	@Before("targetMethod2()")
	public void f1() {
		System.out.println("@Before LoggingAdvice");
	}
	
	@After("targetMethod2()")
	public void f2() {
		System.out.println("@After LoggingAdvice");
	}
	
	@AfterReturning("targetMethod2()")
	public void f3() {
		System.out.println("@AfterReturning LoggingAdvice");
	}
	
	@AfterThrowing("targetMethod2()")
	public void f4() {
		System.out.println("@AfterThrowing LoggingAdvice");
	}
	
	
	@Around("targetMethod2()")
	public Object aroundMethod(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("[메서드 호출 전 : LogginAdvice");
		System.out.println(jp.getSignature().getName() + "메서드 호출 전");
		System.out.println("---------------------------------------");
		// @Before 수행
		Object obj = jp.proceed(); // 주업무 수행
		// @AfterReturning 수행
		// @After 수행
		System.out.println("---------------------------------------");
		System.out.println("[메서드 호출 후 : LogginAdvice");
		System.out.println(jp.getSignature().getName() + "메서드 호출 후");
		
		return obj;
	}
	
	// LoggingAdvice가 MethodInterceptor를 implement를 받고 있어서 invoke라는 정해진 method를 호출한 것
//	public Object invoke(MethodInvocation invocation) throws Throwable {
//		System.out.println("[메서드 호출 전 : LogginAdvice");
//		System.out.println(invocation.getMethod() + "메서드 호출 전");
//		System.out.println("---------------------------------------");
//		//주업무를 수행한다. 
//		Object object = invocation.proceed();
//
//		//주업무 수행후 돌아와서 수행한다.
//		System.out.println("---------------------------------------");
//		System.out.println("[메서드 호출 후 : loggingAdvice");
//		System.out.println(invocation.getMethod() + "메서드 호출 후");
//		
//		return object;
//	}
}