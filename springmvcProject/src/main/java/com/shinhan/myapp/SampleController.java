package com.shinhan.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shinhan.myapp.model.DeptService;

@Controller // 요청오면 page를 return
public class SampleController {
	@Autowired
	DeptService dService;
	
	// 요청주소와 페이지의 위치가 같으면 페이지 이름은 setting하지 않아도 됨
	@RequestMapping(value = "/jsptest/test2.do", method = RequestMethod.GET)
	public void f4(Model model) {
		model.addAttribute("dept", dService.selectByIdService(100));
	}
	
	@RequestMapping(value = "/test3.do", method = RequestMethod.GET)
	public ModelAndView f3() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("dept", dService.selectByIdService(80));
		mv.setViewName("jsptest/test2");
		
		return mv;
	}
	
	@RequestMapping(value = "/test2.do", method = RequestMethod.GET)
	public String f2(Model model) {
		model.addAttribute("dept", dService.selectByIdService(60));
		
		return "jsptest/test2";
	}

	@RequestMapping("/test1.do")
	public String f1(Model dataStore) {
		dataStore.addAttribute("myname", "eunji");
		dataStore.addAttribute("score", "99");
		
		return "jsptest/test1";
	}
}
