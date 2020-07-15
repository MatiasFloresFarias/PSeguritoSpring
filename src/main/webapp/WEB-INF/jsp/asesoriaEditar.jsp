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
		Id Profesional: <form:input path="id_profesional" /><br/>
		Id cliente: <form:input path="id_cliente" /><br/>
		<form:hidden path="id_asesoria"/>
		<input type="submit" value="Editar asesoria" />
	</form:form>

</body>
</html>