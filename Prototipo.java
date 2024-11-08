import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Prototipo extends JFrame {
    // Declaración de componentes
    private JButton botonInstrucciones;
    private JButton botonDatosUsuario;
    private JButton botonRecordarDatos;
    private JButton botonCaloriasSubirPeso;
    private JButton botonGuardarDatos;
    private JButton botonVerUsuarios;
    private JTextField inputNombre;
    private JTextField inputEdad;
    private JTextField inputCarbohidratos;
    private JTextField inputCaloriasActuales;
    private JTextField inputPeso;
    private JTextField inputUsuario;

    // Mapa para almacenar los datos de los usuarios
    private Map<String, String> datosUsuario = new HashMap<>();

    public Prototipo() {
        // Inicializar componentes
        botonInstrucciones = new JButton("Instrucciones");
        botonDatosUsuario = new JButton("Datos Usuario");
        botonRecordarDatos = new JButton("Recordar Datos");
        botonCaloriasSubirPeso = new JButton("Calorías para Subir Peso");
        botonGuardarDatos = new JButton("Guardar Datos");
        botonVerUsuarios = new JButton("Ver Usuarios Registrados");
        inputNombre = new JTextField(20);
        inputEdad = new JTextField(20);
        inputCarbohidratos = new JTextField(20);
        inputCaloriasActuales = new JTextField(20);
        inputPeso = new JTextField(20);
        inputUsuario = new JTextField(20);

        // Establecer propiedades de los componentes
        botonInstrucciones.setToolTipText("Imprimir Instrucciones");
        botonDatosUsuario.setToolTipText("Enviar Datos Usuario");
        botonRecordarDatos.setToolTipText("Recordar Datos");
        botonCaloriasSubirPeso.setToolTipText("Calcular Calorías para Subir Peso");
        botonGuardarDatos.setToolTipText("Guardar Datos del Usuario");
        botonVerUsuarios.setToolTipText("Ver Usuarios Registrados");

        // Establecer colores de fondo para los campos de texto y botones
        inputNombre.setBackground(Color.LIGHT_GRAY);
        inputEdad.setBackground(Color.LIGHT_GRAY);
        inputCarbohidratos.setBackground(Color.LIGHT_GRAY);
        inputCaloriasActuales.setBackground(Color.LIGHT_GRAY);
        inputPeso.setBackground(Color.LIGHT_GRAY);
        inputUsuario.setBackground(Color.LIGHT_GRAY);
        botonInstrucciones.setBackground(Color.CYAN);
        botonDatosUsuario.setBackground(Color.CYAN);
        botonRecordarDatos.setBackground(Color.CYAN);
        botonCaloriasSubirPeso.setBackground(Color.CYAN);
        botonGuardarDatos.setBackground(Color.CYAN);
        botonVerUsuarios.setBackground(Color.CYAN);

        // Crear panel principal con GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Añadir componentes al panel con GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Usuario:"), gbc);

        gbc.gridx = 1;
        panel.add(inputUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Nombre:"), gbc);

        gbc.gridx = 1;
        panel.add(inputNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Edad:"), gbc);

        gbc.gridx = 1;
        panel.add(inputEdad, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Carbohidratos Actuales:"), gbc);

        gbc.gridx = 1;
        panel.add(inputCarbohidratos, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Calorías Actuales:"), gbc);

        gbc.gridx = 1;
        panel.add(inputCaloriasActuales, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Peso:"), gbc);

        gbc.gridx = 1;
        panel.add(inputPeso, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(botonInstrucciones, gbc);

        gbc.gridx = 1;
        panel.add(botonDatosUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(botonRecordarDatos, gbc);

        gbc.gridx = 1;
        panel.add(botonCaloriasSubirPeso, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(botonGuardarDatos, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        panel.add(botonVerUsuarios, gbc);

        // Añadir panel al frame
        add(panel);

        // Añadir ActionListeners a los botones
        botonInstrucciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imprimirInstrucciones();
            }
        });

        botonDatosUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = inputUsuario.getText();
                String nombre = inputNombre.getText();
                int edad = Integer.parseInt(inputEdad.getText());
                String datos = enviarDatosUsuario(nombre, edad);
                datosUsuario.put(usuario, datos);
                JOptionPane.showMessageDialog(null, datos);
            }
        });

        botonRecordarDatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = inputUsuario.getText();
                String datos = datosUsuario.get(usuario);
                if (datos != null) {
                    JOptionPane.showMessageDialog(null, datos);
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron datos para el usuario: " + usuario);
                }
            }
        });

        botonCaloriasSubirPeso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int caloriasActuales = Integer.parseInt(inputCaloriasActuales.getText());
                int peso = Integer.parseInt(inputPeso.getText());
                int caloriasNecesarias = calcularCaloriasParaSubirPeso(caloriasActuales, peso);
                JOptionPane.showMessageDialog(null, "Calorías necesarias para subir de peso: " + caloriasNecesarias);
            }
        });

        botonGuardarDatos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = inputUsuario.getText();
                String nombre = inputNombre.getText();
                int edad = Integer.parseInt(inputEdad.getText());
                String datos = enviarDatosUsuario(nombre, edad);
                datosUsuario.put(usuario, datos);
                JOptionPane.showMessageDialog(null, "Datos guardados para el usuario: " + usuario);
            }
        });

        botonVerUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                for (String usuario : datosUsuario.keySet()) {
                    sb.append(usuario).append("\n");
                }
                JOptionPane.showMessageDialog(null, "Usuarios registrados:\n" + sb.toString());
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

    // Método para calcular el total de calorías consumidas
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

    // Método para calcular calorías necesarias para subir de peso
    private int calcularCaloriasParaSubirPeso(int caloriasActuales, int peso) {
        // Supongamos que para subir de peso se necesitan 500 calorías adicionales por día
        return caloriasActuales + 500;
    }

    public static void main(String[] args) {
        // Crear una instancia de la clase Prototipo y mostrar la interfaz
        new Prototipo();
    }
}


    public static void main(String[] args) {
        new Prototipo();
    }
}
