package com.shinhan.mavenProject.section8;

import org.springframework.stereotype.Component;

/* Target...주관심사(core concern), 업무로직
   @Component("cal")
== <bean id="cal"  class="com.shinhan.mavenProject.section8.Calculator" /> */
@Component("cal")
public class Calculator {
	public void add() {
		System.out.println("arg0개 가지고있는 add");
	}

	public void add(int x) {
		System.out.println("arg1개 가지고있는 add");

	}

	public void add(int x, int y) {
		int result = x + y;
		System.out.println("arg2개 add 결과:" + result);
	}

	public void subtract(int x, int y) {
		int result = x - y;
		System.out.println("결과:" + result);
	}

	public void multiply(int x, int y) {
		int result = x * y;
		System.out.println("결과:" + result);
	}

	public void divide(int x, int y) {
		int result = x / y;
		System.out.println("결과:" + result);
	}
}