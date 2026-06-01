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

    public boolean guardarDonador(Donador d) {
        String sql = "INSERT INTO donador (nombre, direccion, telefono, correo, categoria, anio_graduacion, monto_donado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        boolean resultado = false;

        try {
            Connection conn = conexionBD.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, d.getNombre());
            stmt.setString(2, d.getDireccion());
            stmt.setString(3, d.getTelefono());
            stmt.setString(4, d.getCorreo());
            stmt.setString(5, d.getCategoria());
            stmt.setInt(6, d.getAnioGraduacion());
            stmt.setDouble(7, d.getMontoDonado());

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                resultado = true;
            }

            stmt.close();
            conexionBD.cerrarConexion();

        } catch (Exception e) {
            System.out.println("Error al guardar donador: " + e.getMessage());
        }

        return resultado;
    }

    public boolean actualizarDonador(Donador d) {
        String sql = "UPDATE donador SET nombre=?, direccion=?, telefono=?, correo=?, categoria=?, anio_graduacion=?, monto_donado=? WHERE id=?";
        boolean resultado = false;

        try {
            Connection conn = conexionBD.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, d.getNombre());
            stmt.setString(2, d.getDireccion());
            stmt.setString(3, d.getTelefono());
            stmt.setString(4, d.getCorreo());
            stmt.setString(5, d.getCategoria());
            stmt.setInt(6, d.getAnioGraduacion());
            stmt.setDouble(7, d.getMontoDonado());
            stmt.setInt(8, d.getId());

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                resultado = true;
            }

            stmt.close();
            conexionBD.cerrarConexion();

        } catch (Exception e) {
            System.out.println("Error al actualizar donador: " + e.getMessage());
        }

        return resultado;
    }

    public boolean eliminarDonador(int id) {
        String sql = "DELETE FROM donador WHERE id = ?";
        boolean resultado = false;

        try {
            Connection conn = conexionBD.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                resultado = true;
            }

            stmt.close();
            conexionBD.cerrarConexion();

        } catch (Exception e) {
            System.out.println("Error al eliminar donador: " + e.getMessage());
        }

        return resultado;
    }
}
