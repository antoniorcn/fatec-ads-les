<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>P�gina de Login</title>
</head>
<body>
	<h2>Login no sistema</h2>
	<%
		String msg = (String)session.getAttribute("MENSAGEM");
		if (msg != null) { 
	%>
		<h3 style="color:red;"><%=msg%></h3>
	<% } 
	   session.setAttribute("MENSAGEM", null);%>
	<form action="./authenticator" method="post">
		<table>
			<tr>
				<td>Usuario:</td>
				<td><input type="text" name="TXTUSER"/></td>
			</tr>
			<tr>
				<td>Senha:</td>
				<td><input type="password" name="TXTPASSWORD"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Logar"/></td>
			</tr>		
		</table>
	</form>
</body>
</html>