package org.example.Vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DonadorCRUDInternalFrame extends JInternalFrame {

    private JTextField txtNombre;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JComboBox<String> cbCategoria;
    private JTextField txtAnioGraduacion;
    private JTextField txtMonto;

    public DonadorCRUDInternalFrame() {
        super("ABCC de Donadores", true, true, true, true);
        setSize(800, 600);
        setLocation(50, 50);
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50, 50, 100, 25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(160, 50, 250, 25);
        add(txtNombre);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(50, 90, 100, 25);
        add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(160, 90, 250, 25);
        add(txtDireccion);


        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(50, 130, 100, 25);
        add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(160, 130, 150, 25);
        add(txtTelefono);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(50, 170, 100, 25);
        add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(160, 170, 250, 25);
        add(txtCorreo);

        JLabel lblCategoria = new JLabel("Categoría:");
        lblCategoria.setBounds(50, 210, 100, 25);
        add(lblCategoria);

        String[] categorias = {"graduado", "alumno", "padre", "administrador", "docente", "corporacion", "amigo"};
        cbCategoria = new JComboBox<>(categorias);
        cbCategoria.setBounds(160, 210, 150, 25);
        add(cbCategoria);

        JLabel lblAnio = new JLabel("Año Graduación:");
        lblAnio.setBounds(50, 250, 120, 25);
        add(lblAnio);

        txtAnioGraduacion = new JTextField();
        txtAnioGraduacion.setBounds(160, 250, 80, 25);
        add(txtAnioGraduacion);

        JLabel lblMonto = new JLabel("Monto Donado:");
        lblMonto.setBounds(50, 290, 100, 25);
        add(lblMonto);

        txtMonto = new JTextField();
        txtMonto.setBounds(160, 290, 150, 25);
        add(txtMonto);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(50, 340, 100, 30);
        add(btnGuardar);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(170, 340, 100, 30);
        add(btnActualizar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(290, 340, 100, 30);
        add(btnEliminar);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(410, 340, 100, 30);
        add(btnLimpiar);

        JButton btnReestablecer = new JButton("Reestablecer");
        btnReestablecer.setBounds(530, 340, 120, 30);
        add(btnReestablecer);

        String[] columnas = {"ID", "Nombre", "Teléfono", "Correo", "Categoría", "Monto"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        JTable tablaDonadores = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaDonadores);
        scrollPane.setBounds(50, 400, 700, 150);
        add(scrollPane);
    }
}