<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1" />
    <title>Index</title>

    <!-- Llamado a boostrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous" />
</head>

<body>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark" >
        <a style="border: none;" class="navbar-brand" href="#">PSegurito</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <!-- Datos Administrador -->

                <li class="nav-item dropdown">


                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Datos Administrador
                    </a>


                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="profesional" target="myFrame">Control Profesional</a>
                        <a class="dropdown-item" href="cliente" target="myFrame">Control Cliente</a>
                        <a class="dropdown-item" href="nuevafactura" target="myFrame">Facturacion Clientes</a>
                    </div>
                </li>

                <!-- Detalle Profesional -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Datos Profesional
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="nuevaactividadmejora" target="myFrame">Ingresar Actividad a mejorar</a>
                        <a class="dropdown-item" href="nuevaasesoria" target="myFrame">Agendar Asesoria</a>
                        <a class="dropdown-item" href="#" target="myFrame">Agendar Capacitacion</a>
                        <a class="dropdown-item" href="listadoreporteaccidente" target="myFrame">Revisar Accidentes</a>
                        <a class="dropdown-item" href="listadofactura" target="myFrame">Revisar Facturacion de clientes</a>
                    </div>
                </li>
                <!-- Detalle Cliente -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Datos Cliente
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="listadoactividadesmejora" target="myFrame">Actividades a mejorar</a>
                        <a class="dropdown-item" href="listadoasesoria" target="myFrame">Revisar Asesorias</a>
                        <a class="dropdown-item" href="#" target=" myFrame">Revisar Capacitaciones</a>
                        <a class="dropdown-item" href="nuevoreporteaccidente" target="myFrame">Reportar Accidente</a>
                        <a class="dropdown-item" href="listadofactura" target="myFrame">Facturacion</a>
                    </div>
                </li>
            </ul>
            <!--Boton cerrar sesion  -->
            <div class="dropdown">
                <button class="btn btn-info dropdown-toggle" type="button" id="dropdownMenuButton"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Cerrar Sesion
                </button>
                <div class="dropdown-menu text-center">
                    <a class="dropdown-item" href="#">
                        <img src="#" alt="60" width="60" />
                    </a>
                    <a class="dropdown-item" href="#">${rol}</a>
                    <a class="dropdown-item" href="#">${nickname}</a>
                    <div class="dropdown-divider"></div>
                    <form action="CerrarSesion" method="Post">
                        <button name="accion" value="Salir" class="dropdown-item" href="#">
                            Salir
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </nav>
    <div class="m-4" style="height:800px;">
        <iframe name="myFrame" style="height: 70%; width: 100%; border: none;">
        </iframe>
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