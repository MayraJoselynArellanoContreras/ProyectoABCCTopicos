package org.example.Vistas;

import javax.swing.*;

public class DonadorCRUDInternalFrame extends JInternalFrame {

    public DonadorCRUDInternalFrame() {
        super("ABCC de Donadores", true, true, true, true);
        setSize(800, 600);
        setLocation(50, 50);
        setLayout(null);

        JLabel label = new JLabel("Formulario de Donadores");
        label.setBounds(300, 250, 200, 30);
        add(label);
    }
}