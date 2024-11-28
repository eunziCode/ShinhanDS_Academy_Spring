package com.shinhan.myapp;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// 여러가지 형태의 요청 학습

@Controller
public class SampleController3 {
	
	Logger logger = LoggerFactory.getLogger(SampleController3.class);
	
	/* 요청의 주소가 같고 넘어오는 파라미터도 확인
	 * 조건 : name=userid는 value=pej && name=userpw는 존재만 하면 됨 && name=email은 존재하면 안됨
	 */
	@RequestMapping(value = "/second4.do", params = {"userid=pej", "userpw", "!email"})
	public String f3(String userid, int userpw) {
		logger.info("아이디는 "+ userid);
		logger.info("패스워드는 "+ userpw);
		
		 return "jsptest/second3";
	}
	
	@RequestMapping(value = {"/second3.do"}, method = RequestMethod.POST)
	public String f2(@RequestParam("userid") String userid2, 
					 @RequestParam("userpw") int userpw2) {
		logger.info("아이디는 "+ userid2);
		logger.info("패스워드는 "+ userpw2);
		
		return "jsptest/second3";
	}

	@RequestMapping(value = {"/second1.do","/second2.do"}, method = RequestMethod.GET)
	public String f1() {
		
		return "jsptest/first1";
	}
}
