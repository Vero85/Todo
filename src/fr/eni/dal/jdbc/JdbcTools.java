package fr.eni.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTools {

    // ici le nom du gestionnaire de la BDD (identifier.sqlite)
    private static final String url = "jdbc:sqlite:identifier.sqlite";

    public static Connection Connection() throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        return connection;
    }


}
