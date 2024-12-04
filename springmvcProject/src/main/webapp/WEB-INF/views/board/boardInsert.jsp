<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/bootstrap.jsp" %>
<meta charset="UTF-8">
<title>2024-12-04 실습</title>
</head>
<body>
	<div class="container mt-3">
		<%@ include file="../common/header.jsp" %>
  		<h2>게시글등록</h2>
		<form action="insert.do" method="post" enctype="multipart/form-data">
			<div class="input-group mb-3">
				<span class="input-group-text">제목</span> 
				<input type="text" class="form-control" name="title">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">내용</span> 
				<input type="text" class="form-control" name="content">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">이미지선택</span> 
				<input type="file" class="form-control" name="pic">
			</div>
			<div class="input-group mb-3">
				<input class="btn btn-primary" type="submit" value="입력">
			</div>
		</form>
	</div>
</body>
</html>