<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="../common/bootstrap.jsp"%>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var result = "${result}";
	if(result != ""){
		alert(result);
	}
</script>
</head>
<body>
<div class="container">
	<%@ include file="../common/header.jsp"%>
	<h2>부서 등록</h2>  
	<table class="table table-striped-columns table-hover">
		<tr>
			<th>부서번호</th>
			<th>부서이름</th>
			<th>부서장</th>
			<th>지역번호</th>
		</tr>
	
		<c:forEach items="${deptlist}" var="dept">
			<tr>
				<td><a href="detail.do?deptid=${dept.department_id}">${dept.department_id}</a></td>
				<td>${dept.department_name}</td>
				<td>${dept.manager_id}</td>
				<td>${dept.location_id}</td>
				<td><button onclick="location.href='delete.do?deptid=${dept.department_id}'">삭제</button></td>
				<td>
					<form action="delete.do" method="post">
						<input type="hidden" name="deptid" value="${dept.department_id}">
						<input type="submit" value="삭제(form)">
					</form>
				</td>
			</tr>
		</c:forEach>
		
	</table>
</div>
</body>
</html>