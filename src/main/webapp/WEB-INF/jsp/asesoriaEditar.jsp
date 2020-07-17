<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar asesoria</title>
	<!-- Css de boostrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col align-self-start"></div>
			<div class="col-3 align-self-center">
				<h1 class="display-4">Editar </h1>
					<form:form method="post" action="../guardareditasesoria">
						<div class="form-group">
							<label>Fecha y Hora: </label><br>
							<form:input path="fechayhora" class="form-control"/>
						</div>
						<div class="form-group">
							<label>Motivo:</label><br>
							<form:input path="motivo" class="form-control" />
						</div>
						<div>
							<label>Detalle:</label><br>
							<form:input path="detalle" class="form-control" />
						</div>
						<div class="form-group">
							<label>Profesional:</label><br> 
							<form:select path="profesional.id_profesional" class="form-control form-control">
									<form:options items="${listadoprofesional}" itemValue="id_profesional" itemLabel="nombreyapellido"></form:options>
							</form:select>							
						</div>
						<div class="form-group">
							<label>Cliente:</label><br> 
							<form:select path="cliente.id_cliente" class="form-control form-control"><form:options items="${listadocliente}" itemValue="id_cliente" itemLabel="nombreEmpresa"></form:options>
							</form:select>
						</div>		
								
								<form:hidden path="id_asesoria"/>
								<input class="btn btn-info" type="submit" value="Editar asesoria" />

					</form:form>
			</div>
			<div class="col align-self-end"></div>
		</div>
	</div>

			<!-- Jss boostrap -->
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
			integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
			crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
			integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
			crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
			integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
			crossorigin="anonymous"></script>

</body>
</html>