<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
// request 객체로부터 파라미터를 가져옴.
	String email = request.getParameter("email");
	String userName = request.getParameter("userName");
%>
<h1>form태그 예제</h1>
<h3>이메일 : <%=email %></h3>
<h3>이름 : <%=userName %></h3>