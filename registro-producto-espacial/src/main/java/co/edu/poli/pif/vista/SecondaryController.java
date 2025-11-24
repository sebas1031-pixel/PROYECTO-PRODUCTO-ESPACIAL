package co.edu.poli.pif.vista;

import java.io.IOException;

import co.edu.poli.pif.App;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controlador de la segunda pantalla.
 * Puedes usarla como ventana de información, créditos, etc.
 */
public class SecondaryController {

    @FXML
    private Label lblInfo;

    @FXML
    private void initialize() {
        if (lblInfo != null) {
            lblInfo.setText("Sistema de Registro de Producto Espacial\n"
                    + "Versión 1.0 - Ejemplo académico.");
        }
    }

    /**
     * Acción del botón Volver: regresa a la ventana principal (primary.fxml).
     */
    @FXML
    private void onVolver() throws IOException {
        App.setRoot("primary");   // vuelve a cargar primary.fxml
    }
}
