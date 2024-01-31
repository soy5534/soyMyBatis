<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록 조회</title>
<style>
table {
	width: 800px;
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
}
</style>
</head>
<!--  JSP는 Controller랑 같이보기. -->
<body>
	<h1>공지사항 목록</h1>
	<table>
		<colgroup>
			<col width="10%">
			<col width="35%">
			<col width="10%">
			<col width="25%">
			<col width="10%">
		</colgroup>
		<thead>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<!--  JSP는 Controller랑 같이보기. -->
			<c:forEach items="${nList }" var="notice">
				<tr>
					<td>${notice.noticeNo }</td>
					<td><a href="/notice/detail.do?noticeNo=${notice.noticeNo }"> ${notice.noticeSubject }</a></td>
					<td>${notice.noticeWriter }</td>
					<td>${notice.noticeDate }</td>
					<td>${notice.viewCount }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" align="center">
				${pageNavi }
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>