package com.shinhan.mavenProject.section1;

public class SamsungTV implements TVInterface {
	
	String name;
	
	public SamsungTV(String name) {
		this.name = name;
	}

	public void turnOn() {
		System.out.println(getClass().getSimpleName()+"전원을 켠다");
	}
	
	public void turnOff() {
		System.out.println(getClass().getSimpleName()+"전원을 끈다");
	}
}
