<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>공지사항 작성</title>
	</head>
	<body>
		<h1>공지사항 작성</h1>
		<form action="/notice/register.do"method="post">
			<fieldset>
				<legend>공지사항 작성</legend>
				<ul>
					<li>
						<label>제목</label>
						<input type="text" name="notice-subject">
					</li>					
					<li>
						<label>내용</label>
						<textarea rows="10" cols="40" name="notice-content"></textarea>
					</li>
				</ul>				
			</fieldset>
			<div>
				<input type="submit"value="작성">
			</div>
		</form>
	</body>
</html>