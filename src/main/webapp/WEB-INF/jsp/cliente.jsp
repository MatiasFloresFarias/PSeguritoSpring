<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Registro Cliente</title>
	<!-- Css de boostrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="https://trentrichardson.com/examples/timepicker/jquery-ui-timepicker-addon.css">
</head>

<body>
	<div class="d-sm-flex">
		<div class="card col-sm-4">
			<div class="card-body">
				<form:form method="post" action="guardarcliente">
					<div class="form-group">
						<label>Nombre Empresa:
						</label>
						<form:input path="nombreEmpresa" class="form-control"/>
					</div>
					<div class="form-group">
						<label>Rut:
						</label>
						<form:input path="rut" class="form-control"/>
					</div>
					<div class="form-group">
						<label>Fecha Registro:
						</label>
						<form:input path="fechaRegistro" class="form-control" id="datetimepicker"/>
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
						<th>Nombre Empresa</th>
						<th>Rut</th>
						<th>Fecha Registro</th>
					</tr>
				</thead>
				</tbody>
				<c:forEach items='${listadocliente}' var='cliente'>
					<tr>
						<td>${cliente.getNombreEmpresa()}</td>
						<td>${cliente.getRut()}</td>
						<td>${cliente.getFechaRegistro()}</td>
						<td>
							<a class="btn btn-warning"
								href="${pageContext.request.contextPath}/editarcliente/${cliente.getId_cliente()}">Editar</a>
							<a class="btn btn-danger"
								href="${pageContext.request.contextPath}/eliminarcliente/${cliente.getId_cliente()}">Eliminar</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
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
			<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<script src="https://trentrichardson.com/examples/timepicker/jquery-ui-timepicker-addon.js"></script>
				<script>
			$(function () {
				$('#datetimepicker').datepicker({
					dateFormat: 'dd/mm/yy',
				});
			});
		</script>
</body>

</html>