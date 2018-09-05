<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="edu.curso.UserInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina administrador</title>
</head>
<body>
	<% UserInfo userInfo = 
			(UserInfo)session.getAttribute("LOGADO"); 
		if (userInfo != null 
			&& userInfo.isLogado()
			&& "admin".equals(userInfo.getProfile())) {
	%>
			<h3>Conteúdo da pagina de administrador</h3>
			<h4>Parabéns <%=userInfo.getNome()%> você está acessando a pagina de administração do sistema</h4>
	<%  } else { %>
			<h3>Apenas o administrador pode acessar esta página</h3>
			<h4>Clique <a href="./login.jsp">aqui</a> para acessar acessar a página de login</h4>
	<% } %>
</body>
</html>