<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 23/11/2021
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="pais" type="beans.PaisB" scope="request" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Paises"/>
    </jsp:include>

    <head>
        <title>Lista de Paises</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.0/font/bootstrap-icons.css">
    </head>
    <body>
        <div class='container'>

            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="paises"/>
            </jsp:include>

            <div class="mt-2 text-center">
                <h1>Editar <%=pais.getNombrePais()%></h1>
            </div>
            <div class="d-flex justify-content-center">
                <div class="w-75">
                    <form method="POST" action="<%= request.getContextPath()%>/paises?action=editar">
                        <input type="hidden" class="form-control" name="id" value="<%= pais.getIdPais()%>">

                       <div class="form-group">
                            <label >Nombre del Pais</label>
                            <input class="form-control" type="text" name="nombre" value="<%= pais.getNombrePais()%>" >
                        </div>
                        <div class="form-group">
                            <label >Poblacion</label>
                            <input class="form-control" type="text" name="poblacion" value="<%=pais.getPoblacion()%>" >
                        </div>
                        <div class="form-group">
                            <label >Tamaño</label>
                            <input class="form-control" type="text" name="tamano" value="<%=pais.getTamaño()%>" >
                        </div>
                        <div class="form-group">
                            <label >Continente al que pertenece</label>
                            <input class="form-control" type="text" name="continente" value="<%=pais.getContinenteB().getNombreContinente()%>" >
                        </div>

                        <button type="submit" class="btn btn-primary mr-2">Enviar</button>
                        <a class="btn btn-danger ml-2 " href="<%= request.getContextPath()%>/paises">Cancelar</a>
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
