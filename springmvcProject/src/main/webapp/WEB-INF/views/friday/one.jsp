<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2024-11-29 실습</title>
</head>
<body>
	<h1>ONE requestParam연습</h1>
	<form action="two.do">
		<input name="userid">
		<input name="username" value="홍길동">
		<input name="useremail" value="test@naver.com">
		<input name="userphone" value="010-1234-5678">
		<input type="submit" value="서버전송">
	</form>
</body>
</html>