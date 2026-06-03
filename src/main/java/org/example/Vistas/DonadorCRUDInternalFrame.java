package org.example.Vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import org.example.DAO.DonadorDAO;
import org.example.Modelo.Donador;

public class DonadorCRUDInternalFrame extends JInternalFrame {

    private JTextField txtNombre;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JComboBox<String> cbCategoria;
    private JTextField txtAnioGraduacion;
    private JTextField txtMonto;
    private DonadorDAO donadorDAO;
    private DefaultTableModel modeloTabla;
    private JTable tablaDonadores;

    public DonadorCRUDInternalFrame() {
        super("ABCC de Donadores", true, true, true, true);
        setSize(800, 600);
        setLocation(50, 50);
        setLayout(null);

        // ========== FORMULARIO ==========

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

        // ========== BOTONES ==========

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

        // ========== TABLA ==========

        String[] columnas = {"ID", "Nombre", "Teléfono", "Correo", "Categoría", "Monto"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaDonadores = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaDonadores);
        scrollPane.setBounds(50, 400, 700, 150);
        add(scrollPane);

        // ========== INICIALIZAR DAO ==========
        donadorDAO = new DonadorDAO();

        // ========== EVENTOS ==========
        btnGuardar.addActionListener(e -> guardarDonador());
        btnActualizar.addActionListener(e -> actualizarDonador());
        btnEliminar.addActionListener(e -> eliminarDonador());
        btnLimpiar.addActionListener(e -> limpiarFormulario());
        btnReestablecer.addActionListener(e -> {
            limpiarFormulario();
            JOptionPane.showMessageDialog(this, "Formulario reestablecido");
        });

        // Evento para seleccionar una fila de la tabla
        tablaDonadores.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    cargarDonadorSeleccionado();
                }
            }
        });

        // ========== CARGAR TABLA AL INICIAR ==========
        cargarTabla();
    }

    // ========== MÉTODOS ==========

    private void guardarDonador() {
        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre es obligatorio");
            txtNombre.requestFocus();
            return;
        }

        if (txtDireccion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La dirección es obligatoria");
            txtDireccion.requestFocus();
            return;
        }

        if (txtTelefono.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El teléfono es obligatorio");
            txtTelefono.requestFocus();
            return;
        }

        if (txtCorreo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El correo es obligatorio");
            txtCorreo.requestFocus();
            return;
        }

        String telefono = txtTelefono.getText().trim();
        for (int i = 0; i < telefono.length(); i++) {
            if (!Character.isDigit(telefono.charAt(i))) {
                JOptionPane.showMessageDialog(this, "El teléfono debe contener solo números");
                txtTelefono.requestFocus();
                return;
            }
        }

        String correo = txtCorreo.getText().trim();
        if (!correo.contains("@")) {
            JOptionPane.showMessageDialog(this, "El correo debe contener @");
            txtCorreo.requestFocus();
            return;
        }

        Donador d = new Donador();
        d.setNombre(txtNombre.getText().trim());
        d.setDireccion(txtDireccion.getText().trim());
        d.setTelefono(txtTelefono.getText().trim());
        d.setCorreo(txtCorreo.getText().trim());
        d.setCategoria((String) cbCategoria.getSelectedItem());

        int anio = 0;
        if (!txtAnioGraduacion.getText().trim().isEmpty()) {
            try {
                anio = Integer.parseInt(txtAnioGraduacion.getText().trim());
                d.setAnioGraduacion(anio);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El año debe ser un número válido");
                txtAnioGraduacion.requestFocus();
                return;
            }
        }

        double monto = 0;
        if (!txtMonto.getText().trim().isEmpty()) {
            try {
                monto = Double.parseDouble(txtMonto.getText().trim());
                d.setMontoDonado(monto);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El monto debe ser un número válido");
                txtMonto.requestFocus();
                return;
            }
        }

        if (donadorDAO.guardarDonador(d)) {
            JOptionPane.showMessageDialog(this, "Donador guardado correctamente");
            limpiarFormulario();
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar donador");
        }
    }

    private void actualizarDonador() {
        int fila = tablaDonadores.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un donador para actualizar");
            return;
        }

        int id = Integer.parseInt(modeloTabla.getValueAt(fila, 0).toString());

        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre es obligatorio");
            txtNombre.requestFocus();
            return;
        }

        Donador d = new Donador();
        d.setId(id);
        d.setNombre(txtNombre.getText().trim());
        d.setDireccion(txtDireccion.getText().trim());
        d.setTelefono(txtTelefono.getText().trim());
        d.setCorreo(txtCorreo.getText().trim());
        d.setCategoria((String) cbCategoria.getSelectedItem());

        int anio = 0;
        if (!txtAnioGraduacion.getText().trim().isEmpty()) {
            anio = Integer.parseInt(txtAnioGraduacion.getText().trim());
        }
        d.setAnioGraduacion(anio);

        double monto = 0;
        if (!txtMonto.getText().trim().isEmpty()) {
            monto = Double.parseDouble(txtMonto.getText().trim());
        }
        d.setMontoDonado(monto);

        if (donadorDAO.actualizarDonador(d)) {
            JOptionPane.showMessageDialog(this, "Donador actualizado correctamente");
            limpiarFormulario();
            cargarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar");
        }
    }

    private void eliminarDonador() {
        int fila = tablaDonadores.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un donador para eliminar");
            return;
        }

        int id = Integer.parseInt(modeloTabla.getValueAt(fila, 0).toString());
        String nombre = modeloTabla.getValueAt(fila, 1).toString();

        int confirmar = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de eliminar a " + nombre + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            if (donadorDAO.eliminarDonador(id)) {
                JOptionPane.showMessageDialog(this, "Donador eliminado correctamente");
                limpiarFormulario();
                cargarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar");
            }
        }
    }

    private void cargarDonadorSeleccionado() {
        int fila = tablaDonadores.getSelectedRow();
        if (fila != -1) {
            txtNombre.setText(modeloTabla.getValueAt(fila, 1).toString());
            txtTelefono.setText(modeloTabla.getValueAt(fila, 2).toString());
            txtCorreo.setText(modeloTabla.getValueAt(fila, 3).toString());

            String categoria = modeloTabla.getValueAt(fila, 4).toString();
            for (int i = 0; i < cbCategoria.getItemCount(); i++) {
                if (cbCategoria.getItemAt(i).equals(categoria)) {
                    cbCategoria.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

    private void limpiarFormulario() {
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        cbCategoria.setSelectedIndex(0);
        txtAnioGraduacion.setText("");
        txtMonto.setText("");
        txtNombre.requestFocus();
    }

    private void cargarTabla() {
        Thread hiloCarga = new Thread(new Runnable() {
            public void run() {
                ArrayList<Donador> donadores = donadorDAO.listarTodos();

                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        modeloTabla.setRowCount(0);

                        for (Donador d : donadores) {
                            Object[] fila = {
                                    d.getId(),
                                    d.getNombre(),
                                    d.getTelefono(),
                                    d.getCorreo(),
                                    d.getCategoria(),
                                    "$" + d.getMontoDonado()
                            };
                            modeloTabla.addRow(fila);
                        }
                    }
                });
            }
        });
        hiloCarga.start();
    }
}