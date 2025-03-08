package pedro.com.app.mvc.controller;
//IMPORTAMOS LAS LIBRERIAS QUE VAMOS A OCUPAR, JUNTO CON EL ARCHIVO VENTANACONVERSOR
import pedro.com.app.mvc.view.VentanaConversor; 
import javax.swing.*; 
import org.jscience.physics.amount.Amount; 
import javax.measure.unit.SI; 
import javax.measure.unit.NonSI; 
import org.apache.commons.math3.util.Precision; 


public class ConversorController {
    private VentanaConversor view; // Instancia de la vista (interfaz gráfica)

    public ConversorController(VentanaConversor view) {
        this.view = view;
    }

    /**
     * Realiza la conversión de unidades según la opción seleccionada.
     */
    public void convertirUnidad() {
        try {
            // Obtiene el valor ingresado en la vista y lo convierte a número
            double valor = Double.parseDouble(view.getInputText());
            String seleccion = view.getSelectedConversion(); // Obtiene la opción seleccionada
            double resultado = 0; // Variable donde se almacenará el resultado

            // Evalúa la opción seleccionada y realiza la conversión correspondiente
            switch (seleccion) {
                case "Metros a Kilómetros":
                    resultado = Amount.valueOf(valor, SI.METER).doubleValue(SI.KILOMETER);
                    break;
                case "Kilómetros a Metros":
                    resultado = Amount.valueOf(valor, SI.KILOMETER).doubleValue(SI.METER);
                    break;
                case "Celsius a Fahrenheit":
                    resultado = Precision.round((valor * 9 / 5) + 32, 2); // Fórmula de conversión
                    break;
                case "Fahrenheit a Celsius":
                    resultado = Precision.round((valor - 32) * 5 / 9, 2); // Fórmula de conversión
                    break;
            }

            // Muestra el resultado en la vista
            view.setResultado(String.valueOf(resultado));
        } catch (NumberFormatException ex) { // En caso de que el usuario ingrese valores no numericos muestra un erorr
            JOptionPane.showMessageDialog(null, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}