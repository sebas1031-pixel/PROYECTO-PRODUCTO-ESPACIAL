package co.edu.poli.pif.model;
import java.io.Serializable; 
import java.util.*;
/** Ingrediente compuesto por componentes base. */
public class Ingrediente implements Serializable {

    /** Identificador del ingrediente. */
    private int id;

    /** Nombre del ingrediente. */
    private String nombre;

    /** Cantidad total del ingrediente. */
    private int cantidad;

    /** Unidad de medida de la cantidad. */
    private String unidadMedida;

    /** Componente base asociado (composición mínima). */
    private ComponenteBase componenteBase;

    /** Componentes adicionales (opcional). */
    private final List<ComponenteBase> componentes = new ArrayList<>();

    public Ingrediente() {}

    public Ingrediente(int id, String nombre, int cantidad, String unidadMedida) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
    }

    /** @return id */
    public int getId() { return id; }

    /** @param id nuevo id */
    public void setId(int id) { this.id = id; }

    /** @return nombre */
    public String getNombre() { return nombre; }

    /** @param nombre nuevo nombre */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @return cantidad */
    public int getCantidad() { return cantidad; }

    /** @param cantidad nueva cantidad */
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    /** @return unidad de medida */
    public String getUnidadMedida() { return unidadMedida; }

    /** @param unidadMedida nueva unidad de medida */
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }

    /** @return componente base principal */
    public ComponenteBase getComponenteBase() { return componenteBase; }

    /** @param componenteBase nuevo componente base */
    public void setComponenteBase(ComponenteBase componenteBase) { this.componenteBase = componenteBase; }

    /** @return lista modificable de componentes extra */
    public List<ComponenteBase> getComponentes() { return componentes; }

    /**
     * Convierte unidades: cantidad * factor
     * @param unidadDestino unidad destino (solo etiqueta)
     * @param factor factor de conversión
     * @return texto con el resultado convertido
     */
    public String cantidadEnUnidad(String unidadDestino, double factor){
        double convertido = Math.max(0, cantidad) * Math.max(0d, factor);
        return convertido + " " + unidadDestino;
    }

    @Override public String toString() { return nombre + " (" + cantidad + " " + unidadMedida + ")"; }
}