package co.edu.poli.pif.model;
import java.io.Serializable;
/**
/** Componente base que compone un ingrediente. */
public class ComponenteBase implements Serializable {

    /** Nombre del componente. */
    private String nombre;

    /** Cantidad del componente. */
    private int cantidad;

    /** Unidad de medición de la cantidad. */
    private String unidadMedicion;

    public ComponenteBase() {}

    public ComponenteBase(String nombre, int cantidad, String unidadMedicion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidadMedicion = unidadMedicion;
    }

    /** @return nombre */
    public String getNombre() { return nombre; }

    /** @param nombre nuevo nombre */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @return cantidad */
    public int getCantidad() { return cantidad; }

    /** @param cantidad nueva cantidad */
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    /** @return unidad de medicion */
    public String getUnidadMedicion() { return unidadMedicion; }

    /** @param unidadMedicion nueva unidad de medicion */
    public void setUnidadMedicion(String unidadMedicion) { this.unidadMedicion = unidadMedicion; }

    /** @return etiqueta corta legible */
    public String etiquetaComponente() {
        return cantidad + " " + unidadMedicion + " de " + nombre;
    }

    @Override public String toString() { return etiquetaComponente(); }
}