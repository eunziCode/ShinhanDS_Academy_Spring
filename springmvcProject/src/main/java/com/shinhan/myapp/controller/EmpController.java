package com.shinhan.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shinhan.myapp.emp.EmpDTO;
import com.shinhan.myapp.emp.EmpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	EmpService eService;
	
	@GetMapping("/list.do")
	public void selectAll() {
		List<EmpDTO> emplist = eService.selectAllService();
		
		log.info(emplist.size()+"°Ç");
	}
}
