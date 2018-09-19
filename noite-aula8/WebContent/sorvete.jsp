<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="edu.entidade.Sorvete, java.util.List, java.util.ArrayList"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Gestão de Sorvetes</title>
	<link rel="stylesheet" href="./css/bootstrap.min.css"/>
	<script src="./js/bootstrap.min.js"></script>
	<script src="./js/jquery-3.3.1.min.js"></script>
	<script>
		function remover( id ) {
			if (confirm("Remove o sorvete com id " + id)) {
				$('#formSorvete').empty();
				$('#formSorvete').append('<input type="hidden" name="txtId" value="' + id + '"/>');
				$('#formSorvete').append('<input type="hidden" name="cmd" value="remover"/>');
				$('#formSorvete').submit();
			}
		}

		function editar( id ) {
			$('#formSorvete').empty();
			$('#formSorvete').append('<input type="hidden" name="txtId" value="' + id + '"/>');
			$('#formSorvete').append('<input type="hidden" name="cmd" value="editar"/>');
			$('#formSorvete').submit();
		}		
	</script>
</head>
<body>
	<h2>Gestão de Sorvetes</h2>
	
	<%  String msg = (String)session.getAttribute("MENSAGEM");
		List<Sorvete> lista = (List<Sorvete>)session.getAttribute("LISTA");
	   if (lista == null) { 
	   	   lista = new ArrayList<Sorvete>();
	   } else { 
		   session.setAttribute("LISTA", null);
	   }
	   
	   Sorvete sorveteAtual = (Sorvete)session.getAttribute("SORVETE_ATUAL");
	   if (sorveteAtual == null) { 
		   sorveteAtual = new Sorvete();
	   } else { 
		   session.setAttribute("SORVETE_ATUAL", null);
	   }
	   
	   if (msg != null) {
		   session.setAttribute("MENSAGEM", null);
	%>
			<h3 class="alert alert-danger"><%=msg%></h3>
	<% } %>
	
	
	<form id="formSorvete" action="./SorveteController" method="post">
		<div class="container">
			<div class="form-group">
    			<label for="txtId">Id</label>
    			<input type="text" class="form-control" id="txtId" name="txtId" value="<%=sorveteAtual.getId()%>" readonly/>
  			</div>
			<div class="form-group">
    			<label for="txtSabor">Sabor</label>
    			<input type="text" class="form-control" id="txtSabor" name="txtSabor" value="<%=sorveteAtual.getSabor()%>"/>
  			</div>  	
			<div class="form-group">
    			<label for="txtPreco">Preço</label>
    			<input type="text" class="form-control" id="txtPreco" name="txtPreco" value="<%=sorveteAtual.getPreco()%>"/>
  			</div>   	
			<div class="form-group">
    			<label for="txtTipo">Tipo do Sorvete</label>
    			<select class="form-control" id="txtTipo" name="txtTipo">
      				<option value="massa2k">Massa 2Kg</option>
      				<option value="massa1k">Massa 1Kg</option>
      				<option value="massa250">Massa 250g</option>
				    <option value="picole">Picole</option>
				</select>
			</div>
			<div class="form-check form-check-inline">
  				<input class="form-check-input" type="radio" name="txtCobertura" id="txtCobertura" value="choc">
  				<label class="form-check-label" for="txtCobertura">Chocolate</label>
			</div>				
			<div class="form-check form-check-inline">
  				<input class="form-check-input" type="radio" name="txtCobertura" id="txtCobertura" value="mor">
  				<label class="form-check-label" for="txtCobertura">Morango</label>
			</div>										
			<div class="form-check form-check-inline">
  				<input class="form-check-input" type="radio" name="txtCobertura" id="txtCobertura" value="car">
  				<label class="form-check-label" for="txtCobertura">Caramelo</label>
			</div>	
			<div class="form-group">
				<%if (sorveteAtual.getId() == 0) { %>
					<button type="submit" class="btn btn-primary" name="cmd" value="adicionar">Adicionar</button>
				<%} else { %>
					<button type="submit" class="btn btn-primary" name="cmd" value="salvar">Salvar</button>
				<%} %>
				<button type="submit" class="btn btn-primary" name="cmd" value="pesquisar">Pesquisar</button>
			</div>																		
		</div>
		<div class="container">
			<table class="table table-striped">
				<tbody>
					<% for (Sorvete s : lista) { %>
					<tr>
						<td><%=s.getId()%></td>
						<td><%=s.getSabor()%></td>
						<td><%=s.getTipo()%></td>
						<td><%=s.getPreco()%></td>
						<td><%=s.getCobertura()%></td>
						<td>
							<div class="form-group">
								<button type="button" class="btn btn-primary" onclick="remover(<%=s.getId()%>);">Remover</button>
								<button type="button" class="btn btn-primary" onclick="editar(<%=s.getId()%>);">Editar</button>
							</div>																		
						</td>
					</tr>
					<% } %>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>