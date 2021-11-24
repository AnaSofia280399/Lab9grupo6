<%@ page import="beans.UniversidadB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<beans.UniversidadB>" scope="request" id="listaUniversidades"/>
<jsp:useBean type="java.lang.Boolean" scope="request" id="filtro"/>
<html>
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Lista de Universidades"/>
    </jsp:include>
    <body>
        <div class='container'>
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value="universidades"/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
                <div class="col-lg-6">
                    <h1 class='text-light'>Lista <%=filtro ? "Filtro " : ""%>de Universidades</h1>
                </div>
            </div>
            <div class="tabla">
                <table class="table table-dark table-transparent table-hover">
                    <thead>
                        <th>UNIVERSIDAD</th>
                        <th>RANKING</th>
                        <th>PAIS</th>
                        <th>CONTINENTE</th>
                        <th>FOTO</th>
                    </thead>
                    <%
                        for (UniversidadB uni : listaUniversidades) {
                    %>
                    <tr class="<%=uni.getPais_idPais().getContinente_idContinente().colorF()%>">
                        <td><%=uni.getNombre()%>
                        </td>
                        <td><%=uni.getRanking()%>
                        </td>
                        <td><%=uni.getPais_idPais().getNombre()%>
                        </td>
                        <td><%=uni.getPais_idPais().getContinente_idContinente().getNombre()%>
                        </td>
                        <td><%=uni.getUrl_foto()%>
                        </td>
                        <td>
                            <a href="<%=request.getContextPath()%>/alumnos?action=formEditar&id=<%=uni.getIdUniversidad()%>"
                               type="button" class="btn btn-primary">Mostrar alumnos
                                <i class="bi bi-pencil-square"></i>
                            </a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </table>

                <tr class="fila-red"...>

            </div>

        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>