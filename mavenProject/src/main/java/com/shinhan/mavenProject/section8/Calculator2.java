package com.shinhan.mavenProject.section8;

import org.springframework.stereotype.Component;

// Target...주관심사(core concern), 업무로직

@Component("cal2")
public class Calculator2 {
	
	public int add(int a) {
		return a;
	}
	
	public int add(int a, int b) {
		return a + b;
	}
	public String dd(int a, int b) {
		return "결과:"+(a + b);
	}
}