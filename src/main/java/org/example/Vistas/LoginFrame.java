package org.example.Vistas;

import org.example.DAO.UsuarioDAO;
import org.example.Modelo.Usuario;
import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnIngresar;
    private JButton btnSalir;
    private UsuarioDAO usuarioDAO;

    public LoginFrame() {
        usuarioDAO = new UsuarioDAO();

        setTitle("Sistema de Donativos - Universidad Beta");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 51, 102));
        panel.setLayout(null);
        add(panel);

        JLabel titulo = new JLabel("SISTEMA DE DONATIVOS");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setForeground(Color.WHITE);
        titulo.setBounds(120, 30, 250, 30);
        panel.add(titulo);

        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.WHITE);
        formPanel.setBounds(50, 80, 350, 150);
        formPanel.setLayout(null);
        panel.add(formPanel);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(30, 30, 80, 25);
        formPanel.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(120, 30, 200, 25);
        formPanel.add(txtUsuario);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(30, 70, 80, 25);
        formPanel.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(120, 70, 200, 25);
        formPanel.add(txtPassword);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBackground(new Color(0, 102, 204));
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setBounds(80, 250, 120, 35);
        panel.add(btnIngresar);

        setFocusTraversalPolicy(new FocusTraversalPolicy() {
            public Component getComponentAfter(Container focusCycleRoot, Component aComponent) {
                if (aComponent.equals(txtUsuario)) return txtPassword;
                if (aComponent.equals(txtPassword)) return btnIngresar;
                return txtUsuario;
            }

            public Component getComponentBefore(Container focusCycleRoot, Component aComponent) {
                if (aComponent.equals(txtPassword)) return txtUsuario;
                if (aComponent.equals(btnIngresar)) return txtPassword;
                return btnIngresar;
            }

            public Component getFirstComponent(Container focusCycleRoot) {
                return txtUsuario;
            }

            public Component getLastComponent(Container focusCycleRoot) {
                return btnIngresar;
            }

            public Component getDefaultComponent(Container focusCycleRoot) {
                return txtUsuario;
            }
        });

        txtPassword.addActionListener(e -> validarLogin());

        btnSalir = new JButton("Salir");
        btnSalir.setBackground(new Color(153, 0, 0));
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setBounds(250, 250, 120, 35);
        panel.add(btnSalir);

        btnIngresar.addActionListener(e -> validarLogin());
        btnSalir.addActionListener(e -> System.exit(0));
    }

    private void validarLogin() {
        String usuario = txtUsuario.getText().trim();
        String password = new String(txtPassword.getPassword());

        if (usuario.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor ingrese usuario y contraseña",
                    "Campos vacíos",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Usuario user = usuarioDAO.validarLogin(usuario, password);

        if (user != null) {
            JOptionPane.showMessageDialog(this,
                    "Bienvenido " + user.getNombreUsuario(),
                    "Login exitoso",
                    JOptionPane.INFORMATION_MESSAGE);
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Usuario o contraseña incorrectos.\nIntente nuevamente.",
                    "Error de autenticación",
                    JOptionPane.ERROR_MESSAGE);
            txtPassword.setText("");
            txtPassword.requestFocus();
        }
    }

    public static void main(String[] args) {
        new LoginFrame().setVisible(true);
    }
}