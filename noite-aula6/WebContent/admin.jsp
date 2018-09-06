<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="edu.curso.UserInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		UserInfo user = (UserInfo)session.getAttribute("LOGADO");
	
		if (user != null 
				&& user.isLogado() 
				&& "admin".equals(user.getProfile())) {
	%>
			<h2>Bem vindo <%=user.getNome()%> a pagina de administração do sistema</h2>
			<h3>Você conseguiu se logar com sucesso e pode acessar a página</h3>
	<%  } else {  %>
			<h2>Apenas o administrador pode acessar esta pagina</h2>
			<h3><a href="./login.jsp">Clique aqui</a> e acesse a página de login</h3>
	<%  } %>
	

</body>
</html>