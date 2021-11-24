
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.AlumnoB" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    ArrayList<AlumnoB> lista = (ArrayList<AlumnoB>) request.getAttribute("lista");

%>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Alumnos"/>
    </jsp:include>

    <head>
        <title>Lista de Alumnos</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.0/font/bootstrap-icons.css">

    </head>

    <body>
        <div class='container'>

            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="alumnos"/>
            </jsp:include>

            <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
                <div class="col-lg-6">
                    <h1 class='text-light'> Lista de Alumnos
                    </h1>
                </div>

                <div class="my-2">
                    <a href="<%= request.getContextPath()%>/alumnos?action=crear" class="btn btn-info">Añadir alumno</a>
                </div>
            </div>

            <div >
                <div >



                    <div class="tabla">
                        <table class="table table-dark table-transparent table-hover">
                            <thead>
                                <tr>
                                    <th>NOMBRE </th>
                                    <th>APELLIDO</th>
                                    <th>EDAD</th>
                                    <th>CODIGO</th>
                                    <th>PROMEDIO</th>
                                    <th>CONDICION</th>
                                    <th>EDITAR</th>
                                    <th>ELIMINAR</th>
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
                                    <td><a href="<%= request.getContextPath()%>/alumnos?action=editar&id=<%=alu.getIdAlumno()%>" class="btn btn-primary"><i class="bi bi-pencil-square"></i></a></td>
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
