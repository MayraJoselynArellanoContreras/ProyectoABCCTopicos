package org.example.Vistas;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JMenuBar menuBar;
    private JMenu menuArchivo;
    private JMenu menuABCC;
    private JMenu menuAyuda;
    private JMenuItem menuSalir;
    private JMenuItem menuDonadores;
    private JMenuItem menuAcerca;

    public MainFrame() {
        setTitle("Sistema de Donativos - Universidad Beta");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        menuBar = new JMenuBar();

        menuArchivo = new JMenu("Archivo");
        menuSalir = new JMenuItem("Salir");
        menuSalir.addActionListener(e -> System.exit(0));
        menuArchivo.add(menuSalir);

        menuABCC = new JMenu("ABCC");
        menuDonadores = new JMenuItem("Donadores");
        menuABCC.add(menuDonadores);

        menuAyuda = new JMenu("Ayuda");
        menuAcerca = new JMenuItem("Acerca de");
        menuAyuda.add(menuAcerca);

        menuBar.add(menuArchivo);
        menuBar.add(menuABCC);
        menuBar.add(menuAyuda);

        setJMenuBar(menuBar);

        JLabel bienvenida = new JLabel("Bienvenido al Sistema de Donativos");
        bienvenida.setFont(new Font("Arial", Font.BOLD, 20));
        bienvenida.setHorizontalAlignment(SwingConstants.CENTER);
        add(bienvenida);
    }
}