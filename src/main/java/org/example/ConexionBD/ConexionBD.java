package org.example.ConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private Connection conexion;

    public Connection obtenerConexion() {
        try {
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/universidad_donativos",
                    "root",
                    "joselin1"
            );
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return conexion;
    }

    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (Exception e) {
            System.out.println("Error al cerrar conexión: " + e.getMessage());
        }
    }

    public boolean probarConexion() {
        try {
            Connection conn = obtenerConexion();
            return conn != null && !conn.isClosed();
        } catch (Exception e) {
            return false;
        }
    }
}
