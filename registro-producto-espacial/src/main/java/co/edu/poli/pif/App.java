package co.edu.poli.pif;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Punto de entrada de la aplicación JavaFX.
 * Carga primary.fxml al inicio.
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 1000, 600);
        stage.setTitle("Registro de Producto Espacial");
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Carga un FXML desde src/main/resources/co/edu/poli/pif
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                App.class.getResource("/co/edu/poli/pif/" + fxml + ".fxml")
        );
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
