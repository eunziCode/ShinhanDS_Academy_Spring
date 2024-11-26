package com.shinhan.mavenProject.section3;

import lombok.ToString;

// POJO(Plain Old Java Object) : 평범한 오래된 자바 객체
// Java beans 문법 : field는 "private" modifier 사용, 기존 생성자, getter/setter

@ToString
public class Car {
	private String model;
	private int price;
	
	public Car() {
		System.out.println("Car default생성자");
	}

	public Car(String model, int price) {
		System.out.println("Car arg2생성자");
		this.model = model;
		this.price = price;
	}

	public String getModel() {
		System.out.println("Car getModel()");
		return model;
	}

	public void setModel(String model) {
		System.out.println("Car setModel()");
		this.model = model;
	}

	public int getPrice() {
		System.out.println("Car getPrice()");
		return price;
	}

	public void setPrice(int price) {
		System.out.println("Car setPrice()");
		this.price = price;
	}
	

}
