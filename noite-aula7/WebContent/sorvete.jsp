<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Gestão de Sorvetes</title>
	<link rel="stylesheet" href="./css/bootstrap.min.css"/>
	<script src="./js/bootstrap.min.js"></script>
</head>
<body>
	<h2>Gestão de Sorvetes</h2>
	
	<form>
		<div class="container">
			<div class="form-group">
    			<label for="txtId">Id</label>
    			<input type="text" class="form-control" id="txtId" name="txtId" readonly/>
  			</div>
			<div class="form-group">
    			<label for="txtSabor">Sabor</label>
    			<input type="text" class="form-control" id="txtSabor" name="txtSabor"/>
  			</div>  	
			<div class="form-group">
    			<label for="txtPreco">Preço</label>
    			<input type="text" class="form-control" id="txtPreco" name="txtPreco"/>
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
				<button type="submit" class="btn btn-primary">Adicionar</button>
			</div>																		
		</div>
	</form>
</body>
</html>