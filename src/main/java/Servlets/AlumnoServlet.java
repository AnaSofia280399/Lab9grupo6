package Servlets;

import beans.AlumnoB;
import beans.ParticipanteB;
import beans.UniversidadB;
import daos.AlumnoDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AlumnoServlet", urlPatterns = {"/alumnos"})
public class AlumnoServlet  extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");


        AlumnoDao alumnoDao = new AlumnoDao();
        RequestDispatcher view;
        switch (action){
            case "guardar":

                AlumnoB alumnoB = new AlumnoB();

                alumnoB.setCodigo(Integer.parseInt(request.getParameter("codigo")));
                alumnoB.setPromedio(Integer.parseInt(request.getParameter("promedio")));
                UniversidadB universidadB = new UniversidadB();
                universidadB.setIdUniversidad(Integer.parseInt(request.getParameter("idU")));
                alumnoB.setUniversidad_idUniversidad(universidadB);
                ParticipanteB participanteB = new ParticipanteB();
                participanteB.setIdParticipante(Integer.parseInt(request.getParameter("Participante_idParticipante")));
                alumnoB.setIdParticipante(participanteB);

                ArrayList<AlumnoB> listaAlumnos = alumnoDao.obtenerListaAlumnosGeneral();
                boolean evaluar = false;
                int cod = Integer.parseInt(request.getParameter("codigo"));
                for(AlumnoB alu: listaAlumnos){
                   if(alu.getCodigo() == cod ){
                       evaluar = true;
                       break;
                   }
                }
                if (!request.getParameter("codigo").equalsIgnoreCase("")
                    &&!request.getParameter("promedio").equalsIgnoreCase("")
                    &&!request.getParameter("Participante_idParticipante").equalsIgnoreCase("")
                        && evaluar == false)  {
                    alumnoDao.crearAlumno(alumnoB);
                }else {
                    int idUni = Integer.parseInt(request.getParameter("idU"));
                    int idPais =  alumnoDao.ObtenerIdpais(idUni);

                    request.setAttribute("idU2", idUni);
                    ArrayList<ParticipanteB> participantes1 = alumnoDao.obtenerListaParticipantesAgregar(idPais);
                    request.setAttribute("lista", participantes1);

                    view = request.getRequestDispatcher("/agregarAlumno.jsp");
                    view.forward(request,response);

                }

                int Iduni0 = Integer.parseInt(request.getParameter("idU"));
                response.sendRedirect(request.getContextPath()+"/alumnos?idU="+Iduni0);

                break;

            case "actualizar":
                AlumnoB alumnoB1 = new AlumnoB();
                alumnoB1.setIdAlumno(Integer.parseInt(request.getParameter("id")));
                alumnoB1.setCodigo(Integer.parseInt(request.getParameter("codigo")));
                alumnoB1.setPromedio(Integer.parseInt(request.getParameter("promedio")));
                alumnoB1.setCondicion(request.getParameter("condicion"));

                if (!request.getParameter("codigo").equalsIgnoreCase("")
                        &&!request.getParameter("promedio").equalsIgnoreCase("")
                        &&!request.getParameter("condicion").equalsIgnoreCase("")){
                    alumnoDao.ActualizarAlumno(alumnoB1);
                } else {

                    request.setAttribute("alumno", alumnoB1);
                    view=request.getRequestDispatcher("/editarAlumno.jsp");
                    view.forward(request,response);
                }
                int Iduni3 = Integer.parseInt(request.getParameter("idU"));
                response.sendRedirect(request.getContextPath()+"/alumnos?idU="+Iduni3);

                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");

        AlumnoDao alumnoDao = new AlumnoDao();

        RequestDispatcher view;


        switch (action) {
            case "lista":


                int idUniversidad = Integer.parseInt(request.getParameter("idU"));
                request.setAttribute("idU2", idUniversidad);
                ArrayList<AlumnoB> listaAlumnos = alumnoDao.obtenerListaAlumnos(idUniversidad);
                request.setAttribute("lista", listaAlumnos);
                view = request.getRequestDispatcher("listaAlumnos.jsp");
                view.forward(request, response);
                break;
            case "crear":

                int idUni = Integer.parseInt(request.getParameter("idU"));
                int idPais =  alumnoDao.ObtenerIdpais(idUni);

                request.setAttribute("idU2", idUni);
                ArrayList<ParticipanteB> participantes1 = alumnoDao.obtenerListaParticipantesAgregar(idPais);
                request.setAttribute("lista", participantes1);

                view = request.getRequestDispatcher("/agregarAlumno.jsp");
                view.forward(request,response);

                break;
            case "editar":

                int id = Integer.parseInt(request.getParameter("id"));
                AlumnoB alumnoB3 = alumnoDao.buscarAlumno(id);


                if(alumnoB3 != null){


                    request.setAttribute("alumno", alumnoB3);
                    view = request.getRequestDispatcher("/editarAlumno.jsp");
                    view.forward(request, response);
                }else{
                    int idU1 = Integer.parseInt(request.getParameter("idU"));

                    response.sendRedirect(request.getContextPath()+"/alumnos?idU="+idU1);
                }
                break;

            case "eliminar":

                int id3 = Integer.parseInt(request.getParameter("id"));
                AlumnoB alumnoB4 = alumnoDao.buscarAlumno(id3);
                if (alumnoB4 != null){
                    alumnoDao.AlumnoEliminable(alumnoB4);
                }

                int Iduni = Integer.parseInt(request.getParameter("idU"));

                response.sendRedirect(request.getContextPath()+"/alumnos?idU="+Iduni);
                break;
            case "borrar":
                int id2 = Integer.parseInt(request.getParameter("id"));

                if( alumnoDao.buscarAlumno(id2)  != null){
                    alumnoDao.borrarAlumno(id2);
                }

                int Iduni2 = Integer.parseInt(request.getParameter("idU"));
                response.sendRedirect(request.getContextPath()+"/alumnos?idU="+Iduni2);
                break;
        }
    }



}
