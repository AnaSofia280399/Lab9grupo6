
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.AlumnoB" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    ArrayList<AlumnoB> lista = (ArrayList<AlumnoB>) request.getAttribute("lista");

%>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'/>
        <link rel="shortcut icon" href="<%=request.getContextPath()%>/static/favicon.png" type="image/x-icon">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
              integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <title>Lista Alumnos
        </title>
    </head>

    <body>
        <div class='container'>

            <div class="mt-2 text-center">
                <h1>Lista de Alumnos</h1>
            </div>

            <div class="d-flex justify-content-center">
                <div class="w-75">

                    <div class="my-2">
                        <a href="<%= request.getContextPath()%>/alumnos?action=crear" class="btn btn-info">Añadir alumno</a>
                    </div>

                    <table class="table table-dark table-transparent table-hover">
                        <thead>
                            <tr>
                                <th>Nombre </th>
                                <th>Apellido</th>
                                <th>Edad</th>
                                <th>Código</th>
                                <th>Promedio</th>
                                <th>Condición</th>
                                <th>Editar</th>
                                <th>Eliminar</th>
                            </tr>
                        </thead>
                        <%
                            for(AlumnoB alu : lista){
                        %>
                        <tbody>
                            <tr>
                                <td style="<%= alu.getColorNombre()%>"><%=alu.getIdParticipante().getNombre()%></td>
                                <td style="<%= alu.getColorNombre()%>"><%=alu.getIdParticipante().getApellido()%></td>
                                <td style="<%= alu.getColorNombre()%>"><%=alu.getIdParticipante().getEdad()%></td>
                                <td style="<%= alu.getColorNombre()%>"><%=alu.getCodigo()%></td>
                                <td style="<%= alu.getColorNombre()%>" ><%=alu.getPromedio()%></td>
                                <td style="<%= alu.getColorNombre()%>"><%=alu.getCondicion()%></td>
                                <td><a href="<%= request.getContextPath()%>/alumnos?action=editar&id=<%=alu.getIdAlumno()%>" class="btn btn-primary"><span class="fa fa-edit"></span></a></td>
                                <td><%=  alu.EliminaroNo() ? "<a class='btn btn-danger' href='"+request.getContextPath()+ "/alumnos?action=eliminar&id="+alu.getIdAlumno()+"&idU="+alu.getUniversidad_idUniversidad().getIdUniversidad()+"' > Eliminar</a>"
                                        : "<a class='btn btn-danger' href='"+request.getContextPath()+ "/alumnos?action=borrar&id="+alu.getIdAlumno()+"&idU="+alu.getUniversidad_idUniversidad().getIdUniversidad()+"' > Borrar</a>" %></td>
                            </tr>
                        </tbody>
                        <%

                            }
                        %>
                    </table>
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
