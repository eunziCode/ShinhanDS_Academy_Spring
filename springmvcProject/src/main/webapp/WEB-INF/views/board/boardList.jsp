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
		<h1>게시목록</h1>
		<img alt="우산이미지" src="${path}/resources/image/umbrella.jpg" width="100" height="100">
		<table class="table table-striped table-bordered table-hover">
			<tr>
				<td>순서</td>
			    <td>board_no</td>
				<td>제목</td>
				<td>내용</td>
				<td>작성자</td>
				<td>이미지</td>
				<td>get요청</td>
			</tr>
			<c:forEach items="${boardlist}" var="board" varStatus="status">
				<tr>
					<td>${status.count}</td>					
					<td>
						<a href="${path}/board/detail.do?bno=${board.board_no}">${board.board_no}</a>
					</td>					
					<td>${board.title}</td>					
					<td>${board.content}</td>					
					<td>${board.writer}</td>					
					<td>${board.pic}</td>
					<c:if test="${loginMember.member_id == board.writer}">					
						<td>
							<button onclick="location.href='${path}/board/delete.do?bno=${board.board_no}'">삭제</button>
						</td>	
					</c:if>				
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>