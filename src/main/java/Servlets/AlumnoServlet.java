package Servlets;

import beans.AlumnoB;
import beans.UniversidadB;
import daos.AlumnoDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
                AlumnoB alumnoB2 = new AlumnoB();
                alumnoB2.setIdAlumno(Integer.parseInt(request.getParameter("id")));
                alumnoB2.setCodigo(Integer.parseInt(request.getParameter("codigo")));
                alumnoB2.setPromedio(Integer.parseInt(request.getParameter("promedio")));
                UniversidadB universidadB = new UniversidadB();
                universidadB.setIdUniversidad(Integer.parseInt("idU"));
                alumnoB2.setUniversidad_idUniversidad(universidadB);


                if (!request.getParameter("codigo").equalsIgnoreCase("")
                        &&!request.getParameter("promedio").equalsIgnoreCase("")
                        &&!request.getParameter("condicion").equalsIgnoreCase("")
                        &&!request.getParameter("idU").equalsIgnoreCase("")){
                    alumnoDao.agregarAlumno(alumnoB2);
                } else {

                    request.setAttribute("alumno", alumnoB2);
                    view=request.getRequestDispatcher("/agregarAlumno.jsp");
                    view.forward(request,response);
                }
                int Iduni7 = Integer.parseInt(request.getParameter("idU"));
                response.sendRedirect(request.getContextPath()+"/alumnos?idU="+Iduni7);

                /*AlumnoB alumnoB = new AlumnoB();

                alumnoB.setUniversidad_idUniversidad("Universidad_idUniversidad");
                alumnoB.setCodigo(Integer.parseInt(request.getParameter("codigo")));
                alumnoB.setPromedio(Integer.parseInt(request.getParameter("promedio")));


                Cancion cancion1 = new Cancion();
                cancion1.setNombreCancion(request.getParameter("nombre_cancion"));
                cancion1.setIdAlbum(Integer.parseInt(request.getParameter("id_album")));

                ArrayList<Cancion> listacancion = cancionDao.obtenerListaCanciones();
                boolean evaluar = false;
                for (Cancion c : listacancion){
                    if (c.getNombreCancion().equalsIgnoreCase(request.getParameter("nombre_cancion")) ){
                        evaluar = true;
                        break;
                    }
                }
                if (!request.getParameter("nombre_cancion").equalsIgnoreCase("")
                        &&!request.getParameter("id_album").equalsIgnoreCase("")
                        && evaluar == false) {
                    cancionDao.crearCancion(cancion1);
                } else {
                    ArrayList<Album> albums = cancionDao.obtenerListaAlbum();
                    request.setAttribute("lista", albums);
                    view = request.getRequestDispatcher("/crearCanciones.jsp");
                    view.forward(request, response);
                }
                response.sendRedirect(request.getContextPath()+"/canciones");

                break; */

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
                ArrayList<AlumnoB> listaAlumnos = alumnoDao.obtenerListaAlumnos(idUniversidad);
                request.setAttribute("lista", listaAlumnos);
                view = request.getRequestDispatcher("listaAlumnos.jsp");
                view.forward(request, response);
                break;
            case "crear":


                int idPais = 41;

                ArrayList<AlumnoB> alumnos = alumnoDao.obtenerListaAlumnosAgregar(idPais);
                request.setAttribute("lista", alumnos);

                view = request.getRequestDispatcher("/agregarAlumno.jsp");
                view.forward(request,response);

                break;
            case "editar":

                int id = Integer.parseInt(request.getParameter("id"));
                AlumnoB alumnoB3 = alumnoDao.buscarAlumno(id);


                if(alumnoB3 != null){

                   // request.setAttribute("idU", Iduni6);
                    request.setAttribute("alumno", alumnoB3);
                    view = request.getRequestDispatcher("/editarAlumno.jsp");
                    view.forward(request, response);
                }else{
                    response.sendRedirect(request.getContextPath()+"/alumnos");
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
