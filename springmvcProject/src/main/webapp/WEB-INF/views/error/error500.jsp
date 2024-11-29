<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>500 ERROR</title>
</head>
<body>
	<h1>500 ERROR 정보</h1>
	message ▶ <%=exception.getMessage() %>
	<p>${message}</p>
</body>
</html>