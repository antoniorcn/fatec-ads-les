<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2> Gestão de Sorvete </h2>
	
	<jsp:useBean id="sorvete" scope="session" class="edu.curso.Sorvete">
		<jsp:setProperty property="*" name="sorvete"/>
	</jsp:useBean>
	<form action="./SorveteController">
		<table>
			<tr>
				<td>Id</td>
				<td><input type="text" name="id" value="${sorvete.id}"/></td>
			</tr>
			<tr>
				<td>Sabor</td>
				<td><input type="text" name="sabor" value="${sorvete.sabor}"/></td>
			</tr>
			<tr>
				<td>Preço</td>
				<td><input type="text" name="preco" value="${sorvete.preco}"/></td>
			</tr>
			<tr>
				<td>Tipo</td>
				<td>
					<select name="tipo">
						<option value="picole">Picole</option>
						<option value="massa">Massa</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Adicionar"/></td>
				<td><input type="submit" value="Pesquisar"/></td>
			</tr>												
		</table>
	</form>
</body>
</html>