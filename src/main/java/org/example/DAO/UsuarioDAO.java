package org.example.DAO;

import org.example.ConexionBD.ConexionBD;
import org.example.Modelo.Usuario;
import java.sql.*;

public class UsuarioDAO {

    private ConexionBD conexionBD;

    public UsuarioDAO() {
        conexionBD = new ConexionBD();
    }

    public Usuario validarLogin(String usuario, String password) {
        Usuario user = null;
        String sql = "SELECT * FROM usuario WHERE nombre_usuario = ? AND contrasena = ?";

        try {
            Connection conn = conexionBD.obtenerConexion();
            if (conn == null) {
                throw new SQLException("No se pudo establecer la conexión con la base de datos");
            }
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new Usuario();
                user.setId(rs.getInt("id"));
                user.setNombreUsuario(rs.getString("nombre_usuario"));
                user.setContrasena(rs.getString("contrasena"));
            }

            rs.close();
            stmt.close();
            conexionBD.cerrarConexion();

        } catch (Exception e) {
            System.out.println("Error en validarLogin: " + e.getMessage());
        }

        return user;
    }
}
