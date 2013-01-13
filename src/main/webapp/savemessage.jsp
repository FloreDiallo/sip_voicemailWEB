<%@ page language="java" 
    	contentType="text/html;charset=UTF-8"
    	pageEncoding="UTF-8"
    	import="java.lang.*"
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
	<META http-equiv=Content-Type content="text/html; charset=UTF-8">
	<script language="Javascript"></script>
</head>
<body>

	<h1>Save your file</h1>
	<%-- Get the name of the file --%>
	<% String filename = new String();
	filename = (String)request.getAttribute("filename");
	String originDir = new String();
	originDir = (String)request.getAttribute("originDir");
	 %>
	<form method="get" action="/storemessage">
		<strong>File to Save</strong> :
			<textarea name="save" readonly="true" rows=1 cols=60><%= filename %></textarea><br /><br />	
		<strong>Old Directory</strong> :
			<textarea name="from" readonly="true"rows=1 cols=60><%= originDir %></textarea><br /><br />	
		<strong>New Directory</strong> :
			<textarea name="to" rows=1 cols=60>/home/</textarea><br /><br />	
		<strong>Rename your file:</strong> :		
			<input type="text" value=<%= filename %> name="new_name" size=60/><br>
		<input type="submit" name="finalsave" value="Save"/>
	</form>
</body>
</html>
