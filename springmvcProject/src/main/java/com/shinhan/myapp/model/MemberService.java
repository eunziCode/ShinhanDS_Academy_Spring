package com.shinhan.myapp.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // @Component + service
public class MemberService {
	
	@Autowired
	MemberDAO mdao;

	public MemberDTO loginService(String mid, String mpass) {
		return mdao.login(mid, mpass);
	}
}
