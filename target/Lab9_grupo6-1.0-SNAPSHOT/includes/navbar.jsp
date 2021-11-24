<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Consorcio VIP</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor02">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Principal
                        <span class="visually-hidden"></span>
                    </a>
                </li>
                <li class="nav-item">
                    <a a class="nav-link <%=request.getParameter("page").equals("paises")? "active": "" %>" href="<%=request.getContextPath()%>/paises">Paises</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Participantes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Universidades</a>
                </li>

            </ul>

        </div>
    </div>
</nav>