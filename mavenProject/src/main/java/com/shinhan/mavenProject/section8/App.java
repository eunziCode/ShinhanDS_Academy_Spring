package com.shinhan.mavenProject.section8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop8.xml");

		// 주업무
		DeptService dService = ctx.getBean("deptService", DeptService.class);
		for(DeptDTO dept : dService.selectAllService()) {
			//System.out.println(dept);
		}
		
		// 보조업무는 Spring이 하게끔 구현됨
		// 주업무 수행
//		Calculator cal = ctx.getBean("cal", Calculator.class);
//		cal.divide(1,2);
	}
}
