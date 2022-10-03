<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>BoardList</title>
</head>
<body>
	<h3>게시판</h3>
	<table border="1">
		<col width="80px">
		<col width="200px">
		<col width="100px">
		<tr>
			<th>Name</th>
			<th>Title</th>
			<th>Date</th>
			
		</tr>
		<c:forEach items="${boardlist}" var="item">
			<tr>
				<td>${item.bdName}</td>
				<td><a href="selectone?title=${item.bdTitle}">${item.bdTitle}</a></td>
				<td>${item.bdDate}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="right">
				<input type="button" value="글쓰기" onclick="location='writeboard.do'">
			</td>
		</tr>
	</table>
</body>
</html>
