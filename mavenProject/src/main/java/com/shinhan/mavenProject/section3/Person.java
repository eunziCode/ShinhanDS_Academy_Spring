package com.shinhan.mavenProject.section3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// POJO
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	String name;
	int age;
	Car car;
}
