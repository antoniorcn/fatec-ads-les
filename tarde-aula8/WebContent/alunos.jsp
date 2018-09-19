<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, edu.entidade.Aluno" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.3.1.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Gestão de alunos</title>
</head>
<body>
	<h1>Gestão de Alunos</h1>
	
	<%
		Aluno alunoAtual = (Aluno) session.getAttribute("ALUNO_ATUAL");
		if (alunoAtual == null) { 
			alunoAtual = new Aluno();
		}
		String msg = (String) session.getAttribute("MENSAGEM");
		List<Aluno> alunos = (List<Aluno>) session.getAttribute("ALUNOS");
		if (msg != null) { 
			session.setAttribute("MENSAGEM", null);
	%>
			<h3 class="alert alert-danger"><%=msg%></h3>
	<%  } %>
	<form action="./AlunoController" method="post">
		<div class="container">
			<div class="form-group">
				<label for="alunoId">Id</label>
			    <input type="text" class="form-control" id="alunoId" name="alunoId" value="<%=alunoAtual.getId()%>" readonly>
			</div>
			<div class="form-group">
			    <label for="alunoNome">Nome</label>
			    <input type="text" class="form-control" id="alunoNome" name="alunoNome" value="<%=alunoAtual.getNome()%>">
			</div>
			<div class="form-group">
			    <label for="alunoRA">RA</label>
			    <input type="text" class="form-control" id="alunoRA" name="alunoRA" value="<%=alunoAtual.getRa()%>">
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
				<button type="submit" class="btn btn-primary" name="cmd" value="adicionar">Adicionar</button>
				<button type="submit" class="btn btn-primary" name="cmd" value="pesquisar">Pesquisar</button>
			</div>
		</div>
	</form>
	<%if (alunos != null && alunos.size() > 0) { %>
<%-- 		<div class="container">
			<table class="table table-striped">
				<thead>
					<th>Id</th>
					<th>RA</th>
					<th>Nome</th>
					<th>Cidade</th>
					<th>Genero</th>
				</thead>
				<tbody>
					<% for (Aluno a : alunos) { %>
					<tr>
						<td><%=a.getId()%></td>
						<td><%=a.getRa()%></td>
						<td><%=a.getNome()%></td>
						<td><%=a.getCidade()%></td>
						<td><%=a.isGenero() ? "Masculino" : "Feminino"%></td>
					</tr>
					<% } %>
				</tbody>
			</table>
		</div> --%>
		<form id="tableForm" action="./AlunoController" method="post">
			<div class="container">
				<div class="row">
					<div class="col col-lg-1">Id</div>
					<div class="col col-lg-2">RA</div>
					<div class="col col-lg-3">Nome</div>
					<div class="col col-lg-2">Cidade</div>
					<div class="col col-lg-1">Genero</div>
					<div class="col col-lg-3">Ações</div>
				</div>
				<% for (Aluno a : alunos) { %>
				<div class="row">
					<div class="col col-lg-1"><%=a.getId()%></div>
					<div class="col col-lg-2"><%=a.getRa()%></div>
					<div class="col col-lg-3"><%=a.getNome()%></div>
					<div class="col col-lg-2"><%=a.getCidade()%></div>
					<div class="col col-lg-1"><%=a.isGenero() ? "Masculino" : "Feminino"%></div>
					<div class="col col-lg-3">
						<div class="form-group form-group-inline">
							<button type="button" class="btn btn-primary" name="cmd" value="atualizar" onclick="atualizar(<%=a.getId()%>);">Atualizar</button>
							<button type="button" class="btn btn-primary" name="cmd" value="remover" onclick="remover(<%=a.getId()%>);">Remover</button>
						</div>
					</div>
				</div>
				<% } %>
			</div>
		</form>
	<%}%>
	
	<script>
		function remover( id ) {
		      $("#tableForm").append('<input type="hidden" name="alunoId" value="' + id + '" />');
		      $("#tableForm").append('<input type="hidden" name="cmd" value="remover" />');
		      $("#tableForm").submit(); 
		}

		function atualizar( id ) {
		      $("#tableForm").append('<input type="hidden" name="alunoId" value="' + id + '" />');
		      $("#tableForm").append('<input type="hidden" name="cmd" value="atualizar" />');
		      $("#tableForm").submit(); 
		}		
	</script>
</body>
</html>