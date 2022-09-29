<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title1111</title>
</head>
<body>
 <form action="/action1" method="post">
 	이메일 : <input name="email" type="text"/><br/>
 	이름 : <input name="userName" type="text"/><br/>
 	<button type="submit">버튼</button>
 </form>
 
 <c:forEach items="${emaillist}" var="item">
		${item.email}<br>
	</c:forEach>
</body>
</html>
