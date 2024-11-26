package com.shinhan.mavenProject.section1;

public class TVFactory {

	public static TVInterface makeTV(String brand) {
		if(brand.equals("sam")) {
			return new SamsungTV("랄랄라");
		} else {
			return new LgTV();
		}
	}
}
