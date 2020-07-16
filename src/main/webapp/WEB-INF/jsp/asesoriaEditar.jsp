<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar asesoria</title>
</head>
<body>

	<h1>Editar asesoria</h1>

	<form:form method="post" action="../guardareditasesoria">
		Fecha y Hora: <form:input path="fechayhora" /><br/>
		Motivo: <form:input path="motivo" /><br/>
		Detalle: <form:input path="detalle" /><br/>
		Profesional: <form:select path="profesional.id_profesional">
		<form:options items="${listadoprofesional}" itemValue="id_profesional" itemLabel="nombreyapellido"></form:options>
		</form:select><br/> 
		Cliente: <form:select path="cliente.id_cliente"><form:options items="${listadocliente}" itemValue="id_cliente" itemLabel="nombreEmpresa"></form:options>
		</form:select><br/>
		<form:hidden path="id_asesoria"/>
		<input type="submit" value="Editar asesoria" />
	</form:form>

</body>
</html>