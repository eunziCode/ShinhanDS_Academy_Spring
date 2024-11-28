package com.shinhan.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/jsptest") // class(type) level에서 요청주소를 작성
public class SampleController2 {
	
	@GetMapping ("/first1.do") // function(method) level에서 요청주소를 작성
	public void f1() {
		
	}
	
	@RequestMapping ("/first2.do")
	public void f2() {
		
	}

	@RequestMapping(value = "/first3.do", method = RequestMethod.GET)
	public void f3() {
		
	}
}
