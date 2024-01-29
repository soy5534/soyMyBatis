<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyBatis 메인</title>
</head>
<body>
	<c:if test="${sessionScope.memberId eq null }">
	<form action="/member/login.do" method="post">
		<fieldset>
			<legend>로그인</legend>
			<input type="text" name="member-id"placeholder="아이디를 입력해주세요"><br>
			<input type="password" name="member-pw" placeholder="비밀번호를 입력해주세요">
		</fieldset>
		<div>
			<input type="submit"value="로그인">
			<a href="/member/register.do">회원가입</a>
		</div>
	</form>
	</c:if>
	<c:if test="${sessionScope.memberId ne null }">
		${memberName }님 환영합니다~ <br>
		<a href="/member/logout.do">로그아웃</a>
		<a href="/member/myPage.do">마이페이지</a> <!-- << 쿼리스트링 없이 해봄 -->
	</c:if>
</body>
</html>