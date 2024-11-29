package com.shinhan.myapp.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.shinhan.myapp.model.DeptService;
import com.shinhan.myapp.vo.DeptDTO;

// 부서의 CRUD작업 : Controller → Service → DAO
// 사용자의 요청 → DispatcherServlet → Controller 찾기
// component-scan에 의해서 Bean 생성


/* 
 @Controller : 요청오면 page를 return 
 
 @RestController : 요청을 받아서 응답 데이터를 return
 == @Controller + @ResponseBody
 
 @ResponseBody : 해당 Annotation을 사용한 method 에서 return을 하면 데이터 자체를 전송하는 것
 == request.getWriter().append()
*/

@Controller 
public class DeptController {
	
	Logger logger = LoggerFactory.getLogger(DeptController.class);
	
	@Autowired
	DeptService dService;
	
	// 상세화면 요청
	@GetMapping("/dept/detail.do")
	public String detailGet(int deptid, Model model) {
		model.addAttribute("deptInfo",dService.selectByIdService(deptid));
		
		return "dept/deptDetail";
	}
	
	/* 상세보기후에 결과를 보여주고 1초후 list로 가기
	@PostMapping("/dept/detail.do")
	public String detailPost(@ModelAttribute("dept") DeptDTO dept) {
		logger.info(dept.toString());
		
		dService.updateService(dept);
		
		return "dept/result";
	}*/
	
	// 상세 보기
	@PostMapping("/dept/detail.do")
	public String detailPost(DeptDTO dept, RedirectAttributes attr) {
	
		int result = dService.updateService(dept);
		String message = "수정건수:"+result;
		
		logger.info(message);
		
		attr.addFlashAttribute("resultMessage",message);
		
		return "redirect:/dept/list.do"; // redirect: == response.sendRedirect()
	}
	
	// 부서 입력화면 요청
	@GetMapping("/dept/insert.do")
	public String insertGet() {
		
		return "dept/deptInsert";
	}
	
	// 부서 입력
	@PostMapping("/dept/insert.do")
	public String insertPost(DeptDTO dept, RedirectAttributes attr) {
		
		int result = dService.insertService(dept);		
		String message = "입력건수:"+result;
		
		logger.info(message);
		
		attr.addFlashAttribute("resultMessage", message);
		
		return "redirect:/dept/list.do";
	}
	
	// 부서 삭제화면 요청
	@GetMapping("/dept/delete.do")
	public String deleteGet() {
		
		return "dept/deptInsert";
	}
	
	// 부서 삭제
	@RequestMapping(value="/dept/delete.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(int deptid, RedirectAttributes attr) {
		int result = dService.deleteService(deptid);
		String message = "삭제건수:"+result;
		
		attr.addFlashAttribute("resultMessage",message);
		
		return "redirect:/dept/list.do";
	}
	
	// 부서 조회
	@RequestMapping("/dept/list.do")
	public String f1(Model model, HttpServletRequest request) {
		Map<String,?> map = RequestContextUtils.getInputFlashMap(request);
		if(map != null) {
			String message = (String)map.get("resultMessage");
			model.addAttribute("result",message);
		}
		
		List<DeptDTO> deptlist = dService.selectAllService();
		
		model.addAttribute("deptlist", deptlist);
		
		return "dept/deptList"; // forward, include
	}
}
