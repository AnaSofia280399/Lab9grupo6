package daos;

import beans.AlumnoB;
import beans.PaisB;
import beans.ParticipanteB;
import beans.UniversidadB;

import javax.servlet.http.Part;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AlumnoDao extends BaseDao{
    public ArrayList<AlumnoB> obtenerListaAlumnosGeneral (){
        ArrayList<AlumnoB> listaAlumnos =new ArrayList<>();

        String sql ="SELECT * FROM labgrupo6.alumno ";

        try (Connection connection = getConection();
             PreparedStatement pstmt = connection.prepareStatement(sql);){

            try (ResultSet rs = pstmt.executeQuery();){
                while (rs.next()){
                    AlumnoB alumnoB = new AlumnoB();
                    alumnoB.setIdAlumno(rs.getInt(1));
                    alumnoB.setCodigo(rs.getInt(2));
                    alumnoB.setPromedio(rs.getInt(3));
                    alumnoB.setCondicion(rs.getString(4));



                    listaAlumnos.add(alumnoB);

                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }



        return listaAlumnos;
    }


    public ArrayList<AlumnoB> obtenerListaAlumnos (int id_Universidad){
        ArrayList<AlumnoB> listaAlumnos =new ArrayList<>();

        String sql ="SELECT * FROM alumno a left join participante p on a.Participante_idParticipante = p.idParticipante  \n" +
                "where a.Universidad_idUniversidad = ? order by promedio desc";

        try (Connection connection = getConection();
             PreparedStatement pstmt = connection.prepareStatement(sql);){

            pstmt.setInt(1, id_Universidad);

            try (ResultSet rs = pstmt.executeQuery();){
                while (rs.next()){
                    AlumnoB alumnoB = new AlumnoB();
                    alumnoB.setIdAlumno(rs.getInt(1));
                    alumnoB.setCodigo(rs.getInt(2));
                    alumnoB.setPromedio(rs.getInt(3));
                    alumnoB.setCondicion(rs.getString(4));

                    UniversidadB universidadB = new UniversidadB();
                    universidadB.setIdUniversidad(rs.getInt(5));

                    ParticipanteB participanteB = new ParticipanteB();
                    participanteB.setIdParticipante(rs.getInt(6));
                    participanteB.setNombre(rs.getString(8));
                    participanteB.setApellido(rs.getString(9));
                    participanteB.setEdad(rs.getInt(10));
                    participanteB.setGenero(rs.getString(11));
                    //pasara algo si no pongo el p.Pais_idPais
                    alumnoB.setUniversidad_idUniversidad(universidadB);
                    alumnoB.setIdParticipante(participanteB);
                    alumnoB.setUniversidad_idUniversidad(universidadB);

                    listaAlumnos.add(alumnoB);

                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }



        return listaAlumnos;
    }

    public ArrayList<ParticipanteB> obtenerListaParticipantesAgregar (int id_Pais){


        ArrayList<ParticipanteB> listaParticipantes =new ArrayList<>();

        String sql ="SELECT * FROM participante p left join alumno a on p.idParticipante = a.Participante_idParticipante WHERE idAlumno IS NULL and p.Pais_idPais = ?;";

        try (Connection connection = getConection();
             PreparedStatement pstmt = connection.prepareStatement(sql);){

            pstmt.setInt(1, id_Pais);

            try (ResultSet rs = pstmt.executeQuery();){
                while (rs.next()){
                    ParticipanteB participanteB = new ParticipanteB();
                    participanteB.setIdParticipante(rs.getInt(1));
                    participanteB.setNombre(rs.getString(2));
                    participanteB.setApellido(rs.getString(3));
                    participanteB.setEdad(rs.getInt(4));

                    PaisB paisB = new PaisB();
                    paisB.setIdPais(rs.getInt(6));
                    participanteB.setIdpais(paisB);




                    listaParticipantes.add(participanteB);

                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return listaParticipantes;
    }

    public  void crearAlumno (AlumnoB alumnoB){
        String url = "jdbc:mysql://localhost:3306/labgrupo6?serverTimezone=America/Lima";
        String sql = "INSERT INTO `labgrupo6`.`alumno` (`codigo`, `promedio`, `condicion`, `Universidad_idUniversidad`,`Participante_idParticipante`) VALUES (?,?,?,?,?) ";

        String condi = "N";

        try(Connection connection = this.getConection();
        PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);){
            pstmt.setInt(1,alumnoB.getCodigo());
            pstmt.setDouble(2,alumnoB.getPromedio());
            pstmt.setString(3,condi);
            pstmt.setInt(4, alumnoB.getUniversidad_idUniversidad().getIdUniversidad());
            pstmt.setInt(5,alumnoB.getIdParticipante().getIdParticipante());

            pstmt.executeUpdate();
        }catch (SQLException e){

        }

    }

    public void agregarAlumno (AlumnoB alumnoB){
        String sql = "UPDATE `labgrupo6`.`alumno` SET `codigo`=?, `promedio`=?, `condicion`= 'N', `Universidad_idUniversidad`=? WHERE (`idAlumno`= ?)";

        try(Connection connection = this.getConection();
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);){
            pstmt.setInt(1, alumnoB.getCodigo());
            pstmt.setDouble(2,alumnoB.getPromedio());
            pstmt.setInt(3,alumnoB.getUniversidad_idUniversidad().getIdUniversidad());
            pstmt.setInt(4,alumnoB.getIdAlumno());
            pstmt.executeUpdate();
        }catch (SQLException e){

        }

    }

    public void ActualizarAlumno (AlumnoB alumnoB){
        String sql = "UPDATE `labgrupo6`.`alumno` SET `codigo`=?, `promedio`=?, `condicion`=? WHERE (`idAlumno`= ?)";
        try(Connection connection = this.getConection();
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);){
          pstmt.setInt(1, alumnoB.getCodigo());
          pstmt.setDouble(2,alumnoB.getPromedio());
          pstmt.setString(3, alumnoB.getCondicion());
          pstmt.setInt(4,alumnoB.getIdAlumno());
          pstmt.executeUpdate();
        }catch (SQLException e){

        }

    }
    public void AlumnoEliminable (AlumnoB alumnoB){
        String sql = "UPDATE `labgrupo6`.`alumno` SET `condicion` = 'E' WHERE (`idAlumno` = ?)";
        try(Connection connection = this.getConection();
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);){
            pstmt.setInt(1,alumnoB.getIdAlumno());
            pstmt.executeUpdate();
        }catch (SQLException e){

        }

    }

    public void borrarAlumno(int id){
        String sql = "DELETE FROM `labgrupo6`.`alumno` WHERE (`idAlumno`= ?)";
        try(Connection connection =this.getConection();
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);){
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
        }catch (SQLException e){

        }
    }

    public int ObtenerIdpais(int id){
        int idPais = 0;
        String sql = "SELECT Pais_idPais FROM universidad WHERE idUniversidad = ? ";
        try(Connection connection = this.getConection();
        PreparedStatement pstmt = connection.prepareStatement(sql);){

        pstmt.setInt(1,id);
        try (ResultSet rs = pstmt.executeQuery()){
            if (rs.next()){
                idPais = rs.getInt(1);
            }
        }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }




        return idPais;
    }

    public AlumnoB buscarAlumno(int id){
        AlumnoB alumnoB = new AlumnoB();
        String sql = "SELECT * FROM alumno a left join participante p on a.Participante_idParticipante = p.idParticipante\n" +
                "left join universidad u on a.Universidad_idUniversidad = u.idUniversidad WHERE idAlumno = ?;";

        try (Connection connection = this.getConection();
             PreparedStatement pstmt = connection.prepareStatement(sql);){

            pstmt.setInt(1,id);

            try (ResultSet rs =pstmt.executeQuery()){
                if (rs.next()){
                    alumnoB.setIdAlumno(id);
                    alumnoB.setCodigo(rs.getInt(2));
                    alumnoB.setPromedio(rs.getInt(3));
                    alumnoB.setCondicion(rs.getString("condicion"));

                    UniversidadB universidadB = new UniversidadB();
                    universidadB.setIdUniversidad(rs.getInt("Universidad_idUniversidad"));
                    alumnoB.setUniversidad_idUniversidad(universidadB);

                    ParticipanteB participanteB = new ParticipanteB();
                    participanteB.setNombre(rs.getString(8));
                    participanteB.setApellido(rs.getString(9));
                    participanteB.setEdad(rs.getInt(10));
                    alumnoB.setIdParticipante(participanteB);

                }
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return alumnoB;
    }
//public


}


