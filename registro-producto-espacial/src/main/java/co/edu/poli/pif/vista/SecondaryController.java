package co.edu.poli.pif.vista;

import java.io.IOException;

import co.edu.poli.pif.App;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}
