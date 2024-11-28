package com.shinhan.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.shinhan.myapp.vo.DeptDTO;

@Controller
public class SampleController4 {
	
	Logger logger = LoggerFactory.getLogger(SampleController4.class);

	@GetMapping("/jsptest2/coffee.do")
	public void f1() {
		
	}
	
	// @RequestParam == request.getParameter()
	
	@GetMapping("/jsptest2/coffee2.do")
	public void f2(String department_id, String department_name, String manager_id, String location_id) {
		logger.info("department_id:"+ department_id);
		logger.info("department_name:"+ department_name);
		logger.info("manager_id:"+ manager_id);
		logger.info("location_id:"+ location_id);
	}
	
	@GetMapping("/jsptest2/coffee3.do")
	public String f3(@ModelAttribute("dept") DeptDTO dept) {
		// 생성한 DTO와 이름이 모두 같으면 생성과 Setter도 진행
		logger.info(dept.toString());
		return "jsptest2/coffee2";
	}
}
