<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina principal</title>
</head>
<body>
	<% Boolean logado = 
			(Boolean)session.getAttribute("LOGADO"); 
		if (logado != null && logado == true) {
	%>
			<h3>Conteúdo da pagina principal</h3>
			<h4>Parabéns você está logado</h4>
	<%  } else { %>
			<h3>Você precisa fazer o login</h3>
			<h4>Clique <a href="./login.jsp">aqui</a> para acessar acessar a página de login</h4>
	<% } %>
	

</body>
</html>