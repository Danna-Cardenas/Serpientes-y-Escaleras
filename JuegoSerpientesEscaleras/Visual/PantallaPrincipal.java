package serpientesYEscaleras.Vista;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DANNA
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import serpientesYEscaleras.Modelo.Tablero;

public class PantallaPrincipal extends JFrame {

    private JLabel bienvenidaLabel;
    private JLabel instruccionesLabel;
    private JLabel jugadoresLabel;
    private JTextField jugadoresField;
    private JLabel casillasLabel;
    private JTextField casillasField;
    private JTextField serpientesField;
    private JLabel serpientesLabel;
    private JLabel escalerasLabel;
    private JTextField escalerasField;
    private JButton agregarSerpienteButton;
    private JButton agregarEscaleraButton;
    private JButton continuarButton;

    private List<int[]> serpientes;
    private List<int[]> escaleras;

    public PantallaPrincipal() {
        super("Inicio");
        // Configuración del JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400); // Ajustamos el tamaño de la ventana
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 218, 185)); // Color de fondo 

        // Inicializar las listas
        serpientes = new ArrayList<>();
        escaleras = new ArrayList<>();

        // Crear componentes de la pantalla inicial
        bienvenidaLabel = new JLabel("Juego Escaleras y Serpientes", SwingConstants.CENTER);
        bienvenidaLabel.setFont(new Font("Times new roman", Font.BOLD, 30)); // Ajustamos el tamaño de la fuente
        instruccionesLabel = new JLabel("Modifica tu juego", SwingConstants.CENTER);
        jugadoresLabel = new JLabel("Escriba el número de jugadores (2 a 4):");
        jugadoresField = new JTextField(15);
        casillasLabel = new JLabel("Escribe el número de casillas (10,13,15): ");
        casillasField = new JTextField(15);
        serpientesLabel = new JLabel("Escriba las coordenadas de la serpiente (10-4,28-9...):");
        serpientesField = new JTextField(15);
        agregarSerpienteButton = new JButton("Agregar");

        escalerasLabel = new JLabel("Escriba las coordenadas de la escalera (6-45,10-54...):");
        escalerasField = new JTextField(15);
        agregarEscaleraButton = new JButton("Agregar");
        continuarButton = new JButton("Siguiente"); 
        continuarButton.setBackground(new Color(230, 230, 250)); // Color para el botón
        continuarButton.setForeground(Color.black); 

        // Configurar el layout del JFrame
        setLayout(new BorderLayout());
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25)); // Margen
        panelCentral.setBackground(new Color(255, 218, 185)); // Color de fondo

        bienvenidaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentral.add(bienvenidaLabel);
        panelCentral.add(Box.createRigidArea(new Dimension(0, 0))); // Espacio entre componentes

        instruccionesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentral.add(instruccionesLabel);
        panelCentral.add(Box.createRigidArea(new Dimension(0, 0))); 

        JPanel panelJugadores = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelJugadores.setBackground(new Color(173, 216, 230)); 
        panelJugadores.add(jugadoresLabel);
        panelJugadores.add(jugadoresField);
        panelCentral.add(panelJugadores);
        panelCentral.add(Box.createRigidArea(new Dimension(0, 0))); 

        JPanel panelCasillas = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelCasillas.setBackground(new Color(173, 216, 230)); // Color de fondo verdoso claro
        panelCasillas.add(casillasLabel);
        panelCasillas.add(casillasField);
        panelCentral.add(panelCasillas);
        panelCentral.add(Box.createRigidArea(new Dimension(0, 0))); 

        JPanel panelSerpientes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelSerpientes.setBackground(new Color(173, 216, 230));
        panelSerpientes.add(serpientesLabel);
        panelSerpientes.add(serpientesField);
        panelSerpientes.add(agregarSerpienteButton);
        panelCentral.add(panelSerpientes);
        panelCentral.add(Box.createRigidArea(new Dimension(0, 0))); 

        JPanel panelEscaleras = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelEscaleras.setBackground(new Color(173, 216, 230));
        panelEscaleras.add(escalerasLabel);
        panelEscaleras.add(escalerasField);
        panelEscaleras.add(agregarEscaleraButton);
        panelCentral.add(panelEscaleras);
        panelCentral.add(Box.createRigidArea(new Dimension(0, 0))); 

        continuarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentral.add(continuarButton);

        add(panelCentral, BorderLayout.CENTER);

        // Botón para agregar serpientes
        agregarSerpienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String coordenadas = serpientesField.getText();
                if (!coordenadas.isEmpty()) {
                    String[] pos = coordenadas.split("-");
                    if (pos.length == 2) {
                        int inicioPos = Integer.parseInt(pos[0].trim());
                        int finPos = Integer.parseInt(pos[1].trim());
                        serpientes.add(new int[]{inicioPos, finPos});
                        serpientesField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Formato incorrecto.Debe ser asi(12-5)");
                    }
                }
            }
        });

        // Botón para agregar escaleras
        agregarEscaleraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String coordenadas = escalerasField.getText();
                if (!coordenadas.isEmpty()) {
                    String[] pos = coordenadas.split("-");
                    if (pos.length == 2) {
                        int inicioPos = Integer.parseInt(pos[0].trim());
                        int finPos = Integer.parseInt(pos[1].trim());
                        escaleras.add(new int[]{inicioPos, finPos});
                        escalerasField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Formato incorrecto.Debe ser asi(3-14)");
                    }
                }
            }
        });

        // Agregar ActionListener al botón de continuar
        continuarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int numJugadores = Integer.parseInt(jugadoresField.getText());
                int numCasillas = Integer.parseInt(casillasField.getText());
                Tablero t = new Tablero(numCasillas * numCasillas, numJugadores);

                for (int[] serpiente : serpientes) {
                    t.agregarSerpiente(serpiente[0], serpiente[1]);
                }

               
                for (int[] escalera : escaleras) {
                    t.agregarEscalera(escalera[0], escalera[1]);
                }

                t.rellenarTablero();
                t.imprimirTablero();

                TableroJFrame tablero = new TableroJFrame(numCasillas, numCasillas, t);
                tablero.setVisible(true);

                NombresJugadores nombresJugadores = new NombresJugadores(numJugadores, t);
                nombresJugadores.setVisible(true);
                dispose();
            }
   });
}}
