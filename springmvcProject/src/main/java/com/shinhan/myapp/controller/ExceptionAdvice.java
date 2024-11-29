package com.shinhan.myapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;
/*
 @ControllerAdvice : 예외발생시 전역적으로 처리하는 controller
 500 : 서버오류
 404 : 존재하지 않는 페이지
 */
@ControllerAdvice
@Slf4j
public class ExceptionAdvice {

	// 괄호 안에는 원하는 Exception을 넣으면 됨
	@ExceptionHandler(Exception.class)
	public String f1(Exception ex, Model model) {
		log.info("예외발생 class:"+ex.getClass().getName());
		log.info("예외발생 메세지:"+ex.getMessage());
		model.addAttribute("message","공사중~~~~");
		
		return "error/error500";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String f2(HttpServletRequest request) {
		log.info(request.getRequestURI());
		
		return "error/error404";
	}
}
