package daos;

import beans.ContinenteB;
import beans.PaisB;

import java.sql.*;
import java.util.ArrayList;

public class PaisDao extends BaseDao {


    public ArrayList<PaisB> obtenerListaPaises() {
        //filtrado por orden alfabetico

        ArrayList<PaisB> listapaises = new ArrayList<>();

        String sql = "select p.idPais, p.nombre, p.poblacion, p.tamaño, c.nombre from pais p inner join continente c on p.Continente_idContinente=c.idContinente order by p.nombre ASC;";

        try (Connection conn = this.getConection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(sql);) {
            System.out.println(sql);
            while (rs.next()) {
                PaisB paisB = new PaisB();
                paisB.setIdPais(rs.getInt(1));
                paisB.setNombre(rs.getString(2));
                paisB.setPoblacion(rs.getString(3));
                paisB.setTamano(rs.getString(4));
                ContinenteB continenteB = new ContinenteB();
                continenteB.setNombreContinente(rs.getString(5));
                paisB.setContinenteB(continenteB);
                listapaises.add(paisB);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listapaises;
    }


    public ArrayList<PaisB> obtenerListaPaisesporContinente() {
        //filtrado por orden alfabetico
        ArrayList<PaisB> listapaises = new ArrayList<>();

        String sql = "select p.nombre, p.poblacion, p.tamaño, c.nombre from pais p inner join continente c on p.Continente_idContinente=c.idContinente order by c.nombre ASC;";

        try (Connection conn = this.getConection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(sql);) {
            System.out.println(sql);
            while (rs.next()) {
                PaisB paisB = new PaisB();
                paisB.setNombre(rs.getString(1));
                paisB.setPoblacion(rs.getString(2));
                paisB.setTamano(rs.getString(3));
                ContinenteB continenteB = new ContinenteB();
                continenteB.setNombreContinente(rs.getString(4));
                paisB.setContinenteB(continenteB);
                listapaises.add(paisB);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listapaises;
    }


    public PaisB obtenerID(String id) {

        PaisB pais = null;

        String sql = "select p.idPais, p.nombre, p.poblacion, p.tamaño, c.nombre from pais p inner join continente c on p.Continente_idContinente=c.idContinente where p.idPais = ?;";
        try (Connection connection = this.getConection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1,id);


            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {

                    pais = new PaisB();
                    pais.setIdPais(rs.getInt(1));
                    pais.setNombre(rs.getString(2));
                    pais.setTamano(rs.getString(4));
                    pais.setPoblacion(rs.getString(3));
                    ContinenteB continenteB = new ContinenteB();
                    continenteB.setNombreContinente(rs.getString(5));
                    pais.setContinenteB(continenteB);

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pais;
    }



    public void crearPais(int idPais, String nombrePais, String tamano, String poblacion,int continente) {



        String sql = "INSERT INTO labgrupo6.pais(idPais,nombre, poblacion, tamaño, Continente_idContinente) VALUES (?,?,?,?,?);";

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);){
            pstmt.setInt(1, idPais);
            pstmt.setString(2, nombrePais);
            pstmt.setString(4, tamano);
            pstmt.setString(3, poblacion);
            pstmt.setInt(5,continente);


            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public int obtenerIDContinente(String continente){

        String sql1 ="select idContinente from continente where nombre like ?;";

        ContinenteB continenteB = new ContinenteB();
        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql1);) {

            pstmt.setString(1, "%" + continente + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    continenteB.setIdContinente(rs.getInt(1));

                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return continenteB.getIdContinente();
    }

    public void editarPais(int idPais, String nombre, String tamano,String poblacion, int continente) {

        String sql = "UPDATE labgrupo6.pais SET  nombre = ?, tamaño = ?, poblacion = ?, Continente_idContinente=? WHERE (idPais = ?);";
        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(5, idPais);
            pstmt.setString(1, nombre);
            pstmt.setString(2, tamano);
            pstmt.setString(3, poblacion);
            pstmt.setInt(4, continente);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void borrarPais(int idPais, int idContinente) throws SQLException {

        String sql = "Delete from pais where idPais = ? and idContinente = ?;";


        try (Connection connection = getConection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setInt(1, idPais);
            pstmt.setInt(2,idContinente);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("no se pudo ingresar");
        }

        String sql2 = "Delete from pedido where idPais = ?;";
        try (Connection connection = this.getConection();
             PreparedStatement pstmt = connection.prepareStatement(sql2);) {
            pstmt.setInt(1, idPais);
            pstmt.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("no se pudo ingresar");
        }


    }




}
