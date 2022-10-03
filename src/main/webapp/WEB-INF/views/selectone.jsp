<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>SelectOne</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>NAME</th>
			<td>${board.bdName}</td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td>${board.bdTitle}</td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td><textarea rows="10" cols="60" readonly="readonly">${board.bdContent}</textarea></td>
		</tr>
		<tr>
			<td><a href="updatepage.do?title=${board.bdTitle}?content=${board.bdContent}">수정</a>&nbsp;&nbsp;
			<a href="deleteboard.do?title=${board.bdTitle}?content=${board.bdContent}">삭제</a>&nbsp;&nbsp;
			<button onclick="location='boardlist.do'">목록</button>
	</td>
		</tr>
	</table>
	</form>
	
</body>
</html>

