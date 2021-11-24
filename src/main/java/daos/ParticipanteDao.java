package daos;

import beans.AlumnoB;
import beans.PaisB;
import beans.ParticipanteB;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ParticipanteDao extends BaseDao {
    //test
    public ArrayList<ParticipanteB> obtenerListaParticipantes() {

        ArrayList<ParticipanteB> listaParticipantes = new ArrayList<>();

        String sql = "SELECT * FROM participante p left join pais ps on p.Pais_idPais = ps.idPais;";

        try (Connection connection = this.getConection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {

                    ParticipanteB participanteB = new ParticipanteB();
                    participanteB.setIdParticipante(rs.getInt(1));
                    participanteB.setNombre(rs.getString(2));
                    participanteB.setApellido(rs.getString(3));
                    participanteB.setEdad(rs.getInt(4));
                    participanteB.setGenero(rs.getString(5));

                    PaisB paisB = new PaisB();
                    paisB.setIdPais(rs.getInt(6));
                    paisB.setNombre(rs.getString(8));

                    participanteB.setIdpais(paisB);


                    listaParticipantes.add(participanteB);

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listaParticipantes;
    }

    public void crearParticipante(ParticipanteB participanteB) {
        String url = "jdbc:mysql://localhost:3306/labgrupo6?serverTimezone=America/Lima";
        String sql = "INSERT INTO `labgrupo6`.`participante` (`nombre`, `apellido`, `edad`, `Pais_idPais`,`genero`) VALUES (?,?,?,?,?) ";


        try (Connection connection = this.getConection();
             PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, participanteB.getNombre());
            pstmt.setString(2, participanteB.getApellido());
            pstmt.setInt(3, participanteB.getEdad());
            pstmt.setInt(4, participanteB.getIdpais().getIdPais());
            pstmt.setString(5, participanteB.getGenero());

            pstmt.executeUpdate();
        } catch (SQLException e) {

        }

    }

    public void agregarParticipante (ParticipanteB participanteB){
        String sql = "UPDATE `labgrupo6`.`participante` SET `nombre`=?, `apellido`=?,`edad`=? , `nombre`=? , `genero`=?";

        try(Connection connection = this.getConection();
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);){
            pstmt.setString(1, participanteB.getNombre());
            pstmt.setString(2,participanteB.getApellido());
            pstmt.setInt(3,participanteB.getEdad());
            pstmt.setString(4,participanteB.getIdpais().getNombre());
            pstmt.setString(5,participanteB.getGenero());
            pstmt.executeUpdate();
        }catch (SQLException e){

        }

    }




}

