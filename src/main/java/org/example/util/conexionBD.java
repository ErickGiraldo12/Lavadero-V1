package org.example.util;
import java.sql.*;
public class conexionBD {
    private static final String URL = "jdbc:mysql://localhost:3312/lavadero0";
    private static final String USUARIO ="root";
    private static final String CONTRASENA = "1234";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }


}
