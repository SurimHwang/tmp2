<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<html>
<head>
<title>UserList</title>
</head>
<body>
	<c:forEach items="${emaillist}" var="item">
		${item.email}<br>
	</c:forEach>
</body>
</html>