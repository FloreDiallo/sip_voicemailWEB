<%@ page language="java" 
    contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
	<META http-equiv=Content-Type content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="layout.css" />
	<script language="Javascript"></script>
</head>
<body>
<div id="sub">
	<h1>Identify yourself to access your messages</h1>
	<form action="LoginServlet">
		<strong>Username :</strong>		
		<input type="text" name="username"/><br>
		<input type="submit" name="login" value="Login">		
	</form>
</div>
</body>
</html>
