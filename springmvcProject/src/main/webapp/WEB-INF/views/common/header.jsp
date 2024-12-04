<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#loginInfo{
		background-color: beige;
	}
</style>
<div id="loginInfo">
	<p>
		${loginMember.member_name==null?"손님":loginMember.member_name}님 환영합니다.
		<a href="${path}/auth/logout.do">로그아웃</a>
	</p>
	<a href="${path}/auth/main.do">홈으로</a>
</div>
<hr>