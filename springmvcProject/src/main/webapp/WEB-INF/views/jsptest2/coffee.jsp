<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}" scope="application"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2024-11-28 실습</title>
</head>
<body>
	<h1>coffee.jsp 파일 입니다.</h1>
	
	<form action="${path}/jsptest2/coffee3.do">
		<input name="department_id" type="number" value="100"><br>
		<input name="department_name" type="text" value="개발부"><br>
		<input name="manager_id" type="number" value="120"><br>
		<input name="location_id" type="number" value="1700"><br>
		<input type="submit" value="서버전송">
	</form>
</body>
</html>