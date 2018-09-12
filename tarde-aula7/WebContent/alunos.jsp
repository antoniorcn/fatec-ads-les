<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	<script src="js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Gestão de alunos</title>
</head>
<body>

	<h1>Gestão de Alunos</h1>
	<form action="./AlunoController" method="post">
		<div class="container">
			<div class="form-group">
				<label for="alunoId">Id</label>
			    <input type="text" class="form-control" id="alunoId" name="alunoId" readonly>
			</div>
			<div class="form-group">
			    <label for="alunoNome">Nome</label>
			    <input type="text" class="form-control" id="alunoNome" name="alunoNome">
			</div>
			<div class="form-group">
			    <label for="alunoRA">RA</label>
			    <input type="text" class="form-control" id="alunoRA" name="alunoRA">
			</div>		  		  		  
			<div class="form-group">
			    <label for="alunoCidade">Cidade de Moradia</label>
			    <select class="form-control" id="alunoCidade" name="alunoCidade">
					<option>São Paulo</option>
					<option>Mogi das Cruzes</option>
					<option>Taboão da Serra</option>
					<option>Poá</option>
					<option>Bragança</option>
					<option>Guarulhos</option>
			    </select>
			</div>
			<div class="form-check form-check-inline">
			    <input class="form-check-input" type="radio" id="alunoMasculino" value="masc" name="alunoGenero">
			    <label class="form-check-label" for="alunoMasculino">Masculino</label>
			</div>
			<div class="form-check form-check-inline">
			    <input class="form-check-input" type="radio" id="alunoFeminino" value="fem" name="alunoGenero">
			    <label class="form-check-label" for="alunoFeminino">Feminino</label>
			</div>	
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Adicionar</button>
			</div>
		</div>
	</form>
</body>
</html>