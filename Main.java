import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;
import javax.swing.*;
// Codigo de GuiGenie y creación de metodos
public class Prototipo extends JPanel {
    private JButton botonInstrucciones;
    private JButton botonCalorias;
    private JButton botonDatosUsuario;
    private JButton botonRecordarDatos;
    private JTextField inputCalorias;
    private JTextField inputNombre;
    private JTextField inputEdad;

    // Método para imprimir instrucciones
    public static void imprimirInstrucciones() {
        System.out.println("Por favor, ingrese las calorías consumidas de cada comida separadas por espacios.");
    }

    // Método para enviar la cantidad de calorías consumidas
    public static int calcularCaloriasConsumidas(String input) {
        String[] caloriasStr = input.split(" ");
        int totalCalorias = 0;
        for (String calorias : caloriasStr) {
            totalCalorias += Integer.parseInt(calorias);
        }
        return totalCalorias;
    }

    // Método para enviar datos del usuario
    public static String enviarDatosUsuario(String nombre, int edad) {
        return "Datos del usuario: Nombre - " + nombre + ", Edad - " + edad;
    }

    // Método para almacenar los datos ingresados por el usuario
    private static List<String> datosUsuario = new ArrayList<>();

    public static void almacenarDatosUsuario(String datos) {
        datosUsuario.add(datos);
    }

    // Método para recordarle al usuario los datos que ha ingresado
    public static void recordarDatosIngresados() {
        System.out.println("Datos ingresados por el usuario:");
        for (String dato : datosUsuario) {
            System.out.println(dato);
        }
    }

    // Método para guardar la información ingresada por el usuario automáticamente
    public static void guardarInformacionAutomatica(String datos) {
        almacenarDatosUsuario(datos);
        System.out.println("Información guardada automáticamente.");
    }

    public Prototipo() {
        // Construct components
        botonInstrucciones = new JButton("Instrucciones");
        botonCalorias = new JButton("Calcular Calorías");
        botonDatosUsuario = new JButton("Enviar Datos Usuario");
        botonRecordarDatos = new JButton("Recordar Datos");
        inputCalorias = new JTextField(20);
        inputNombre = new JTextField(20);
        inputEdad = new JTextField(20);

        // Set components properties
        botonInstrucciones.setToolTipText("Imprimir Instrucciones");
        botonCalorias.setToolTipText("Calcular Calorías");
        botonDatosUsuario.setToolTipText("Enviar Datos Usuario");
        botonRecordarDatos.setToolTipText("Recordar Datos");

        // Adjust size and set layout
        setPreferredSize(new Dimension(500, 300));
        setLayout(new FlowLayout());

        // Add components
        add(botonInstrucciones);
        add(new JLabel("Calorías:"));
        add(inputCalorias);
        add(botonCalorias);
        add(new JLabel("Nombre:"));
        add(inputNombre);
        add(new JLabel("Edad:"));
        add(inputEdad);
        add(botonDatosUsuario);
        add(botonRecordarDatos);

        // Add action listeners for buttons
        botonInstrucciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imprimirInstrucciones();
            }
        });

        botonCalorias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputCalorias.getText();
                int calorias = calcularCaloriasConsumidas(input);
                System.out.println("Calorías consumidas: " + calorias);
            }
        });

        botonDatosUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = inputNombre.getText();
                int edad = Integer.parseInt(inputEdad.getText());
                String datos = enviarDatosUsuario(nombre, edad);
                guardarInformacionAutomatica(datos);
            }
        });

        botonRecordarDatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                recordarDatosIngresados();
            }
        });
    }
        // archivo Main
    public static void main(String[] args) {
        JFrame frame = new JFrame("Prototipo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Prototipo());
        frame.pack();
        frame.setVisible(true);
    }
}
