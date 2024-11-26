package com.shinhan.mavenProject.section1;

public class TVUser {

	public static void main(String[] args) {
		f3_2();
//		f3();
//		f2();
//		f1();
	}

	private static void f3_2() {
		// 공장화 함
		TVInterface tv = TVFactory.makeTV("sam");
		tv.turnOn();
		tv.turnOff();
	}

	private static void f3() {
		// interface(규격서)가 있는 경우
		// SamsungTV 생성자가 변경되면 또 수정해야함 → 유지보수 용이하지 않음
		TVInterface tv = new SamsungTV("sam"); 
		tv.turnOn();
		tv.turnOff();
		
		tv = new LgTV();
		tv.turnOn();
		tv.turnOff();
	}

	private static void f2() {
		// interface(규격서)가 없는 경우
		LgTV tv = new LgTV();
		tv.powerOn();
		tv.powerOff();
	}
	private static void f1() {
		// interface(규격서)가 없는 경우
		SamsungTV tv = new SamsungTV("test");
		tv.turnOn();
		tv.turnOff();
	}

}
