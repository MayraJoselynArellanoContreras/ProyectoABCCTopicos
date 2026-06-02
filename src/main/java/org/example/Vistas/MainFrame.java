package org.example.Vistas;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Sistema de Donativos - Universidad Beta");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel bienvenida = new JLabel("Bienvenido al Sistema de Donativos");
        bienvenida.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        bienvenida.setHorizontalAlignment(SwingConstants.CENTER);
        add(bienvenida);
    }
}