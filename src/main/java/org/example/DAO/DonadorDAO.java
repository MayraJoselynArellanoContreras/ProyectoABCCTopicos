package org.example.DAO;

import org.example.ConexionBD.ConexionBD;
import org.example.Modelo.Donador;
import java.sql.*;
import java.util.ArrayList;

public class DonadorDAO {

    private ConexionBD conexionBD;

    public DonadorDAO() {
        conexionBD = new ConexionBD();
    }

    public ArrayList<Donador> listarTodos() {
        ArrayList<Donador> donadores = new ArrayList<>();
        String sql = "SELECT * FROM donador ORDER BY id DESC";

        try {
            Connection conn = conexionBD.obtenerConexion();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Donador d = new Donador();
                d.setId(rs.getInt("id"));
                d.setNombre(rs.getString("nombre"));
                d.setDireccion(rs.getString("direccion"));
                d.setTelefono(rs.getString("telefono"));
                d.setCorreo(rs.getString("correo"));
                d.setCategoria(rs.getString("categoria"));
                d.setAnioGraduacion(rs.getInt("anio_graduacion"));
                d.setMontoDonado(rs.getDouble("monto_donado"));
                donadores.add(d);
            }

            rs.close();
            stmt.close();
            conexionBD.cerrarConexion();

        } catch (Exception e) {
            System.out.println("Error al listar donadores: " + e.getMessage());
        }

        return donadores;
    }
}
