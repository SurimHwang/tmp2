<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>SignUp</title>
</head>
<body>
 	<h3>회원가입</h3>
	<form action="/signUp" method="post">
		이메일 : <input name="email" type="text" /> <br /> 
		이름 : <input name="userName" type="text" /><br />
		<button type="submit">회원가입</button>
	</form>