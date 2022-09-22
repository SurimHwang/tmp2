<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2022-09-22
  Time: 오후 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title1111</title>
</head>
<body>
 <c:forEach items="${list}" var="item">
     <div>
         ${item.email}
     </div>
 </c:forEach>
</body>
</html>
