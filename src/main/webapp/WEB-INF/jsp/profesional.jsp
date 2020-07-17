<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Registro Profesional</title>
	<!-- Css de boostrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body></body>

<body>
	<div class="d-sm-flex">
		<div class="card col-sm-4">
			<div class="card-body">
				<form:form method="post" action="guardarprofesional">
					<div class="form-group">
						<label>Nombre:
						</label>
						<form:input path="nombre" class="form-control"/>
					</div>
					<div class="form-group">
						<label>Apellido:
						</label>
						<form:input path="apellido" class="form-control"/>
					</div>
					<div class="form-group">
						<label>Correo:
						</label>
						<form:input path="correo" class="form-control"/>
					</div>
					<div class="form-group">
						<label>Telefono:
						</label>
						<form:input path="telefono" class="form-control"/>
					</div>
					<div class="form-group">
						<label>Cargo:
						</label>
						<form:input path="cargo" class="form-control"/>
					</div>
					<input type="submit" name="accion" value="Agregar" class="btn btn-info">
					<input type="reset" value="Cancelar" class="btn btn-info">
				</form:form>
			</div>
		</div>
		<div class="col-sm-8">

			<table class="table table-striped">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Correo</th>
						<th>Telefono</th>
						<th>Cargo</th>
					</tr>
				</thead>
				</tbody>
				<c:forEach items='${listadoprofesional}' var='profesional'>
					<tr>
						<td>${profesional.getNombre()}</td>
						<td>${profesional.getApellido()}</td>
						<td>${profesional.getCorreo()}</td>
						<td>${profesional.getTelefono()}</td>
						<td>${profesional.getCargo()}</td>
						<td>
							<a class="btn btn-warning"
								href="${pageContext.request.contextPath}/editarprofesional/${profesional.getId_profesional()}">Editar</a>
							<a class="btn btn-danger"
								href="${pageContext.request.contextPath}/eliminarprofesional/${profesional.getId_profesional()}">Eliminar</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
				</div>
	</div>
</body>

</html>
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