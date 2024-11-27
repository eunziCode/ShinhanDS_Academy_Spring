package com.shinhan.mavenProject.section5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.shinhan.mavenProject.section4.CarVO;

// section4까지는 XML 설정을 통해서 Bean을 생성함
// section5에서는 .java를 이용해서 Bean을 생성함

@Configuration // 의미 : 설정파일
@ComponentScan // 의미 : 이 파일을 scan할 수 있음 
public class AppConfig {
	
	@Bean // <bean id="getCar"></bean> 과 같은 의미
	public CarVO getCar() {
		return new CarVO("ABC", 1000, "black");
	}
}
