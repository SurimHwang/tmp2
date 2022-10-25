<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>BoardList</title>
</head>
<body>
	<p><h2>게시판</h2>${userName}님 안녕하세요!&nbsp;&nbsp;&nbsp;<button onclick="location.href='../../login.jsp'">로그인 페이지</button></p>
	<table border="1">
		<col width="40px">
		<col width="300px">
		<col width="50px">
		<col width="100px">
		<col width="100px">
		<tr>
			<th>No</th>
			<th>Apart Name</th>
			<th>Floor</th>
			<th>Price</th>
			<th>Date</th>
		</tr>
		<c:forEach items="${boardlist}" var="board">
			<tr onclick="location.href='selectone?bno=${board.bno}'" formmethod="post">
				<td>${board.bno}</td>
				<td>${board.apartName}</td>
				<td>${board.floor}</td>
				<td>${board.price}</td>
				<td>${board.date}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
