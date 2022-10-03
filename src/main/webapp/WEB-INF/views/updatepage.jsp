<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ page import="com.tmp.dao.BoardDAO" %>
	<%@ page import="com.tmp.dto.BoardDTO" %>
<html>
<head>
<title>UpdatePage</title>
</head>
<body>
<%
	String bdTitle = request.getParameter("bdTitle");

	BoardDAO dao;
	BoardDTO dto = dao.selectOne(bdTitle);
	
%>
	<h3>게시글 수정</h3>
	<form action="updateboard.do" method="get">
	<table border="1">
	<tr>
		<th>TITLE</th>
		<td><textarea rows="1" cols="60" name="bdTitle" readonly="readonly">${board.bdTitle}</textarea></td>
	</tr>
	<tr>
		<th>CONTENT</th>
		<td><textarea rows="10" cols="60" name="bdContent">${board.bdContent}</textarea></td>
	</tr>
	</table>
		<button type="submit" formmethod="get">수정완료</button>	
	</form>
	<button onclick="location='boardlist.do'" >목록</button>
</body>
</html>
