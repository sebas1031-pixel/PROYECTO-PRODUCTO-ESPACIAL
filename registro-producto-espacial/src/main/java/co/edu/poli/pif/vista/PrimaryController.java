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
 * Controlador principal de la interfaz grafica.
 * Maneja tabla, formulario y operaciones CRUD.
 */
public class PrimaryController implements Initializable {

    // ----------------- TABLA -----------------
    @FXML private TableView<ProductoEspacial> tblProductos;
    @FXML private TableColumn<ProductoEspacial, Integer> colId;
    @FXML private TableColumn<ProductoEspacial, String> colNombre;
    @FXML private TableColumn<ProductoEspacial, String> colTipo;
    @FXML private TableColumn<ProductoEspacial, Integer> colCantidad;
    @FXML private TableColumn<ProductoEspacial, Double> colMasa;
    @FXML private TableColumn<ProductoEspacial, Double> colVolumen;
    @FXML private TableColumn<ProductoEspacial, String> colFechaCaducidad;
    @FXML private TableColumn<ProductoEspacial, String> colNivelCriticidad;
    @FXML private TableColumn<ProductoEspacial, String> colObservaciones;

    // ----------------- FORMULARIO -----------------
    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private ComboBox<TipoProducto> cmbTipo;
    @FXML private TextField txtMasa;
    @FXML private TextField txtVolumen;
    @FXML private TextField txtCantidad;
    @FXML private TextField txtFechaCaducidad;
    @FXML private ComboBox<String> cmbNivelCriticidad;
    @FXML private TextArea txtObservaciones;

    // ----------------- BOTONES -----------------
    @FXML private Button btnGuardar;
    @FXML private Button btnEditar;
    @FXML private Button btnEliminar;
    @FXML private Button btnLimpiar;

    // Servicio CRUD
    private final ImplementacionOperacionCRUD servicio = new ImplementacionOperacionCRUD();
    private final ObservableList<ProductoEspacial> datosTabla = FXCollections.observableArrayList();

    private static final String ARCHIVO_DAT = "productos.dat";

    private boolean modoEdicion = false;

    /**
     * Inicializa la vista y carga datos.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Configurar columnas
        colId.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()).asObject());
        colNombre.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNombre()));
        colTipo.setCellValueFactory(c -> new SimpleStringProperty(
                c.getValue().getTipo() != null ? c.getValue().getTipo().name() : ""
        ));
        colCantidad.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getCantidad()).asObject());
        colMasa.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getMasaKg()).asObject());
        colVolumen.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getVolumen()).asObject());
        colFechaCaducidad.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getFechaCaducidad()));
        colNivelCriticidad.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNivelCriticidad()));
        colObservaciones.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getObservaciones()));

        tblProductos.setItems(datosTabla);

        // Poblar combos
        cmbTipo.setItems(FXCollections.observableArrayList(TipoProducto.values()));
        cmbNivelCriticidad.setItems(FXCollections.observableArrayList("Baja", "Media", "Alta"));

        cargarDatosEnTabla();
    }

    // ----------------- CARGA DE DATOS -----------------

    /**
     * Carga los datos desde archivo y luego los agrega a la tabla.
     */
    private void cargarDatosEnTabla() {
        datosTabla.clear();
        servicio.deserializar(ARCHIVO_DAT);
        ProductoEspacial[] arr = servicio.readAll();
        if (arr != null) datosTabla.addAll(Arrays.asList(arr));
    }

    // ----------------- BOTONES PRINCIPALES -----------------

    /**
     * Accion del boton Nuevo.
     */
    @FXML
    private void onNuevo() {
        limpiarFormulario();
        modoEdicion = false;
        txtId.setDisable(false);
        tblProductos.getSelectionModel().clearSelection();
    }

    /**
     * Accion del boton Editar.
     */
    @FXML
    private void onEditar() {
        ProductoEspacial sel = tblProductos.getSelectionModel().getSelectedItem();
        if (sel == null) {
            mostrarAlerta("Seleccione un producto para editar.", Alert.AlertType.WARNING);
            return;
        }

        modoEdicion = true;

        txtId.setText(String.valueOf(sel.getId()));
        txtId.setDisable(true);

        txtNombre.setText(sel.getNombre());
        cmbTipo.setValue(sel.getTipo());
        txtMasa.setText(String.valueOf(sel.getMasaKg()));
        txtVolumen.setText(String.valueOf(sel.getVolumen()));
        txtCantidad.setText(String.valueOf(sel.getCantidad()));
        txtFechaCaducidad.setText(sel.getFechaCaducidad());
        cmbNivelCriticidad.setValue(sel.getNivelCriticidad());
        txtObservaciones.setText(sel.getObservaciones());
    }

    /**
     * Accion del boton Eliminar.
     */
    @FXML
    private void onEliminar() {
        ProductoEspacial sel = tblProductos.getSelectionModel().getSelectedItem();
        if (sel == null) {
            mostrarAlerta("Seleccione un producto para eliminar.", Alert.AlertType.WARNING);
            return;
        }

        servicio.delete(sel.getId());
        servicio.serializar(ARCHIVO_DAT);

        cargarDatosEnTabla();
        limpiarFormulario();
    }

    /**
     * Accion del boton Guardar (crear o actualizar).
     */
    @FXML
    private void onGuardar() {
        try {
            if (txtId.getText().isBlank()
            || txtNombre.getText().isBlank()
            || cmbTipo.getValue() == null
            || txtMasa.getText().isBlank()
            || txtVolumen.getText().isBlank()
            || txtCantidad.getText().isBlank()) {

                mostrarAlerta("Complete todos los campos obligatorios.", Alert.AlertType.WARNING);
                return;
            }

            int id = Integer.parseInt(txtId.getText().trim());
            String nombre = txtNombre.getText().trim();
            TipoProducto tipo = cmbTipo.getValue();
            double masa = Double.parseDouble(txtMasa.getText().trim());
            double volumen = Double.parseDouble(txtVolumen.getText().trim());
            int cantidad = Integer.parseInt(txtCantidad.getText().trim());
            String fecha = txtFechaCaducidad.getText().trim();
            String nivel = cmbNivelCriticidad.getValue();
            String obs = txtObservaciones.getText().trim();

            ProductoEspacial p = new ProductoEspacial(
                    id, nombre, tipo, masa, volumen, cantidad, fecha, nivel, obs
            );

            if (modoEdicion) {
                servicio.update(id, p);
            } else {
                servicio.create(p);
            }

            servicio.serializar(ARCHIVO_DAT);
            cargarDatosEnTabla();
            limpiarFormulario();

            modoEdicion = false;
            txtId.setDisable(false);

        } catch (NumberFormatException e) {
            mostrarAlerta("ID, masa, volumen y cantidad deben ser numericos.", Alert.AlertType.ERROR);
        }
    }

    /**
     * Accion del boton Limpiar.
     */
    @FXML
    private void onLimpiar() {
        limpiarFormulario();
        tblProductos.getSelectionModel().clearSelection();
        modoEdicion = false;
        txtId.setDisable(false);
    }

    // ----------------- UTILIDADES -----------------

    /**
     * Limpia todos los campos del formulario.
     */
    private void limpiarFormulario() {
        txtId.clear();
        txtNombre.clear();
        cmbTipo.setValue(null);
        txtMasa.clear();
        txtVolumen.clear();
        txtCantidad.clear();
        txtFechaCaducidad.clear();
        cmbNivelCriticidad.setValue(null);
        txtObservaciones.clear();
    }

    /**
     * Muestra una alerta con un mensaje.
     *
     * @param msg mensaje
     * @param tipo tipo de alerta
     */
    private void mostrarAlerta(String msg, Alert.AlertType tipo) {
        Alert a = new Alert(tipo);
        a.setTitle("Registro de productos");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}
