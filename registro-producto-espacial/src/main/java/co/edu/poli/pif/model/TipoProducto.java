package co.edu.poli.pif.model;
import java.io.Serializable;
/**
 * Enum con el tipo general del producto que maneja el sistema.
 * Se usa para distinguir la rama de herencia.
 */
public enum TipoProducto implements Serializable {
    /** Productos con fecha de caducidad. */
    CONSUMIBLE,
    /** Equipos y herramientas reutilizables. */
    EQUIPO,
    /** Repuestos/partes. */
    REPUESTO
}