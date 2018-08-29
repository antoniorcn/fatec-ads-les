<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Data Atual</title>
</head>
<body>

	<h2>Ola mundo JSP</h2>
	<% 
		Date d = new Date();
		SimpleDateFormat sdf = 
				new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	%>
	<h3>Data e hora atual : <%= sdf.format(d) %></h3>

</body>
</html>