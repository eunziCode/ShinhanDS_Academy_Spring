<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="../common/bootstrap.jsp"%>
  <%@ include file="../common/header.jsp"%>  
  <title>부서 수정</title>
  <meta charset="utf-8">
  <style>
  [readonly] { background: lightgray; }
  </style>
</head>
<body>

<div class="container mt-3">
  <h2>부서 수정</h2>  
  <form action="detail.do" method="post">
    <div class="input-group mb-3">
      <span class="input-group-text">부서번호</span>
      <input readonly type="number" required="required" class="form-control" name="department_id" value="${deptInfo.department_id}">
    </div>    
    <div class="input-group mb-3">
      <span class="input-group-text">부서이름</span>
      <input type="text" required="required" class="form-control" name="department_name" value="${deptInfo.department_name}">
    </div>    
    <div class="input-group mb-3">
      <span class="input-group-text">부서장</span>
      <input type="number" required="required" class="form-control" name="manager_id" value="${deptInfo.manager_id}">
    </div>    
    <div class="input-group mb-3">
      <span class="input-group-text">지역번호</span>
      <input type="number" required="required" class="form-control" name="location_id" value="${deptInfo.location_id}">
    </div>
    <input type="hidden" name="phone" value="010-1234-5678">   
    <button type="submit" class="btn btn-primary">부서 수정</button>
  </form>
</div>

</body>
</html>