package com.shinhan.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shinhan.myapp.model.MemberService;
import com.shinhan.myapp.vo.MemberDTO;

@Controller
@RequestMapping("/auth")
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	MemberService mService;
	
	@GetMapping("/login.do")
	public void loginPage() {
		
	}
	
	@PostMapping("/login.do")
	public String loginPost(String userid, String userpass, HttpServletRequest request, HttpSession session) {
		logger.info(request.getRemoteAddr()+"에서 요청함");
		
		MemberDTO member = mService.loginService(userid, userpass);
		
		if(member == null) {
			logger.info("아이디가 존재하지 않음");
		} else if(member.getMember_id().equals("-1")) {
			logger.info("비밀번호 오류");
		} else {
			logger.info(member.toString());
			
			// 세션에 저장하고 업무 시작 → 부서조회로 이동
			session.setAttribute("loginMember", member);
			return "redirect:/dept/list.do";
		}
		// 다시 로그인
		return "redirect:/auth/login.do";
	}
}
