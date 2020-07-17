<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Profesional</title>
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
					<form:form method="post" action="../guardareditprofesional">
						<div class="form-group">
							<label>Nombre: </label><br>
							<form:input path="nombre" class="form-control"/>
						</div>
						<div class="form-group">
							<label>Apellido:</label><br>
							<form:input path="apellido" class="form-control" />
						</div>
						<div>
							<label>Correo:</label><br>
							<form:input path="correo" class="form-control" />
						</div>
						<div>
							<label>Telefono:</label><br>
							<form:input path="telefono" class="form-control" />
						</div>
						<div>
							<label>Cargo:</label><br>
							<form:input path="cargo" class="form-control" />
						</div>							
								<form:hidden path="id_profesional"/>
								<input class="btn btn-info" type="submit" value="Editar profesional" />

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