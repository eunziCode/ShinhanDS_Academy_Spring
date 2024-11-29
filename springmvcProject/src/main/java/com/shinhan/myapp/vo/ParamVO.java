package com.shinhan.myapp.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class ParamVO {

	Integer userid;		// int로 하게되면 null 값이 못들어오기 때문에 Integer로 선언
	String username;
	String useremail;
	String userphone;
}
