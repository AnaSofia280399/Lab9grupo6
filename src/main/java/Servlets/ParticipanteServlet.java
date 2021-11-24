package Servlets;

import beans.AlumnoB;
import beans.ParticipanteB;
import daos.ParticipanteDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "participanteServlet", value = "/participantes")
public class ParticipanteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");

        ParticipanteDao partipanteDao = new ParticipanteDao();
        RequestDispatcher view;

        switch (action){

            case "lista":

                ArrayList<ParticipanteB> listaParticipantes = partipanteDao.obtenerListaParticipantes();
                request.setAttribute("lista", listaParticipantes);
                view = request.getRequestDispatcher("listaParticipantes.jsp");
                view.forward(request, response);
                break;

            case "crear":
                break;

            case "editar":
                break;


        }



    }

}
