package Servlets;

import beans.UniversidadB;
import daos.UniversidadDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "universidadesServlet", value = "/universidadesServlet")
public class UniversidadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") != null ? request.getParameter("action") : "listar";


        switch (action){
            case "listar":
                String filter = request.getParameter("filter");
                UniversidadDao universidadDao = new UniversidadDao();
                ArrayList<UniversidadB> universidades;

                if (filter == null) {
                    filter = "";
                }
                if (filter.equals("on")) {
                    universidades = universidadDao.ListaUniversidadesXCampo();
                    request.setAttribute("filtro", true);
                } else {
                    universidades = universidadDao.ListaUniversidades();
                    request.setAttribute("filtro", false);
                }

                request.setAttribute("listaUniversidades", universidades);
                RequestDispatcher view = request.getRequestDispatcher("listaUniversidades.jsp");
                view.forward(request, response);
                break;
        }






    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*
        String action = request.getParameter("action") != null ? request.getParameter("action") : "crear";

        UniversidadB
        switch (action){
            case "crear":


                break;
        }*/
    }
}
