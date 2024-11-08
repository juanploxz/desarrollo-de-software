import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class Prototipo extends JFrame {
    private JButton botonInstrucciones;
    private JButton botonCalorias;
    private JButton botonDatosUsuario;
    private JButton botonRecordarDatos;
    private JTextField inputNombre;
    private JTextField inputEdad;
    private JTextField inputCalorias;

    private List<String> datosUsuario = new ArrayList<>();

    public Prototipo() {
        // Inicializar componentes
        botonInstrucciones = new JButton("Instrucciones");
        botonCalorias = new JButton("Calorías");
        botonDatosUsuario = new JButton("Datos Usuario");
        botonRecordarDatos = new JButton("Recordar Datos");
        inputNombre = new JTextField(20);
        inputEdad = new JTextField(20);
        inputCalorias = new JTextField(20);

        // Set components properties
        botonInstrucciones.setToolTipText("Imprimir Instrucciones");
        botonCalorias.setToolTipText("Calcular Calorías");
        botonDatosUsuario.setToolTipText("Enviar Datos Usuario");
        botonRecordarDatos.setToolTipText("Recordar Datos");

        // Establecer colores de fondo
        inputNombre.setBackground(Color.LIGHT_GRAY);
        inputEdad.setBackground(Color.LIGHT_GRAY);
        inputCalorias.setBackground(Color.LIGHT_GRAY);
        botonInstrucciones.setBackground(Color.CYAN);
        botonCalorias.setBackground(Color.CYAN);
        botonDatosUsuario.setBackground(Color.CYAN);
        botonRecordarDatos.setBackground(Color.CYAN);

        // Crear panel principal con GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Añadir componentes al panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nombre:"), gbc);

        gbc.gridx = 1;
        panel.add(inputNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Edad:"), gbc);

        gbc.gridx = 1;
        panel.add(inputEdad, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Calorías:"), gbc);

        gbc.gridx = 1;
        panel.add(inputCalorias, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(botonInstrucciones, gbc);

        gbc.gridx = 1;
        panel.add(botonCalorias, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(botonDatosUsuario, gbc);

        gbc.gridx = 1;
        panel.add(botonRecordarDatos, gbc);

        // Añadir panel al frame
        add(panel);

        // Add action listeners for buttons
        botonInstrucciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imprimirInstrucciones();
            }
        });

        botonCalorias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputCalorias.getText();
                int totalCalorias = calcularCaloriasConsumidas(input);
                JOptionPane.showMessageDialog(null, "Total Calorías: " + totalCalorias);
            }
        });

        botonDatosUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = inputNombre.getText();
                int edad = Integer.parseInt(inputEdad.getText());
                String datos = enviarDatosUsuario(nombre, edad);
                datosUsuario.add(datos);
                JOptionPane.showMessageDialog(null, datos);
            }
        });

        botonRecordarDatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                for (String datos : datosUsuario) {
                    sb.append(datos).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        // Configurar el frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    // Método para imprimir instrucciones
    private void imprimirInstrucciones() {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese las calorías consumidas de cada comida separadas por espacios.");
    }

    // Método para enviar la cantidad de calorías consumidas
    private int calcularCaloriasConsumidas(String input) {
        String[] caloriasStr = input.split(" ");
        int totalCalorias = 0;
        for (String calorias : caloriasStr) {
            totalCalorias += Integer.parseInt(calorias);
        }
        return totalCalorias;
    }

    // Método para enviar datos del usuario
    private String enviarDatosUsuario(String nombre, int edad) {
        return "Datos del usuario: Nombre - " + nombre + ", Edad - " + edad;
    }

    public static void main(String[] args) {
        new Prototipo();
    }
}
