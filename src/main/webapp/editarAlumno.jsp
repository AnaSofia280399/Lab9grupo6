<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.AlumnoB" %>
<%@ page import="daos.AlumnoDao" %>
<%@ page import="beans.ParticipanteB" %>


<%
    AlumnoB alumnoB = (AlumnoB) request.getAttribute("alumno") ;

%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'/>
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/static/uni.ico" type="image/x-icon">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <title>Lista Alumnos
        </title>
    </head>
    <body>
        <div class='container'>


            <div class="mt-2 text-center">
                <h1>Editar Alumnos</h1>
            </div>
            <div class="d-flex justify-content-center">
                <div class="w-75">
                    <form method="POST" action="<%= request.getContextPath()%>/alumnos?action=actualizar">
                        <input type="hidden" class="form-control" name="id" value="<%= alumnoB.getIdAlumno()%>">
                        <input type="hidden" class="form-control" name="idU" value="<%= alumnoB.getUniversidad_idUniversidad().getIdUniversidad()%>">


                        <div class="form-group">
                            <label >Alumno</label>
                            <input class="form-control" type="text" disabled   value="<%= alumnoB.getIdParticipante().getNombre() +" "+ alumnoB.getIdParticipante().getApellido()%>">
                        </div>

                        <div class="form-group">
                            <label >Edad</label>
                            <input class="form-control" type="text" disabled   value="<%= alumnoB.getIdParticipante().getEdad()%>">
                        </div>
                        <div class="form-group">
                            <label >Código de Alumno</label>
                            <input class="form-control" type="text" name="codigo" value="<%= alumnoB.getCodigo() == 0  ? "" : alumnoB.getCodigo()%>" >
                        </div>
                        <div class="form-group">
                            <label >Promedio</label>
                            <input class="form-control" type="text" name="promedio" value="<%= alumnoB.getPromedio() == 0  ? "" : alumnoB.getPromedio()%>" >
                        </div>
                        <div class="form-group">
                            <label >Condición</label>
                            <select class="form-control" name="condicion">
                                <option value="E">Eliminado</option>
                                <option value="N">Normal</option>
                            </select>
                        </div>

                        <button type="submit" class="btn btn-primary">Enviar</button>
                        <a class="btn btn-danger" href="<%= request.getContextPath()%>/alumnos&idU=<%= alumnoB.getUniversidad_idUniversidad().getIdUniversidad()%>">Cancelar</a>
                    </form>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
                crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
                crossorigin="anonymous"></script>
    </body>
</html>
