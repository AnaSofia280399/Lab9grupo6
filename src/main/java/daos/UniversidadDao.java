package daos;

import beans.ContinenteB;
import beans.PaisB;
import beans.UniversidadB;

import java.sql.*;
import java.util.ArrayList;

public class UniversidadDao extends BaseDao {

    public ArrayList<UniversidadB> ListaUniversidades() {
        return sql("SELECT u.nombre as 'N.Uni' , u.ranking ,p.nombre as 'N.pais', c.nombre 'N.continente' , u.foto from universidad u \n" +
                "inner join pais p on u.Pais_idPais = p.idPais\n" +
                "inner join continente c  on p.Continente_idContinente = c.idContinente\n" +
                "  order by ranking ASC ;");
    }

    public ArrayList<UniversidadB> ListaUniversidadesXCampo() {
        return sql("SELECT u.nombre as 'N.Uni' , u.ranking ,p.nombre as 'N.pais', c.nombre 'N.continente' , u.foto from universidad u \n" +
                "inner join pais p on u.Pais_idPais = p.idPais\n" +
                "inner join continente c  on p.Continente_idContinente = c.idContinente\n" +
                "  order by ranking ASC ;");
    }

    public ArrayList<UniversidadB> sql(String sql) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<UniversidadB> lista = new ArrayList<>();
        try (Connection conn =getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                UniversidadB universidadB = new UniversidadB();
                universidadB.setNombre(rs.getString(1));
                universidadB.setRanking(rs.getInt(2));
                PaisB pais = new PaisB();
                pais.setNombre(rs.getString(3));
                ContinenteB continente = new ContinenteB();
                continente.setNombre(rs.getString(4));

                pais.setContinente_idContinente(continente);
                universidadB.setPais_idPais(pais);


                lista.add(universidadB);

            }
        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return lista;
    }
    /*
    public void insertarUniversidad( String nombre  , int  ranking  ,int  n_estud,) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        String sql = "INSERT INTO universidad (`nombre`, `ranking`, `num_estud`, `Pais_idPais`) VALUES (?, ?, ?, ?);";

        try (Connection connection = getConection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, );
            pstmt.setString(2, );
            pstmt.setInt(3, );
            pstmt.setInt(4, );
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/
}
