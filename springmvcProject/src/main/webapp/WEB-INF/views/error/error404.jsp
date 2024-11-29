<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404 ERROR</title>
</head>
<body>
	<h1>알림 : 주소확인 필요!</h1>
	<p id="here">입력한 주소 ▶ </p>
	<script>
		document.querySelector('#here').innerHTML += location.href;
	</script>
</body>
</html>