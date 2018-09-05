<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Boolean b = (Boolean)session.getAttribute("LOGADO");
	
		if (b != null && b == true) {
	%>
			<h2>Bem vindo a pagina principal</h2>
			<h3>Você conseguiu se logar com sucesso e pode acessar a página</h3>
	<%  } else {  %>
			<h2>Você precisa se logar para acessar o sistema</h2>
			<h3>Acesse a página de login</h3>
	<%  } %>
	

</body>
</html>