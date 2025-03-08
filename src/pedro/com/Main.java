package pedro.com;

import pedro.com.app.mvc.view.VentanaConversor;

public class Main {
    public static void main(String[] args) {
        // Crea una instancia de la ventana principal del conversor
        VentanaConversor view = new VentanaConversor();
        
        // Hace visible la ventana para que el usuario pueda interactuar con ella
        view.setVisible(true);
    }
}