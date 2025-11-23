package co.edu.poli.pif.model;
import java.io.Serializable;
/** Categoría funcional del producto. */
public class Categoria implements Serializable {

    /** Identificador de la categoría. */
    private int id;

    /** Nombre visible de la categoría. */
    private String nombre;

    public Categoria() {}

    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /** @return id */
    public int getId() { return id; }

    /** @param id nuevo id */
    public void setId(int id) { this.id = id; }

    /** @return nombre */
    public String getNombre() { return nombre; }

    /** @param nombre nuevo nombre */
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override public String toString() { return nombre; }
}