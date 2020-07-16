<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear asesoria</title>
</head>
<body>

	<h1>Crear asesoria</h1>

	<form:form method="post" action="guardarasesoria">
		Fecha y Hora: <form:input path="fechayhora" /><br/>
		Motivo: <form:input path="motivo" /><br/>
		Detalle: <form:input path="detalle" /><br/>
		Profesional: <form:select path="profesional.id_profesional"><form:options items="${listadoprofesional}" itemValue="id_profesional" itemLabel="nombreyapellido"></form:options>
		</form:select><br/>
		Cliente: <form:select path="cliente.id_cliente"><form:options items="${listadocliente}" itemValue="id_cliente" itemLabel="nombreEmpresa"></form:options>
		</form:select><br/>
		<input type="submit" value="Guardar asesoria" />
	</form:form>

</body>
</html>