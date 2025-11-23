package co.edu.poli.pif.model;
import java.io.Serializable;

/**
 * Representa un almacén físico donde se guardan productos espaciales.
 */
public class Almacen implements Serializable {

    /** Identificador único del almacén. */
    private int id;

    /** Ubicación física del almacén. */
    private String ubicacion;

    /** Capacidad total del almacén (en unidades). */
    private int capacidad;

    /** Crea un almacén vacío. */
    public Almacen() {}

    /**
     * Crea un almacén con datos básicos.
     * @param id identificador del almacén
     * @param ubicacion descripción de la ubicación
     * @param capacidad capacidad máxima
     */
    public Almacen(int id, String ubicacion, int capacidad) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }

    /** Obtiene el identificador del almacén.
     *  @return id
     */
    public int getId() { return id; }

    /** Actualiza el identificador del almacén.
     *  @param id nuevo id
     */
    public void setId(int id) { this.id = id; }

    /** Obtiene la ubicación del almacén.
     *  @return ubicacion
     */
    public String getUbicacion() { return ubicacion; }

    /** Actualiza la ubicación del almacén.
     *  @param ubicacion nueva ubicación
     */
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    /** Obtiene la capacidad del almacén.
     *  @return capacidad
     */
    public int getCapacidad() { return capacidad; }

    /** Actualiza la capacidad del almacén.
     *  @param capacidad nueva capacidad
     */
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    @Override public String toString() {
        return "Almacen{id=" + id + ", ubicacion='" + ubicacion + "', capacidad=" + capacidad + "}";
    }
}