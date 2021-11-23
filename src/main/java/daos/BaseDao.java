package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDao {

    public Connection getConection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/labgrupo6?serverTimezone=America/Lima&useSSL=false&allowPublicKeyRetrieval=true";

        return DriverManager.getConnection(url, "root", "root");

    }
}