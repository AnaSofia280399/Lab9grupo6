
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.PaisB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.lang.Boolean" scope="request" id="ordenada"/>


<%
    ArrayList<PaisB> lista = (ArrayList<PaisB>) request.getAttribute("listaPaises");

%>
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
            <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista de Paises del Consorcio<%=ordenada ? " Ordenadas por Continente" : ""%>
                    </h1>
                </div>
                <%=ordenada ? "" : "<a class='btn btn-light mr-3' href='" + request.getContextPath() + "/paises?order=on' >Ordenar por Continente</a>"%>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                        <thead>
                            <tr>
                                <th>NOMBRE </th>
                                <th>POBLACION</th>
                                <th>TAMAÑO EN MILLONES</th>
                                <th>CONTINENTE</th>
                                <th>Editar</th>
                            </tr>
                        </thead>
                        <%
                            for(PaisB paises : lista){
                        %>
                        <tbody>
                            <tr>
                                <td><%=paises.getNombrePais()%>
                                </td>
                                <td><%=paises.getPoblacion()%>
                                </td>
                                <td><%=paises.getTamaño()%>
                                </td>
                                <td><%=paises.getContinenteB().getNombreContinente()%>
                                </td>
                                <td><a href="<%=request.getContextPath()%>/paises?action=editar&id=<%=paises.getIdPais()%>"
                                       type="button" class="btn btn-primary">
                                    <i class="bi bi-pencil-square"></i>
                                </a></td>
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


