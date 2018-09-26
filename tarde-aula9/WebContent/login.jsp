<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style>
		
	</style>
	<link href="./arquivo.css" rel="stylesheet"/>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página de Login</title>
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
		<table class="table table-striped">
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