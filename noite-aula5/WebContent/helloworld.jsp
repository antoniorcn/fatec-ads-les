<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World</title>
</head>
<body>

	<h2>HelloWorld JSP</h2>
	
	<h3>Codigo em java</h3>
	<%
		int a = 10;
		int b = 40;
		
		out.write("Soma : " + (a + b) );
	%>

</body>
</html>