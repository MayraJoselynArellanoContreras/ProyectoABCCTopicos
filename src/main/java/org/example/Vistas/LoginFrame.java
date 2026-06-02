package org.example.Vistas;
import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnIngresar;
    private JButton btnSalir;

    public LoginFrame() {
        setTitle("Sistema de Donativos - Universidad");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(50, 80, 100, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(150, 80, 180, 25);
        add(txtUsuario);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(50, 120, 100, 25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 120, 180, 25);
        add(txtPassword);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(100, 180, 100, 30);
        add(btnIngresar);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(220, 180, 100, 30);
        add(btnSalir);

        btnSalir.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        new LoginFrame().setVisible(true);
    }
}