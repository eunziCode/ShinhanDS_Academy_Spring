<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/bootstrap.jsp" %>
<meta charset="UTF-8">
<title>2024-12-04 실습</title>
<style>
	input[readonly] {
		background-color: lightgray;
	}
</style>
</head>
<body>
	<div class="container mt-3">
		<%@ include file="../common/header.jsp" %>
  		<h2>게시글수정</h2>
		<form action="update.do" method="post">
			<div class="input-group mb-3">
				<span class="input-group-text">번호</span> 
				<input type="number" readonly class="form-control" name="board_no" value="${board.board_no}">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">등록일</span> 
				<input type="date" readonly class="form-control" name="regdate" value="${board.regdate}">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">작성자</span> 
				<input type="text" readonly class="form-control" name="writer" value="${board.writer}">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">제목</span> 
				<input type="text" class="form-control" name="title" value="${board.title}">
			</div>
			<div class="input-group mb-3">
				<span class="input-group-text">내용</span> 
				<input type="text" class="form-control" name="content" value="${board.content}">
			</div>
			<div class="input-group mb-3">
				<c:if test="${fn:length(board.pic) > 0}">
					<img alt="${board.title}이미지" src="${path}/resources/upload/${board.pic}" width="100" height="100">
				</c:if>
			</div>
			<c:if test="${loginMember.member_id == board.writer}">
				<div class="input-group mb-3">
					<input class="btn btn-primary" type="submit" value="수정">
				</div>
			</c:if>
		</form>
	</div>
</body>
</html>