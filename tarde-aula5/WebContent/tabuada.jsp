<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tabuada</title>
</head>
<body>
	<h1> Pagina de Teste em JSP </h1>
	<h2> Este código esta em JSP </h2>
	
	<jsp:forward page="/Tabuada">
		<jsp:param name="NUMERO" value="9"/>
	</jsp:forward>

	<h2> Fim da Tabuada </h2>
</body>
</html>