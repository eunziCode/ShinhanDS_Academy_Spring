package com.shinhan.mavenProject.section8;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect // @Pointcut + Advice
public class StopWatchAdvice {
	
	@Pointcut("execution(* d*(int,int))")
	public void targetMethod2() {
		
	}
	
	@Pointcut("execution(* selectAllService())")
	public void deptTimer() {
		
	}
	
	@Around("deptTimer()")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		//보조업무
		System.out.println("******" + jp.getSignature().getName() + "메서드 호출 전");
		StopWatch watch = new StopWatch("계산시간");
		watch.start();
		System.out.println("------------------before------------------");
		
		Object obj = jp.proceed();
		
		//보조업무
		System.out.println("------------------after------------------");
		System.out.println("*****" + jp.getSignature().getName() + "메서드 호출 후");
		watch.stop();
		System.out.println("주업무 수행 시간:" + watch.getTotalTimeMillis());
		System.out.println(watch.prettyPrint());
		
		return obj;
	}
	
	@Around("targetMethod2()")
	public Object aa(ProceedingJoinPoint jp) throws Throwable {

		//보조업무
		System.out.println("******" + jp.getSignature().getName() + "메서드 호출 전");
		StopWatch watch = new StopWatch("계산시간");
		watch.start();

		//주업무를 수행한다. 
		Object object = jp.proceed();

		//보조업무
		System.out.println("*****" + jp.getSignature().getName() + "메서드 호출 후");
		watch.stop();
		System.out.println("주업무 수행 시간:" + watch.getTotalTimeMillis());
		System.out.println(watch.prettyPrint());
		
		return object;
	}
}
