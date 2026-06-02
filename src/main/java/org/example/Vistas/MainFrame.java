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
    private JDesktopPane desktopPane;

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

        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);

        JButton btnDonadores = new JButton("Donadores");
        JButton btnSalirTool = new JButton("Salir");

        toolBar.add(btnDonadores);
        toolBar.addSeparator();
        toolBar.add(btnSalirTool);

        add(toolBar, BorderLayout.NORTH);

        desktopPane = new JDesktopPane();
        desktopPane.setBackground(new Color(240, 240, 240));
        add(desktopPane, BorderLayout.CENTER);

        setLayout(new BorderLayout());

        btnSalirTool.addActionListener(e -> System.exit(0));

        JLabel bienvenida = new JLabel("Bienvenido al Sistema de Donativos");
        bienvenida.setFont(new Font("Arial", Font.BOLD, 20));
        bienvenida.setHorizontalAlignment(SwingConstants.CENTER);
        add(bienvenida);
    }
}