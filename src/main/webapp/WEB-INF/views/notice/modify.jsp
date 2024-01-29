<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
</head>
<body>
	<h1>공지사항 수정</h1>
	<form action="/notice/modify.do" method="post">
		<!-- ${notice.noticeNo } -->		
		<input type="hidden" name="notice-no" value="${notice.noticeNo }">
		<fieldset>
			<legend>공지사항 수정</legend>
			<ul>
				<li><label>제목</label> <input type="text"
					value="${notice.noticeSubject }"></li>
				<li><label>내용</label> <textarea rows="10" cols="40">${notice.noticeContent }</textarea>
				</li>
			</ul>
		</fieldset>
		<div>
			<input type="submit" value="수정하기">
		</div>
	</form>
</body>
</html>