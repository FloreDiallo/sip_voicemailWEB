<%@ page language="java" 
    	contentType="text/html;charset=UTF-8"
    	pageEncoding="UTF-8"
    	import="java.lang.*"
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
	<h1>Save your file</h1>
	<%-- Get the name of the file --%>
	<% String filename = new String();
	filename = (String)request.getAttribute("filename");
	String originDir = new String();
	originDir = (String)request.getAttribute("originDir");
	String username = new String();
	username = (String)request.getAttribute("username");
	 %>
	<form method="get" action="/storemessage">
	<div id="hidden">
		<strong>Username :</strong>
			<textarea name="username" readonly="true" rows=1 cols=64><%= username %></textarea><br /><br />	
		<strong>File to Save :</strong>
			<textarea name="save" readonly="true" rows=1 cols=63><%= filename %></textarea><br /><br />	
		<strong>Old Directory :</strong>
			<textarea name="from" readonly="true"rows=1 cols=61><%= originDir %></textarea><br /><br />	
	</div>
		<strong>New Directory :</strong>
			<textarea name="to" rows=1 cols=60>/tmp/</textarea><br /><br />	
		<strong>Rename your file :</strong>		
			<input type="text" value=<%= filename %> name="new_name" size=60/><br>
		<input type="submit" name="finalsave" value="Save"/>
	</form>
	<a href="/LoginServlet?username=<%=username%>"><input type="button" value="Cancel"></a>
</div>
</body>
</html>
