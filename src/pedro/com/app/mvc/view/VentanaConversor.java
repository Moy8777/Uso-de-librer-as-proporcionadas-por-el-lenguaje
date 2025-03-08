package pedro.com.app.mvc.view;
//importamos las librerias nesesarias a ocupar
import javax.swing.*;
import java.awt.*;
import pedro.com.app.mvc.controller.ConversorController;

public class VentanaConversor extends JFrame {
    private JComboBox<String> tipoConversion;
    private JTextField inputField;
    private JLabel resultadoLabel;
    private JButton convertirBtn;
    private ConversorController controller;
    private JPanel panelFondo; // Panel para manejar el fondo

    public VentanaConversor() {
        setTitle("Conversor de Unidades");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true); // Permite redimensionar la ventana 
       
        // Panel de fondo con color (no pudimos meterle una imagen de fondo)
        panelFondo = new JPanel();
        panelFondo.setBackground(new Color(173, 216, 230)); // Azul claro
        panelFondo.setLayout(new GridBagLayout()); // Para organizar los componentes
        setContentPane(panelFondo);

        // Usamos GridBagLayout para una mejor distribución de los componentes por que los superponia
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL; // Expandir los elementos horizontalmente

        // Controlador
        controller = new ConversorController(this);

        // Etiqueta y campo de entrada
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Ingrese el valor:"), gbc);

        gbc.gridx = 1;
        inputField = new JTextField(10);
        add(inputField, gbc);

        // Etiqueta y lista desplegable de conversiones
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Tipo de conversión:"), gbc);

        gbc.gridx = 1;
        String[] opciones = {"Metros a Kilómetros", "Kilómetros a Metros",
                             "Celsius a Fahrenheit", "Fahrenheit a Celsius"};
        tipoConversion = new JComboBox<>(opciones);
        add(tipoConversion, gbc);

        // Botón para convertir
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Ocupar dos columnas
        convertirBtn = new JButton("Convertir");
        convertirBtn.addActionListener(e -> controller.convertirUnidad());
        add(convertirBtn, gbc);

        // Etiqueta de resultado
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        resultadoLabel = new JLabel("Resultado: ");
        add(resultadoLabel, gbc);
    }

    public String getInputText() {
        return inputField.getText();
    }

    public String getSelectedConversion() {
        return (String) tipoConversion.getSelectedItem();
    }

    public void setResultado(String resultado) {
        resultadoLabel.setText("Resultado: " + resultado);
    }
}
