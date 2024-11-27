package com.shinhan.mavenProject.section6;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("d16.xml"); // DB설정한 Bean 파일
		/*
		 * 위 문장을 실행함으로써 @Repository(DeptDAO), @Service(DeptService)가 생성됨
		 */
		
		DeptService dservice = ctx.getBean("deptService", DeptService.class);
		List<DeptDTO> dlist = dservice.selectAllService();
		System.out.println(dlist);
	}
}
