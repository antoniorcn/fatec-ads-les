<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tabuada</title>
</head>
<body>
	
	<h1>Mostra a tabuada</h1>
	<h2>Invoca o servlet para calcular a tabuada</h2>
	<%-- 
		<jsp:include page="./Tabuada">
			<jsp:param value="9" name="NUMERO"/>
		</jsp:include>
 	--%>
 	<form action="./Tabuada">
 		<h3>Digite um numero para mostrar a tabuada</h3>
 		<input type="text" name="NUMERO"/>
 		<input type="submit" value="Calcular"/>
  	</form>
</body>
</html>