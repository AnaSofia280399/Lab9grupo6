<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <!--Colocar como value: nombre de la presente página -->
    <jsp:include page="/static/head.jsp">
        <jsp:param name="title" value="Bienvenido"/>
    </jsp:include>
    <body>
        <div class='container'>
            <!--Colocar como value: artistas, canciones, bandas, tours o tpc  (dependiendo de la pagina a la que corresponda) -->
            <jsp:include page="/includes/navbar.jsp">
                <jsp:param name="page" value=""/>
            </jsp:include>
            <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
                <div class="col-lg-6">
                    <h1 class='text-light'>Bienvenido al Consorcio de Universidades !</h1>
                </div>
            </div>
            <div class="pb-5 pt-4 px-3  d-flex justify-content-between align-items-center">
                <div class="col-lg-6">
                    <h1 style="color: black">Este es un registro de todas las universidades que pertenecen a nuestro consorcio.
                        Esta página a sido creada con el fin de poder mejorar las experiencias de intercambio estudiantil</h1>
                </div>
                <div class="col-lg-6">
                    <img src="https://www.uhipocrates.edu.mx/wp-content/uploads/2019/08/portada-intercambio-estudiantil.jpg" style="border-radius: 15px 50px 30px"  width="500" height="450" />
                </div>

            </div>

        </div>
        <jsp:include page="/static/scripts.jsp"/>
    </body>
</html>
