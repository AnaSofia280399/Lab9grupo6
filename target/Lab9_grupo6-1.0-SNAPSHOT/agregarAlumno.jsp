
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.ParticipanteB" %>
<%@ page import="daos.AlumnoDao" %>
<%@ page import="beans.AlumnoB" %>

<%
    ArrayList<ParticipanteB> lista = (ArrayList<ParticipanteB>) request.getAttribute("lista");
    Integer idU2 = (Integer) request.getAttribute("idU2");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Agregar Alumno"/>
    </jsp:include>
    <head>
        <title>Agregar Alumno</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/cuadro_editar.css">

    </head>
    <body>
        <div class='container'>

            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="alumnos"/>
            </jsp:include>

            <section class="formulario mt-3" >

            <div class="mt-2 text-center">
                <h1>Crear Alumno</h1>
            </div>
            <div class="d-flex justify-content-center">
                <div class="w-75">
                    <form method="POST" action="<%=request.getContextPath()%>/alumnos?action=guardar">
                        <input type="hidden" class="form-control" name="idU" value="<%= idU2%>">

                        <div class="form-group">
                            <label>Alumno</label>
                            <select name="Participante_idParticipante" class="form-control">
                                <% for (ParticipanteB participanteB: lista ) {%>
                                <option value="<%=participanteB.getIdParticipante() %>"><%=participanteB.getNombre()+" "+ participanteB.getApellido()%></option>
                                <% }%>
                            </select>

                        </div>
                        <div class="form-group">
                            <label >Promedio</label>
                            <input class="form-control" type="text" name="promedio">
                        </div>
                        <div class="form-group">
                            <label >Código</label>
                            <input class="form-control" type="text" name="codigo">
                        </div>
                        <button type="submit" class="btn btn-primary">Enviar</button>
                        <a class="btn btn-danger" href="<%= request.getContextPath()%>/alumnos&idU=<%= idU2%>">Cancelar</a>
                    </form>
                </div>
            </div>

            </section>
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
