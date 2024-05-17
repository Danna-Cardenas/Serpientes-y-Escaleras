package serpientesYEscaleras.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import serpientesYEscaleras.Modelo.Tablero;

public class NombresJugadores extends JFrame {

    private int numeroJugadores; 
    private int jugadorActual; 
    private JTextField nombreField;
    private JButton continuarButton;
    private JLabel mensajeLabel;
    private JLabel tituloLabel;
    private String[] nombresJugadores; 
    private Tablero tablero;
    
    public NombresJugadores(int numeroJugadores, Tablero tablero) {
        super("Nombres de Jugadores");

        this.numeroJugadores = numeroJugadores;
        this.nombresJugadores = new String[numeroJugadores];
        this.jugadorActual = 0;
        this.numeroJugadores = 0;
        this.tablero = tablero; 

        // Configuración del JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300); 
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(220, 255, 220)); // Color de fondo 

        // Crear componentes de la ventana
        int actual = jugadorActual+1;
        tituloLabel = new JLabel("Coloque el nombre del jugador " + actual, SwingConstants.CENTER);
        mensajeLabel = new JLabel("", SwingConstants.CENTER);
        nombreField = new JTextField(20);
        continuarButton = new JButton("Continuar");

        // Configurar el layout del JFrame
        setLayout(new BorderLayout());
        JPanel panelCentral = new JPanel(new GridLayout(4, 1, 10, 10)); // GridLayout de 4 filas
        panelCentral.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25)); 
        panelCentral.setBackground(new Color(255, 255, 224)); // Color de fondo 
        panelCentral.add(tituloLabel);
        panelCentral.add(mensajeLabel);
        panelCentral.add(nombreField);
        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBoton.setBackground(new Color(255, 255, 224)); // Color de fondo 
        panelBoton.add(continuarButton);
        panelCentral.add(panelBoton);

        add(panelCentral, BorderLayout.CENTER);

      
        continuarButton.addActionListener(new ActionListener() {
            @Override
          
            public void actionPerformed(ActionEvent e) {
                if (!nombreField.getText().isEmpty()) {
                    nombresJugadores[jugadorActual] = nombreField.getText();
                    tablero.agregarJugador(nombresJugadores[jugadorActual]);
                    tituloLabel.setText("Coloque el nombre del jugador " + (jugadorActual+2));
                    nombreField.setText(""); // Limpiar el campo de texto
                    nombreField.requestFocusInWindow();
                    jugadorActual++;
                    tablero.imprimirJugadores();

                    if (jugadorActual < numeroJugadores) {
//                  
                    } else {
                        // Todos los nombres han sido ingresados
                        JOptionPane.showMessageDialog(null, "Se han ingreado los nombres");
                        for (int i = 0; i < nombresJugadores.length; i++) {
                            System.out.println("Jugador " + (i + 1) + ": " + nombresJugadores[i]);
                        }
                        dispose(); 
                    }
                } else {
                    
                    mensajeLabel.setText("No puede estar vacío el nombre");
                }
            }
   });
}}
