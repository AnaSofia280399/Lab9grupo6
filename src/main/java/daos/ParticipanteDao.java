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

        String sql = "SELECT p.nombre, p.apellido, p.edad, ps.nombre , p.genero FROM participante p left join pais ps on p.idParticipante = ps.idPais;";

        try (Connection connection = getConection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            try (ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {

                    ParticipanteB participanteB = new ParticipanteB();

                    participanteB.setNombre(rs.getString(1));
                    participanteB.setApellido(rs.getString(2));
                    participanteB.setEdad(rs.getInt(3));
                    participanteB.setGenero(rs.getString(5));

                    PaisB paisB = new PaisB();
                    paisB.setNombre(rs.getString(4));

                    listaParticipantes.add(participanteB);

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listaParticipantes;
    }
    



}

