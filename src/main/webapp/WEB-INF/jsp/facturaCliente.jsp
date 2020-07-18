<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Listado de facturas</title>
	<!-- Css de boostrap -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>

	<body>

		<div class="col-sm-12">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Fecha de cobro</th>
						<th>Fecha de vencimiento</th>
						<th>Extras</th>
						<th>Impuestos</th>
						<th>Subtotales</th>
						<th>Total</th>
						<th>Cliente</th>
					</tr>
				</thead>
				</tbody>
				<c:forEach items='${listadofactura}' var='factura'>
					<tr>
						<td>${factura.getFechadecobro()}</td>
						<td>${factura.getFechaVencimiento()}</td>
						<td>${factura.getExtras()}</td>
						<td>${factura.getImpuestos()}</td>
						<td>${factura.getSubtotal()}</td>
						<td>${factura.getTotal()}</td>
						<td>${factura.getCliente().getNombreEmpresa()}</td>
						<td>
							<a class="btn btn-success"
								href="${pageContext.request.contextPath}/ListarDetalleFactura?id=${factura.getId_factura()}">Mas
								Detalles</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
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