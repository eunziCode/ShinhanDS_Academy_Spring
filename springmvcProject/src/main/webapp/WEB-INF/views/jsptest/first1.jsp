<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.servletContext.contextPath}" scope="application"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2024-11-28 실습</title>
</head>
<body>
	<h1>first1.jsp 열림</h1>
	
	<h2>Post 요청하기 연습</h2>
	<form action="${path}/second4.do" method="post">
		id: <input type="text" name="userid" value="pej"><br>
		pw: <input type="text" name="userpw" value="1234"><br>
		<input type="submit" value="서버에 전송(post)">
	</form>
	<hr>
	<h2>요청 파라미터 체크 연습</h2>
	<form action="${path}/second4.do" method="get">
		id: <input type="text" name="userid" value="pej"><br>
		pw: <input type="text" name="userpw" value="1234"><br>
		<input type="submit" value="서버에 전송(post)">
	</form>
</body>
</html>