package Servlets;

import beans.ContinenteB;
import beans.PaisB;
import daos.PaisDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "PaisServlet", value = "/paises")
public class PaisServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        PaisDao paisDao = new PaisDao();
        RequestDispatcher view;


        switch (action) {
            case "listar":

                String filtro = request.getParameter("order") != null ? request.getParameter("order") :"";
                if (filtro.equals("on")) {
                    request.setAttribute("listaPaises", paisDao.obtenerListaPaisesporContinente());
                    request.setAttribute("ordenada", true);
                } else {
                    request.setAttribute("listaPaises", paisDao.obtenerListaPaises());
                    request.setAttribute("ordenada", false);
                }
                view = request.getRequestDispatcher("/listaPaises.jsp");
                view.forward(request, response);
                break;

            case "crear":
                view = request.getRequestDispatcher("/agregarPaises.jsp");
                view.forward(request, response);
                break;



            case "editar":

                /*DistritoB distritoB = new DistritoB();

                clienteB = clienteDao.obtenerID(1);
                distritoB = clienteDao.obtenerDistrito(1);


                request.setAttribute("cliente", clienteB);
                request.setAttribute("distrito", distritoB);
                view = request.getRequestDispatcher("/EditarPerfil.jsp");
                view.forward(request, response);
                break;*/

                String idE = request.getParameter("id") != null ? request.getParameter("id") :"";
                PaisB paisE = paisDao.obtenerID(idE);

                if (paisE!= null) {
                    request.setAttribute("pais", paisE);
                    RequestDispatcher view3 = request.getRequestDispatcher("/editarPaises.jsp");
                    view3.forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/paises");
                }
                break;


            case "borrar":
                // String id = request.getParameter("id") != null ? request.getParameter("id") : "";
                // PaisB paisB = paisDao.obtenerID(id);
                //  if (paisB != null) { //borramos
                //    try {
                //      paisDao.borrarPais(id);
                //jobDao.borrarTrabajoLogico(id);
                //    response.sendRedirect(request.getContextPath() + "/JobServlet?msg=be");
                //        } catch (SQLException e) {
                //          response.sendRedirect(request.getContextPath() + "/JobServlet?err=ber");
                //      e.printStackTrace();
                //   }
                // } else { //el jobId no existe
                //    response.sendRedirect(request.getContextPath() + "/JobServlet?err=ber");
                // }

                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") != null ? request.getParameter("action") : "crear";

        PaisDao paisDao = new PaisDao();

        switch (action) {


            case "crear":
                String idPais = request.getParameter("idPais") != null ? request.getParameter("idPais") : "";
                String nombrePais = request.getParameter("nombrePais") != null ? request.getParameter("nombrePais") : "";
                String poblacion = request.getParameter("poblacion") != null ? request.getParameter("poblacion") : "";
                String tamano = request.getParameter("tamano") != null ? request.getParameter("urlBanda") : "";
                String continente = request.getParameter("continente") != null ? request.getParameter("continente"):"";
                int idPaisStr = Integer.parseInt(idPais);



                paisDao.crearPais(idPaisStr, nombrePais, poblacion, tamano,paisDao.obtenerIDContinente(continente));

                response.sendRedirect(request.getContextPath() + "/paisesServlet?msg=ce");
                break;
            case "editar":
                String idPais2 = request.getParameter("id") != null ? request.getParameter("id") : "";
                String nombrePais2 = request.getParameter("nombre") != null ? request.getParameter("nombre") : "";
                String poblacion2 = request.getParameter("poblacion") != null ? request.getParameter("poblacion") : "";
                String tamano2 = request.getParameter("tamano") != null ? request.getParameter("tamano") : "";
                String continente2 = request.getParameter("continente") != null ? request.getParameter("continente"):"";
                int idPaisStr2 = Integer.parseInt(idPais2);

                paisDao.editarPais(idPaisStr2, nombrePais2, tamano2, poblacion2,paisDao.obtenerIDContinente(continente2));
                response.sendRedirect(request.getContextPath() + "/paises");
                break;

        }
    }
}