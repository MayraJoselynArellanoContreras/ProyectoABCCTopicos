package org.example.ConexcionBD;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
    private Connection conexion;

    public Connection obtenerConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/universidad_donativos",
                    "root",
                    "joselin1"
            );
        } catch (Exception e) {
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


}
