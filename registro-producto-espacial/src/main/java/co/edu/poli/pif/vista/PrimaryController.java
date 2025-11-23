package co.edu.poli.pif.vista;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import co.edu.poli.pif.model.ProductoEspacial;
import co.edu.poli.pif.model.TipoProducto;
import co.edu.poli.pif.servicios.ImplementacionOperacionCRUD;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 * Controlador de primary.fxml.
 * Tabla a la izquierda y formulario de producto a la derecha.
 */
public class PrimaryController implements Initializable {

    // --- TABLA ---
    @FXML private TableView<ProductoEspacial> tblProductos;
    @FXML private TableColumn<ProductoEspacial, Integer> colId;
    @FXML private TableColumn<ProductoEspacial, String> colNombre;
    @FXML private TableColumn<ProductoEspacial, String> colTipo;
    @FXML private TableColumn<ProductoEspacial, Integer> colCantidad;
    @FXML private TableColumn<ProductoEspacial, Double> colMasa;

    // --- FORMULARIO ---
    @FXML private TextField txtNombre;
    @FXML private ComboBox<TipoProducto> cmbTipo;
    @FXML private TextField txtMasa;
    @FXML private TextField txtVolumen;           // si no lo usas aún, igual déjalo
    @FXML private TextField txtCantidad;
    @FXML private TextField txtFechaCaducidad;
    @FXML private ComboBox<String> cmbNivelCriticidad;
    @FXML private TextArea txtObservaciones;

    // --- BOTONES SUPERIORES ---
    @FXML private Button btnNuevo;
    @FXML private Button btnEditar;
    @FXML private Button btnEliminar;
    @FXML private Button btnRefrescar;

    // Servicio CRUD y datos
    private final ImplementacionOperacionCRUD servicio = new ImplementacionOperacionCRUD();
    private final ObservableList<ProductoEspacial> datosTabla = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Configurar columnas
        colId.setCellValueFactory(c ->
                new SimpleIntegerProperty(c.getValue().getId()).asObject());
        colNombre.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getNombre()));
        colTipo.setCellValueFactory(c ->
                new SimpleStringProperty(
                        c.getValue().getTipo() != null ? c.getValue().getTipo().name() : ""
                ));
        colCantidad.setCellValueFactory(c ->
                new SimpleIntegerProperty(c.getValue().getCantidad()).asObject());
        colMasa.setCellValueFactory(c ->
                new SimpleDoubleProperty(c.getValue().getMasaKg()).asObject());

        tblProductos.setItems(datosTabla);

        // Combos
        cmbTipo.setItems(FXCollections.observableArrayList(TipoProducto.values()));
        cmbNivelCriticidad.setItems(FXCollections.observableArrayList("Baja", "Media", "Alta"));

        cargarDatosEnTabla();
    }

    private void cargarDatosEnTabla() {
        datosTabla.clear();
        ProductoEspacial[] arr = servicio.readAll();
        if (arr != null) {
            datosTabla.addAll(Arrays.asList(arr));
        }
    }

    // ---------- BOTONES SUPERIORES ----------

    @FXML
    private void onNuevo() {
        limpiarFormulario();
        tblProductos.getSelectionModel().clearSelection();
    }

    @FXML
    private void onEditar() {
        ProductoEspacial sel = tblProductos.getSelectionModel().getSelectedItem();
        if (sel == null) {
            mostrarAlerta("Debe seleccionar un producto.", Alert.AlertType.WARNING);
            return;
        }
        txtNombre.setText(sel.getNombre());
        cmbTipo.setValue(sel.getTipo());
        txtMasa.setText(String.valueOf(sel.getMasaKg()));
        txtCantidad.setText(String.valueOf(sel.getCantidad()));
        // Otros campos si los manejas en tu modelo concreto
    }

    @FXML
    private void onEliminar() {
        ProductoEspacial sel = tblProductos.getSelectionModel().getSelectedItem();
        if (sel == null) {
            mostrarAlerta("Debe seleccionar un producto para eliminar.", Alert.AlertType.WARNING);
            return;
        }
        servicio.delete(sel.getId());
        cargarDatosEnTabla();
    }

    @FXML
    private void onRefrescar() {
        cargarDatosEnTabla();
    }

    // ---------- BOTONES DEL FORMULARIO ----------

    @FXML
    private void onGuardar() {
        if (txtNombre.getText().isBlank()
                || cmbTipo.getValue() == null
                || txtMasa.getText().isBlank()
                || txtCantidad.getText().isBlank()) {
            mostrarAlerta("Complete al menos Nombre, Tipo, Masa y Cantidad.", Alert.AlertType.WARNING);
            return;
        }

        // Aquí luego podemos armar Consumible, Repuesto, etc.
        // De momento solo mensaje para que compile y puedas probar la GUI.
        mostrarAlerta("Aquí va la lógica para crear/actualizar el ProductoEspacial.", Alert.AlertType.INFORMATION);

        limpiarFormulario();
        cargarDatosEnTabla();
    }

    @FXML
    private void onCancelar() {
        limpiarFormulario();
        tblProductos.getSelectionModel().clearSelection();
    }

    // ---------- UTILIDADES ----------

    private void limpiarFormulario() {
        txtNombre.clear();
        cmbTipo.setValue(null);
        txtMasa.clear();
        txtVolumen.clear();
        txtCantidad.clear();
        txtFechaCaducidad.clear();
        cmbNivelCriticidad.setValue(null);
        txtObservaciones.clear();
    }

    private void mostrarAlerta(String msg, Alert.AlertType tipo) {
        Alert a = new Alert(tipo);
        a.setTitle("Registro de Producto Espacial");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}
